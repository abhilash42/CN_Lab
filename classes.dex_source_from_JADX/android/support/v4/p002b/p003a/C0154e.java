package android.support.v4.p002b.p003a;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatHoneycomb */
class C0154e {
    public static void m677a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable m678b(Drawable drawable) {
        if (drawable instanceof C0004o) {
            return drawable;
        }
        return new C0165l(drawable);
    }
}
