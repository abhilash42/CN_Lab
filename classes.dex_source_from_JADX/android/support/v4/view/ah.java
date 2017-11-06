package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewCompatBase */
class ah {
    private static Field f552a;
    private static boolean f553b;

    static ColorStateList m1302a(View view) {
        return view instanceof ad ? ((ad) view).getSupportBackgroundTintList() : null;
    }

    static void m1303a(View view, ColorStateList colorStateList) {
        if (view instanceof ad) {
            ((ad) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static Mode m1305b(View view) {
        return view instanceof ad ? ((ad) view).getSupportBackgroundTintMode() : null;
    }

    static void m1304a(View view, Mode mode) {
        if (view instanceof ad) {
            ((ad) view).setSupportBackgroundTintMode(mode);
        }
    }

    static boolean m1306c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m1307d(View view) {
        if (!f553b) {
            try {
                f552a = View.class.getDeclaredField("mMinHeight");
                f552a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f553b = true;
        }
        if (f552a != null) {
            try {
                return ((Integer) f552a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m1308e(View view) {
        return view.getWindowToken() != null;
    }
}
