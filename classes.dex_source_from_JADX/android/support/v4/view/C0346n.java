package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MarginLayoutParamsCompat */
public final class C0346n {
    static final C0343a f590a;

    /* compiled from: MarginLayoutParamsCompat */
    interface C0343a {
        int mo276a(MarginLayoutParams marginLayoutParams);

        int mo277b(MarginLayoutParams marginLayoutParams);
    }

    /* compiled from: MarginLayoutParamsCompat */
    static class C0344b implements C0343a {
        C0344b() {
        }

        public int mo276a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public int mo277b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    /* compiled from: MarginLayoutParamsCompat */
    static class C0345c implements C0343a {
        C0345c() {
        }

        public int mo276a(MarginLayoutParams marginLayoutParams) {
            return C0347o.m1560a(marginLayoutParams);
        }

        public int mo277b(MarginLayoutParams marginLayoutParams) {
            return C0347o.m1561b(marginLayoutParams);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f590a = new C0345c();
        } else {
            f590a = new C0344b();
        }
    }

    public static int m1558a(MarginLayoutParams marginLayoutParams) {
        return f590a.mo276a(marginLayoutParams);
    }

    public static int m1559b(MarginLayoutParams marginLayoutParams) {
        return f590a.mo277b(marginLayoutParams);
    }
}
