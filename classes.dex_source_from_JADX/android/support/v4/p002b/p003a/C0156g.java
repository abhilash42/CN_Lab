package android.support.v4.p002b.p003a;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatKitKat */
class C0156g {
    public static void m680a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m681a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m682b(Drawable drawable) {
        if (drawable instanceof C0004o) {
            return drawable;
        }
        return new C0167m(drawable);
    }

    public static int m683c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
