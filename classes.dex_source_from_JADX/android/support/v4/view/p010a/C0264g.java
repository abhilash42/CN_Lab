package android.support.v4.view.p010a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatKitKat */
class C0264g {

    /* compiled from: AccessibilityNodeProviderCompatKitKat */
    interface C0257a {
        Object mo180a(int i);

        List<Object> mo181a(String str, int i);

        boolean mo182a(int i, int i2, Bundle bundle);

        Object mo183b(int i);
    }

    public static Object m1049a(final C0257a c0257a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0257a.mo180a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0257a.mo181a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0257a.mo182a(i, i2, bundle);
            }

            public AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) c0257a.mo183b(i);
            }
        };
    }
}
