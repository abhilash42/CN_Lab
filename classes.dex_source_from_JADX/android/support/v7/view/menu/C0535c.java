package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p006c.p007a.C0172b;
import android.support.v4.p006c.p007a.C0173c;
import android.support.v4.p009e.C0189a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BaseMenuWrapper */
abstract class C0535c<T> extends C0534d<T> {
    final Context f1100a;
    private Map<C0172b, MenuItem> f1101c;
    private Map<C0173c, SubMenu> f1102d;

    C0535c(Context context, T t) {
        super(t);
        this.f1100a = context;
    }

    final MenuItem m2429a(MenuItem menuItem) {
        if (!(menuItem instanceof C0172b)) {
            return menuItem;
        }
        C0172b c0172b = (C0172b) menuItem;
        if (this.f1101c == null) {
            this.f1101c = new C0189a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1101c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0551n.m2573a(this.f1100a, c0172b);
        this.f1101c.put(c0172b, menuItem2);
        return menuItem2;
    }

    final SubMenu m2430a(SubMenu subMenu) {
        if (!(subMenu instanceof C0173c)) {
            return subMenu;
        }
        C0173c c0173c = (C0173c) subMenu;
        if (this.f1102d == null) {
            this.f1102d = new C0189a();
        }
        SubMenu subMenu2 = (SubMenu) this.f1102d.get(c0173c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = C0551n.m2574a(this.f1100a, c0173c);
        this.f1102d.put(c0173c, subMenu2);
        return subMenu2;
    }

    final void m2431a() {
        if (this.f1101c != null) {
            this.f1101c.clear();
        }
        if (this.f1102d != null) {
            this.f1102d.clear();
        }
    }

    final void m2432a(int i) {
        if (this.f1101c != null) {
            Iterator it = this.f1101c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m2433b(int i) {
        if (this.f1101c != null) {
            Iterator it = this.f1101c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
