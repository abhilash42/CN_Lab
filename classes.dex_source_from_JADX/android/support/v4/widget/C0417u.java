package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: ScrollerCompat */
public final class C0417u {
    Object f682a;
    C0413a f683b;

    /* compiled from: ScrollerCompat */
    interface C0413a {
        Object mo328a(Context context, Interpolator interpolator);

        void mo329a(Object obj, int i, int i2, int i3, int i4);

        void mo330a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void mo331a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean mo332a(Object obj);

        boolean mo333a(Object obj, int i, int i2, int i3, int i4, int i5, int i6);

        int mo334b(Object obj);

        int mo335c(Object obj);

        float mo336d(Object obj);

        boolean mo337e(Object obj);

        void mo338f(Object obj);

        int mo339g(Object obj);
    }

    /* compiled from: ScrollerCompat */
    static class C0414b implements C0413a {
        C0414b() {
        }

        public Object mo328a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public boolean mo332a(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public int mo334b(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public int mo335c(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public float mo336d(Object obj) {
            return 0.0f;
        }

        public boolean mo337e(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public void mo329a(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        public void mo330a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo331a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo338f(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public int mo339g(Object obj) {
            return ((Scroller) obj).getFinalY();
        }

        public boolean mo333a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return false;
        }
    }

    /* compiled from: ScrollerCompat */
    static class C0415c implements C0413a {
        C0415c() {
        }

        public Object mo328a(Context context, Interpolator interpolator) {
            return C0418v.m1879a(context, interpolator);
        }

        public boolean mo332a(Object obj) {
            return C0418v.m1883a(obj);
        }

        public int mo334b(Object obj) {
            return C0418v.m1885b(obj);
        }

        public int mo335c(Object obj) {
            return C0418v.m1886c(obj);
        }

        public float mo336d(Object obj) {
            return 0.0f;
        }

        public boolean mo337e(Object obj) {
            return C0418v.m1887d(obj);
        }

        public void mo329a(Object obj, int i, int i2, int i3, int i4) {
            C0418v.m1880a(obj, i, i2, i3, i4);
        }

        public void mo330a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            C0418v.m1881a(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo331a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            C0418v.m1882a(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public void mo338f(Object obj) {
            C0418v.m1888e(obj);
        }

        public int mo339g(Object obj) {
            return C0418v.m1889f(obj);
        }

        public boolean mo333a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return C0418v.m1884a(obj, i, i2, i3, i4, i5, i6);
        }
    }

    /* compiled from: ScrollerCompat */
    static class C0416d extends C0415c {
        C0416d() {
        }

        public float mo336d(Object obj) {
            return C0419w.m1890a(obj);
        }
    }

    public static C0417u m1866a(Context context) {
        return C0417u.m1867a(context, null);
    }

    public static C0417u m1867a(Context context, Interpolator interpolator) {
        return new C0417u(VERSION.SDK_INT, context, interpolator);
    }

    private C0417u(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f683b = new C0416d();
        } else if (i >= 9) {
            this.f683b = new C0415c();
        } else {
            this.f683b = new C0414b();
        }
        this.f682a = this.f683b.mo328a(context, interpolator);
    }

    public boolean m1871a() {
        return this.f683b.mo332a(this.f682a);
    }

    public int m1873b() {
        return this.f683b.mo334b(this.f682a);
    }

    public int m1874c() {
        return this.f683b.mo335c(this.f682a);
    }

    public int m1875d() {
        return this.f683b.mo339g(this.f682a);
    }

    public float m1876e() {
        return this.f683b.mo336d(this.f682a);
    }

    public boolean m1877f() {
        return this.f683b.mo337e(this.f682a);
    }

    public void m1868a(int i, int i2, int i3, int i4) {
        this.f683b.mo329a(this.f682a, i, i2, i3, i4);
    }

    public void m1869a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f683b.mo330a(this.f682a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m1870a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f683b.mo331a(this.f682a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m1872a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f683b.mo333a(this.f682a, i, i2, i3, i4, i5, i6);
    }

    public void m1878g() {
        this.f683b.mo338f(this.f682a);
    }
}
