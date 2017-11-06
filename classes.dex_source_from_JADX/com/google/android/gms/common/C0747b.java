package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1023k;

public class C0747b {
    public static final int f1793a = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final C0747b f1794b = new C0747b();

    C0747b() {
    }

    public static C0747b m3202a() {
        return f1794b;
    }

    private String m3203a(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f1793a);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int m3204a(Context context) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        return GooglePlayServicesUtil.zzd(context, isGooglePlayServicesAvailable) ? 18 : isGooglePlayServicesAvailable;
    }

    public Dialog m3205a(Activity activity, int i, int i2) {
        return GooglePlayServicesUtil.getErrorDialog(i, activity, i2);
    }

    public PendingIntent m3206a(Context context, int i, int i2) {
        return m3207a(context, i, i2, null);
    }

    public PendingIntent m3207a(Context context, int i, int i2, String str) {
        Intent a = m3208a(context, i, str);
        return a == null ? null : PendingIntent.getActivity(context, i2, a, 268435456);
    }

    public Intent m3208a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return C1023k.m3578a(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, m3203a(context, str));
            case 3:
                return C1023k.m3577a(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            case 42:
                return C1023k.m3576a();
            default:
                return null;
        }
    }

    public final boolean m3209a(int i) {
        return GooglePlayServicesUtil.isUserRecoverableError(i);
    }
}
