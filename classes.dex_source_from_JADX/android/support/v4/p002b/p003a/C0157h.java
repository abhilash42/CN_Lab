package android.support.v4.p002b.p003a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DrawableCompatLollipop */
class C0157h {
    public static void m685a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m687a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m686a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m688a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m691a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable m684a(Drawable drawable) {
        if (drawable instanceof C0004o) {
            return drawable;
        }
        return new C0169n(drawable);
    }

    public static void m689a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean m692b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m693c(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void m690a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
