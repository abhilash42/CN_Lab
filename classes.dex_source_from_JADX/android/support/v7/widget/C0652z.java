package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: AppCompatTextHelperV17 */
class C0652z extends C0651y {
    private static final int[] f1741b = new int[]{16843666, 16843667};
    private ap f1742c;
    private ap f1743d;

    C0652z(TextView textView) {
        super(textView);
    }

    void mo590a(AttributeSet attributeSet, int i) {
        super.mo590a(attributeSet, i);
        Context context = this.a.getContext();
        C0632l a = C0632l.m3110a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1741b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f1742c = C0651y.m3164a(context, a, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f1743d = C0651y.m3164a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }

    void mo589a() {
        super.mo589a();
        if (this.f1742c != null || this.f1743d != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m3168a(compoundDrawablesRelative[0], this.f1742c);
            m3168a(compoundDrawablesRelative[2], this.f1743d);
        }
    }
}
