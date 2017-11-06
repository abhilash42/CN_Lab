package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewParentCompat */
public final class au {
    static final C0295b f556a;

    /* compiled from: ViewParentCompat */
    interface C0295b {
        void mo241a(ViewParent viewParent, View view);

        void mo242a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void mo243a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean mo244a(ViewParent viewParent, View view, float f, float f2);

        boolean mo245a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean mo246a(ViewParent viewParent, View view, View view2, int i);

        void mo247b(ViewParent viewParent, View view, View view2, int i);
    }

    /* compiled from: ViewParentCompat */
    static class C0296e implements C0295b {
        C0296e() {
        }

        public boolean mo246a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0367y) {
                return ((C0367y) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void mo247b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0367y) {
                ((C0367y) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void mo241a(ViewParent viewParent, View view) {
            if (viewParent instanceof C0367y) {
                ((C0367y) viewParent).onStopNestedScroll(view);
            }
        }

        public void mo242a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof C0367y) {
                ((C0367y) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void mo243a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof C0367y) {
                ((C0367y) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean mo245a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof C0367y) {
                return ((C0367y) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean mo244a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof C0367y) {
                return ((C0367y) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    /* compiled from: ViewParentCompat */
    static class C0297a extends C0296e {
        C0297a() {
        }
    }

    /* compiled from: ViewParentCompat */
    static class C0298c extends C0297a {
        C0298c() {
        }
    }

    /* compiled from: ViewParentCompat */
    static class C0299d extends C0298c {
        C0299d() {
        }

        public boolean mo246a(ViewParent viewParent, View view, View view2, int i) {
            return av.m1398a(viewParent, view, view2, i);
        }

        public void mo247b(ViewParent viewParent, View view, View view2, int i) {
            av.m1399b(viewParent, view, view2, i);
        }

        public void mo241a(ViewParent viewParent, View view) {
            av.m1393a(viewParent, view);
        }

        public void mo242a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            av.m1394a(viewParent, view, i, i2, i3, i4);
        }

        public void mo243a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            av.m1395a(viewParent, view, i, i2, iArr);
        }

        public boolean mo245a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return av.m1397a(viewParent, view, f, f2, z);
        }

        public boolean mo244a(ViewParent viewParent, View view, float f, float f2) {
            return av.m1396a(viewParent, view, f, f2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f556a = new C0299d();
        } else if (i >= 19) {
            f556a = new C0298c();
        } else if (i >= 14) {
            f556a = new C0297a();
        } else {
            f556a = new C0296e();
        }
    }

    public static boolean m1391a(ViewParent viewParent, View view, View view2, int i) {
        return f556a.mo246a(viewParent, view, view2, i);
    }

    public static void m1392b(ViewParent viewParent, View view, View view2, int i) {
        f556a.mo247b(viewParent, view, view2, i);
    }

    public static void m1386a(ViewParent viewParent, View view) {
        f556a.mo241a(viewParent, view);
    }

    public static void m1387a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f556a.mo242a(viewParent, view, i, i2, i3, i4);
    }

    public static void m1388a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f556a.mo243a(viewParent, view, i, i2, iArr);
    }

    public static boolean m1390a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f556a.mo245a(viewParent, view, f, f2, z);
    }

    public static boolean m1389a(ViewParent viewParent, View view, float f, float f2) {
        return f556a.mo244a(viewParent, view, f, f2);
    }
}
