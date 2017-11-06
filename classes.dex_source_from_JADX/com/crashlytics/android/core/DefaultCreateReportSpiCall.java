package com.crashlytics.android.core;

import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.network.C1572c;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.p020b.C0671a;
import io.fabric.sdk.android.services.p020b.C1500r;
import java.io.File;
import java.util.Map.Entry;

class DefaultCreateReportSpiCall extends C0671a implements CreateReportSpiCall {
    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";
    static final String MULTI_FILE_PARAM = "report[file";

    public DefaultCreateReportSpiCall(C0653h c0653h, String str, String str2, C1570d c1570d) {
        super(c0653h, str, str2, c1570d, C1572c.POST);
    }

    DefaultCreateReportSpiCall(C0653h c0653h, String str, String str2, C1570d c1570d, C1572c c1572c) {
        super(c0653h, str, str2, c1570d, c1572c);
    }

    public boolean invoke(CreateReportRequest createReportRequest) {
        HttpRequest applyMultipartDataTo = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createReportRequest), createReportRequest.report);
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Sending report to: " + getUrl());
        int b = applyMultipartDataTo.m5888b();
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Create report request ID: " + applyMultipartDataTo.m5890b(C0671a.HEADER_REQUEST_ID));
        C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Result was: " + b);
        return C1500r.m5738a(b) == 0;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        HttpRequest a = httpRequest.m5878a(C0671a.HEADER_API_KEY, createReportRequest.apiKey).m5878a(C0671a.HEADER_CLIENT_TYPE, C0671a.ANDROID_CLIENT_TYPE).m5878a(C0671a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        HttpRequest httpRequest2 = a;
        for (Entry a2 : createReportRequest.report.getCustomHeaders().entrySet()) {
            httpRequest2 = httpRequest2.m5884a(a2);
        }
        return httpRequest2;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        int i = 0;
        httpRequest.m5898e(IDENTIFIER_PARAM, report.getIdentifier());
        if (report.getFiles().length == 1) {
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Adding single file " + report.getFileName() + " to report " + report.getIdentifier());
            return httpRequest.m5881a(FILE_PARAM, report.getFileName(), FILE_CONTENT_TYPE, report.getFile());
        }
        File[] files = report.getFiles();
        int length = files.length;
        int i2 = 0;
        while (i < length) {
            File file = files[i];
            C1457c.m5546h().mo811a(CrashlyticsCore.TAG, "Adding file " + file.getName() + " to report " + report.getIdentifier());
            httpRequest.m5881a(MULTI_FILE_PARAM + i2 + "]", file.getName(), FILE_CONTENT_TYPE, file);
            i2++;
            i++;
        }
        return httpRequest;
    }
}
