package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.p016d.C0511a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextHelper */
class C0651y {
    private static final int[] f1734b = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] f1735c = new int[]{C0498a.textAllCaps};
    final TextView f1736a;
    private ap f1737d;
    private ap f1738e;
    private ap f1739f;
    private ap f1740g;

    static C0651y m3165a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new C0652z(textView);
        }
        return new C0651y(textView);
    }

    C0651y(TextView textView) {
        this.f1736a = textView;
    }

    void mo590a(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.f1736a.getContext();
        C0632l a = C0632l.m3110a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1734b, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.f1737d = C0651y.m3164a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f1738e = C0651y.m3164a(context, a, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f1739f = C0651y.m3164a(context, a, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.f1740g = C0651y.m3164a(context, a, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.f1736a.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0508k.TextAppearance);
                if (obtainStyledAttributes2.hasValue(C0508k.TextAppearance_textAllCaps)) {
                    z = obtainStyledAttributes2.getBoolean(C0508k.TextAppearance_textAllCaps, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f1735c, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                m3170a(z);
            }
        }
    }

    void m3167a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, f1735c);
        if (obtainStyledAttributes.hasValue(0)) {
            m3170a(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    void m3170a(boolean z) {
        this.f1736a.setTransformationMethod(z ? new C0511a(this.f1736a.getContext()) : null);
    }

    void mo589a() {
        if (this.f1737d != null || this.f1738e != null || this.f1739f != null || this.f1740g != null) {
            Drawable[] compoundDrawables = this.f1736a.getCompoundDrawables();
            m3168a(compoundDrawables[0], this.f1737d);
            m3168a(compoundDrawables[1], this.f1738e);
            m3168a(compoundDrawables[2], this.f1739f);
            m3168a(compoundDrawables[3], this.f1740g);
        }
    }

    final void m3168a(Drawable drawable, ap apVar) {
        if (drawable != null && apVar != null) {
            C0632l.m3113a(drawable, apVar, this.f1736a.getDrawableState());
        }
    }

    protected static ap m3164a(Context context, C0632l c0632l, int i) {
        ColorStateList b = c0632l.m3136b(context, i);
        if (b == null) {
            return null;
        }
        ap apVar = new ap();
        apVar.f1559d = true;
        apVar.f1556a = b;
        return apVar;
    }
}
