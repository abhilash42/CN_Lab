package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0220a;
import android.support.v4.view.C0361s;
import android.support.v4.view.C0365w;
import android.support.v4.view.C0366x;
import android.support.v4.view.C0367y;
import android.support.v4.view.C0368z;
import android.support.v4.view.ac;
import android.support.v4.view.ae;
import android.support.v4.view.ag;
import android.support.v4.view.p010a.C0239a;
import android.support.v4.view.p010a.C0249b;
import android.support.v4.view.p010a.C0270h;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.List;

public class NestedScrollView extends FrameLayout implements ac, C0365w, C0367y {
    private static final C0370a f600v = new C0370a();
    private static final int[] f601w = new int[]{16843130};
    private C0371b f602A;
    private long f603a;
    private final Rect f604b;
    private C0417u f605c;
    private C0394h f606d;
    private C0394h f607e;
    private int f608f;
    private boolean f609g;
    private boolean f610h;
    private View f611i;
    private boolean f612j;
    private VelocityTracker f613k;
    private boolean f614l;
    private boolean f615m;
    private int f616n;
    private int f617o;
    private int f618p;
    private int f619q;
    private final int[] f620r;
    private final int[] f621s;
    private int f622t;
    private SavedState f623u;
    private final C0368z f624x;
    private final C0366x f625y;
    private float f626z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C03691();
        public int f599a;

        static class C03691 implements Creator<SavedState> {
            C03691() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1641a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1642a(i);
            }

            public SavedState m1641a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m1642a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f599a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f599a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f599a + "}";
        }
    }

    static class C0370a extends C0220a {
        C0370a() {
        }

        public boolean mo126a(View view, int i, Bundle bundle) {
            if (super.mo126a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m1672b(0, min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m1672b(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public void mo125a(View view, C0249b c0249b) {
            super.mo125a(view, c0249b);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0249b.m985a(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int a = nestedScrollView.getScrollRange();
                if (a > 0) {
                    c0249b.m986a(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0249b.m983a(8192);
                    }
                    if (nestedScrollView.getScrollY() < a) {
                        c0249b.m983a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
                    }
                }
            }
        }

        public void mo127d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo127d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            C0270h a = C0239a.m917a(accessibilityEvent);
            a.m1075a(nestedScrollView.getScrollRange() > 0);
            a.m1078d(nestedScrollView.getScrollX());
            a.m1079e(nestedScrollView.getScrollY());
            a.m1080f(nestedScrollView.getScrollX());
            a.m1081g(nestedScrollView.getScrollRange());
        }
    }

    public interface C0371b {
        void mo354a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f604b = new Rect();
        this.f609g = true;
        this.f610h = false;
        this.f611i = null;
        this.f612j = false;
        this.f615m = true;
        this.f619q = -1;
        this.f620r = new int[2];
        this.f621s = new int[2];
        m1649a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f601w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f624x = new C0368z(this);
        this.f625y = new C0366x(this);
        setNestedScrollingEnabled(true);
        ag.m1267a((View) this, f600v);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f625y.m1629a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f625y.m1630a();
    }

    public boolean startNestedScroll(int i) {
        return this.f625y.m1633a(i);
    }

    public void stopNestedScroll() {
        this.f625y.m1637c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f625y.m1636b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f625y.m1634a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f625y.m1635a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f625y.m1632a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f625y.m1631a(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f624x.m1640a(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.f624x.m1639a(view);
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m1665f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.f624x.m1638a();
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    private void m1649a() {
        this.f605c = C0417u.m1867a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f616n = viewConfiguration.getScaledTouchSlop();
        this.f617o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f618p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(C0371b c0371b) {
        this.f602A = c0371b;
    }

    private boolean m1658b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f614l) {
            this.f614l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f615m = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f602A != null) {
            this.f602A.mo354a(this, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f614l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1671a(keyEvent);
    }

    public boolean m1671a(KeyEvent keyEvent) {
        int i = 33;
        this.f604b.setEmpty();
        if (m1658b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return m1673b(33);
                    }
                    return m1674c(33);
                case 20:
                    if (keyEvent.isAltPressed()) {
                        return m1673b(130);
                    }
                    return m1674c(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m1669a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            boolean z;
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        }
    }

    private boolean m1660c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void m1659c() {
        if (this.f613k == null) {
            this.f613k = VelocityTracker.obtain();
        } else {
            this.f613k.clear();
        }
    }

    private void m1661d() {
        if (this.f613k == null) {
            this.f613k = VelocityTracker.obtain();
        }
    }

    private void m1662e() {
        if (this.f613k != null) {
            this.f613k.recycle();
            this.f613k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m1662e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f612j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                if (!m1660c((int) motionEvent.getX(), action)) {
                    this.f612j = false;
                    m1662e();
                    break;
                }
                this.f608f = action;
                this.f619q = C0361s.m1618b(motionEvent, 0);
                m1659c();
                this.f613k.addMovement(motionEvent);
                this.f605c.m1877f();
                if (!this.f605c.m1871a()) {
                    z = true;
                }
                this.f612j = z;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                this.f612j = false;
                this.f619q = -1;
                m1662e();
                if (this.f605c.m1872a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ag.m1274b(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.f619q;
                if (action != -1) {
                    int a = C0361s.m1616a(motionEvent, action);
                    if (a != -1) {
                        action = (int) C0361s.m1621d(motionEvent, a);
                        if (Math.abs(action - this.f608f) > this.f616n && (getNestedScrollAxes() & 2) == 0) {
                            this.f612j = true;
                            this.f608f = action;
                            m1661d();
                            this.f613k.addMovement(motionEvent);
                            this.f622t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m1650a(motionEvent);
                break;
        }
        return this.f612j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m1661d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = C0361s.m1615a(motionEvent);
        if (a == 0) {
            this.f622t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f622t);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f605c.m1871a();
                    this.f612j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f605c.m1871a()) {
                        this.f605c.m1878g();
                    }
                    this.f608f = (int) motionEvent.getY();
                    this.f619q = C0361s.m1618b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.f612j) {
                    VelocityTracker velocityTracker = this.f613k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f618p);
                    a = (int) ae.m1117b(velocityTracker, this.f619q);
                    if (Math.abs(a) > this.f617o) {
                        m1665f(-a);
                    } else if (this.f605c.m1872a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ag.m1274b(this);
                    }
                }
                this.f619q = -1;
                m1664f();
                break;
            case 2:
                int a2 = C0361s.m1616a(motionEvent, this.f619q);
                if (a2 != -1) {
                    int i;
                    int d = (int) C0361s.m1621d(motionEvent, a2);
                    a = this.f608f - d;
                    if (dispatchNestedPreScroll(0, a, this.f621s, this.f620r)) {
                        a -= this.f621s[1];
                        obtain.offsetLocation(0.0f, (float) this.f620r[1]);
                        this.f622t += this.f620r[1];
                    }
                    if (this.f612j || Math.abs(a) <= this.f616n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f612j = true;
                        if (a > 0) {
                            i = a - this.f616n;
                        } else {
                            i = a + this.f616n;
                        }
                    }
                    if (this.f612j) {
                        Object obj;
                        this.f608f = d - this.f620r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = ag.m1259a(this);
                        if (a == 0 || (a == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (m1670a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f613k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f620r)) {
                            if (obj != null) {
                                m1666g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f606d.m1788a(((float) i) / ((float) getHeight()), C0361s.m1619c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f607e.m1786a()) {
                                        this.f607e.m1792c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f607e.m1788a(((float) i) / ((float) getHeight()), 1.0f - (C0361s.m1619c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f606d.m1786a()) {
                                        this.f606d.m1792c();
                                    }
                                }
                                if (!(this.f606d == null || (this.f606d.m1786a() && this.f607e.m1786a()))) {
                                    ag.m1274b(this);
                                    break;
                                }
                            }
                        }
                        this.f608f -= this.f620r[1];
                        obtain.offsetLocation(0.0f, (float) this.f620r[1]);
                        this.f622t += this.f620r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f619q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f612j && getChildCount() > 0 && this.f605c.m1872a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ag.m1274b(this);
                }
                this.f619q = -1;
                m1664f();
                break;
            case 5:
                a = C0361s.m1617b(motionEvent);
                this.f608f = (int) C0361s.m1621d(motionEvent, a);
                this.f619q = C0361s.m1618b(motionEvent, a);
                break;
            case 6:
                m1650a(motionEvent);
                this.f608f = (int) C0361s.m1621d(motionEvent, C0361s.m1616a(motionEvent, this.f619q));
                break;
        }
        if (this.f613k != null) {
            this.f613k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void m1650a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (C0361s.m1618b(motionEvent, action) == this.f619q) {
            action = action == 0 ? 1 : 0;
            this.f608f = (int) C0361s.m1621d(motionEvent, action);
            this.f619q = C0361s.m1618b(motionEvent, action);
            if (this.f613k != null) {
                this.f613k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((C0361s.m1620c(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f612j) {
                    return false;
                }
                float e = C0361s.m1622e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f626z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f626z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f626z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean m1670a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int a = ag.m1259a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        a = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < a) {
            z3 = true;
            i13 = a;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f605c.m1872a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private View m1648a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    public boolean m1669a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f604b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f604b.top + height > childAt.getBottom()) {
                    this.f604b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f604b.top = getScrollY() - height;
            if (this.f604b.top < 0) {
                this.f604b.top = 0;
            }
        }
        this.f604b.bottom = this.f604b.top + height;
        return m1651a(i, this.f604b.top, this.f604b.bottom);
    }

    public boolean m1673b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f604b.top = 0;
        this.f604b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f604b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f604b.top = this.f604b.bottom - height;
            }
        }
        return m1651a(i, this.f604b.top, this.f604b.bottom);
    }

    private boolean m1651a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m1648a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m1663e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    public boolean m1674c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m1654a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m1663e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f604b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f604b);
            m1663e(m1667a(this.f604b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m1653a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean m1653a(View view) {
        return !m1654a(view, 0, getHeight());
    }

    private boolean m1654a(View view, int i, int i2) {
        view.getDrawingRect(this.f604b);
        offsetDescendantRectToMyCoords(view, this.f604b);
        return this.f604b.bottom + i >= getScrollY() && this.f604b.top - i <= getScrollY() + i2;
    }

    private void m1663e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f615m) {
            m1668a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    public final void m1668a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f603a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f605c.m1868a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ag.m1274b(this);
            } else {
                if (!this.f605c.m1871a()) {
                    this.f605c.m1878g();
                }
                scrollBy(i, i2);
            }
            this.f603a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void m1672b(int i, int i2) {
        m1668a(i - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.f605c.m1877f()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f605c.m1873b();
            int c = this.f605c.m1874c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = ag.m1259a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m1670a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m1666g();
                    if (c <= 0 && scrollY > 0) {
                        this.f606d.m1789a((int) this.f605c.m1876e());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f607e.m1789a((int) this.f605c.m1876e());
                    }
                }
            }
        }
    }

    private void m1657b(View view) {
        view.getDrawingRect(this.f604b);
        offsetDescendantRectToMyCoords(view, this.f604b);
        int a = m1667a(this.f604b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m1652a(Rect rect, boolean z) {
        int a = m1667a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m1668a(0, a);
            }
        }
        return z2;
    }

    protected int m1667a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f609g) {
            this.f611i = view2;
        } else {
            m1657b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus == null || m1653a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m1652a(rect, z);
    }

    public void requestLayout() {
        this.f609g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f609g = false;
        if (this.f611i != null && m1655a(this.f611i, (View) this)) {
            m1657b(this.f611i);
        }
        this.f611i = null;
        if (!this.f610h) {
            if (this.f623u != null) {
                scrollTo(getScrollX(), this.f623u.f599a);
                this.f623u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f610h = true;
    }

    public void onAttachedToWindow() {
        this.f610h = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m1654a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f604b);
            offsetDescendantRectToMyCoords(findFocus, this.f604b);
            m1663e(m1667a(this.f604b));
        }
    }

    private static boolean m1655a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m1655a((View) parent, view2);
        return z;
    }

    public void m1675d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f605c.m1870a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            ag.m1274b(this);
        }
    }

    private void m1665f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m1675d(i);
            }
        }
    }

    private void m1664f() {
        this.f612j = false;
        m1662e();
        stopNestedScroll();
        if (this.f606d != null) {
            this.f606d.m1792c();
            this.f607e.m1792c();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m1656b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m1656b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    private void m1666g() {
        if (ag.m1259a(this) == 2) {
            this.f606d = null;
            this.f607e = null;
        } else if (this.f606d == null) {
            Context context = getContext();
            this.f606d = new C0394h(context);
            this.f607e = new C0394h(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f606d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f606d.m1786a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f606d.m1785a(width, getHeight());
                if (this.f606d.m1790a(canvas)) {
                    ag.m1274b(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f607e.m1786a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f607e.m1785a(width, height);
                if (this.f607e.m1790a(canvas)) {
                    ag.m1274b(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int m1656b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f623u = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f599a = getScrollY();
        return savedState;
    }
}
