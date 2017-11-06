package android.support.v7.p012a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0139v;
import android.support.v4.view.C0124m;
import android.support.v4.view.C0337i;
import android.support.v4.view.aa;
import android.support.v4.view.ag;
import android.support.v4.view.ar;
import android.support.v4.view.aw;
import android.support.v4.view.bb;
import android.support.v4.view.bd;
import android.support.v4.widget.C0407o;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0500c;
import android.support.v7.p013b.C0509a.C0503f;
import android.support.v7.p013b.C0509a.C0505h;
import android.support.v7.p013b.C0509a.C0507j;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.C0494b;
import android.support.v7.view.C0494b.C0476a;
import android.support.v7.view.C0515d;
import android.support.v7.view.C0516e;
import android.support.v7.view.menu.C0530m;
import android.support.v7.view.menu.C0532l.C0473a;
import android.support.v7.view.menu.C0537e;
import android.support.v7.view.menu.C0538f;
import android.support.v7.view.menu.C0538f.C0457a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.C0632l;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.C0468a;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ab;
import android.support.v7.widget.ae;
import android.support.v7.widget.ae.C0466a;
import android.support.v7.widget.at;
import android.support.v7.widget.au;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* compiled from: AppCompatDelegateImplV7 */
class C0458l extends C0456h implements C0124m, C0457a {
    private boolean f821A;
    private C0479d[] f822B;
    private C0479d f823C;
    private boolean f824D;
    private boolean f825E;
    private int f826F;
    private final Runnable f827G = new C04641(this);
    private boolean f828H;
    private Rect f829I;
    private Rect f830J;
    private C0482n f831K;
    C0494b f832m;
    ActionBarContextView f833n;
    PopupWindow f834o;
    Runnable f835p;
    aw f836q = null;
    private ab f837r;
    private C0474a f838s;
    private C0480e f839t;
    private boolean f840u;
    private ViewGroup f841v;
    private TextView f842w;
    private View f843x;
    private boolean f844y;
    private boolean f845z;

    /* compiled from: AppCompatDelegateImplV7 */
    class C04641 implements Runnable {
        final /* synthetic */ C0458l f853a;

        C04641(C0458l c0458l) {
            this.f853a = c0458l;
        }

        public void run() {
            if ((this.f853a.f826F & 1) != 0) {
                this.f853a.m2079f(0);
            }
            if ((this.f853a.f826F & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0) {
                this.f853a.m2079f(108);
            }
            this.f853a.f825E = false;
            this.f853a.f826F = 0;
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    class C04652 implements aa {
        final /* synthetic */ C0458l f854a;

        C04652(C0458l c0458l) {
            this.f854a = c0458l;
        }

        public bd mo122a(View view, bd bdVar) {
            int b = bdVar.mo266b();
            int c = this.f854a.m2080g(b);
            if (b != c) {
                bdVar = bdVar.mo265a(bdVar.mo264a(), c, bdVar.mo267c(), bdVar.mo268d());
            }
            return ag.m1260a(view, bdVar);
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    class C04673 implements C0466a {
        final /* synthetic */ C0458l f855a;

        C04673(C0458l c0458l) {
            this.f855a = c0458l;
        }

        public void mo398a(Rect rect) {
            rect.top = this.f855a.m2080g(rect.top);
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    class C04694 implements C0468a {
        final /* synthetic */ C0458l f856a;

        C04694(C0458l c0458l) {
            this.f856a = c0458l;
        }

        public void mo399a() {
        }

        public void mo400b() {
            this.f856a.m2087x();
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    class C04715 implements Runnable {
        final /* synthetic */ C0458l f858a;

        /* compiled from: AppCompatDelegateImplV7 */
        class C04701 extends bb {
            final /* synthetic */ C04715 f857a;

            C04701(C04715 c04715) {
                this.f857a = c04715;
            }

            public void mo261b(View view) {
                ag.m1275b(this.f857a.f858a.f833n, 1.0f);
                this.f857a.f858a.f836q.m1456a(null);
                this.f857a.f858a.f836q = null;
            }

            public void mo260a(View view) {
                this.f857a.f858a.f833n.setVisibility(0);
            }
        }

        C04715(C0458l c0458l) {
            this.f858a = c0458l;
        }

        public void run() {
            this.f858a.f834o.showAtLocation(this.f858a.f833n, 55, 0, 0);
            this.f858a.m2085v();
            ag.m1275b(this.f858a.f833n, 0.0f);
            this.f858a.f836q = ag.m1290l(this.f858a.f833n).m1454a(1.0f);
            this.f858a.f836q.m1456a(new C04701(this));
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    class C04726 extends bb {
        final /* synthetic */ C0458l f859a;

        C04726(C0458l c0458l) {
            this.f859a = c0458l;
        }

        public void mo261b(View view) {
            ag.m1275b(this.f859a.f833n, 1.0f);
            this.f859a.f836q.m1456a(null);
            this.f859a.f836q = null;
        }

        public void mo260a(View view) {
            this.f859a.f833n.setVisibility(0);
            this.f859a.f833n.sendAccessibilityEvent(32);
            if (this.f859a.f833n.getParent() != null) {
                ag.m1293o((View) this.f859a.f833n.getParent());
            }
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    private final class C0474a implements C0473a {
        final /* synthetic */ C0458l f860a;

        private C0474a(C0458l c0458l) {
            this.f860a = c0458l;
        }

        public boolean mo402a(C0538f c0538f) {
            Callback p = this.f860a.m2046p();
            if (p != null) {
                p.onMenuOpened(108, c0538f);
            }
            return true;
        }

        public void mo401a(C0538f c0538f, boolean z) {
            this.f860a.m2068b(c0538f);
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    class C0477b implements C0476a {
        final /* synthetic */ C0458l f862a;
        private C0476a f863b;

        /* compiled from: AppCompatDelegateImplV7 */
        class C04751 extends bb {
            final /* synthetic */ C0477b f861a;

            C04751(C0477b c0477b) {
                this.f861a = c0477b;
            }

            public void mo261b(View view) {
                this.f861a.f862a.f833n.setVisibility(8);
                if (this.f861a.f862a.f834o != null) {
                    this.f861a.f862a.f834o.dismiss();
                } else if (this.f861a.f862a.f833n.getParent() instanceof View) {
                    ag.m1293o((View) this.f861a.f862a.f833n.getParent());
                }
                this.f861a.f862a.f833n.removeAllViews();
                this.f861a.f862a.f836q.m1456a(null);
                this.f861a.f862a.f836q = null;
            }
        }

        public C0477b(C0458l c0458l, C0476a c0476a) {
            this.f862a = c0458l;
            this.f863b = c0476a;
        }

        public boolean mo404a(C0494b c0494b, Menu menu) {
            return this.f863b.mo404a(c0494b, menu);
        }

        public boolean mo406b(C0494b c0494b, Menu menu) {
            return this.f863b.mo406b(c0494b, menu);
        }

        public boolean mo405a(C0494b c0494b, MenuItem menuItem) {
            return this.f863b.mo405a(c0494b, menuItem);
        }

        public void mo403a(C0494b c0494b) {
            this.f863b.mo403a(c0494b);
            if (this.f862a.f834o != null) {
                this.f862a.b.getDecorView().removeCallbacks(this.f862a.f835p);
            }
            if (this.f862a.f833n != null) {
                this.f862a.m2085v();
                this.f862a.f836q = ag.m1290l(this.f862a.f833n).m1454a(0.0f);
                this.f862a.f836q.m1456a(new C04751(this));
            }
            if (this.f862a.e != null) {
                this.f862a.e.mo345b(this.f862a.f832m);
            }
            this.f862a.f832m = null;
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    private class C0478c extends ContentFrameLayout {
        final /* synthetic */ C0458l f872a;

        public C0478c(C0458l c0458l, Context context) {
            this.f872a = c0458l;
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f872a.mo380a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m2157a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f872a.mo395d(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0632l.m3110a().m3133a(getContext(), i));
        }

        private boolean m2157a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    private static final class C0479d {
        int f873a;
        int f874b;
        int f875c;
        int f876d;
        int f877e;
        int f878f;
        ViewGroup f879g;
        View f880h;
        View f881i;
        C0538f f882j;
        C0537e f883k;
        Context f884l;
        boolean f885m;
        boolean f886n;
        boolean f887o;
        public boolean f888p;
        boolean f889q = false;
        boolean f890r;
        Bundle f891s;

        C0479d(int i) {
            this.f873a = i;
        }

        public boolean m2161a() {
            if (this.f880h == null) {
                return false;
            }
            if (this.f881i != null || this.f883k.m2438a().getCount() > 0) {
                return true;
            }
            return false;
        }

        void m2159a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0498a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0498a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0507j.Theme_AppCompat_CompactMenu, true);
            }
            Context c0515d = new C0515d(context, 0);
            c0515d.getTheme().setTo(newTheme);
            this.f884l = c0515d;
            TypedArray obtainStyledAttributes = c0515d.obtainStyledAttributes(C0508k.AppCompatTheme);
            this.f874b = obtainStyledAttributes.getResourceId(C0508k.AppCompatTheme_panelBackground, 0);
            this.f878f = obtainStyledAttributes.getResourceId(C0508k.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void m2160a(C0538f c0538f) {
            if (c0538f != this.f882j) {
                if (this.f882j != null) {
                    this.f882j.m2477b(this.f883k);
                }
                this.f882j = c0538f;
                if (c0538f != null && this.f883k != null) {
                    c0538f.m2466a(this.f883k);
                }
            }
        }

        C0530m m2158a(C0473a c0473a) {
            if (this.f882j == null) {
                return null;
            }
            if (this.f883k == null) {
                this.f883k = new C0537e(this.f884l, C0505h.abc_list_menu_item_layout);
                this.f883k.m2441a(c0473a);
                this.f882j.m2466a(this.f883k);
            }
            return this.f883k.m2437a(this.f879g);
        }
    }

    /* compiled from: AppCompatDelegateImplV7 */
    private final class C0480e implements C0473a {
        final /* synthetic */ C0458l f892a;

        private C0480e(C0458l c0458l) {
            this.f892a = c0458l;
        }

        public void mo401a(C0538f c0538f, boolean z) {
            Menu menu;
            Menu p = c0538f.mo498p();
            boolean z2 = p != c0538f;
            C0458l c0458l = this.f892a;
            if (z2) {
                menu = p;
            }
            C0479d a = c0458l.m2053a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.f892a.m2054a(a.f873a, a, p);
                this.f892a.m2056a(a, true);
                return;
            }
            this.f892a.m2056a(a, z);
        }

        public boolean mo402a(C0538f c0538f) {
            if (c0538f == null && this.f892a.h) {
                Callback p = this.f892a.m2046p();
                if (!(p == null || this.f892a.m2045o())) {
                    p.onMenuOpened(108, c0538f);
                }
            }
            return true;
        }
    }

    C0458l(Context context, Window window, C0433f c0433f) {
        super(context, window, c0433f);
    }

    public void mo374a(Bundle bundle) {
        if ((this.c instanceof Activity) && C0139v.m597b((Activity) this.c) != null) {
            C0432a l = m2042l();
            if (l == null) {
                this.f828H = true;
            } else {
                l.mo415c(true);
            }
        }
    }

    public void mo382b(Bundle bundle) {
        m2082s();
    }

    public void mo391k() {
        m2082s();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new C0497r((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new C0497r((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.mo415c(this.f828H);
            }
        }
    }

    public View mo371a(int i) {
        m2082s();
        return this.b.findViewById(i);
    }

    public void mo373a(Configuration configuration) {
        if (this.h && this.f840u) {
            C0432a a = mo364a();
            if (a != null) {
                a.mo409a(configuration);
            }
        }
        mo369h();
    }

    public void mo386c() {
        C0432a a = mo364a();
        if (a != null) {
            a.mo416d(false);
        }
    }

    public void mo388d() {
        C0432a a = mo364a();
        if (a != null) {
            a.mo416d(true);
        }
    }

    public void mo376a(View view) {
        m2082s();
        ViewGroup viewGroup = (ViewGroup) this.f841v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void mo381b(int i) {
        m2082s();
        ViewGroup viewGroup = (ViewGroup) this.f841v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void mo377a(View view, LayoutParams layoutParams) {
        m2082s();
        ViewGroup viewGroup = (ViewGroup) this.f841v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    public void mo383b(View view, LayoutParams layoutParams) {
        m2082s();
        ((ViewGroup) this.f841v.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    public void mo368f() {
        super.mo368f();
        if (this.f != null) {
            this.f.mo421h();
        }
    }

    private void m2082s() {
        if (!this.f840u) {
            this.f841v = m2083t();
            CharSequence q = m2047q();
            if (!TextUtils.isEmpty(q)) {
                mo384b(q);
            }
            m2084u();
            m2097a(this.f841v);
            this.f840u = true;
            C0479d a = m2051a(0, false);
            if (!m2045o()) {
                if (a == null || a.f882j == null) {
                    m2077e(108);
                }
            }
        }
    }

    private ViewGroup m2083t() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0508k.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0508k.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0508k.AppCompatTheme_windowNoTitle, false)) {
                mo387c(1);
            } else if (obtainStyledAttributes.getBoolean(C0508k.AppCompatTheme_windowActionBar, false)) {
                mo387c(108);
            }
            if (obtainStyledAttributes.getBoolean(C0508k.AppCompatTheme_windowActionBarOverlay, false)) {
                mo387c(109);
            }
            if (obtainStyledAttributes.getBoolean(C0508k.AppCompatTheme_windowActionModeOverlay, false)) {
                mo387c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0508k.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2;
                if (this.j) {
                    view2 = (ViewGroup) from.inflate(C0505h.abc_screen_simple_overlay_action_mode, null);
                } else {
                    view2 = (ViewGroup) from.inflate(C0505h.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    ag.m1268a(view2, new C04652(this));
                    view = view2;
                } else {
                    ((ae) view2).setOnFitSystemWindowsListener(new C04673(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(C0505h.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                Context c0515d;
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0498a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    c0515d = new C0515d(this.a, typedValue.resourceId);
                } else {
                    c0515d = this.a;
                }
                r0 = (ViewGroup) LayoutInflater.from(c0515d).inflate(C0505h.abc_screen_toolbar, null);
                this.f837r = (ab) r0.findViewById(C0503f.decor_content_parent);
                this.f837r.setWindowCallback(m2046p());
                if (this.i) {
                    this.f837r.mo508a(109);
                }
                if (this.f844y) {
                    this.f837r.mo508a(2);
                }
                if (this.f845z) {
                    this.f837r.mo508a(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f837r == null) {
                this.f842w = (TextView) view.findViewById(C0503f.title);
            }
            au.m3013b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0503f.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new C04694(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    void m2097a(ViewGroup viewGroup) {
    }

    private void m2084u() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f841v.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m2155a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0508k.AppCompatTheme);
        obtainStyledAttributes.getValue(C0508k.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0508k.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0508k.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0508k.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0508k.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0508k.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0508k.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0508k.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0508k.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0508k.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public boolean mo387c(int i) {
        int h = m2081h(i);
        if (this.l && h == 108) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                m2086w();
                this.l = true;
                return true;
            case 2:
                m2086w();
                this.f844y = true;
                return true;
            case 5:
                m2086w();
                this.f845z = true;
                return true;
            case 10:
                m2086w();
                this.j = true;
                return true;
            case 108:
                m2086w();
                this.h = true;
                return true;
            case 109:
                m2086w();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    void mo384b(CharSequence charSequence) {
        if (this.f837r != null) {
            this.f837r.setWindowTitle(charSequence);
        } else if (m2042l() != null) {
            m2042l().mo410a(charSequence);
        } else if (this.f842w != null) {
            this.f842w.setText(charSequence);
        }
    }

    void mo372a(int i, Menu menu) {
        if (i == 108) {
            C0432a a = mo364a();
            if (a != null) {
                a.mo417e(false);
            }
        } else if (i == 0) {
            C0479d a2 = m2051a(i, true);
            if (a2.f887o) {
                m2056a(a2, false);
            }
        }
    }

    boolean mo385b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        C0432a a = mo364a();
        if (a == null) {
            return true;
        }
        a.mo417e(true);
        return true;
    }

    public boolean mo379a(C0538f c0538f, MenuItem menuItem) {
        Callback p = m2046p();
        if (!(p == null || m2045o())) {
            C0479d a = m2053a(c0538f.mo498p());
            if (a != null) {
                return p.onMenuItemSelected(a.f873a, menuItem);
            }
        }
        return false;
    }

    public void mo375a(C0538f c0538f) {
        m2061a(c0538f, true);
    }

    public C0494b m2101b(C0476a c0476a) {
        if (c0476a == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f832m != null) {
            this.f832m.mo431c();
        }
        C0476a c0477b = new C0477b(this, c0476a);
        C0432a a = mo364a();
        if (a != null) {
            this.f832m = a.mo437a(c0477b);
            if (!(this.f832m == null || this.e == null)) {
                this.e.mo344a(this.f832m);
            }
        }
        if (this.f832m == null) {
            this.f832m = mo370a(c0477b);
        }
        return this.f832m;
    }

    public void mo389e() {
        C0432a a = mo364a();
        if (a == null || !a.mo418e()) {
            m2077e(0);
        }
    }

    C0494b mo370a(C0476a c0476a) {
        C0494b c0494b;
        m2085v();
        if (this.f832m != null) {
            this.f832m.mo431c();
        }
        C0476a c0477b = new C0477b(this, c0476a);
        if (this.e == null || m2045o()) {
            c0494b = null;
        } else {
            try {
                c0494b = this.e.mo343a(c0477b);
            } catch (AbstractMethodError e) {
                c0494b = null;
            }
        }
        if (c0494b != null) {
            this.f832m = c0494b;
        } else {
            if (this.f833n == null) {
                if (this.k) {
                    Context c0515d;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0498a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0515d = new C0515d(this.a, 0);
                        c0515d.getTheme().setTo(newTheme);
                    } else {
                        c0515d = this.a;
                    }
                    this.f833n = new ActionBarContextView(c0515d);
                    this.f834o = new PopupWindow(c0515d, null, C0498a.actionModePopupWindowStyle);
                    C0407o.m1819a(this.f834o, 2);
                    this.f834o.setContentView(this.f833n);
                    this.f834o.setWidth(-1);
                    c0515d.getTheme().resolveAttribute(C0498a.actionBarSize, typedValue, true);
                    this.f833n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0515d.getResources().getDisplayMetrics()));
                    this.f834o.setHeight(-2);
                    this.f835p = new C04715(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f841v.findViewById(C0503f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m2043m()));
                        this.f833n = (ActionBarContextView) viewStubCompat.m2800a();
                    }
                }
            }
            if (this.f833n != null) {
                boolean z;
                m2085v();
                this.f833n.m2599c();
                Context context = this.f833n.getContext();
                ActionBarContextView actionBarContextView = this.f833n;
                if (this.f834o == null) {
                    z = true;
                } else {
                    z = false;
                }
                C0494b c0516e = new C0516e(context, actionBarContextView, c0477b, z);
                if (c0476a.mo404a(c0516e, c0516e.mo428b())) {
                    c0516e.mo432d();
                    this.f833n.m2596a(c0516e);
                    this.f832m = c0516e;
                    ag.m1275b(this.f833n, 0.0f);
                    this.f836q = ag.m1290l(this.f833n).m1454a(1.0f);
                    this.f836q.m1456a(new C04726(this));
                    if (this.f834o != null) {
                        this.b.getDecorView().post(this.f835p);
                    }
                } else {
                    this.f832m = null;
                }
            }
        }
        if (!(this.f832m == null || this.e == null)) {
            this.e.mo344a(this.f832m);
        }
        return this.f832m;
    }

    private void m2085v() {
        if (this.f836q != null) {
            this.f836q.m1461b();
        }
    }

    boolean m2118r() {
        if (this.f832m != null) {
            this.f832m.mo431c();
            return true;
        }
        C0432a a = mo364a();
        if (a == null || !a.mo419f()) {
            return false;
        }
        return true;
    }

    boolean mo378a(int i, KeyEvent keyEvent) {
        C0432a a = mo364a();
        if (a != null && a.mo412a(i, keyEvent)) {
            return true;
        }
        if (this.f823C == null || !m2063a(this.f823C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f823C == null) {
                C0479d a2 = m2051a(0, true);
                m2070b(a2, keyEvent);
                boolean a3 = m2063a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f885m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f823C == null) {
            return true;
        } else {
            this.f823C.f886n = true;
            return true;
        }
    }

    boolean mo380a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m2112c(keyCode, keyEvent) : m2107b(keyCode, keyEvent);
    }

    boolean m2107b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.f824D;
                this.f824D = false;
                C0479d a = m2051a(0, false);
                if (a == null || !a.f887o) {
                    if (m2118r()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m2056a(a, true);
                    return true;
                }
                break;
            case 82:
                m2078e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean m2112c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f824D = z;
                break;
            case 82:
                m2076d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            mo378a(i, keyEvent);
        }
        return false;
    }

    public View m2109c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = VERSION.SDK_INT < 21;
        if (this.f831K == null) {
            this.f831K = new C0482n();
        }
        if (z2 && m2065a((ViewParent) view)) {
            z = true;
        } else {
            z = false;
        }
        return this.f831K.m2169a(view, str, context, attributeSet, z, z2, true, at.m3008a());
    }

    private boolean m2065a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || ag.m1300v((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    public void mo390g() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            C0337i.m1546a(from, this);
        } else if (!(C0337i.m1545a(from) instanceof C0458l)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View mo78a(View view, String str, Context context, AttributeSet attributeSet) {
        View b = mo392b(view, str, context, attributeSet);
        return b != null ? b : m2109c(view, str, context, attributeSet);
    }

    View mo392b(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2055a(android.support.v7.p012a.C0458l.C0479d r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f887o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m2045o();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f873a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m2046p();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f873a;
        r5 = r11.f882j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m2056a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m2070b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f879g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f889q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f879g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m2062a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f879g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m2073c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m2161a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f880h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f874b;
        r4 = r11.f879g;
        r4.setBackgroundResource(r0);
        r0 = r11.f880h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f880h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f879g;
        r4 = r11.f880h;
        r0.addView(r4, r1);
        r0 = r11.f880h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f880h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f886n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f876d;
        r4 = r11.f877e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f875c;
        r0.gravity = r1;
        r1 = r11.f878f;
        r0.windowAnimations = r1;
        r1 = r11.f879g;
        r8.addView(r1, r0);
        r11.f887o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f889q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f879g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f879g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f881i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f881i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.l.a(android.support.v7.a.l$d, android.view.KeyEvent):void");
    }

    private boolean m2062a(C0479d c0479d) {
        c0479d.m2159a(m2043m());
        c0479d.f879g = new C0478c(this, c0479d.f884l);
        c0479d.f875c = 81;
        return true;
    }

    private void m2061a(C0538f c0538f, boolean z) {
        if (this.f837r == null || !this.f837r.mo510d() || (ar.m1362b(ViewConfiguration.get(this.a)) && !this.f837r.mo512f())) {
            C0479d a = m2051a(0, true);
            a.f889q = true;
            m2056a(a, false);
            m2055a(a, null);
            return;
        }
        Callback p = m2046p();
        if (this.f837r.mo511e() && z) {
            this.f837r.mo514h();
            if (!m2045o()) {
                p.onPanelClosed(108, m2051a(0, true).f882j);
            }
        } else if (p != null && !m2045o()) {
            if (this.f825E && (this.f826F & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.f827G);
                this.f827G.run();
            }
            C0479d a2 = m2051a(0, true);
            if (a2.f882j != null && !a2.f890r && p.onPreparePanel(0, a2.f881i, a2.f882j)) {
                p.onMenuOpened(108, a2.f882j);
                this.f837r.mo513g();
            }
        }
    }

    private boolean m2069b(C0479d c0479d) {
        Context c0515d;
        C0538f c0538f;
        Context context = this.a;
        if ((c0479d.f873a == 0 || c0479d.f873a == 108) && this.f837r != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0498a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0498a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0498a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0515d = new C0515d(context, 0);
                c0515d.getTheme().setTo(theme3);
                c0538f = new C0538f(c0515d);
                c0538f.mo492a((C0457a) this);
                c0479d.m2160a(c0538f);
                return true;
            }
        }
        c0515d = context;
        c0538f = new C0538f(c0515d);
        c0538f.mo492a((C0457a) this);
        c0479d.m2160a(c0538f);
        return true;
    }

    private boolean m2073c(C0479d c0479d) {
        if (c0479d.f881i != null) {
            c0479d.f880h = c0479d.f881i;
            return true;
        } else if (c0479d.f882j == null) {
            return false;
        } else {
            if (this.f839t == null) {
                this.f839t = new C0480e();
            }
            c0479d.f880h = (View) c0479d.m2158a(this.f839t);
            return c0479d.f880h != null;
        }
    }

    private boolean m2070b(C0479d c0479d, KeyEvent keyEvent) {
        if (m2045o()) {
            return false;
        }
        if (c0479d.f885m) {
            return true;
        }
        if (!(this.f823C == null || this.f823C == c0479d)) {
            m2056a(this.f823C, false);
        }
        Callback p = m2046p();
        if (p != null) {
            c0479d.f881i = p.onCreatePanelView(c0479d.f873a);
        }
        boolean z = c0479d.f873a == 0 || c0479d.f873a == 108;
        if (z && this.f837r != null) {
            this.f837r.mo515i();
        }
        if (c0479d.f881i == null && !(z && (m2042l() instanceof C0486o))) {
            if (c0479d.f882j == null || c0479d.f890r) {
                if (c0479d.f882j == null && (!m2069b(c0479d) || c0479d.f882j == null)) {
                    return false;
                }
                if (z && this.f837r != null) {
                    if (this.f838s == null) {
                        this.f838s = new C0474a();
                    }
                    this.f837r.mo509a(c0479d.f882j, this.f838s);
                }
                c0479d.f882j.m2488g();
                if (p.onCreatePanelMenu(c0479d.f873a, c0479d.f882j)) {
                    c0479d.f890r = false;
                } else {
                    c0479d.m2160a(null);
                    if (!z || this.f837r == null) {
                        return false;
                    }
                    this.f837r.mo509a(null, this.f838s);
                    return false;
                }
            }
            c0479d.f882j.m2488g();
            if (c0479d.f891s != null) {
                c0479d.f882j.m2475b(c0479d.f891s);
                c0479d.f891s = null;
            }
            if (p.onPreparePanel(0, c0479d.f881i, c0479d.f882j)) {
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z = true;
                } else {
                    z = false;
                }
                c0479d.f888p = z;
                c0479d.f882j.setQwertyMode(c0479d.f888p);
                c0479d.f882j.m2489h();
            } else {
                if (z && this.f837r != null) {
                    this.f837r.mo509a(null, this.f838s);
                }
                c0479d.f882j.m2489h();
                return false;
            }
        }
        c0479d.f885m = true;
        c0479d.f886n = false;
        this.f823C = c0479d;
        return true;
    }

    private void m2068b(C0538f c0538f) {
        if (!this.f821A) {
            this.f821A = true;
            this.f837r.mo516j();
            Callback p = m2046p();
            if (!(p == null || m2045o())) {
                p.onPanelClosed(108, c0538f);
            }
            this.f821A = false;
        }
    }

    private void mo395d(int i) {
        m2056a(m2051a(i, true), true);
    }

    private void m2056a(C0479d c0479d, boolean z) {
        if (z && c0479d.f873a == 0 && this.f837r != null && this.f837r.mo511e()) {
            m2068b(c0479d.f882j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !c0479d.f887o || c0479d.f879g == null)) {
            windowManager.removeView(c0479d.f879g);
            if (z) {
                m2054a(c0479d.f873a, c0479d, null);
            }
        }
        c0479d.f885m = false;
        c0479d.f886n = false;
        c0479d.f887o = false;
        c0479d.f880h = null;
        c0479d.f889q = true;
        if (this.f823C == c0479d) {
            this.f823C = null;
        }
    }

    private boolean m2076d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0479d a = m2051a(i, true);
            if (!a.f887o) {
                return m2070b(a, keyEvent);
            }
        }
        return false;
    }

    private boolean m2078e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f832m != null) {
            return false;
        }
        C0479d a = m2051a(i, true);
        if (i != 0 || this.f837r == null || !this.f837r.mo510d() || ar.m1362b(ViewConfiguration.get(this.a))) {
            boolean z2;
            if (a.f887o || a.f886n) {
                z2 = a.f887o;
                m2056a(a, true);
                z = z2;
            } else {
                if (a.f885m) {
                    if (a.f890r) {
                        a.f885m = false;
                        z2 = m2070b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m2055a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f837r.mo511e()) {
            z = this.f837r.mo514h();
        } else {
            if (!m2045o() && m2070b(a, keyEvent)) {
                z = this.f837r.mo513g();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private void m2054a(int i, C0479d c0479d, Menu menu) {
        if (menu == null) {
            if (c0479d == null && i >= 0 && i < this.f822B.length) {
                c0479d = this.f822B[i];
            }
            if (c0479d != null) {
                menu = c0479d.f882j;
            }
        }
        if ((c0479d == null || c0479d.f887o) && !m2045o()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    private C0479d m2053a(Menu menu) {
        C0479d[] c0479dArr = this.f822B;
        int length = c0479dArr != null ? c0479dArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0479d c0479d = c0479dArr[i];
            if (c0479d != null && c0479d.f882j == menu) {
                return c0479d;
            }
        }
        return null;
    }

    private C0479d m2051a(int i, boolean z) {
        Object obj = this.f822B;
        if (obj == null || obj.length <= i) {
            Object obj2 = new C0479d[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f822B = obj2;
            obj = obj2;
        }
        C0479d c0479d = obj[i];
        if (c0479d != null) {
            return c0479d;
        }
        c0479d = new C0479d(i);
        obj[i] = c0479d;
        return c0479d;
    }

    private boolean m2063a(C0479d c0479d, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((c0479d.f885m || m2070b(c0479d, keyEvent)) && c0479d.f882j != null) {
                z = c0479d.f882j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f837r == null) {
                m2056a(c0479d, true);
            }
        }
        return z;
    }

    private void m2077e(int i) {
        this.f826F |= 1 << i;
        if (!this.f825E) {
            ag.m1269a(this.b.getDecorView(), this.f827G);
            this.f825E = true;
        }
    }

    private void m2079f(int i) {
        C0479d a = m2051a(i, true);
        if (a.f882j != null) {
            Bundle bundle = new Bundle();
            a.f882j.m2463a(bundle);
            if (bundle.size() > 0) {
                a.f891s = bundle;
            }
            a.f882j.m2488g();
            a.f882j.clear();
        }
        a.f890r = true;
        a.f889q = true;
        if ((i == 108 || i == 0) && this.f837r != null) {
            a = m2051a(0, false);
            if (a != null) {
                a.f885m = false;
                m2070b(a, null);
            }
        }
    }

    private int m2080g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f833n == null || !(this.f833n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f833n.getLayoutParams();
            if (this.f833n.isShown()) {
                if (this.f829I == null) {
                    this.f829I = new Rect();
                    this.f830J = new Rect();
                }
                Rect rect = this.f829I;
                Rect rect2 = this.f830J;
                rect.set(0, i, 0, 0);
                au.m3011a(this.f841v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f843x == null) {
                        this.f843x = new View(this.a);
                        this.f843x.setBackgroundColor(this.a.getResources().getColor(C0500c.abc_input_method_navigation_guard));
                        this.f841v.addView(this.f843x, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f843x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f843x.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f843x == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f833n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f843x != null) {
            View view = this.f843x;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void m2086w() {
        if (this.f840u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int m2081h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private void m2087x() {
        if (this.f837r != null) {
            this.f837r.mo516j();
        }
        if (this.f834o != null) {
            this.b.getDecorView().removeCallbacks(this.f835p);
            if (this.f834o.isShowing()) {
                try {
                    this.f834o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f834o = null;
        }
        m2085v();
        C0479d a = m2051a(0, false);
        if (a != null && a.f882j != null) {
            a.f882j.close();
        }
    }
}
