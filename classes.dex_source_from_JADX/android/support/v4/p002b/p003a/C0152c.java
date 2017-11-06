package android.support.v4.p002b.p003a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DrawableCompatBase */
class C0152c {
    public static void m672a(Drawable drawable, int i) {
        if (drawable instanceof C0004o) {
            ((C0004o) drawable).setTint(i);
        }
    }

    public static void m673a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0004o) {
            ((C0004o) drawable).setTintList(colorStateList);
        }
    }

    public static void m675a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0004o) {
            ((C0004o) drawable).setTintMode(mode);
        }
    }

    public static Drawable m671a(Drawable drawable) {
        if (drawable instanceof C0004o) {
            return drawable;
        }
        return new C0161j(drawable);
    }

    public static void m674a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }
}
