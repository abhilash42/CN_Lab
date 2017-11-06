package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.C0361s;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.view.ba;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0508k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* compiled from: AbsActionBarView */
abstract class C0556a extends ViewGroup {
    protected final C0583a f1213a;
    protected final Context f1214b;
    protected ActionMenuView f1215c;
    protected C0614d f1216d;
    protected int f1217e;
    protected aw f1218f;
    private boolean f1219g;
    private boolean f1220h;

    /* compiled from: AbsActionBarView */
    protected class C0583a implements ba {
        int f1432a;
        final /* synthetic */ C0556a f1433b;
        private boolean f1434c = false;

        protected C0583a(C0556a c0556a) {
            this.f1433b = c0556a;
        }

        public C0583a m2801a(aw awVar, int i) {
            this.f1433b.f1218f = awVar;
            this.f1432a = i;
            return this;
        }

        public void mo260a(View view) {
            super.setVisibility(0);
            this.f1434c = false;
        }

        public void mo261b(View view) {
            if (!this.f1434c) {
                this.f1433b.f1218f = null;
                super.setVisibility(this.f1432a);
            }
        }

        public void mo262c(View view) {
            this.f1434c = true;
        }
    }

    C0556a(Context context) {
        this(context, null);
    }

    C0556a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0556a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1213a = new C0583a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0498a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1214b = context;
        } else {
            this.f1214b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0508k.ActionBar, C0498a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0508k.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1216d != null) {
            this.f1216d.m3038a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0361s.m1615a(motionEvent);
        if (a == 0) {
            this.f1219g = false;
        }
        if (!this.f1219g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1219g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1219g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0361s.m1615a(motionEvent);
        if (a == 9) {
            this.f1220h = false;
        }
        if (!this.f1220h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1220h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1220h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1217e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1217e;
    }

    public int getAnimatedVisibility() {
        if (this.f1218f != null) {
            return this.f1213a.f1432a;
        }
        return getVisibility();
    }

    public aw mo500a(int i, long j) {
        if (this.f1218f != null) {
            this.f1218f.m1461b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ag.m1275b((View) this, 0.0f);
            }
            aw a = ag.m1290l(this).m1454a(1.0f);
            a.m1455a(j);
            a.m1456a(this.f1213a.m2801a(a, i));
            return a;
        }
        a = ag.m1290l(this).m1454a(0.0f);
        a.m1455a(j);
        a.m1456a(this.f1213a.m2801a(a, i));
        return a;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1218f != null) {
                this.f1218f.m1461b();
            }
            super.setVisibility(i);
        }
    }

    public boolean mo501a() {
        if (this.f1216d != null) {
            return this.f1216d.m3052d();
        }
        return false;
    }

    protected int m2590a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected static int m2587a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m2591a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
