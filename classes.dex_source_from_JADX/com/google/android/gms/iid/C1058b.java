package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.p004a.C0042k;
import android.util.Log;
import com.google.android.gms.gcm.C1046c;
import java.io.IOException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class C1058b extends Service {
    static String f2110a = CLConstants.OUTPUT_KEY_ACTION;
    private static String f2111f = "google.com/iid";
    private static String f2112g = "CMD";
    private static String f2113h = "gcm.googleapis.com/refresh";
    MessengerCompat f2114b = new MessengerCompat(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ C1058b f2108a;

        public void handleMessage(Message message) {
            this.f2108a.m3832a(message, MessengerCompat.m3814a(message));
        }
    });
    BroadcastReceiver f2115c = new C10572(this);
    int f2116d;
    int f2117e;

    class C10572 extends BroadcastReceiver {
        final /* synthetic */ C1058b f2109a;

        C10572(C1058b c1058b) {
            this.f2109a = c1058b;
        }

        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + intent.getExtras());
            }
            this.f2109a.m3836a(intent);
            this.f2109a.m3834a();
        }
    }

    static void m3830a(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(f2112g, "SYNC");
        context.startService(intent);
    }

    static void m3831a(Context context, C1063f c1063f) {
        c1063f.m3867b();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(f2112g, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    private void m3832a(Message message, int i) {
        C1062e.m3841a((Context) this);
        getPackageManager();
        if (i == C1062e.f2122c || i == C1062e.f2121b) {
            m3836a((Intent) message.obj);
        } else {
            Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + C1062e.f2121b + " appid=" + C1062e.f2122c);
        }
    }

    void m3834a() {
        synchronized (this) {
            this.f2116d--;
            if (this.f2116d == 0) {
                stopSelf(this.f2117e);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.f2116d + " " + this.f2117e);
            }
        }
    }

    void m3835a(int i) {
        synchronized (this) {
            this.f2116d++;
            if (i > this.f2117e) {
                this.f2117e = i;
            }
        }
    }

    public void m3836a(Intent intent) {
        C1055a b;
        String stringExtra = intent.getStringExtra(CLConstants.FIELD_SUBTYPE);
        if (stringExtra == null) {
            b = C1055a.m3822b(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(CLConstants.FIELD_SUBTYPE, stringExtra);
            b = C1055a.m3819a(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(f2112g);
        if (intent.getStringExtra(CLConstants.OUTPUT_KEY_ERROR) == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                C1063f c = b.m3827c();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                c.m3871e(stringExtra);
                b.m3828d().m3857d(intent);
                return;
            } else if (f2113h.equals(intent.getStringExtra("from"))) {
                b.m3827c().m3871e(stringExtra);
                m3837a(false);
                return;
            } else if ("RST".equals(stringExtra2)) {
                b.m3826b();
                m3837a(true);
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!b.m3827c().m3866a()) {
                    b.m3827c().m3867b();
                    m3837a(true);
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                b.m3827c().m3871e(stringExtra);
                m3837a(false);
                return;
            } else if ("PING".equals(stringExtra2)) {
                try {
                    C1046c.m3777a((Context) this).m3786a(f2111f, C1062e.m3848b(), 0, intent.getExtras());
                    return;
                } catch (IOException e) {
                    Log.w("InstanceID", "Failed to send ping response");
                    return;
                }
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Register result in service " + stringExtra);
        }
        b.m3828d().m3857d(intent);
    }

    public void m3837a(boolean z) {
        mo802b();
    }

    public void mo802b() {
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.f2114b.m3816a();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.f2115c, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.f2115c);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m3835a(i2);
        if (intent == null) {
            m3834a();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                m3836a(intent);
            }
            m3834a();
            if (intent.getStringExtra("from") != null) {
                C0042k.m115a(intent);
            }
            return 2;
        } finally {
            m3834a();
        }
    }
}
