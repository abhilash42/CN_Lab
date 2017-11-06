package android.support.v4.p008d;

import android.os.Build.VERSION;
import java.util.Locale;

/* compiled from: ICUCompat */
public final class C0178a {
    private static final C0174a f447a;

    /* compiled from: ICUCompat */
    interface C0174a {
        String mo109a(Locale locale);
    }

    /* compiled from: ICUCompat */
    static class C0175b implements C0174a {
        C0175b() {
        }

        public String mo109a(Locale locale) {
            return null;
        }
    }

    /* compiled from: ICUCompat */
    static class C0176c implements C0174a {
        C0176c() {
        }

        public String mo109a(Locale locale) {
            return C0180c.m724a(locale);
        }
    }

    /* compiled from: ICUCompat */
    static class C0177d implements C0174a {
        C0177d() {
        }

        public String mo109a(Locale locale) {
            return C0179b.m722a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f447a = new C0177d();
        } else if (i >= 14) {
            f447a = new C0176c();
        } else {
            f447a = new C0175b();
        }
    }

    public static String m721a(Locale locale) {
        return f447a.mo109a(locale);
    }
}
