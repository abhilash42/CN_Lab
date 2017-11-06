package android.support.v4.p006c.p007a;

import android.support.v4.view.C0321d;
import android.support.v4.view.C0353p.C0352e;
import android.view.MenuItem;
import android.view.View;

/* compiled from: SupportMenuItem */
public interface C0172b extends MenuItem {
    C0172b mo459a(C0321d c0321d);

    C0172b mo460a(C0352e c0352e);

    C0321d mo461a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
