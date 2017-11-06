package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionMode */
public abstract class C0494b {
    private Object f928a;
    private boolean f929b;

    /* compiled from: ActionMode */
    public interface C0476a {
        void mo403a(C0494b c0494b);

        boolean mo404a(C0494b c0494b, Menu menu);

        boolean mo405a(C0494b c0494b, MenuItem menuItem);

        boolean mo406b(C0494b c0494b, Menu menu);
    }

    public abstract MenuInflater mo423a();

    public abstract void mo424a(int i);

    public abstract void mo425a(View view);

    public abstract void mo426a(CharSequence charSequence);

    public abstract Menu mo428b();

    public abstract void mo429b(int i);

    public abstract void mo430b(CharSequence charSequence);

    public abstract void mo431c();

    public abstract void mo432d();

    public abstract CharSequence mo433f();

    public abstract CharSequence mo434g();

    public abstract View mo436i();

    public void m2207a(Object obj) {
        this.f928a = obj;
    }

    public Object m2218j() {
        return this.f928a;
    }

    public void mo427a(boolean z) {
        this.f929b = z;
    }

    public boolean m2219k() {
        return this.f929b;
    }

    public boolean mo435h() {
        return false;
    }
}
