package io.fabric.sdk.android.services.p020b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p037d.C1533c;
import io.fabric.sdk.android.services.p037d.C1534d;

/* compiled from: AdvertisingInfoProvider */
class C1472c {
    private final Context f3693a;
    private final C1533c f3694b;

    public C1472c(Context context) {
        this.f3693a = context.getApplicationContext();
        this.f3694b = new C1534d(context, "TwitterAdvertisingInfoPreferences");
    }

    public C1470b m5616a() {
        C1470b b = m5617b();
        if (m5614c(b)) {
            C1457c.m5546h().mo811a("Fabric", "Using AdvertisingInfo from Preference Store");
            m5611a(b);
            return b;
        }
        b = m5615e();
        m5613b(b);
        return b;
    }

    private void m5611a(final C1470b c1470b) {
        new Thread(new C0719h(this) {
            final /* synthetic */ C1472c f3692b;

            public void onRun() {
                C1470b a = this.f3692b.m5615e();
                if (!c1470b.equals(a)) {
                    C1457c.m5546h().mo811a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    this.f3692b.m5613b(a);
                }
            }
        }).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m5613b(C1470b c1470b) {
        if (m5614c(c1470b)) {
            this.f3694b.mo844a(this.f3694b.mo845b().putString("advertising_id", c1470b.f3689a).putBoolean("limit_ad_tracking_enabled", c1470b.f3690b));
        } else {
            this.f3694b.mo844a(this.f3694b.mo845b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected C1470b m5617b() {
        return new C1470b(this.f3694b.mo843a().getString("advertising_id", ""), this.f3694b.mo843a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public C1473f m5618c() {
        return new C1474d(this.f3693a);
    }

    public C1473f m5619d() {
        return new C1478e(this.f3693a);
    }

    private boolean m5614c(C1470b c1470b) {
        return (c1470b == null || TextUtils.isEmpty(c1470b.f3689a)) ? false : true;
    }

    private C1470b m5615e() {
        C1470b a = m5618c().mo829a();
        if (m5614c(a)) {
            C1457c.m5546h().mo811a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            a = m5619d().mo829a();
            if (m5614c(a)) {
                C1457c.m5546h().mo811a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                C1457c.m5546h().mo811a("Fabric", "AdvertisingInfo not present");
            }
        }
        return a;
    }
}
