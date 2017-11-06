package android.support.v4.view.p010a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompat */
public final class C0239a {
    private static final C0235d f533a;

    /* compiled from: AccessibilityEventCompat */
    interface C0235d {
    }

    /* compiled from: AccessibilityEventCompat */
    static class C0236c implements C0235d {
        C0236c() {
        }
    }

    /* compiled from: AccessibilityEventCompat */
    static class C0237a extends C0236c {
        C0237a() {
        }
    }

    /* compiled from: AccessibilityEventCompat */
    static class C0238b extends C0237a {
        C0238b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f533a = new C0238b();
        } else if (VERSION.SDK_INT >= 14) {
            f533a = new C0237a();
        } else {
            f533a = new C0236c();
        }
    }

    public static C0270h m917a(AccessibilityEvent accessibilityEvent) {
        return new C0270h(accessibilityEvent);
    }
}
