package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p006c.p007a.C0171a;
import android.support.v4.p006c.p007a.C0172b;
import android.support.v4.p009e.C0188i;
import android.support.v7.view.C0494b.C0476a;
import android.support.v7.view.menu.C0551n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
/* compiled from: SupportActionModeWrapper */
public class C0518f extends ActionMode {
    final Context f987a;
    final C0494b f988b;

    /* compiled from: SupportActionModeWrapper */
    public static class C0517a implements C0476a {
        final Callback f983a;
        final Context f984b;
        final ArrayList<C0518f> f985c = new ArrayList();
        final C0188i<Menu, Menu> f986d = new C0188i();

        public C0517a(Context context, Callback callback) {
            this.f984b = context;
            this.f983a = callback;
        }

        public boolean mo404a(C0494b c0494b, Menu menu) {
            return this.f983a.onCreateActionMode(m2326b(c0494b), m2322a(menu));
        }

        public boolean mo406b(C0494b c0494b, Menu menu) {
            return this.f983a.onPrepareActionMode(m2326b(c0494b), m2322a(menu));
        }

        public boolean mo405a(C0494b c0494b, MenuItem menuItem) {
            return this.f983a.onActionItemClicked(m2326b(c0494b), C0551n.m2573a(this.f984b, (C0172b) menuItem));
        }

        public void mo403a(C0494b c0494b) {
            this.f983a.onDestroyActionMode(m2326b(c0494b));
        }

        private Menu m2322a(Menu menu) {
            Menu menu2 = (Menu) this.f986d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = C0551n.m2572a(this.f984b, (C0171a) menu);
            this.f986d.put(menu, menu2);
            return menu2;
        }

        public ActionMode m2326b(C0494b c0494b) {
            int size = this.f985c.size();
            for (int i = 0; i < size; i++) {
                C0518f c0518f = (C0518f) this.f985c.get(i);
                if (c0518f != null && c0518f.f988b == c0494b) {
                    return c0518f;
                }
            }
            ActionMode c0518f2 = new C0518f(this.f984b, c0494b);
            this.f985c.add(c0518f2);
            return c0518f2;
        }
    }

    public C0518f(Context context, C0494b c0494b) {
        this.f987a = context;
        this.f988b = c0494b;
    }

    public Object getTag() {
        return this.f988b.m2218j();
    }

    public void setTag(Object obj) {
        this.f988b.m2207a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f988b.mo430b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f988b.mo426a(charSequence);
    }

    public void invalidate() {
        this.f988b.mo432d();
    }

    public void finish() {
        this.f988b.mo431c();
    }

    public Menu getMenu() {
        return C0551n.m2572a(this.f987a, (C0171a) this.f988b.mo428b());
    }

    public CharSequence getTitle() {
        return this.f988b.mo433f();
    }

    public void setTitle(int i) {
        this.f988b.mo424a(i);
    }

    public CharSequence getSubtitle() {
        return this.f988b.mo434g();
    }

    public void setSubtitle(int i) {
        this.f988b.mo429b(i);
    }

    public View getCustomView() {
        return this.f988b.mo436i();
    }

    public void setCustomView(View view) {
        this.f988b.mo425a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f988b.mo423a();
    }

    public boolean getTitleOptionalHint() {
        return this.f988b.m2219k();
    }

    public void setTitleOptionalHint(boolean z) {
        this.f988b.mo427a(z);
    }

    public boolean isTitleOptional() {
        return this.f988b.mo435h();
    }
}
