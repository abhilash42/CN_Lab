package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.C1032p;

abstract class C1109j {
    private static volatile Handler f2315b;
    private final C1164y f2316a;
    private final Runnable f2317c = new C11311(this);
    private volatile long f2318d;
    private boolean f2319e = true;

    class C11311 implements Runnable {
        final /* synthetic */ C1109j f2361a;

        C11311(C1109j c1109j) {
            this.f2361a = c1109j;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f2361a.f2316a.m4519g().m4478a((Runnable) this);
                return;
            }
            boolean b = this.f2361a.m4143b();
            this.f2361a.f2318d = 0;
            if (b && this.f2361a.f2319e) {
                this.f2361a.mo746a();
            }
        }
    }

    C1109j(C1164y c1164y) {
        C1032p.m3678a((Object) c1164y);
        this.f2316a = c1164y;
    }

    private Handler m4140d() {
        if (f2315b != null) {
            return f2315b;
        }
        Handler handler;
        synchronized (C1109j.class) {
            if (f2315b == null) {
                f2315b = new Handler(this.f2316a.m4526n().getMainLooper());
            }
            handler = f2315b;
        }
        return handler;
    }

    public abstract void mo746a();

    public void m4142a(long j) {
        m4144c();
        if (j >= 0) {
            this.f2318d = this.f2316a.m4527o().mo728a();
            if (!m4140d().postDelayed(this.f2317c, j)) {
                this.f2316a.m4518f().m4399b().m4388a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public boolean m4143b() {
        return this.f2318d != 0;
    }

    public void m4144c() {
        this.f2318d = 0;
        m4140d().removeCallbacks(this.f2317c);
    }
}
