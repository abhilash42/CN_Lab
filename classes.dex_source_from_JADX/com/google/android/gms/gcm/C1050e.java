package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.aa.C0058d;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

class C1050e {
    static C1050e f2093a;
    private final Context f2094b;
    private final Class<? extends C1043a> f2095c;

    private class C1049a extends IllegalArgumentException {
        final /* synthetic */ C1050e f2092a;

        private C1049a(C1050e c1050e, String str) {
            this.f2092a = c1050e;
            super(str);
        }
    }

    private C1050e(Context context, Class<? extends C1043a> cls) {
        this.f2094b = context.getApplicationContext();
        this.f2095c = cls;
    }

    private int m3792a() {
        return (int) SystemClock.uptimeMillis();
    }

    private PendingIntent m3793a(Bundle bundle, PendingIntent pendingIntent) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_OPEN");
        m3797a(intent, bundle);
        intent.putExtra("com.google.android.gms.gcm.PENDING_INTENT", pendingIntent);
        return PendingIntent.getService(this.f2094b, m3792a(), intent, 1073741824);
    }

    static synchronized C1050e m3794a(Context context, Class<? extends C1043a> cls) {
        C1050e c1050e;
        synchronized (C1050e.class) {
            if (f2093a == null) {
                f2093a = new C1050e(context, cls);
            }
            c1050e = f2093a;
        }
        return c1050e;
    }

    static String m3795a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private String m3796a(String str) {
        return str.substring("gcm.n.".length());
    }

    private void m3797a(Intent intent, Bundle bundle) {
        intent.setClass(this.f2094b, this.f2095c);
        for (String str : bundle.keySet()) {
            if (str.startsWith("gcm.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private void m3798a(String str, Notification notification) {
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.f2094b.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    static boolean m3799a(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    static boolean m3800a(Bundle bundle) {
        return C1050e.m3795a(bundle, "gcm.n.icon") != null;
    }

    private int m3801b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new C1049a("Missing icon");
        }
        Resources resources = this.f2094b.getResources();
        int identifier = resources.getIdentifier(str, "drawable", this.f2094b.getPackageName());
        if (identifier == 0) {
            identifier = resources.getIdentifier(str, "mipmap", this.f2094b.getPackageName());
            if (identifier == 0) {
                throw new C1049a("Icon resource not found: " + str);
            }
        }
        return identifier;
    }

    private String m3802b(Bundle bundle, String str) {
        Object a = C1050e.m3795a(bundle, str);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = C1050e.m3795a(bundle, str + "_loc_key");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        Resources resources = this.f2094b.getResources();
        int identifier = resources.getIdentifier(a2, "string", this.f2094b.getPackageName());
        if (identifier == 0) {
            throw new C1049a(m3796a(str + "_loc_key") + " resource not found: " + a2);
        }
        String a3 = C1050e.m3795a(bundle, str + "_loc_args");
        if (TextUtils.isEmpty(a3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(a3);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            try {
                return resources.getString(identifier, strArr);
            } catch (MissingFormatArgumentException e) {
                throw new C1049a("Missing format argument for " + a2 + ": " + e);
            }
        } catch (JSONException e2) {
            throw new C1049a("Malformed " + m3796a(str + "_loc_args") + ": " + a3);
        }
    }

    static void m3803b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("gcm.n.")) {
                bundle2.putString(str.substring("gcm.n.".length()), bundle.getString(str));
                it.remove();
            } else if (str.startsWith("gcm.notification.")) {
                bundle2.putString(str.substring("gcm.notification.".length()), bundle.getString(str));
                it.remove();
            }
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("notification", bundle2);
        }
    }

    private Uri m3804c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("default".equals(str)) {
            return RingtoneManager.getDefaultUri(2);
        }
        throw new C1049a("Invalid sound: " + str);
    }

    private Notification m3805d(Bundle bundle) {
        PendingIntent pendingIntent = null;
        CharSequence b = m3802b(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(b)) {
            throw new C1049a("Missing title");
        }
        CharSequence b2 = m3802b(bundle, "gcm.n.body");
        int b3 = m3801b(C1050e.m3795a(bundle, "gcm.n.icon"));
        Object a = C1050e.m3795a(bundle, "gcm.n.color");
        Uri c = m3804c(C1050e.m3795a(bundle, "gcm.n.sound"));
        PendingIntent e = m3806e(bundle);
        if (C1043a.m3763a(bundle)) {
            e = m3793a(bundle, e);
            pendingIntent = m3807f(bundle);
        }
        C0058d b4 = new C0058d(this.f2094b).m231a(true).m224a(b3).m230a(b).m234b(b2);
        if (!TextUtils.isEmpty(a)) {
            b4.m232b(Color.parseColor(a));
        }
        if (c != null) {
            b4.m228a(c);
        }
        if (e != null) {
            b4.m226a(e);
        }
        if (pendingIntent != null) {
            b4.m233b(pendingIntent);
        }
        return b4.m223a();
    }

    private PendingIntent m3806e(Bundle bundle) {
        Object a = C1050e.m3795a(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        Intent intent = new Intent(a);
        intent.setPackage(this.f2094b.getPackageName());
        intent.setFlags(268435456);
        intent.putExtras(bundle);
        for (String str : bundle.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.f2094b, m3792a(), intent, 1073741824);
    }

    private PendingIntent m3807f(Bundle bundle) {
        Intent intent = new Intent("com.google.android.gms.gcm.NOTIFICATION_DISMISS");
        m3797a(intent, bundle);
        return PendingIntent.getService(this.f2094b, m3792a(), intent, 1073741824);
    }

    boolean m3808c(Bundle bundle) {
        try {
            m3798a(C1050e.m3795a(bundle, "gcm.n.tag"), m3805d(bundle));
            return true;
        } catch (C1049a e) {
            Log.w("GcmNotification", "Failed to show notification: " + e.getMessage());
            return false;
        }
    }
}
