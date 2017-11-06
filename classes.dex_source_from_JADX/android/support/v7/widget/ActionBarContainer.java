package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p013b.C0509a.C0503f;
import android.support.v7.p013b.C0509a.C0508k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable f1201a;
    Drawable f1202b;
    Drawable f1203c;
    boolean f1204d;
    boolean f1205e;
    private boolean f1206f;
    private View f1207g;
    private View f1208h;
    private View f1209i;
    private int f1210j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable c0604c;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            c0604c = new C0604c(this);
        } else {
            c0604c = new C0603b(this);
        }
        setBackgroundDrawable(c0604c);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0508k.ActionBar);
        this.f1201a = obtainStyledAttributes.getDrawable(C0508k.ActionBar_background);
        this.f1202b = obtainStyledAttributes.getDrawable(C0508k.ActionBar_backgroundStacked);
        this.f1210j = obtainStyledAttributes.getDimensionPixelSize(C0508k.ActionBar_height, -1);
        if (getId() == C0503f.split_action_bar) {
            this.f1204d = true;
            this.f1203c = obtainStyledAttributes.getDrawable(C0508k.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f1204d ? this.f1203c == null : this.f1201a == null && this.f1202b == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1208h = findViewById(C0503f.action_bar);
        this.f1209i = findViewById(C0503f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1201a != null) {
            this.f1201a.setCallback(null);
            unscheduleDrawable(this.f1201a);
        }
        this.f1201a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1208h != null) {
                this.f1201a.setBounds(this.f1208h.getLeft(), this.f1208h.getTop(), this.f1208h.getRight(), this.f1208h.getBottom());
            }
        }
        if (this.f1204d) {
            if (this.f1203c != null) {
                z = false;
            }
        } else if (!(this.f1201a == null && this.f1202b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1202b != null) {
            this.f1202b.setCallback(null);
            unscheduleDrawable(this.f1202b);
        }
        this.f1202b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1205e && this.f1202b != null) {
                this.f1202b.setBounds(this.f1207g.getLeft(), this.f1207g.getTop(), this.f1207g.getRight(), this.f1207g.getBottom());
            }
        }
        if (this.f1204d) {
            if (this.f1203c != null) {
                z = false;
            }
        } else if (!(this.f1201a == null && this.f1202b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1203c != null) {
            this.f1203c.setCallback(null);
            unscheduleDrawable(this.f1203c);
        }
        this.f1203c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1204d && this.f1203c != null) {
                this.f1203c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1204d) {
            if (this.f1203c != null) {
                z = false;
            }
        } else if (!(this.f1201a == null && this.f1202b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1201a != null) {
            this.f1201a.setVisible(z, false);
        }
        if (this.f1202b != null) {
            this.f1202b.setVisible(z, false);
        }
        if (this.f1203c != null) {
            this.f1203c.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1201a && !this.f1204d) || ((drawable == this.f1202b && this.f1205e) || ((drawable == this.f1203c && this.f1204d) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1201a != null && this.f1201a.isStateful()) {
            this.f1201a.setState(getDrawableState());
        }
        if (this.f1202b != null && this.f1202b.isStateful()) {
            this.f1202b.setState(getDrawableState());
        }
        if (this.f1203c != null && this.f1203c.isStateful()) {
            this.f1203c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1201a != null) {
                this.f1201a.jumpToCurrentState();
            }
            if (this.f1202b != null) {
                this.f1202b.jumpToCurrentState();
            }
            if (this.f1203c != null) {
                this.f1203c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f1206f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1206f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ak akVar) {
        if (this.f1207g != null) {
            removeView(this.f1207g);
        }
        this.f1207g = akVar;
        if (akVar != null) {
            addView(akVar);
            LayoutParams layoutParams = akVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            akVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f1207g;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private boolean m2585a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m2586b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.f1208h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1210j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1210j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1208h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f1207g != null && this.f1207g.getVisibility() != 8 && mode != 1073741824) {
                int b;
                if (!m2585a(this.f1208h)) {
                    b = m2586b(this.f1208h);
                } else if (m2585a(this.f1209i)) {
                    b = 0;
                } else {
                    b = m2586b(this.f1209i);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m2586b(this.f1207g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1207g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1204d) {
            int i6;
            if (this.f1201a != null) {
                if (this.f1208h.getVisibility() == 0) {
                    this.f1201a.setBounds(this.f1208h.getLeft(), this.f1208h.getTop(), this.f1208h.getRight(), this.f1208h.getBottom());
                } else if (this.f1209i == null || this.f1209i.getVisibility() != 0) {
                    this.f1201a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1201a.setBounds(this.f1209i.getLeft(), this.f1209i.getTop(), this.f1209i.getRight(), this.f1209i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f1205e = z2;
            if (!z2 || this.f1202b == null) {
                i5 = i6;
            } else {
                this.f1202b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1203c != null) {
            this.f1203c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
