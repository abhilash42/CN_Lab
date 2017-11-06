package android.support.v4.p008d;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompatIcs */
class C0180c {
    private static Method f449a;
    private static Method f450b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f449a = cls.getMethod("getScript", new Class[]{String.class});
                f450b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f449a = null;
            f450b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String m724a(Locale locale) {
        String b = C0180c.m725b(locale);
        if (b != null) {
            return C0180c.m723a(b);
        }
        return null;
    }

    private static String m723a(String str) {
        try {
            if (f449a != null) {
                return (String) f449a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String m725b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f450b != null) {
                return (String) f450b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
