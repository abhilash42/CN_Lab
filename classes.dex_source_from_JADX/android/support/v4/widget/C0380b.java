package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

/* compiled from: CompoundButtonCompat */
public final class C0380b {
    private static final C0376c f657a;

    /* compiled from: CompoundButtonCompat */
    interface C0376c {
        Drawable mo304a(CompoundButton compoundButton);

        void mo305a(CompoundButton compoundButton, ColorStateList colorStateList);

        void mo306a(CompoundButton compoundButton, Mode mode);
    }

    /* compiled from: CompoundButtonCompat */
    static class C0377b implements C0376c {
        C0377b() {
        }

        public void mo305a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0382d.m1739a(compoundButton, colorStateList);
        }

        public void mo306a(CompoundButton compoundButton, Mode mode) {
            C0382d.m1740a(compoundButton, mode);
        }

        public Drawable mo304a(CompoundButton compoundButton) {
            return C0382d.m1738a(compoundButton);
        }
    }

    /* compiled from: CompoundButtonCompat */
    static class C0378d extends C0377b {
        C0378d() {
        }

        public void mo305a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0383e.m1741a(compoundButton, colorStateList);
        }

        public void mo306a(CompoundButton compoundButton, Mode mode) {
            C0383e.m1742a(compoundButton, mode);
        }
    }

    /* compiled from: CompoundButtonCompat */
    static class C0379a extends C0378d {
        C0379a() {
        }

        public Drawable mo304a(CompoundButton compoundButton) {
            return C0381c.m1737a(compoundButton);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f657a = new C0379a();
        } else if (i >= 21) {
            f657a = new C0378d();
        } else {
            f657a = new C0377b();
        }
    }

    public static void m1735a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f657a.mo305a(compoundButton, colorStateList);
    }

    public static void m1736a(CompoundButton compoundButton, Mode mode) {
        f657a.mo306a(compoundButton, mode);
    }

    public static Drawable m1734a(CompoundButton compoundButton) {
        return f657a.mo304a(compoundButton);
    }
}
