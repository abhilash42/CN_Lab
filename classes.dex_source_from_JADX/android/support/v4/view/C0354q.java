package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompatHoneycomb */
class C0354q {
    public static void m1593a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m1591a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static MenuItem m1594b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    public static View m1592a(MenuItem menuItem) {
        return menuItem.getActionView();
    }
}
