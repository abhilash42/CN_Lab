package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1075e;

class C1122b {
    private final C1075e f2347a;
    private long f2348b;

    public C1122b(C1075e c1075e) {
        C1032p.m3678a((Object) c1075e);
        this.f2347a = c1075e;
    }

    public void m4187a() {
        this.f2348b = this.f2347a.mo729b();
    }

    public boolean m4188a(long j) {
        return this.f2348b == 0 || this.f2347a.mo729b() - this.f2348b >= j;
    }

    public void m4189b() {
        this.f2348b = 0;
    }
}
