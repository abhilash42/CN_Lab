package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0367y;
import android.support.v4.view.C0368z;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.view.ba;
import android.support.v4.view.bb;
import android.support.v4.widget.C0417u;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0503f;
import android.support.v7.view.menu.C0532l.C0473a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements C0367y, ab {
    static final int[] f1235a = new int[]{C0498a.actionBarSize, 16842841};
    private final Runnable f1236A;
    private final C0368z f1237B;
    private int f1238b;
    private int f1239c;
    private ContentFrameLayout f1240d;
    private ActionBarContainer f1241e;
    private ac f1242f;
    private Drawable f1243g;
    private boolean f1244h;
    private boolean f1245i;
    private boolean f1246j;
    private boolean f1247k;
    private boolean f1248l;
    private int f1249m;
    private int f1250n;
    private final Rect f1251o;
    private final Rect f1252p;
    private final Rect f1253q;
    private final Rect f1254r;
    private final Rect f1255s;
    private final Rect f1256t;
    private C0496a f1257u;
    private final int f1258v;
    private C0417u f1259w;
    private aw f1260x;
    private final ba f1261y;
    private final Runnable f1262z;

    public interface C0496a {
        void mo438a(int i);

        void mo441g(boolean z);

        void mo442l();

        void mo443m();

        void mo444n();

        void mo445o();
    }

    class C05571 extends bb {
        final /* synthetic */ ActionBarOverlayLayout f1232a;

        C05571(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1232a = actionBarOverlayLayout;
        }

        public void mo261b(View view) {
            this.f1232a.f1260x = null;
            this.f1232a.f1248l = false;
        }

        public void mo262c(View view) {
            this.f1232a.f1260x = null;
            this.f1232a.f1248l = false;
        }
    }

    class C05582 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1233a;

        C05582(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1233a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1233a.m2621k();
            this.f1233a.f1260x = ag.m1290l(this.f1233a.f1241e).m1459b(0.0f).m1456a(this.f1233a.f1261y);
        }
    }

    class C05593 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1234a;

        C05593(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1234a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1234a.m2621k();
            this.f1234a.f1260x = ag.m1290l(this.f1234a.f1241e).m1459b((float) (-this.f1234a.f1241e.getHeight())).m1456a(this.f1234a.f1261y);
        }
    }

    public static class C0560b extends MarginLayoutParams {
        public C0560b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0560b(int i, int i2) {
            super(i, i2);
        }

        public C0560b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m2630b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2626a(attributeSet);
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1239c = 0;
        this.f1251o = new Rect();
        this.f1252p = new Rect();
        this.f1253q = new Rect();
        this.f1254r = new Rect();
        this.f1255s = new Rect();
        this.f1256t = new Rect();
        this.f1258v = 600;
        this.f1261y = new C05571(this);
        this.f1262z = new C05582(this);
        this.f1236A = new C05593(this);
        m2614a(context);
        this.f1237B = new C0368z(this);
    }

    private void m2614a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1235a);
        this.f1238b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1243g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1243g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1244h = z;
        this.f1259w = C0417u.m1866a(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2621k();
    }

    public void setActionBarVisibilityCallback(C0496a c0496a) {
        this.f1257u = c0496a;
        if (getWindowToken() != null) {
            this.f1257u.mo438a(this.f1239c);
            if (this.f1250n != 0) {
                onWindowSystemUiVisibilityChanged(this.f1250n);
                ag.m1293o(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f1245i = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f1244h = z2;
    }

    public boolean m2629a() {
        return this.f1245i;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1246j = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m2614a(getContext());
        ag.m1293o(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m2631c();
        int i2 = this.f1250n ^ i;
        this.f1250n = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1257u != null) {
            C0496a c0496a = this.f1257u;
            if (z) {
                z2 = false;
            }
            c0496a.mo441g(z2);
            if (z3 || !z) {
                this.f1257u.mo442l();
            } else {
                this.f1257u.mo443m();
            }
        }
        if ((i2 & 256) != 0 && this.f1257u != null) {
            ag.m1293o(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1239c = i;
        if (this.f1257u != null) {
            this.f1257u.mo438a(i);
        }
    }

    private boolean m2618a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0560b c0560b = (C0560b) view.getLayoutParams();
        if (z && c0560b.leftMargin != rect.left) {
            c0560b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0560b.topMargin != rect.top) {
            c0560b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0560b.rightMargin != rect.right) {
            c0560b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0560b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0560b.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        m2631c();
        if ((ag.m1292n(this) & 256) != 0) {
            a = m2618a(this.f1241e, rect, true, true, false, true);
            this.f1254r.set(rect);
            au.m3011a(this, this.f1254r, this.f1251o);
        } else {
            a = m2618a(this.f1241e, rect, true, true, false, true);
            this.f1254r.set(rect);
            au.m3011a(this, this.f1254r, this.f1251o);
        }
        if (!this.f1252p.equals(this.f1251o)) {
            this.f1252p.set(this.f1251o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected C0560b m2630b() {
        return new C0560b(-1, -1);
    }

    public C0560b m2626a(AttributeSet attributeSet) {
        return new C0560b(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0560b(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0560b;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int i3;
        m2631c();
        measureChildWithMargins(this.f1241e, i, 0, i2, 0);
        C0560b c0560b = (C0560b) this.f1241e.getLayoutParams();
        int max = Math.max(0, (this.f1241e.getMeasuredWidth() + c0560b.leftMargin) + c0560b.rightMargin);
        int max2 = Math.max(0, c0560b.bottomMargin + (this.f1241e.getMeasuredHeight() + c0560b.topMargin));
        int a = au.m3010a(0, ag.m1285g(this.f1241e));
        if ((ag.m1292n(this) & 256) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i3 = this.f1238b;
            if (this.f1246j && this.f1241e.getTabContainer() != null) {
                i3 += this.f1238b;
            }
        } else {
            i3 = this.f1241e.getVisibility() != 8 ? this.f1241e.getMeasuredHeight() : 0;
        }
        this.f1253q.set(this.f1251o);
        this.f1255s.set(this.f1254r);
        Rect rect;
        Rect rect2;
        if (this.f1245i || obj != null) {
            rect = this.f1255s;
            rect.top = i3 + rect.top;
            rect2 = this.f1255s;
            rect2.bottom += 0;
        } else {
            rect = this.f1253q;
            rect.top = i3 + rect.top;
            rect2 = this.f1253q;
            rect2.bottom += 0;
        }
        m2618a(this.f1240d, this.f1253q, true, true, true, true);
        if (!this.f1256t.equals(this.f1255s)) {
            this.f1256t.set(this.f1255s);
            this.f1240d.m2156a(this.f1255s);
        }
        measureChildWithMargins(this.f1240d, i, 0, i2, 0);
        c0560b = (C0560b) this.f1240d.getLayoutParams();
        int max3 = Math.max(max, (this.f1240d.getMeasuredWidth() + c0560b.leftMargin) + c0560b.rightMargin);
        i3 = Math.max(max2, c0560b.bottomMargin + (this.f1240d.getMeasuredHeight() + c0560b.topMargin));
        int a2 = au.m3010a(a, ag.m1285g(this.f1240d));
        setMeasuredDimension(ag.m1258a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ag.m1258a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0560b c0560b = (C0560b) childAt.getLayoutParams();
                int i6 = c0560b.leftMargin + paddingLeft;
                paddingRight = c0560b.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1243g != null && !this.f1244h) {
            int bottom = this.f1241e.getVisibility() == 0 ? (int) ((((float) this.f1241e.getBottom()) + ag.m1288j(this.f1241e)) + 0.5f) : 0;
            this.f1243g.setBounds(0, bottom, getWidth(), this.f1243g.getIntrinsicHeight() + bottom);
            this.f1243g.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1241e.getVisibility() != 0) {
            return false;
        }
        return this.f1247k;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1237B.m1640a(view, view2, i);
        this.f1249m = getActionBarHideOffset();
        m2621k();
        if (this.f1257u != null) {
            this.f1257u.mo444n();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1249m += i2;
        setActionBarHideOffset(this.f1249m);
    }

    public void onStopNestedScroll(View view) {
        if (this.f1247k && !this.f1248l) {
            if (this.f1249m <= this.f1241e.getHeight()) {
                m2622l();
            } else {
                m2623m();
            }
        }
        if (this.f1257u != null) {
            this.f1257u.mo445o();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1247k || !z) {
            return false;
        }
        if (m2616a(f, f2)) {
            m2625o();
        } else {
            m2624n();
        }
        this.f1248l = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f1237B.m1638a();
    }

    void m2631c() {
        if (this.f1240d == null) {
            this.f1240d = (ContentFrameLayout) findViewById(C0503f.action_bar_activity_content);
            this.f1241e = (ActionBarContainer) findViewById(C0503f.action_bar_container);
            this.f1242f = m2613a(findViewById(C0503f.action_bar));
        }
    }

    private ac m2613a(View view) {
        if (view instanceof ac) {
            return (ac) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1247k) {
            this.f1247k = z;
            if (!z) {
                m2621k();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.f1241e != null ? -((int) ag.m1288j(this.f1241e)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        m2621k();
        ag.m1261a(this.f1241e, (float) (-Math.max(0, Math.min(i, this.f1241e.getHeight()))));
    }

    private void m2621k() {
        removeCallbacks(this.f1262z);
        removeCallbacks(this.f1236A);
        if (this.f1260x != null) {
            this.f1260x.m1461b();
        }
    }

    private void m2622l() {
        m2621k();
        postDelayed(this.f1262z, 600);
    }

    private void m2623m() {
        m2621k();
        postDelayed(this.f1236A, 600);
    }

    private void m2624n() {
        m2621k();
        this.f1262z.run();
    }

    private void m2625o() {
        m2621k();
        this.f1236A.run();
    }

    private boolean m2616a(float f, float f2) {
        this.f1259w.m1869a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f1259w.m1875d() > this.f1241e.getHeight()) {
            return true;
        }
        return false;
    }

    public void setWindowCallback(Callback callback) {
        m2631c();
        this.f1242f.mo549a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m2631c();
        this.f1242f.mo550a(charSequence);
    }

    public CharSequence getTitle() {
        m2631c();
        return this.f1242f.mo558e();
    }

    public void mo508a(int i) {
        m2631c();
        switch (i) {
            case 2:
                this.f1242f.mo559f();
                return;
            case 5:
                this.f1242f.mo560g();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        m2631c();
        this.f1242f.mo544a(i);
    }

    public void setIcon(Drawable drawable) {
        m2631c();
        this.f1242f.mo545a(drawable);
    }

    public void setLogo(int i) {
        m2631c();
        this.f1242f.mo553b(i);
    }

    public boolean mo510d() {
        m2631c();
        return this.f1242f.mo561h();
    }

    public boolean mo511e() {
        m2631c();
        return this.f1242f.mo562i();
    }

    public boolean mo512f() {
        m2631c();
        return this.f1242f.mo563j();
    }

    public boolean mo513g() {
        m2631c();
        return this.f1242f.mo564k();
    }

    public boolean mo514h() {
        m2631c();
        return this.f1242f.mo565l();
    }

    public void mo515i() {
        m2631c();
        this.f1242f.mo566m();
    }

    public void mo509a(Menu menu, C0473a c0473a) {
        m2631c();
        this.f1242f.mo548a(menu, c0473a);
    }

    public void mo516j() {
        m2631c();
        this.f1242f.mo567n();
    }
}
