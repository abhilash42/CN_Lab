package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1493o;
import io.fabric.sdk.android.services.p020b.C1493o.C1492a;
import java.util.Map;
import java.util.UUID;

class SessionMetadataCollector {
    private final Context context;
    private final C1493o idManager;
    private final String versionCode;
    private final String versionName;

    public SessionMetadataCollector(Context context, C1493o c1493o, String str, String str2) {
        this.context = context;
        this.idManager = c1493o;
        this.versionCode = str;
        this.versionName = str2;
    }

    public SessionEventMetadata getMetadata() {
        Map i = this.idManager.m5703i();
        return new SessionEventMetadata(this.idManager.m5697c(), UUID.randomUUID().toString(), this.idManager.m5696b(), (String) i.get(C1492a.ANDROID_ID), (String) i.get(C1492a.ANDROID_ADVERTISING_ID), this.idManager.m5706l(), (String) i.get(C1492a.FONT_TOKEN), C1482i.m5679m(this.context), this.idManager.m5698d(), this.idManager.m5701g(), this.versionCode, this.versionName);
    }
}
