package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p002b.p003a.C0150a;
import android.support.v4.view.C0321d;
import android.support.v4.view.C0321d.C0319a;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0504g;
import android.support.v7.p013b.C0509a.C0505h;
import android.support.v7.p017e.C0512a;
import android.support.v7.view.C0513a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.C0526b;
import android.support.v7.view.menu.C0530m;
import android.support.v7.view.menu.C0530m.C0527a;
import android.support.v7.view.menu.C0532l.C0473a;
import android.support.v7.view.menu.C0533b;
import android.support.v7.view.menu.C0538f;
import android.support.v7.view.menu.C0541h;
import android.support.v7.view.menu.C0550k;
import android.support.v7.view.menu.C0553p;
import android.support.v7.widget.ActionMenuView.C0528a;
import android.support.v7.widget.ag.C0524b;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* compiled from: ActionMenuPresenter */
class C0614d extends C0533b implements C0319a {
    private C0607b f1602A;
    final C0613f f1603g = new C0613f();
    int f1604h;
    private C0611d f1605i;
    private Drawable f1606j;
    private boolean f1607k;
    private boolean f1608l;
    private boolean f1609m;
    private int f1610n;
    private int f1611o;
    private int f1612p;
    private boolean f1613q;
    private boolean f1614r;
    private boolean f1615s;
    private boolean f1616t;
    private int f1617u;
    private final SparseBooleanArray f1618v = new SparseBooleanArray();
    private View f1619w;
    private C0612e f1620x;
    private C0606a f1621y;
    private C0608c f1622z;

    /* compiled from: ActionMenuPresenter */
    private class C0606a extends C0550k {
        final /* synthetic */ C0614d f1589c;
        private C0553p f1590d;

        public C0606a(C0614d c0614d, Context context, C0553p c0553p) {
            boolean z = false;
            this.f1589c = c0614d;
            super(context, c0553p, null, false, C0498a.actionOverflowMenuStyle);
            this.f1590d = c0553p;
            if (!((C0541h) c0553p.getItem()).m2528j()) {
                m2561a(c0614d.f1605i == null ? (View) c0614d.f : c0614d.f1605i);
            }
            m2560a(c0614d.f1603g);
            int size = c0553p.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = c0553p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            m2562a(z);
        }

        public void onDismiss() {
            super.onDismiss();
            this.f1589c.f1621y = null;
            this.f1589c.f1604h = 0;
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0607b extends C0526b {
        final /* synthetic */ C0614d f1591a;

        private C0607b(C0614d c0614d) {
            this.f1591a = c0614d;
        }

        public ag mo573a() {
            return this.f1591a.f1621y != null ? this.f1591a.f1621y.m2568c() : null;
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0608c implements Runnable {
        final /* synthetic */ C0614d f1592a;
        private C0612e f1593b;

        public C0608c(C0614d c0614d, C0612e c0612e) {
            this.f1592a = c0614d;
            this.f1593b = c0612e;
        }

        public void run() {
            this.f1592a.c.m2487f();
            View view = (View) this.f1592a.f;
            if (!(view == null || view.getWindowToken() == null || !this.f1593b.m2569d())) {
                this.f1592a.f1620x = this.f1593b;
            }
            this.f1592a.f1622z = null;
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0611d extends C0610p implements C0528a {
        final /* synthetic */ C0614d f1598a;
        private final float[] f1599b = new float[2];

        public C0611d(final C0614d c0614d, Context context) {
            this.f1598a = c0614d;
            super(context, null, C0498a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new C0524b(this, this) {
                final /* synthetic */ C0611d f1595b;

                public ag mo446a() {
                    if (this.f1595b.f1598a.f1620x == null) {
                        return null;
                    }
                    return this.f1595b.f1598a.f1620x.m2568c();
                }

                public boolean mo447b() {
                    this.f1595b.f1598a.m3052d();
                    return true;
                }

                public boolean mo574c() {
                    if (this.f1595b.f1598a.f1622z != null) {
                        return false;
                    }
                    this.f1595b.f1598a.m3053e();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f1598a.m3052d();
            }
            return true;
        }

        public boolean mo454c() {
            return false;
        }

        public boolean mo455d() {
            return false;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0150a.m658a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0612e extends C0550k {
        final /* synthetic */ C0614d f1600c;

        public C0612e(C0614d c0614d, Context context, C0538f c0538f, View view, boolean z) {
            this.f1600c = c0614d;
            super(context, c0538f, view, z, C0498a.actionOverflowMenuStyle);
            m2557a(8388613);
            m2560a(c0614d.f1603g);
        }

        public void onDismiss() {
            super.onDismiss();
            if (this.f1600c.c != null) {
                this.f1600c.c.close();
            }
            this.f1600c.f1620x = null;
        }
    }

    /* compiled from: ActionMenuPresenter */
    private class C0613f implements C0473a {
        final /* synthetic */ C0614d f1601a;

        private C0613f(C0614d c0614d) {
            this.f1601a = c0614d;
        }

        public boolean mo402a(C0538f c0538f) {
            if (c0538f == null) {
                return false;
            }
            this.f1601a.f1604h = ((C0553p) c0538f).getItem().getItemId();
            C0473a a = this.f1601a.m2412a();
            return a != null ? a.mo402a(c0538f) : false;
        }

        public void mo401a(C0538f c0538f, boolean z) {
            if (c0538f instanceof C0553p) {
                ((C0553p) c0538f).mo498p().m2470a(false);
            }
            C0473a a = this.f1601a.m2412a();
            if (a != null) {
                a.mo401a(c0538f, z);
            }
        }
    }

    public C0614d(Context context) {
        super(context, C0505h.abc_action_menu_layout, C0505h.abc_action_menu_item_layout);
    }

    public void mo470a(Context context, C0538f c0538f) {
        super.mo470a(context, c0538f);
        Resources resources = context.getResources();
        C0513a a = C0513a.m2293a(context);
        if (!this.f1609m) {
            this.f1608l = a.m2295b();
        }
        if (!this.f1615s) {
            this.f1610n = a.m2296c();
        }
        if (!this.f1613q) {
            this.f1612p = a.m2294a();
        }
        int i = this.f1610n;
        if (this.f1608l) {
            if (this.f1605i == null) {
                this.f1605i = new C0611d(this, this.a);
                if (this.f1607k) {
                    this.f1605i.setImageDrawable(this.f1606j);
                    this.f1606j = null;
                    this.f1607k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f1605i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1605i.getMeasuredWidth();
        } else {
            this.f1605i = null;
        }
        this.f1611o = i;
        this.f1617u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f1619w = null;
    }

    public void m3038a(Configuration configuration) {
        if (!this.f1613q) {
            this.f1612p = this.b.getResources().getInteger(C0504g.abc_max_action_buttons);
        }
        if (this.c != null) {
            this.c.m2478b(true);
        }
    }

    public void m3050c(boolean z) {
        this.f1608l = z;
        this.f1609m = true;
    }

    public void m3051d(boolean z) {
        this.f1616t = z;
    }

    public void m3039a(Drawable drawable) {
        if (this.f1605i != null) {
            this.f1605i.setImageDrawable(drawable);
            return;
        }
        this.f1607k = true;
        this.f1606j = drawable;
    }

    public Drawable m3049c() {
        if (this.f1605i != null) {
            return this.f1605i.getDrawable();
        }
        if (this.f1607k) {
            return this.f1606j;
        }
        return null;
    }

    public C0530m mo575a(ViewGroup viewGroup) {
        C0530m a = super.mo575a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View mo576a(C0541h c0541h, View view, ViewGroup viewGroup) {
        View actionView = c0541h.getActionView();
        if (actionView == null || c0541h.m2532n()) {
            actionView = super.mo576a(c0541h, view, viewGroup);
        }
        actionView.setVisibility(c0541h.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m2670a(layoutParams));
        }
        return actionView;
    }

    public void mo577a(C0541h c0541h, C0527a c0527a) {
        c0527a.mo452a(c0541h, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0527a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f1602A == null) {
            this.f1602A = new C0607b();
        }
        actionMenuItemView.setPopupCallback(this.f1602A);
    }

    public boolean mo579a(int i, C0541h c0541h) {
        return c0541h.m2528j();
    }

    public void mo474b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            C0512a.m2292a(viewGroup);
        }
        super.mo474b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.m2492k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                C0321d a = ((C0541h) k.get(i)).mo461a();
                if (a != null) {
                    a.m1511a((C0319a) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.m2493l() : null;
        if (this.f1608l && l != null) {
            i = l.size();
            if (i == 1) {
                int i4;
                if (((C0541h) l.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f1605i == null) {
                this.f1605i = new C0611d(this, this.a);
            }
            viewGroup = (ViewGroup) this.f1605i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1605i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f1605i, actionMenuView.m2679c());
            }
        } else if (this.f1605i != null && this.f1605i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f1605i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f1608l);
    }

    public boolean mo580a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1605i) {
            return false;
        }
        return super.mo580a(viewGroup, i);
    }

    public boolean mo473a(C0553p c0553p) {
        if (!c0553p.hasVisibleItems()) {
            return false;
        }
        C0553p c0553p2 = c0553p;
        while (c0553p2.m2583s() != this.c) {
            c0553p2 = (C0553p) c0553p2.m2583s();
        }
        View a = m3026a(c0553p2.getItem());
        if (a == null) {
            if (this.f1605i == null) {
                return false;
            }
            a = this.f1605i;
        }
        this.f1604h = c0553p.getItem().getItemId();
        this.f1621y = new C0606a(this, this.b, c0553p);
        this.f1621y.m2561a(a);
        this.f1621y.m2556a();
        super.mo473a(c0553p);
        return true;
    }

    private View m3026a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0527a) && ((C0527a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean m3052d() {
        if (!this.f1608l || m3056h() || this.c == null || this.f == null || this.f1622z != null || this.c.m2493l().isEmpty()) {
            return false;
        }
        this.f1622z = new C0608c(this, new C0612e(this, this.b, this.c, this.f1605i, true));
        ((View) this.f).post(this.f1622z);
        super.mo473a(null);
        return true;
    }

    public boolean m3053e() {
        if (this.f1622z == null || this.f == null) {
            C0550k c0550k = this.f1620x;
            if (c0550k == null) {
                return false;
            }
            c0550k.m2570e();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f1622z);
        this.f1622z = null;
        return true;
    }

    public boolean m3054f() {
        return m3053e() | m3055g();
    }

    public boolean m3055g() {
        if (this.f1621y == null) {
            return false;
        }
        this.f1621y.m2570e();
        return true;
    }

    public boolean m3056h() {
        return this.f1620x != null && this.f1620x.m2571f();
    }

    public boolean m3057i() {
        return this.f1622z != null || m3056h();
    }

    public boolean mo475b() {
        int i;
        ArrayList i2 = this.c.m2490i();
        int size = i2.size();
        int i3 = this.f1612p;
        int i4 = this.f1611o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0541h c0541h = (C0541h) i2.get(i7);
            if (c0541h.m2530l()) {
                i5++;
            } else if (c0541h.m2529k()) {
                i6++;
            } else {
                obj = 1;
            }
            if (this.f1616t && c0541h.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i3;
            }
            i7++;
            i3 = i;
        }
        if (this.f1608l && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.f1618v;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f1614r) {
            i = i4 / this.f1617u;
            i6 = ((i4 % this.f1617u) / i) + this.f1617u;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0541h = (C0541h) i2.get(i8);
            int i10;
            if (c0541h.m2530l()) {
                View a = mo576a(c0541h, this.f1619w, viewGroup);
                if (this.f1619w == null) {
                    this.f1619w = a;
                }
                if (this.f1614r) {
                    i9 -= ActionMenuView.m2665a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0541h.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0541h.m2521d(true);
                i = i10;
                i3 = i7;
            } else if (c0541h.m2529k()) {
                boolean z;
                int groupId = c0541h.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.f1614r || i9 > 0);
                if (z3) {
                    View a2 = mo576a(c0541h, this.f1619w, viewGroup);
                    if (this.f1619w == null) {
                        this.f1619w = a2;
                    }
                    boolean z4;
                    if (this.f1614r) {
                        int a3 = ActionMenuView.m2665a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.f1614r) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0541h c0541h2 = (C0541h) i2.get(i7);
                        if (c0541h2.getGroupId() == groupId) {
                            if (c0541h2.m2528j()) {
                                i5++;
                            }
                            c0541h2.m2521d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0541h.m2521d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0541h.m2521d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public void mo471a(C0538f c0538f, boolean z) {
        m3054f();
        super.mo471a(c0538f, z);
    }

    public void mo578a(boolean z) {
        if (z) {
            super.mo473a(null);
        } else {
            this.c.m2470a(false);
        }
    }

    public void m3042a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.mo457a(this.c);
    }
}
