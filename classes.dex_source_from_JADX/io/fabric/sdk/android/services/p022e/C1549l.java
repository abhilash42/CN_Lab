package io.fabric.sdk.android.services.p022e;

import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.network.C1572c;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.p020b.C0671a;
import io.fabric.sdk.android.services.p020b.C1482i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DefaultSettingsSpiCall */
class C1549l extends C0671a implements C1548x {
    public C1549l(C0653h c0653h, String str, String str2, C1570d c1570d) {
        this(c0653h, str, str2, c1570d, C1572c.GET);
    }

    C1549l(C0653h c0653h, String str, String str2, C1570d c1570d, C1572c c1572c) {
        super(c0653h, str, str2, c1570d, c1572c);
    }

    public JSONObject mo852a(C1560w c1560w) {
        HttpRequest httpRequest = null;
        try {
            Map b = m5833b(c1560w);
            httpRequest = m5830a(getHttpRequest(b), c1560w);
            C1457c.m5546h().mo811a("Fabric", "Requesting settings from " + getUrl());
            C1457c.m5546h().mo811a("Fabric", "Settings query params were: " + b);
            JSONObject a = m5835a(httpRequest);
            return a;
        } finally {
            if (httpRequest != null) {
                C1457c.m5546h().mo811a("Fabric", "Settings request ID: " + httpRequest.m5890b(C0671a.HEADER_REQUEST_ID));
            }
        }
    }

    JSONObject m5835a(HttpRequest httpRequest) {
        int b = httpRequest.m5888b();
        C1457c.m5546h().mo811a("Fabric", "Settings result was: " + b);
        if (m5836a(b)) {
            return m5831a(httpRequest.m5899e());
        }
        C1457c.m5546h().mo818e("Fabric", "Failed to retrieve settings from " + getUrl());
        return null;
    }

    boolean m5836a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    private JSONObject m5831a(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            C1457c.m5546h().mo812a("Fabric", "Failed to parse settings JSON from " + getUrl(), e);
            C1457c.m5546h().mo811a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> m5833b(C1560w c1560w) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c1560w.f3919j);
        hashMap.put("display_version", c1560w.f3918i);
        hashMap.put("source", Integer.toString(c1560w.f3920k));
        if (c1560w.f3921l != null) {
            hashMap.put("icon_hash", c1560w.f3921l);
        }
        String str = c1560w.f3917h;
        if (!C1482i.m5669c(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private HttpRequest m5830a(HttpRequest httpRequest, C1560w c1560w) {
        m5832a(httpRequest, C0671a.HEADER_API_KEY, c1560w.f3910a);
        m5832a(httpRequest, C0671a.HEADER_CLIENT_TYPE, C0671a.ANDROID_CLIENT_TYPE);
        m5832a(httpRequest, C0671a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        m5832a(httpRequest, C0671a.HEADER_ACCEPT, C0671a.ACCEPT_JSON_VALUE);
        m5832a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", c1560w.f3911b);
        m5832a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", c1560w.f3912c);
        m5832a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", c1560w.f3913d);
        m5832a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", c1560w.f3914e);
        m5832a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", c1560w.f3915f);
        m5832a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", c1560w.f3916g);
        return httpRequest;
    }

    private void m5832a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.m5878a(str, str2);
        }
    }
}
