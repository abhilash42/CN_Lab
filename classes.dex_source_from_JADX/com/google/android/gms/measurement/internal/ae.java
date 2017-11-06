package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0744c.C0740b;
import com.google.android.gms.common.api.C0744c.C0741c;
import com.google.android.gms.common.internal.C1002d;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.common.stats.C1036b;
import com.google.android.gms.internal.C1075e;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.internal.C1139q.C1141a;
import java.util.ArrayList;
import java.util.List;

public class ae extends ab {
    private final C1121a f2340a;
    private C1139q f2341b;
    private Boolean f2342c;
    private final C1109j f2343d;
    private final C1122b f2344e;
    private final List<Runnable> f2345f = new ArrayList();
    private final C1109j f2346h;

    class C11123 implements Runnable {
        final /* synthetic */ ae f2322a;

        C11123(ae aeVar) {
            this.f2322a = aeVar;
        }

        public void run() {
            C1139q c = this.f2322a.f2341b;
            if (c == null) {
                this.f2322a.mo743l().m4399b().m4387a("Failed to send measurementEnabled to service");
                return;
            }
            try {
                c.mo754b(this.f2322a.mo737f().m4366a(this.f2322a.mo743l().m4418u()));
                this.f2322a.m4163r();
            } catch (RemoteException e) {
                this.f2322a.mo743l().m4399b().m4388a("Failed to send measurementEnabled to AppMeasurementService", e);
            }
        }
    }

    class C11156 implements Runnable {
        final /* synthetic */ ae f2328a;

        C11156(ae aeVar) {
            this.f2328a = aeVar;
        }

        public void run() {
            C1139q c = this.f2328a.f2341b;
            if (c == null) {
                this.f2328a.mo743l().m4399b().m4387a("Discarding data. Failed to send app launch");
                return;
            }
            try {
                c.mo750a(this.f2328a.mo737f().m4366a(this.f2328a.mo743l().m4418u()));
                this.f2328a.m4163r();
            } catch (RemoteException e) {
                this.f2328a.mo743l().m4399b().m4388a("Failed to send app launch to AppMeasurementService", e);
            }
        }
    }

    class C11167 implements ServiceConnection {
        final /* synthetic */ ae f2329a;

        C11167(ae aeVar) {
            this.f2329a = aeVar;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    protected class C1121a implements ServiceConnection, C0740b, C0741c {
        final /* synthetic */ ae f2337a;
        private volatile boolean f2338b;
        private volatile C1143s f2339c;

        class C11204 implements Runnable {
            final /* synthetic */ C1121a f2336a;

            C11204(C1121a c1121a) {
                this.f2336a = c1121a;
            }

            public void run() {
                this.f2336a.f2337a.m4155a(new ComponentName(this.f2336a.f2337a.mo740i(), AppMeasurementService.class));
            }
        }

        protected C1121a(ae aeVar) {
            this.f2337a = aeVar;
        }

        public void m4147a() {
            this.f2337a.mo736e();
            Context i = this.f2337a.mo740i();
            synchronized (this) {
                if (this.f2338b) {
                    this.f2337a.mo743l().m4417t().m4387a("Connection attempt already in progress");
                } else if (this.f2339c != null) {
                    this.f2337a.mo743l().m4417t().m4387a("Already awaiting connection attempt");
                } else {
                    this.f2339c = new C1143s(i, Looper.getMainLooper(), C1002d.m3474a(i), this, this);
                    this.f2337a.mo743l().m4417t().m4387a("Connecting to remote service");
                    this.f2338b = true;
                    this.f2339c.m3540e();
                }
            }
        }

        public void mo747a(int i) {
            C1032p.m3684b("MeasurementServiceConnection.onConnectionSuspended");
            this.f2337a.mo743l().m4416s().m4387a("Service connection suspended");
            this.f2337a.mo742k().m4478a(new C11204(this));
        }

        public void m4149a(Intent intent) {
            this.f2337a.mo736e();
            Context i = this.f2337a.mo740i();
            C1036b a = C1036b.m3742a();
            synchronized (this) {
                if (this.f2338b) {
                    this.f2337a.mo743l().m4417t().m4387a("Connection attempt already in progress");
                    return;
                }
                this.f2338b = true;
                a.m3753a(i, intent, this.f2337a.f2340a, 129);
            }
        }

        public void mo748a(Bundle bundle) {
            C1032p.m3684b("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                this.f2338b = false;
                try {
                    final C1139q c1139q = (C1139q) this.f2339c.m3547l();
                    this.f2339c = null;
                    this.f2337a.mo742k().m4478a(new Runnable(this) {
                        final /* synthetic */ C1121a f2335b;

                        public void run() {
                            if (!this.f2335b.f2337a.m4171b()) {
                                this.f2335b.f2337a.mo743l().m4416s().m4387a("Connected to remote service");
                                this.f2335b.f2337a.m4158a(c1139q);
                            }
                        }
                    });
                } catch (DeadObjectException e) {
                    this.f2339c = null;
                } catch (IllegalStateException e2) {
                    this.f2339c = null;
                }
            }
        }

        public void mo749a(ConnectionResult connectionResult) {
            C1032p.m3684b("MeasurementServiceConnection.onConnectionFailed");
            this.f2337a.mo743l().m4412o().m4388a("Service connection failed", connectionResult);
            synchronized (this) {
                this.f2338b = false;
                this.f2339c = null;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1032p.m3684b("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                this.f2338b = false;
                if (iBinder == null) {
                    this.f2337a.mo743l().m4399b().m4387a("Service connected with null binder");
                    return;
                }
                C1139q c1139q = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        c1139q = C1141a.m4364a(iBinder);
                        this.f2337a.mo743l().m4417t().m4387a("Bound to IMeasurementService interface");
                    } else {
                        this.f2337a.mo743l().m4399b().m4388a("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.f2337a.mo743l().m4399b().m4387a("Service connect failed to get IMeasurementService");
                }
                if (c1139q == null) {
                    try {
                        C1036b.m3742a().m3751a(this.f2337a.mo740i(), this.f2337a.f2340a);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.f2337a.mo742k().m4478a(new Runnable(this) {
                        final /* synthetic */ C1121a f2331b;

                        public void run() {
                            if (!this.f2331b.f2337a.m4171b()) {
                                this.f2331b.f2337a.mo743l().m4416s().m4387a("Connected to service");
                                this.f2331b.f2337a.m4158a(c1139q);
                            }
                        }
                    });
                }
            }
        }

        public void onServiceDisconnected(final ComponentName componentName) {
            C1032p.m3684b("MeasurementServiceConnection.onServiceDisconnected");
            this.f2337a.mo743l().m4416s().m4387a("Service disconnected");
            this.f2337a.mo742k().m4478a(new Runnable(this) {
                final /* synthetic */ C1121a f2333b;

                public void run() {
                    this.f2333b.f2337a.m4155a(componentName);
                }
            });
        }
    }

    protected ae(C1164y c1164y) {
        super(c1164y);
        this.f2344e = new C1122b(c1164y.m4527o());
        this.f2340a = new C1121a(this);
        this.f2343d = new C1109j(this, c1164y) {
            final /* synthetic */ ae f2320a;

            public void mo746a() {
                this.f2320a.m4167v();
            }
        };
        this.f2346h = new C1109j(this, c1164y) {
            final /* synthetic */ ae f2321a;

            public void mo746a() {
                this.f2321a.mo743l().m4412o().m4387a("Tasks have been queued for a long time");
            }
        };
    }

    private void m4152A() {
        mo736e();
        m4164s();
    }

    private void m4153B() {
        mo736e();
        mo743l().m4417t().m4388a("Processing queued up service tasks", Integer.valueOf(this.f2345f.size()));
        for (Runnable a : this.f2345f) {
            mo742k().m4478a(a);
        }
        this.f2345f.clear();
        this.f2346h.m4144c();
    }

    private void m4155a(ComponentName componentName) {
        mo736e();
        if (this.f2341b != null) {
            this.f2341b = null;
            mo743l().m4417t().m4388a("Disconnected from device MeasurementService", componentName);
            m4152A();
        }
    }

    private void m4158a(C1139q c1139q) {
        mo736e();
        C1032p.m3678a((Object) c1139q);
        this.f2341b = c1139q;
        m4163r();
        m4153B();
    }

    private void m4159a(Runnable runnable) {
        mo736e();
        if (m4171b()) {
            runnable.run();
        } else if (((long) this.f2345f.size()) >= mo745n().m4250G()) {
            mo743l().m4399b().m4387a("Discarding data. Max runnable queue size reached");
        } else {
            this.f2345f.add(runnable);
            if (!this.g.m4534v()) {
                this.f2346h.m4142a(60000);
            }
            m4164s();
        }
    }

    private void m4163r() {
        mo736e();
        this.f2344e.m4187a();
        if (!this.g.m4534v()) {
            this.f2343d.m4142a(mo745n().m4285y());
        }
    }

    private void m4164s() {
        mo736e();
        m4091y();
        if (!m4171b()) {
            if (this.f2342c == null) {
                this.f2342c = mo744m().m4464q();
                if (this.f2342c == null) {
                    mo743l().m4417t().m4387a("State of service unknown");
                    this.f2342c = Boolean.valueOf(m4166u());
                    mo744m().m4459a(this.f2342c.booleanValue());
                }
            }
            if (this.f2342c.booleanValue()) {
                mo743l().m4417t().m4387a("Using measurement service");
                this.f2340a.m4147a();
            } else if (m4165t() && !this.g.m4534v()) {
                mo743l().m4417t().m4387a("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(mo740i(), AppMeasurementService.class));
                this.f2340a.m4149a(intent);
            } else if (mo745n().m4247D()) {
                mo743l().m4417t().m4387a("Using direct local measurement implementation");
                m4158a(new C1171z(this.g, true));
            } else {
                mo743l().m4399b().m4387a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    private boolean m4165t() {
        List queryIntentServices = mo740i().getPackageManager().queryIntentServices(new Intent(mo740i(), AppMeasurementService.class), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    private boolean m4166u() {
        mo736e();
        m4091y();
        if (mo745n().m4246C()) {
            return true;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.measurement.service.MeasurementBrokerService"));
        C1036b a = C1036b.m3742a();
        mo743l().m4417t().m4387a("Checking service availability");
        if (!a.m3753a(mo740i(), intent, new C11167(this), 0)) {
            return false;
        }
        mo743l().m4417t().m4387a("Service available");
        return true;
    }

    private void m4167v() {
        mo736e();
        if (m4171b()) {
            mo743l().m4417t().m4387a("Inactivity, disconnecting from AppMeasurementService");
            m4186q();
        }
    }

    protected void mo733a() {
    }

    protected void m4169a(final EventParcel eventParcel, final String str) {
        C1032p.m3678a((Object) eventParcel);
        mo736e();
        m4091y();
        m4159a(new Runnable(this) {
            final /* synthetic */ ae f2325c;

            public void run() {
                C1139q c = this.f2325c.f2341b;
                if (c == null) {
                    this.f2325c.mo743l().m4399b().m4387a("Discarding data. Failed to send event to service");
                    return;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        c.mo751a(eventParcel, this.f2325c.mo737f().m4366a(this.f2325c.mo743l().m4418u()));
                    } else {
                        c.mo752a(eventParcel, str, this.f2325c.mo743l().m4418u());
                    }
                    this.f2325c.m4163r();
                } catch (RemoteException e) {
                    this.f2325c.mo743l().m4399b().m4388a("Failed to send event to AppMeasurementService", e);
                }
            }
        });
    }

    protected void m4170a(final UserAttributeParcel userAttributeParcel) {
        mo736e();
        m4091y();
        m4159a(new Runnable(this) {
            final /* synthetic */ ae f2327b;

            public void run() {
                C1139q c = this.f2327b.f2341b;
                if (c == null) {
                    this.f2327b.mo743l().m4399b().m4387a("Discarding data. Failed to set user attribute");
                    return;
                }
                try {
                    c.mo753a(userAttributeParcel, this.f2327b.mo737f().m4366a(this.f2327b.mo743l().m4418u()));
                    this.f2327b.m4163r();
                } catch (RemoteException e) {
                    this.f2327b.mo743l().m4399b().m4388a("Failed to send attribute to AppMeasurementService", e);
                }
            }
        });
    }

    public boolean m4171b() {
        mo736e();
        m4091y();
        return this.f2341b != null;
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

    protected void m4184o() {
        mo736e();
        m4091y();
        m4159a(new C11123(this));
    }

    protected void m4185p() {
        mo736e();
        m4091y();
        m4159a(new C11156(this));
    }

    public void m4186q() {
        mo736e();
        m4091y();
        try {
            C1036b.m3742a().m3751a(mo740i(), this.f2340a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.f2341b = null;
    }
}
