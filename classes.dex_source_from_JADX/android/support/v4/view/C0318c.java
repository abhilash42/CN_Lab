package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: AccessibilityDelegateCompatJellyBean */
class C0318c {

    /* compiled from: AccessibilityDelegateCompatJellyBean */
    public interface C0232a {
        Object mo146a(View view);

        void mo147a(View view, int i);

        void mo148a(View view, Object obj);

        boolean mo149a(View view, int i, Bundle bundle);

        boolean mo150a(View view, AccessibilityEvent accessibilityEvent);

        boolean mo151a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo152b(View view, AccessibilityEvent accessibilityEvent);

        void mo153c(View view, AccessibilityEvent accessibilityEvent);

        void mo154d(View view, AccessibilityEvent accessibilityEvent);
    }

    public static Object m1504a(final C0232a c0232a) {
        return new AccessibilityDelegate() {
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return c0232a.mo150a(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0232a.mo152b(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                c0232a.mo148a(view, (Object) accessibilityNodeInfo);
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0232a.mo153c(view, accessibilityEvent);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return c0232a.mo151a(viewGroup, view, accessibilityEvent);
            }

            public void sendAccessibilityEvent(View view, int i) {
                c0232a.mo147a(view, i);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                c0232a.mo154d(view, accessibilityEvent);
            }

            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                return (AccessibilityNodeProvider) c0232a.mo146a(view);
            }

            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                return c0232a.mo149a(view, i, bundle);
            }
        };
    }

    public static Object m1505a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m1506a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
