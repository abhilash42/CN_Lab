package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider */
public abstract class C0321d {
    private final Context f581a;
    private C0319a f582b;
    private C0320b f583c;

    /* compiled from: ActionProvider */
    public interface C0319a {
        void mo578a(boolean z);
    }

    /* compiled from: ActionProvider */
    public interface C0320b {
        void mo477a(boolean z);
    }

    public abstract View mo478a();

    public C0321d(Context context) {
        this.f581a = context;
    }

    public View mo486a(MenuItem menuItem) {
        return mo478a();
    }

    public boolean mo488b() {
        return false;
    }

    public boolean mo489c() {
        return true;
    }

    public boolean mo480d() {
        return false;
    }

    public boolean mo481e() {
        return false;
    }

    public void mo479a(SubMenu subMenu) {
    }

    public void m1514a(boolean z) {
        if (this.f582b != null) {
            this.f582b.mo578a(z);
        }
    }

    public void m1511a(C0319a c0319a) {
        this.f582b = c0319a;
    }

    public void mo487a(C0320b c0320b) {
        if (!(this.f583c == null || c0320b == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f583c = c0320b;
    }

    public void m1519f() {
        this.f583c = null;
        this.f582b = null;
    }
}
