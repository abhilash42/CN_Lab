package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p013b.C0509a.C0498a;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/* compiled from: AppCompatEditText */
public class C0633m extends EditText implements ad {
    private C0632l f1681a;
    private C0622g f1682b;
    private C0651y f1683c;

    public C0633m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.editTextStyle);
    }

    public C0633m(Context context, AttributeSet attributeSet, int i) {
        super(ao.m2936a(context), attributeSet, i);
        this.f1681a = C0632l.m3110a();
        this.f1682b = new C0622g(this, this.f1681a);
        this.f1682b.m3086a(attributeSet, i);
        this.f1683c = C0651y.m3165a((TextView) this);
        this.f1683c.mo590a(attributeSet, i);
        this.f1683c.mo589a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1682b != null) {
            this.f1682b.m3082a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1682b != null) {
            this.f1682b.m3085a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1682b != null) {
            this.f1682b.m3083a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1682b != null ? this.f1682b.m3081a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1682b != null) {
            this.f1682b.m3084a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1682b != null ? this.f1682b.m3087b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1682b != null) {
            this.f1682b.m3089c();
        }
        if (this.f1683c != null) {
            this.f1683c.mo589a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1683c != null) {
            this.f1683c.m3167a(context, i);
        }
    }
}
