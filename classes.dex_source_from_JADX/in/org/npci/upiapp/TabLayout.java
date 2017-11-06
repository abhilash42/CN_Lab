package in.org.npci.upiapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.ActionBar.Tab;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p004a.C0023a;
import android.support.v4.p009e.C0203h.C0200a;
import android.support.v4.p009e.C0203h.C0201b;
import android.support.v4.p009e.C0203h.C0202c;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0223f;
import android.support.v4.view.ab;
import android.support.v4.view.ag;
import android.support.v4.view.p011b.C0315a;
import android.support.v4.widget.C0426x;
import android.support.v7.p013b.C0509a.C0508k;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import in.org.npci.upiapp.C1427f.C1426a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    private static final int INVALID_WIDTH = -1;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final C0200a<C1374d> sTabPool = new C0202c(16);
    private int mContentInsetStart;
    private C1369a mCurrentVpSelectedListener;
    int mMode;
    private C1375e mPageChangeListener;
    private ab mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private final int mRequestedTabMaxWidth;
    private final int mRequestedTabMinWidth;
    private ValueAnimator mScrollAnimator;
    private final int mScrollableTabMinWidth;
    private C1369a mSelectedListener;
    private final ArrayList<C1369a> mSelectedListeners;
    private C1374d mSelectedTab;
    private boolean mSetupViewPagerImplicitly;
    final int mTabBackgroundResId;
    int mTabGravity;
    int mTabMaxWidth;
    int mTabPaddingBottom;
    int mTabPaddingEnd;
    int mTabPaddingStart;
    int mTabPaddingTop;
    private final C1373c mTabStrip;
    int mTabTextAppearance;
    ColorStateList mTabTextColors;
    float mTabTextMultiLineSize;
    float mTabTextSize;
    private final C0200a<C1376f> mTabViewPool;
    private final ArrayList<C1374d> mTabs;
    ViewPager mViewPager;

    class C13681 implements AnimatorUpdateListener {
        final /* synthetic */ TabLayout f3213a;

        C13681(TabLayout tabLayout) {
            this.f3213a = tabLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3213a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public interface C1369a {
        void mo796a(C1374d c1374d);

        void mo797b(C1374d c1374d);

        void mo798c(C1374d c1374d);
    }

    private class C1370b extends DataSetObserver {
        final /* synthetic */ TabLayout f3214a;

        C1370b(TabLayout tabLayout) {
            this.f3214a = tabLayout;
        }

        public void onChanged() {
            this.f3214a.populateFromPagerAdapter();
        }

        public void onInvalidated() {
            this.f3214a.populateFromPagerAdapter();
        }
    }

    private class C1373c extends LinearLayout {
        int f3222a = TabLayout.INVALID_WIDTH;
        float f3223b;
        final /* synthetic */ TabLayout f3224c;
        private int f3225d;
        private final Paint f3226e;
        private int f3227f = TabLayout.INVALID_WIDTH;
        private int f3228g = TabLayout.INVALID_WIDTH;
        private ValueAnimator f3229h;

        C1373c(TabLayout tabLayout, Context context) {
            this.f3224c = tabLayout;
            super(context);
            setWillNotDraw(false);
            this.f3226e = new Paint();
        }

        void m5242a(int i) {
            if (this.f3226e.getColor() != i) {
                this.f3226e.setColor(i);
                ag.m1274b(this);
            }
        }

        void m5247b(int i) {
            if (this.f3225d != i) {
                this.f3225d = i;
                ag.m1274b(this);
            }
        }

        boolean m5245a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void m5243a(int i, float f) {
            if (this.f3229h != null && this.f3229h.isRunning()) {
                this.f3229h.cancel();
            }
            this.f3222a = i;
            this.f3223b = f;
            m5240c();
        }

        float m5246b() {
            return ((float) this.f3222a) + this.f3223b;
        }

        protected void onMeasure(int i, int i2) {
            boolean z = false;
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824 && this.f3224c.mMode == 1 && this.f3224c.mTabGravity == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    int max;
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        max = Math.max(i4, childAt.getMeasuredWidth());
                    } else {
                        max = i4;
                    }
                    i3++;
                    i4 = max;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (this.f3224c.dpToPx(16) * 2)) {
                        i3 = 0;
                        while (i3 < childCount) {
                            boolean z2;
                            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                z2 = z;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                z2 = true;
                            }
                            i3++;
                            z = z2;
                        }
                    } else {
                        this.f3224c.mTabGravity = 0;
                        this.f3224c.updateTabViews(false);
                        z = true;
                    }
                    if (z) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f3229h == null || !this.f3229h.isRunning()) {
                m5240c();
                return;
            }
            this.f3229h.cancel();
            m5244a(this.f3222a, Math.round(((float) this.f3229h.getDuration()) * (1.0f - this.f3229h.getAnimatedFraction())));
        }

        private void m5240c() {
            int i;
            int i2;
            View childAt = getChildAt(this.f3222a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = TabLayout.INVALID_WIDTH;
                i2 = TabLayout.INVALID_WIDTH;
            } else {
                i2 = childAt.getLeft();
                i = childAt.getRight();
                if (this.f3223b > 0.0f && this.f3222a < getChildCount() + TabLayout.INVALID_WIDTH) {
                    View childAt2 = getChildAt(this.f3222a + 1);
                    i2 = (int) ((((float) i2) * (1.0f - this.f3223b)) + (this.f3223b * ((float) childAt2.getLeft())));
                    i = (int) ((((float) i) * (1.0f - this.f3223b)) + (((float) childAt2.getRight()) * this.f3223b));
                }
            }
            m5241a((float) i2, (float) i);
        }

        void m5241a(float f, float f2) {
            if (f != ((float) this.f3227f) || f2 != ((float) this.f3228g)) {
                this.f3227f = (int) f;
                this.f3228g = (int) f2;
                ag.m1274b(this);
            }
        }

        void m5244a(final int i, int i2) {
            if (this.f3229h != null && this.f3229h.isRunning()) {
                this.f3229h.cancel();
            }
            Object obj = ag.m1283e(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                m5240c();
                return;
            }
            int i3;
            int i4;
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.f3222a) <= 1) {
                i3 = this.f3227f;
                i4 = this.f3228g;
            } else {
                int dpToPx = this.f3224c.dpToPx(24);
                if (i < this.f3222a) {
                    if (obj != null) {
                        i4 = left - dpToPx;
                        i3 = i4;
                    } else {
                        i4 = right + dpToPx;
                        i3 = i4;
                    }
                } else if (obj != null) {
                    i4 = right + dpToPx;
                    i3 = i4;
                } else {
                    i4 = left - dpToPx;
                    i3 = i4;
                }
            }
            if (i3 != left || i4 != right) {
                ValueAnimator a = C1430h.m5417a();
                this.f3229h = a;
                a.setInterpolator(new C0315a());
                a.setDuration((long) i2);
                a.setFloatValues(new float[]{0.0f, 1.0f});
                a.addUpdateListener(new AnimatorUpdateListener(this) {
                    final /* synthetic */ C1373c f3219e;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        this.f3219e.m5241a((float) C1430h.m5416a(i3, left, animatedFraction), (float) C1430h.m5416a(i4, right, animatedFraction));
                    }
                });
                a.addListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ C1373c f3221b;

                    public void onAnimationEnd(Animator animator) {
                        this.f3221b.f3222a = i;
                        this.f3221b.f3223b = 0.0f;
                    }
                });
                a.start();
            }
        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.f3227f >= 0 && this.f3228g > this.f3227f) {
                canvas.drawRect((float) this.f3227f, (float) (getHeight() - this.f3225d), (float) this.f3228g, (float) getHeight(), this.f3226e);
            }
        }
    }

    public static final class C1374d {
        TabLayout f3230a;
        C1376f f3231b;
        private Object f3232c;
        private Drawable f3233d;
        private CharSequence f3234e;
        private CharSequence f3235f;
        private int f3236g = TabLayout.INVALID_WIDTH;
        private View f3237h;

        C1374d() {
        }

        public View m5248a() {
            return this.f3237h;
        }

        public C1374d m5251a(View view) {
            this.f3237h = view;
            m5261h();
            return this;
        }

        public C1374d m5249a(int i) {
            return m5251a(LayoutInflater.from(this.f3231b.getContext()).inflate(i, this.f3231b, false));
        }

        public Drawable m5253b() {
            return this.f3233d;
        }

        public int m5256c() {
            return this.f3236g;
        }

        void m5255b(int i) {
            this.f3236g = i;
        }

        public CharSequence m5257d() {
            return this.f3234e;
        }

        public C1374d m5250a(Drawable drawable) {
            this.f3233d = drawable;
            m5261h();
            return this;
        }

        public C1374d m5252a(CharSequence charSequence) {
            this.f3234e = charSequence;
            m5261h();
            return this;
        }

        public void m5258e() {
            if (this.f3230a == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.f3230a.selectTab(this);
        }

        public boolean m5259f() {
            if (this.f3230a != null) {
                return this.f3230a.getSelectedTabPosition() == this.f3236g;
            } else {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
        }

        public C1374d m5254b(CharSequence charSequence) {
            this.f3235f = charSequence;
            m5261h();
            return this;
        }

        public CharSequence m5260g() {
            return this.f3235f;
        }

        void m5261h() {
            if (this.f3231b != null) {
                this.f3231b.m5271b();
            }
        }

        void m5262i() {
            this.f3230a = null;
            this.f3231b = null;
            this.f3232c = null;
            this.f3233d = null;
            this.f3234e = null;
            this.f3235f = null;
            this.f3236g = TabLayout.INVALID_WIDTH;
            this.f3237h = null;
        }
    }

    public static class C1375e implements C0223f {
        private final WeakReference<TabLayout> f3238a;
        private int f3239b;
        private int f3240c;

        public C1375e(TabLayout tabLayout) {
            this.f3238a = new WeakReference(tabLayout);
        }

        public void mo795b(int i) {
            this.f3239b = this.f3240c;
            this.f3240c = i;
        }

        public void mo794a(int i, float f, int i2) {
            boolean z = false;
            TabLayout tabLayout = (TabLayout) this.f3238a.get();
            if (tabLayout != null) {
                boolean z2 = this.f3240c != 2 || this.f3239b == 1;
                if (!(this.f3240c == 2 && this.f3239b == 0)) {
                    z = true;
                }
                tabLayout.setScrollPosition(i, f, z2, z);
            }
        }

        public void mo793a(int i) {
            TabLayout tabLayout = (TabLayout) this.f3238a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                boolean z = this.f3240c == 0 || (this.f3240c == 2 && this.f3239b == 0);
                tabLayout.selectTab(tabLayout.getTabAt(i), z);
            }
        }

        void m5263a() {
            this.f3240c = 0;
            this.f3239b = 0;
        }
    }

    class C1376f extends LinearLayout implements OnLongClickListener {
        final /* synthetic */ TabLayout f3241a;
        private C1374d f3242b;
        private TextView f3243c;
        private ImageView f3244d;
        private View f3245e;
        private TextView f3246f;
        private ImageView f3247g;
        private int f3248h = 2;

        public C1376f(TabLayout tabLayout, Context context) {
            this.f3241a = tabLayout;
            super(context);
            if (tabLayout.mTabBackgroundResId != 0) {
                setBackground(C0023a.m77a(context, tabLayout.mTabBackgroundResId));
            }
            ag.m1263a(this, tabLayout.mTabPaddingStart, tabLayout.mTabPaddingTop, tabLayout.mTabPaddingEnd, tabLayout.mTabPaddingBottom);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f3242b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f3242b.m5258e();
            return true;
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z && VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.f3243c != null) {
                this.f3243c.setSelected(z);
            }
            if (this.f3244d != null) {
                this.f3244d.setSelected(z);
            }
            if (this.f3245e != null) {
                this.f3245e.setSelected(z);
            }
        }

        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(Tab.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(Tab.class.getName());
        }

        public void onMeasure(int i, int i2) {
            int i3 = 1;
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int tabMaxWidth = this.f3241a.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = MeasureSpec.makeMeasureSpec(this.f3241a.mTabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f3243c != null) {
                getResources();
                float f = this.f3241a.mTabTextSize;
                size = this.f3248h;
                if (this.f3244d != null && this.f3244d.getVisibility() == 0) {
                    size = 1;
                } else if (this.f3243c != null && this.f3243c.getLineCount() > 1) {
                    f = this.f3241a.mTabTextMultiLineSize;
                }
                float textSize = this.f3243c.getTextSize();
                int lineCount = this.f3243c.getLineCount();
                int a = C0426x.m1897a(this.f3243c);
                if (f != textSize || (a >= 0 && size != a)) {
                    if (this.f3241a.mMode == 1 && f > textSize && lineCount == 1) {
                        Layout layout = this.f3243c.getLayout();
                        if (layout == null || m5267a(layout, 0, f) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.f3243c.setTextSize(0, f);
                        this.f3243c.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        void m5270a(C1374d c1374d) {
            if (c1374d != this.f3242b) {
                this.f3242b = c1374d;
                m5271b();
            }
        }

        void m5269a() {
            m5270a(null);
            setSelected(false);
        }

        final void m5271b() {
            boolean z;
            C1374d c1374d = this.f3242b;
            View a = c1374d != null ? c1374d.m5248a() : null;
            if (a != null) {
                C1376f parent = a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(a);
                    }
                    addView(a);
                }
                this.f3245e = a;
                if (this.f3243c != null) {
                    this.f3243c.setVisibility(8);
                }
                if (this.f3244d != null) {
                    this.f3244d.setVisibility(8);
                    this.f3244d.setImageDrawable(null);
                }
                this.f3246f = (TextView) a.findViewById(16908308);
                if (this.f3246f != null) {
                    this.f3248h = C0426x.m1897a(this.f3246f);
                }
                this.f3247g = (ImageView) a.findViewById(16908294);
            } else {
                if (this.f3245e != null) {
                    removeView(this.f3245e);
                    this.f3245e = null;
                }
                this.f3246f = null;
                this.f3247g = null;
            }
            if (this.f3245e == null) {
                if (this.f3244d == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(2130968603, this, false);
                    addView(imageView, 0);
                    this.f3244d = imageView;
                }
                if (this.f3243c == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(2130968604, this, false);
                    addView(textView);
                    this.f3243c = textView;
                    this.f3248h = C0426x.m1897a(this.f3243c);
                }
                C0426x.m1898a(this.f3243c, this.f3241a.mTabTextAppearance);
                if (this.f3241a.mTabTextColors != null) {
                    this.f3243c.setTextColor(this.f3241a.mTabTextColors);
                }
                m5268a(this.f3243c, this.f3244d);
            } else if (!(this.f3246f == null && this.f3247g == null)) {
                m5268a(this.f3246f, this.f3247g);
            }
            if (c1374d == null || !c1374d.m5259f()) {
                z = false;
            } else {
                z = true;
            }
            setSelected(z);
        }

        private void m5268a(TextView textView, ImageView imageView) {
            CharSequence d;
            CharSequence g;
            boolean z;
            Drawable b = this.f3242b != null ? this.f3242b.m5253b() : null;
            if (this.f3242b != null) {
                d = this.f3242b.m5257d();
            } else {
                d = null;
            }
            if (this.f3242b != null) {
                g = this.f3242b.m5260g();
            } else {
                g = null;
            }
            if (imageView != null) {
                if (b != null) {
                    imageView.setImageDrawable(b);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(g);
            }
            if (TextUtils.isEmpty(d)) {
                z = false;
            } else {
                z = true;
            }
            if (textView != null) {
                if (z) {
                    textView.setText(d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(g);
            }
            if (imageView != null) {
                int dpToPx;
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    dpToPx = this.f3241a.dpToPx(8);
                } else {
                    dpToPx = 0;
                }
                if (dpToPx != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = dpToPx;
                    imageView.requestLayout();
                }
            }
            if (z || TextUtils.isEmpty(g)) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            Rect rect = new Rect();
            getLocationOnScreen(iArr);
            getWindowVisibleDisplayFrame(rect);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = iArr[1] + (height / 2);
            width = (width / 2) + iArr[0];
            if (ag.m1283e(view) == 0) {
                width = context.getResources().getDisplayMetrics().widthPixels - width;
            }
            Toast makeText = Toast.makeText(context, this.f3242b.m5260g(), 0);
            if (i < rect.height()) {
                makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
            } else {
                makeText.setGravity(81, 0, height);
            }
            makeText.show();
            return true;
        }

        private float m5267a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }
    }

    public static class C1377g implements C1369a {
        private final ViewPager f3249a;

        public C1377g(ViewPager viewPager) {
            this.f3249a = viewPager;
        }

        public void mo796a(C1374d c1374d) {
            this.f3249a.setCurrentItem(c1374d.m5256c());
        }

        public void mo797b(C1374d c1374d) {
        }

        public void mo798c(C1374d c1374d) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList();
        this.mTabMaxWidth = Integer.MAX_VALUE;
        this.mSelectedListeners = new ArrayList();
        this.mTabViewPool = new C0201b(12);
        C1430h.m5418a(context);
        setHorizontalScrollBarEnabled(false);
        this.mTabStrip = new C1373c(this, context);
        super.addView(this.mTabStrip, 0, new FrameLayout.LayoutParams(-2, INVALID_WIDTH));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1426a.TabLayout);
        this.mTabStrip.m5247b(obtainStyledAttributes.getDimensionPixelSize(1, 0));
        this.mTabStrip.m5242a(obtainStyledAttributes.getColor(0, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(13, 0);
        this.mTabPaddingBottom = dimensionPixelSize;
        this.mTabPaddingEnd = dimensionPixelSize;
        this.mTabPaddingTop = dimensionPixelSize;
        this.mTabPaddingStart = dimensionPixelSize;
        this.mTabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(9, this.mTabPaddingStart);
        this.mTabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(10, this.mTabPaddingTop);
        this.mTabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(11, this.mTabPaddingEnd);
        this.mTabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(12, this.mTabPaddingBottom);
        this.mTabTextAppearance = obtainStyledAttributes.getResourceId(6, 2131362022);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.mTabTextAppearance, C0508k.TextAppearance);
        try {
            this.mTabTextSize = (float) obtainStyledAttributes2.getDimensionPixelSize(0, 0);
            this.mTabTextColors = obtainStyledAttributes2.getColorStateList(3);
            if (obtainStyledAttributes.hasValue(7)) {
                this.mTabTextColors = obtainStyledAttributes.getColorStateList(7);
            }
            if (obtainStyledAttributes.hasValue(8)) {
                this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), obtainStyledAttributes.getColor(8, 0));
            }
            this.mRequestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(4, INVALID_WIDTH);
            this.mRequestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(5, INVALID_WIDTH);
            this.mTabBackgroundResId = obtainStyledAttributes.getResourceId(3, 0);
            this.mContentInsetStart = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.mMode = obtainStyledAttributes.getInt(14, 1);
            this.mTabGravity = obtainStyledAttributes.getInt(15, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.mTabTextMultiLineSize = (float) resources.getDimensionPixelSize(2131296330);
            this.mScrollableTabMinWidth = resources.getDimensionPixelSize(2131296328);
            applyModeAndGravity();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.mTabStrip.m5242a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.mTabStrip.m5247b(i);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        setScrollPosition(i, f, z, true);
    }

    void setScrollPosition(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.mTabStrip.getChildCount()) {
            if (z2) {
                this.mTabStrip.m5243a(i, f);
            }
            if (this.mScrollAnimator != null && this.mScrollAnimator.isRunning()) {
                this.mScrollAnimator.cancel();
            }
            scrollTo(calculateScrollXForTab(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        return this.mTabStrip.m5246b();
    }

    public void addTab(C1374d c1374d) {
        addTab(c1374d, this.mTabs.isEmpty());
    }

    public void addTab(C1374d c1374d, int i) {
        addTab(c1374d, i, this.mTabs.isEmpty());
    }

    public void addTab(C1374d c1374d, boolean z) {
        addTab(c1374d, this.mTabs.size(), z);
    }

    public void addTab(C1374d c1374d, int i, boolean z) {
        if (c1374d.f3230a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        configureTab(c1374d, i);
        addTabView(c1374d);
        if (z) {
            c1374d.m5258e();
        }
    }

    private void addTabFromItemView(C1428g c1428g) {
        C1374d newTab = newTab();
        if (c1428g.f3546a != null) {
            newTab.m5252a(c1428g.f3546a);
        }
        if (c1428g.f3547b != null) {
            newTab.m5250a(c1428g.f3547b);
        }
        if (c1428g.f3548c != 0) {
            newTab.m5249a(c1428g.f3548c);
        }
        if (!TextUtils.isEmpty(c1428g.getContentDescription())) {
            newTab.m5254b(c1428g.getContentDescription());
        }
        addTab(newTab);
    }

    @Deprecated
    public void setOnTabSelectedListener(C1369a c1369a) {
        if (this.mSelectedListener != null) {
            removeOnTabSelectedListener(this.mSelectedListener);
        }
        this.mSelectedListener = c1369a;
        if (c1369a != null) {
            addOnTabSelectedListener(c1369a);
        }
    }

    public void addOnTabSelectedListener(C1369a c1369a) {
        if (!this.mSelectedListeners.contains(c1369a)) {
            this.mSelectedListeners.add(c1369a);
        }
    }

    public void removeOnTabSelectedListener(C1369a c1369a) {
        this.mSelectedListeners.remove(c1369a);
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    public C1374d newTab() {
        C1374d c1374d = (C1374d) sTabPool.mo120a();
        if (c1374d == null) {
            c1374d = new C1374d();
        }
        c1374d.f3230a = this;
        c1374d.f3231b = createTabView(c1374d);
        return c1374d;
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public C1374d getTabAt(int i) {
        return (i < 0 || i >= getTabCount()) ? null : (C1374d) this.mTabs.get(i);
    }

    public int getSelectedTabPosition() {
        return this.mSelectedTab != null ? this.mSelectedTab.m5256c() : INVALID_WIDTH;
    }

    public void removeTab(C1374d c1374d) {
        if (c1374d.f3230a != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(c1374d.m5256c());
    }

    public void removeTabAt(int i) {
        int c = this.mSelectedTab != null ? this.mSelectedTab.m5256c() : 0;
        removeTabViewAt(i);
        C1374d c1374d = (C1374d) this.mTabs.remove(i);
        if (c1374d != null) {
            c1374d.m5262i();
            sTabPool.mo121a(c1374d);
        }
        int size = this.mTabs.size();
        for (int i2 = i; i2 < size; i2++) {
            ((C1374d) this.mTabs.get(i2)).m5255b(i2);
        }
        if (c == i) {
            selectTab(this.mTabs.isEmpty() ? null : (C1374d) this.mTabs.get(Math.max(0, i + INVALID_WIDTH)));
        }
    }

    public void removeAllTabs() {
        for (int childCount = this.mTabStrip.getChildCount() + INVALID_WIDTH; childCount >= 0; childCount += INVALID_WIDTH) {
            removeTabViewAt(childCount);
        }
        Iterator it = this.mTabs.iterator();
        while (it.hasNext()) {
            C1374d c1374d = (C1374d) it.next();
            it.remove();
            c1374d.m5262i();
            sTabPool.mo121a(c1374d);
        }
        this.mSelectedTab = null;
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            applyModeAndGravity();
        }
    }

    public int getTabMode() {
        return this.mMode;
    }

    public void setTabGravity(int i) {
        if (this.mTabGravity != i) {
            this.mTabGravity = i;
            applyModeAndGravity();
        }
    }

    public int getTabGravity() {
        return this.mTabGravity;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.mTabTextColors != colorStateList) {
            this.mTabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.mTabTextColors;
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, false);
    }

    private void setupWithViewPager(ViewPager viewPager, boolean z, boolean z2) {
        if (!(this.mViewPager == null || this.mPageChangeListener == null)) {
            this.mViewPager.removeOnPageChangeListener(this.mPageChangeListener);
        }
        if (this.mCurrentVpSelectedListener != null) {
            removeOnTabSelectedListener(this.mCurrentVpSelectedListener);
            this.mCurrentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.mViewPager = viewPager;
            if (this.mPageChangeListener == null) {
                this.mPageChangeListener = new C1375e(this);
            }
            this.mPageChangeListener.m5263a();
            viewPager.addOnPageChangeListener(this.mPageChangeListener);
            this.mCurrentVpSelectedListener = new C1377g(viewPager);
            addOnTabSelectedListener(this.mCurrentVpSelectedListener);
            ab adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.mViewPager = null;
            setPagerAdapter(null, false);
        }
        this.mSetupViewPagerImplicitly = z2;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(ab abVar) {
        setPagerAdapter(abVar, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mSetupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.mSetupViewPagerImplicitly = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.mTabStrip.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    void setPagerAdapter(ab abVar, boolean z) {
        if (!(this.mPagerAdapter == null || this.mPagerAdapterObserver == null)) {
            this.mPagerAdapter.m1104b(this.mPagerAdapterObserver);
        }
        this.mPagerAdapter = abVar;
        if (z && abVar != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new C1370b(this);
            }
            abVar.m1095a(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    void populateFromPagerAdapter() {
        removeAllTabs();
        if (this.mPagerAdapter != null) {
            int i;
            int a = this.mPagerAdapter.mo804a();
            for (i = 0; i < a; i++) {
                addTab(newTab().m5252a(this.mPagerAdapter.mo805a(i)), false);
            }
            if (this.mViewPager != null && a > 0) {
                i = this.mViewPager.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    selectTab(getTabAt(i));
                }
            }
        }
    }

    private void updateAllTabs() {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            ((C1374d) this.mTabs.get(i)).m5261h();
        }
    }

    private C1376f createTabView(C1374d c1374d) {
        C1376f c1376f = this.mTabViewPool != null ? (C1376f) this.mTabViewPool.mo120a() : null;
        if (c1376f == null) {
            c1376f = new C1376f(this, getContext());
        }
        c1376f.m5270a(c1374d);
        c1376f.setFocusable(true);
        c1376f.setMinimumWidth(getTabMinWidth());
        return c1376f;
    }

    private void configureTab(C1374d c1374d, int i) {
        c1374d.m5255b(i);
        this.mTabs.add(i, c1374d);
        int size = this.mTabs.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((C1374d) this.mTabs.get(i2)).m5255b(i2);
        }
    }

    private void addTabView(C1374d c1374d) {
        this.mTabStrip.addView(c1374d.f3231b, c1374d.m5256c(), createLayoutParamsForTabs());
    }

    public void addView(View view) {
        addViewInternal(view);
    }

    public void addView(View view, int i) {
        addViewInternal(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    private void addViewInternal(View view) {
        if (view instanceof C1428g) {
            addTabFromItemView((C1428g) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LayoutParams createLayoutParamsForTabs() {
        LayoutParams layoutParams = new LayoutParams(-2, INVALID_WIDTH);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private void updateTabViewLayoutParams(LayoutParams layoutParams) {
        if (this.mMode == 1 && this.mTabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    int dpToPx(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int dpToPx = (dpToPx(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(dpToPx, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(dpToPx, 1073741824);
                break;
        }
        dpToPx = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.mRequestedTabMaxWidth > 0) {
                dpToPx = this.mRequestedTabMaxWidth;
            } else {
                dpToPx -= dpToPx(56);
            }
            this.mTabMaxWidth = dpToPx;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.mMode) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        dpToPx = 0;
                        break;
                    } else {
                        dpToPx = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    dpToPx = i3;
                    break;
                default:
                    dpToPx = 0;
                    break;
            }
            if (dpToPx != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void removeTabViewAt(int i) {
        C1376f c1376f = (C1376f) this.mTabStrip.getChildAt(i);
        this.mTabStrip.removeViewAt(i);
        if (c1376f != null) {
            c1376f.m5269a();
            this.mTabViewPool.mo121a(c1376f);
        }
        requestLayout();
    }

    private void animateToTab(int i) {
        if (i != INVALID_WIDTH) {
            if (getWindowToken() == null || !ag.m1299u(this) || this.mTabStrip.m5245a()) {
                setScrollPosition(i, 0.0f, true);
                return;
            }
            if (getScrollX() != calculateScrollXForTab(i, 0.0f)) {
                if (this.mScrollAnimator == null) {
                    this.mScrollAnimator = C1430h.m5417a();
                    this.mScrollAnimator.setInterpolator(new C0315a());
                    this.mScrollAnimator.setDuration(300);
                    this.mScrollAnimator.addUpdateListener(new C13681(this));
                }
                this.mScrollAnimator.setIntValues(new int[]{r0, r1});
                this.mScrollAnimator.start();
            }
            this.mTabStrip.m5244a(i, (int) ANIMATION_DURATION);
        }
    }

    public void setSelectedTabView(int i) {
        int childCount = this.mTabStrip.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.mTabStrip.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    void selectTab(C1374d c1374d) {
        selectTab(c1374d, true);
    }

    void selectTab(C1374d c1374d, boolean z) {
        C1374d c1374d2 = this.mSelectedTab;
        if (c1374d2 != c1374d) {
            int c = c1374d != null ? c1374d.m5256c() : INVALID_WIDTH;
            if (z) {
                if ((c1374d2 == null || c1374d2.m5256c() == INVALID_WIDTH) && c != INVALID_WIDTH) {
                    setScrollPosition(c, 0.0f, true);
                } else {
                    animateToTab(c);
                }
                if (c != INVALID_WIDTH) {
                    setSelectedTabView(c);
                }
            }
            if (c1374d2 != null) {
                dispatchTabUnselected(c1374d2);
            }
            this.mSelectedTab = c1374d;
            if (c1374d != null) {
                dispatchTabSelected(c1374d);
            }
        } else if (c1374d2 != null) {
            dispatchTabReselected(c1374d);
            animateToTab(c1374d.m5256c());
        }
    }

    private void dispatchTabSelected(C1374d c1374d) {
        for (int size = this.mSelectedListeners.size() + INVALID_WIDTH; size >= 0; size += INVALID_WIDTH) {
            ((C1369a) this.mSelectedListeners.get(size)).mo796a(c1374d);
        }
    }

    private void dispatchTabUnselected(C1374d c1374d) {
        for (int size = this.mSelectedListeners.size() + INVALID_WIDTH; size >= 0; size += INVALID_WIDTH) {
            ((C1369a) this.mSelectedListeners.get(size)).mo797b(c1374d);
        }
    }

    private void dispatchTabReselected(C1374d c1374d) {
        for (int size = this.mSelectedListeners.size() + INVALID_WIDTH; size >= 0; size += INVALID_WIDTH) {
            ((C1369a) this.mSelectedListeners.get(size)).mo798c(c1374d);
        }
    }

    private int calculateScrollXForTab(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        int width;
        View childAt = this.mTabStrip.getChildAt(i);
        View childAt2 = i + 1 < this.mTabStrip.getChildCount() ? this.mTabStrip.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private void applyModeAndGravity() {
        int max;
        if (this.mMode == 0) {
            max = Math.max(0, this.mContentInsetStart - this.mTabPaddingStart);
        } else {
            max = 0;
        }
        ag.m1263a(this.mTabStrip, max, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.mTabStrip.setGravity(8388611);
                break;
            case 1:
                this.mTabStrip.setGravity(1);
                break;
        }
        updateTabViews(true);
    }

    void updateTabViews(boolean z) {
        for (int i = 0; i < this.mTabStrip.getChildCount(); i++) {
            View childAt = this.mTabStrip.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private static ColorStateList createColorStateList(int i, int i2) {
        r0 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r0[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r0, iArr);
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            C1374d c1374d = (C1374d) this.mTabs.get(i);
            if (c1374d != null && c1374d.m5253b() != null && !TextUtils.isEmpty(c1374d.m5257d())) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        if (this.mRequestedTabMinWidth != INVALID_WIDTH) {
            return this.mRequestedTabMinWidth;
        }
        return this.mMode == 0 ? this.mScrollableTabMinWidth : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    int getTabMaxWidth() {
        return this.mTabMaxWidth;
    }
}
