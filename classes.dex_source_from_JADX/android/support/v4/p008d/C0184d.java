package android.support.v4.p008d;

import android.os.Build.VERSION;
import java.util.Locale;

/* compiled from: TextUtilsCompat */
public final class C0184d {
    public static final Locale f451a = new Locale("", "");
    private static final C0182a f452b;
    private static String f453c = "Arab";
    private static String f454d = "Hebr";

    /* compiled from: TextUtilsCompat */
    private static class C0182a {
        private C0182a() {
        }

        public int mo110a(Locale locale) {
            if (!(locale == null || locale.equals(C0184d.f451a))) {
                String a = C0178a.m721a(locale);
                if (a == null) {
                    return C0182a.m726b(locale);
                }
                if (a.equalsIgnoreCase(C0184d.f453c) || a.equalsIgnoreCase(C0184d.f454d)) {
                    return 1;
                }
            }
            return 0;
        }

        private static int m726b(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case (byte) 1:
                case (byte) 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    /* compiled from: TextUtilsCompat */
    private static class C0183b extends C0182a {
        private C0183b() {
            super();
        }

        public int mo110a(Locale locale) {
            return C0185e.m732a(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f452b = new C0183b();
        } else {
            f452b = new C0182a();
        }
    }

    public static int m729a(Locale locale) {
        return f452b.mo110a(locale);
    }
}
