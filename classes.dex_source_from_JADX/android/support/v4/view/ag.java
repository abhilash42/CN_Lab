package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;
import java.util.WeakHashMap;

/* compiled from: ViewCompat */
public final class ag {
    static final C0276m f551a;

    /* compiled from: ViewCompat */
    interface C0276m {
        int mo194a(int i, int i2, int i3);

        int mo195a(View view);

        bd mo196a(View view, bd bdVar);

        void mo197a(View view, float f);

        void mo198a(View view, int i, int i2);

        void mo199a(View view, int i, int i2, int i3, int i4);

        void mo200a(View view, int i, Paint paint);

        void mo201a(View view, ColorStateList colorStateList);

        void mo202a(View view, Mode mode);

        void mo203a(View view, C0220a c0220a);

        void mo204a(View view, aa aaVar);

        void mo205a(View view, Runnable runnable);

        void mo206a(View view, Runnable runnable, long j);

        void mo207a(View view, boolean z);

        boolean mo208a(View view, int i);

        bd mo209b(View view, bd bdVar);

        void mo210b(View view);

        void mo211b(View view, float f);

        void mo212b(View view, boolean z);

        boolean mo213b(View view, int i);

        int mo214c(View view);

        void mo215c(View view, float f);

        void mo216c(View view, int i);

        int mo217d(View view);

        void mo218d(View view, float f);

        int mo219e(View view);

        int mo220f(View view);

        int mo221g(View view);

        int mo222h(View view);

        int mo223i(View view);

        boolean mo224j(View view);

        float mo225k(View view);

        float mo226l(View view);

        int mo227m(View view);

        aw mo228n(View view);

        int mo229o(View view);

        void mo230p(View view);

        void mo231q(View view);

        ColorStateList mo232r(View view);

        Mode mo233s(View view);

        void mo234t(View view);

        boolean mo235u(View view);

        boolean mo236v(View view);

        boolean mo237w(View view);
    }

    /* compiled from: ViewCompat */
    static class C0277a implements C0276m {
        WeakHashMap<View, aw> f549a = null;

        C0277a() {
        }

        public boolean mo208a(View view, int i) {
            return (view instanceof ac) && m1164a((ac) view, i);
        }

        public boolean mo213b(View view, int i) {
            return (view instanceof ac) && m1165b((ac) view, i);
        }

        public int mo195a(View view) {
            return 2;
        }

        public void mo203a(View view, C0220a c0220a) {
        }

        public void mo210b(View view) {
            view.invalidate();
        }

        public void mo205a(View view, Runnable runnable) {
            view.postDelayed(runnable, mo238a());
        }

        public void mo206a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, mo238a() + j);
        }

        long mo238a() {
            return 10;
        }

        public int mo214c(View view) {
            return 0;
        }

        public void mo216c(View view, int i) {
        }

        public void mo200a(View view, int i, Paint paint) {
        }

        public int mo217d(View view) {
            return 0;
        }

        public int mo219e(View view) {
            return 0;
        }

        public int mo194a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int mo220f(View view) {
            return view.getMeasuredWidth();
        }

        public int mo221g(View view) {
            return 0;
        }

        public int mo222h(View view) {
            return view.getPaddingLeft();
        }

        public int mo223i(View view) {
            return view.getPaddingRight();
        }

        public void mo199a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public boolean mo224j(View view) {
            return true;
        }

        public float mo225k(View view) {
            return 0.0f;
        }

        public float mo226l(View view) {
            return 0.0f;
        }

        public int mo227m(View view) {
            return ah.m1307d(view);
        }

        public aw mo228n(View view) {
            return new aw(view);
        }

        public void mo197a(View view, float f) {
        }

        public void mo211b(View view, float f) {
        }

        public void mo215c(View view, float f) {
        }

        public int mo229o(View view) {
            return 0;
        }

        public void mo230p(View view) {
        }

        public void mo218d(View view, float f) {
        }

        public void mo231q(View view) {
        }

        public void mo204a(View view, aa aaVar) {
        }

        public bd mo196a(View view, bd bdVar) {
            return bdVar;
        }

        public bd mo209b(View view, bd bdVar) {
            return bdVar;
        }

        public void mo207a(View view, boolean z) {
        }

        public void mo212b(View view, boolean z) {
        }

        public ColorStateList mo232r(View view) {
            return ah.m1302a(view);
        }

        public void mo201a(View view, ColorStateList colorStateList) {
            ah.m1303a(view, colorStateList);
        }

        public void mo202a(View view, Mode mode) {
            ah.m1304a(view, mode);
        }

        public Mode mo233s(View view) {
            return ah.m1305b(view);
        }

        private boolean m1164a(ac acVar, int i) {
            int computeHorizontalScrollOffset = acVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = acVar.computeHorizontalScrollRange() - acVar.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeHorizontalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        private boolean m1165b(ac acVar, int i) {
            int computeVerticalScrollOffset = acVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = acVar.computeVerticalScrollRange() - acVar.computeVerticalScrollExtent();
            if (computeVerticalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeVerticalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        public void mo234t(View view) {
            if (view instanceof C0365w) {
                ((C0365w) view).stopNestedScroll();
            }
        }

        public boolean mo235u(View view) {
            return ah.m1306c(view);
        }

        public boolean mo236v(View view) {
            return ah.m1308e(view);
        }

        public boolean mo237w(View view) {
            return false;
        }

        public void mo198a(View view, int i, int i2) {
        }
    }

    /* compiled from: ViewCompat */
    static class C0278b extends C0277a {
        C0278b() {
        }
    }

    /* compiled from: ViewCompat */
    static class C0279c extends C0278b {
        C0279c() {
        }

        public int mo195a(View view) {
            return ai.m1309a(view);
        }
    }

    /* compiled from: ViewCompat */
    static class C0280d extends C0279c {
        C0280d() {
        }

        long mo238a() {
            return aj.m1312a();
        }

        public void mo200a(View view, int i, Paint paint) {
            aj.m1314a(view, i, paint);
        }

        public int mo217d(View view) {
            return aj.m1311a(view);
        }

        public int mo194a(int i, int i2, int i3) {
            return aj.m1310a(i, i2, i3);
        }

        public int mo220f(View view) {
            return aj.m1316b(view);
        }

        public int mo221g(View view) {
            return aj.m1319c(view);
        }

        public float mo225k(View view) {
            return aj.m1321d(view);
        }

        public void mo197a(View view, float f) {
            aj.m1313a(view, f);
        }

        public void mo211b(View view, float f) {
            aj.m1317b(view, f);
        }

        public void mo215c(View view, float f) {
            aj.m1320c(view, f);
        }

        public float mo226l(View view) {
            return aj.m1322e(view);
        }

        public void mo231q(View view) {
            aj.m1323f(view);
        }

        public void mo207a(View view, boolean z) {
            aj.m1315a(view, z);
        }

        public void mo212b(View view, boolean z) {
            aj.m1318b(view, z);
        }
    }

    /* compiled from: ViewCompat */
    static class C0281f extends C0280d {
        static boolean f550b = false;

        C0281f() {
        }

        public boolean mo208a(View view, int i) {
            return ak.m1325a(view, i);
        }

        public boolean mo213b(View view, int i) {
            return ak.m1326b(view, i);
        }

        public void mo203a(View view, C0220a c0220a) {
            ak.m1324a(view, c0220a == null ? null : c0220a.m832a());
        }

        public aw mo228n(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            aw awVar = (aw) this.a.get(view);
            if (awVar != null) {
                return awVar;
            }
            awVar = new aw(view);
            this.a.put(view, awVar);
            return awVar;
        }
    }

    /* compiled from: ViewCompat */
    static class C0282e extends C0281f {
        C0282e() {
        }

        public boolean mo237w(View view) {
            return al.m1327a(view);
        }
    }

    /* compiled from: ViewCompat */
    static class C0283g extends C0282e {
        C0283g() {
        }

        public void mo210b(View view) {
            am.m1328a(view);
        }

        public void mo205a(View view, Runnable runnable) {
            am.m1330a(view, runnable);
        }

        public void mo206a(View view, Runnable runnable, long j) {
            am.m1331a(view, runnable, j);
        }

        public int mo214c(View view) {
            return am.m1332b(view);
        }

        public void mo216c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            am.m1329a(view, i);
        }

        public int mo227m(View view) {
            return am.m1333c(view);
        }

        public void mo230p(View view) {
            am.m1334d(view);
        }

        public boolean mo224j(View view) {
            return am.m1335e(view);
        }
    }

    /* compiled from: ViewCompat */
    static class C0284h extends C0283g {
        C0284h() {
        }

        public int mo219e(View view) {
            return an.m1336a(view);
        }

        public int mo222h(View view) {
            return an.m1338b(view);
        }

        public int mo223i(View view) {
            return an.m1339c(view);
        }

        public void mo199a(View view, int i, int i2, int i3, int i4) {
            an.m1337a(view, i, i2, i3, i4);
        }

        public int mo229o(View view) {
            return an.m1340d(view);
        }
    }

    /* compiled from: ViewCompat */
    static class C0285i extends C0284h {
        C0285i() {
        }
    }

    /* compiled from: ViewCompat */
    static class C0286j extends C0285i {
        C0286j() {
        }

        public void mo216c(View view, int i) {
            am.m1329a(view, i);
        }

        public boolean mo235u(View view) {
            return ao.m1341a(view);
        }

        public boolean mo236v(View view) {
            return ao.m1342b(view);
        }
    }

    /* compiled from: ViewCompat */
    static class C0287k extends C0286j {
        C0287k() {
        }

        public void mo230p(View view) {
            ap.m1344a(view);
        }

        public void mo218d(View view, float f) {
            ap.m1345a(view, f);
        }

        public void mo204a(View view, aa aaVar) {
            ap.m1348a(view, aaVar);
        }

        public void mo234t(View view) {
            ap.m1352d(view);
        }

        public ColorStateList mo232r(View view) {
            return ap.m1349b(view);
        }

        public void mo201a(View view, ColorStateList colorStateList) {
            ap.m1346a(view, colorStateList);
        }

        public void mo202a(View view, Mode mode) {
            ap.m1347a(view, mode);
        }

        public Mode mo233s(View view) {
            return ap.m1351c(view);
        }

        public bd mo196a(View view, bd bdVar) {
            return ap.m1343a(view, bdVar);
        }

        public bd mo209b(View view, bd bdVar) {
            return ap.m1350b(view, bdVar);
        }
    }

    /* compiled from: ViewCompat */
    static class C0288l extends C0287k {
        C0288l() {
        }

        public void mo198a(View view, int i, int i2) {
            aq.m1353a(view, i, i2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f551a = new C0288l();
        } else if (i >= 21) {
            f551a = new C0287k();
        } else if (i >= 19) {
            f551a = new C0286j();
        } else if (i >= 17) {
            f551a = new C0284h();
        } else if (i >= 16) {
            f551a = new C0283g();
        } else if (i >= 15) {
            f551a = new C0282e();
        } else if (i >= 14) {
            f551a = new C0281f();
        } else if (i >= 11) {
            f551a = new C0280d();
        } else if (i >= 9) {
            f551a = new C0279c();
        } else if (i >= 7) {
            f551a = new C0278b();
        } else {
            f551a = new C0277a();
        }
    }

    public static boolean m1272a(View view, int i) {
        return f551a.mo208a(view, i);
    }

    public static boolean m1277b(View view, int i) {
        return f551a.mo213b(view, i);
    }

    public static int m1259a(View view) {
        return f551a.mo195a(view);
    }

    public static void m1267a(View view, C0220a c0220a) {
        f551a.mo203a(view, c0220a);
    }

    public static void m1274b(View view) {
        f551a.mo210b(view);
    }

    public static void m1269a(View view, Runnable runnable) {
        f551a.mo205a(view, runnable);
    }

    public static void m1270a(View view, Runnable runnable, long j) {
        f551a.mo206a(view, runnable, j);
    }

    public static int m1278c(View view) {
        return f551a.mo214c(view);
    }

    public static void m1280c(View view, int i) {
        f551a.mo216c(view, i);
    }

    public static void m1264a(View view, int i, Paint paint) {
        f551a.mo200a(view, i, paint);
    }

    public static int m1281d(View view) {
        return f551a.mo217d(view);
    }

    public static int m1283e(View view) {
        return f551a.mo219e(view);
    }

    public static int m1258a(int i, int i2, int i3) {
        return f551a.mo194a(i, i2, i3);
    }

    public static int m1284f(View view) {
        return f551a.mo220f(view);
    }

    public static int m1285g(View view) {
        return f551a.mo221g(view);
    }

    public static int m1286h(View view) {
        return f551a.mo222h(view);
    }

    public static int m1287i(View view) {
        return f551a.mo223i(view);
    }

    public static void m1263a(View view, int i, int i2, int i3, int i4) {
        f551a.mo199a(view, i, i2, i3, i4);
    }

    public static float m1288j(View view) {
        return f551a.mo225k(view);
    }

    public static int m1289k(View view) {
        return f551a.mo227m(view);
    }

    public static aw m1290l(View view) {
        return f551a.mo228n(view);
    }

    public static void m1261a(View view, float f) {
        f551a.mo197a(view, f);
    }

    public static void m1275b(View view, float f) {
        f551a.mo211b(view, f);
    }

    public static void m1279c(View view, float f) {
        f551a.mo215c(view, f);
    }

    public static float m1291m(View view) {
        return f551a.mo226l(view);
    }

    public static void m1282d(View view, float f) {
        f551a.mo218d(view, f);
    }

    public static int m1292n(View view) {
        return f551a.mo229o(view);
    }

    public static void m1293o(View view) {
        f551a.mo230p(view);
    }

    public static void m1294p(View view) {
        f551a.mo231q(view);
    }

    public static void m1268a(View view, aa aaVar) {
        f551a.mo204a(view, aaVar);
    }

    public static bd m1260a(View view, bd bdVar) {
        return f551a.mo196a(view, bdVar);
    }

    public static bd m1273b(View view, bd bdVar) {
        return f551a.mo209b(view, bdVar);
    }

    public static void m1271a(View view, boolean z) {
        f551a.mo207a(view, z);
    }

    public static void m1276b(View view, boolean z) {
        f551a.mo212b(view, z);
    }

    public static boolean m1295q(View view) {
        return f551a.mo224j(view);
    }

    public static ColorStateList m1296r(View view) {
        return f551a.mo232r(view);
    }

    public static void m1265a(View view, ColorStateList colorStateList) {
        f551a.mo201a(view, colorStateList);
    }

    public static Mode m1297s(View view) {
        return f551a.mo233s(view);
    }

    public static void m1266a(View view, Mode mode) {
        f551a.mo202a(view, mode);
    }

    public static void m1298t(View view) {
        f551a.mo234t(view);
    }

    public static boolean m1299u(View view) {
        return f551a.mo235u(view);
    }

    public static boolean m1300v(View view) {
        return f551a.mo236v(view);
    }

    public static boolean m1301w(View view) {
        return f551a.mo237w(view);
    }

    public static void m1262a(View view, int i, int i2) {
        f551a.mo198a(view, i, i2);
    }
}
