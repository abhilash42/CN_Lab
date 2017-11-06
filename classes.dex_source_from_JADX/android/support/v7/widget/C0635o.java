package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.p004a.C0023a;
import android.support.v7.p013b.C0509a.C0508k;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageHelper */
public class C0635o {
    private final ImageView f1686a;
    private final C0632l f1687b;

    public C0635o(ImageView imageView, C0632l c0632l) {
        this.f1686a = imageView;
        this.f1687b = c0632l;
    }

    public void m3138a(AttributeSet attributeSet, int i) {
        ar a = ar.m2940a(this.f1686a.getContext(), attributeSet, C0508k.AppCompatImageView, i, 0);
        try {
            Drawable b = a.m2947b(C0508k.AppCompatImageView_android_src);
            if (b != null) {
                this.f1686a.setImageDrawable(b);
            }
            int g = a.m2956g(C0508k.AppCompatImageView_srcCompat, -1);
            if (g != -1) {
                b = this.f1687b.m3133a(this.f1686a.getContext(), g);
                if (b != null) {
                    this.f1686a.setImageDrawable(b);
                }
            }
            b = this.f1686a.getDrawable();
            if (b != null) {
                ad.m2836a(b);
            }
            a.m2944a();
        } catch (Throwable th) {
            a.m2944a();
        }
    }

    public void m3137a(int i) {
        if (i != 0) {
            Drawable a = this.f1687b != null ? this.f1687b.m3133a(this.f1686a.getContext(), i) : C0023a.m77a(this.f1686a.getContext(), i);
            if (a != null) {
                ad.m2836a(a);
            }
            this.f1686a.setImageDrawable(a);
            return;
        }
        this.f1686a.setImageDrawable(null);
    }
}
