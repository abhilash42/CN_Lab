package android.support.v4.view.p010a;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: AccessibilityNodeInfoCompatIcs */
class C0250c {
    public static void m1005a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public static int m1004a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void m1006a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void m1010b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static CharSequence m1009b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static CharSequence m1011c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static CharSequence m1012d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static CharSequence m1013e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static boolean m1014f(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean m1015g(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean m1016h(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean m1017i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean m1018j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean m1019k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean m1020l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean m1021m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean m1022n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean m1023o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static void m1007a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void m1008a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }
}
