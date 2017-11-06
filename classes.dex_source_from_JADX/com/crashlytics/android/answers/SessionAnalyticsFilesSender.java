package com.crashlytics.android.answers;

import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.network.C1572c;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.p018c.C0664f;
import io.fabric.sdk.android.services.p020b.C0671a;
import io.fabric.sdk.android.services.p020b.C1500r;
import java.io.File;
import java.util.List;

class SessionAnalyticsFilesSender extends C0671a implements C0664f {
    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(C0653h c0653h, String str, String str2, C1570d c1570d, String str3) {
        super(c0653h, str, str2, c1570d, C1572c.POST);
        this.apiKey = str3;
    }

    public boolean send(List<File> list) {
        HttpRequest a = getHttpRequest().m5878a(C0671a.HEADER_CLIENT_TYPE, C0671a.ANDROID_CLIENT_TYPE).m5878a(C0671a.HEADER_CLIENT_VERSION, this.kit.getVersion()).m5878a(C0671a.HEADER_API_KEY, this.apiKey);
        int i = 0;
        for (File file : list) {
            a.m5881a(FILE_PARAM_NAME + i, file.getName(), FILE_CONTENT_TYPE, file);
            i++;
        }
        C1457c.m5546h().mo811a(Answers.TAG, "Sending " + list.size() + " analytics files to " + getUrl());
        int b = a.m5888b();
        C1457c.m5546h().mo811a(Answers.TAG, "Response code for analytics file send is " + b);
        if (C1500r.m5738a(b) == 0) {
            return true;
        }
        return false;
    }
}
