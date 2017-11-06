package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p004a.C0023a;
import android.support.v7.view.menu.C0538f.C0457a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuBuilder */
public class C0553p extends C0538f implements SubMenu {
    private C0538f f1199d;
    private C0541h f1200e;

    public C0553p(Context context, C0538f c0538f, C0541h c0541h) {
        super(context);
        this.f1199d = c0538f;
        this.f1200e = c0541h;
    }

    public void setQwertyMode(boolean z) {
        this.f1199d.setQwertyMode(z);
    }

    public boolean mo494b() {
        return this.f1199d.mo494b();
    }

    public boolean mo495c() {
        return this.f1199d.mo495c();
    }

    public Menu m2583s() {
        return this.f1199d;
    }

    public MenuItem getItem() {
        return this.f1200e;
    }

    public void mo492a(C0457a c0457a) {
        this.f1199d.mo492a(c0457a);
    }

    public C0538f mo498p() {
        return this.f1199d;
    }

    boolean mo493a(C0538f c0538f, MenuItem menuItem) {
        return super.mo493a(c0538f, menuItem) || this.f1199d.mo493a(c0538f, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1200e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1200e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m2457a(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m2457a(C0023a.m77a(m2486e(), i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m2459a(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m2459a(m2486e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m2458a(view);
        return this;
    }

    public boolean mo496c(C0541h c0541h) {
        return this.f1199d.mo496c(c0541h);
    }

    public boolean mo497d(C0541h c0541h) {
        return this.f1199d.mo497d(c0541h);
    }

    public String mo491a() {
        int itemId = this.f1200e != null ? this.f1200e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo491a() + ":" + itemId;
    }
}
