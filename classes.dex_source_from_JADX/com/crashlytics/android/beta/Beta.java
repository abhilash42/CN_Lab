package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1571b;
import io.fabric.sdk.android.services.p020b.C0676m;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1493o;
import io.fabric.sdk.android.services.p020b.C1493o.C1492a;
import io.fabric.sdk.android.services.p020b.C1501s;
import io.fabric.sdk.android.services.p021a.C1469b;
import io.fabric.sdk.android.services.p022e.C1540f;
import io.fabric.sdk.android.services.p022e.C1556q;
import io.fabric.sdk.android.services.p022e.C1558t;
import io.fabric.sdk.android.services.p037d.C1534d;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Beta extends C0653h<Boolean> implements C0676m {
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String CRASHLYTICS_BUILD_PROPERTIES = "crashlytics-build.properties";
    static final String NO_DEVICE_TOKEN = "";
    public static final String TAG = "Beta";
    private final C1469b<String> deviceTokenCache = new C1469b();
    private final DeviceTokenLoader deviceTokenLoader = new DeviceTokenLoader();
    private UpdatesController updatesController;

    public static Beta getInstance() {
        return (Beta) C1457c.m5538a(Beta.class);
    }

    @TargetApi(14)
    protected boolean onPreExecute() {
        this.updatesController = createUpdatesController(VERSION.SDK_INT, (Application) getContext().getApplicationContext());
        return true;
    }

    protected Boolean doInBackground() {
        C1457c.m5546h().mo811a(TAG, "Beta kit initializing...");
        Context context = getContext();
        C1493o idManager = getIdManager();
        if (TextUtils.isEmpty(getBetaDeviceToken(context, idManager.m5704j()))) {
            C1457c.m5546h().mo811a(TAG, "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        C1457c.m5546h().mo811a(TAG, "Beta device token is present, checking for app updates.");
        C1540f betaSettingsData = getBetaSettingsData();
        BuildProperties loadBuildProperties = loadBuildProperties(context);
        if (canCheckForUpdates(betaSettingsData, loadBuildProperties)) {
            this.updatesController.initialize(context, this, idManager, betaSettingsData, loadBuildProperties, new C1534d(this), new C1501s(), new C1571b(C1457c.m5546h()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    UpdatesController createUpdatesController(int i, Application application) {
        if (i >= 14) {
            return new ActivityLifecycleCheckForUpdatesController(getFabric().m5557e(), getFabric().m5558f());
        }
        return new ImmediateCheckForUpdatesController();
    }

    public Map<C1492a, String> getDeviceIdentifiers() {
        CharSequence betaDeviceToken = getBetaDeviceToken(getContext(), getIdManager().m5704j());
        Map<C1492a, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(betaDeviceToken)) {
            hashMap.put(C1492a.FONT_TOKEN, betaDeviceToken);
        }
        return hashMap;
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String getVersion() {
        return "1.2.2.142";
    }

    boolean canCheckForUpdates(C1540f c1540f, BuildProperties buildProperties) {
        return (c1540f == null || TextUtils.isEmpty(c1540f.f3860a) || buildProperties == null) ? false : true;
    }

    private String getBetaDeviceToken(Context context, String str) {
        Object obj;
        try {
            obj = (String) this.deviceTokenCache.mo826a(context, this.deviceTokenLoader);
            if ("".equals(obj)) {
                obj = null;
            }
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(TAG, "Failed to load the Beta device token", e);
            obj = null;
        }
        C1457c.m5546h().mo811a(TAG, "Beta device token present: " + (!TextUtils.isEmpty(obj)));
        return obj;
    }

    private C1540f getBetaSettingsData() {
        C1558t b = C1556q.m5839a().m5843b();
        if (b != null) {
            return b.f3905f;
        }
        return null;
    }

    private BuildProperties loadBuildProperties(Context context) {
        BuildProperties fromPropertiesStream;
        Throwable th;
        Throwable e;
        Object obj;
        Throwable th2;
        BuildProperties buildProperties;
        InputStream inputStream = null;
        InputStream open;
        try {
            open = context.getAssets().open(CRASHLYTICS_BUILD_PROPERTIES);
            if (open != null) {
                try {
                    fromPropertiesStream = BuildProperties.fromPropertiesStream(open);
                } catch (Throwable e2) {
                    th = e2;
                    obj = inputStream;
                    th2 = th;
                    try {
                        C1457c.m5546h().mo819e(TAG, "Error reading Beta build properties", th2);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th22) {
                                C1457c.m5546h().mo819e(TAG, "Error closing Beta build properties asset", th22);
                            }
                        }
                        return buildProperties;
                    } catch (Throwable th3) {
                        e2 = th3;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th222) {
                                C1457c.m5546h().mo819e(TAG, "Error closing Beta build properties asset", th222);
                            }
                        }
                        throw e2;
                    }
                }
                try {
                    C1457c.m5546h().mo811a(TAG, fromPropertiesStream.packageName + " build properties: " + fromPropertiesStream.versionName + " (" + fromPropertiesStream.versionCode + ")" + " - " + fromPropertiesStream.buildId);
                    buildProperties = fromPropertiesStream;
                } catch (Throwable e22) {
                    th = e22;
                    buildProperties = fromPropertiesStream;
                    th222 = th;
                    C1457c.m5546h().mo819e(TAG, "Error reading Beta build properties", th222);
                    if (open != null) {
                        open.close();
                    }
                    return buildProperties;
                }
            }
            obj = inputStream;
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2222) {
                    C1457c.m5546h().mo819e(TAG, "Error closing Beta build properties asset", th2222);
                }
            }
        } catch (Throwable e222) {
            open = inputStream;
            InputStream inputStream2 = inputStream;
            th2222 = e222;
            buildProperties = inputStream2;
            C1457c.m5546h().mo819e(TAG, "Error reading Beta build properties", th2222);
            if (open != null) {
                open.close();
            }
            return buildProperties;
        } catch (Throwable th4) {
            e222 = th4;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        return buildProperties;
    }

    String getOverridenSpiEndpoint() {
        return C1482i.m5664b(getContext(), CRASHLYTICS_API_ENDPOINT);
    }
}
