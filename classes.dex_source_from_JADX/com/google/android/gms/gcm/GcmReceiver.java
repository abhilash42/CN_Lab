package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.p004a.C0042k;
import android.util.Base64;

public class GcmReceiver extends C0042k {
    private static String f2068a = "gcm.googleapis.com/refresh";

    public void m3759b(Context context, Intent intent) {
        C0042k.m114a(context, intent);
    }

    public void onReceive(Context context, Intent intent) {
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("from");
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction()) || "google.com/iid".equals(stringExtra) || f2068a.equals(stringExtra)) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            m3759b(context, intent);
        } else {
            C0042k.m114a(context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
    }
}
