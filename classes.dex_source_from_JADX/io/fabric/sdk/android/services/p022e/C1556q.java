package io.fabric.sdk.android.services.p022e;

import android.content.Context;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.p020b.C1479g;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1487l;
import io.fabric.sdk.android.services.p020b.C1493o;
import io.fabric.sdk.android.services.p020b.C1501s;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Settings */
public class C1556q {
    private final AtomicReference<C1558t> f3892a;
    private final CountDownLatch f3893b;
    private C1544s f3894c;
    private boolean f3895d;

    /* compiled from: Settings */
    public interface C0694b<T> {
        T usingSettings(C1558t c1558t);
    }

    /* compiled from: Settings */
    static class C1555a {
        private static final C1556q f3891a = new C1556q();
    }

    public static C1556q m5839a() {
        return C1555a.f3891a;
    }

    private C1556q() {
        this.f3892a = new AtomicReference();
        this.f3893b = new CountDownLatch(1);
        this.f3895d = false;
    }

    public synchronized C1556q m5841a(C0653h c0653h, C1493o c1493o, C1570d c1570d, String str, String str2, String str3) {
        C1556q c1556q;
        if (this.f3895d) {
            c1556q = this;
        } else {
            if (this.f3894c == null) {
                Context context = c0653h.getContext();
                String c = c1493o.m5697c();
                String a = new C1479g().m5631a(context);
                String j = c1493o.m5704j();
                C1501s c1501s = new C1501s();
                C1547k c1547k = new C1547k();
                C1543i c1543i = new C1543i(c0653h);
                String k = C1482i.m5677k(context);
                C0653h c0653h2 = c0653h;
                String str4 = str3;
                C1549l c1549l = new C1549l(c0653h2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c}), c1570d);
                j = str2;
                String str5 = str;
                this.f3894c = new C1545j(c0653h, new C1560w(a, c1493o.m5701g(), c1493o.m5700f(), c1493o.m5699e(), c1493o.m5707m(), c1493o.m5696b(), c1493o.m5708n(), C1482i.m5651a(C1482i.m5679m(context)), j, str5, C1487l.m5684a(j).m5685a(), k), c1501s, c1547k, c1543i, c1549l);
            }
            this.f3895d = true;
            c1556q = this;
        }
        return c1556q;
    }

    public <T> T m5842a(C0694b<T> c0694b, T t) {
        C1558t c1558t = (C1558t) this.f3892a.get();
        return c1558t == null ? t : c0694b.usingSettings(c1558t);
    }

    public C1558t m5843b() {
        try {
            this.f3893b.await();
            return (C1558t) this.f3892a.get();
        } catch (InterruptedException e) {
            C1457c.m5546h().mo818e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean m5844c() {
        C1558t a;
        a = this.f3894c.mo849a();
        m5840a(a);
        return a != null;
    }

    public synchronized boolean m5845d() {
        C1558t a;
        a = this.f3894c.mo850a(C1557r.SKIP_CACHE_LOOKUP);
        m5840a(a);
        if (a == null) {
            C1457c.m5546h().mo819e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    private void m5840a(C1558t c1558t) {
        this.f3892a.set(c1558t);
        this.f3893b.countDown();
    }
}
