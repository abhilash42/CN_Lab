package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.C0208c;
import android.support.v4.os.C0209d;
import android.support.v4.view.p010a.C0239a;
import android.support.v4.view.p010a.C0249b;
import android.support.v4.view.p010a.C0270h;
import android.support.v4.widget.C0394h;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<C0218b> COMPARATOR = new C02121();
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS = new int[]{16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new C02132();
    private static final C0226i sPositionComparator = new C0226i();
    private int mActivePointerId = INVALID_POINTER;
    private ab mAdapter;
    private C0222e mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new C02143(this);
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private C0223f mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<C0218b> mItems = new ArrayList();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private C0394h mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private C0225h mObserver;
    private int mOffscreenPageLimit = 1;
    private C0223f mOnPageChangeListener;
    private List<C0223f> mOnPageChangeListeners;
    private int mPageMargin;
    private C0224g mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = INVALID_POINTER;
    private C0394h mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final C0218b mTempItem = new C0218b();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    static class C02121 implements Comparator<C0218b> {
        C02121() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m824a((C0218b) obj, (C0218b) obj2);
        }

        public int m824a(C0218b c0218b, C0218b c0218b2) {
            return c0218b.f514b - c0218b2.f514b;
        }
    }

    static class C02132 implements Interpolator {
        C02132() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C02143 implements Runnable {
        final /* synthetic */ ViewPager f507a;

        C02143(ViewPager viewPager) {
            this.f507a = viewPager;
        }

        public void run() {
            this.f507a.setScrollState(0);
            this.f507a.populate();
        }
    }

    class C02154 implements aa {
        final /* synthetic */ ViewPager f508a;
        private final Rect f509b = new Rect();

        C02154(ViewPager viewPager) {
            this.f508a = viewPager;
        }

        public bd mo122a(View view, bd bdVar) {
            bd a = ag.m1260a(view, bdVar);
            if (a.mo269e()) {
                return a;
            }
            Rect rect = this.f509b;
            rect.left = a.mo264a();
            rect.top = a.mo266b();
            rect.right = a.mo267c();
            rect.bottom = a.mo268d();
            int childCount = this.f508a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                bd b = ag.m1273b(this.f508a.getChildAt(i), a);
                rect.left = Math.min(b.mo264a(), rect.left);
                rect.top = Math.min(b.mo266b(), rect.top);
                rect.right = Math.min(b.mo267c(), rect.right);
                rect.bottom = Math.min(b.mo268d(), rect.bottom);
            }
            return a.mo265a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = C0208c.m820a(new C02161());
        int f510a;
        Parcelable f511b;
        ClassLoader f512c;

        static class C02161 implements C0209d<SavedState> {
            C02161() {
            }

            public /* synthetic */ Object mo123a(Parcel parcel, ClassLoader classLoader) {
                return m829b(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo124a(int i) {
                return m830b(i);
            }

            public SavedState m829b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m830b(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f510a);
            parcel.writeParcelable(this.f511b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f510a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f510a = parcel.readInt();
            this.f511b = parcel.readParcelable(classLoader);
            this.f512c = classLoader;
        }
    }

    interface C0217a {
    }

    static class C0218b {
        Object f513a;
        int f514b;
        boolean f515c;
        float f516d;
        float f517e;

        C0218b() {
        }
    }

    public static class C0219c extends LayoutParams {
        public boolean f518a;
        public int f519b;
        float f520c = 0.0f;
        boolean f521d;
        int f522e;
        int f523f;

        public C0219c() {
            super(ViewPager.INVALID_POINTER, ViewPager.INVALID_POINTER);
        }

        public C0219c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f519b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class C0221d extends C0220a {
        final /* synthetic */ ViewPager f527b;

        C0221d(ViewPager viewPager) {
            this.f527b = viewPager;
        }

        public void mo127d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo127d(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            C0270h a = C0239a.m917a(accessibilityEvent);
            a.m1075a(m841b());
            if (accessibilityEvent.getEventType() == CodedOutputStream.DEFAULT_BUFFER_SIZE && this.f527b.mAdapter != null) {
                a.m1074a(this.f527b.mAdapter.mo804a());
                a.m1076b(this.f527b.mCurItem);
                a.m1077c(this.f527b.mCurItem);
            }
        }

        public void mo125a(View view, C0249b c0249b) {
            super.mo125a(view, c0249b);
            c0249b.m985a(ViewPager.class.getName());
            c0249b.m986a(m841b());
            if (this.f527b.canScrollHorizontally(1)) {
                c0249b.m983a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
            }
            if (this.f527b.canScrollHorizontally(ViewPager.INVALID_POINTER)) {
                c0249b.m983a(8192);
            }
        }

        public boolean mo126a(View view, int i, Bundle bundle) {
            if (super.mo126a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                    if (!this.f527b.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.f527b.setCurrentItem(this.f527b.mCurItem + 1);
                    return true;
                case 8192:
                    if (!this.f527b.canScrollHorizontally(ViewPager.INVALID_POINTER)) {
                        return false;
                    }
                    this.f527b.setCurrentItem(this.f527b.mCurItem + ViewPager.INVALID_POINTER);
                    return true;
                default:
                    return false;
            }
        }

        private boolean m841b() {
            return this.f527b.mAdapter != null && this.f527b.mAdapter.mo804a() > 1;
        }
    }

    interface C0222e {
        void m845a(ab abVar, ab abVar2);
    }

    public interface C0223f {
        void mo793a(int i);

        void mo794a(int i, float f, int i2);

        void mo795b(int i);
    }

    public interface C0224g {
        void m849a(View view, float f);
    }

    private class C0225h extends DataSetObserver {
        final /* synthetic */ ViewPager f528a;

        private C0225h(ViewPager viewPager) {
            this.f528a = viewPager;
        }

        public void onChanged() {
            this.f528a.dataSetChanged();
        }

        public void onInvalidated() {
            this.f528a.dataSetChanged();
        }
    }

    static class C0226i implements Comparator<View> {
        C0226i() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m850a((View) obj, (View) obj2);
        }

        public int m850a(View view, View view2) {
            C0219c c0219c = (C0219c) view.getLayoutParams();
            C0219c c0219c2 = (C0219c) view2.getLayoutParams();
            if (c0219c.f518a != c0219c2.f518a) {
                return c0219c.f518a ? 1 : ViewPager.INVALID_POINTER;
            } else {
                return c0219c.f522e - c0219c2.f522e;
            }
        }
    }

    public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = ar.m1361a(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new C0394h(context);
        this.mRightEdge = new C0394h(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (16.0f * f);
        ag.m1267a((View) this, new C0221d(this));
        if (ag.m1278c(this) == 0) {
            ag.m1280c((View) this, 1);
        }
        ag.m1268a((View) this, new C02154(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        if (!(this.mScroller == null || this.mScroller.isFinished())) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0);
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void setAdapter(ab abVar) {
        if (this.mAdapter != null) {
            this.mAdapter.m1109c(null);
            this.mAdapter.m1099a((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                C0218b c0218b = (C0218b) this.mItems.get(i);
                this.mAdapter.mo807a((ViewGroup) this, c0218b.f514b, c0218b.f513a);
            }
            this.mAdapter.m1107b((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        ab abVar2 = this.mAdapter;
        this.mAdapter = abVar;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new C0225h();
            }
            this.mAdapter.m1109c(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.mo804a();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.m1096a(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = INVALID_POINTER;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        if (this.mAdapterChangeListener != null && abVar2 != abVar) {
            this.mAdapterChangeListener.m845a(abVar2, abVar);
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0219c) getChildAt(i).getLayoutParams()).f518a) {
                removeViewAt(i);
                i += INVALID_POINTER;
            }
            i++;
        }
    }

    public ab getAdapter() {
        return this.mAdapter;
    }

    void setOnAdapterChangeListener(C0222e c0222e) {
        this.mAdapterChangeListener = c0222e;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.mPopulatePending = false;
        if (this.mFirstLayout) {
            z = false;
        } else {
            z = true;
        }
        setCurrentItemInternal(i, z, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.mAdapter == null || this.mAdapter.mo804a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.mAdapter.mo804a()) {
                i = this.mAdapter.mo804a() + INVALID_POINTER;
            }
            int i3 = this.mOffscreenPageLimit;
            if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
                for (int i4 = 0; i4 < this.mItems.size(); i4++) {
                    ((C0218b) this.mItems.get(i4)).f515c = true;
                }
            }
            if (this.mCurItem != i) {
                z3 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3) {
                    dispatchOnPageSelected(i);
                }
                requestLayout();
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        int max;
        C0218b infoForPosition = infoForPosition(i);
        if (infoForPosition != null) {
            max = (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.f517e, this.mLastOffset)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            smoothScrollTo(max, 0, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(false);
        scrollTo(max, 0);
        pageScrolled(max);
    }

    @Deprecated
    public void setOnPageChangeListener(C0223f c0223f) {
        this.mOnPageChangeListener = c0223f;
    }

    public void addOnPageChangeListener(C0223f c0223f) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(c0223f);
    }

    public void removeOnPageChangeListener(C0223f c0223f) {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.remove(c0223f);
        }
    }

    public void clearOnPageChangeListeners() {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.clear();
        }
    }

    public void setPageTransformer(boolean z, C0224g c0224g) {
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            boolean z2;
            boolean z3 = c0224g != null;
            if (this.mPageTransformer != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i2 = z3 != z2 ? 1 : 0;
            this.mPageTransformer = c0224g;
            setChildrenDrawingOrderEnabledCompat(z3);
            if (z3) {
                if (z) {
                    i = 2;
                }
                this.mDrawingOrder = i;
            } else {
                this.mDrawingOrder = 0;
            }
            if (i2 != 0) {
                populate();
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.mSetChildrenDrawingOrderEnabled == null) {
                try {
                    this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e(TAG, "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.mSetChildrenDrawingOrderEnabled.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e(TAG, "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i + INVALID_POINTER) - i2;
        }
        return ((C0219c) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).f523f;
    }

    C0223f setInternalPageChangeListener(C0223f c0223f) {
        C0223f c0223f2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = c0223f;
        return c0223f2;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int i4;
        boolean z = (this.mScroller == null || this.mScroller.isFinished()) ? false : true;
        if (z) {
            int currX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float distanceInfluenceForSnapDuration = (((float) i7) * distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        if (abs > 0) {
            currX = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / ((float) abs))) * 4;
        } else {
            currX = (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.mAdapter.m1102b(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f);
        }
        i7 = Math.min(currX, MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i4, scrollY, i5, i6, i7);
        ag.m1274b(this);
    }

    C0218b addNewItem(int i, int i2) {
        C0218b c0218b = new C0218b();
        c0218b.f514b = i;
        c0218b.f513a = this.mAdapter.mo806a((ViewGroup) this, i);
        c0218b.f516d = this.mAdapter.m1102b(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(c0218b);
        } else {
            this.mItems.add(i2, c0218b);
        }
        return c0218b;
    }

    void dataSetChanged() {
        int a = this.mAdapter.mo804a();
        this.mExpectedAdapterCount = a;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < a;
        boolean z2 = false;
        int i = this.mCurItem;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.mItems.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            C0218b c0218b = (C0218b) this.mItems.get(i2);
            int a2 = this.mAdapter.m1091a(c0218b.f513a);
            if (a2 == INVALID_POINTER) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a2 == -2) {
                this.mItems.remove(i2);
                i2 += INVALID_POINTER;
                if (!z2) {
                    this.mAdapter.m1099a((ViewGroup) this);
                    z2 = true;
                }
                this.mAdapter.mo807a((ViewGroup) this, c0218b.f514b, c0218b.f513a);
                if (this.mCurItem == c0218b.f514b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.mCurItem, a + INVALID_POINTER));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (c0218b.f514b != a2) {
                if (c0218b.f514b == this.mCurItem) {
                    i = a2;
                }
                c0218b.f514b = a2;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.mAdapter.m1107b((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                C0219c c0219c = (C0219c) getChildAt(i2).getLayoutParams();
                if (!c0219c.f518a) {
                    c0219c.f520c = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    void populate() {
        populate(this.mCurItem);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void populate(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.mCurItem;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.mCurItem;
        r0 = r17;
        r2 = r0.infoForPosition(r2);
        r0 = r18;
        r1 = r17;
        r1.mCurItem = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.mAdapter;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.sortChildDrawingOrder();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.mPopulatePending;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.sortChildDrawingOrder();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.mAdapter;
        r0 = r17;
        r2.m1099a(r0);
        r0 = r17;
        r2 = r0.mOffscreenPageLimit;
        r4 = 0;
        r0 = r17;
        r5 = r0.mCurItem;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.mAdapter;
        r11 = r4.mo804a();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.mCurItem;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.mExpectedAdapterCount;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.mExpectedAdapterCount;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.mAdapter;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0218b) r2;
        r6 = r2.f514b;
        r0 = r17;
        r7 = r0.mCurItem;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.f514b;
        r0 = r17;
        r7 = r0.mCurItem;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.mCurItem;
        r0 = r17;
        r2 = r0.addNewItem(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.C0218b) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.mCurItem;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.f516d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.C0218b) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.mCurItem;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.calculatePageOffsets(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.mAdapter;
        r0 = r17;
        r4 = r0.mCurItem;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.f513a;
    L_0x0179:
        r0 = r17;
        r3.m1108b(r0, r4, r2);
        r0 = r17;
        r2 = r0.mAdapter;
        r0 = r17;
        r2.m1107b(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.C0219c) r2;
        r2.f523f = r3;
        r6 = r2.f518a;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.f520c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.infoForChild(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.f516d;
        r2.f520c = r6;
        r5 = r5.f514b;
        r2.f522e = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.f516d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.f514b;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.f515c;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.mItems;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.mAdapter;
        r2 = r2.f513a;
        r0 = r17;
        r14.mo807a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0218b) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.f514b;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.f516d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0218b) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.addNewItem(r8, r2);
        r2 = r2.f516d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0218b) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.f514b;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.f515c;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.mItems;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.mAdapter;
        r2 = r2.f513a;
        r0 = r17;
        r10.mo807a(r0, r8, r2);
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0218b) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.f514b;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.f516d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0218b) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.addNewItem(r8, r6);
        r6 = r6 + 1;
        r2 = r2.f516d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.mItems;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0218b) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.sortChildDrawingOrder();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.infoForAnyChild(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.f514b;
        r0 = r17;
        r3 = r0.mCurItem;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.infoForChild(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.f514b;
        r0 = r17;
        r5 = r0.mCurItem;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.populate(int):void");
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    private void calculatePageOffsets(C0218b c0218b, int i, C0218b c0218b2) {
        float f;
        float f2;
        int i2;
        C0218b c0218b3;
        int i3;
        int a = this.mAdapter.mo804a();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (c0218b2 != null) {
            clientWidth = c0218b2.f514b;
            int i4;
            if (clientWidth < c0218b.f514b) {
                f2 = (c0218b2.f517e + c0218b2.f516d) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= c0218b.f514b && i2 < this.mItems.size()) {
                    c0218b3 = (C0218b) this.mItems.get(i2);
                    while (i4 > c0218b3.f514b && i2 < this.mItems.size() + INVALID_POINTER) {
                        i2++;
                        c0218b3 = (C0218b) this.mItems.get(i2);
                    }
                    while (i4 < c0218b3.f514b) {
                        f2 += this.mAdapter.m1102b(i4) + f;
                        i4++;
                    }
                    c0218b3.f517e = f2;
                    f2 += c0218b3.f516d + f;
                    i4++;
                }
            } else if (clientWidth > c0218b.f514b) {
                i2 = this.mItems.size() + INVALID_POINTER;
                f2 = c0218b2.f517e;
                i4 = clientWidth + INVALID_POINTER;
                while (i4 >= c0218b.f514b && i2 >= 0) {
                    c0218b3 = (C0218b) this.mItems.get(i2);
                    while (i4 < c0218b3.f514b && i2 > 0) {
                        i2 += INVALID_POINTER;
                        c0218b3 = (C0218b) this.mItems.get(i2);
                    }
                    while (i4 > c0218b3.f514b) {
                        f2 -= this.mAdapter.m1102b(i4) + f;
                        i4 += INVALID_POINTER;
                    }
                    f2 -= c0218b3.f516d + f;
                    c0218b3.f517e = f2;
                    i4 += INVALID_POINTER;
                }
            }
        }
        int size = this.mItems.size();
        float f3 = c0218b.f517e;
        i2 = c0218b.f514b + INVALID_POINTER;
        this.mFirstOffset = c0218b.f514b == 0 ? c0218b.f517e : -3.4028235E38f;
        this.mLastOffset = c0218b.f514b == a + INVALID_POINTER ? (c0218b.f517e + c0218b.f516d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i + INVALID_POINTER; i3 >= 0; i3 += INVALID_POINTER) {
            c0218b3 = (C0218b) this.mItems.get(i3);
            f2 = f3;
            while (i2 > c0218b3.f514b) {
                f2 -= this.mAdapter.m1102b(i2) + f;
                i2 += INVALID_POINTER;
            }
            f3 = f2 - (c0218b3.f516d + f);
            c0218b3.f517e = f3;
            if (c0218b3.f514b == 0) {
                this.mFirstOffset = f3;
            }
            i2 += INVALID_POINTER;
        }
        f3 = (c0218b.f517e + c0218b.f516d) + f;
        i2 = c0218b.f514b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            c0218b3 = (C0218b) this.mItems.get(i3);
            f2 = f3;
            while (i2 < c0218b3.f514b) {
                f2 = (this.mAdapter.m1102b(i2) + f) + f2;
                i2++;
            }
            if (c0218b3.f514b == a + INVALID_POINTER) {
                this.mLastOffset = (c0218b3.f516d + f2) - 1.0f;
            }
            c0218b3.f517e = f2;
            f3 = f2 + (c0218b3.f516d + f);
            i2++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f510a = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.f511b = this.mAdapter.m1103b();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.mAdapter != null) {
                this.mAdapter.m1096a(savedState.f511b, savedState.f512c);
                setCurrentItemInternal(savedState.f510a, false, true);
                return;
            }
            this.mRestoredCurItem = savedState.f510a;
            this.mRestoredAdapterState = savedState.f511b;
            this.mRestoredClassLoader = savedState.f512c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        C0219c c0219c = (C0219c) layoutParams2;
        c0219c.f518a |= view instanceof C0217a;
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams2);
        } else if (c0219c == null || !c0219c.f518a) {
            c0219c.f521d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    C0218b infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            C0218b c0218b = (C0218b) this.mItems.get(i);
            if (this.mAdapter.mo808a(view, c0218b.f513a)) {
                return c0218b;
            }
        }
        return null;
    }

    C0218b infoForAnyChild(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    C0218b infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            C0218b c0218b = (C0218b) this.mItems.get(i2);
            if (c0218b.f514b == i) {
                return c0218b;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            C0219c c0219c;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                c0219c = (C0219c) childAt.getLayoutParams();
                if (c0219c != null && c0219c.f518a) {
                    int i6 = c0219c.f519b & 7;
                    int i7 = c0219c.f519b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (c0219c.width != -2) {
                        i7 = 1073741824;
                        i3 = c0219c.width != INVALID_POINTER ? c0219c.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (c0219c.height != -2) {
                        i5 = 1073741824;
                        if (c0219c.height != INVALID_POINTER) {
                            measuredWidth = c0219c.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                c0219c = (C0219c) childAt2.getLayoutParams();
                if (c0219c == null || !c0219c.f518a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0219c.f520c * ((float) paddingLeft)), 1073741824), this.mChildHeightMeasureSpec);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
        }
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.mItems.isEmpty()) {
            C0218b infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.f517e, this.mLastOffset) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                completeScroll(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.mScroller.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0219c c0219c;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c0219c = (C0219c) childAt.getLayoutParams();
                if (c0219c.f518a) {
                    int i9 = c0219c.f519b & 112;
                    switch (c0219c.f519b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                c0219c = (C0219c) childAt2.getLayoutParams();
                if (!c0219c.f518a) {
                    C0218b infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        i5 = ((int) (infoForChild.f517e * ((float) max))) + paddingLeft;
                        if (c0219c.f521d) {
                            c0219c.f521d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0219c.f520c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i6 - paddingBottom;
        this.mDecorChildCount = i7;
        if (this.mFirstLayout) {
            scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ag.m1274b(this);
    }

    private boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            C0218b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin + clientWidth;
            float f = ((float) this.mPageMargin) / ((float) clientWidth);
            int i3 = infoForCurrentScrollPosition.f514b;
            float f2 = ((((float) i) / ((float) clientWidth)) - infoForCurrentScrollPosition.f517e) / (infoForCurrentScrollPosition.f516d + f);
            clientWidth = (int) (((float) i2) * f2);
            this.mCalledSuper = false;
            onPageScrolled(i3, f2, clientWidth);
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void onPageScrolled(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                C0219c c0219c = (C0219c) childAt.getLayoutParams();
                if (c0219c.f518a) {
                    int max;
                    switch (c0219c.f519b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        dispatchOnPageScrolled(i, f, i2);
        if (this.mPageTransformer != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((C0219c) childAt2.getLayoutParams()).f518a) {
                    this.mPageTransformer.m849a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.mo794a(i, f, i2);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0223f c0223f = (C0223f) this.mOnPageChangeListeners.get(i3);
                if (c0223f != null) {
                    c0223f.mo794a(i, f, i2);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.mo794a(i, f, i2);
        }
    }

    private void dispatchOnPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.mo793a(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0223f c0223f = (C0223f) this.mOnPageChangeListeners.get(i2);
                if (c0223f != null) {
                    c0223f.mo793a(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.mo793a(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.mo795b(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0223f c0223f = (C0223f) this.mOnPageChangeListeners.get(i2);
                if (c0223f != null) {
                    c0223f.mo795b(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.mo795b(i);
        }
    }

    private void completeScroll(boolean z) {
        int scrollX;
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.mScroller.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.mScroller.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.mItems.size(); scrollX++) {
            C0218b c0218b = (C0218b) this.mItems.get(scrollX);
            if (c0218b.f515c) {
                c0218b.f515c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            ag.m1269a((View) this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private boolean isGutterDrag(float f, float f2) {
        return (f < ((float) this.mGutterSize) && f2 > 0.0f) || (f > ((float) (getWidth() - this.mGutterSize)) && f2 < 0.0f);
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ag.m1264a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                x = motionEvent.getY();
                this.mInitialMotionY = x;
                this.mLastMotionY = x;
                this.mActivePointerId = C0361s.m1618b(motionEvent, 0);
                this.mIsUnableToDrag = false;
                this.mIsScrollStarted = true;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    break;
                }
                completeScroll(false);
                this.mIsBeingDragged = false;
                break;
            case 2:
                action = this.mActivePointerId;
                if (action != INVALID_POINTER) {
                    action = C0361s.m1616a(motionEvent, action);
                    float c = C0361s.m1619c(motionEvent, action);
                    float f = c - this.mLastMotionX;
                    float abs = Math.abs(f);
                    float d = C0361s.m1621d(motionEvent, action);
                    float abs2 = Math.abs(d - this.mInitialMotionY);
                    if (f == 0.0f || isGutterDrag(this.mLastMotionX, f) || !canScroll(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.mTouchSlop) && 0.5f * abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            setScrollState(1);
                            this.mLastMotionX = f > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                            this.mLastMotionY = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.mTouchSlop)) {
                            this.mIsUnableToDrag = true;
                        }
                        if (this.mIsBeingDragged && performDrag(c)) {
                            ag.m1274b(this);
                            break;
                        }
                    }
                    this.mLastMotionX = c;
                    this.mLastMotionY = d;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.mFakeDragging) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.mAdapter == null || this.mAdapter.mo804a() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                x = motionEvent.getY();
                this.mInitialMotionY = x;
                this.mLastMotionY = x;
                this.mActivePointerId = C0361s.m1618b(motionEvent, 0);
                break;
            case 1:
                if (this.mIsBeingDragged) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                    a = (int) ae.m1116a(velocityTracker, this.mActivePointerId);
                    this.mPopulatePending = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C0218b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                    setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f514b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f517e) / (infoForCurrentScrollPosition.f516d + (((float) this.mPageMargin) / ((float) clientWidth))), a, (int) (C0361s.m1619c(motionEvent, C0361s.m1616a(motionEvent, this.mActivePointerId)) - this.mInitialMotionX)), true, true, a);
                    z = resetTouch();
                    break;
                }
                break;
            case 2:
                if (!this.mIsBeingDragged) {
                    a = C0361s.m1616a(motionEvent, this.mActivePointerId);
                    if (a == INVALID_POINTER) {
                        z = resetTouch();
                        break;
                    }
                    float c = C0361s.m1619c(motionEvent, a);
                    float abs = Math.abs(c - this.mLastMotionX);
                    float d = C0361s.m1621d(motionEvent, a);
                    x = Math.abs(d - this.mLastMotionY);
                    if (abs > ((float) this.mTouchSlop) && abs > x) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        if (c - this.mInitialMotionX > 0.0f) {
                            x = this.mInitialMotionX + ((float) this.mTouchSlop);
                        } else {
                            x = this.mInitialMotionX - ((float) this.mTouchSlop);
                        }
                        this.mLastMotionX = x;
                        this.mLastMotionY = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z = false | performDrag(C0361s.m1619c(motionEvent, C0361s.m1616a(motionEvent, this.mActivePointerId)));
                    break;
                }
                break;
            case 3:
                if (this.mIsBeingDragged) {
                    scrollToItem(this.mCurItem, true, 0, false);
                    z = resetTouch();
                    break;
                }
                break;
            case 5:
                a = C0361s.m1617b(motionEvent);
                this.mLastMotionX = C0361s.m1619c(motionEvent, a);
                this.mActivePointerId = C0361s.m1618b(motionEvent, a);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionX = C0361s.m1619c(motionEvent, C0361s.m1616a(motionEvent, this.mActivePointerId));
                break;
        }
        if (z) {
            ag.m1274b(this);
        }
        return true;
    }

    private boolean resetTouch() {
        this.mActivePointerId = INVALID_POINTER;
        endDrag();
        return this.mLeftEdge.m1792c() | this.mRightEdge.m1792c();
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean performDrag(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.mFirstOffset;
        float f5 = ((float) clientWidth) * this.mLastOffset;
        C0218b c0218b = (C0218b) this.mItems.get(0);
        C0218b c0218b2 = (C0218b) this.mItems.get(this.mItems.size() + INVALID_POINTER);
        if (c0218b.f514b != 0) {
            f4 = c0218b.f517e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (c0218b2.f514b != this.mAdapter.mo804a() + INVALID_POINTER) {
            f2 = c0218b2.f517e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.mLeftEdge.m1787a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.mRightEdge.m1787a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.mLastMotionX += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        pageScrolled((int) f4);
        return z3;
    }

    private C0218b infoForCurrentScrollPosition() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = INVALID_POINTER;
        int i2 = 0;
        Object obj = 1;
        C0218b c0218b = null;
        while (i2 < this.mItems.size()) {
            int i3;
            C0218b c0218b2;
            C0218b c0218b3 = (C0218b) this.mItems.get(i2);
            C0218b c0218b4;
            if (obj != null || c0218b3.f514b == i + 1) {
                c0218b4 = c0218b3;
                i3 = i2;
                c0218b2 = c0218b4;
            } else {
                c0218b3 = this.mTempItem;
                c0218b3.f517e = (f2 + f3) + f;
                c0218b3.f514b = i + 1;
                c0218b3.f516d = this.mAdapter.m1102b(c0218b3.f514b);
                c0218b4 = c0218b3;
                i3 = i2 + INVALID_POINTER;
                c0218b2 = c0218b4;
            }
            f2 = c0218b2.f517e;
            f3 = (c0218b2.f516d + f2) + f;
            if (obj == null && scrollX < f2) {
                return c0218b;
            }
            if (scrollX < f3 || i3 == this.mItems.size() + INVALID_POINTER) {
                return c0218b2;
            }
            f3 = f2;
            i = c0218b2.f514b;
            obj = null;
            f2 = c0218b2.f516d;
            c0218b = c0218b2;
            i2 = i3 + 1;
        }
        return c0218b;
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i = (int) ((i >= this.mCurItem ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() <= 0) {
            return i;
        }
        return Math.max(((C0218b) this.mItems.get(0)).f514b, Math.min(i, ((C0218b) this.mItems.get(this.mItems.size() + INVALID_POINTER)).f514b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ag.m1259a(this);
        if (a == 0 || (a == 1 && this.mAdapter != null && this.mAdapter.mo804a() > 1)) {
            int height;
            int width;
            if (!this.mLeftEdge.m1786a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.m1785a(height, width);
                i = 0 | this.mLeftEdge.m1790a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.mRightEdge.m1786a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) height));
                this.mRightEdge.m1785a(width, height);
                i |= this.mRightEdge.m1790a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.mLeftEdge.m1791b();
            this.mRightEdge.m1791b();
        }
        if (i != 0) {
            ag.m1274b(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.mPageMargin) / ((float) width);
            C0218b c0218b = (C0218b) this.mItems.get(0);
            float f2 = c0218b.f517e;
            int size = this.mItems.size();
            int i = c0218b.f514b;
            int i2 = ((C0218b) this.mItems.get(size + INVALID_POINTER)).f514b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c0218b.f514b && i3 < size) {
                    i3++;
                    c0218b = (C0218b) this.mItems.get(i3);
                }
                if (i4 == c0218b.f514b) {
                    f3 = (c0218b.f517e + c0218b.f516d) * ((float) width);
                    f2 = (c0218b.f517e + c0218b.f516d) + f;
                } else {
                    float b = this.mAdapter.m1102b(i4);
                    f3 = (f2 + b) * ((float) width);
                    f2 += b + f;
                }
                if (((float) this.mPageMargin) + f3 > ((float) scrollX)) {
                    this.mMarginDrawable.setBounds(Math.round(f3), this.mTopPageBounds, Math.round(((float) this.mPageMargin) + f3), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int a = (int) ae.m1116a(velocityTracker, this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                C0218b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f514b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f517e) / infoForCurrentScrollPosition.f516d, a, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, a);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            float f2;
            float f3;
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            int clientWidth = getClientWidth();
            float f4 = ((float) clientWidth) * this.mFirstOffset;
            float f5 = ((float) clientWidth) * this.mLastOffset;
            C0218b c0218b = (C0218b) this.mItems.get(0);
            C0218b c0218b2 = (C0218b) this.mItems.get(this.mItems.size() + INVALID_POINTER);
            if (c0218b.f514b != 0) {
                f2 = c0218b.f517e * ((float) clientWidth);
            } else {
                f2 = f4;
            }
            if (c0218b2.f514b != this.mAdapter.mo804a() + INVALID_POINTER) {
                f3 = c0218b2.f517e * ((float) clientWidth);
            } else {
                f3 = f5;
            }
            if (scrollX >= f2) {
                if (scrollX > f3) {
                    f2 = f3;
                } else {
                    f2 = scrollX;
                }
            }
            this.mLastMotionX += f2 - ((float) ((int) f2));
            scrollTo((int) f2, getScrollY());
            pageScrolled((int) f2);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int b = C0361s.m1617b(motionEvent);
        if (C0361s.m1618b(motionEvent, b) == this.mActivePointerId) {
            b = b == 0 ? 1 : 0;
            this.mLastMotionX = C0361s.m1619c(motionEvent, b);
            this.mActivePointerId = C0361s.m1618b(motionEvent, b);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.mFirstOffset))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() + INVALID_POINTER; childCount >= 0; childCount += INVALID_POINTER) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && ag.m1272a(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return arrowScroll(17);
            case 22:
                return arrowScroll(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (C0331g.m1534a(keyEvent)) {
                    return arrowScroll(2);
                }
                if (C0331g.m1535a(keyEvent, 1)) {
                    return arrowScroll(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean arrowScroll(int i) {
        View view;
        boolean pageLeft;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                pageLeft = pageLeft();
            } else {
                if (i == 66 || i == 2) {
                    pageLeft = pageRight();
                }
                pageLeft = false;
            }
        } else if (i == 17) {
            pageLeft = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left < getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findNextFocus.requestFocus() : pageLeft();
        } else {
            if (i == 66) {
                pageLeft = (view == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).left > getChildRectInPagerCoordinates(this.mTempRect, view).left) ? findNextFocus.requestFocus() : pageRight();
            }
            pageLeft = false;
        }
        if (pageLeft) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return pageLeft;
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return false;
        }
        setCurrentItem(this.mCurItem + INVALID_POINTER, true);
        return true;
    }

    boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.mo804a() + INVALID_POINTER) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C0218b infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.f514b == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0218b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f514b == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = INVALID_POINTER;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount + INVALID_POINTER;
            childCount = INVALID_POINTER;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C0218b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f514b == this.mCurItem && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == CodedOutputStream.DEFAULT_BUFFER_SIZE) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0218b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f514b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0219c();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0219c) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0219c(getContext(), attributeSet);
    }
}
