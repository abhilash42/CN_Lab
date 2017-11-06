package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.support.v7.p013b.C0509a.C0508k;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: AppCompatBackgroundHelper */
class C0622g {
    private final View f1646a;
    private final C0632l f1647b;
    private ap f1648c;
    private ap f1649d;
    private ap f1650e;

    C0622g(View view, C0632l c0632l) {
        this.f1646a = view;
        this.f1647b = c0632l;
    }

    void m3086a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f1646a.getContext().obtainStyledAttributes(attributeSet, C0508k.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0508k.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.f1647b.m3136b(this.f1646a.getContext(), obtainStyledAttributes.getResourceId(C0508k.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    m3088b(b);
                }
            }
            if (obtainStyledAttributes.hasValue(C0508k.ViewBackgroundHelper_backgroundTint)) {
                ag.m1265a(this.f1646a, obtainStyledAttributes.getColorStateList(C0508k.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(C0508k.ViewBackgroundHelper_backgroundTintMode)) {
                ag.m1266a(this.f1646a, ad.m2835a(obtainStyledAttributes.getInt(C0508k.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    void m3082a(int i) {
        m3088b(this.f1647b != null ? this.f1647b.m3136b(this.f1646a.getContext(), i) : null);
    }

    void m3085a(Drawable drawable) {
        m3088b(null);
    }

    void m3083a(ColorStateList colorStateList) {
        if (this.f1649d == null) {
            this.f1649d = new ap();
        }
        this.f1649d.f1556a = colorStateList;
        this.f1649d.f1559d = true;
        m3089c();
    }

    ColorStateList m3081a() {
        return this.f1649d != null ? this.f1649d.f1556a : null;
    }

    void m3084a(Mode mode) {
        if (this.f1649d == null) {
            this.f1649d = new ap();
        }
        this.f1649d.f1557b = mode;
        this.f1649d.f1558c = true;
        m3089c();
    }

    Mode m3087b() {
        return this.f1649d != null ? this.f1649d.f1557b : null;
    }

    void m3089c() {
        Drawable background = this.f1646a.getBackground();
        if (background == null) {
            return;
        }
        if (VERSION.SDK_INT != 21 || !m3080b(background)) {
            if (this.f1649d != null) {
                C0632l.m3113a(background, this.f1649d, this.f1646a.getDrawableState());
            } else if (this.f1648c != null) {
                C0632l.m3113a(background, this.f1648c, this.f1646a.getDrawableState());
            }
        }
    }

    void m3088b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1648c == null) {
                this.f1648c = new ap();
            }
            this.f1648c.f1556a = colorStateList;
            this.f1648c.f1559d = true;
        } else {
            this.f1648c = null;
        }
        m3089c();
    }

    private boolean m3080b(Drawable drawable) {
        if (this.f1650e == null) {
            this.f1650e = new ap();
        }
        ap apVar = this.f1650e;
        apVar.m2938a();
        ColorStateList r = ag.m1296r(this.f1646a);
        if (r != null) {
            apVar.f1559d = true;
            apVar.f1556a = r;
        }
        Mode s = ag.m1297s(this.f1646a);
        if (s != null) {
            apVar.f1558c = true;
            apVar.f1557b = s;
        }
        if (!apVar.f1559d && !apVar.f1558c) {
            return false;
        }
        C0632l.m3113a(drawable, apVar, this.f1646a.getDrawableState());
        return true;
    }
}
