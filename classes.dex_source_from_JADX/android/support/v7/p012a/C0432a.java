package android.support.v7.p012a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.C0494b;
import android.support.v7.view.C0494b.C0476a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: ActionBar */
public abstract class C0432a {

    /* compiled from: ActionBar */
    public static class C0429a extends MarginLayoutParams {
        public int f689a;

        public C0429a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f689a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0508k.ActionBarLayout);
            this.f689a = obtainStyledAttributes.getInt(C0508k.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0429a(int i, int i2) {
            super(i, i2);
            this.f689a = 0;
            this.f689a = 8388627;
        }

        public C0429a(C0429a c0429a) {
            super(c0429a);
            this.f689a = 0;
            this.f689a = c0429a.f689a;
        }

        public C0429a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f689a = 0;
        }
    }

    /* compiled from: ActionBar */
    public interface C0430b {
        void m1904a(boolean z);
    }

    /* compiled from: ActionBar */
    public static abstract class C0431c {
        public abstract Drawable m1905a();

        public abstract CharSequence m1906b();

        public abstract View m1907c();

        public abstract void m1908d();

        public abstract CharSequence m1909e();
    }

    public abstract int mo407a();

    public abstract boolean mo413b();

    public void mo411a(boolean z) {
    }

    public Context mo414c() {
        return null;
    }

    public void mo439b(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public int mo440d() {
        return 0;
    }

    public void mo408a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void mo415c(boolean z) {
    }

    public void mo416d(boolean z) {
    }

    public void mo409a(Configuration configuration) {
    }

    public void mo417e(boolean z) {
    }

    public C0494b mo437a(C0476a c0476a) {
        return null;
    }

    public boolean mo418e() {
        return false;
    }

    public boolean mo412a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean mo419f() {
        return false;
    }

    public void mo410a(CharSequence charSequence) {
    }

    boolean mo420g() {
        return false;
    }

    void mo421h() {
    }
}
