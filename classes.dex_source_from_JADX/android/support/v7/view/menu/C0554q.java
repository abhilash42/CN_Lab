package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p006c.p007a.C0173c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuWrapperICS */
class C0554q extends C0552o implements SubMenu {
    C0554q(Context context, C0173c c0173c) {
        super(context, c0173c);
    }

    public C0173c m2584b() {
        return (C0173c) this.b;
    }

    public SubMenu setHeaderTitle(int i) {
        m2584b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m2584b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        m2584b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m2584b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m2584b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        m2584b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        m2584b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m2584b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m2429a(m2584b().getItem());
    }
}
