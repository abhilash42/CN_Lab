package android.support.v4.view;

import android.view.WindowInsets;

/* compiled from: WindowInsetsCompatApi21 */
class be extends bd {
    private final WindowInsets f579a;

    be(WindowInsets windowInsets) {
        this.f579a = windowInsets;
    }

    public int mo264a() {
        return this.f579a.getSystemWindowInsetLeft();
    }

    public int mo266b() {
        return this.f579a.getSystemWindowInsetTop();
    }

    public int mo267c() {
        return this.f579a.getSystemWindowInsetRight();
    }

    public int mo268d() {
        return this.f579a.getSystemWindowInsetBottom();
    }

    public boolean mo269e() {
        return this.f579a.isConsumed();
    }

    public bd mo265a(int i, int i2, int i3, int i4) {
        return new be(this.f579a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    WindowInsets m1503f() {
        return this.f579a;
    }
}
