package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

/* compiled from: ViewCompatICS */
class ak {
    public static boolean m1325a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m1326b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m1324a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }
}
