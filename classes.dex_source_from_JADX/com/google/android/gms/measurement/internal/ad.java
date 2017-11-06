package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1075e;
import com.google.android.gms.measurement.C1100a.C1099a;

public class ad extends ab {
    private C1108a f2312a;
    private C1099a f2313b;
    private boolean f2314c;

    class C11041 implements Runnable {
        final /* synthetic */ boolean f2293a;
        final /* synthetic */ ad f2294b;

        public void run() {
            this.f2294b.m4116a(this.f2293a);
        }
    }

    private class C1108a implements ActivityLifecycleCallbacks {
        final /* synthetic */ ad f2311a;

        private C1108a(ad adVar) {
            this.f2311a = adVar;
        }

        private boolean m4109a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.f2311a.m4122a("auto", "_ldl", (Object) str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                this.f2311a.mo743l().m4417t().m4387a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.contains("gclid")) {
                                this.f2311a.mo743l().m4416s().m4388a("Activity created with referrer", queryParameter);
                                m4109a(queryParameter);
                                return;
                            }
                            this.f2311a.mo743l().m4416s().m4387a("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                this.f2311a.mo743l().m4399b().m4388a("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected ad(C1164y c1164y) {
        super(c1164y);
    }

    private void m4113a(String str, String str2, long j, Bundle bundle, boolean z, String str3) {
        C1032p.m3680a(str);
        C1032p.m3680a(str2);
        C1032p.m3678a((Object) bundle);
        mo736e();
        m4091y();
        if (mo744m().m4465r()) {
            if (!this.f2314c) {
                this.f2314c = true;
                m4117p();
            }
            if (z && this.f2313b != null) {
                mo743l().m4416s().m4389a("Passing event to registered event handler (FE)", str2, bundle);
                this.f2313b.m4056a(str, str2, bundle);
                return;
            } else if (this.g.m4514b()) {
                mo743l().m4416s().m4389a("Logging event (FE)", str2, bundle);
                mo738g().m4169a(new EventParcel(str2, new EventParams(bundle), str, j), str3);
                return;
            } else {
                return;
            }
        }
        mo743l().m4415r().m4387a("Event not sent since app measurement is disabled");
    }

    private void m4114a(String str, String str2, Bundle bundle, boolean z, String str3) {
        C1032p.m3680a(str);
        final long a = mo739h().mo728a();
        mo741j().m4218a(str2);
        final Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str4 : bundle.keySet()) {
                mo741j().m4228c(str4);
                Object a2 = mo741j().m4214a(str4, bundle.get(str4));
                if (a2 != null) {
                    mo741j().m4215a(bundle2, str4, a2);
                }
            }
        }
        final String str5 = str;
        final String str6 = str2;
        final boolean z2 = z;
        final String str7 = str3;
        mo742k().m4478a(new Runnable(this) {
            final /* synthetic */ ad f2301g;

            public void run() {
                this.f2301g.m4113a(str5, str6, a, bundle2, z2, str7);
            }
        });
    }

    private void m4115a(String str, String str2, Object obj, long j) {
        C1032p.m3680a(str);
        C1032p.m3680a(str2);
        mo736e();
        mo734c();
        m4091y();
        if (!mo744m().m4465r()) {
            mo743l().m4415r().m4387a("User attribute not set since app measurement is disabled");
        } else if (this.g.m4514b()) {
            mo743l().m4416s().m4389a("Setting user attribute (FE)", str2, obj);
            mo738g().m4170a(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    private void m4116a(boolean z) {
        mo736e();
        mo734c();
        m4091y();
        mo743l().m4416s().m4388a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        mo744m().m4461b(z);
        mo738g().m4184o();
    }

    private void m4117p() {
        try {
            m4120a(Class.forName(m4118q()));
        } catch (ClassNotFoundException e) {
            mo743l().m4415r().m4387a("Tag Manager is not found and thus will not be used");
        }
    }

    private String m4118q() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    protected void mo733a() {
    }

    public void m4120a(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{mo740i()});
        } catch (Exception e) {
            mo743l().m4412o().m4388a("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    public void m4121a(String str, String str2, Bundle bundle) {
        mo734c();
        m4114a(str, str2, bundle, true, null);
    }

    public void m4122a(String str, String str2, Object obj) {
        C1032p.m3680a(str);
        final long a = mo739h().mo728a();
        mo741j().m4223b(str2);
        if (obj != null) {
            mo741j().m4224b(str2, obj);
            final Object c = mo741j().m4226c(str2, obj);
            if (c != null) {
                final String str3 = str;
                final String str4 = str2;
                mo742k().m4478a(new Runnable(this) {
                    final /* synthetic */ ad f2306e;

                    public void run() {
                        this.f2306e.m4115a(str3, str4, c, a);
                    }
                });
                return;
            }
            return;
        }
        str4 = str;
        final String str5 = str2;
        mo742k().m4478a(new Runnable(this) {
            final /* synthetic */ ad f2310d;

            public void run() {
                this.f2310d.m4115a(str4, str5, null, a);
            }
        });
    }

    public void m4123b() {
        if (mo740i().getApplicationContext() instanceof Application) {
            Application application = (Application) mo740i().getApplicationContext();
            if (this.f2312a == null) {
                this.f2312a = new C1108a();
            }
            application.unregisterActivityLifecycleCallbacks(this.f2312a);
            application.registerActivityLifecycleCallbacks(this.f2312a);
            mo743l().m4417t().m4387a("Registered activity lifecycle callback");
        }
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

    public void m4136o() {
        mo736e();
        mo734c();
        m4091y();
        if (this.g.m4514b()) {
            mo738g().m4185p();
        }
    }
}
