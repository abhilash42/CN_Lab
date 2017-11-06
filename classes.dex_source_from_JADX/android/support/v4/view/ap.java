package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: ViewCompatLollipop */
class ap {
    public static void m1344a(View view) {
        view.requestApplyInsets();
    }

    public static void m1345a(View view, float f) {
        view.setElevation(f);
    }

    public static void m1348a(View view, final aa aaVar) {
        if (aaVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return ((be) aaVar.mo122a(view, new be(windowInsets))).m1503f();
                }
            });
        }
    }

    static ColorStateList m1349b(View view) {
        return view.getBackgroundTintList();
    }

    static void m1346a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static Mode m1351c(View view) {
        return view.getBackgroundTintMode();
    }

    static void m1347a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static bd m1343a(View view, bd bdVar) {
        if (!(bdVar instanceof be)) {
            return bdVar;
        }
        WindowInsets f = ((be) bdVar).m1503f();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f);
        if (onApplyWindowInsets != f) {
            return new be(onApplyWindowInsets);
        }
        return bdVar;
    }

    public static bd m1350b(View view, bd bdVar) {
        if (!(bdVar instanceof be)) {
            return bdVar;
        }
        WindowInsets f = ((be) bdVar).m1503f();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(f);
        if (dispatchApplyWindowInsets != f) {
            return new be(dispatchApplyWindowInsets);
        }
        return bdVar;
    }

    public static void m1352d(View view) {
        view.stopNestedScroll();
    }
}
