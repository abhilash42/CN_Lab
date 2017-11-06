package io.fabric.sdk.android.services.p022e;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1486k;
import io.fabric.sdk.android.services.p037d.C1533c;
import io.fabric.sdk.android.services.p037d.C1534d;
import org.json.JSONObject;

/* compiled from: DefaultSettingsController */
class C1545j implements C1544s {
    private final C1560w f3863a;
    private final C1546v f3864b;
    private final C1486k f3865c;
    private final C1541g f3866d;
    private final C1548x f3867e;
    private final C0653h f3868f;
    private final C1533c f3869g = new C1534d(this.f3868f);

    public C1545j(C0653h c0653h, C1560w c1560w, C1486k c1486k, C1546v c1546v, C1541g c1541g, C1548x c1548x) {
        this.f3868f = c0653h;
        this.f3863a = c1560w;
        this.f3865c = c1486k;
        this.f3864b = c1546v;
        this.f3866d = c1541g;
        this.f3867e = c1548x;
    }

    public C1558t mo849a() {
        return mo850a(C1557r.USE_CACHE);
    }

    public C1558t mo850a(C1557r c1557r) {
        Throwable th;
        C1558t c1558t;
        Throwable th2;
        C1558t c1558t2 = null;
        try {
            if (!(C1457c.m5547i() || m5818d())) {
                c1558t2 = m5812b(c1557r);
            }
            if (c1558t2 == null) {
                try {
                    JSONObject a = this.f3867e.mo852a(this.f3863a);
                    if (a != null) {
                        c1558t2 = this.f3864b.mo851a(this.f3865c, a);
                        this.f3866d.mo848a(c1558t2.f3906g, a);
                        m5811a(a, "Loaded settings: ");
                        m5815a(m5816b());
                    }
                } catch (Throwable e) {
                    th = e;
                    c1558t = c1558t2;
                    th2 = th;
                    C1457c.m5546h().mo819e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c1558t;
                }
            }
            c1558t = c1558t2;
            if (c1558t == null) {
                try {
                    c1558t = m5812b(C1557r.IGNORE_CACHE_EXPIRATION);
                } catch (Exception e2) {
                    th2 = e2;
                    C1457c.m5546h().mo819e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c1558t;
                }
            }
        } catch (Throwable e3) {
            th = e3;
            c1558t = null;
            th2 = th;
            C1457c.m5546h().mo819e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
            return c1558t;
        }
        return c1558t;
    }

    private C1558t m5812b(C1557r c1557r) {
        Throwable th;
        C1558t c1558t = null;
        try {
            if (C1557r.SKIP_CACHE_LOOKUP.equals(c1557r)) {
                return null;
            }
            JSONObject a = this.f3866d.mo847a();
            if (a != null) {
                C1558t a2 = this.f3864b.mo851a(this.f3865c, a);
                if (a2 != null) {
                    m5811a(a, "Loaded cached settings: ");
                    long a3 = this.f3865c.mo830a();
                    if (C1557r.IGNORE_CACHE_EXPIRATION.equals(c1557r) || !a2.m5846a(a3)) {
                        try {
                            C1457c.m5546h().mo811a("Fabric", "Returning cached settings.");
                            return a2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            c1558t = a2;
                            th = th2;
                            C1457c.m5546h().mo819e("Fabric", "Failed to get cached settings", th);
                            return c1558t;
                        }
                    }
                    C1457c.m5546h().mo811a("Fabric", "Cached settings have expired.");
                    return null;
                }
                C1457c.m5546h().mo819e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            C1457c.m5546h().mo811a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e2) {
            th = e2;
            C1457c.m5546h().mo819e("Fabric", "Failed to get cached settings", th);
            return c1558t;
        }
    }

    private void m5811a(JSONObject jSONObject, String str) {
        C1457c.m5546h().mo811a("Fabric", str + jSONObject.toString());
    }

    String m5816b() {
        return C1482i.m5651a(C1482i.m5679m(this.f3868f.getContext()));
    }

    String m5817c() {
        return this.f3869g.mo843a().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean m5815a(String str) {
        Editor b = this.f3869g.mo845b();
        b.putString("existing_instance_identifier", str);
        return this.f3869g.mo844a(b);
    }

    boolean m5818d() {
        return !m5817c().equals(m5816b());
    }
}
