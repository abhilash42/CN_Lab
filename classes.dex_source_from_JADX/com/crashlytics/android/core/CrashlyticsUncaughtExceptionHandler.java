package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1487l;
import io.fabric.sdk.android.services.p020b.C1493o;
import io.fabric.sdk.android.services.p022e.C1553p;
import io.fabric.sdk.android.services.p022e.C1556q;
import io.fabric.sdk.android.services.p037d.C1531a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CrashlyticsUncaughtExceptionHandler implements UncaughtExceptionHandler {
    private static final int ANALYZER_VERSION = 1;
    static final FilenameFilter ANY_SESSION_FILENAME_FILTER = new C07054();
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    private static final String[] INITIAL_SESSION_PART_TAGS = new String[]{SESSION_USER_TAG, SESSION_APP_TAG, SESSION_OS_TAG, SESSION_DEVICE_TAG};
    static final String INVALID_CLS_CACHE_DIR = "invalidClsFiles";
    static final Comparator<File> LARGEST_FILE_NAME_FIRST = new C07032();
    private static final int MAX_COMPLETE_SESSIONS_COUNT = 4;
    static final int MAX_INVALID_SESSIONS = 4;
    private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
    static final int MAX_OPEN_SESSIONS = 8;
    static final int MAX_STACK_SIZE = 1024;
    static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private static final Map<String, String> SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    static final String SESSION_APP_TAG = "SessionApp";
    static final String SESSION_BEGIN_TAG = "BeginSession";
    static final String SESSION_DEVICE_TAG = "SessionDevice";
    static final String SESSION_EVENT_MISSING_BINARY_IMGS_TAG = "SessionMissingBinaryImages";
    static final String SESSION_FATAL_TAG = "SessionCrash";
    static final FilenameFilter SESSION_FILE_FILTER = new C07021();
    private static final Pattern SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final int SESSION_ID_LENGTH = 35;
    static final String SESSION_NON_FATAL_TAG = "SessionEvent";
    static final String SESSION_OS_TAG = "SessionOS";
    static final String SESSION_USER_TAG = "SessionUser";
    static final Comparator<File> SMALLEST_FILE_NAME_FIRST = new C07043();
    private final CrashlyticsCore crashlyticsCore;
    private final UncaughtExceptionHandler defaultHandler;
    private final DevicePowerStateListener devicePowerStateListener;
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final CrashlyticsExecutorServiceWrapper executorServiceWrapper;
    private final C1531a fileStore;
    private final C1493o idManager;
    private final AtomicBoolean isHandlingException;
    private final LogFileManager logFileManager;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    private final String unityVersion;

    static class C07021 implements FilenameFilter {
        C07021() {
        }

        public boolean accept(File file, String str) {
            return str.length() == ClsFileOutputStream.SESSION_FILE_EXTENSION.length() + 35 && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    }

    static class C07032 implements Comparator<File> {
        C07032() {
        }

        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    static class C07043 implements Comparator<File> {
        C07043() {
        }

        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    static class C07054 implements FilenameFilter {
        C07054() {
        }

        public boolean accept(File file, String str) {
            return CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    }

    private static class AnySessionPartFileFilter implements FilenameFilter {
        private AnySessionPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            return !CrashlyticsUncaughtExceptionHandler.SESSION_FILE_FILTER.accept(file, str) && CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    }

    static class FileNameContainsFilter implements FilenameFilter {
        private final String string;

        public FileNameContainsFilter(String str) {
            this.string = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.string) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    }

    static class InvalidPartFileFilter implements FilenameFilter {
        InvalidPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            return ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(file, str) || str.contains(CrashlyticsUncaughtExceptionHandler.SESSION_EVENT_MISSING_BINARY_IMGS_TAG);
        }
    }

    private static final class SendSessionRunnable implements Runnable {
        private final CrashlyticsCore crashlyticsCore;
        private final File fileToSend;

        public SendSessionRunnable(CrashlyticsCore crashlyticsCore, File file) {
            this.crashlyticsCore = crashlyticsCore;
            this.fileToSend = file;
        }

        public void run() {
            if (C1482i.m5680n(this.crashlyticsCore.getContext())) {
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Attempting to send crash report at time of crash...");
                CreateReportSpiCall createReportSpiCall = this.crashlyticsCore.getCreateReportSpiCall(C1556q.m5839a().m5843b());
                if (createReportSpiCall != null) {
                    new ReportUploader(this.crashlyticsCore.getApiKey(), createReportSpiCall).forceUpload(new SessionReport(this.fileToSend, CrashlyticsUncaughtExceptionHandler.SEND_AT_CRASHTIME_HEADER));
                }
            }
        }
    }

    static class SessionPartFileFilter implements FilenameFilter {
        private final String sessionId;

        public SessionPartFileFilter(String str) {
            this.sessionId = str;
        }

        public boolean accept(File file, String str) {
            if (str.equals(this.sessionId + ClsFileOutputStream.SESSION_FILE_EXTENSION) || !str.contains(this.sessionId) || str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION)) {
                return false;
            }
            return true;
        }
    }

    CrashlyticsUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsExecutorServiceWrapper crashlyticsExecutorServiceWrapper, C1493o c1493o, UnityVersionProvider unityVersionProvider, C1531a c1531a, CrashlyticsCore crashlyticsCore) {
        this.defaultHandler = uncaughtExceptionHandler;
        this.executorServiceWrapper = crashlyticsExecutorServiceWrapper;
        this.idManager = c1493o;
        this.crashlyticsCore = crashlyticsCore;
        this.unityVersion = unityVersionProvider.getUnityVersion();
        this.fileStore = c1531a;
        this.isHandlingException = new AtomicBoolean(false);
        Context context = crashlyticsCore.getContext();
        this.logFileManager = new LogFileManager(context, c1531a);
        this.devicePowerStateListener = new DevicePowerStateListener(context);
        this.stackTraceTrimmingStrategy = new MiddleOutFallbackStrategy(MAX_STACK_SIZE, new RemoveRepeatsStrategy(10));
    }

    public synchronized void uncaughtException(final Thread thread, final Throwable th) {
        this.isHandlingException.set(true);
        try {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            this.devicePowerStateListener.dispose();
            final Date date = new Date();
            this.executorServiceWrapper.executeSyncLoggingException(new Callable<Void>() {
                public Void call() {
                    CrashlyticsUncaughtExceptionHandler.this.handleUncaughtException(date, thread, th);
                    return null;
                }
            });
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Crashlytics completed exception processing. Invoking default exception handler.");
            this.defaultHandler.uncaughtException(thread, th);
            this.isHandlingException.set(false);
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "An error occurred in the uncaught exception handler", e);
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Crashlytics completed exception processing. Invoking default exception handler.");
            this.defaultHandler.uncaughtException(thread, th);
            this.isHandlingException.set(false);
        } catch (Throwable th2) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Crashlytics completed exception processing. Invoking default exception handler.");
            this.defaultHandler.uncaughtException(thread, th);
            this.isHandlingException.set(false);
        }
    }

    private void handleUncaughtException(Date date, Thread thread, Throwable th) {
        this.crashlyticsCore.createCrashMarker();
        writeFatal(date, thread, th);
        doCloseSessions();
        doOpenSession();
        trimSessionFiles();
        if (!this.crashlyticsCore.shouldPromptUserBeforeSendingCrashReports()) {
            sendSessionReports();
        }
    }

    boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    File getInvalidFilesDir() {
        return new File(getFilesDir(), INVALID_CLS_CACHE_DIR);
    }

    void writeToLog(final long j, final String str) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            public Void call() {
                if (!CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    CrashlyticsUncaughtExceptionHandler.this.logFileManager.writeToLog(j, str);
                }
                return null;
            }
        });
    }

    void writeNonFatalException(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.executorServiceWrapper.executeAsync(new Runnable() {
            public void run() {
                if (!CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    CrashlyticsUncaughtExceptionHandler.this.doWriteNonFatal(date, thread, th);
                }
            }
        });
    }

    void cacheUserData(final String str, final String str2, final String str3) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            public Void call() {
                new MetaDataStore(CrashlyticsUncaughtExceptionHandler.this.getFilesDir()).writeUserData(CrashlyticsUncaughtExceptionHandler.this.getCurrentSessionId(), new UserMetaData(str, str2, str3));
                return null;
            }
        });
    }

    void cacheKeyData(final Map<String, String> map) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            public Void call() {
                new MetaDataStore(CrashlyticsUncaughtExceptionHandler.this.getFilesDir()).writeKeyData(CrashlyticsUncaughtExceptionHandler.this.getCurrentSessionId(), map);
                return null;
            }
        });
    }

    void openSession() {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            public Void call() {
                CrashlyticsUncaughtExceptionHandler.this.doOpenSession();
                return null;
            }
        });
    }

    private String getCurrentSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        return listSortedSessionBeginFiles.length > 0 ? getSessionIdFromSessionFile(listSortedSessionBeginFiles[0]) : null;
    }

    private String getPreviousSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        return listSortedSessionBeginFiles.length > 1 ? getSessionIdFromSessionFile(listSortedSessionBeginFiles[1]) : null;
    }

    static String getSessionIdFromSessionFile(File file) {
        return file.getName().substring(0, 35);
    }

    boolean hasOpenSession() {
        return listSessionBeginFiles().length > 0;
    }

    boolean finalizeSessions() {
        return ((Boolean) this.executorServiceWrapper.executeSyncLoggingException(new Callable<Boolean>() {
            public Boolean call() {
                if (CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Finalizing previously open sessions.");
                CrashlyticsUncaughtExceptionHandler.this.doCloseSessions(true);
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    private void doOpenSession() {
        Date date = new Date();
        String clsuuid = new CLSUUID(this.idManager).toString();
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Opening an new session with ID " + clsuuid);
        writeBeginSession(clsuuid, date);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
    }

    void doCloseSessions() {
        doCloseSessions(false);
    }

    private void doCloseSessions(boolean z) {
        int i = z ? 1 : 0;
        trimOpenSessions(i + 8);
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length <= i) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "No open sessions to be closed.");
            return;
        }
        writeSessionUser(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i]));
        CrashlyticsCore crashlyticsCore = this.crashlyticsCore;
        C1553p sessionSettingsData = CrashlyticsCore.getSessionSettingsData();
        if (sessionSettingsData == null) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Unable to close session. Settings are not loaded.");
        } else {
            closeOpenSessions(listSortedSessionBeginFiles, i, sessionSettingsData.f3887c);
        }
    }

    private void closeOpenSessions(File[] fileArr, int i, int i2) {
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String sessionIdFromSessionFile = getSessionIdFromSessionFile(file);
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Closing session: " + sessionIdFromSessionFile);
            writeSessionPartsToSessionFile(file, sessionIdFromSessionFile, i2);
            i++;
        }
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.closeInProgressStream();
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void deleteSessionPartFilesFor(String str) {
        for (File delete : listSessionPartFilesFor(str)) {
            delete.delete();
        }
    }

    private File[] listSessionPartFilesFor(String str) {
        return listFilesMatching(new SessionPartFileFilter(str));
    }

    private File[] listCompleteSessionFiles() {
        return listFilesMatching(SESSION_FILE_FILTER);
    }

    File[] listSessionBeginFiles() {
        return listFilesMatching(new FileNameContainsFilter(SESSION_BEGIN_TAG));
    }

    private File[] listSortedSessionBeginFiles() {
        File[] listSessionBeginFiles = listSessionBeginFiles();
        Arrays.sort(listSessionBeginFiles, LARGEST_FILE_NAME_FIRST);
        return listSessionBeginFiles;
    }

    private File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(getFilesDir(), filenameFilter);
    }

    private File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }

    private File[] listFiles(File file) {
        return ensureFileArrayNotNull(file.listFiles());
    }

    private File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void trimSessionEventFiles(String str, int i) {
        Utils.capFileCount(getFilesDir(), new FileNameContainsFilter(str + SESSION_NON_FATAL_TAG), i, SMALLEST_FILE_NAME_FIRST);
    }

    void trimSessionFiles() {
        Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, 4, SMALLEST_FILE_NAME_FIRST);
    }

    private void trimOpenSessions(int i) {
        Set hashSet = new HashSet();
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        int min = Math.min(i, listSortedSessionBeginFiles.length);
        for (int i2 = 0; i2 < min; i2++) {
            hashSet.add(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i2]));
        }
        this.logFileManager.discardOldLogFiles(hashSet);
        retainSessions(listFilesMatching(new AnySessionPartFileFilter()), hashSet);
    }

    private void retainSessions(File[] fileArr, Set<String> set) {
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            String name = file.getName();
            Matcher matcher = SESSION_FILE_PATTERN.matcher(name);
            if (matcher.matches()) {
                if (!set.contains(matcher.group(1))) {
                    C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Trimming session file: " + name);
                    file.delete();
                }
                i++;
            } else {
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Deleting unknown file: " + name);
                file.delete();
                return;
            }
        }
    }

    private File[] getTrimmedNonFatalFiles(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
        trimSessionEventFiles(str, i);
        return listFilesMatching(new FileNameContainsFilter(str + SESSION_NON_FATAL_TAG));
    }

    void cleanInvalidTempFiles() {
        this.executorServiceWrapper.executeAsync(new Runnable() {
            public void run() {
                CrashlyticsUncaughtExceptionHandler.this.doCleanInvalidTempFiles(CrashlyticsUncaughtExceptionHandler.this.listFilesMatching(new InvalidPartFileFilter()));
            }
        });
    }

    void doCleanInvalidTempFiles(File[] fileArr) {
        int length;
        int i = 0;
        final Set hashSet = new HashSet();
        for (File file : fileArr) {
            File file2;
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Found invalid session part file: " + file2);
            hashSet.add(getSessionIdFromSessionFile(file2));
        }
        if (!hashSet.isEmpty()) {
            File invalidFilesDir = getInvalidFilesDir();
            if (!invalidFilesDir.exists()) {
                invalidFilesDir.mkdir();
            }
            File[] listFilesMatching = listFilesMatching(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            });
            length = listFilesMatching.length;
            while (i < length) {
                file2 = listFilesMatching[i];
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Moving session file: " + file2);
                if (!file2.renameTo(new File(invalidFilesDir, file2.getName()))) {
                    C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Could not move session file. Deleting " + file2);
                    file2.delete();
                }
                i++;
            }
            trimInvalidSessionFiles();
        }
    }

    private void trimInvalidSessionFiles() {
        File invalidFilesDir = getInvalidFilesDir();
        if (invalidFilesDir.exists()) {
            File[] listFilesMatching = listFilesMatching(invalidFilesDir, new InvalidPartFileFilter());
            Arrays.sort(listFilesMatching, Collections.reverseOrder());
            Set hashSet = new HashSet();
            for (int i = 0; i < listFilesMatching.length && hashSet.size() < 4; i++) {
                hashSet.add(getSessionIdFromSessionFile(listFilesMatching[i]));
            }
            retainSessions(listFiles(invalidFilesDir), hashSet);
        }
    }

    private void writeFatal(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        try {
            String currentSessionId = getCurrentSessionId();
            if (currentSessionId == null) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Tried to write a fatal exception while no session was open.", null);
                C1482i.m5657a(null, "Failed to flush to session begin file.");
                C1482i.m5656a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            CrashlyticsCore.recordFatalExceptionEvent(currentSessionId, th.getClass().getName());
            Closeable clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), currentSessionId + SESSION_FATAL_TAG);
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                writeSessionEvent(flushable, date, thread, th, EVENT_TYPE_CRASH, true);
                C1482i.m5657a(flushable, "Failed to flush to session begin file.");
                C1482i.m5656a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                closeable = clsFileOutputStream;
                try {
                    C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "An error occurred in the fatal exception logger", e);
                    C1482i.m5657a(flushable, "Failed to flush to session begin file.");
                    C1482i.m5656a(closeable, "Failed to close fatal exception file output stream.");
                } catch (Throwable th2) {
                    e = th2;
                    C1482i.m5657a(flushable, "Failed to flush to session begin file.");
                    C1482i.m5656a(closeable, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                closeable = clsFileOutputStream;
                C1482i.m5657a(flushable, "Failed to flush to session begin file.");
                C1482i.m5656a(closeable, "Failed to close fatal exception file output stream.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            closeable = null;
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "An error occurred in the fatal exception logger", e);
            C1482i.m5657a(flushable, "Failed to flush to session begin file.");
            C1482i.m5656a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            e = th4;
            closeable = null;
            C1482i.m5657a(flushable, "Failed to flush to session begin file.");
            C1482i.m5656a(closeable, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    void writeExternalCrashEvent(final SessionEventData sessionEventData) {
        this.executorServiceWrapper.executeAsync(new Callable<Void>() {
            public Void call() {
                if (!CrashlyticsUncaughtExceptionHandler.this.isHandlingException.get()) {
                    CrashlyticsUncaughtExceptionHandler.this.doWriteExternalCrashEvent(sessionEventData);
                }
                return null;
            }
        });
    }

    private void doWriteExternalCrashEvent(SessionEventData sessionEventData) {
        Closeable clsFileOutputStream;
        Throwable e;
        Object obj = 1;
        Flushable flushable = null;
        try {
            String previousSessionId = getPreviousSessionId();
            if (previousSessionId == null) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Tried to write a native crash while no session was open.", null);
                C1482i.m5657a(null, "Failed to flush to session begin file.");
                C1482i.m5656a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            CrashlyticsCore.recordFatalExceptionEvent(previousSessionId, String.format(Locale.US, "<native-crash [%s (%s)]>", new Object[]{sessionEventData.signal.code, sessionEventData.signal.name}));
            if (sessionEventData.binaryImages == null || sessionEventData.binaryImages.length <= 0) {
                obj = null;
            }
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), previousSessionId + (obj != null ? SESSION_FATAL_TAG : SESSION_EVENT_MISSING_BINARY_IMGS_TAG));
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                NativeCrashWriter.writeNativeCrash(sessionEventData, new LogFileManager(this.crashlyticsCore.getContext(), this.fileStore, previousSessionId), new MetaDataStore(getFilesDir()).readKeyData(previousSessionId), flushable);
                C1482i.m5657a(flushable, "Failed to flush to session begin file.");
                C1482i.m5656a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "An error occurred in the native crash logger", e);
                    C1482i.m5657a(flushable, "Failed to flush to session begin file.");
                    C1482i.m5656a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                } catch (Throwable th) {
                    e = th;
                    C1482i.m5657a(flushable, "Failed to flush to session begin file.");
                    C1482i.m5656a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "An error occurred in the native crash logger", e);
            C1482i.m5657a(flushable, "Failed to flush to session begin file.");
            C1482i.m5656a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
        } catch (Throwable th2) {
            e = th2;
            clsFileOutputStream = null;
            C1482i.m5657a(flushable, "Failed to flush to session begin file.");
            C1482i.m5656a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void doWriteNonFatal(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        String currentSessionId = getCurrentSessionId();
        if (currentSessionId == null) {
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        CrashlyticsCore.recordLoggedExceptionEvent(currentSessionId, th.getClass().getName());
        try {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
            Closeable clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), currentSessionId + SESSION_NON_FATAL_TAG + C1482i.m5643a(this.eventCounter.getAndIncrement()));
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                writeSessionEvent(flushable, date, thread, th, "error", false);
                C1482i.m5657a(flushable, "Failed to flush to non-fatal file.");
                C1482i.m5656a(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            } catch (Exception e2) {
                e = e2;
                closeable = clsFileOutputStream;
                try {
                    C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "An error occurred in the non-fatal exception logger", e);
                    C1482i.m5657a(flushable, "Failed to flush to non-fatal file.");
                    C1482i.m5656a(closeable, "Failed to close non-fatal file output stream.");
                    trimSessionEventFiles(currentSessionId, 64);
                } catch (Throwable th2) {
                    e = th2;
                    C1482i.m5657a(flushable, "Failed to flush to non-fatal file.");
                    C1482i.m5656a(closeable, "Failed to close non-fatal file output stream.");
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                closeable = clsFileOutputStream;
                C1482i.m5657a(flushable, "Failed to flush to non-fatal file.");
                C1482i.m5656a(closeable, "Failed to close non-fatal file output stream.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            closeable = null;
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "An error occurred in the non-fatal exception logger", e);
            C1482i.m5657a(flushable, "Failed to flush to non-fatal file.");
            C1482i.m5656a(closeable, "Failed to close non-fatal file output stream.");
            trimSessionEventFiles(currentSessionId, 64);
        } catch (Throwable th4) {
            e = th4;
            closeable = null;
            C1482i.m5657a(flushable, "Failed to flush to non-fatal file.");
            C1482i.m5656a(closeable, "Failed to close non-fatal file output stream.");
            throw e;
        }
        try {
            trimSessionEventFiles(currentSessionId, 64);
        } catch (Throwable e4) {
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "An error occurred when trimming non-fatal files.", e4);
        }
    }

    private void writeBeginSession(String str, Date date) {
        Throwable th;
        Flushable flushable = null;
        Closeable clsFileOutputStream;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_BEGIN_TAG);
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                SessionProtobufHelper.writeBeginSession(flushable, str, String.format(Locale.US, GENERATOR_FORMAT, new Object[]{this.crashlyticsCore.getVersion()}), date.getTime() / 1000);
                C1482i.m5657a(flushable, "Failed to flush to session begin file.");
                C1482i.m5656a(clsFileOutputStream, "Failed to close begin session file.");
            } catch (Throwable th2) {
                th = th2;
                C1482i.m5657a(flushable, "Failed to flush to session begin file.");
                C1482i.m5656a(clsFileOutputStream, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            C1482i.m5657a(flushable, "Failed to flush to session begin file.");
            C1482i.m5656a(clsFileOutputStream, "Failed to close begin session file.");
            throw th;
        }
    }

    private void writeSessionApp(String str) {
        Closeable closeable;
        Throwable th;
        Flushable flushable = null;
        try {
            Closeable clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_APP_TAG);
            try {
                Flushable newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                try {
                    SessionProtobufHelper.writeSessionApp(newInstance, this.idManager.m5697c(), this.crashlyticsCore.getApiKey(), this.crashlyticsCore.getVersionCode(), this.crashlyticsCore.getVersionName(), this.idManager.m5696b(), C1487l.m5684a(this.crashlyticsCore.getInstallerPackageName()).m5685a(), this.unityVersion);
                    C1482i.m5657a(newInstance, "Failed to flush to session app file.");
                    C1482i.m5656a(clsFileOutputStream, "Failed to close session app file.");
                } catch (Throwable th2) {
                    closeable = clsFileOutputStream;
                    Flushable flushable2 = newInstance;
                    th = th2;
                    flushable = flushable2;
                    C1482i.m5657a(flushable, "Failed to flush to session app file.");
                    C1482i.m5656a(closeable, "Failed to close session app file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = clsFileOutputStream;
                C1482i.m5657a(flushable, "Failed to flush to session app file.");
                C1482i.m5656a(closeable, "Failed to close session app file.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            C1482i.m5657a(flushable, "Failed to flush to session app file.");
            C1482i.m5656a(closeable, "Failed to close session app file.");
            throw th;
        }
    }

    private void writeSessionOS(String str) {
        Closeable clsFileOutputStream;
        Throwable th;
        Flushable flushable = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_OS_TAG);
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                SessionProtobufHelper.writeSessionOS(flushable, C1482i.m5673g(this.crashlyticsCore.getContext()));
                C1482i.m5657a(flushable, "Failed to flush to session OS file.");
                C1482i.m5656a(clsFileOutputStream, "Failed to close session OS file.");
            } catch (Throwable th2) {
                th = th2;
                C1482i.m5657a(flushable, "Failed to flush to session OS file.");
                C1482i.m5656a(clsFileOutputStream, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            C1482i.m5657a(flushable, "Failed to flush to session OS file.");
            C1482i.m5656a(clsFileOutputStream, "Failed to close session OS file.");
            throw th;
        }
    }

    private void writeSessionDevice(String str) {
        Throwable th;
        Closeable closeable = null;
        Flushable flushable = null;
        try {
            OutputStream clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_DEVICE_TAG);
            try {
                flushable = CodedOutputStream.newInstance(clsFileOutputStream);
                Context context = this.crashlyticsCore.getContext();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                SessionProtobufHelper.writeSessionDevice(flushable, this.idManager.m5702h(), C1482i.m5637a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), C1482i.m5660b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), C1482i.m5672f(context), this.idManager.m5703i(), C1482i.m5674h(context), Build.MANUFACTURER, Build.PRODUCT);
                C1482i.m5657a(flushable, "Failed to flush session device info.");
                C1482i.m5656a((Closeable) clsFileOutputStream, "Failed to close session device file.");
            } catch (Throwable th2) {
                th = th2;
                Object obj = clsFileOutputStream;
                C1482i.m5657a(flushable, "Failed to flush session device info.");
                C1482i.m5656a(closeable, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C1482i.m5657a(flushable, "Failed to flush session device info.");
            C1482i.m5656a(closeable, "Failed to close session device file.");
            throw th;
        }
    }

    private void writeSessionUser(String str) {
        Closeable clsFileOutputStream;
        Throwable th;
        Flushable flushable = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str + SESSION_USER_TAG);
            try {
                flushable = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                UserMetaData userMetaData = getUserMetaData(str);
                if (userMetaData.isEmpty()) {
                    C1482i.m5657a(flushable, "Failed to flush session user file.");
                    C1482i.m5656a(clsFileOutputStream, "Failed to close session user file.");
                    return;
                }
                SessionProtobufHelper.writeSessionUser(flushable, userMetaData.id, userMetaData.name, userMetaData.email);
                C1482i.m5657a(flushable, "Failed to flush session user file.");
                C1482i.m5656a(clsFileOutputStream, "Failed to close session user file.");
            } catch (Throwable th2) {
                th = th2;
                C1482i.m5657a(flushable, "Failed to flush session user file.");
                C1482i.m5656a(clsFileOutputStream, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            C1482i.m5657a(flushable, "Failed to flush session user file.");
            C1482i.m5656a(clsFileOutputStream, "Failed to close session user file.");
            throw th;
        }
    }

    private void writeSessionEvent(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) {
        Thread[] threadArr;
        Map treeMap;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy);
        Context context = this.crashlyticsCore.getContext();
        long time = date.getTime() / 1000;
        Float c = C1482i.m5666c(context);
        int a = C1482i.m5639a(context, this.devicePowerStateListener.isPowerConnected());
        boolean d = C1482i.m5670d(context);
        int i = context.getResources().getConfiguration().orientation;
        long b = C1482i.m5660b() - C1482i.m5661b(context);
        long b2 = C1482i.m5662b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = C1482i.m5641a(context.getPackageName(), context);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String buildId = this.crashlyticsCore.getBuildId();
        String c2 = this.idManager.m5697c();
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr[i2] = (Thread) entry.getKey();
                linkedList.add(this.stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[]) entry.getValue()));
                i2++;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (C1482i.m5659a(context, "com.crashlytics.CollectCustomKeys", true)) {
            Map attributes = this.crashlyticsCore.getAttributes();
            treeMap = (attributes == null || attributes.size() <= 1) ? attributes : new TreeMap(attributes);
        } else {
            treeMap = new TreeMap();
        }
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.logFileManager, a2, i, c2, buildId, c, a, d, b, b2);
    }

    private void writeSessionPartsToSessionFile(File file, String str, int i) {
        boolean z;
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Collecting session parts for ID " + str);
        File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + SESSION_FATAL_TAG));
        boolean z2 = listFilesMatching != null && listFilesMatching.length > 0;
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)}));
        File[] listFilesMatching2 = listFilesMatching(new FileNameContainsFilter(str + SESSION_NON_FATAL_TAG));
        if (listFilesMatching2 == null || listFilesMatching2.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z)}));
        if (z2 || z) {
            synthesizeSessionFile(file, str, getTrimmedNonFatalFiles(str, listFilesMatching2, i), z2 ? listFilesMatching[0] : null);
        } else {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "No events present for session ID " + str);
        }
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Removing session part files for ID " + str);
        deleteSessionPartFilesFor(str);
    }

    private void synthesizeSessionFile(File file, String str, File[] fileArr, File file2) {
        Closeable clsFileOutputStream;
        Throwable e;
        boolean z = true;
        if (file2 == null) {
            z = false;
        }
        try {
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), str);
            try {
                Flushable newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Collecting SessionStart data for session ID " + str);
                writeToCosFromFile(newInstance, file);
                newInstance.writeUInt64(4, new Date().getTime() / 1000);
                newInstance.writeBool(5, z);
                newInstance.writeUInt32(11, 1);
                newInstance.writeEnum(12, 3);
                writeInitialPartsTo(newInstance, str);
                writeNonFatalEventsTo(newInstance, fileArr, str);
                if (z) {
                    writeToCosFromFile(newInstance, file2);
                }
                C1482i.m5657a(newInstance, "Error flushing session file stream");
                C1482i.m5656a(clsFileOutputStream, "Failed to close CLS file");
            } catch (Exception e2) {
                e = e2;
                try {
                    C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Failed to write session file for session ID: " + str, e);
                    C1482i.m5657a(null, "Error flushing session file stream");
                    closeWithoutRenamingOrLog(clsFileOutputStream);
                } catch (Throwable th) {
                    e = th;
                    C1482i.m5657a(null, "Error flushing session file stream");
                    C1482i.m5656a(clsFileOutputStream, "Failed to close CLS file");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Failed to write session file for session ID: " + str, e);
            C1482i.m5657a(null, "Error flushing session file stream");
            closeWithoutRenamingOrLog(clsFileOutputStream);
        } catch (Throwable th2) {
            e = th2;
            clsFileOutputStream = null;
            C1482i.m5657a(null, "Error flushing session file stream");
            C1482i.m5656a(clsFileOutputStream, "Failed to close CLS file");
            throw e;
        }
    }

    private static void writeNonFatalEventsTo(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, C1482i.f3712a);
        for (File name : fileArr) {
            try {
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                writeToCosFromFile(codedOutputStream, name);
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error writting non-fatal to session.", e);
            }
        }
    }

    private void writeInitialPartsTo(CodedOutputStream codedOutputStream, String str) {
        for (String str2 : INITIAL_SESSION_PART_TAGS) {
            File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + str2));
            if (listFilesMatching.length == 0) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Collecting " + str2 + " data for session ID " + str);
                writeToCosFromFile(codedOutputStream, listFilesMatching[0]);
            }
        }
    }

    private static void writeToCosFromFile(CodedOutputStream codedOutputStream, File file) {
        Throwable th;
        if (file.exists()) {
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    copyToCodedOutputStream(fileInputStream, codedOutputStream, (int) file.length());
                    C1482i.m5656a(fileInputStream, "Failed to close file input stream.");
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    C1482i.m5656a(fileInputStream, "Failed to close file input stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                C1482i.m5656a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private static void copyToCodedOutputStream(InputStream inputStream, CodedOutputStream codedOutputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = inputStream.read(bArr, i2, bArr.length - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        codedOutputStream.writeRawBytes(bArr);
    }

    private UserMetaData getUserMetaData(String str) {
        return isHandlingException() ? new UserMetaData(this.crashlyticsCore.getUserIdentifier(), this.crashlyticsCore.getUserName(), this.crashlyticsCore.getUserEmail()) : new MetaDataStore(getFilesDir()).readUserData(str);
    }

    private void sendSessionReports() {
        for (File sendSessionRunnable : listCompleteSessionFiles()) {
            this.executorServiceWrapper.executeAsync(new SendSessionRunnable(this.crashlyticsCore, sendSessionRunnable));
        }
    }

    private File getFilesDir() {
        return this.fileStore.mo842a();
    }
}
