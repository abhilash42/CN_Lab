package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* compiled from: NavUtilsJB */
class C0140w {
    public static Intent m600a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static boolean m602a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m603b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static String m601a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }
}
