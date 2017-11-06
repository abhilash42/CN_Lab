package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: ActivityCompatJB */
class C0091d {
    public static void m306a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void m305a(Activity activity) {
        activity.finishAffinity();
    }
}
