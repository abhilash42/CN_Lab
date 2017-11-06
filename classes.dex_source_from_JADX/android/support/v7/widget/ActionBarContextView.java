package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.aw;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0503f;
import android.support.v7.p013b.C0509a.C0505h;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.C0494b;
import android.support.v7.view.menu.C0538f;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0556a {
    private CharSequence f1221g;
    private CharSequence f1222h;
    private View f1223i;
    private View f1224j;
    private LinearLayout f1225k;
    private TextView f1226l;
    private TextView f1227m;
    private int f1228n;
    private int f1229o;
    private boolean f1230p;
    private int f1231q;

    public /* bridge */ /* synthetic */ aw mo500a(int i, long j) {
        return super.mo500a(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0498a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ar a = ar.m2940a(context, attributeSet, C0508k.ActionMode, i, 0);
        setBackgroundDrawable(a.m2943a(C0508k.ActionMode_background));
        this.f1228n = a.m2956g(C0508k.ActionMode_titleTextStyle, 0);
        this.f1229o = a.m2956g(C0508k.ActionMode_subtitleTextStyle, 0);
        this.e = a.m2954f(C0508k.ActionMode_height, 0);
        this.f1231q = a.m2956g(C0508k.ActionMode_closeItemLayout, C0505h.abc_action_mode_close_item_material);
        a.m2944a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m3053e();
            this.d.m3055g();
        }
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f1224j != null) {
            removeView(this.f1224j);
        }
        this.f1224j = view;
        if (!(view == null || this.f1225k == null)) {
            removeView(this.f1225k);
            this.f1225k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1221g = charSequence;
        m2594e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1222h = charSequence;
        m2594e();
    }

    public CharSequence getTitle() {
        return this.f1221g;
    }

    public CharSequence getSubtitle() {
        return this.f1222h;
    }

    private void m2594e() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.f1225k == null) {
            LayoutInflater.from(getContext()).inflate(C0505h.abc_action_bar_title_item, this);
            this.f1225k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1226l = (TextView) this.f1225k.findViewById(C0503f.action_bar_title);
            this.f1227m = (TextView) this.f1225k.findViewById(C0503f.action_bar_subtitle);
            if (this.f1228n != 0) {
                this.f1226l.setTextAppearance(getContext(), this.f1228n);
            }
            if (this.f1229o != 0) {
                this.f1227m.setTextAppearance(getContext(), this.f1229o);
            }
        }
        this.f1226l.setText(this.f1221g);
        this.f1227m.setText(this.f1222h);
        Object obj2 = !TextUtils.isEmpty(this.f1221g) ? 1 : null;
        if (TextUtils.isEmpty(this.f1222h)) {
            obj = null;
        }
        TextView textView = this.f1227m;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.f1225k;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.f1225k.getParent() == null) {
            addView(this.f1225k);
        }
    }

    public void m2596a(final C0494b c0494b) {
        if (this.f1223i == null) {
            this.f1223i = LayoutInflater.from(getContext()).inflate(this.f1231q, this, false);
            addView(this.f1223i);
        } else if (this.f1223i.getParent() == null) {
            addView(this.f1223i);
        }
        this.f1223i.findViewById(C0503f.action_mode_close_button).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView f1212b;

            public void onClick(View view) {
                c0494b.mo431c();
            }
        });
        C0538f c0538f = (C0538f) c0494b.mo428b();
        if (this.d != null) {
            this.d.m3054f();
        }
        this.d = new C0614d(getContext());
        this.d.m3050c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c0538f.m2467a(this.d, this.b);
        this.c = (ActionMenuView) this.d.mo575a((ViewGroup) this);
        this.c.setBackgroundDrawable(null);
        addView(this.c, layoutParams);
    }

    public void m2598b() {
        if (this.f1223i == null) {
            m2599c();
        }
    }

    public void m2599c() {
        removeAllViews();
        this.f1224j = null;
        this.c = null;
    }

    public boolean mo501a() {
        if (this.d != null) {
            return this.d.m3052d();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.e > 0 ? this.e : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f1223i != null) {
                a = m2590a(this.f1223i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1223i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m2590a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1225k != null && this.f1224j == null) {
                if (this.f1230p) {
                    this.f1225k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f1225k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f1225k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m2590a(this.f1225k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1224j != null) {
                int min;
                LayoutParams layoutParams = this.f1224j.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.f1224j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = au.m3012a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1223i == null || this.f1223i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1223i.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0556a.m2587a(paddingRight, i5, a);
            i5 = C0556a.m2587a(m2591a(this.f1223i, i5, paddingTop, paddingTop2, a) + i5, i6, a);
        }
        if (!(this.f1225k == null || this.f1224j != null || this.f1225k.getVisibility() == 8)) {
            i5 += m2591a(this.f1225k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f1224j != null) {
            int a2 = m2591a(this.f1224j, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m2591a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1221g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1230p) {
            requestLayout();
        }
        this.f1230p = z;
    }

    public boolean m2600d() {
        return this.f1230p;
    }
}
