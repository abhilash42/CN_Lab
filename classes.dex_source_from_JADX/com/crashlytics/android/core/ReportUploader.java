package com.crashlytics.android.core;

import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p020b.C0719h;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ReportUploader {
    private static final String CLS_FILE_EXT = ".cls";
    static final Map<String, String> HEADER_INVALID_CLS_FILE = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    private static final short[] RETRY_INTERVALS = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private static final FilenameFilter crashFileFilter = new C07181();
    private final String apiKey;
    private final CreateReportSpiCall createReportCall;
    private final Object fileAccessLock = new Object();
    private Thread uploadThread;

    static class C07181 implements FilenameFilter {
        C07181() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cls") && !str.contains("Session");
        }
    }

    private class Worker extends C0719h {
        private final float delay;

        Worker(float f) {
            this.delay = f;
        }

        public void onRun() {
            try {
                attemptUploadWithRetry();
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.uploadThread = null;
        }

        private void attemptUploadWithRetry() {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Starting report processing in " + this.delay + " second(s)...");
            if (this.delay > 0.0f) {
                try {
                    Thread.sleep((long) (this.delay * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            CrashlyticsCore instance = CrashlyticsCore.getInstance();
            CrashlyticsUncaughtExceptionHandler handler = instance.getHandler();
            List<Report> findReports = ReportUploader.this.findReports();
            if (!handler.isHandlingException()) {
                if (findReports.isEmpty() || instance.canSendWithUserApproval()) {
                    List list = findReports;
                    int i = 0;
                    while (!r0.isEmpty() && !CrashlyticsCore.getInstance().getHandler().isHandlingException()) {
                        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Attempting to send " + r0.size() + " report(s)");
                        for (Report forceUpload : r0) {
                            ReportUploader.this.forceUpload(forceUpload);
                        }
                        List findReports2 = ReportUploader.this.findReports();
                        if (findReports2.isEmpty()) {
                            list = findReports2;
                        } else {
                            int i2 = i + 1;
                            long j = (long) ReportUploader.RETRY_INTERVALS[Math.min(i, ReportUploader.RETRY_INTERVALS.length - 1)];
                            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                                list = findReports2;
                            } catch (InterruptedException e2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "User declined to send. Removing " + findReports.size() + " Report(s).");
                for (Report forceUpload2 : findReports) {
                    forceUpload2.remove();
                }
            }
        }
    }

    public ReportUploader(String str, CreateReportSpiCall createReportSpiCall) {
        if (createReportSpiCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.createReportCall = createReportSpiCall;
        this.apiKey = str;
    }

    public void uploadReports() {
        uploadReports(0.0f);
    }

    public synchronized void uploadReports(float f) {
        if (this.uploadThread == null) {
            this.uploadThread = new Thread(new Worker(f), "Crashlytics Report Uploader");
            this.uploadThread.start();
        }
    }

    boolean isUploading() {
        return this.uploadThread != null;
    }

    boolean forceUpload(Report report) {
        boolean z = false;
        synchronized (this.fileAccessLock) {
            try {
                boolean invoke = this.createReportCall.invoke(new CreateReportRequest(this.apiKey, report));
                C1457c.m5546h().mo815c(CrashlyticsCore.TAG, "Crashlytics report upload " + (invoke ? "complete: " : "FAILED: ") + report.getIdentifier());
                if (invoke) {
                    report.remove();
                    z = true;
                }
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error occurred sending report " + report, e);
            }
        }
        return z;
    }

    List<Report> findReports() {
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Checking for crash reports...");
        CrashlyticsCore instance = CrashlyticsCore.getInstance();
        CrashlyticsUncaughtExceptionHandler handler = instance.getHandler();
        synchronized (this.fileAccessLock) {
            File[] listFiles = instance.getSdkDirectory().listFiles(crashFileFilter);
            File[] listFiles2 = handler.getInvalidFilesDir().listFiles();
        }
        List<Report> linkedList = new LinkedList();
        for (File file : listFiles) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Found crash report " + file.getPath());
            linkedList.add(new SessionReport(file));
        }
        Map hashMap = new HashMap();
        if (listFiles2 != null) {
            for (File file2 : listFiles2) {
                String sessionIdFromSessionFile = CrashlyticsUncaughtExceptionHandler.getSessionIdFromSessionFile(file2);
                if (!hashMap.containsKey(sessionIdFromSessionFile)) {
                    hashMap.put(sessionIdFromSessionFile, new LinkedList());
                }
                ((List) hashMap.get(sessionIdFromSessionFile)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Found invalid session: " + str);
            List list = (List) hashMap.get(str);
            linkedList.add(new InvalidSessionReport(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (linkedList.isEmpty()) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "No reports found.");
        }
        return linkedList;
    }
}
