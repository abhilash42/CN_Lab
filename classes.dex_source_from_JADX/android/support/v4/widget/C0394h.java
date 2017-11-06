package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* compiled from: EdgeEffectCompat */
public final class C0394h {
    private static final C0390c f672b;
    private Object f673a;

    /* compiled from: EdgeEffectCompat */
    interface C0390c {
        Object mo311a(Context context);

        void mo312a(Object obj, int i, int i2);

        boolean mo313a(Object obj);

        boolean mo314a(Object obj, float f);

        boolean mo315a(Object obj, float f, float f2);

        boolean mo316a(Object obj, int i);

        boolean mo317a(Object obj, Canvas canvas);

        void mo318b(Object obj);

        boolean mo319c(Object obj);
    }

    /* compiled from: EdgeEffectCompat */
    static class C0391a implements C0390c {
        C0391a() {
        }

        public Object mo311a(Context context) {
            return null;
        }

        public void mo312a(Object obj, int i, int i2) {
        }

        public boolean mo313a(Object obj) {
            return true;
        }

        public void mo318b(Object obj) {
        }

        public boolean mo314a(Object obj, float f) {
            return false;
        }

        public boolean mo319c(Object obj) {
            return false;
        }

        public boolean mo316a(Object obj, int i) {
            return false;
        }

        public boolean mo317a(Object obj, Canvas canvas) {
            return false;
        }

        public boolean mo315a(Object obj, float f, float f2) {
            return false;
        }
    }

    /* compiled from: EdgeEffectCompat */
    static class C0392b implements C0390c {
        C0392b() {
        }

        public Object mo311a(Context context) {
            return C0395i.m1793a(context);
        }

        public void mo312a(Object obj, int i, int i2) {
            C0395i.m1794a(obj, i, i2);
        }

        public boolean mo313a(Object obj) {
            return C0395i.m1795a(obj);
        }

        public void mo318b(Object obj) {
            C0395i.m1799b(obj);
        }

        public boolean mo314a(Object obj, float f) {
            return C0395i.m1796a(obj, f);
        }

        public boolean mo319c(Object obj) {
            return C0395i.m1800c(obj);
        }

        public boolean mo316a(Object obj, int i) {
            return C0395i.m1797a(obj, i);
        }

        public boolean mo317a(Object obj, Canvas canvas) {
            return C0395i.m1798a(obj, canvas);
        }

        public boolean mo315a(Object obj, float f, float f2) {
            return C0395i.m1796a(obj, f);
        }
    }

    /* compiled from: EdgeEffectCompat */
    static class C0393d extends C0392b {
        C0393d() {
        }

        public boolean mo315a(Object obj, float f, float f2) {
            return C0396j.m1801a(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f672b = new C0393d();
        } else if (VERSION.SDK_INT >= 14) {
            f672b = new C0392b();
        } else {
            f672b = new C0391a();
        }
    }

    public C0394h(Context context) {
        this.f673a = f672b.mo311a(context);
    }

    public void m1785a(int i, int i2) {
        f672b.mo312a(this.f673a, i, i2);
    }

    public boolean m1786a() {
        return f672b.mo313a(this.f673a);
    }

    public void m1791b() {
        f672b.mo318b(this.f673a);
    }

    public boolean m1787a(float f) {
        return f672b.mo314a(this.f673a, f);
    }

    public boolean m1788a(float f, float f2) {
        return f672b.mo315a(this.f673a, f, f2);
    }

    public boolean m1792c() {
        return f672b.mo319c(this.f673a);
    }

    public boolean m1789a(int i) {
        return f672b.mo316a(this.f673a, i);
    }

    public boolean m1790a(Canvas canvas) {
        return f672b.mo317a(this.f673a, canvas);
    }
}
