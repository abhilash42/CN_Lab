package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p006c.p007a.C0172b;
import android.support.v4.view.C0321d;
import android.support.v4.view.C0321d.C0320b;
import android.support.v4.view.C0353p.C0352e;
import android.support.v7.view.menu.C0530m.C0527a;
import android.support.v7.widget.C0632l;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

/* compiled from: MenuItemImpl */
public final class C0541h implements C0172b {
    private static String f1144w;
    private static String f1145x;
    private static String f1146y;
    private static String f1147z;
    private final int f1148a;
    private final int f1149b;
    private final int f1150c;
    private final int f1151d;
    private CharSequence f1152e;
    private CharSequence f1153f;
    private Intent f1154g;
    private char f1155h;
    private char f1156i;
    private Drawable f1157j;
    private int f1158k = 0;
    private C0538f f1159l;
    private C0553p f1160m;
    private Runnable f1161n;
    private OnMenuItemClickListener f1162o;
    private int f1163p = 16;
    private int f1164q = 0;
    private View f1165r;
    private C0321d f1166s;
    private C0352e f1167t;
    private boolean f1168u = false;
    private ContextMenuInfo f1169v;

    /* compiled from: MenuItemImpl */
    class C05401 implements C0320b {
        final /* synthetic */ C0541h f1143a;

        C05401(C0541h c0541h) {
            this.f1143a = c0541h;
        }

        public void mo477a(boolean z) {
            this.f1143a.f1159l.m2465a(this.f1143a);
        }
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m2506a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m2509a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m2515b(i);
    }

    C0541h(C0538f c0538f, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1159l = c0538f;
        this.f1148a = i2;
        this.f1149b = i;
        this.f1150c = i3;
        this.f1151d = i4;
        this.f1152e = charSequence;
        this.f1164q = i5;
    }

    public boolean m2517b() {
        if ((this.f1162o != null && this.f1162o.onMenuItemClick(this)) || this.f1159l.mo493a(this.f1159l.mo498p(), (MenuItem) this)) {
            return true;
        }
        if (this.f1161n != null) {
            this.f1161n.run();
            return true;
        }
        if (this.f1154g != null) {
            try {
                this.f1159l.m2486e().startActivity(this.f1154g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f1166s == null || !this.f1166s.mo480d()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f1163p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1163p |= 16;
        } else {
            this.f1163p &= -17;
        }
        this.f1159l.m2478b(false);
        return this;
    }

    public int getGroupId() {
        return this.f1149b;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1148a;
    }

    public int getOrder() {
        return this.f1150c;
    }

    public int m2518c() {
        return this.f1151d;
    }

    public Intent getIntent() {
        return this.f1154g;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1154g = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f1156i;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1156i != c) {
            this.f1156i = Character.toLowerCase(c);
            this.f1159l.m2478b(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f1155h;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1155h != c) {
            this.f1155h = c;
            this.f1159l.m2478b(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1155h = c;
        this.f1156i = Character.toLowerCase(c2);
        this.f1159l.m2478b(false);
        return this;
    }

    char m2520d() {
        return this.f1159l.mo494b() ? this.f1156i : this.f1155h;
    }

    String m2522e() {
        char d = m2520d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f1144w);
        switch (d) {
            case '\b':
                stringBuilder.append(f1146y);
                break;
            case '\n':
                stringBuilder.append(f1145x);
                break;
            case ' ':
                stringBuilder.append(f1147z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    boolean m2524f() {
        return this.f1159l.mo495c() && m2520d() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f1160m;
    }

    public boolean hasSubMenu() {
        return this.f1160m != null;
    }

    public void m2512a(C0553p c0553p) {
        this.f1160m = c0553p;
        c0553p.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1152e;
    }

    CharSequence m2511a(C0527a c0527a) {
        return (c0527a == null || !c0527a.mo453a()) ? getTitle() : getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1152e = charSequence;
        this.f1159l.m2478b(false);
        if (this.f1160m != null) {
            this.f1160m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f1159l.m2486e().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1153f != null ? this.f1153f : this.f1152e;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1153f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1152e;
        }
        this.f1159l.m2478b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f1157j != null) {
            return this.f1157j;
        }
        if (this.f1158k == 0) {
            return null;
        }
        Drawable a = C0632l.m3110a().m3133a(this.f1159l.m2486e(), this.f1158k);
        this.f1158k = 0;
        this.f1157j = a;
        return a;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1158k = 0;
        this.f1157j = drawable;
        this.f1159l.m2478b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1157j = null;
        this.f1158k = i;
        this.f1159l.m2478b(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f1163p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1163p;
        this.f1163p = (z ? 1 : 0) | (this.f1163p & -2);
        if (i != this.f1163p) {
            this.f1159l.m2478b(false);
        }
        return this;
    }

    public void m2514a(boolean z) {
        this.f1163p = (z ? 4 : 0) | (this.f1163p & -5);
    }

    public boolean m2525g() {
        return (this.f1163p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f1163p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1163p & 4) != 0) {
            this.f1159l.m2468a((MenuItem) this);
        } else {
            m2516b(z);
        }
        return this;
    }

    void m2516b(boolean z) {
        int i;
        int i2 = this.f1163p;
        int i3 = this.f1163p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f1163p = i | i3;
        if (i2 != this.f1163p) {
            this.f1159l.m2478b(false);
        }
    }

    public boolean isVisible() {
        if (this.f1166s == null || !this.f1166s.mo488b()) {
            if ((this.f1163p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f1163p & 8) == 0 && this.f1166s.mo489c()) {
            return true;
        } else {
            return false;
        }
    }

    boolean m2519c(boolean z) {
        int i = this.f1163p;
        this.f1163p = (z ? 0 : 8) | (this.f1163p & -9);
        if (i != this.f1163p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (m2519c(z)) {
            this.f1159l.m2465a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1162o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.f1152e != null ? this.f1152e.toString() : null;
    }

    void m2513a(ContextMenuInfo contextMenuInfo) {
        this.f1169v = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1169v;
    }

    public void m2526h() {
        this.f1159l.m2476b(this);
    }

    public boolean m2527i() {
        return this.f1159l.m2498q();
    }

    public boolean m2528j() {
        return (this.f1163p & 32) == 32;
    }

    public boolean m2529k() {
        return (this.f1164q & 1) == 1;
    }

    public boolean m2530l() {
        return (this.f1164q & 2) == 2;
    }

    public void m2521d(boolean z) {
        if (z) {
            this.f1163p |= 32;
        } else {
            this.f1163p &= -33;
        }
    }

    public boolean m2531m() {
        return (this.f1164q & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1164q = i;
                this.f1159l.m2476b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public C0172b m2509a(View view) {
        this.f1165r = view;
        this.f1166s = null;
        if (view != null && view.getId() == -1 && this.f1148a > 0) {
            view.setId(this.f1148a);
        }
        this.f1159l.m2476b(this);
        return this;
    }

    public C0172b m2506a(int i) {
        Context e = this.f1159l.m2486e();
        m2509a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public View getActionView() {
        if (this.f1165r != null) {
            return this.f1165r;
        }
        if (this.f1166s == null) {
            return null;
        }
        this.f1165r = this.f1166s.mo486a((MenuItem) this);
        return this.f1165r;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public C0321d mo461a() {
        return this.f1166s;
    }

    public C0172b mo459a(C0321d c0321d) {
        if (this.f1166s != null) {
            this.f1166s.m1519f();
        }
        this.f1165r = null;
        this.f1166s = c0321d;
        this.f1159l.m2478b(true);
        if (this.f1166s != null) {
            this.f1166s.mo487a(new C05401(this));
        }
        return this;
    }

    public C0172b m2515b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!m2532n()) {
            return false;
        }
        if (this.f1167t == null || this.f1167t.mo484a(this)) {
            return this.f1159l.mo496c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f1164q & 8) == 0) {
            return false;
        }
        if (this.f1165r == null) {
            return true;
        }
        if (this.f1167t == null || this.f1167t.mo485b(this)) {
            return this.f1159l.mo497d(this);
        }
        return false;
    }

    public C0172b mo460a(C0352e c0352e) {
        this.f1167t = c0352e;
        return this;
    }

    public boolean m2532n() {
        if ((this.f1164q & 8) == 0) {
            return false;
        }
        if (this.f1165r == null && this.f1166s != null) {
            this.f1165r = this.f1166s.mo486a((MenuItem) this);
        }
        if (this.f1165r != null) {
            return true;
        }
        return false;
    }

    public void m2523e(boolean z) {
        this.f1168u = z;
        this.f1159l.m2478b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f1168u;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
