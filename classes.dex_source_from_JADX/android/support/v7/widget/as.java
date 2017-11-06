package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.view.bb;
import android.support.v7.p013b.C0509a.C0498a;
import android.support.v7.p013b.C0509a.C0502e;
import android.support.v7.p013b.C0509a.C0503f;
import android.support.v7.p013b.C0509a.C0506i;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.menu.C0531a;
import android.support.v7.view.menu.C0532l.C0473a;
import android.support.v7.view.menu.C0538f;
import android.support.v7.view.menu.C0538f.C0457a;
import android.support.v7.widget.Toolbar.C0580b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

/* compiled from: ToolbarWidgetWrapper */
public class as implements ac {
    private Toolbar f1568a;
    private int f1569b;
    private View f1570c;
    private View f1571d;
    private Drawable f1572e;
    private Drawable f1573f;
    private Drawable f1574g;
    private boolean f1575h;
    private CharSequence f1576i;
    private CharSequence f1577j;
    private CharSequence f1578k;
    private Callback f1579l;
    private boolean f1580m;
    private C0614d f1581n;
    private int f1582o;
    private final C0632l f1583p;
    private int f1584q;
    private Drawable f1585r;

    /* compiled from: ToolbarWidgetWrapper */
    class C06011 implements OnClickListener {
        final C0531a f1563a = new C0531a(this.f1564b.f1568a.getContext(), 0, 16908332, 0, 0, this.f1564b.f1576i);
        final /* synthetic */ as f1564b;

        C06011(as asVar) {
            this.f1564b = asVar;
        }

        public void onClick(View view) {
            if (this.f1564b.f1579l != null && this.f1564b.f1580m) {
                this.f1564b.f1579l.onMenuItemSelected(0, this.f1563a);
            }
        }
    }

    public as(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0506i.abc_action_bar_up_description, C0502e.abc_ic_ab_back_mtrl_am_alpha);
    }

    public as(Toolbar toolbar, boolean z, int i, int i2) {
        this.f1582o = 0;
        this.f1584q = 0;
        this.f1568a = toolbar;
        this.f1576i = toolbar.getTitle();
        this.f1577j = toolbar.getSubtitle();
        this.f1575h = this.f1576i != null;
        this.f1574g = toolbar.getNavigationIcon();
        if (z) {
            ar a = ar.m2940a(toolbar.getContext(), null, C0508k.ActionBar, C0498a.actionBarStyle, 0);
            CharSequence c = a.m2949c(C0508k.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                m2983b(c);
            }
            c = a.m2949c(C0508k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m2987c(c);
            }
            Drawable a2 = a.m2943a(C0508k.ActionBar_logo);
            if (a2 != null) {
                m2986c(a2);
            }
            a2 = a.m2943a(C0508k.ActionBar_icon);
            if (this.f1574g == null && a2 != null) {
                mo545a(a2);
            }
            a2 = a.m2943a(C0508k.ActionBar_homeAsUpIndicator);
            if (a2 != null) {
                m2991d(a2);
            }
            mo555c(a.m2942a(C0508k.ActionBar_displayOptions, 0));
            int g = a.m2956g(C0508k.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m2976a(LayoutInflater.from(this.f1568a.getContext()).inflate(g, this.f1568a, false));
                mo555c(this.f1569b | 16);
            }
            g = a.m2954f(C0508k.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f1568a.getLayoutParams();
                layoutParams.height = g;
                this.f1568a.setLayoutParams(layoutParams);
            }
            g = a.m2950d(C0508k.ActionBar_contentInsetStart, -1);
            int d = a.m2950d(C0508k.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f1568a.m2783a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m2956g(C0508k.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f1568a.m2784a(this.f1568a.getContext(), g);
            }
            g = a.m2956g(C0508k.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f1568a.m2788b(this.f1568a.getContext(), g);
            }
            int g2 = a.m2956g(C0508k.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f1568a.setPopupTheme(g2);
            }
            a.m2944a();
        } else {
            this.f1569b = m2965s();
        }
        this.f1583p = C0632l.m3110a();
        m2990d(i);
        this.f1578k = this.f1568a.getNavigationContentDescription();
        m2982b(this.f1583p.m3133a(mo552b(), i2));
        this.f1568a.setNavigationOnClickListener(new C06011(this));
    }

    public void m2990d(int i) {
        if (i != this.f1584q) {
            this.f1584q = i;
            if (TextUtils.isEmpty(this.f1568a.getNavigationContentDescription())) {
                m2994e(this.f1584q);
            }
        }
    }

    public void m2982b(Drawable drawable) {
        if (this.f1585r != drawable) {
            this.f1585r = drawable;
            m2968v();
        }
    }

    private int m2965s() {
        if (this.f1568a.getNavigationIcon() != null) {
            return 15;
        }
        return 11;
    }

    public ViewGroup mo543a() {
        return this.f1568a;
    }

    public Context mo552b() {
        return this.f1568a.getContext();
    }

    public boolean mo556c() {
        return this.f1568a.m2794g();
    }

    public void mo557d() {
        this.f1568a.m2795h();
    }

    public void mo549a(Callback callback) {
        this.f1579l = callback;
    }

    public void mo550a(CharSequence charSequence) {
        if (!this.f1575h) {
            m2964e(charSequence);
        }
    }

    public CharSequence mo558e() {
        return this.f1568a.getTitle();
    }

    public void m2983b(CharSequence charSequence) {
        this.f1575h = true;
        m2964e(charSequence);
    }

    private void m2964e(CharSequence charSequence) {
        this.f1576i = charSequence;
        if ((this.f1569b & 8) != 0) {
            this.f1568a.setTitle(charSequence);
        }
    }

    public void m2987c(CharSequence charSequence) {
        this.f1577j = charSequence;
        if ((this.f1569b & 8) != 0) {
            this.f1568a.setSubtitle(charSequence);
        }
    }

    public void mo559f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void mo560g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void mo544a(int i) {
        mo545a(i != 0 ? this.f1583p.m3133a(mo552b(), i) : null);
    }

    public void mo545a(Drawable drawable) {
        this.f1572e = drawable;
        m2966t();
    }

    public void mo553b(int i) {
        m2986c(i != 0 ? this.f1583p.m3133a(mo552b(), i) : null);
    }

    public void m2986c(Drawable drawable) {
        this.f1573f = drawable;
        m2966t();
    }

    private void m2966t() {
        Drawable drawable = null;
        if ((this.f1569b & 2) != 0) {
            drawable = (this.f1569b & 1) != 0 ? this.f1573f != null ? this.f1573f : this.f1572e : this.f1572e;
        }
        this.f1568a.setLogo(drawable);
    }

    public boolean mo561h() {
        return this.f1568a.m2787a();
    }

    public boolean mo562i() {
        return this.f1568a.m2789b();
    }

    public boolean mo563j() {
        return this.f1568a.m2790c();
    }

    public boolean mo564k() {
        return this.f1568a.m2791d();
    }

    public boolean mo565l() {
        return this.f1568a.m2792e();
    }

    public void mo566m() {
        this.f1580m = true;
    }

    public void mo548a(Menu menu, C0473a c0473a) {
        if (this.f1581n == null) {
            this.f1581n = new C0614d(this.f1568a.getContext());
            this.f1581n.m2415a(C0503f.action_menu_presenter);
        }
        this.f1581n.m2419a(c0473a);
        this.f1568a.m2785a((C0538f) menu, this.f1581n);
    }

    public void mo567n() {
        this.f1568a.m2793f();
    }

    public int mo568o() {
        return this.f1569b;
    }

    public void mo555c(int i) {
        int i2 = this.f1569b ^ i;
        this.f1569b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m2968v();
                    m2967u();
                } else {
                    this.f1568a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                m2966t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1568a.setTitle(this.f1576i);
                    this.f1568a.setSubtitle(this.f1577j);
                } else {
                    this.f1568a.setTitle(null);
                    this.f1568a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f1571d != null) {
                if ((i & 16) != 0) {
                    this.f1568a.addView(this.f1571d);
                } else {
                    this.f1568a.removeView(this.f1571d);
                }
            }
        }
    }

    public void mo547a(ak akVar) {
        if (this.f1570c != null && this.f1570c.getParent() == this.f1568a) {
            this.f1568a.removeView(this.f1570c);
        }
        this.f1570c = akVar;
        if (akVar != null && this.f1582o == 2) {
            this.f1568a.addView(this.f1570c, 0);
            C0580b c0580b = (C0580b) this.f1570c.getLayoutParams();
            c0580b.width = -2;
            c0580b.height = -2;
            c0580b.a = 8388691;
            akVar.setAllowCollapse(true);
        }
    }

    public void mo551a(boolean z) {
        this.f1568a.setCollapsible(z);
    }

    public void mo554b(boolean z) {
    }

    public int mo569p() {
        return this.f1582o;
    }

    public void m2976a(View view) {
        if (!(this.f1571d == null || (this.f1569b & 16) == 0)) {
            this.f1568a.removeView(this.f1571d);
        }
        this.f1571d = view;
        if (view != null && (this.f1569b & 16) != 0) {
            this.f1568a.addView(this.f1571d);
        }
    }

    public aw mo542a(final int i, long j) {
        return ag.m1290l(this.f1568a).m1454a(i == 0 ? 1.0f : 0.0f).m1455a(j).m1456a(new bb(this) {
            final /* synthetic */ as f1566b;
            private boolean f1567c = false;

            public void mo260a(View view) {
                this.f1566b.f1568a.setVisibility(0);
            }

            public void mo261b(View view) {
                if (!this.f1567c) {
                    this.f1566b.f1568a.setVisibility(i);
                }
            }

            public void mo262c(View view) {
                this.f1567c = true;
            }
        });
    }

    public void m2991d(Drawable drawable) {
        this.f1574g = drawable;
        m2968v();
    }

    public void m2992d(CharSequence charSequence) {
        this.f1578k = charSequence;
        m2967u();
    }

    public void m2994e(int i) {
        m2992d(i == 0 ? null : mo552b().getString(i));
    }

    private void m2967u() {
        if ((this.f1569b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1578k)) {
            this.f1568a.setNavigationContentDescription(this.f1584q);
        } else {
            this.f1568a.setNavigationContentDescription(this.f1578k);
        }
    }

    private void m2968v() {
        if ((this.f1569b & 4) != 0) {
            this.f1568a.setNavigationIcon(this.f1574g != null ? this.f1574g : this.f1585r);
        }
    }

    public int mo570q() {
        return this.f1568a.getVisibility();
    }

    public void mo546a(C0473a c0473a, C0457a c0457a) {
        this.f1568a.m2786a(c0473a, c0457a);
    }

    public Menu mo571r() {
        return this.f1568a.getMenu();
    }
}
