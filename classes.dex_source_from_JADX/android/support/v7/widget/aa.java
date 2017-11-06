package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextView */
public class aa extends TextView implements ad {
    private C0632l f1044a;
    private C0622g f1045b;
    private C0651y f1046c;

    public aa(Context context) {
        this(context, null);
    }

    public aa(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public aa(Context context, AttributeSet attributeSet, int i) {
        super(ao.m2936a(context), attributeSet, i);
        this.f1044a = C0632l.m3110a();
        this.f1045b = new C0622g(this, this.f1044a);
        this.f1045b.m3086a(attributeSet, i);
        this.f1046c = C0651y.m3165a((TextView) this);
        this.f1046c.mo590a(attributeSet, i);
        this.f1046c.mo589a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1045b != null) {
            this.f1045b.m3082a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1045b != null) {
            this.f1045b.m3085a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1045b != null) {
            this.f1045b.m3083a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1045b != null ? this.f1045b.m3081a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1045b != null) {
            this.f1045b.m3084a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1045b != null ? this.f1045b.m3087b() : null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1046c != null) {
            this.f1046c.m3167a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1045b != null) {
            this.f1045b.m3089c();
        }
        if (this.f1046c != null) {
            this.f1046c.mo589a();
        }
    }
}
