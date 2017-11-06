package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.measurement.internal.C1126f;
import com.google.android.gms.measurement.internal.C1146t;
import com.google.android.gms.measurement.internal.C1164y;

public final class AppMeasurementReceiver extends BroadcastReceiver {
    static final Object f2237a = new Object();
    static WakeLock f2238b;
    static Boolean f2239c;

    public static boolean m4051a(Context context) {
        C1032p.m3678a((Object) context);
        if (f2239c != null) {
            return f2239c.booleanValue();
        }
        boolean a = C1126f.m4212a(context, AppMeasurementReceiver.class, false);
        f2239c = Boolean.valueOf(a);
        return a;
    }

    public void onReceive(Context context, Intent intent) {
        C1164y a = C1164y.m4496a(context);
        C1146t f = a.m4518f();
        String action = intent.getAction();
        if (a.m4516d().m4246C()) {
            f.m4417t().m4388a("Device AppMeasurementReceiver got", action);
        } else {
            f.m4417t().m4388a("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean a2 = AppMeasurementService.m4054a(context);
            Intent intent2 = new Intent(context, AppMeasurementService.class);
            intent2.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (f2237a) {
                context.startService(intent2);
                if (a2) {
                    try {
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (f2238b == null) {
                            f2238b = powerManager.newWakeLock(1, "AppMeasurement WakeLock");
                            f2238b.setReferenceCounted(false);
                        }
                        f2238b.acquire(1000);
                    } catch (SecurityException e) {
                        f.m4412o().m4387a("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                    return;
                }
            }
        }
    }
}
