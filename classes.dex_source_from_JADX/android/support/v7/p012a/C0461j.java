package android.support.v7.p012a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.p012a.C0456h.C0455a;
import android.support.v7.view.C0494b;
import android.support.v7.view.C0494b.C0476a;
import android.support.v7.view.C0518f.C0517a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

/* compiled from: AppCompatDelegateImplV14 */
class C0461j extends C0459i {
    private static C0490q f847r;
    private int f848s = -100;
    private boolean f849t;
    private boolean f850u = true;

    /* compiled from: AppCompatDelegateImplV14 */
    class C0460a extends C0455a {
        final /* synthetic */ C0461j f846b;

        C0460a(C0461j c0461j, Callback callback) {
            this.f846b = c0461j;
            super(c0461j, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (this.f846b.mo396n()) {
                return m2120a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode m2120a(ActionMode.Callback callback) {
            Object c0517a = new C0517a(this.f846b.a, callback);
            C0494b b = this.f846b.m2101b((C0476a) c0517a);
            if (b != null) {
                return c0517a.m2326b(b);
            }
            return null;
        }
    }

    C0461j(Context context, Window window, C0433f c0433f) {
        super(context, window, c0433f);
    }

    public void mo374a(Bundle bundle) {
        super.mo374a(bundle);
        if (bundle != null && this.f848s == -100) {
            this.f848s = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback mo394a(Callback callback) {
        return new C0460a(this, callback);
    }

    public boolean mo396n() {
        return this.f850u;
    }

    public boolean mo369h() {
        this.f849t = true;
        int d = mo395d(this.f848s == -100 ? C0453g.m2007i() : this.f848s);
        if (d != -1) {
            return m2121e(d);
        }
        return false;
    }

    int mo395d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                return m2122s().m2199a() ? 2 : 1;
            default:
                return i;
        }
    }

    public void mo367c(Bundle bundle) {
        super.mo367c(bundle);
        if (this.f848s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f848s);
        }
    }

    private boolean m2121e(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    private C0490q m2122s() {
        if (f847r == null) {
            f847r = new C0490q(this.a.getApplicationContext());
        }
        return f847r;
    }
}
