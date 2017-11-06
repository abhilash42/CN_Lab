package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p008d.C0184d;
import android.support.v4.view.C0361s;
import android.support.v4.view.aw;
import android.support.v4.widget.C0397k;
import android.support.v4.widget.C0407o;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0508k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow */
public class ag {
    private static Method f1461a;
    private static Method f1462c;
    private final C0590c f1463A;
    private Runnable f1464B;
    private final Handler f1465C;
    private Rect f1466D;
    private boolean f1467E;
    private int f1468F;
    int f1469b;
    private Context f1470d;
    private PopupWindow f1471e;
    private ListAdapter f1472f;
    private C0587a f1473g;
    private int f1474h;
    private int f1475i;
    private int f1476j;
    private int f1477k;
    private int f1478l;
    private boolean f1479m;
    private int f1480n;
    private boolean f1481o;
    private boolean f1482p;
    private View f1483q;
    private int f1484r;
    private DataSetObserver f1485s;
    private View f1486t;
    private Drawable f1487u;
    private OnItemClickListener f1488v;
    private OnItemSelectedListener f1489w;
    private final C0594g f1490x;
    private final C0593f f1491y;
    private final C0592e f1492z;

    /* compiled from: ListPopupWindow */
    public static abstract class C0524b implements OnTouchListener {
        private final float f1033a;
        private final int f1034b;
        private final int f1035c;
        private final View f1036d;
        private Runnable f1037e;
        private Runnable f1038f;
        private boolean f1039g;
        private boolean f1040h;
        private int f1041i;
        private final int[] f1042j = new int[2];

        /* compiled from: ListPopupWindow */
        private class C0588a implements Runnable {
            final /* synthetic */ C0524b f1454a;

            private C0588a(C0524b c0524b) {
                this.f1454a = c0524b;
            }

            public void run() {
                this.f1454a.f1036d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* compiled from: ListPopupWindow */
        private class C0589b implements Runnable {
            final /* synthetic */ C0524b f1455a;

            private C0589b(C0524b c0524b) {
                this.f1455a = c0524b;
            }

            public void run() {
                this.f1455a.m2369e();
            }
        }

        public abstract ag mo446a();

        public C0524b(View view) {
            this.f1036d = view;
            this.f1033a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1034b = ViewConfiguration.getTapTimeout();
            this.f1035c = (this.f1034b + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean b;
            boolean z = this.f1039g;
            if (z) {
                b = this.f1040h ? m2366b(motionEvent) : m2366b(motionEvent) || !mo574c();
            } else {
                boolean z2 = m2362a(motionEvent) && mo447b();
                if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.f1036d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                b = z2;
            }
            this.f1039g = b;
            if (b || z) {
                return true;
            }
            return false;
        }

        protected boolean mo447b() {
            ag a = mo446a();
            if (!(a == null || a.m2884k())) {
                a.mo588c();
            }
            return true;
        }

        protected boolean mo574c() {
            ag a = mo446a();
            if (a != null && a.m2884k()) {
                a.m2882i();
            }
            return true;
        }

        private boolean m2362a(MotionEvent motionEvent) {
            View view = this.f1036d;
            if (!view.isEnabled()) {
                return false;
            }
            switch (C0361s.m1615a(motionEvent)) {
                case 0:
                    this.f1041i = motionEvent.getPointerId(0);
                    this.f1040h = false;
                    if (this.f1037e == null) {
                        this.f1037e = new C0588a();
                    }
                    view.postDelayed(this.f1037e, (long) this.f1034b);
                    if (this.f1038f == null) {
                        this.f1038f = new C0589b();
                    }
                    view.postDelayed(this.f1038f, (long) this.f1035c);
                    return false;
                case 1:
                case 3:
                    m2368d();
                    return false;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1041i);
                    if (findPointerIndex < 0 || C0524b.m2363a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1033a)) {
                        return false;
                    }
                    m2368d();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        private void m2368d() {
            if (this.f1038f != null) {
                this.f1036d.removeCallbacks(this.f1038f);
            }
            if (this.f1037e != null) {
                this.f1036d.removeCallbacks(this.f1037e);
            }
        }

        private void m2369e() {
            m2368d();
            View view = this.f1036d;
            if (view.isEnabled() && !view.isLongClickable() && mo447b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                this.f1039g = true;
                this.f1040h = true;
            }
        }

        private boolean m2366b(MotionEvent motionEvent) {
            boolean z = true;
            View view = this.f1036d;
            ag a = mo446a();
            if (a == null || !a.m2884k()) {
                return false;
            }
            View a2 = a.f1473g;
            if (a2 == null || !a2.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            m2367b(view, obtainNoHistory);
            m2364a(a2, obtainNoHistory);
            boolean a3 = a2.m2853a(obtainNoHistory, this.f1041i);
            obtainNoHistory.recycle();
            int a4 = C0361s.m1615a(motionEvent);
            boolean z2;
            if (a4 == 1 || a4 == 3) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!(a3 && r2)) {
                z = false;
            }
            return z;
        }

        private static boolean m2363a(View view, float f, float f2, float f3) {
            return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
        }

        private boolean m2364a(View view, MotionEvent motionEvent) {
            int[] iArr = this.f1042j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
            return true;
        }

        private boolean m2367b(View view, MotionEvent motionEvent) {
            int[] iArr = this.f1042j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            return true;
        }
    }

    /* compiled from: ListPopupWindow */
    class C05841 extends C0524b {
        final /* synthetic */ ag f1437a;

        public ag mo446a() {
            return this.f1437a;
        }
    }

    /* compiled from: ListPopupWindow */
    class C05852 implements Runnable {
        final /* synthetic */ ag f1438a;

        C05852(ag agVar) {
            this.f1438a = agVar;
        }

        public void run() {
            View e = this.f1438a.m2874e();
            if (e != null && e.getWindowToken() != null) {
                this.f1438a.mo588c();
            }
        }
    }

    /* compiled from: ListPopupWindow */
    class C05863 implements OnItemSelectedListener {
        final /* synthetic */ ag f1439a;

        C05863(ag agVar) {
            this.f1439a = agVar;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                C0587a a = this.f1439a.f1473g;
                if (a != null) {
                    a.f1449g = false;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: ListPopupWindow */
    private static class C0587a extends ah {
        private boolean f1449g;
        private boolean f1450h;
        private boolean f1451i;
        private aw f1452j;
        private C0397k f1453k;

        public C0587a(Context context, boolean z) {
            super(context, null, C0498a.dropDownListViewStyle);
            this.f1450h = z;
            setCacheColorHint(0);
        }

        public boolean m2853a(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            int a = C0361s.m1615a(motionEvent);
            switch (a) {
                case 1:
                    z = false;
                    break;
                case 2:
                    z = true;
                    break;
                case 3:
                    z = false;
                    z2 = false;
                    break;
                default:
                    z = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    m2849a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                    if (a == 1) {
                        m2848a(childAt, pointToPosition);
                    }
                    z = false;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                m2851d();
            }
            if (z2) {
                if (this.f1453k == null) {
                    this.f1453k = new C0397k(this);
                }
                this.f1453k.m1713a(true);
                this.f1453k.onTouch(this, motionEvent);
            } else if (this.f1453k != null) {
                this.f1453k.m1713a(false);
            }
            return z2;
        }

        private void m2848a(View view, int i) {
            performItemClick(view, i, getItemIdAtPosition(i));
        }

        private void m2851d() {
            this.f1451i = false;
            setPressed(false);
            drawableStateChanged();
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(false);
            }
            if (this.f1452j != null) {
                this.f1452j.m1461b();
                this.f1452j = null;
            }
        }

        private void m2849a(View view, int i, float f, float f2) {
            this.f1451i = true;
            if (VERSION.SDK_INT >= 21) {
                drawableHotspotChanged(f, f2);
            }
            if (!isPressed()) {
                setPressed(true);
            }
            layoutChildren();
            if (this.f != -1) {
                View childAt = getChildAt(this.f - getFirstVisiblePosition());
                if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                    childAt.setPressed(false);
                }
            }
            this.f = i;
            float left = f - ((float) view.getLeft());
            float top = f2 - ((float) view.getTop());
            if (VERSION.SDK_INT >= 21) {
                view.drawableHotspotChanged(left, top);
            }
            if (!view.isPressed()) {
                view.setPressed(true);
            }
            m2842a(i, view, f, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        protected boolean mo530a() {
            return this.f1451i || super.mo530a();
        }

        public boolean isInTouchMode() {
            return (this.f1450h && this.f1449g) || super.isInTouchMode();
        }

        public boolean hasWindowFocus() {
            return this.f1450h || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f1450h || super.isFocused();
        }

        public boolean hasFocus() {
            return this.f1450h || super.hasFocus();
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0590c implements Runnable {
        final /* synthetic */ ag f1456a;

        private C0590c(ag agVar) {
            this.f1456a = agVar;
        }

        public void run() {
            this.f1456a.m2883j();
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0591d extends DataSetObserver {
        final /* synthetic */ ag f1457a;

        private C0591d(ag agVar) {
            this.f1457a = agVar;
        }

        public void onChanged() {
            if (this.f1457a.m2884k()) {
                this.f1457a.mo588c();
            }
        }

        public void onInvalidated() {
            this.f1457a.m2882i();
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0592e implements OnScrollListener {
        final /* synthetic */ ag f1458a;

        private C0592e(ag agVar) {
            this.f1458a = agVar;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f1458a.m2885l() && this.f1458a.f1471e.getContentView() != null) {
                this.f1458a.f1465C.removeCallbacks(this.f1458a.f1490x);
                this.f1458a.f1490x.run();
            }
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0593f implements OnTouchListener {
        final /* synthetic */ ag f1459a;

        private C0593f(ag agVar) {
            this.f1459a = agVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f1459a.f1471e != null && this.f1459a.f1471e.isShowing() && x >= 0 && x < this.f1459a.f1471e.getWidth() && y >= 0 && y < this.f1459a.f1471e.getHeight()) {
                this.f1459a.f1465C.postDelayed(this.f1459a.f1490x, 250);
            } else if (action == 1) {
                this.f1459a.f1465C.removeCallbacks(this.f1459a.f1490x);
            }
            return false;
        }
    }

    /* compiled from: ListPopupWindow */
    private class C0594g implements Runnable {
        final /* synthetic */ ag f1460a;

        private C0594g(ag agVar) {
            this.f1460a = agVar;
        }

        public void run() {
            if (this.f1460a.f1473g != null && android.support.v4.view.ag.m1300v(this.f1460a.f1473g) && this.f1460a.f1473g.getCount() > this.f1460a.f1473g.getChildCount() && this.f1460a.f1473g.getChildCount() <= this.f1460a.f1469b) {
                this.f1460a.f1471e.setInputMethodMode(2);
                this.f1460a.mo588c();
            }
        }
    }

    static {
        try {
            f1461a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f1462c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public ag(Context context) {
        this(context, null, C0498a.listPopupWindowStyle);
    }

    public ag(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ag(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1474h = -2;
        this.f1475i = -2;
        this.f1478l = 1002;
        this.f1480n = 0;
        this.f1481o = false;
        this.f1482p = false;
        this.f1469b = Integer.MAX_VALUE;
        this.f1484r = 0;
        this.f1490x = new C0594g();
        this.f1491y = new C0593f();
        this.f1492z = new C0592e();
        this.f1463A = new C0590c();
        this.f1466D = new Rect();
        this.f1470d = context;
        this.f1465C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0508k.ListPopupWindow, i, i2);
        this.f1476j = obtainStyledAttributes.getDimensionPixelOffset(C0508k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1477k = obtainStyledAttributes.getDimensionPixelOffset(C0508k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1477k != 0) {
            this.f1479m = true;
        }
        obtainStyledAttributes.recycle();
        this.f1471e = new C0638r(context, attributeSet, i);
        this.f1471e.setInputMethodMode(1);
        this.f1468F = C0184d.m729a(this.f1470d.getResources().getConfiguration().locale);
    }

    public void mo586a(ListAdapter listAdapter) {
        if (this.f1485s == null) {
            this.f1485s = new C0591d();
        } else if (this.f1472f != null) {
            this.f1472f.unregisterDataSetObserver(this.f1485s);
        }
        this.f1472f = listAdapter;
        if (this.f1472f != null) {
            listAdapter.registerDataSetObserver(this.f1485s);
        }
        if (this.f1473g != null) {
            this.f1473g.setAdapter(this.f1472f);
        }
    }

    public void m2862a(int i) {
        this.f1484r = i;
    }

    public void m2868a(boolean z) {
        this.f1467E = z;
        this.f1471e.setFocusable(z);
    }

    public Drawable m2872d() {
        return this.f1471e.getBackground();
    }

    public void m2863a(Drawable drawable) {
        this.f1471e.setBackgroundDrawable(drawable);
    }

    public View m2874e() {
        return this.f1486t;
    }

    public void m2864a(View view) {
        this.f1486t = view;
    }

    public int m2876f() {
        return this.f1476j;
    }

    public void m2869b(int i) {
        this.f1476j = i;
    }

    public int m2878g() {
        if (this.f1479m) {
            return this.f1477k;
        }
        return 0;
    }

    public void m2871c(int i) {
        this.f1477k = i;
        this.f1479m = true;
    }

    public void m2873d(int i) {
        this.f1480n = i;
    }

    public int m2880h() {
        return this.f1475i;
    }

    public void m2875e(int i) {
        this.f1475i = i;
    }

    public void m2877f(int i) {
        Drawable background = this.f1471e.getBackground();
        if (background != null) {
            background.getPadding(this.f1466D);
            this.f1475i = (this.f1466D.left + this.f1466D.right) + i;
            return;
        }
        m2875e(i);
    }

    public void m2865a(OnItemClickListener onItemClickListener) {
        this.f1488v = onItemClickListener;
    }

    public void mo588c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int b = mo587b();
        boolean l = m2885l();
        C0407o.m1819a(this.f1471e, this.f1478l);
        int i2;
        if (this.f1471e.isShowing()) {
            int i3;
            int i4;
            if (this.f1475i == -1) {
                i3 = -1;
            } else if (this.f1475i == -2) {
                i3 = m2874e().getWidth();
            } else {
                i3 = this.f1475i;
            }
            if (this.f1474h == -1) {
                if (!l) {
                    b = -1;
                }
                PopupWindow popupWindow;
                if (l) {
                    popupWindow = this.f1471e;
                    if (this.f1475i == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.f1471e.setHeight(0);
                    i4 = b;
                } else {
                    popupWindow = this.f1471e;
                    if (this.f1475i == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.f1471e.setHeight(-1);
                    i4 = b;
                }
            } else if (this.f1474h == -2) {
                i4 = b;
            } else {
                i4 = this.f1474h;
            }
            PopupWindow popupWindow2 = this.f1471e;
            if (!(this.f1482p || this.f1481o)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.f1471e;
            View e = m2874e();
            b = this.f1476j;
            int i5 = this.f1477k;
            if (i3 < 0) {
                i3 = -1;
            }
            if (i4 >= 0) {
                i = i4;
            }
            popupWindow2.update(e, b, i5, i3, i);
            return;
        }
        if (this.f1475i == -1) {
            i2 = -1;
        } else if (this.f1475i == -2) {
            i2 = m2874e().getWidth();
        } else {
            i2 = this.f1475i;
        }
        if (this.f1474h == -1) {
            b = -1;
        } else if (this.f1474h != -2) {
            b = this.f1474h;
        }
        this.f1471e.setWidth(i2);
        this.f1471e.setHeight(b);
        m2859b(true);
        popupWindow2 = this.f1471e;
        if (this.f1482p || this.f1481o) {
            z = false;
        }
        popupWindow2.setOutsideTouchable(z);
        this.f1471e.setTouchInterceptor(this.f1491y);
        C0407o.m1820a(this.f1471e, m2874e(), this.f1476j, this.f1477k, this.f1480n);
        this.f1473g.setSelection(-1);
        if (!this.f1467E || this.f1473g.isInTouchMode()) {
            m2883j();
        }
        if (!this.f1467E) {
            this.f1465C.post(this.f1463A);
        }
    }

    public void m2882i() {
        this.f1471e.dismiss();
        mo585a();
        this.f1471e.setContentView(null);
        this.f1473g = null;
        this.f1465C.removeCallbacks(this.f1490x);
    }

    public void m2867a(OnDismissListener onDismissListener) {
        this.f1471e.setOnDismissListener(onDismissListener);
    }

    private void mo585a() {
        if (this.f1483q != null) {
            ViewParent parent = this.f1483q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1483q);
            }
        }
    }

    public void m2879g(int i) {
        this.f1471e.setInputMethodMode(i);
    }

    public void m2881h(int i) {
        C0587a c0587a = this.f1473g;
        if (m2884k() && c0587a != null) {
            c0587a.f1449g = false;
            c0587a.setSelection(i);
            if (VERSION.SDK_INT >= 11 && c0587a.getChoiceMode() != 0) {
                c0587a.setItemChecked(i, true);
            }
        }
    }

    public void m2883j() {
        C0587a c0587a = this.f1473g;
        if (c0587a != null) {
            c0587a.f1449g = true;
            c0587a.requestLayout();
        }
    }

    public boolean m2884k() {
        return this.f1471e.isShowing();
    }

    public boolean m2885l() {
        return this.f1471e.getInputMethodMode() == 2;
    }

    public ListView m2886m() {
        return this.f1473g;
    }

    private int mo587b() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.f1473g == null) {
            Context context = this.f1470d;
            this.f1464B = new C05852(this);
            this.f1473g = new C0587a(context, !this.f1467E);
            if (this.f1487u != null) {
                this.f1473g.setSelector(this.f1487u);
            }
            this.f1473g.setAdapter(this.f1472f);
            this.f1473g.setOnItemClickListener(this.f1488v);
            this.f1473g.setFocusable(true);
            this.f1473g.setFocusableInTouchMode(true);
            this.f1473g.setOnItemSelectedListener(new C05863(this));
            this.f1473g.setOnScrollListener(this.f1492z);
            if (this.f1489w != null) {
                this.f1473g.setOnItemSelectedListener(this.f1489w);
            }
            View view2 = this.f1473g;
            View view3 = this.f1483q;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f1484r) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f1484r);
                        break;
                }
                if (this.f1475i >= 0) {
                    i = this.f1475i;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.f1471e.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f1471e.getContentView();
            view = this.f1483q;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f1471e.getBackground();
        if (background != null) {
            background.getPadding(this.f1466D);
            i2 = this.f1466D.top + this.f1466D.bottom;
            if (this.f1479m) {
                i4 = i2;
            } else {
                this.f1477k = -this.f1466D.top;
                i4 = i2;
            }
        } else {
            this.f1466D.setEmpty();
            i4 = 0;
        }
        if (this.f1471e.getInputMethodMode() != 2) {
            z = false;
        }
        i = m2854a(m2874e(), this.f1477k, z);
        if (this.f1481o || this.f1474h == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.f1475i) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1470d.getResources().getDisplayMetrics().widthPixels - (this.f1466D.left + this.f1466D.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1470d.getResources().getDisplayMetrics().widthPixels - (this.f1466D.left + this.f1466D.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1475i, 1073741824);
                break;
        }
        i2 = this.f1473g.m2840a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += i4;
        }
        return i2 + i3;
    }

    private void m2859b(boolean z) {
        if (f1461a != null) {
            try {
                f1461a.invoke(this.f1471e, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int m2854a(View view, int i, boolean z) {
        if (f1462c != null) {
            try {
                return ((Integer) f1462c.invoke(this.f1471e, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1471e.getMaxAvailableHeight(view, i);
    }
}
