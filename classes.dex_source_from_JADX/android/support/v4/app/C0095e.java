package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: AppOpsManagerCompat */
public final class C0095e {
    private static final C0093b f256a;

    /* compiled from: AppOpsManagerCompat */
    private static class C0093b {
        private C0093b() {
        }

        public String mo44a(String str) {
            return null;
        }

        public int mo43a(Context context, String str, String str2) {
            return 1;
        }
    }

    /* compiled from: AppOpsManagerCompat */
    private static class C0094a extends C0093b {
        private C0094a() {
            super();
        }

        public String mo44a(String str) {
            return C0096f.m314a(str);
        }

        public int mo43a(Context context, String str, String str2) {
            return C0096f.m313a(context, str, str2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f256a = new C0094a();
        } else {
            f256a = new C0093b();
        }
    }

    public static String m312a(String str) {
        return f256a.mo44a(str);
    }

    public static int m311a(Context context, String str, String str2) {
        return f256a.mo43a(context, str, str2);
    }
}
