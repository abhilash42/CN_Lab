package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

/* compiled from: AppOpsManagerCompat23 */
class C0096f {
    public static String m314a(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public static int m313a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }
}
