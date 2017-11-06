package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.C1100a;

class C1047d {
    static C1100a f2091a;

    public static void m3787a(Context context, Intent intent) {
        C1047d.m3788a(context, "_nr", intent);
    }

    private static void m3788a(Context context, String str, Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.a.campaign");
        if (Log.isLoggable("GcmAnalytics", 3)) {
            Log.d("GcmAnalytics", "Sending event=" + str + " campaign=" + stringExtra);
        }
        Bundle bundle = new Bundle();
        bundle.putString("nc", stringExtra);
        stringExtra = intent.getStringExtra("from");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (stringExtra.startsWith("/topics/")) {
                bundle.putString("nt", stringExtra);
            } else {
                try {
                    Long.parseLong(stringExtra);
                    bundle.putString("nsid", stringExtra);
                } catch (NumberFormatException e) {
                    Log.d("GcmAnalytics", "Unrecognised from address: " + stringExtra);
                }
            }
        }
        try {
            (f2091a == null ? C1100a.m4057a(context) : f2091a).m4058a("gcm", str, bundle);
        } catch (NoClassDefFoundError e2) {
            Log.e("GcmAnalytics", "Unable to log event, missing GMS measurement library");
        }
    }

    public static void m3789b(Context context, Intent intent) {
        C1047d.m3788a(context, "_no", intent);
    }

    public static void m3790c(Context context, Intent intent) {
        C1047d.m3788a(context, "_nd", intent);
    }

    public static void m3791d(Context context, Intent intent) {
        C1047d.m3788a(context, "_nf", intent);
    }
}
