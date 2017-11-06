package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.C0494b.C0476a;
import android.support.v7.view.menu.C0538f;
import android.support.v7.view.menu.C0538f.C0457a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode */
public class C0516e extends C0494b implements C0457a {
    private Context f976a;
    private ActionBarContextView f977b;
    private C0476a f978c;
    private WeakReference<View> f979d;
    private boolean f980e;
    private boolean f981f;
    private C0538f f982g;

    public C0516e(Context context, ActionBarContextView actionBarContextView, C0476a c0476a, boolean z) {
        this.f976a = context;
        this.f977b = actionBarContextView;
        this.f978c = c0476a;
        this.f982g = new C0538f(actionBarContextView.getContext()).m2456a(1);
        this.f982g.mo492a((C0457a) this);
        this.f981f = z;
    }

    public void mo430b(CharSequence charSequence) {
        this.f977b.setTitle(charSequence);
    }

    public void mo426a(CharSequence charSequence) {
        this.f977b.setSubtitle(charSequence);
    }

    public void mo424a(int i) {
        mo430b(this.f976a.getString(i));
    }

    public void mo429b(int i) {
        mo426a(this.f976a.getString(i));
    }

    public void mo427a(boolean z) {
        super.mo427a(z);
        this.f977b.setTitleOptional(z);
    }

    public boolean mo435h() {
        return this.f977b.m2600d();
    }

    public void mo425a(View view) {
        this.f977b.setCustomView(view);
        this.f979d = view != null ? new WeakReference(view) : null;
    }

    public void mo432d() {
        this.f978c.mo406b(this, this.f982g);
    }

    public void mo431c() {
        if (!this.f980e) {
            this.f980e = true;
            this.f977b.sendAccessibilityEvent(32);
            this.f978c.mo403a(this);
        }
    }

    public Menu mo428b() {
        return this.f982g;
    }

    public CharSequence mo433f() {
        return this.f977b.getTitle();
    }

    public CharSequence mo434g() {
        return this.f977b.getSubtitle();
    }

    public View mo436i() {
        return this.f979d != null ? (View) this.f979d.get() : null;
    }

    public MenuInflater mo423a() {
        return new C0521g(this.f977b.getContext());
    }

    public boolean mo379a(C0538f c0538f, MenuItem menuItem) {
        return this.f978c.mo405a((C0494b) this, menuItem);
    }

    public void mo375a(C0538f c0538f) {
        mo432d();
        this.f977b.mo501a();
    }
}
