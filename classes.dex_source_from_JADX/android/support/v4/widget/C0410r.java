package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* compiled from: PopupWindowCompatGingerbread */
class C0410r {
    private static Method f677a;
    private static boolean f678b;

    static void m1825a(PopupWindow popupWindow, int i) {
        if (!f678b) {
            try {
                f677a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f677a.setAccessible(true);
            } catch (Exception e) {
            }
            f678b = true;
        }
        if (f677a != null) {
            try {
                f677a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
