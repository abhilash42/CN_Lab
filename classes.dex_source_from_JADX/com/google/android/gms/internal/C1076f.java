package com.google.android.gms.internal;

import android.os.SystemClock;

public final class C1076f implements C1075e {
    private static C1076f f2146a;

    public static synchronized C1075e m3910c() {
        C1075e c1075e;
        synchronized (C1076f.class) {
            if (f2146a == null) {
                f2146a = new C1076f();
            }
            c1075e = f2146a;
        }
        return c1075e;
    }

    public long mo728a() {
        return System.currentTimeMillis();
    }

    public long mo729b() {
        return SystemClock.elapsedRealtime();
    }
}
