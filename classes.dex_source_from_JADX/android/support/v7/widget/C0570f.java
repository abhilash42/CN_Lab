package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p013b.C0509a.C0498a;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/* compiled from: AppCompatAutoCompleteTextView */
public class C0570f extends AutoCompleteTextView implements ad {
    private static final int[] f1329a = new int[]{16843126};
    private C0632l f1330b;
    private C0622g f1331c;
    private C0651y f1332d;

    public C0570f(Context context) {
        this(context, null);
    }

    public C0570f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.autoCompleteTextViewStyle);
    }

    public C0570f(Context context, AttributeSet attributeSet, int i) {
        super(ao.m2936a(context), attributeSet, i);
        this.f1330b = C0632l.m3110a();
        ar a = ar.m2940a(getContext(), attributeSet, f1329a, i, 0);
        if (a.m2955f(0)) {
            setDropDownBackgroundDrawable(a.m2943a(0));
        }
        a.m2944a();
        this.f1331c = new C0622g(this, this.f1330b);
        this.f1331c.m3086a(attributeSet, i);
        this.f1332d = C0651y.m3165a((TextView) this);
        this.f1332d.mo590a(attributeSet, i);
        this.f1332d.mo589a();
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1330b != null) {
            setDropDownBackgroundDrawable(this.f1330b.m3133a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1331c != null) {
            this.f1331c.m3082a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1331c != null) {
            this.f1331c.m3085a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1331c != null) {
            this.f1331c.m3083a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1331c != null ? this.f1331c.m3081a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1331c != null) {
            this.f1331c.m3084a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1331c != null ? this.f1331c.m3087b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1331c != null) {
            this.f1331c.m3089c();
        }
        if (this.f1332d != null) {
            this.f1332d.mo589a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1332d != null) {
            this.f1332d.m3167a(context, i);
        }
    }
}
