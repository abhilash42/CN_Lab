package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ab.C0072a;
import android.support.v4.app.ac.C0073a;
import android.support.v4.app.ad.C0053a;
import android.support.v4.app.ad.C0053a.C0051a;
import android.support.v4.app.ag.C0074a;
import android.support.v4.app.ah.C0075a;
import android.support.v4.app.ai.C0076a;
import android.support.v4.app.al.C0083a;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NotificationCompat */
public class aa {
    private static final C0061g f230a;

    /* compiled from: NotificationCompat */
    public static class C0054a extends C0053a {
        public static final C0051a f186d = new C00521();
        public int f187a;
        public CharSequence f188b;
        public PendingIntent f189c;
        private final Bundle f190e;
        private final aj[] f191f;

        /* compiled from: NotificationCompat */
        static class C00521 implements C0051a {
            C00521() {
            }
        }

        public /* synthetic */ C0083a[] mo33f() {
            return m216e();
        }

        public int mo29a() {
            return this.f187a;
        }

        public CharSequence mo30b() {
            return this.f188b;
        }

        public PendingIntent mo31c() {
            return this.f189c;
        }

        public Bundle mo32d() {
            return this.f190e;
        }

        public aj[] m216e() {
            return this.f191f;
        }
    }

    /* compiled from: NotificationCompat */
    public static abstract class C0055p {
        C0058d f192d;
        CharSequence f193e;
        CharSequence f194f;
        boolean f195g = false;

        public void m218a(C0058d c0058d) {
            if (this.f192d != c0058d) {
                this.f192d = c0058d;
                if (this.f192d != null) {
                    this.f192d.m229a(this);
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    public static class C0056b extends C0055p {
        Bitmap f196a;
        Bitmap f197b;
        boolean f198c;
    }

    /* compiled from: NotificationCompat */
    public static class C0057c extends C0055p {
        CharSequence f199a;

        public C0057c m219a(CharSequence charSequence) {
            this.e = C0058d.m222d(charSequence);
            return this;
        }

        public C0057c m220b(CharSequence charSequence) {
            this.f199a = C0058d.m222d(charSequence);
            return this;
        }
    }

    /* compiled from: NotificationCompat */
    public static class C0058d {
        Notification f200A;
        public Notification f201B = new Notification();
        public ArrayList<String> f202C;
        public Context f203a;
        public CharSequence f204b;
        public CharSequence f205c;
        PendingIntent f206d;
        PendingIntent f207e;
        RemoteViews f208f;
        public Bitmap f209g;
        public CharSequence f210h;
        public int f211i;
        int f212j;
        boolean f213k = true;
        public boolean f214l;
        public C0055p f215m;
        public CharSequence f216n;
        int f217o;
        int f218p;
        boolean f219q;
        String f220r;
        boolean f221s;
        String f222t;
        public ArrayList<C0054a> f223u = new ArrayList();
        boolean f224v = false;
        String f225w;
        Bundle f226x;
        int f227y = 0;
        int f228z = 0;

        public C0058d(Context context) {
            this.f203a = context;
            this.f201B.when = System.currentTimeMillis();
            this.f201B.audioStreamType = -1;
            this.f212j = 0;
            this.f202C = new ArrayList();
        }

        public C0058d m225a(long j) {
            this.f201B.when = j;
            return this;
        }

        public C0058d m224a(int i) {
            this.f201B.icon = i;
            return this;
        }

        public C0058d m230a(CharSequence charSequence) {
            this.f204b = C0058d.m222d(charSequence);
            return this;
        }

        public C0058d m234b(CharSequence charSequence) {
            this.f205c = C0058d.m222d(charSequence);
            return this;
        }

        public C0058d m226a(PendingIntent pendingIntent) {
            this.f206d = pendingIntent;
            return this;
        }

        public C0058d m233b(PendingIntent pendingIntent) {
            this.f201B.deleteIntent = pendingIntent;
            return this;
        }

        public C0058d m236c(CharSequence charSequence) {
            this.f201B.tickerText = C0058d.m222d(charSequence);
            return this;
        }

        public C0058d m227a(Bitmap bitmap) {
            this.f209g = bitmap;
            return this;
        }

        public C0058d m228a(Uri uri) {
            this.f201B.sound = uri;
            this.f201B.audioStreamType = -1;
            return this;
        }

        public C0058d m231a(boolean z) {
            m221a(16, z);
            return this;
        }

        private void m221a(int i, boolean z) {
            if (z) {
                Notification notification = this.f201B;
                notification.flags |= i;
                return;
            }
            notification = this.f201B;
            notification.flags &= i ^ -1;
        }

        public C0058d m229a(C0055p c0055p) {
            if (this.f215m != c0055p) {
                this.f215m = c0055p;
                if (this.f215m != null) {
                    this.f215m.m218a(this);
                }
            }
            return this;
        }

        public C0058d m232b(int i) {
            this.f227y = i;
            return this;
        }

        public Notification m223a() {
            return aa.f230a.mo34a(this, m235b());
        }

        protected C0059e m235b() {
            return new C0059e();
        }

        protected static CharSequence m222d(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    /* compiled from: NotificationCompat */
    protected static class C0059e {
        protected C0059e() {
        }

        public Notification m237a(C0058d c0058d, C0071z c0071z) {
            return c0071z.mo37b();
        }
    }

    /* compiled from: NotificationCompat */
    public static class C0060f extends C0055p {
        ArrayList<CharSequence> f229a = new ArrayList();
    }

    /* compiled from: NotificationCompat */
    interface C0061g {
        Notification mo34a(C0058d c0058d, C0059e c0059e);
    }

    /* compiled from: NotificationCompat */
    static class C0062j implements C0061g {
        C0062j() {
        }

        public Notification mo34a(C0058d c0058d, C0059e c0059e) {
            Notification a = ad.m262a(c0058d.f201B, c0058d.f203a, c0058d.f204b, c0058d.f205c, c0058d.f206d);
            if (c0058d.f212j > 0) {
                a.flags |= 128;
            }
            return a;
        }
    }

    /* compiled from: NotificationCompat */
    static class C0063n extends C0062j {
        C0063n() {
        }

        public Notification mo34a(C0058d c0058d, C0059e c0059e) {
            C0071z c0075a = new C0075a(c0058d.f203a, c0058d.f201B, c0058d.f204b, c0058d.f205c, c0058d.f210h, c0058d.f208f, c0058d.f211i, c0058d.f206d, c0058d.f207e, c0058d.f209g, c0058d.f217o, c0058d.f218p, c0058d.f219q, c0058d.f214l, c0058d.f212j, c0058d.f216n, c0058d.f224v, c0058d.f226x, c0058d.f220r, c0058d.f221s, c0058d.f222t);
            aa.m250b((C0070y) c0075a, c0058d.f223u);
            aa.m251b(c0075a, c0058d.f215m);
            return c0059e.m237a(c0058d, c0075a);
        }
    }

    /* compiled from: NotificationCompat */
    static class C0064o extends C0063n {
        C0064o() {
        }

        public Notification mo34a(C0058d c0058d, C0059e c0059e) {
            C0071z c0076a = new C0076a(c0058d.f203a, c0058d.f201B, c0058d.f204b, c0058d.f205c, c0058d.f210h, c0058d.f208f, c0058d.f211i, c0058d.f206d, c0058d.f207e, c0058d.f209g, c0058d.f217o, c0058d.f218p, c0058d.f219q, c0058d.f213k, c0058d.f214l, c0058d.f212j, c0058d.f216n, c0058d.f224v, c0058d.f202C, c0058d.f226x, c0058d.f220r, c0058d.f221s, c0058d.f222t);
            aa.m250b((C0070y) c0076a, c0058d.f223u);
            aa.m251b(c0076a, c0058d.f215m);
            return c0059e.m237a(c0058d, c0076a);
        }
    }

    /* compiled from: NotificationCompat */
    static class C0065h extends C0064o {
        C0065h() {
        }

        public Notification mo34a(C0058d c0058d, C0059e c0059e) {
            C0071z c0072a = new C0072a(c0058d.f203a, c0058d.f201B, c0058d.f204b, c0058d.f205c, c0058d.f210h, c0058d.f208f, c0058d.f211i, c0058d.f206d, c0058d.f207e, c0058d.f209g, c0058d.f217o, c0058d.f218p, c0058d.f219q, c0058d.f213k, c0058d.f214l, c0058d.f212j, c0058d.f216n, c0058d.f224v, c0058d.f202C, c0058d.f226x, c0058d.f220r, c0058d.f221s, c0058d.f222t);
            aa.m250b((C0070y) c0072a, c0058d.f223u);
            aa.m251b(c0072a, c0058d.f215m);
            return c0059e.m237a(c0058d, c0072a);
        }
    }

    /* compiled from: NotificationCompat */
    static class C0066i extends C0065h {
        C0066i() {
        }

        public Notification mo34a(C0058d c0058d, C0059e c0059e) {
            C0071z c0073a = new C0073a(c0058d.f203a, c0058d.f201B, c0058d.f204b, c0058d.f205c, c0058d.f210h, c0058d.f208f, c0058d.f211i, c0058d.f206d, c0058d.f207e, c0058d.f209g, c0058d.f217o, c0058d.f218p, c0058d.f219q, c0058d.f213k, c0058d.f214l, c0058d.f212j, c0058d.f216n, c0058d.f224v, c0058d.f225w, c0058d.f202C, c0058d.f226x, c0058d.f227y, c0058d.f228z, c0058d.f200A, c0058d.f220r, c0058d.f221s, c0058d.f222t);
            aa.m250b((C0070y) c0073a, c0058d.f223u);
            aa.m251b(c0073a, c0058d.f215m);
            return c0059e.m237a(c0058d, c0073a);
        }
    }

    /* compiled from: NotificationCompat */
    static class C0067k extends C0062j {
        C0067k() {
        }

        public Notification mo34a(C0058d c0058d, C0059e c0059e) {
            Notification a = ae.m263a(c0058d.f201B, c0058d.f203a, c0058d.f204b, c0058d.f205c, c0058d.f206d, c0058d.f207e);
            if (c0058d.f212j > 0) {
                a.flags |= 128;
            }
            return a;
        }
    }

    /* compiled from: NotificationCompat */
    static class C0068l extends C0062j {
        C0068l() {
        }

        public Notification mo34a(C0058d c0058d, C0059e c0059e) {
            return af.m264a(c0058d.f203a, c0058d.f201B, c0058d.f204b, c0058d.f205c, c0058d.f210h, c0058d.f208f, c0058d.f211i, c0058d.f206d, c0058d.f207e, c0058d.f209g);
        }
    }

    /* compiled from: NotificationCompat */
    static class C0069m extends C0062j {
        C0069m() {
        }

        public Notification mo34a(C0058d c0058d, C0059e c0059e) {
            return c0059e.m237a(c0058d, new C0074a(c0058d.f203a, c0058d.f201B, c0058d.f204b, c0058d.f205c, c0058d.f210h, c0058d.f208f, c0058d.f211i, c0058d.f206d, c0058d.f207e, c0058d.f209g, c0058d.f217o, c0058d.f218p, c0058d.f219q));
        }
    }

    private static void m250b(C0070y c0070y, ArrayList<C0054a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c0070y.mo36a((C0054a) it.next());
        }
    }

    private static void m251b(C0071z c0071z, C0055p c0055p) {
        if (c0055p == null) {
            return;
        }
        if (c0055p instanceof C0057c) {
            C0057c c0057c = (C0057c) c0055p;
            ah.m274a(c0071z, c0057c.e, c0057c.g, c0057c.f, c0057c.f199a);
        } else if (c0055p instanceof C0060f) {
            C0060f c0060f = (C0060f) c0055p;
            ah.m275a(c0071z, c0060f.e, c0060f.g, c0060f.f, c0060f.f229a);
        } else if (c0055p instanceof C0056b) {
            C0056b c0056b = (C0056b) c0055p;
            ah.m273a(c0071z, c0056b.e, c0056b.g, c0056b.f, c0056b.f196a, c0056b.f197b, c0056b.f198c);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f230a = new C0066i();
        } else if (VERSION.SDK_INT >= 20) {
            f230a = new C0065h();
        } else if (VERSION.SDK_INT >= 19) {
            f230a = new C0064o();
        } else if (VERSION.SDK_INT >= 16) {
            f230a = new C0063n();
        } else if (VERSION.SDK_INT >= 14) {
            f230a = new C0069m();
        } else if (VERSION.SDK_INT >= 11) {
            f230a = new C0068l();
        } else if (VERSION.SDK_INT >= 9) {
            f230a = new C0067k();
        } else {
            f230a = new C0062j();
        }
    }
}
