package android.support.v7.p012a;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.p012a.C0461j.C0460a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

/* compiled from: AppCompatDelegateImplV23 */
class C0463k extends C0461j {
    private final UiModeManager f852r;

    /* compiled from: AppCompatDelegateImplV23 */
    class C0462a extends C0460a {
        final /* synthetic */ C0463k f851c;

        C0462a(C0463k c0463k, Callback callback) {
            this.f851c = c0463k;
            super(c0463k, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.f851c.mo396n()) {
                switch (i) {
                    case 0:
                        return m2120a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }

    C0463k(Context context, Window window, C0433f c0433f) {
        super(context, window, c0433f);
        this.f852r = (UiModeManager) context.getSystemService("uimode");
    }

    Callback mo394a(Callback callback) {
        return new C0462a(this, callback);
    }

    int mo395d(int i) {
        if (i == 0 && this.f852r.getNightMode() == 0) {
            return -1;
        }
        return super.mo395d(i);
    }
}
