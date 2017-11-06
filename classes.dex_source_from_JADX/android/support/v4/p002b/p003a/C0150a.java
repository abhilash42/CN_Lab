package android.support.v4.p002b.p003a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DrawableCompat */
public final class C0150a {
    static final C0142b f432a;

    /* compiled from: DrawableCompat */
    interface C0142b {
        void mo87a(Drawable drawable);

        void mo88a(Drawable drawable, float f, float f2);

        void mo89a(Drawable drawable, int i);

        void mo90a(Drawable drawable, int i, int i2, int i3, int i4);

        void mo91a(Drawable drawable, ColorStateList colorStateList);

        void mo92a(Drawable drawable, Theme theme);

        void mo93a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);

        void mo94a(Drawable drawable, Mode mode);

        void mo95a(Drawable drawable, boolean z);

        boolean mo96b(Drawable drawable);

        Drawable mo97c(Drawable drawable);

        int mo98d(Drawable drawable);

        int mo99e(Drawable drawable);

        boolean mo100f(Drawable drawable);

        ColorFilter mo101g(Drawable drawable);
    }

    /* compiled from: DrawableCompat */
    static class C0143a implements C0142b {
        C0143a() {
        }

        public void mo87a(Drawable drawable) {
        }

        public void mo95a(Drawable drawable, boolean z) {
        }

        public boolean mo96b(Drawable drawable) {
            return false;
        }

        public void mo88a(Drawable drawable, float f, float f2) {
        }

        public void mo90a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void mo89a(Drawable drawable, int i) {
            C0152c.m672a(drawable, i);
        }

        public void mo91a(Drawable drawable, ColorStateList colorStateList) {
            C0152c.m673a(drawable, colorStateList);
        }

        public void mo94a(Drawable drawable, Mode mode) {
            C0152c.m675a(drawable, mode);
        }

        public Drawable mo97c(Drawable drawable) {
            return C0152c.m671a(drawable);
        }

        public int mo98d(Drawable drawable) {
            return 0;
        }

        public int mo99e(Drawable drawable) {
            return 0;
        }

        public void mo92a(Drawable drawable, Theme theme) {
        }

        public boolean mo100f(Drawable drawable) {
            return false;
        }

        public ColorFilter mo101g(Drawable drawable) {
            return null;
        }

        public void mo93a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0152c.m674a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    /* compiled from: DrawableCompat */
    static class C0144c extends C0143a {
        C0144c() {
        }

        public Drawable mo97c(Drawable drawable) {
            return C0153d.m676a(drawable);
        }
    }

    /* compiled from: DrawableCompat */
    static class C0145d extends C0144c {
        C0145d() {
        }

        public void mo87a(Drawable drawable) {
            C0154e.m677a(drawable);
        }

        public Drawable mo97c(Drawable drawable) {
            return C0154e.m678b(drawable);
        }
    }

    /* compiled from: DrawableCompat */
    static class C0146e extends C0145d {
        C0146e() {
        }

        public int mo98d(Drawable drawable) {
            int a = C0155f.m679a(drawable);
            return a >= 0 ? a : 0;
        }
    }

    /* compiled from: DrawableCompat */
    static class C0147f extends C0146e {
        C0147f() {
        }

        public void mo95a(Drawable drawable, boolean z) {
            C0156g.m680a(drawable, z);
        }

        public boolean mo96b(Drawable drawable) {
            return C0156g.m681a(drawable);
        }

        public Drawable mo97c(Drawable drawable) {
            return C0156g.m682b(drawable);
        }

        public int mo99e(Drawable drawable) {
            return C0156g.m683c(drawable);
        }
    }

    /* compiled from: DrawableCompat */
    static class C0148g extends C0147f {
        C0148g() {
        }

        public void mo88a(Drawable drawable, float f, float f2) {
            C0157h.m685a(drawable, f, f2);
        }

        public void mo90a(Drawable drawable, int i, int i2, int i3, int i4) {
            C0157h.m687a(drawable, i, i2, i3, i4);
        }

        public void mo89a(Drawable drawable, int i) {
            C0157h.m686a(drawable, i);
        }

        public void mo91a(Drawable drawable, ColorStateList colorStateList) {
            C0157h.m688a(drawable, colorStateList);
        }

        public void mo94a(Drawable drawable, Mode mode) {
            C0157h.m691a(drawable, mode);
        }

        public Drawable mo97c(Drawable drawable) {
            return C0157h.m684a(drawable);
        }

        public void mo92a(Drawable drawable, Theme theme) {
            C0157h.m689a(drawable, theme);
        }

        public boolean mo100f(Drawable drawable) {
            return C0157h.m692b(drawable);
        }

        public ColorFilter mo101g(Drawable drawable) {
            return C0157h.m693c(drawable);
        }

        public void mo93a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0157h.m690a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    /* compiled from: DrawableCompat */
    static class C0149h extends C0148g {
        C0149h() {
        }

        public int mo98d(Drawable drawable) {
            return C0151b.m670a(drawable);
        }

        public Drawable mo97c(Drawable drawable) {
            return drawable;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f432a = new C0149h();
        } else if (i >= 21) {
            f432a = new C0148g();
        } else if (i >= 19) {
            f432a = new C0147f();
        } else if (i >= 17) {
            f432a = new C0146e();
        } else if (i >= 11) {
            f432a = new C0145d();
        } else if (i >= 5) {
            f432a = new C0144c();
        } else {
            f432a = new C0143a();
        }
    }

    public static void m655a(Drawable drawable) {
        f432a.mo87a(drawable);
    }

    public static void m663a(Drawable drawable, boolean z) {
        f432a.mo95a(drawable, z);
    }

    public static boolean m664b(Drawable drawable) {
        return f432a.mo96b(drawable);
    }

    public static void m656a(Drawable drawable, float f, float f2) {
        f432a.mo88a(drawable, f, f2);
    }

    public static void m658a(Drawable drawable, int i, int i2, int i3, int i4) {
        f432a.mo90a(drawable, i, i2, i3, i4);
    }

    public static void m657a(Drawable drawable, int i) {
        f432a.mo89a(drawable, i);
    }

    public static void m659a(Drawable drawable, ColorStateList colorStateList) {
        f432a.mo91a(drawable, colorStateList);
    }

    public static void m662a(Drawable drawable, Mode mode) {
        f432a.mo94a(drawable, mode);
    }

    public static int m665c(Drawable drawable) {
        return f432a.mo99e(drawable);
    }

    public static void m660a(Drawable drawable, Theme theme) {
        f432a.mo92a(drawable, theme);
    }

    public static boolean m666d(Drawable drawable) {
        return f432a.mo100f(drawable);
    }

    public static ColorFilter m667e(Drawable drawable) {
        return f432a.mo101g(drawable);
    }

    public static void m661a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f432a.mo93a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable m668f(Drawable drawable) {
        return f432a.mo97c(drawable);
    }

    public static int m669g(Drawable drawable) {
        return f432a.mo98d(drawable);
    }
}
