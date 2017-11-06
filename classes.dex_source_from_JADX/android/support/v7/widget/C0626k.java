package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p002b.p003a.C0150a;
import android.support.v4.widget.C0380b;
import android.support.v7.p013b.C0509a.C0508k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* compiled from: AppCompatCompoundButtonHelper */
class C0626k {
    private final CompoundButton f1659a;
    private final C0632l f1660b;
    private ColorStateList f1661c = null;
    private Mode f1662d = null;
    private boolean f1663e = false;
    private boolean f1664f = false;
    private boolean f1665g;

    C0626k(CompoundButton compoundButton, C0632l c0632l) {
        this.f1659a = compoundButton;
        this.f1660b = c0632l;
    }

    void m3094a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f1659a.getContext().obtainStyledAttributes(attributeSet, C0508k.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0508k.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C0508k.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f1659a.setButtonDrawable(this.f1660b.m3133a(this.f1659a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C0508k.CompoundButton_buttonTint)) {
                C0380b.m1735a(this.f1659a, obtainStyledAttributes.getColorStateList(C0508k.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0508k.CompoundButton_buttonTintMode)) {
                C0380b.m1736a(this.f1659a, ad.m2835a(obtainStyledAttributes.getInt(C0508k.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    void m3092a(ColorStateList colorStateList) {
        this.f1661c = colorStateList;
        this.f1663e = true;
        m3097d();
    }

    ColorStateList m3091a() {
        return this.f1661c;
    }

    void m3093a(Mode mode) {
        this.f1662d = mode;
        this.f1664f = true;
        m3097d();
    }

    Mode m3095b() {
        return this.f1662d;
    }

    void m3096c() {
        if (this.f1665g) {
            this.f1665g = false;
            return;
        }
        this.f1665g = true;
        m3097d();
    }

    void m3097d() {
        Drawable a = C0380b.m1734a(this.f1659a);
        if (a == null) {
            return;
        }
        if (this.f1663e || this.f1664f) {
            a = C0150a.m668f(a).mutate();
            if (this.f1663e) {
                C0150a.m659a(a, this.f1661c);
            }
            if (this.f1664f) {
                C0150a.m662a(a, this.f1662d);
            }
            if (a.isStateful()) {
                a.setState(this.f1659a.getDrawableState());
            }
            this.f1659a.setButtonDrawable(a);
        }
    }

    int m3090a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0380b.m1734a(this.f1659a);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
