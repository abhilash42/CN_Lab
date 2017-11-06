package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1075e;
import com.google.android.gms.measurement.C1100a;

public class C1146t extends ab {
    private final String f2409a = mo745n().m4261a();
    private final char f2410b;
    private final long f2411c = mo745n().m4245B();
    private final C1145a f2412d;
    private final C1145a f2413e;
    private final C1145a f2414f;
    private final C1145a f2415h;
    private final C1145a f2416i;
    private final C1145a f2417j;
    private final C1145a f2418k;
    private final C1145a f2419l;
    private final C1145a f2420m;

    public class C1145a {
        final /* synthetic */ C1146t f2405a;
        private final int f2406b;
        private final boolean f2407c;
        private final boolean f2408d;

        C1145a(C1146t c1146t, int i, boolean z, boolean z2) {
            this.f2405a = c1146t;
            this.f2406b = i;
            this.f2407c = z;
            this.f2408d = z2;
        }

        public void m4387a(String str) {
            this.f2405a.m4397a(this.f2406b, this.f2407c, this.f2408d, str, null, null, null);
        }

        public void m4388a(String str, Object obj) {
            this.f2405a.m4397a(this.f2406b, this.f2407c, this.f2408d, str, obj, null, null);
        }

        public void m4389a(String str, Object obj, Object obj2) {
            this.f2405a.m4397a(this.f2406b, this.f2407c, this.f2408d, str, obj, obj2, null);
        }

        public void m4390a(String str, Object obj, Object obj2, Object obj3) {
            this.f2405a.m4397a(this.f2406b, this.f2407c, this.f2408d, str, obj, obj2, obj3);
        }
    }

    C1146t(C1164y c1164y) {
        super(c1164y);
        if (mo745n().m4247D()) {
            this.f2410b = mo745n().m4246C() ? 'P' : 'C';
        } else {
            this.f2410b = mo745n().m4246C() ? 'p' : 'c';
        }
        this.f2412d = new C1145a(this, 6, false, false);
        this.f2413e = new C1145a(this, 6, true, false);
        this.f2414f = new C1145a(this, 6, false, true);
        this.f2415h = new C1145a(this, 5, false, false);
        this.f2416i = new C1145a(this, 5, true, false);
        this.f2417j = new C1145a(this, 5, false, true);
        this.f2418k = new C1145a(this, 4, false, false);
        this.f2419l = new C1145a(this, 3, false, false);
        this.f2420m = new C1145a(this, 2, false, false);
    }

    private static String m4391a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    static String m4392a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return str + Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d);
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(th.toString());
                String a = C1146t.m4391a(C1100a.class.getCanonicalName());
                String a2 = C1146t.m4391a(C1164y.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = C1146t.m4391a(className);
                            if (className.equals(a) || className.equals(a2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    static String m4393a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = C1146t.m4392a(z, obj);
        Object a2 = C1146t.m4392a(z, obj2);
        Object a3 = C1146t.m4392a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    protected void mo733a() {
    }

    protected void m4395a(int i, String str) {
        Log.println(i, this.f2409a, str);
    }

    public void m4396a(int i, String str, Object obj, Object obj2, Object obj3) {
        C1032p.m3678a((Object) str);
        C1161x h = this.g.m4520h();
        if (h == null || !h.m4089w() || h.m4090x()) {
            m4395a(6, "Scheduler not initialized or shutdown. Not logging error/warn.");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= "01VDIWEA?".length()) {
            i = "01VDIWEA?".length() - 1;
        }
        String str2 = "1" + "01VDIWEA?".charAt(i) + this.f2410b + this.f2411c + ":" + C1146t.m4393a(true, str, obj, obj2, obj3);
        final String substring = str2.length() > 1024 ? str.substring(0, 1024) : str2;
        h.m4478a(new Runnable(this) {
            final /* synthetic */ C1146t f2404b;

            public void run() {
                C1157w e = this.f2404b.g.m4517e();
                if (!e.m4089w() || e.m4090x()) {
                    this.f2404b.m4395a(6, "Persisted config not initialized . Not logging error/warn.");
                } else {
                    e.f2446b.m4451a(substring);
                }
            }
        });
    }

    protected void m4397a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m4398a(i)) {
            m4395a(i, C1146t.m4393a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            m4396a(i, str, obj, obj2, obj3);
        }
    }

    protected boolean m4398a(int i) {
        return Log.isLoggable(this.f2409a, i);
    }

    public C1145a m4399b() {
        return this.f2412d;
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

    public C1145a m4412o() {
        return this.f2415h;
    }

    public C1145a m4413p() {
        return this.f2416i;
    }

    public C1145a m4414q() {
        return this.f2417j;
    }

    public C1145a m4415r() {
        return this.f2418k;
    }

    public C1145a m4416s() {
        return this.f2419l;
    }

    public C1145a m4417t() {
        return this.f2420m;
    }

    public String m4418u() {
        Pair a = mo744m().f2446b.m4450a();
        return a == null ? null : String.valueOf(a.second) + ":" + ((String) a.first);
    }
}
