package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p013b.C0509a.C0498a;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

/* compiled from: AppCompatButton */
public class C0623h extends Button implements ad {
    private final C0632l f1651a;
    private final C0622g f1652b;
    private final C0651y f1653c;

    public C0623h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.buttonStyle);
    }

    public C0623h(Context context, AttributeSet attributeSet, int i) {
        super(ao.m2936a(context), attributeSet, i);
        this.f1651a = C0632l.m3110a();
        this.f1652b = new C0622g(this, this.f1651a);
        this.f1652b.m3086a(attributeSet, i);
        this.f1653c = C0651y.m3165a((TextView) this);
        this.f1653c.mo590a(attributeSet, i);
        this.f1653c.mo589a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1652b != null) {
            this.f1652b.m3082a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1652b != null) {
            this.f1652b.m3085a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1652b != null) {
            this.f1652b.m3083a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1652b != null ? this.f1652b.m3081a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1652b != null) {
            this.f1652b.m3084a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1652b != null ? this.f1652b.m3087b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1652b != null) {
            this.f1652b.m3089c();
        }
        if (this.f1653c != null) {
            this.f1653c.mo589a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1653c != null) {
            this.f1653c.m3167a(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f1653c != null) {
            this.f1653c.m3170a(z);
        }
    }
}
