package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p013b.C0509a.C0508k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f1427a;
    private int f1428b;
    private WeakReference<View> f1429c;
    private LayoutInflater f1430d;
    private C0582a f1431e;

    public interface C0582a {
        void m2799a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1427a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0508k.ViewStubCompat, i, 0);
        this.f1428b = obtainStyledAttributes.getResourceId(C0508k.ViewStubCompat_android_inflatedId, -1);
        this.f1427a = obtainStyledAttributes.getResourceId(C0508k.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0508k.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f1428b;
    }

    public void setInflatedId(int i) {
        this.f1428b = i;
    }

    public int getLayoutResource() {
        return this.f1427a;
    }

    public void setLayoutResource(int i) {
        this.f1427a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1430d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1430d;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void draw(Canvas canvas) {
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void setVisibility(int i) {
        if (this.f1429c != null) {
            View view = (View) this.f1429c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m2800a();
        }
    }

    public View m2800a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1427a != 0) {
            LayoutInflater layoutInflater;
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f1430d != null) {
                layoutInflater = this.f1430d;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1427a, viewGroup, false);
            if (this.f1428b != -1) {
                inflate.setId(this.f1428b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1429c = new WeakReference(inflate);
            if (this.f1431e != null) {
                this.f1431e.m2799a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(C0582a c0582a) {
        this.f1431e = c0582a;
    }
}
