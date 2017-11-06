package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1075e;
import com.google.android.gms.internal.C1086j.C1081a;
import com.google.android.gms.internal.C1086j.C1082b;
import com.google.android.gms.internal.C1086j.C1083c;
import com.google.android.gms.internal.C1086j.C1084d;
import com.google.android.gms.internal.C1086j.C1085e;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import com.google.android.gms.measurement.C1100a;
import com.google.android.gms.measurement.internal.C1151u.C1148a;
import io.fabric.sdk.android.services.p020b.C0671a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C1164y {
    private static ac f2474a;
    private static volatile C1164y f2475b;
    private final Context f2476c;
    private final C1128h f2477d;
    private final C1157w f2478e;
    private final C1146t f2479f;
    private final C1161x f2480g;
    private final C1100a f2481h;
    private final C1126f f2482i;
    private final C1130i f2483j;
    private final C1151u f2484k;
    private final C1075e f2485l;
    private final ae f2486m;
    private final C1132k f2487n;
    private final ad f2488o;
    private final C1142r f2489p;
    private final C1153v f2490q;
    private final C1123c f2491r;
    private final boolean f2492s;
    private Boolean f2493t;
    private List<Long> f2494u;
    private int f2495v;
    private int f2496w;

    class C11621 implements Runnable {
        final /* synthetic */ C1164y f2472a;

        C11621(C1164y c1164y) {
            this.f2472a = c1164y;
        }

        public void run() {
            this.f2472a.m4515c();
        }
    }

    class C11632 implements C1148a {
        final /* synthetic */ C1164y f2473a;

        C11632(C1164y c1164y) {
            this.f2473a = c1164y;
        }

        public void mo758a(int i, Throwable th, byte[] bArr) {
            this.f2473a.m4497a(i, th, bArr);
        }
    }

    C1164y(ac acVar) {
        C1032p.m3678a((Object) acVar);
        this.f2476c = acVar.f2292a;
        this.f2485l = acVar.m4103j(this);
        this.f2477d = acVar.m4093a(this);
        C1157w b = acVar.m4095b(this);
        b.m4092z();
        this.f2478e = b;
        C1146t c = acVar.m4096c(this);
        c.m4092z();
        this.f2479f = c;
        this.f2482i = acVar.m4100g(this);
        C1132k l = acVar.m4105l(this);
        l.m4092z();
        this.f2487n = l;
        C1142r m = acVar.m4106m(this);
        m.m4092z();
        this.f2489p = m;
        C1130i h = acVar.m4101h(this);
        h.m4092z();
        this.f2483j = h;
        C1151u i = acVar.m4102i(this);
        i.m4092z();
        this.f2484k = i;
        ae k = acVar.m4104k(this);
        k.m4092z();
        this.f2486m = k;
        ad f = acVar.m4099f(this);
        f.m4092z();
        this.f2488o = f;
        C1123c o = acVar.m4108o(this);
        o.m4092z();
        this.f2491r = o;
        this.f2490q = acVar.m4107n(this);
        this.f2481h = acVar.m4098e(this);
        C1161x d = acVar.m4097d(this);
        d.m4092z();
        this.f2480g = d;
        if (this.f2495v != this.f2496w) {
            m4518f().m4399b().m4389a("Not all components initialized", Integer.valueOf(this.f2495v), Integer.valueOf(this.f2496w));
        }
        this.f2492s = true;
        if (!(this.f2477d.m4246C() || m4534v())) {
            if (!(this.f2476c.getApplicationContext() instanceof Application)) {
                m4518f().m4412o().m4387a("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                m4521i().m4123b();
            } else {
                m4518f().m4416s().m4387a("Not tracking deep linking pre-ICS");
            }
        }
        this.f2480g.m4478a(new C11621(this));
    }

    private boolean m4493A() {
        return !TextUtils.isEmpty(m4524l().m4315r());
    }

    private void m4494B() {
        m4533u();
        m4505a();
        if (m4514b() && m4493A()) {
            long C = m4495C();
            if (C == 0) {
                m4531s().m4442b();
                m4532t().m4193b();
                return;
            } else if (m4525m().m4425b()) {
                long a = m4517e().f2449e.m4445a();
                long L = m4516d().m4255L();
                if (!m4523k().m4220a(a, L)) {
                    C = Math.max(C, a + L);
                }
                m4531s().m4442b();
                C -= m4527o().mo728a();
                if (C <= 0) {
                    m4532t().m4192a(1);
                    return;
                }
                m4518f().m4417t().m4388a("Upload scheduled in approximately ms", Long.valueOf(C));
                m4532t().m4192a(C);
                return;
            } else {
                m4531s().m4441a();
                m4532t().m4193b();
                return;
            }
        }
        m4531s().m4442b();
        m4532t().m4193b();
    }

    private long m4495C() {
        long a = m4527o().mo728a();
        long O = m4516d().m4258O();
        long M = m4516d().m4256M();
        long a2 = m4517e().f2447c.m4445a();
        long a3 = m4517e().f2448d.m4445a();
        long u = m4524l().m4318u();
        if (u == 0) {
            return 0;
        }
        a -= Math.abs(u - a);
        O += a;
        if (!m4523k().m4220a(a2, M)) {
            O = a2 + M;
        }
        if (a3 == 0 || a3 < a) {
            return O;
        }
        for (int i = 0; i < m4516d().m4260Q(); i++) {
            O += ((long) (1 << i)) * m4516d().m4259P();
            if (O > a3) {
                return O;
            }
        }
        return 0;
    }

    public static C1164y m4496a(Context context) {
        C1032p.m3678a((Object) context);
        C1032p.m3678a(context.getApplicationContext());
        if (f2475b == null) {
            synchronized (C1164y.class) {
                if (f2475b == null) {
                    f2475b = (f2474a != null ? f2474a : new ac(context)).m4094a();
                }
            }
        }
        return f2475b;
    }

    private void m4497a(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        m4533u();
        m4505a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.f2494u;
        this.f2494u = null;
        if ((i == 200 || i == 204) && th == null) {
            m4517e().f2447c.m4446a(m4527o().mo728a());
            m4517e().f2448d.m4446a(0);
            m4494B();
            m4518f().m4417t().m4389a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            m4524l().m4310b();
            try {
                for (Long longValue : list) {
                    m4524l().m4302a(longValue.longValue());
                }
                m4524l().m4312o();
                if (m4525m().m4425b() && m4493A()) {
                    m4536x();
                } else {
                    m4494B();
                }
            } finally {
                m4524l().m4313p();
            }
        } else {
            m4518f().m4417t().m4389a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            m4517e().f2448d.m4446a(m4527o().mo728a());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                m4517e().f2449e.m4446a(m4527o().mo728a());
            }
            m4494B();
        }
    }

    private void m4498a(aa aaVar) {
        if (aaVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void m4500a(List<Long> list) {
        C1032p.m3685b(!list.isEmpty());
        if (this.f2494u != null) {
            m4518f().m4399b().m4387a("Set uploading progress before finishing the previous upload");
        } else {
            this.f2494u = new ArrayList(list);
        }
    }

    private void m4501b(ab abVar) {
        if (abVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!abVar.m4089w()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void m4502c(AppMetadata appMetadata) {
        m4533u();
        m4505a();
        C1032p.m3678a((Object) appMetadata);
        C1032p.m3680a(appMetadata.f2253b);
        C1103a b = m4524l().m4308b(appMetadata.f2253b);
        String o = m4517e().m4462o();
        Object obj = null;
        if (b == null) {
            b = new C1103a(appMetadata.f2253b, m4517e().m4463p(), appMetadata.f2254c, o, 0, 0, appMetadata.f2255d, appMetadata.f2256e, appMetadata.f2257f, appMetadata.f2258g, appMetadata.f2260i);
            obj = 1;
        } else if (!o.equals(b.f2280d)) {
            b = b.m4073a(m4517e().m4463p(), o);
            obj = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f2254c) || (appMetadata.f2254c.equals(b.f2279c) && appMetadata.f2257f == b.f2285i))) {
            b = b.m4072a(appMetadata.f2254c, appMetadata.f2257f);
            obj = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f2255d) || (appMetadata.f2255d.equals(b.f2283g) && appMetadata.f2256e.equals(b.f2284h)))) {
            b = b.m4075b(appMetadata.f2255d, appMetadata.f2256e);
            obj = 1;
        }
        if (appMetadata.f2258g != b.f2286j) {
            b = b.m4070a(appMetadata.f2258g);
            obj = 1;
        }
        if (appMetadata.f2260i != b.f2287k) {
            b = b.m4074a(appMetadata.f2260i);
            obj = 1;
        }
        if (obj != null) {
            m4524l().m4305a(b);
        }
    }

    private boolean m4503z() {
        m4533u();
        return this.f2494u != null;
    }

    C1084d m4504a(C1133l[] c1133lArr, AppMetadata appMetadata) {
        int i;
        C1032p.m3678a((Object) appMetadata);
        C1032p.m3678a((Object) c1133lArr);
        m4533u();
        C1084d c1084d = new C1084d();
        c1084d.f2161a = Integer.valueOf(1);
        c1084d.f2169i = C0671a.ANDROID_CLIENT_TYPE;
        c1084d.f2175o = appMetadata.f2253b;
        c1084d.f2174n = appMetadata.f2256e;
        c1084d.f2176p = appMetadata.f2255d;
        c1084d.f2177q = Long.valueOf(appMetadata.f2257f);
        c1084d.f2185y = appMetadata.f2254c;
        c1084d.f2182v = appMetadata.f2258g == 0 ? null : Long.valueOf(appMetadata.f2258g);
        Pair b = m4517e().m4460b();
        if (!(b == null || b.first == null || b.second == null)) {
            c1084d.f2179s = (String) b.first;
            c1084d.f2180t = (Boolean) b.second;
        }
        c1084d.f2171k = m4529q().m4320b();
        c1084d.f2170j = m4529q().m4333o();
        c1084d.f2173m = Integer.valueOf((int) m4529q().m4334p());
        c1084d.f2172l = m4529q().m4335q();
        c1084d.f2178r = null;
        c1084d.f2164d = null;
        c1084d.f2165e = Long.valueOf(c1133lArr[0].f2367d);
        c1084d.f2166f = Long.valueOf(c1133lArr[0].f2367d);
        for (int i2 = 1; i2 < c1133lArr.length; i2++) {
            c1084d.f2165e = Long.valueOf(Math.min(c1084d.f2165e.longValue(), c1133lArr[i2].f2367d));
            c1084d.f2166f = Long.valueOf(Math.max(c1084d.f2166f.longValue(), c1133lArr[i2].f2367d));
        }
        C1103a b2 = m4524l().m4308b(appMetadata.f2253b);
        if (b2 == null) {
            b2 = new C1103a(appMetadata.f2253b, m4517e().m4463p(), appMetadata.f2254c, m4517e().m4462o(), 0, 0, appMetadata.f2255d, appMetadata.f2256e, appMetadata.f2257f, appMetadata.f2258g, appMetadata.f2260i);
        }
        C1103a a = b2.m4071a(m4518f(), c1084d.f2166f.longValue());
        m4524l().m4305a(a);
        c1084d.f2181u = a.f2278b;
        c1084d.f2183w = Integer.valueOf((int) a.f2281e);
        c1084d.f2168h = b2.f2282f == 0 ? null : Long.valueOf(b2.f2282f);
        c1084d.f2167g = c1084d.f2168h;
        List a2 = m4524l().m4299a(appMetadata.f2253b);
        c1084d.f2163c = new C1085e[a2.size()];
        for (i = 0; i < a2.size(); i++) {
            C1085e c1085e = new C1085e();
            c1084d.f2163c[i] = c1085e;
            c1085e.f2189b = ((C1124d) a2.get(i)).f2352b;
            c1085e.f2188a = Long.valueOf(((C1124d) a2.get(i)).f2353c);
            m4523k().m4217a(c1085e, ((C1124d) a2.get(i)).f2354d);
        }
        c1084d.f2162b = new C1081a[c1133lArr.length];
        for (i = 0; i < c1133lArr.length; i++) {
            C1081a c1081a = new C1081a();
            c1084d.f2162b[i] = c1081a;
            c1081a.f2150b = c1133lArr[i].f2365b;
            c1081a.f2151c = Long.valueOf(c1133lArr[i].f2367d);
            c1081a.f2149a = new C1082b[c1133lArr[i].f2369f.m4066a()];
            Iterator it = c1133lArr[i].f2369f.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                C1082b c1082b = new C1082b();
                int i4 = i3 + 1;
                c1081a.f2149a[i3] = c1082b;
                c1082b.f2155a = str;
                m4523k().m4216a(c1082b, c1133lArr[i].f2369f.m4067a(str));
                i3 = i4;
            }
        }
        c1084d.f2184x = m4518f().m4418u();
        return c1084d;
    }

    void m4505a() {
        if (!this.f2492s) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    void m4506a(AppMetadata appMetadata) {
        m4533u();
        m4505a();
        C1032p.m3680a(appMetadata.f2253b);
        m4502c(appMetadata);
    }

    void m4507a(EventParcel eventParcel, AppMetadata appMetadata) {
        m4533u();
        m4505a();
        C1032p.m3680a(appMetadata.f2253b);
        if (!TextUtils.isEmpty(appMetadata.f2254c)) {
            m4518f().m4417t().m4388a("Logging event", eventParcel);
            Object c1133l = new C1133l(this, eventParcel.f2268d, appMetadata.f2253b, eventParcel.f2266b, eventParcel.f2269e, 0, eventParcel.f2267c.m4068b());
            m4524l().m4310b();
            try {
                C1134m c1134m;
                m4502c(appMetadata);
                C1134m a = m4524l().m4298a(appMetadata.f2253b, c1133l.f2365b);
                if (a == null) {
                    c1134m = new C1134m(appMetadata.f2253b, c1133l.f2365b, 1, 1, c1133l.f2367d);
                } else {
                    c1133l = c1133l.m4337a(this, a.f2374e);
                    c1134m = a.m4338a(c1133l.f2367d);
                }
                m4524l().m4307a(c1134m);
                m4524l().m4304a(m4504a(new C1133l[]{c1133l}, appMetadata));
                m4524l().m4312o();
                m4518f().m4416s().m4388a("Event logged", c1133l);
                m4494B();
            } finally {
                m4524l().m4313p();
            }
        }
    }

    void m4508a(EventParcel eventParcel, String str) {
        C1103a b = m4524l().m4308b(str);
        if (b == null || TextUtils.isEmpty(b.f2283g)) {
            m4518f().m4416s().m4388a("No app data available; dropping event", str);
            return;
        }
        m4507a(eventParcel, new AppMetadata(str, b.f2279c, b.f2283g, b.f2284h, b.f2285i, b.f2286j, null, b.f2287k));
    }

    void m4509a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        m4533u();
        m4505a();
        if (!TextUtils.isEmpty(appMetadata.f2254c)) {
            m4523k().m4223b(userAttributeParcel.f2271b);
            Object c = m4523k().m4226c(userAttributeParcel.f2271b, userAttributeParcel.m4069a());
            if (c != null) {
                C1124d c1124d = new C1124d(appMetadata.f2253b, userAttributeParcel.f2271b, userAttributeParcel.f2272c, c);
                m4518f().m4416s().m4389a("Setting user attribute", c1124d.f2352b, c);
                m4524l().m4310b();
                try {
                    m4502c(appMetadata);
                    m4524l().m4306a(c1124d);
                    m4524l().m4312o();
                    m4518f().m4416s().m4389a("User attribute set", c1124d.f2352b, c1124d.f2354d);
                } finally {
                    m4524l().m4313p();
                }
            }
        }
    }

    void m4510a(ab abVar) {
        this.f2495v++;
    }

    public void m4511a(boolean z) {
        m4494B();
    }

    public void m4512b(AppMetadata appMetadata) {
        m4533u();
        m4505a();
        C1032p.m3678a((Object) appMetadata);
        C1032p.m3680a(appMetadata.f2253b);
        if (!TextUtils.isEmpty(appMetadata.f2254c)) {
            m4502c(appMetadata);
            if (m4524l().m4298a(appMetadata.f2253b, "_f") == null) {
                long a = m4527o().mo728a();
                m4509a(new UserAttributeParcel("_fot", a, Long.valueOf(3600000 * ((a / 3600000) + 1)), "auto"), appMetadata);
                Bundle bundle = new Bundle();
                bundle.putLong("_c", 1);
                m4507a(new EventParcel("_f", new EventParams(bundle), "auto", a), appMetadata);
            }
        }
    }

    void m4513b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        m4533u();
        m4505a();
        if (!TextUtils.isEmpty(appMetadata.f2254c)) {
            m4518f().m4416s().m4388a("Removing user attribute", userAttributeParcel.f2271b);
            m4524l().m4310b();
            try {
                m4502c(appMetadata);
                m4524l().m4311b(appMetadata.f2253b, userAttributeParcel.f2271b);
                m4524l().m4312o();
                m4518f().m4416s().m4388a("User attribute removed", userAttributeParcel.f2271b);
            } finally {
                m4524l().m4313p();
            }
        }
    }

    protected boolean m4514b() {
        boolean z = true;
        m4505a();
        m4533u();
        if (this.f2493t == null) {
            boolean z2 = m4523k().m4230d("android.permission.INTERNET") && m4523k().m4230d("android.permission.ACCESS_NETWORK_STATE") && AppMeasurementReceiver.m4051a(m4526n()) && AppMeasurementService.m4054a(m4526n());
            this.f2493t = Boolean.valueOf(z2);
            if (this.f2493t.booleanValue() && !m4516d().m4246C()) {
                if (TextUtils.isEmpty(m4530r().m4368b())) {
                    z = false;
                }
                this.f2493t = Boolean.valueOf(z);
            }
        }
        return this.f2493t.booleanValue();
    }

    protected void m4515c() {
        m4533u();
        m4518f().m4415r().m4387a("App measurement is starting up");
        m4518f().m4416s().m4387a("Debug logging enabled");
        if (!m4534v() || (this.f2480g.m4089w() && !this.f2480g.m4090x())) {
            m4524l().m4316s();
            if (!m4514b()) {
                if (!m4523k().m4230d("android.permission.INTERNET")) {
                    m4518f().m4399b().m4387a("App is missing INTERNET permission");
                }
                if (!m4523k().m4230d("android.permission.ACCESS_NETWORK_STATE")) {
                    m4518f().m4399b().m4387a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!AppMeasurementReceiver.m4051a(m4526n())) {
                    m4518f().m4399b().m4387a("AppMeasurementReceiver not registered/enabled");
                }
                if (!AppMeasurementService.m4054a(m4526n())) {
                    m4518f().m4399b().m4387a("AppMeasurementService not registered/enabled");
                }
                m4518f().m4399b().m4387a("Uploading is not possible. App measurement disabled");
            } else if (!(m4516d().m4246C() || m4534v() || TextUtils.isEmpty(m4530r().m4368b()))) {
                m4521i().m4136o();
            }
            m4494B();
            return;
        }
        m4518f().m4399b().m4387a("Scheduler shutting down before Scion.start() called");
    }

    public C1128h m4516d() {
        return this.f2477d;
    }

    public C1157w m4517e() {
        m4498a(this.f2478e);
        return this.f2478e;
    }

    public C1146t m4518f() {
        m4501b(this.f2479f);
        return this.f2479f;
    }

    public C1161x m4519g() {
        m4501b(this.f2480g);
        return this.f2480g;
    }

    C1161x m4520h() {
        return this.f2480g;
    }

    public ad m4521i() {
        m4501b(this.f2488o);
        return this.f2488o;
    }

    public C1100a m4522j() {
        return this.f2481h;
    }

    public C1126f m4523k() {
        m4498a(this.f2482i);
        return this.f2482i;
    }

    public C1130i m4524l() {
        m4501b(this.f2483j);
        return this.f2483j;
    }

    public C1151u m4525m() {
        m4501b(this.f2484k);
        return this.f2484k;
    }

    public Context m4526n() {
        return this.f2476c;
    }

    public C1075e m4527o() {
        return this.f2485l;
    }

    public ae m4528p() {
        m4501b(this.f2486m);
        return this.f2486m;
    }

    public C1132k m4529q() {
        m4501b(this.f2487n);
        return this.f2487n;
    }

    public C1142r m4530r() {
        m4501b(this.f2489p);
        return this.f2489p;
    }

    public C1153v m4531s() {
        if (this.f2490q != null) {
            return this.f2490q;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public C1123c m4532t() {
        m4501b(this.f2491r);
        return this.f2491r;
    }

    public void m4533u() {
        m4519g().mo736e();
    }

    protected boolean m4534v() {
        return false;
    }

    void m4535w() {
        if (m4516d().m4246C()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public void m4536x() {
        int i = 0;
        m4533u();
        m4505a();
        if (!m4516d().m4246C()) {
            Boolean q = m4517e().m4464q();
            if (q == null) {
                m4518f().m4412o().m4387a("Upload data called on the client side before use of service was decided");
                return;
            } else if (q.booleanValue()) {
                m4518f().m4399b().m4387a("Upload called in the client side when service should be used");
                return;
            }
        }
        if (m4503z()) {
            m4518f().m4412o().m4387a("Uploading requested multiple times");
        } else if (m4525m().m4425b()) {
            long a = m4517e().f2447c.m4445a();
            if (a != 0) {
                m4518f().m4416s().m4388a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(m4527o().mo728a() - a)));
            }
            String r = m4524l().m4315r();
            if (!TextUtils.isEmpty(r)) {
                List<Pair> a2 = m4524l().m4300a(r, m4516d().m4252I(), m4516d().m4253J());
                if (!a2.isEmpty()) {
                    C1084d c1084d;
                    Object obj;
                    List subList;
                    for (Pair pair : a2) {
                        c1084d = (C1084d) pair.first;
                        if (!TextUtils.isEmpty(c1084d.f2179s)) {
                            obj = c1084d.f2179s;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        for (int i2 = 0; i2 < a2.size(); i2++) {
                            c1084d = (C1084d) ((Pair) a2.get(i2)).first;
                            if (!TextUtils.isEmpty(c1084d.f2179s) && !c1084d.f2179s.equals(obj)) {
                                subList = a2.subList(0, i2);
                                break;
                            }
                        }
                    }
                    subList = a2;
                    C1083c c1083c = new C1083c();
                    c1083c.f2159a = new C1084d[subList.size()];
                    List arrayList = new ArrayList(subList.size());
                    long a3 = m4527o().mo728a();
                    while (i < c1083c.f2159a.length) {
                        c1083c.f2159a[i] = (C1084d) ((Pair) subList.get(i)).first;
                        arrayList.add(((Pair) subList.get(i)).second);
                        c1083c.f2159a[i].f2178r = Long.valueOf(m4516d().m4245B());
                        c1083c.f2159a[i].f2164d = Long.valueOf(a3);
                        c1083c.f2159a[i].f2186z = Boolean.valueOf(m4516d().m4246C());
                        i++;
                    }
                    byte[] a4 = m4523k().m4221a(c1083c);
                    String K = m4516d().m4254K();
                    try {
                        URL url = new URL(K);
                        m4500a(arrayList);
                        m4517e().f2448d.m4446a(m4527o().mo728a());
                        m4525m().m4424a(url, a4, new C11632(this));
                    } catch (MalformedURLException e) {
                        m4518f().m4399b().m4388a("Failed to parse upload URL. Not uploading", K);
                    }
                }
            }
        } else {
            m4518f().m4412o().m4387a("Network not connected, ignoring upload request");
            m4494B();
        }
    }

    void m4537y() {
        this.f2496w++;
    }
}
