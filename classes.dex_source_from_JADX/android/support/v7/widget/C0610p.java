package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageView */
public class C0610p extends ImageView implements ad {
    private C0622g f1596a;
    private C0635o f1597b;

    public C0610p(Context context) {
        this(context, null);
    }

    public C0610p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0610p(Context context, AttributeSet attributeSet, int i) {
        super(ao.m2936a(context), attributeSet, i);
        C0632l a = C0632l.m3110a();
        this.f1596a = new C0622g(this, a);
        this.f1596a.m3086a(attributeSet, i);
        this.f1597b = new C0635o(this, a);
        this.f1597b.m3138a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f1597b.m3137a(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1596a != null) {
            this.f1596a.m3082a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1596a != null) {
            this.f1596a.m3085a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1596a != null) {
            this.f1596a.m3083a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1596a != null ? this.f1596a.m3081a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1596a != null) {
            this.f1596a.m3084a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1596a != null ? this.f1596a.m3087b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1596a != null) {
            this.f1596a.m3089c();
        }
    }
}
