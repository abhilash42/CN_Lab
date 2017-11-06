package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.concurrency.C0687l;
import io.fabric.sdk.android.services.concurrency.C0689g;
import io.fabric.sdk.android.services.concurrency.C1524d;
import io.fabric.sdk.android.services.concurrency.C1525e;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.C0701f;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.network.C1571b;
import io.fabric.sdk.android.services.network.C1572c;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.p020b.C1479g;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1483j.C1484a;
import io.fabric.sdk.android.services.p020b.C1483j.C1485b;
import io.fabric.sdk.android.services.p020b.C1491n;
import io.fabric.sdk.android.services.p022e.C1552o;
import io.fabric.sdk.android.services.p022e.C1553p;
import io.fabric.sdk.android.services.p022e.C1556q;
import io.fabric.sdk.android.services.p022e.C1556q.C0694b;
import io.fabric.sdk.android.services.p022e.C1558t;
import io.fabric.sdk.android.services.p037d.C1531a;
import io.fabric.sdk.android.services.p037d.C1532b;
import io.fabric.sdk.android.services.p037d.C1533c;
import io.fabric.sdk.android.services.p037d.C1534d;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;

@C1524d(a = {CrashEventDataProvider.class})
public class CrashlyticsCore extends C0653h<Void> {
    static final float CLS_DEFAULT_PROCESS_DELAY = 1.0f;
    static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    private static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
    public static final String TAG = "CrashlyticsCore";
    private String apiKey;
    private final ConcurrentHashMap<String, String> attributes;
    private String buildId;
    private CrashlyticsFileMarker crashMarker;
    private float delay;
    private boolean disabled;
    private CrashlyticsExecutorServiceWrapper executorServiceWrapper;
    private CrashEventDataProvider externalCrashEventDataProvider;
    private C1531a fileStore;
    private CrashlyticsUncaughtExceptionHandler handler;
    private C1570d httpRequestFactory;
    private CrashlyticsFileMarker initializationMarker;
    private String installerPackageName;
    private CrashlyticsListener listener;
    private String packageName;
    private final PinningInfoProvider pinningInfo;
    private File sdkDir;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;
    private String versionCode;
    private String versionName;

    class C06901 extends C0689g<Void> {
        C06901() {
        }

        public Void call() {
            return CrashlyticsCore.this.doInBackground();
        }

        public C1525e getPriority() {
            return C1525e.IMMEDIATE;
        }
    }

    class C06912 implements Callable<Void> {
        C06912() {
        }

        public Void call() {
            CrashlyticsCore.this.initializationMarker.create();
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Initialization marker file created.");
            return null;
        }
    }

    class C06923 implements Callable<Boolean> {
        C06923() {
        }

        public Boolean call() {
            try {
                boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Initialization marker file removed: " + remove);
                return Boolean.valueOf(remove);
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.valueOf(false);
            }
        }
    }

    class C06934 implements Callable<Boolean> {
        C06934() {
        }

        public Boolean call() {
            return Boolean.valueOf(CrashlyticsCore.this.initializationMarker.isPresent());
        }
    }

    class C06955 implements C0694b<Boolean> {
        C06955() {
        }

        public Boolean usingSettings(C1558t c1558t) {
            boolean z = false;
            if (!c1558t.f3903d.f3870a) {
                return Boolean.valueOf(false);
            }
            if (!CrashlyticsCore.this.shouldSendReportsWithoutPrompting()) {
                z = CrashlyticsCore.CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
            }
            return Boolean.valueOf(z);
        }
    }

    class C06966 implements C0694b<Boolean> {
        C06966() {
        }

        public Boolean usingSettings(C1558t c1558t) {
            boolean z = CrashlyticsCore.CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
            Activity b = CrashlyticsCore.this.getFabric().m5553b();
            if (!(b == null || b.isFinishing() || !CrashlyticsCore.this.shouldPromptUserBeforeSendingCrashReports())) {
                z = CrashlyticsCore.this.getSendDecisionFromUser(b, c1558t.f3902c);
            }
            return Boolean.valueOf(z);
        }
    }

    class C06977 implements AlwaysSendCallback {
        C06977() {
        }

        public void sendUserReportsWithoutPrompting(boolean z) {
            CrashlyticsCore.this.setShouldSendUserReportsWithoutPrompting(z);
        }
    }

    public static class Builder {
        private float delay = -1.0f;
        private boolean disabled = false;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public Builder delay(float f) {
            if (f <= 0.0f) {
                throw new IllegalArgumentException("delay must be greater than 0");
            } else if (this.delay > 0.0f) {
                throw new IllegalStateException("delay already set.");
            } else {
                this.delay = f;
                return this;
            }
        }

        public Builder listener(CrashlyticsListener crashlyticsListener) {
            if (crashlyticsListener == null) {
                throw new IllegalArgumentException("listener must not be null.");
            } else if (this.listener != null) {
                throw new IllegalStateException("listener already set.");
            } else {
                this.listener = crashlyticsListener;
                return this;
            }
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider) {
            if (pinningInfoProvider == null) {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            } else if (this.pinningInfoProvider != null) {
                throw new IllegalStateException("pinningInfoProvider already set.");
            } else {
                this.pinningInfoProvider = pinningInfoProvider;
                return this;
            }
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        public CrashlyticsCore build() {
            if (this.delay < 0.0f) {
                this.delay = CrashlyticsCore.CLS_DEFAULT_PROCESS_DELAY;
            }
            return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
        }
    }

    private static final class CrashMarkerCheck implements Callable<Boolean> {
        private final CrashlyticsFileMarker crashMarker;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.crashMarker = crashlyticsFileMarker;
        }

        public Boolean call() {
            if (!this.crashMarker.isPresent()) {
                return Boolean.FALSE;
            }
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Found previous crash marker.");
            this.crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    private static final class NoOpListener implements CrashlyticsListener {
        private NoOpListener() {
        }

        public void crashlyticsDidDetectCrashDuringPreviousExecution() {
        }
    }

    public CrashlyticsCore() {
        this(CLS_DEFAULT_PROCESS_DELAY, null, null, false);
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f, crashlyticsListener, pinningInfoProvider, z, C1491n.m5686a("Crashlytics Exception Handler"));
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.userEmail = null;
        this.userName = null;
        this.delay = f;
        if (crashlyticsListener == null) {
            crashlyticsListener = new NoOpListener();
        }
        this.listener = crashlyticsListener;
        this.pinningInfo = pinningInfoProvider;
        this.disabled = z;
        this.executorServiceWrapper = new CrashlyticsExecutorServiceWrapper(executorService);
        this.attributes = new ConcurrentHashMap();
        this.startTime = System.currentTimeMillis();
    }

    protected boolean onPreExecute() {
        return onPreExecute(super.getContext());
    }

    boolean onPreExecute(Context context) {
        if (this.disabled) {
            return false;
        }
        this.apiKey = new C1479g().m5631a(context);
        if (this.apiKey == null) {
            return false;
        }
        this.buildId = C1482i.m5679m(context);
        if (isBuildIdValid(this.buildId, C1482i.m5659a(context, CRASHLYTICS_REQUIRE_BUILD_ID, (boolean) CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT))) {
            C1457c.m5546h().mo815c(TAG, "Initializing Crashlytics " + getVersion());
            this.fileStore = new C1532b(this);
            this.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, this.fileStore);
            this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, this.fileStore);
            try {
                setAndValidateKitProperties(context);
                UnityVersionProvider manifestUnityVersionProvider = new ManifestUnityVersionProvider(context, getPackageName());
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                if (!installExceptionHandler(manifestUnityVersionProvider)) {
                    return false;
                }
                if (!didPreviousInitializationFail || !C1482i.m5680n(context)) {
                    return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
                }
                finishInitSynchronously();
                return false;
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(TAG, "Crashlytics was not started due to an exception during initialization", e);
                return false;
            }
        }
        throw new UnmetDependencyException(MISSING_BUILD_ID_MSG);
    }

    private void setAndValidateKitProperties(Context context) {
        C0701f crashlyticsPinningInfoProvider = this.pinningInfo != null ? new CrashlyticsPinningInfoProvider(this.pinningInfo) : null;
        this.httpRequestFactory = new C1571b(C1457c.m5546h());
        this.httpRequestFactory.mo859a(crashlyticsPinningInfoProvider);
        this.packageName = context.getPackageName();
        this.installerPackageName = getIdManager().m5704j();
        C1457c.m5546h().mo811a(TAG, "Installer package name is: " + this.installerPackageName);
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.packageName, 0);
        this.versionCode = Integer.toString(packageInfo.versionCode);
        this.versionName = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
    }

    private boolean installExceptionHandler(UnityVersionProvider unityVersionProvider) {
        try {
            C1457c.m5546h().mo811a(TAG, "Installing exception handler...");
            this.handler = new CrashlyticsUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler(), this.executorServiceWrapper, getIdManager(), unityVersionProvider, this.fileStore, this);
            this.handler.openSession();
            Thread.setDefaultUncaughtExceptionHandler(this.handler);
            C1457c.m5546h().mo811a(TAG, "Successfully installed exception handler.");
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(TAG, "There was a problem installing the exception handler.", e);
            this.handler = null;
            return false;
        }
    }

    protected Void doInBackground() {
        markInitializationStarted();
        SessionEventData externalCrashEventData = getExternalCrashEventData();
        if (externalCrashEventData != null) {
            this.handler.writeExternalCrashEvent(externalCrashEventData);
        }
        this.handler.cleanInvalidTempFiles();
        try {
            C1558t b = C1556q.m5839a().m5843b();
            if (b == null) {
                C1457c.m5546h().mo816d(TAG, "Received null settings, skipping initialization!");
            } else if (b.f3903d.f3872c) {
                this.handler.finalizeSessions();
                CreateReportSpiCall createReportSpiCall = getCreateReportSpiCall(b);
                if (createReportSpiCall == null) {
                    C1457c.m5546h().mo816d(TAG, "Unable to create a call to upload reports.");
                    markInitializationComplete();
                } else {
                    new ReportUploader(this.apiKey, createReportSpiCall).uploadReports(this.delay);
                    markInitializationComplete();
                }
            } else {
                C1457c.m5546h().mo811a(TAG, "Collection of crash reports disabled in Crashlytics settings.");
                markInitializationComplete();
            }
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(TAG, "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            markInitializationComplete();
        }
        return null;
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String getVersion() {
        return "2.3.14.151";
    }

    public static CrashlyticsCore getInstance() {
        return (CrashlyticsCore) C1457c.m5538a(CrashlyticsCore.class);
    }

    public PinningInfoProvider getPinningInfoProvider() {
        return !this.disabled ? this.pinningInfo : null;
    }

    public void logException(Throwable th) {
        if (this.disabled || !ensureFabricWithCalled("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            C1457c.m5546h().mo809a(5, TAG, "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.handler.writeNonFatalException(Thread.currentThread(), th);
        }
    }

    public void log(String str) {
        doLog(3, TAG, str);
    }

    private void doLog(int i, String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
            this.handler.writeToLog(System.currentTimeMillis() - this.startTime, formatLogMessage(i, str, str2));
        }
    }

    public void log(int i, String str, String str2) {
        doLog(i, str, str2);
        C1457c.m5546h().mo810a(i, "" + str, "" + str2, CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT);
    }

    public void setUserIdentifier(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userId = sanitizeAttribute(str);
            this.handler.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserName(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userName = sanitizeAttribute(str);
            this.handler.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserEmail(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userEmail = sanitizeAttribute(str);
            this.handler.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setString(String str, String str2) {
        if (this.disabled || !ensureFabricWithCalled("prior to setting keys.")) {
            return;
        }
        if (str == null) {
            Context context = getContext();
            if (context == null || !C1482i.m5675i(context)) {
                C1457c.m5546h().mo819e(TAG, "Attempting to set custom attribute with null key, ignoring.", null);
                return;
            }
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        String sanitizeAttribute = sanitizeAttribute(str);
        if (this.attributes.size() < 64 || this.attributes.containsKey(sanitizeAttribute)) {
            this.attributes.put(sanitizeAttribute, str2 == null ? "" : sanitizeAttribute(str2));
            this.handler.cacheKeyData(this.attributes);
            return;
        }
        C1457c.m5546h().mo811a(TAG, "Exceeded maximum number of custom attributes (64)");
    }

    public void setBool(String str, boolean z) {
        setString(str, Boolean.toString(z));
    }

    public void setDouble(String str, double d) {
        setString(str, Double.toString(d));
    }

    public void setFloat(String str, float f) {
        setString(str, Float.toString(f));
    }

    public void setInt(String str, int i) {
        setString(str, Integer.toString(i));
    }

    public void setLong(String str, long j) {
        setString(str, Long.toString(j));
    }

    public void crash() {
        new CrashTest().indexOutOfBounds();
    }

    public boolean verifyPinning(URL url) {
        try {
            return internalVerifyPinning(url);
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(TAG, "Could not verify SSL pinning", e);
            return false;
        }
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        C1457c.m5546h().mo816d(TAG, "Use of setListener is deprecated.");
        if (crashlyticsListener == null) {
            throw new IllegalArgumentException("listener must not be null.");
        }
        this.listener = crashlyticsListener;
    }

    static void recordLoggedExceptionEvent(String str, String str2) {
        Answers answers = (Answers) C1457c.m5538a(Answers.class);
        if (answers != null) {
            answers.onException(new C1485b(str, str2));
        }
    }

    static void recordFatalExceptionEvent(String str, String str2) {
        Answers answers = (Answers) C1457c.m5538a(Answers.class);
        if (answers != null) {
            answers.onException(new C1484a(str, str2));
        }
    }

    Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    String getPackageName() {
        return this.packageName;
    }

    String getApiKey() {
        return this.apiKey;
    }

    String getInstallerPackageName() {
        return this.installerPackageName;
    }

    String getVersionName() {
        return this.versionName;
    }

    String getVersionCode() {
        return this.versionCode;
    }

    String getOverridenSpiEndpoint() {
        return C1482i.m5664b(getContext(), CRASHLYTICS_API_ENDPOINT);
    }

    String getBuildId() {
        return this.buildId;
    }

    CrashlyticsUncaughtExceptionHandler getHandler() {
        return this.handler;
    }

    String getUserIdentifier() {
        return getIdManager().m5695a() ? this.userId : null;
    }

    String getUserEmail() {
        return getIdManager().m5695a() ? this.userEmail : null;
    }

    String getUserName() {
        return getIdManager().m5695a() ? this.userName : null;
    }

    private void finishInitSynchronously() {
        Callable c06901 = new C06901();
        for (C0687l addDependency : getDependencies()) {
            c06901.addDependency(addDependency);
        }
        Future submit = getFabric().m5558f().submit(c06901);
        C1457c.m5546h().mo811a(TAG, "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(TAG, "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            C1457c.m5546h().mo819e(TAG, "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            C1457c.m5546h().mo819e(TAG, "Crashlytics timed out during initialization.", e22);
        }
    }

    void markInitializationStarted() {
        this.executorServiceWrapper.executeSyncLoggingException(new C06912());
    }

    void markInitializationComplete() {
        this.executorServiceWrapper.executeAsync(new C06923());
    }

    boolean didPreviousInitializationFail() {
        return ((Boolean) this.executorServiceWrapper.executeSyncLoggingException(new C06934())).booleanValue();
    }

    void setExternalCrashEventDataProvider(CrashEventDataProvider crashEventDataProvider) {
        this.externalCrashEventDataProvider = crashEventDataProvider;
    }

    SessionEventData getExternalCrashEventData() {
        if (this.externalCrashEventDataProvider != null) {
            return this.externalCrashEventDataProvider.getCrashEventData();
        }
        return null;
    }

    boolean internalVerifyPinning(URL url) {
        if (getPinningInfoProvider() == null) {
            return false;
        }
        HttpRequest a = this.httpRequestFactory.mo857a(C1572c.GET, url.toString());
        ((HttpsURLConnection) a.m5887a()).setInstanceFollowRedirects(false);
        a.m5888b();
        return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
    }

    File getSdkDirectory() {
        if (this.sdkDir == null) {
            this.sdkDir = new C1532b(this).mo842a();
        }
        return this.sdkDir;
    }

    boolean shouldPromptUserBeforeSendingCrashReports() {
        return ((Boolean) C1556q.m5839a().m5842a(new C06955(), Boolean.valueOf(false))).booleanValue();
    }

    boolean shouldSendReportsWithoutPrompting() {
        return new C1534d(this).mo843a().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
    }

    @SuppressLint({"CommitPrefEdits"})
    void setShouldSendUserReportsWithoutPrompting(boolean z) {
        C1533c c1534d = new C1534d(this);
        c1534d.mo844a(c1534d.mo845b().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
    }

    boolean canSendWithUserApproval() {
        return ((Boolean) C1556q.m5839a().m5842a(new C06966(), Boolean.valueOf(CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT))).booleanValue();
    }

    CreateReportSpiCall getCreateReportSpiCall(C1558t c1558t) {
        if (c1558t != null) {
            return new DefaultCreateReportSpiCall(this, getOverridenSpiEndpoint(), c1558t.f3900a.f3857d, this.httpRequestFactory);
        }
        return null;
    }

    private void checkForPreviousCrash() {
        if (Boolean.TRUE.equals((Boolean) this.executorServiceWrapper.executeSyncLoggingException(new CrashMarkerCheck(this.crashMarker)))) {
            try {
                this.listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(TAG, "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void createCrashMarker() {
        this.crashMarker.create();
    }

    private boolean getSendDecisionFromUser(Activity activity, C1552o c1552o) {
        final CrashPromptDialog create = CrashPromptDialog.create(activity, c1552o, new C06977());
        activity.runOnUiThread(new Runnable() {
            public void run() {
                create.show();
            }
        });
        C1457c.m5546h().mo811a(TAG, "Waiting for user opt-in.");
        create.await();
        return create.getOptIn();
    }

    static C1553p getSessionSettingsData() {
        C1558t b = C1556q.m5839a().m5843b();
        return b == null ? null : b.f3901b;
    }

    private static String formatLogMessage(int i, String str, String str2) {
        return C1482i.m5663b(i) + "/" + str + " " + str2;
    }

    private static boolean ensureFabricWithCalled(String str) {
        CrashlyticsCore instance = getInstance();
        if (instance != null && instance.handler != null) {
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        }
        C1457c.m5546h().mo819e(TAG, "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        if (str.length() > MAX_ATTRIBUTE_SIZE) {
            return str.substring(0, MAX_ATTRIBUTE_SIZE);
        }
        return str;
    }

    static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            C1457c.m5546h().mo811a(TAG, "Configured not to require a build ID.");
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        } else if (!C1482i.m5669c(str)) {
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        } else {
            Log.e(TAG, ".");
            Log.e(TAG, ".     |  | ");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".   \\ |  | /");
            Log.e(TAG, ".    \\    /");
            Log.e(TAG, ".     \\  /");
            Log.e(TAG, ".      \\/");
            Log.e(TAG, ".");
            Log.e(TAG, MISSING_BUILD_ID_MSG);
            Log.e(TAG, ".");
            Log.e(TAG, ".      /\\");
            Log.e(TAG, ".     /  \\");
            Log.e(TAG, ".    /    \\");
            Log.e(TAG, ".   / |  | \\");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".");
            return false;
        }
    }
}
