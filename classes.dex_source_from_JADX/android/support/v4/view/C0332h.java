package android.support.v4.view;

import android.view.KeyEvent;

/* compiled from: KeyEventCompatHoneycomb */
class C0332h {
    public static int m1536a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m1537a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m1538b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
