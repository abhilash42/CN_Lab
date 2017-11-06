package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p006c.p007a.C0172b;
import android.support.v4.view.C0321d.C0320b;
import android.support.v7.view.menu.C0546i.C0542a;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
/* compiled from: MenuItemWrapperJB */
class C0548j extends C0546i {

    /* compiled from: MenuItemWrapperJB */
    class C0547a extends C0542a implements VisibilityListener {
        C0320b f1176c;
        final /* synthetic */ C0548j f1177d;

        public C0547a(C0548j c0548j, Context context, ActionProvider actionProvider) {
            this.f1177d = c0548j;
            super(c0548j, context, actionProvider);
        }

        public View mo486a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public boolean mo488b() {
            return this.a.overridesItemVisibility();
        }

        public boolean mo489c() {
            return this.a.isVisible();
        }

        public void mo487a(C0320b c0320b) {
            VisibilityListener visibilityListener;
            this.f1176c = c0320b;
            ActionProvider actionProvider = this.a;
            if (c0320b == null) {
                visibilityListener = null;
            }
            actionProvider.setVisibilityListener(visibilityListener);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1176c != null) {
                this.f1176c.mo477a(z);
            }
        }
    }

    C0548j(Context context, C0172b c0172b) {
        super(context, c0172b);
    }

    C0542a mo490a(ActionProvider actionProvider) {
        return new C0547a(this, this.a, actionProvider);
    }
}
