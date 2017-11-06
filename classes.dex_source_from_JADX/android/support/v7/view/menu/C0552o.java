package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.p006c.p007a.C0171a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: MenuWrapperICS */
class C0552o extends C0535c<C0171a> implements Menu {
    C0552o(Context context, C0171a c0171a) {
        super(context, c0171a);
    }

    public MenuItem add(CharSequence charSequence) {
        return m2429a(((C0171a) this.b).add(charSequence));
    }

    public MenuItem add(int i) {
        return m2429a(((C0171a) this.b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m2429a(((C0171a) this.b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m2429a(((C0171a) this.b).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m2430a(((C0171a) this.b).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return m2430a(((C0171a) this.b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m2430a(((C0171a) this.b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m2430a(((C0171a) this.b).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((C0171a) this.b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m2429a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        m2433b(i);
        ((C0171a) this.b).removeItem(i);
    }

    public void removeGroup(int i) {
        m2432a(i);
        ((C0171a) this.b).removeGroup(i);
    }

    public void clear() {
        m2431a();
        ((C0171a) this.b).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((C0171a) this.b).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((C0171a) this.b).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((C0171a) this.b).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((C0171a) this.b).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return m2429a(((C0171a) this.b).findItem(i));
    }

    public int size() {
        return ((C0171a) this.b).size();
    }

    public MenuItem getItem(int i) {
        return m2429a(((C0171a) this.b).getItem(i));
    }

    public void close() {
        ((C0171a) this.b).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((C0171a) this.b).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((C0171a) this.b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((C0171a) this.b).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((C0171a) this.b).setQwertyMode(z);
    }
}
