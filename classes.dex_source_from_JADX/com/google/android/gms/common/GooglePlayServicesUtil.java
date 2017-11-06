package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserManager;
import android.support.v4.app.C0113l;
import android.support.v4.app.Fragment;
import android.support.v4.app.aa.C0058d;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.C0729a.C0725a;
import com.google.android.gms.C0729a.C0726b;
import com.google.android.gms.common.C0994f.bj;
import com.google.android.gms.common.internal.C1000c;
import com.google.android.gms.common.internal.C1003e;
import com.google.android.gms.common.internal.C1004f;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1073c;
import com.google.android.gms.internal.C1078h;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzov();
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzaee = false;
    public static boolean zzaef = false;
    private static int zzaeg = -1;
    private static String zzaeh = null;
    private static Integer zzaei = null;
    static final AtomicBoolean zzaej = new AtomicBoolean();
    private static final AtomicBoolean zzaek = new AtomicBoolean();
    private static final Object zzqf = new Object();

    private static class C0731a extends Handler {
        private final Context f1756a;

        C0731a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f1756a = context.getApplicationContext();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f1756a);
                    if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                        GooglePlayServicesUtil.zza(isGooglePlayServicesAvailable, this.f1756a);
                        return;
                    }
                    return;
                default:
                    Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + message.what);
                    return;
            }
        }
    }

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return zza(i, activity, null, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return C0747b.m3202a().m3206a(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.m3176a(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority(GOOGLE_PLAY_SERVICES_PACKAGE).appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        if (C1000c.f1951a) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0726b.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!GOOGLE_PLAY_SERVICES_PACKAGE.equals(context.getPackageName())) {
            zzak(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            C0995g a = C0995g.m3451a();
            if (!C1073c.m3905a(context)) {
                try {
                    if (a.m3453a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256), bj.f1853a) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (a.m3453a(packageInfo, a.m3453a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256), bj.f1853a)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (a.m3453a(packageInfo, bj.f1853a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (C1073c.m3904a(packageInfo.versionCode) < C1073c.m3904a(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Dialog zza = zza(i, activity, fragment, i2, onCancelListener);
        if (zza == null) {
            return false;
        }
        zza(activity, onCancelListener, GMS_ERROR_DIALOG, zza);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        if (C1073c.m3905a(context) && i == 2) {
            i = 42;
        }
        if (zzd(context, i) || zzf(context, i)) {
            zzal(context);
        } else {
            zza(i, context);
        }
    }

    private static Dialog zza(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (C1073c.m3905a((Context) activity) && i == 2) {
            i = 42;
        }
        if (C1078h.m3918c()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(C1003e.m3479a(activity, i, zzam(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent a = C0747b.m3202a().m3208a((Context) activity, i, "d");
        OnClickListener c1004f = fragment == null ? new C1004f(activity, a, i2) : new C1004f(fragment, a, i2);
        CharSequence b = C1003e.m3480b(activity, i);
        if (b != null) {
            builder.setPositiveButton(b, c1004f);
        }
        CharSequence a2 = C1003e.m3478a(activity, i);
        if (a2 != null) {
            builder.setTitle(a2);
        }
        return builder.create();
    }

    private static void zza(int i, Context context) {
        zza(i, context, null);
    }

    private static void zza(int i, Context context, String str) {
        Notification build;
        int i2;
        Resources resources = context.getResources();
        String zzam = zzam(context);
        CharSequence c = C1003e.m3482c(context, i);
        if (c == null) {
            c = resources.getString(C0726b.common_google_play_services_notification_ticker);
        }
        CharSequence b = C1003e.m3481b(context, i, zzam);
        PendingIntent a = C0747b.m3202a().m3207a(context, i, 0, "n");
        if (C1073c.m3905a(context)) {
            C1032p.m3682a(C1078h.m3919d());
            build = new Notification.Builder(context).setSmallIcon(C0725a.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(c + " " + b)).addAction(C0725a.common_full_open_on_phone, resources.getString(C0726b.common_open_on_phone), a).build();
        } else {
            CharSequence string = resources.getString(C0726b.common_google_play_services_notification_ticker);
            if (C1078h.m3915a()) {
                Notification build2;
                Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(c).setContentText(b).setContentIntent(a).setTicker(string).setAutoCancel(true);
                if (C1078h.m3922g()) {
                    autoCancel.setLocalOnly(true);
                }
                if (C1078h.m3919d()) {
                    autoCancel.setStyle(new BigTextStyle().bigText(b));
                    build2 = autoCancel.build();
                } else {
                    build2 = autoCancel.getNotification();
                }
                if (VERSION.SDK_INT == 19) {
                    build2.extras.putBoolean("android.support.localOnly", true);
                }
                build = build2;
            } else {
                build = new C0058d(context).m224a(17301642).m236c(string).m225a(System.currentTimeMillis()).m231a(true).m226a(a).m230a(c).m234b(b).m223a();
            }
        }
        if (zzbw(i)) {
            zzaej.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, build);
        } else {
            notificationManager.notify(i2, build);
        }
    }

    public static void zza(Activity activity, OnCancelListener onCancelListener, String str, Dialog dialog) {
        boolean z;
        try {
            z = activity instanceof C0113l;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            C0748c.m3210a(dialog, onCancelListener).mo657a(((C0113l) activity).m428f(), str);
        } else if (C1078h.m3915a()) {
            C0732a.m3181a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    @Deprecated
    public static void zzac(Context context) {
        int a = C0747b.m3202a().m3204a(context);
        if (a != 0) {
            Intent a2 = C0747b.m3202a().m3208a(context, a, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + a);
            if (a2 == null) {
                throw new GooglePlayServicesNotAvailableException(a);
            }
            throw new GooglePlayServicesRepairableException(a, "Google Play Services not available", a2);
        }
    }

    @Deprecated
    public static void zzaj(Context context) {
        if (!zzaej.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    private static void zzak(Context context) {
        if (!zzaek.get()) {
            Integer num;
            synchronized (zzqf) {
                if (zzaeh == null) {
                    zzaeh = context.getPackageName();
                    try {
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle != null) {
                            zzaei = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            zzaei = null;
                        }
                    } catch (Throwable e) {
                        Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                    }
                } else if (!zzaeh.equals(context.getPackageName())) {
                    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzaeh + "' and this call used package '" + context.getPackageName() + "'.");
                }
                num = zzaei;
            }
            if (num == null) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (num.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but" + " found " + num + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
    }

    private static void zzal(Context context) {
        Handler c0731a = new C0731a(context);
        c0731a.sendMessageDelayed(c0731a.obtainMessage(1), 120000);
    }

    public static String zzam(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    @Deprecated
    public static int zzan(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    public static boolean zzao(Context context) {
        return C1078h.m3923h() && context.getPackageManager().hasSystemFeature("cn.google");
    }

    public static boolean zzap(Context context) {
        if (C1078h.m3920e()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzb(Context context, int i, String str) {
        if (C1078h.m3921f()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzb(PackageManager packageManager) {
        boolean z = true;
        synchronized (zzqf) {
            if (zzaeg == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
                    if (C0995g.m3451a().m3453a(packageInfo, C0994f.f1930b[1]) != null) {
                        zzaeg = 1;
                    } else {
                        zzaeg = 0;
                    }
                } catch (NameNotFoundException e) {
                    zzaeg = 0;
                }
            }
            if (zzaeg == 0) {
                z = false;
            }
        }
        return z;
    }

    @Deprecated
    public static boolean zzb(PackageManager packageManager, String str) {
        return C0995g.m3451a().m3455a(packageManager, str);
    }

    @Deprecated
    public static Intent zzbv(int i) {
        return C0747b.m3202a().m3208a(null, i, null);
    }

    private static boolean zzbw(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case 42:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzc(PackageManager packageManager) {
        return zzb(packageManager) || !zzow();
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return i == 18 ? true : i == 1 ? zzh(context, GOOGLE_PLAY_SERVICES_PACKAGE) : false;
    }

    public static boolean zze(Context context, int i) {
        return zzb(context, i, GOOGLE_PLAY_SERVICES_PACKAGE) && zzb(context.getPackageManager(), GOOGLE_PLAY_SERVICES_PACKAGE);
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        return i == 9 ? zzh(context, GOOGLE_PLAY_STORE_PACKAGE) : false;
    }

    static boolean zzh(Context context, String str) {
        if (C1078h.m3923h()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (zzap(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192).enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static int zzov() {
        return 8298000;
    }

    public static boolean zzow() {
        return zzaee ? zzaef : "user".equals(Build.TYPE);
    }
}
