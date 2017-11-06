package io.fabric.sdk.android.services.p022e;

import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.C1465j;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.network.C1572c;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.p020b.C0671a;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1500r;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: AbstractAppSpiCall */
abstract class C1535a extends C0671a {
    public C1535a(C0653h c0653h, String str, String str2, C1570d c1570d, C1572c c1572c) {
        super(c0653h, str, str2, c1570d, c1572c);
    }

    public boolean mo846a(C1538d c1538d) {
        HttpRequest b = m5800b(m5799a(getHttpRequest(), c1538d), c1538d);
        C1457c.m5546h().mo811a("Fabric", "Sending app info to " + getUrl());
        if (c1538d.f3852j != null) {
            C1457c.m5546h().mo811a("Fabric", "App icon hash is " + c1538d.f3852j.f3874a);
            C1457c.m5546h().mo811a("Fabric", "App icon size is " + c1538d.f3852j.f3876c + "x" + c1538d.f3852j.f3877d);
        }
        int b2 = b.m5888b();
        C1457c.m5546h().mo811a("Fabric", ("POST".equals(b.m5912p()) ? "Create" : "Update") + " app request ID: " + b.m5890b(C0671a.HEADER_REQUEST_ID));
        C1457c.m5546h().mo811a("Fabric", "Result was " + b2);
        if (C1500r.m5738a(b2) == 0) {
            return true;
        }
        return false;
    }

    private HttpRequest m5799a(HttpRequest httpRequest, C1538d c1538d) {
        return httpRequest.m5878a(C0671a.HEADER_API_KEY, c1538d.f3843a).m5878a(C0671a.HEADER_CLIENT_TYPE, C0671a.ANDROID_CLIENT_TYPE).m5878a(C0671a.HEADER_CLIENT_VERSION, this.kit.getVersion());
    }

    private HttpRequest m5800b(HttpRequest httpRequest, C1538d c1538d) {
        HttpRequest e = httpRequest.m5898e("app[identifier]", c1538d.f3844b).m5898e("app[name]", c1538d.f3848f).m5898e("app[display_version]", c1538d.f3845c).m5898e("app[build_version]", c1538d.f3846d).m5877a("app[source]", Integer.valueOf(c1538d.f3849g)).m5898e("app[minimum_sdk_version]", c1538d.f3850h).m5898e("app[built_sdk_version]", c1538d.f3851i);
        if (!C1482i.m5669c(c1538d.f3847e)) {
            e.m5898e("app[instance_identifier]", c1538d.f3847e);
        }
        if (c1538d.f3852j != null) {
            Closeable closeable = null;
            try {
                closeable = this.kit.getContext().getResources().openRawResource(c1538d.f3852j.f3875b);
                e.m5898e("app[icon][hash]", c1538d.f3852j.f3874a).m5882a("app[icon][data]", "icon.png", "application/octet-stream", (InputStream) closeable).m5877a("app[icon][width]", Integer.valueOf(c1538d.f3852j.f3876c)).m5877a("app[icon][height]", Integer.valueOf(c1538d.f3852j.f3877d));
            } catch (Throwable e2) {
                C1457c.m5546h().mo819e("Fabric", "Failed to find app icon with resource ID: " + c1538d.f3852j.f3875b, e2);
            } finally {
                String str = "Failed to close app icon InputStream.";
                C1482i.m5656a(closeable, str);
            }
        }
        if (c1538d.f3853k != null) {
            for (C1465j c1465j : c1538d.f3853k) {
                e.m5898e(m5801a(c1465j), c1465j.m5592b());
                e.m5898e(m5803b(c1465j), c1465j.m5593c());
            }
        }
        return e;
    }

    String m5801a(C1465j c1465j) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{c1465j.m5591a()});
    }

    String m5803b(C1465j c1465j) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{c1465j.m5591a()});
    }
}
