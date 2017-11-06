package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p012a.C0432a.C0431c;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.view.C0513a;
import android.support.v7.widget.af.C0563a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: ScrollingTabContainerView */
public class ak extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f1513j = new DecelerateInterpolator();
    Runnable f1514a;
    int f1515b;
    int f1516c;
    private C0598b f1517d;
    private af f1518e;
    private Spinner f1519f;
    private boolean f1520g;
    private int f1521h;
    private int f1522i;

    /* compiled from: ScrollingTabContainerView */
    private class C0597a extends BaseAdapter {
        final /* synthetic */ ak f1505a;

        private C0597a(ak akVar) {
            this.f1505a = akVar;
        }

        public int getCount() {
            return this.f1505a.f1518e.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0599c) this.f1505a.f1518e.getChildAt(i)).m2897b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.f1505a.m2899a((C0431c) getItem(i), true);
            }
            ((C0599c) view).m2896a((C0431c) getItem(i));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView */
    private class C0598b implements OnClickListener {
        final /* synthetic */ ak f1506a;

        private C0598b(ak akVar) {
            this.f1506a = akVar;
        }

        public void onClick(View view) {
            ((C0599c) view).m2897b().m1908d();
            int childCount = this.f1506a.f1518e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean z;
                View childAt = this.f1506a.f1518e.getChildAt(i);
                if (childAt == view) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    /* compiled from: ScrollingTabContainerView */
    private class C0599c extends af implements OnLongClickListener {
        final /* synthetic */ ak f1507a;
        private final int[] f1508b = new int[]{16842964};
        private C0431c f1509c;
        private TextView f1510d;
        private ImageView f1511e;
        private View f1512f;

        public C0599c(ak akVar, Context context, C0431c c0431c, boolean z) {
            this.f1507a = akVar;
            super(context, null, C0498a.actionBarTabStyle);
            this.f1509c = c0431c;
            ar a = ar.m2940a(context, null, this.f1508b, C0498a.actionBarTabStyle, 0);
            if (a.m2955f(0)) {
                setBackgroundDrawable(a.m2943a(0));
            }
            a.m2944a();
            if (z) {
                setGravity(8388627);
            }
            m2895a();
        }

        public void m2896a(C0431c c0431c) {
            this.f1509c = c0431c;
            m2895a();
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0431c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(C0431c.class.getName());
            }
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f1507a.f1515b > 0 && getMeasuredWidth() > this.f1507a.f1515b) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f1507a.f1515b, 1073741824), i2);
            }
        }

        public void m2895a() {
            C0431c c0431c = this.f1509c;
            View c = c0431c.m1907c();
            if (c != null) {
                C0599c parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f1512f = c;
                if (this.f1510d != null) {
                    this.f1510d.setVisibility(8);
                }
                if (this.f1511e != null) {
                    this.f1511e.setVisibility(8);
                    this.f1511e.setImageDrawable(null);
                    return;
                }
                return;
            }
            boolean z;
            if (this.f1512f != null) {
                removeView(this.f1512f);
                this.f1512f = null;
            }
            Drawable a = c0431c.m1905a();
            CharSequence b = c0431c.m1906b();
            if (a != null) {
                if (this.f1511e == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams c0563a = new C0563a(-2, -2);
                    c0563a.f1265h = 16;
                    imageView.setLayoutParams(c0563a);
                    addView(imageView, 0);
                    this.f1511e = imageView;
                }
                this.f1511e.setImageDrawable(a);
                this.f1511e.setVisibility(0);
            } else if (this.f1511e != null) {
                this.f1511e.setVisibility(8);
                this.f1511e.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(b)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.f1510d == null) {
                    imageView = new aa(getContext(), null, C0498a.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    c0563a = new C0563a(-2, -2);
                    c0563a.f1265h = 16;
                    imageView.setLayoutParams(c0563a);
                    addView(imageView);
                    this.f1510d = imageView;
                }
                this.f1510d.setText(b);
                this.f1510d.setVisibility(0);
            } else if (this.f1510d != null) {
                this.f1510d.setVisibility(8);
                this.f1510d.setText(null);
            }
            if (this.f1511e != null) {
                this.f1511e.setContentDescription(c0431c.m1909e());
            }
            if (z || TextUtils.isEmpty(c0431c.m1909e())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f1509c.m1909e(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public C0431c m2897b() {
            return this.f1509c;
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f1518e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1515b = -1;
        } else {
            if (childCount > 2) {
                this.f1515b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f1515b = MeasureSpec.getSize(i) / 2;
            }
            this.f1515b = Math.min(this.f1515b, this.f1516c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f1521h, 1073741824);
        if (z || !this.f1520g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f1518e.measure(0, mode);
            if (this.f1518e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m2902b();
            } else {
                m2903c();
            }
        } else {
            m2903c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f1522i);
        }
    }

    private boolean m2901a() {
        return this.f1519f != null && this.f1519f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f1520g = z;
    }

    private void m2902b() {
        if (!m2901a()) {
            if (this.f1519f == null) {
                this.f1519f = m2904d();
            }
            removeView(this.f1518e);
            addView(this.f1519f, new LayoutParams(-2, -1));
            if (this.f1519f.getAdapter() == null) {
                this.f1519f.setAdapter(new C0597a());
            }
            if (this.f1514a != null) {
                removeCallbacks(this.f1514a);
                this.f1514a = null;
            }
            this.f1519f.setSelection(this.f1522i);
        }
    }

    private boolean m2903c() {
        if (m2901a()) {
            removeView(this.f1519f);
            addView(this.f1518e, new LayoutParams(-2, -1));
            setTabSelected(this.f1519f.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.f1522i = i;
        int childCount = this.f1518e.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.f1518e.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                m2905a(i);
            }
        }
        if (this.f1519f != null && i >= 0) {
            this.f1519f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f1521h = i;
        requestLayout();
    }

    private Spinner m2904d() {
        Spinner c0650x = new C0650x(getContext(), null, C0498a.actionDropDownStyle);
        c0650x.setLayoutParams(new C0563a(-2, -1));
        c0650x.setOnItemSelectedListener(this);
        return c0650x;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        C0513a a = C0513a.m2293a(getContext());
        setContentHeight(a.m2298e());
        this.f1516c = a.m2300g();
    }

    public void m2905a(int i) {
        final View childAt = this.f1518e.getChildAt(i);
        if (this.f1514a != null) {
            removeCallbacks(this.f1514a);
        }
        this.f1514a = new Runnable(this) {
            final /* synthetic */ ak f1504b;

            public void run() {
                this.f1504b.smoothScrollTo(childAt.getLeft() - ((this.f1504b.getWidth() - childAt.getWidth()) / 2), 0);
                this.f1504b.f1514a = null;
            }
        };
        post(this.f1514a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1514a != null) {
            post(this.f1514a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1514a != null) {
            removeCallbacks(this.f1514a);
        }
    }

    private C0599c m2899a(C0431c c0431c, boolean z) {
        C0599c c0599c = new C0599c(this, getContext(), c0431c, z);
        if (z) {
            c0599c.setBackgroundDrawable(null);
            c0599c.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1521h));
        } else {
            c0599c.setFocusable(true);
            if (this.f1517d == null) {
                this.f1517d = new C0598b();
            }
            c0599c.setOnClickListener(this.f1517d);
        }
        return c0599c;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0599c) view).m2897b().m1908d();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
