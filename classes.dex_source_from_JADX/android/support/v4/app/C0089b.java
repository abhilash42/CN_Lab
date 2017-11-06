package android.support.v4.app;

import android.app.Activity;

/* compiled from: ActivityCompat23 */
class C0089b {

    /* compiled from: ActivityCompat23 */
    public interface C0088a {
        void mo71a(int i);
    }

    public static void m303a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C0088a) {
            ((C0088a) activity).mo71a(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
