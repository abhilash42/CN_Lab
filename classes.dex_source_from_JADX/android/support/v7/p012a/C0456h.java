package android.support.v7.p012a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.C0454i;
import android.support.v7.view.C0494b;
import android.support.v7.view.C0494b.C0476a;
import android.support.v7.view.C0521g;
import android.support.v7.view.menu.C0538f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

/* compiled from: AppCompatDelegateImplBase */
abstract class C0456h extends C0453g {
    final Context f807a;
    final Window f808b;
    final Callback f809c = this.f808b.getCallback();
    final Callback f810d;
    final C0433f f811e;
    C0432a f812f;
    MenuInflater f813g;
    boolean f814h;
    boolean f815i;
    boolean f816j;
    boolean f817k;
    boolean f818l;
    private CharSequence f819m;
    private boolean f820n;

    /* compiled from: AppCompatDelegateImplBase */
    class C0455a extends C0454i {
        final /* synthetic */ C0456h f806a;

        C0455a(C0456h c0456h, Callback callback) {
            this.f806a = c0456h;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f806a.mo380a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.f806a.mo378a(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C0538f)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0538f c0538f;
            if (menu instanceof C0538f) {
                c0538f = (C0538f) menu;
            } else {
                c0538f = null;
            }
            if (i == 0 && c0538f == null) {
                return false;
            }
            if (c0538f != null) {
                c0538f.m2481c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (c0538f == null) {
                return onPreparePanel;
            }
            c0538f.m2481c(false);
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.f806a.mo385b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.f806a.mo372a(i, menu);
        }
    }

    abstract C0494b mo370a(C0476a c0476a);

    abstract void mo372a(int i, Menu menu);

    abstract boolean mo378a(int i, KeyEvent keyEvent);

    abstract boolean mo380a(KeyEvent keyEvent);

    abstract void mo384b(CharSequence charSequence);

    abstract boolean mo385b(int i, Menu menu);

    abstract void mo391k();

    C0456h(Context context, Window window, C0433f c0433f) {
        this.f807a = context;
        this.f808b = window;
        this.f811e = c0433f;
        if (this.f809c instanceof C0455a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f810d = mo394a(this.f809c);
        this.f808b.setCallback(this.f810d);
    }

    Callback mo394a(Callback callback) {
        return new C0455a(this, callback);
    }

    public C0432a mo364a() {
        mo391k();
        return this.f812f;
    }

    final C0432a m2042l() {
        return this.f812f;
    }

    public MenuInflater mo366b() {
        if (this.f813g == null) {
            mo391k();
            this.f813g = new C0521g(this.f812f != null ? this.f812f.mo414c() : this.f807a);
        }
        return this.f813g;
    }

    final Context m2043m() {
        Context context = null;
        C0432a a = mo364a();
        if (a != null) {
            context = a.mo414c();
        }
        if (context == null) {
            return this.f807a;
        }
        return context;
    }

    public void mo368f() {
        this.f820n = true;
    }

    public boolean mo396n() {
        return false;
    }

    public boolean mo369h() {
        return false;
    }

    final boolean m2045o() {
        return this.f820n;
    }

    final Callback m2046p() {
        return this.f808b.getCallback();
    }

    public final void mo365a(CharSequence charSequence) {
        this.f819m = charSequence;
        mo384b(charSequence);
    }

    public void mo367c(Bundle bundle) {
    }

    final CharSequence m2047q() {
        if (this.f809c instanceof Activity) {
            return ((Activity) this.f809c).getTitle();
        }
        return this.f819m;
    }
}
