package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p013b.C0509a.C0498a;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

/* compiled from: AppCompatMultiAutoCompleteTextView */
public class C0636q extends MultiAutoCompleteTextView implements ad {
    private static final int[] f1688a = new int[]{16843126};
    private C0632l f1689b;
    private C0622g f1690c;
    private C0651y f1691d;

    public C0636q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.autoCompleteTextViewStyle);
    }

    public C0636q(Context context, AttributeSet attributeSet, int i) {
        super(ao.m2936a(context), attributeSet, i);
        this.f1689b = C0632l.m3110a();
        ar a = ar.m2940a(getContext(), attributeSet, f1688a, i, 0);
        if (a.m2955f(0)) {
            setDropDownBackgroundDrawable(a.m2943a(0));
        }
        a.m2944a();
        this.f1690c = new C0622g(this, this.f1689b);
        this.f1690c.m3086a(attributeSet, i);
        this.f1691d = C0651y.m3165a((TextView) this);
        this.f1691d.mo590a(attributeSet, i);
        this.f1691d.mo589a();
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1689b != null) {
            setDropDownBackgroundDrawable(this.f1689b.m3133a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1690c != null) {
            this.f1690c.m3082a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1690c != null) {
            this.f1690c.m3085a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1690c != null) {
            this.f1690c.m3083a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1690c != null ? this.f1690c.m3081a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1690c != null) {
            this.f1690c.m3084a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1690c != null ? this.f1690c.m3087b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1690c != null) {
            this.f1690c.m3089c();
        }
        if (this.f1691d != null) {
            this.f1691d.mo589a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1691d != null) {
            this.f1691d.m3167a(context, i);
        }
    }
}
