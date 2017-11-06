package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p006c.p007a.C0172b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* compiled from: MenuItemCompat */
public final class C0353p {
    static final C0348d f591a;

    /* compiled from: MenuItemCompat */
    interface C0348d {
        MenuItem mo278a(MenuItem menuItem, View view);

        View mo279a(MenuItem menuItem);

        void mo280a(MenuItem menuItem, int i);

        MenuItem mo281b(MenuItem menuItem, int i);

        boolean mo282b(MenuItem menuItem);

        boolean mo283c(MenuItem menuItem);
    }

    /* compiled from: MenuItemCompat */
    static class C0349a implements C0348d {
        C0349a() {
        }

        public void mo280a(MenuItem menuItem, int i) {
        }

        public MenuItem mo278a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public MenuItem mo281b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public View mo279a(MenuItem menuItem) {
            return null;
        }

        public boolean mo282b(MenuItem menuItem) {
            return false;
        }

        public boolean mo283c(MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: MenuItemCompat */
    static class C0350b implements C0348d {
        C0350b() {
        }

        public void mo280a(MenuItem menuItem, int i) {
            C0354q.m1593a(menuItem, i);
        }

        public MenuItem mo278a(MenuItem menuItem, View view) {
            return C0354q.m1591a(menuItem, view);
        }

        public MenuItem mo281b(MenuItem menuItem, int i) {
            return C0354q.m1594b(menuItem, i);
        }

        public View mo279a(MenuItem menuItem) {
            return C0354q.m1592a(menuItem);
        }

        public boolean mo282b(MenuItem menuItem) {
            return false;
        }

        public boolean mo283c(MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: MenuItemCompat */
    static class C0351c extends C0350b {
        C0351c() {
        }

        public boolean mo282b(MenuItem menuItem) {
            return C0355r.m1595a(menuItem);
        }

        public boolean mo283c(MenuItem menuItem) {
            return C0355r.m1596b(menuItem);
        }
    }

    /* compiled from: MenuItemCompat */
    public interface C0352e {
        boolean mo484a(MenuItem menuItem);

        boolean mo485b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f591a = new C0351c();
        } else if (i >= 11) {
            f591a = new C0350b();
        } else {
            f591a = new C0349a();
        }
    }

    public static void m1587a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0172b) {
            ((C0172b) menuItem).setShowAsAction(i);
        } else {
            f591a.mo280a(menuItem, i);
        }
    }

    public static MenuItem m1585a(MenuItem menuItem, View view) {
        if (menuItem instanceof C0172b) {
            return ((C0172b) menuItem).setActionView(view);
        }
        return f591a.mo278a(menuItem, view);
    }

    public static MenuItem m1588b(MenuItem menuItem, int i) {
        if (menuItem instanceof C0172b) {
            return ((C0172b) menuItem).setActionView(i);
        }
        return f591a.mo281b(menuItem, i);
    }

    public static View m1586a(MenuItem menuItem) {
        if (menuItem instanceof C0172b) {
            return ((C0172b) menuItem).getActionView();
        }
        return f591a.mo279a(menuItem);
    }

    public static MenuItem m1584a(MenuItem menuItem, C0321d c0321d) {
        if (menuItem instanceof C0172b) {
            return ((C0172b) menuItem).mo459a(c0321d);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean m1589b(MenuItem menuItem) {
        if (menuItem instanceof C0172b) {
            return ((C0172b) menuItem).expandActionView();
        }
        return f591a.mo282b(menuItem);
    }

    public static boolean m1590c(MenuItem menuItem) {
        if (menuItem instanceof C0172b) {
            return ((C0172b) menuItem).isActionViewExpanded();
        }
        return f591a.mo283c(menuItem);
    }
}
