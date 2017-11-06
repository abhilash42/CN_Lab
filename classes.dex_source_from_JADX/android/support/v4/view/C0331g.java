package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* compiled from: KeyEventCompat */
public final class C0331g {
    static final C0327d f585a;

    /* compiled from: KeyEventCompat */
    interface C0327d {
        boolean mo271a(int i, int i2);

        boolean mo272b(int i);
    }

    /* compiled from: KeyEventCompat */
    static class C0328a implements C0327d {
        C0328a() {
        }

        private static int m1527a(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 != null) {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (obj != null) {
                return i & (i3 ^ -1);
            } else {
                return i;
            }
        }

        public int mo273a(int i) {
            int i2;
            if ((i & 192) != 0) {
                i2 = i | 1;
            } else {
                i2 = i;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean mo271a(int i, int i2) {
            if (C0328a.m1527a(C0328a.m1527a(mo273a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean mo272b(int i) {
            return (mo273a(i) & 247) == 0;
        }
    }

    /* compiled from: KeyEventCompat */
    static class C0329b extends C0328a {
        C0329b() {
        }
    }

    /* compiled from: KeyEventCompat */
    static class C0330c extends C0329b {
        C0330c() {
        }

        public int mo273a(int i) {
            return C0332h.m1536a(i);
        }

        public boolean mo271a(int i, int i2) {
            return C0332h.m1537a(i, i2);
        }

        public boolean mo272b(int i) {
            return C0332h.m1538b(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f585a = new C0330c();
        } else {
            f585a = new C0328a();
        }
    }

    public static boolean m1535a(KeyEvent keyEvent, int i) {
        return f585a.mo271a(keyEvent.getMetaState(), i);
    }

    public static boolean m1534a(KeyEvent keyEvent) {
        return f585a.mo272b(keyEvent.getMetaState());
    }
}
