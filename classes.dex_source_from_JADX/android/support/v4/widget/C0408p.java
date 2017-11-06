package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* compiled from: PopupWindowCompatApi21 */
class C0408p {
    private static Field f676a;

    static {
        try {
            f676a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f676a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m1822a(PopupWindow popupWindow, boolean z) {
        if (f676a != null) {
            try {
                f676a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
