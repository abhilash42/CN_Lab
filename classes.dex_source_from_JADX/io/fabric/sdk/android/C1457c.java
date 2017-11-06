package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.C1450a.C0663b;
import io.fabric.sdk.android.services.concurrency.C1524d;
import io.fabric.sdk.android.services.concurrency.C1530k;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.p020b.C1493o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Fabric */
public class C1457c {
    static volatile C1457c f3640a;
    static final C1451k f3641b = new C1452b();
    final C1451k f3642c;
    final boolean f3643d;
    private final Context f3644e;
    private final Map<Class<? extends C0653h>, C0653h> f3645f;
    private final ExecutorService f3646g;
    private final Handler f3647h;
    private final C1454f<C1457c> f3648i;
    private final C1454f<?> f3649j;
    private final C1493o f3650k;
    private C1450a f3651l;
    private WeakReference<Activity> f3652m;
    private AtomicBoolean f3653n = new AtomicBoolean(false);

    /* compiled from: Fabric */
    class C14531 extends C0663b {
        final /* synthetic */ C1457c f3626a;

        C14531(C1457c c1457c) {
            this.f3626a = c1457c;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.f3626a.m5549a(activity);
        }

        public void onActivityStarted(Activity activity) {
            this.f3626a.m5549a(activity);
        }

        public void onActivityResumed(Activity activity) {
            this.f3626a.m5549a(activity);
        }
    }

    /* compiled from: Fabric */
    public static class C1456a {
        private final Context f3631a;
        private C0653h[] f3632b;
        private C1530k f3633c;
        private Handler f3634d;
        private C1451k f3635e;
        private boolean f3636f;
        private String f3637g;
        private String f3638h;
        private C1454f<C1457c> f3639i;

        public C1456a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f3631a = context;
        }

        public C1456a m5534a(C0653h... c0653hArr) {
            if (this.f3632b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.f3632b = c0653hArr;
            return this;
        }

        public C1457c m5535a() {
            Map hashMap;
            if (this.f3633c == null) {
                this.f3633c = C1530k.m5787a();
            }
            if (this.f3634d == null) {
                this.f3634d = new Handler(Looper.getMainLooper());
            }
            if (this.f3635e == null) {
                if (this.f3636f) {
                    this.f3635e = new C1452b(3);
                } else {
                    this.f3635e = new C1452b();
                }
            }
            if (this.f3638h == null) {
                this.f3638h = this.f3631a.getPackageName();
            }
            if (this.f3639i == null) {
                this.f3639i = C1454f.f3627d;
            }
            if (this.f3632b == null) {
                hashMap = new HashMap();
            } else {
                hashMap = C1457c.m5543b(Arrays.asList(this.f3632b));
            }
            return new C1457c(this.f3631a, hashMap, this.f3633c, this.f3634d, this.f3635e, this.f3636f, this.f3639i, new C1493o(this.f3631a, this.f3638h, this.f3637g, hashMap.values()));
        }
    }

    static C1457c m5536a() {
        if (f3640a != null) {
            return f3640a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    C1457c(Context context, Map<Class<? extends C0653h>, C0653h> map, C1530k c1530k, Handler handler, C1451k c1451k, boolean z, C1454f c1454f, C1493o c1493o) {
        this.f3644e = context.getApplicationContext();
        this.f3645f = map;
        this.f3646g = c1530k;
        this.f3647h = handler;
        this.f3642c = c1451k;
        this.f3643d = z;
        this.f3648i = c1454f;
        this.f3649j = m5550a(map.size());
        this.f3650k = c1493o;
        m5549a(m5544c(context));
    }

    public static C1457c m5537a(Context context, C0653h... c0653hArr) {
        if (f3640a == null) {
            synchronized (C1457c.class) {
                if (f3640a == null) {
                    C1457c.m5545c(new C1456a(context).m5534a(c0653hArr).m5535a());
                }
            }
        }
        return f3640a;
    }

    private static void m5545c(C1457c c1457c) {
        f3640a = c1457c;
        c1457c.m5548j();
    }

    public C1457c m5549a(Activity activity) {
        this.f3652m = new WeakReference(activity);
        return this;
    }

    public Activity m5553b() {
        if (this.f3652m != null) {
            return (Activity) this.f3652m.get();
        }
        return null;
    }

    private void m5548j() {
        this.f3651l = new C1450a(this.f3644e);
        this.f3651l.m5505a(new C14531(this));
        m5551a(this.f3644e);
    }

    public String m5555c() {
        return "1.3.14.143";
    }

    public String m5556d() {
        return "io.fabric.sdk.android:fabric";
    }

    void m5551a(Context context) {
        StringBuilder append;
        Future b = m5554b(context);
        Collection g = m5559g();
        C1466l c1466l = new C1466l(b, g);
        List<C0653h> arrayList = new ArrayList(g);
        Collections.sort(arrayList);
        c1466l.injectParameters(context, this, C1454f.f3627d, this.f3650k);
        for (C0653h injectParameters : arrayList) {
            injectParameters.injectParameters(context, this, this.f3649j, this.f3650k);
        }
        c1466l.initialize();
        if (C1457c.m5546h().mo813a("Fabric", 3)) {
            append = new StringBuilder("Initializing ").append(m5556d()).append(" [Version: ").append(m5555c()).append("], with the following kits:\n");
        } else {
            append = null;
        }
        for (C0653h injectParameters2 : arrayList) {
            injectParameters2.initializationTask.m5582a(c1466l.initializationTask);
            m5552a(this.f3645f, injectParameters2);
            injectParameters2.initialize();
            if (append != null) {
                append.append(injectParameters2.getIdentifier()).append(" [Version: ").append(injectParameters2.getVersion()).append("]\n");
            }
        }
        if (append != null) {
            C1457c.m5546h().mo811a("Fabric", append.toString());
        }
    }

    void m5552a(Map<Class<? extends C0653h>, C0653h> map, C0653h c0653h) {
        C1524d c1524d = c0653h.dependsOnAnnotation;
        if (c1524d != null) {
            for (Class cls : c1524d.m5780a()) {
                if (cls.isInterface()) {
                    for (C0653h c0653h2 : map.values()) {
                        if (cls.isAssignableFrom(c0653h2.getClass())) {
                            c0653h.initializationTask.m5582a(c0653h2.initializationTask);
                        }
                    }
                } else if (((C0653h) map.get(cls)) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                } else {
                    c0653h.initializationTask.m5582a(((C0653h) map.get(cls)).initializationTask);
                }
            }
        }
    }

    private Activity m5544c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public C1450a m5557e() {
        return this.f3651l;
    }

    public ExecutorService m5558f() {
        return this.f3646g;
    }

    public Collection<C0653h> m5559g() {
        return this.f3645f.values();
    }

    public static <T extends C0653h> T m5538a(Class<T> cls) {
        return (C0653h) C1457c.m5536a().f3645f.get(cls);
    }

    public static C1451k m5546h() {
        if (f3640a == null) {
            return f3641b;
        }
        return f3640a.f3642c;
    }

    public static boolean m5547i() {
        if (f3640a == null) {
            return false;
        }
        return f3640a.f3643d;
    }

    private static Map<Class<? extends C0653h>, C0653h> m5543b(Collection<? extends C0653h> collection) {
        Map hashMap = new HashMap(collection.size());
        C1457c.m5541a(hashMap, (Collection) collection);
        return hashMap;
    }

    private static void m5541a(Map<Class<? extends C0653h>, C0653h> map, Collection<? extends C0653h> collection) {
        for (C0653h c0653h : collection) {
            map.put(c0653h.getClass(), c0653h);
            if (c0653h instanceof C0654i) {
                C1457c.m5541a((Map) map, ((C0654i) c0653h).getKits());
            }
        }
    }

    C1454f<?> m5550a(final int i) {
        return new C1454f(this) {
            final CountDownLatch f3628a = new CountDownLatch(i);
            final /* synthetic */ C1457c f3630c;

            public void mo821a(Object obj) {
                this.f3628a.countDown();
                if (this.f3628a.getCount() == 0) {
                    this.f3630c.f3653n.set(true);
                    this.f3630c.f3648i.mo821a(this.f3630c);
                }
            }

            public void mo820a(Exception exception) {
                this.f3630c.f3648i.mo820a(exception);
            }
        };
    }

    Future<Map<String, C1465j>> m5554b(Context context) {
        return m5558f().submit(new C1459e(context.getPackageCodePath()));
    }
}
