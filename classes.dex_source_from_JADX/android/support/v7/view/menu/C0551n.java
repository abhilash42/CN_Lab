package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p006c.p007a.C0171a;
import android.support.v4.p006c.p007a.C0172b;
import android.support.v4.p006c.p007a.C0173c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* compiled from: MenuWrapperFactory */
public final class C0551n {
    public static Menu m2572a(Context context, C0171a c0171a) {
        if (VERSION.SDK_INT >= 14) {
            return new C0552o(context, c0171a);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m2573a(Context context, C0172b c0172b) {
        if (VERSION.SDK_INT >= 16) {
            return new C0548j(context, c0172b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0546i(context, c0172b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m2574a(Context context, C0173c c0173c) {
        if (VERSION.SDK_INT >= 14) {
            return new C0554q(context, c0173c);
        }
        throw new UnsupportedOperationException();
    }
}
