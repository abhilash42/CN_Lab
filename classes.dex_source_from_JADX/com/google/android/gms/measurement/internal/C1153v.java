package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.C1032p;

class C1153v extends BroadcastReceiver {
    static final String f2431a = C1153v.class.getName();
    private final C1164y f2432b;
    private boolean f2433c;
    private boolean f2434d;

    C1153v(C1164y c1164y) {
        C1032p.m3678a((Object) c1164y);
        this.f2432b = c1164y;
    }

    private Context m4439d() {
        return this.f2432b.m4526n();
    }

    private C1146t m4440e() {
        return this.f2432b.m4518f();
    }

    public void m4441a() {
        this.f2432b.m4505a();
        this.f2432b.m4533u();
        if (!this.f2433c) {
            m4439d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f2434d = this.f2432b.m4525m().m4425b();
            m4440e().m4417t().m4388a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f2434d));
            this.f2433c = true;
        }
    }

    public void m4442b() {
        this.f2432b.m4505a();
        this.f2432b.m4533u();
        if (m4443c()) {
            m4440e().m4417t().m4387a("Unregistering connectivity change receiver");
            this.f2433c = false;
            this.f2434d = false;
            try {
                m4439d().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m4440e().m4399b().m4388a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public boolean m4443c() {
        this.f2432b.m4533u();
        return this.f2433c;
    }

    public void onReceive(Context context, Intent intent) {
        this.f2432b.m4505a();
        String action = intent.getAction();
        m4440e().m4417t().m4388a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean b = this.f2432b.m4525m().m4425b();
            if (this.f2434d != b) {
                this.f2434d = b;
                this.f2432b.m4519g().m4478a(new Runnable(this) {
                    final /* synthetic */ C1153v f2430b;

                    public void run() {
                        this.f2430b.f2432b.m4511a(b);
                    }
                });
                return;
            }
            return;
        }
        m4440e().m4412o().m4388a("NetworkBroadcastReceiver received unknown action", action);
    }
}
