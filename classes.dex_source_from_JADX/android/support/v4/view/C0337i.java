package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* compiled from: LayoutInflaterCompat */
public final class C0337i {
    static final C0333a f586a;

    /* compiled from: LayoutInflaterCompat */
    interface C0333a {
        C0124m mo274a(LayoutInflater layoutInflater);

        void mo275a(LayoutInflater layoutInflater, C0124m c0124m);
    }

    /* compiled from: LayoutInflaterCompat */
    static class C0334b implements C0333a {
        C0334b() {
        }

        public void mo275a(LayoutInflater layoutInflater, C0124m c0124m) {
            C0339j.m1548a(layoutInflater, c0124m);
        }

        public C0124m mo274a(LayoutInflater layoutInflater) {
            return C0339j.m1547a(layoutInflater);
        }
    }

    /* compiled from: LayoutInflaterCompat */
    static class C0335c extends C0334b {
        C0335c() {
        }

        public void mo275a(LayoutInflater layoutInflater, C0124m c0124m) {
            C0341k.m1549a(layoutInflater, c0124m);
        }
    }

    /* compiled from: LayoutInflaterCompat */
    static class C0336d extends C0335c {
        C0336d() {
        }

        public void mo275a(LayoutInflater layoutInflater, C0124m c0124m) {
            C0342l.m1551a(layoutInflater, c0124m);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f586a = new C0336d();
        } else if (i >= 11) {
            f586a = new C0335c();
        } else {
            f586a = new C0334b();
        }
    }

    public static void m1546a(LayoutInflater layoutInflater, C0124m c0124m) {
        f586a.mo275a(layoutInflater, c0124m);
    }

    public static C0124m m1545a(LayoutInflater layoutInflater) {
        return f586a.mo274a(layoutInflater);
    }
}
