package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.internal.C1075e;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class C1132k extends ab {
    private long f2362a;
    private String f2363b;

    C1132k(C1164y c1164y) {
        super(c1164y);
    }

    protected void mo733a() {
        Calendar instance = Calendar.getInstance();
        this.f2362a = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        this.f2363b = locale.getLanguage().toLowerCase(Locale.ENGLISH) + "-" + locale.getCountry().toLowerCase(Locale.ENGLISH);
    }

    public String m4320b() {
        m4091y();
        return Build.MODEL;
    }

    public /* bridge */ /* synthetic */ void mo734c() {
        super.mo734c();
    }

    public /* bridge */ /* synthetic */ void mo735d() {
        super.mo735d();
    }

    public /* bridge */ /* synthetic */ void mo736e() {
        super.mo736e();
    }

    public /* bridge */ /* synthetic */ C1142r mo737f() {
        return super.mo737f();
    }

    public /* bridge */ /* synthetic */ ae mo738g() {
        return super.mo738g();
    }

    public /* bridge */ /* synthetic */ C1075e mo739h() {
        return super.mo739h();
    }

    public /* bridge */ /* synthetic */ Context mo740i() {
        return super.mo740i();
    }

    public /* bridge */ /* synthetic */ C1126f mo741j() {
        return super.mo741j();
    }

    public /* bridge */ /* synthetic */ C1161x mo742k() {
        return super.mo742k();
    }

    public /* bridge */ /* synthetic */ C1146t mo743l() {
        return super.mo743l();
    }

    public /* bridge */ /* synthetic */ C1157w mo744m() {
        return super.mo744m();
    }

    public /* bridge */ /* synthetic */ C1128h mo745n() {
        return super.mo745n();
    }

    public String m4333o() {
        m4091y();
        return VERSION.RELEASE;
    }

    public long m4334p() {
        m4091y();
        return this.f2362a;
    }

    public String m4335q() {
        m4091y();
        return this.f2363b;
    }
}
