package android.support.v4.p002b.p003a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: DrawableCompatJellybeanMr1 */
class C0155f {
    private static Method f433a;
    private static boolean f434b;

    public static int m679a(Drawable drawable) {
        if (!f434b) {
            try {
                f433a = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f433a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f434b = true;
        }
        if (f433a != null) {
            try {
                return ((Integer) f433a.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f433a = null;
            }
        }
        return -1;
    }
}
