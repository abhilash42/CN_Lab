package android.support.v4.view;

import android.os.Build.VERSION;

/* compiled from: GravityCompat */
public final class C0325e {
    static final C0322a f584a;

    /* compiled from: GravityCompat */
    interface C0322a {
        int mo270a(int i, int i2);
    }

    /* compiled from: GravityCompat */
    static class C0323b implements C0322a {
        C0323b() {
        }

        public int mo270a(int i, int i2) {
            return -8388609 & i;
        }
    }

    /* compiled from: GravityCompat */
    static class C0324c implements C0322a {
        C0324c() {
        }

        public int mo270a(int i, int i2) {
            return C0326f.m1524a(i, i2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f584a = new C0324c();
        } else {
            f584a = new C0323b();
        }
    }

    public static int m1523a(int i, int i2) {
        return f584a.mo270a(i, i2);
    }
}
