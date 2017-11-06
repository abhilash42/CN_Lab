package com.google.android.gms.internal;

public abstract class C1080p {
    protected volatile int f2147A = -1;

    public void mo730a(zztd com_google_android_gms_internal_zztd) {
    }

    public abstract C1080p mo731b(C1093n c1093n);

    protected int mo732c() {
        return 0;
    }

    public /* synthetic */ Object clone() {
        return m3933f();
    }

    public int m3931d() {
        if (this.f2147A < 0) {
            m3932e();
        }
        return this.f2147A;
    }

    public int m3932e() {
        int c = mo732c();
        this.f2147A = c;
        return c;
    }

    public C1080p m3933f() {
        return (C1080p) super.clone();
    }

    public String toString() {
        return C1095q.m3991a(this);
    }
}
