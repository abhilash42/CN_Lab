package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1075e;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;

public class C1123c extends ab {
    private boolean f2349a;
    private final AlarmManager f2350b = ((AlarmManager) mo740i().getSystemService("alarm"));

    protected C1123c(C1164y c1164y) {
        super(c1164y);
    }

    private PendingIntent m4190o() {
        Intent intent = new Intent(mo740i(), AppMeasurementReceiver.class);
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(mo740i(), 0, intent, 0);
    }

    protected void mo733a() {
        this.f2350b.cancel(m4190o());
    }

    public void m4192a(long j) {
        m4091y();
        C1032p.m3685b(j > 0);
        C1032p.m3683a(AppMeasurementReceiver.m4051a(mo740i()), (Object) "Receiver not registered/enabled");
        C1032p.m3683a(AppMeasurementService.m4054a(mo740i()), (Object) "Service not registered/enabled");
        m4193b();
        long b = mo739h().mo729b() + j;
        this.f2349a = true;
        this.f2350b.setInexactRepeating(2, b, Math.max(mo745n().m4257N(), j), m4190o());
    }

    public void m4193b() {
        m4091y();
        this.f2349a = false;
        this.f2350b.cancel(m4190o());
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
}
