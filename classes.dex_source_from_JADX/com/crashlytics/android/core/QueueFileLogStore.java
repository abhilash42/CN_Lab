package com.crashlytics.android.core;

import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1499q;
import io.fabric.sdk.android.services.p020b.C1499q.C0715c;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;

class QueueFileLogStore implements FileLogStore {
    private C1499q logFile;
    private final int maxLogSize;
    private final File workingFile;

    public QueueFileLogStore(File file, int i) {
        this.workingFile = file;
        this.maxLogSize = i;
    }

    public void writeToLog(long j, String str) {
        openLogFile();
        doWriteToLog(j, str);
    }

    public ByteString getLogAsByteString() {
        if (!this.workingFile.exists()) {
            return null;
        }
        openLogFile();
        if (this.logFile == null) {
            return null;
        }
        final int[] iArr = new int[]{0};
        final byte[] bArr = new byte[this.logFile.m5730a()];
        try {
            this.logFile.m5731a(new C0715c() {
                public void read(InputStream inputStream, int i) {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "A problem occurred while reading the Crashlytics log file.", e);
        }
        return ByteString.copyFrom(bArr, 0, iArr[0]);
    }

    public void closeLogFile() {
        C1482i.m5656a(this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = null;
    }

    public void deleteLogFile() {
        closeLogFile();
        this.workingFile.delete();
    }

    private void openLogFile() {
        if (this.logFile == null) {
            try {
                this.logFile = new C1499q(this.workingFile);
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Could not open log file: " + this.workingFile, e);
            }
        }
    }

    private void doWriteToLog(long j, String str) {
        if (this.logFile != null) {
            String str2;
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            try {
                int i = this.maxLogSize / 4;
                if (str2.length() > i) {
                    str2 = "..." + str2.substring(str2.length() - i);
                }
                str2 = str2.replaceAll("\r", " ").replaceAll("\n", " ");
                this.logFile.m5732a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str2}).getBytes("UTF-8"));
                while (!this.logFile.m5735b() && this.logFile.m5730a() > this.maxLogSize) {
                    this.logFile.m5736c();
                }
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
