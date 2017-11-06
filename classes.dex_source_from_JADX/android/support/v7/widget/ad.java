package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.p002b.p003a.C0158i;
import android.support.v7.p014c.p015a.C0510a;

/* compiled from: DrawableUtils */
public class ad {
    public static final Rect f1435a = new Rect();
    private static Class<?> f1436b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f1436b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    static void m2836a(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m2838c(drawable);
        }
    }

    public static boolean m2837b(Drawable drawable) {
        if (drawable instanceof LayerDrawable) {
            boolean z;
            if (VERSION.SDK_INT >= 16) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (drawable instanceof InsetDrawable) {
            if (VERSION.SDK_INT < 14) {
                return false;
            }
            return true;
        } else if (drawable instanceof StateListDrawable) {
            if (VERSION.SDK_INT < 8) {
                return false;
            }
            return true;
        } else if (drawable instanceof GradientDrawable) {
            if (VERSION.SDK_INT < 14) {
                return false;
            }
            return true;
        } else if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainerState)) {
                return true;
            }
            for (Drawable b : ((DrawableContainerState) constantState).getChildren()) {
                if (!m2837b(b)) {
                    return false;
                }
            }
            return true;
        } else if (drawable instanceof C0158i) {
            return m2837b(((C0158i) drawable).mo103a());
        } else {
            if (drawable instanceof C0510a) {
                return m2837b(((C0510a) drawable).m2290a());
            }
            if (drawable instanceof ScaleDrawable) {
                return m2837b(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
    }

    private static void m2838c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(am.f1547e);
        } else {
            drawable.setState(am.f1550h);
        }
        drawable.setState(state);
    }

    static Mode m2835a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                if (VERSION.SDK_INT >= 11) {
                    return Mode.valueOf("ADD");
                }
                return mode;
            default:
                return mode;
        }
    }
}
