package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p037d.C1531a;
import java.io.File;
import java.util.Set;

class LogFileManager {
    private static final String DIRECTORY_NAME = "log-files";
    private static final String LOGFILE_EXT = ".temp";
    private static final String LOGFILE_PREFIX = "crashlytics-userlog-";
    static final int MAX_LOG_SIZE = 65536;
    private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore();
    private final Context context;
    private FileLogStore currentLog;
    private final C1531a fileStore;

    private static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        public void writeToLog(long j, String str) {
        }

        public ByteString getLogAsByteString() {
            return null;
        }

        public void closeLogFile() {
        }

        public void deleteLogFile() {
        }
    }

    public LogFileManager(Context context, C1531a c1531a) {
        this(context, c1531a, null);
    }

    public LogFileManager(Context context, C1531a c1531a, String str) {
        this.context = context;
        this.fileStore = c1531a;
        this.currentLog = NOOP_LOG_STORE;
        setCurrentSession(str);
    }

    public final void setCurrentSession(String str) {
        this.currentLog.closeLogFile();
        this.currentLog = NOOP_LOG_STORE;
        if (str != null) {
            if (isLoggingEnabled()) {
                setLogFile(getWorkingFileForSession(str), MAX_LOG_SIZE);
            } else {
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Preferences requested no custom logs. Aborting log file creation.");
            }
        }
    }

    public void writeToLog(long j, String str) {
        this.currentLog.writeToLog(j, str);
    }

    public ByteString getByteStringForLog() {
        return this.currentLog.getLogAsByteString();
    }

    public void clearLog() {
        this.currentLog.deleteLogFile();
    }

    public void discardOldLogFiles(Set<String> set) {
        File[] listFiles = getLogFileDir().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(getSessionIdForFile(file))) {
                    file.delete();
                }
            }
        }
    }

    void setLogFile(File file, int i) {
        this.currentLog = new QueueFileLogStore(file, i);
    }

    private File getWorkingFileForSession(String str) {
        return new File(getLogFileDir(), LOGFILE_PREFIX + str + LOGFILE_EXT);
    }

    private String getSessionIdForFile(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(LOGFILE_EXT);
        return lastIndexOf == -1 ? name : name.substring(LOGFILE_PREFIX.length(), lastIndexOf);
    }

    private boolean isLoggingEnabled() {
        return C1482i.m5659a(this.context, "com.crashlytics.CollectCustomLogs", true);
    }

    private File getLogFileDir() {
        File file = new File(this.fileStore.mo842a(), DIRECTORY_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
