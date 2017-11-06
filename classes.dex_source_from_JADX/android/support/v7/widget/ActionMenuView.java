package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0530m;
import android.support.v7.view.menu.C0532l.C0473a;
import android.support.v7.view.menu.C0538f;
import android.support.v7.view.menu.C0538f.C0457a;
import android.support.v7.view.menu.C0538f.C0529b;
import android.support.v7.view.menu.C0541h;
import android.support.v7.widget.af.C0563a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends af implements C0529b, C0530m {
    private C0538f f1288a;
    private Context f1289b;
    private int f1290c;
    private boolean f1291d;
    private C0614d f1292e;
    private C0473a f1293f;
    private C0457a f1294g;
    private boolean f1295h;
    private int f1296i;
    private int f1297j;
    private int f1298k;
    private C0566e f1299l;

    public interface C0528a {
        boolean mo454c();

        boolean mo455d();
    }

    private class C0562b implements C0473a {
        final /* synthetic */ ActionMenuView f1263a;

        private C0562b(ActionMenuView actionMenuView) {
            this.f1263a = actionMenuView;
        }

        public void mo401a(C0538f c0538f, boolean z) {
        }

        public boolean mo402a(C0538f c0538f) {
            return false;
        }
    }

    public static class C0564c extends C0563a {
        @ExportedProperty
        public boolean f1266a;
        @ExportedProperty
        public int f1267b;
        @ExportedProperty
        public int f1268c;
        @ExportedProperty
        public boolean f1269d;
        @ExportedProperty
        public boolean f1270e;
        boolean f1271f;

        public C0564c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0564c(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0564c(C0564c c0564c) {
            super(c0564c);
            this.f1266a = c0564c.f1266a;
        }

        public C0564c(int i, int i2) {
            super(i, i2);
            this.f1266a = false;
        }
    }

    private class C0565d implements C0457a {
        final /* synthetic */ ActionMenuView f1272a;

        private C0565d(ActionMenuView actionMenuView) {
            this.f1272a = actionMenuView;
        }

        public boolean mo379a(C0538f c0538f, MenuItem menuItem) {
            return this.f1272a.f1299l != null && this.f1272a.f1299l.mo529a(menuItem);
        }

        public void mo375a(C0538f c0538f) {
            if (this.f1272a.f1294g != null) {
                this.f1272a.f1294g.mo375a(c0538f);
            }
        }
    }

    public interface C0566e {
        boolean mo529a(MenuItem menuItem);
    }

    public /* synthetic */ C0563a mo519b(AttributeSet attributeSet) {
        return m2669a(attributeSet);
    }

    protected /* synthetic */ C0563a mo520b(LayoutParams layoutParams) {
        return m2670a(layoutParams);
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m2676b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2669a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m2670a(layoutParams);
    }

    protected /* synthetic */ C0563a mo525j() {
        return m2676b();
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1297j = (int) (56.0f * f);
        this.f1298k = (int) (f * 4.0f);
        this.f1289b = context;
        this.f1290c = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f1290c != i) {
            this.f1290c = i;
            if (i == 0) {
                this.f1289b = getContext();
            } else {
                this.f1289b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1290c;
    }

    public void setPresenter(C0614d c0614d) {
        this.f1292e = c0614d;
        this.f1292e.m3042a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f1292e != null) {
            this.f1292e.mo474b(false);
            if (this.f1292e.m3056h()) {
                this.f1292e.m3053e();
                this.f1292e.m3052d();
            }
        }
    }

    public void setOnMenuItemClickListener(C0566e c0566e) {
        this.f1299l = c0566e;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f1295h;
        this.f1295h = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1295h) {
            this.f1296i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1295h || this.f1288a == null || size == this.f1296i)) {
            this.f1296i = size;
            this.f1288a.m2478b(true);
        }
        int childCount = getChildCount();
        if (!this.f1295h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0564c c0564c = (C0564c) getChildAt(i3).getLayoutParams();
                c0564c.rightMargin = 0;
                c0564c.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m2668c(i, i2);
    }

    private void m2668c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f1297j;
        size = i3 % this.f1297j;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        C0564c c0564c;
        Object obj;
        Object obj2;
        int i6 = this.f1297j + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj3 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            long j2;
            int i12;
            int i13;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i11 = paddingLeft;
                j2 = j;
                i12 = i7;
                i13 = i4;
                i4 = i8;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f1298k, 0, this.f1298k, 0);
                }
                c0564c = (C0564c) childAt.getLayoutParams();
                c0564c.f1271f = false;
                c0564c.f1268c = 0;
                c0564c.f1267b = 0;
                c0564c.f1269d = false;
                c0564c.leftMargin = 0;
                c0564c.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m2386b();
                c0564c.f1270e = z2;
                if (c0564c.f1266a) {
                    paddingLeft = 1;
                } else {
                    paddingLeft = i4;
                }
                int a = m2665a(childAt, i6, paddingLeft, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                if (c0564c.f1269d) {
                    paddingLeft = i9 + 1;
                } else {
                    paddingLeft = i9;
                }
                if (c0564c.f1266a) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                int i14 = i4 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = paddingLeft;
                    obj3 = obj;
                    j2 = j3;
                    i4 = i8;
                    i11 = i5;
                } else {
                    i11 = i5;
                    i4 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj3 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            }
            i10++;
            i8 = i4;
            i7 = i12;
            i4 = i13;
            j = j2;
            paddingLeft = i11;
        }
        if (obj3 == null || paddingLeft != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0564c = (C0564c) getChildAt(i15).getLayoutParams();
                if (!c0564c.f1269d) {
                    size = i4;
                    i4 = i5;
                } else if (c0564c.f1267b < i5) {
                    i4 = c0564c.f1267b;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (c0564c.f1267b == i5) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i5;
                } else {
                    size = i4;
                    i4 = i5;
                }
                i15++;
                i5 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                c0564c = (C0564c) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj2 != null && c0564c.f1270e && i4 == 1) {
                        childAt2.setPadding(this.f1298k + i6, 0, this.f1298k, 0);
                    }
                    c0564c.f1267b++;
                    c0564c.f1271f = true;
                    size = i4 - 1;
                } else if (c0564c.f1267b == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj3 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj2 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0564c) getChildAt(0).getLayoutParams()).f1270e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0564c) getChildAt(childCount - 1).getLayoutParams()).f1270e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i4 = 0;
                    obj2 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj2;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0564c = (C0564c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0564c.f1268c = paddingLeft;
                                c0564c.f1271f = true;
                                if (i4 == 0 && !c0564c.f1270e) {
                                    c0564c.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0564c.f1266a) {
                                if (i4 != 0) {
                                    c0564c.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0564c.rightMargin = paddingLeft / 2;
                                }
                                obj = obj2;
                            } else {
                                c0564c.f1268c = paddingLeft;
                                c0564c.f1271f = true;
                                c0564c.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj2 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj2 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0564c = (C0564c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0564c.f1268c = paddingLeft;
                        c0564c.f1271f = true;
                        c0564c.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0564c.f1266a) {
                        if (i4 != 0) {
                            c0564c.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0564c.rightMargin = paddingLeft / 2;
                        }
                        obj = obj2;
                    } else {
                        c0564c.f1268c = paddingLeft;
                        c0564c.f1271f = true;
                        c0564c.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj2;
                }
                i4++;
                obj2 = obj;
            }
        }
        if (obj2 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0564c = (C0564c) childAt.getLayoutParams();
                if (c0564c.f1271f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0564c.f1268c + (c0564c.f1267b * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    static int m2665a(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        C0564c c0564c = (C0564c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.m2386b()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0564c.f1266a && z) {
            z2 = true;
        }
        c0564c.f1269d = z2;
        c0564c.f1267b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1295h) {
            int i5;
            int i6;
            C0564c c0564c;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = au.m3012a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0564c = (C0564c) childAt.getLayoutParams();
                    if (c0564c.f1266a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m2674a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0564c.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0564c.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0564c.leftMargin) + c0564c.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m2674a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0564c = (C0564c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0564c.f1266a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0564c.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0564c.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0564c = (C0564c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0564c.f1266a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0564c.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0564c.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2685i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1292e.m3039a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1292e.m3049c();
    }

    public boolean m2673a() {
        return this.f1291d;
    }

    public void setOverflowReserved(boolean z) {
        this.f1291d = z;
    }

    protected C0564c m2676b() {
        C0564c c0564c = new C0564c(-2, -2);
        c0564c.h = 16;
        return c0564c;
    }

    public C0564c m2669a(AttributeSet attributeSet) {
        return new C0564c(getContext(), attributeSet);
    }

    protected C0564c m2670a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m2676b();
        }
        C0564c c0564c = layoutParams instanceof C0564c ? new C0564c((C0564c) layoutParams) : new C0564c(layoutParams);
        if (c0564c.h > 0) {
            return c0564c;
        }
        c0564c.h = 16;
        return c0564c;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0564c);
    }

    public C0564c m2679c() {
        C0564c b = m2676b();
        b.f1266a = true;
        return b;
    }

    public boolean mo458a(C0541h c0541h) {
        return this.f1288a.m2472a((MenuItem) c0541h, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void mo457a(C0538f c0538f) {
        this.f1288a = c0538f;
    }

    public Menu getMenu() {
        if (this.f1288a == null) {
            Context context = getContext();
            this.f1288a = new C0538f(context);
            this.f1288a.mo492a(new C0565d());
            this.f1292e = new C0614d(context);
            this.f1292e.m3050c(true);
            this.f1292e.m2419a(this.f1293f != null ? this.f1293f : new C0562b());
            this.f1288a.m2467a(this.f1292e, this.f1289b);
            this.f1292e.m3042a(this);
        }
        return this.f1288a;
    }

    public void m2672a(C0473a c0473a, C0457a c0457a) {
        this.f1293f = c0473a;
        this.f1294g = c0457a;
    }

    public C0538f m2680d() {
        return this.f1288a;
    }

    public boolean m2681e() {
        return this.f1292e != null && this.f1292e.m3052d();
    }

    public boolean m2682f() {
        return this.f1292e != null && this.f1292e.m3053e();
    }

    public boolean m2683g() {
        return this.f1292e != null && this.f1292e.m3056h();
    }

    public boolean m2684h() {
        return this.f1292e != null && this.f1292e.m3057i();
    }

    public void m2685i() {
        if (this.f1292e != null) {
            this.f1292e.m3054f();
        }
    }

    protected boolean m2674a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0528a)) {
            z = 0 | ((C0528a) childAt).mo455d();
        }
        return (i <= 0 || !(childAt2 instanceof C0528a)) ? z : ((C0528a) childAt2).mo454c() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1292e.m3051d(z);
    }
}
