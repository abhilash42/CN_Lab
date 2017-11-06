package android.support.v4.p008d;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompatApi23 */
class C0179b {
    private static Method f448a;

    static {
        try {
            f448a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m722a(Locale locale) {
        try {
            return ((Locale) f448a.invoke(null, new Object[]{locale})).getScript();
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
