package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p004a.C0023a;
import android.support.v4.widget.ab;
import android.support.v7.p013b.C0509a.C0498a;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* compiled from: AppCompatCheckBox */
public class C0624i extends CheckBox implements ab {
    private C0632l f1654a;
    private C0626k f1655b;

    public C0624i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.checkboxStyle);
    }

    public C0624i(Context context, AttributeSet attributeSet, int i) {
        super(ao.m2936a(context), attributeSet, i);
        this.f1654a = C0632l.m3110a();
        this.f1655b = new C0626k(this, this.f1654a);
        this.f1655b.m3094a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1655b != null) {
            this.f1655b.m3096c();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f1654a != null ? this.f1654a.m3133a(getContext(), i) : C0023a.m77a(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1655b != null ? this.f1655b.m3090a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1655b != null) {
            this.f1655b.m3092a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f1655b != null ? this.f1655b.m3091a() : null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f1655b != null) {
            this.f1655b.m3093a(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        return this.f1655b != null ? this.f1655b.m3095b() : null;
    }
}
