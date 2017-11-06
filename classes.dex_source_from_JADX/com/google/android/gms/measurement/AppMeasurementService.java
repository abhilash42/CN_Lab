package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.measurement.internal.C1126f;
import com.google.android.gms.measurement.internal.C1146t;
import com.google.android.gms.measurement.internal.C1164y;
import com.google.android.gms.measurement.internal.C1171z;

public final class AppMeasurementService extends Service {
    private static Boolean f2245b;
    private final Handler f2246a = new Handler();

    private void m4053a() {
        try {
            synchronized (AppMeasurementReceiver.f2237a) {
                WakeLock wakeLock = AppMeasurementReceiver.f2238b;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean m4054a(Context context) {
        C1032p.m3678a((Object) context);
        if (f2245b != null) {
            return f2245b.booleanValue();
        }
        boolean a = C1126f.m4211a(context, AppMeasurementService.class);
        f2245b = Boolean.valueOf(a);
        return a;
    }

    private C1146t m4055b() {
        return C1164y.m4496a((Context) this).m4518f();
    }

    public IBinder onBind(Intent intent) {
        if (intent == null) {
            m4055b().m4399b().m4387a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new C1171z(C1164y.m4496a((Context) this));
        }
        m4055b().m4412o().m4388a("onBind received unknown action", action);
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C1164y a = C1164y.m4496a((Context) this);
        C1146t f = a.m4518f();
        if (a.m4516d().m4246C()) {
            f.m4417t().m4387a("Device AppMeasurementService is starting up");
        } else {
            f.m4417t().m4387a("Local AppMeasurementService is starting up");
        }
    }

    public void onDestroy() {
        C1164y a = C1164y.m4496a((Context) this);
        C1146t f = a.m4518f();
        if (a.m4516d().m4246C()) {
            f.m4417t().m4387a("Device AppMeasurementService is shutting down");
        } else {
            f.m4417t().m4387a("Local AppMeasurementService is shutting down");
        }
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        if (intent == null) {
            m4055b().m4399b().m4387a("onRebind called with null intent");
            return;
        }
        m4055b().m4417t().m4388a("onRebind called. action", intent.getAction());
    }

    public int onStartCommand(Intent intent, int i, final int i2) {
        m4053a();
        final C1164y a = C1164y.m4496a((Context) this);
        final C1146t f = a.m4518f();
        String action = intent.getAction();
        if (a.m4516d().m4246C()) {
            f.m4417t().m4389a("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        } else {
            f.m4417t().m4389a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            a.m4519g().m4478a(new Runnable(this) {
                final /* synthetic */ AppMeasurementService f2244d;

                class C10971 implements Runnable {
                    final /* synthetic */ C10981 f2240a;

                    C10971(C10981 c10981) {
                        this.f2240a = c10981;
                    }

                    public void run() {
                        if (!this.f2240a.f2244d.stopSelfResult(i2)) {
                            return;
                        }
                        if (a.m4516d().m4246C()) {
                            f.m4417t().m4387a("Device AppMeasurementService processed last upload request");
                        } else {
                            f.m4417t().m4387a("Local AppMeasurementService processed last upload request");
                        }
                    }
                }

                public void run() {
                    a.m4536x();
                    this.f2244d.f2246a.post(new C10971(this));
                }
            });
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            m4055b().m4399b().m4387a("onUnbind called with null intent");
        } else {
            m4055b().m4417t().m4388a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
