package android.support.v4.view.p010a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompatJellyBean */
class C0262f {

    /* compiled from: AccessibilityNodeProviderCompatJellyBean */
    interface C0253a {
        Object mo176a(int i);

        List<Object> mo177a(String str, int i);

        boolean mo178a(int i, int i2, Bundle bundle);
    }

    public static Object m1048a(final C0253a c0253a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0253a.mo176a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0253a.mo177a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0253a.mo178a(i, i2, bundle);
            }
        };
    }
}
