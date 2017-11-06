package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p004a.C0023a;

/* compiled from: ActivityCompat */
public class C0050a extends C0023a {

    /* compiled from: ActivityCompat */
    public interface C0049a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void m205a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0091d.m306a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m204a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0091d.m305a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m206a(final Activity activity, final String[] strArr, final int i) {
        if (VERSION.SDK_INT >= 23) {
            C0089b.m303a(activity, strArr, i);
        } else if (activity instanceof C0049a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0049a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }
}
