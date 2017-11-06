package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* compiled from: ViewConfigurationCompat */
public final class ar {
    static final C0290e f555a;

    /* compiled from: ViewConfigurationCompat */
    interface C0290e {
        int mo239a(ViewConfiguration viewConfiguration);

        boolean mo240b(ViewConfiguration viewConfiguration);
    }

    /* compiled from: ViewConfigurationCompat */
    static class C0291a implements C0290e {
        C0291a() {
        }

        public int mo239a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean mo240b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    /* compiled from: ViewConfigurationCompat */
    static class C0292b extends C0291a {
        C0292b() {
        }

        public int mo239a(ViewConfiguration viewConfiguration) {
            return as.m1363a(viewConfiguration);
        }
    }

    /* compiled from: ViewConfigurationCompat */
    static class C0293c extends C0292b {
        C0293c() {
        }

        public boolean mo240b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    /* compiled from: ViewConfigurationCompat */
    static class C0294d extends C0293c {
        C0294d() {
        }

        public boolean mo240b(ViewConfiguration viewConfiguration) {
            return at.m1364a(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f555a = new C0294d();
        } else if (VERSION.SDK_INT >= 11) {
            f555a = new C0293c();
        } else if (VERSION.SDK_INT >= 8) {
            f555a = new C0292b();
        } else {
            f555a = new C0291a();
        }
    }

    public static int m1361a(ViewConfiguration viewConfiguration) {
        return f555a.mo239a(viewConfiguration);
    }

    public static boolean m1362b(ViewConfiguration viewConfiguration) {
        return f555a.mo240b(viewConfiguration);
    }
}
