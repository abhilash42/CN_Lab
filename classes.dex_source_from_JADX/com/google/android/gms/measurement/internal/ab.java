package com.google.android.gms.measurement.internal;

abstract class ab extends aa {
    private boolean f2289a;
    private boolean f2290b;
    private boolean f2291c;

    ab(C1164y c1164y) {
        super(c1164y);
        this.g.m4510a(this);
    }

    protected abstract void mo733a();

    boolean m4089w() {
        return this.f2289a && !this.f2290b;
    }

    boolean m4090x() {
        return this.f2291c;
    }

    protected void m4091y() {
        if (!m4089w()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m4092z() {
        if (this.f2289a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo733a();
        this.g.m4537y();
        this.f2289a = true;
    }
}
