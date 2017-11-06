package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

/* compiled from: AppCompatCheckedTextView */
public class C0625j extends CheckedTextView {
    private static final int[] f1656a = new int[]{16843016};
    private C0632l f1657b;
    private C0651y f1658c;

    public C0625j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0625j(Context context, AttributeSet attributeSet, int i) {
        super(ao.m2936a(context), attributeSet, i);
        this.f1658c = C0651y.m3165a((TextView) this);
        this.f1658c.mo590a(attributeSet, i);
        this.f1658c.mo589a();
        this.f1657b = C0632l.m3110a();
        ar a = ar.m2940a(getContext(), attributeSet, f1656a, i, 0);
        setCheckMarkDrawable(a.m2943a(0));
        a.m2944a();
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f1657b != null) {
            setCheckMarkDrawable(this.f1657b.m3133a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1658c != null) {
            this.f1658c.m3167a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1658c != null) {
            this.f1658c.mo589a();
        }
    }
}
