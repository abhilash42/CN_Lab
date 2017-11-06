package android.support.v7.p012a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.view.ba;
import android.support.v4.view.bb;
import android.support.v4.view.bc;
import android.support.v7.p012a.C0432a.C0430b;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0503f;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.C0494b;
import android.support.v7.view.C0494b.C0476a;
import android.support.v7.view.C0513a;
import android.support.v7.view.C0521g;
import android.support.v7.view.C0523h;
import android.support.v7.view.menu.C0538f;
import android.support.v7.view.menu.C0538f.C0457a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.C0496a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ac;
import android.support.v7.widget.ak;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar */
public class C0497r extends C0432a implements C0496a {
    static final /* synthetic */ boolean f935h = (!C0497r.class.desiredAssertionStatus());
    private static final Interpolator f936i = new AccelerateInterpolator();
    private static final Interpolator f937j = new DecelerateInterpolator();
    private static final boolean f938k;
    private boolean f939A;
    private int f940B = 0;
    private boolean f941C = true;
    private boolean f942D;
    private boolean f943E;
    private boolean f944F;
    private boolean f945G = true;
    private C0523h f946H;
    private boolean f947I;
    C0495a f948a;
    C0494b f949b;
    C0476a f950c;
    boolean f951d;
    final ba f952e = new C04911(this);
    final ba f953f = new C04922(this);
    final bc f954g = new C04933(this);
    private Context f955l;
    private Context f956m;
    private Activity f957n;
    private Dialog f958o;
    private ActionBarOverlayLayout f959p;
    private ActionBarContainer f960q;
    private ac f961r;
    private ActionBarContextView f962s;
    private View f963t;
    private ak f964u;
    private ArrayList<Object> f965v = new ArrayList();
    private int f966w = -1;
    private boolean f967x;
    private boolean f968y;
    private ArrayList<C0430b> f969z = new ArrayList();

    /* compiled from: WindowDecorActionBar */
    class C04911 extends bb {
        final /* synthetic */ C0497r f925a;

        C04911(C0497r c0497r) {
            this.f925a = c0497r;
        }

        public void mo261b(View view) {
            if (this.f925a.f941C && this.f925a.f963t != null) {
                ag.m1261a(this.f925a.f963t, 0.0f);
                ag.m1261a(this.f925a.f960q, 0.0f);
            }
            this.f925a.f960q.setVisibility(8);
            this.f925a.f960q.setTransitioning(false);
            this.f925a.f946H = null;
            this.f925a.m2281i();
            if (this.f925a.f959p != null) {
                ag.m1293o(this.f925a.f959p);
            }
        }
    }

    /* compiled from: WindowDecorActionBar */
    class C04922 extends bb {
        final /* synthetic */ C0497r f926a;

        C04922(C0497r c0497r) {
            this.f926a = c0497r;
        }

        public void mo261b(View view) {
            this.f926a.f946H = null;
            this.f926a.f960q.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar */
    class C04933 implements bc {
        final /* synthetic */ C0497r f927a;

        C04933(C0497r c0497r) {
            this.f927a = c0497r;
        }

        public void mo422a(View view) {
            ((View) this.f927a.f960q.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar */
    public class C0495a extends C0494b implements C0457a {
        final /* synthetic */ C0497r f930a;
        private final Context f931b;
        private final C0538f f932c;
        private C0476a f933d;
        private WeakReference<View> f934e;

        public C0495a(C0497r c0497r, Context context, C0476a c0476a) {
            this.f930a = c0497r;
            this.f931b = context;
            this.f933d = c0476a;
            this.f932c = new C0538f(context).m2456a(1);
            this.f932c.mo492a((C0457a) this);
        }

        public MenuInflater mo423a() {
            return new C0521g(this.f931b);
        }

        public Menu mo428b() {
            return this.f932c;
        }

        public void mo431c() {
            if (this.f930a.f948a == this) {
                if (C0497r.m2249b(this.f930a.f942D, this.f930a.f943E, false)) {
                    this.f933d.mo403a(this);
                } else {
                    this.f930a.f949b = this;
                    this.f930a.f950c = this.f933d;
                }
                this.f933d = null;
                this.f930a.m2284j(false);
                this.f930a.f962s.m2598b();
                this.f930a.f961r.mo543a().sendAccessibilityEvent(32);
                this.f930a.f959p.setHideOnContentScrollEnabled(this.f930a.f951d);
                this.f930a.f948a = null;
            }
        }

        public void mo432d() {
            if (this.f930a.f948a == this) {
                this.f932c.m2488g();
                try {
                    this.f933d.mo406b(this, this.f932c);
                } finally {
                    this.f932c.m2489h();
                }
            }
        }

        public boolean m2232e() {
            this.f932c.m2488g();
            try {
                boolean a = this.f933d.mo404a((C0494b) this, this.f932c);
                return a;
            } finally {
                this.f932c.m2489h();
            }
        }

        public void mo425a(View view) {
            this.f930a.f962s.setCustomView(view);
            this.f934e = new WeakReference(view);
        }

        public void mo426a(CharSequence charSequence) {
            this.f930a.f962s.setSubtitle(charSequence);
        }

        public void mo430b(CharSequence charSequence) {
            this.f930a.f962s.setTitle(charSequence);
        }

        public void mo424a(int i) {
            mo430b(this.f930a.f955l.getResources().getString(i));
        }

        public void mo429b(int i) {
            mo426a(this.f930a.f955l.getResources().getString(i));
        }

        public CharSequence mo433f() {
            return this.f930a.f962s.getTitle();
        }

        public CharSequence mo434g() {
            return this.f930a.f962s.getSubtitle();
        }

        public void mo427a(boolean z) {
            super.mo427a(z);
            this.f930a.f962s.setTitleOptional(z);
        }

        public boolean mo435h() {
            return this.f930a.f962s.m2600d();
        }

        public View mo436i() {
            return this.f934e != null ? (View) this.f934e.get() : null;
        }

        public boolean mo379a(C0538f c0538f, MenuItem menuItem) {
            if (this.f933d != null) {
                return this.f933d.mo405a((C0494b) this, menuItem);
            }
            return false;
        }

        public void mo375a(C0538f c0538f) {
            if (this.f933d != null) {
                mo432d();
                this.f930a.f962s.mo501a();
            }
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f938k = z;
    }

    public C0497r(Activity activity, boolean z) {
        this.f957n = activity;
        View decorView = activity.getWindow().getDecorView();
        m2244a(decorView);
        if (!z) {
            this.f963t = decorView.findViewById(16908290);
        }
    }

    public C0497r(Dialog dialog) {
        this.f958o = dialog;
        m2244a(dialog.getWindow().getDecorView());
    }

    private void m2244a(View view) {
        this.f959p = (ActionBarOverlayLayout) view.findViewById(C0503f.decor_content_parent);
        if (this.f959p != null) {
            this.f959p.setActionBarVisibilityCallback(this);
        }
        this.f961r = m2247b(view.findViewById(C0503f.action_bar));
        this.f962s = (ActionBarContextView) view.findViewById(C0503f.action_context_bar);
        this.f960q = (ActionBarContainer) view.findViewById(C0503f.action_bar_container);
        if (this.f961r == null || this.f962s == null || this.f960q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f955l = this.f961r.mo552b();
        boolean z = (this.f961r.mo568o() & 4) != 0;
        if (z) {
            this.f967x = true;
        }
        C0513a a = C0513a.m2293a(this.f955l);
        if (a.m2299f() || z) {
            z = true;
        } else {
            z = false;
        }
        mo411a(z);
        m2257k(a.m2297d());
        TypedArray obtainStyledAttributes = this.f955l.obtainStyledAttributes(null, C0508k.ActionBar, C0498a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0508k.ActionBar_hideOnContentScroll, false)) {
            mo439b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0508k.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo408a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private ac m2247b(View view) {
        if (view instanceof ac) {
            return (ac) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    public void mo408a(float f) {
        ag.m1282d(this.f960q, f);
    }

    public void mo409a(Configuration configuration) {
        m2257k(C0513a.m2293a(this.f955l).m2297d());
    }

    private void m2257k(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.f939A = z;
        if (this.f939A) {
            this.f960q.setTabContainer(null);
            this.f961r.mo547a(this.f964u);
        } else {
            this.f961r.mo547a(null);
            this.f960q.setTabContainer(this.f964u);
        }
        if (m2283j() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f964u != null) {
            if (z2) {
                this.f964u.setVisibility(0);
                if (this.f959p != null) {
                    ag.m1293o(this.f959p);
                }
            } else {
                this.f964u.setVisibility(8);
            }
        }
        ac acVar = this.f961r;
        if (this.f939A || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        acVar.mo551a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f959p;
        if (this.f939A || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    void m2281i() {
        if (this.f950c != null) {
            this.f950c.mo403a(this.f949b);
            this.f949b = null;
            this.f950c = null;
        }
    }

    public void mo438a(int i) {
        this.f940B = i;
    }

    public void mo416d(boolean z) {
        this.f947I = z;
        if (!z && this.f946H != null) {
            this.f946H.m2360b();
        }
    }

    public void mo417e(boolean z) {
        if (z != this.f968y) {
            this.f968y = z;
            int size = this.f969z.size();
            for (int i = 0; i < size; i++) {
                ((C0430b) this.f969z.get(i)).m1904a(z);
            }
        }
    }

    public void m2276f(boolean z) {
        m2265a(z ? 4 : 0, 4);
    }

    public void mo411a(boolean z) {
        this.f961r.mo554b(z);
    }

    public void mo410a(CharSequence charSequence) {
        this.f961r.mo550a(charSequence);
    }

    public boolean mo420g() {
        ViewGroup a = this.f961r.mo543a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void m2265a(int i, int i2) {
        int o = this.f961r.mo568o();
        if ((i2 & 4) != 0) {
            this.f967x = true;
        }
        this.f961r.mo555c((o & (i2 ^ -1)) | (i & i2));
    }

    public int m2283j() {
        return this.f961r.mo569p();
    }

    public int mo407a() {
        return this.f961r.mo568o();
    }

    public C0494b mo437a(C0476a c0476a) {
        if (this.f948a != null) {
            this.f948a.mo431c();
        }
        this.f959p.setHideOnContentScrollEnabled(false);
        this.f962s.m2599c();
        C0494b c0495a = new C0495a(this, this.f962s.getContext(), c0476a);
        if (!c0495a.m2232e()) {
            return null;
        }
        c0495a.mo432d();
        this.f962s.m2596a(c0495a);
        m2284j(true);
        this.f962s.sendAccessibilityEvent(32);
        this.f948a = c0495a;
        return c0495a;
    }

    public int m2285k() {
        return this.f960q.getHeight();
    }

    public void mo441g(boolean z) {
        this.f941C = z;
    }

    private void m2259p() {
        if (!this.f944F) {
            this.f944F = true;
            if (this.f959p != null) {
                this.f959p.setShowingForActionMode(true);
            }
            m2258l(false);
        }
    }

    public void mo442l() {
        if (this.f943E) {
            this.f943E = false;
            m2258l(true);
        }
    }

    private void m2260q() {
        if (this.f944F) {
            this.f944F = false;
            if (this.f959p != null) {
                this.f959p.setShowingForActionMode(false);
            }
            m2258l(false);
        }
    }

    public void mo443m() {
        if (!this.f943E) {
            this.f943E = true;
            m2258l(true);
        }
    }

    public void mo439b(boolean z) {
        if (!z || this.f959p.m2629a()) {
            this.f951d = z;
            this.f959p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public int mo440d() {
        return this.f959p.getActionBarHideOffset();
    }

    private static boolean m2249b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void m2258l(boolean z) {
        if (C0497r.m2249b(this.f942D, this.f943E, this.f944F)) {
            if (!this.f945G) {
                this.f945G = true;
                m2280h(z);
            }
        } else if (this.f945G) {
            this.f945G = false;
            m2282i(z);
        }
    }

    public void m2280h(boolean z) {
        if (this.f946H != null) {
            this.f946H.m2360b();
        }
        this.f960q.setVisibility(0);
        if (this.f940B == 0 && f938k && (this.f947I || z)) {
            ag.m1261a(this.f960q, 0.0f);
            float f = (float) (-this.f960q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f960q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ag.m1261a(this.f960q, f);
            C0523h c0523h = new C0523h();
            aw b = ag.m1290l(this.f960q).m1459b(0.0f);
            b.m1457a(this.f954g);
            c0523h.m2355a(b);
            if (this.f941C && this.f963t != null) {
                ag.m1261a(this.f963t, f);
                c0523h.m2355a(ag.m1290l(this.f963t).m1459b(0.0f));
            }
            c0523h.m2358a(f937j);
            c0523h.m2354a(250);
            c0523h.m2357a(this.f953f);
            this.f946H = c0523h;
            c0523h.m2359a();
        } else {
            ag.m1275b(this.f960q, 1.0f);
            ag.m1261a(this.f960q, 0.0f);
            if (this.f941C && this.f963t != null) {
                ag.m1261a(this.f963t, 0.0f);
            }
            this.f953f.mo261b(null);
        }
        if (this.f959p != null) {
            ag.m1293o(this.f959p);
        }
    }

    public void m2282i(boolean z) {
        if (this.f946H != null) {
            this.f946H.m2360b();
        }
        if (this.f940B == 0 && f938k && (this.f947I || z)) {
            ag.m1275b(this.f960q, 1.0f);
            this.f960q.setTransitioning(true);
            C0523h c0523h = new C0523h();
            float f = (float) (-this.f960q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f960q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            aw b = ag.m1290l(this.f960q).m1459b(f);
            b.m1457a(this.f954g);
            c0523h.m2355a(b);
            if (this.f941C && this.f963t != null) {
                c0523h.m2355a(ag.m1290l(this.f963t).m1459b(f));
            }
            c0523h.m2358a(f936i);
            c0523h.m2354a(250);
            c0523h.m2357a(this.f952e);
            this.f946H = c0523h;
            c0523h.m2359a();
            return;
        }
        this.f952e.mo261b(null);
    }

    public boolean mo413b() {
        int k = m2285k();
        return this.f945G && (k == 0 || mo440d() < k);
    }

    public void m2284j(boolean z) {
        aw a;
        aw a2;
        if (z) {
            m2259p();
        } else {
            m2260q();
        }
        if (z) {
            a = this.f961r.mo542a(4, 100);
            a2 = this.f962s.mo500a(0, 200);
        } else {
            a2 = this.f961r.mo542a(0, 200);
            a = this.f962s.mo500a(8, 100);
        }
        C0523h c0523h = new C0523h();
        c0523h.m2356a(a, a2);
        c0523h.m2359a();
    }

    public Context mo414c() {
        if (this.f956m == null) {
            TypedValue typedValue = new TypedValue();
            this.f955l.getTheme().resolveAttribute(C0498a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f956m = new ContextThemeWrapper(this.f955l, i);
            } else {
                this.f956m = this.f955l;
            }
        }
        return this.f956m;
    }

    public void mo444n() {
        if (this.f946H != null) {
            this.f946H.m2360b();
            this.f946H = null;
        }
    }

    public void mo445o() {
    }

    public boolean mo419f() {
        if (this.f961r == null || !this.f961r.mo556c()) {
            return false;
        }
        this.f961r.mo557d();
        return true;
    }

    public void mo415c(boolean z) {
        if (!this.f967x) {
            m2276f(z);
        }
    }
}
