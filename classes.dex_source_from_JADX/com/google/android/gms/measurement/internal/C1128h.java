package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.google.android.gms.common.C0747b;
import com.google.android.gms.common.internal.C1000c;
import com.google.android.gms.internal.C1075e;
import com.google.android.gms.internal.C1079i;

public class C1128h extends aa {
    static final String f2355a = String.valueOf(C0747b.f1793a / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean f2356b;

    C1128h(C1164y c1164y) {
        super(c1164y);
    }

    public String m4244A() {
        return "google_app_measurement2.db";
    }

    public long m4245B() {
        return (long) (C0747b.f1793a / 1000);
    }

    public boolean m4246C() {
        return C1000c.f1951a;
    }

    public boolean m4247D() {
        if (this.f2356b == null) {
            synchronized (this) {
                if (this.f2356b == null) {
                    ApplicationInfo applicationInfo = mo740i().getApplicationInfo();
                    String a = C1079i.m3926a(mo740i(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.f2356b = Boolean.valueOf(z);
                    }
                    if (this.f2356b == null) {
                        this.f2356b = Boolean.TRUE;
                        mo743l().m4399b().m4387a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f2356b.booleanValue();
    }

    public long m4248E() {
        return ((Long) C1138p.f2393p.m4353a()).longValue();
    }

    public long m4249F() {
        return ((Long) C1138p.f2389l.m4353a()).longValue();
    }

    public long m4250G() {
        return 20;
    }

    public long m4251H() {
        return Math.max(0, ((Long) C1138p.f2382e.m4353a()).longValue());
    }

    public int m4252I() {
        return ((Integer) C1138p.f2383f.m4353a()).intValue();
    }

    public int m4253J() {
        return Math.max(0, ((Integer) C1138p.f2384g.m4353a()).intValue());
    }

    public String m4254K() {
        return (String) C1138p.f2385h.m4353a();
    }

    public long m4255L() {
        return Math.max(0, ((Long) C1138p.f2386i.m4353a()).longValue());
    }

    public long m4256M() {
        return Math.max(0, ((Long) C1138p.f2388k.m4353a()).longValue());
    }

    public long m4257N() {
        return ((Long) C1138p.f2387j.m4353a()).longValue();
    }

    public long m4258O() {
        return Math.max(0, ((Long) C1138p.f2390m.m4353a()).longValue());
    }

    public long m4259P() {
        return Math.max(0, ((Long) C1138p.f2391n.m4353a()).longValue());
    }

    public int m4260Q() {
        return Math.min(20, Math.max(0, ((Integer) C1138p.f2392o.m4353a()).intValue()));
    }

    String m4261a() {
        return (String) C1138p.f2380c.m4353a();
    }

    int m4262b() {
        return 32;
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

    public int m4275o() {
        return 24;
    }

    int m4276p() {
        return 36;
    }

    int m4277q() {
        return 256;
    }

    int m4278r() {
        return 36;
    }

    int m4279s() {
        return 2048;
    }

    int m4280t() {
        return 20;
    }

    long m4281u() {
        return 3600000;
    }

    long m4282v() {
        return 60000;
    }

    long m4283w() {
        return 61000;
    }

    long m4284x() {
        return ((Long) C1138p.f2381d.m4353a()).longValue();
    }

    long m4285y() {
        return ((Long) C1138p.f2394q.m4353a()).longValue();
    }

    public String m4286z() {
        return "google_app_measurement.db";
    }
}
