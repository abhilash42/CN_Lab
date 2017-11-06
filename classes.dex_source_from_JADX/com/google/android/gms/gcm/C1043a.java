package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.p004a.C0042k;
import android.text.TextUtils;
import android.util.Log;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public abstract class C1043a extends Service {
    private static boolean f2073d = false;
    private final Object f2074a = new Object();
    private int f2075b;
    private int f2076c = 0;

    static boolean m3762a(Intent intent) {
        return f2073d && !TextUtils.isEmpty(intent.getStringExtra("gcm.a.campaign"));
    }

    static boolean m3763a(Bundle bundle) {
        return f2073d && !TextUtils.isEmpty(bundle.getString("gcm.a.campaign"));
    }

    private void m3764b() {
        synchronized (this.f2074a) {
            this.f2076c--;
            if (this.f2076c == 0) {
                m3774a(this.f2075b);
            }
        }
    }

    private void m3765b(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("com.google.android.gms.gcm.PENDING_INTENT");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException e) {
                Log.e("GcmListenerService", "Notification pending intent canceled");
            }
        }
        C1047d.m3789b(this, intent);
    }

    private void m3766c(final Intent intent) {
        if (VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(this) {
                final /* synthetic */ C1043a f2070b;

                public void run() {
                    this.f2070b.m3767d(intent);
                }
            });
        } else {
            new AsyncTask<Void, Void, Void>(this) {
                final /* synthetic */ C1043a f2072b;

                protected Void m3760a(Void... voidArr) {
                    this.f2072b.m3767d(intent);
                    return null;
                }

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m3760a((Void[]) objArr);
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3767d(android.content.Intent r4) {
        /*
        r3 = this;
        r1 = r4.getAction();	 Catch:{ all -> 0x004a }
        r0 = -1;
        r2 = r1.hashCode();	 Catch:{ all -> 0x004a }
        switch(r2) {
            case 214175003: goto L_0x003c;
            case 366519424: goto L_0x0032;
            default: goto L_0x000c;
        };	 Catch:{ all -> 0x004a }
    L_0x000c:
        switch(r0) {
            case 0: goto L_0x0046;
            case 1: goto L_0x004f;
            default: goto L_0x000f;
        };	 Catch:{ all -> 0x004a }
    L_0x000f:
        r0 = "GcmListenerService";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004a }
        r1.<init>();	 Catch:{ all -> 0x004a }
        r2 = "Unknown intent action: ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x004a }
        r2 = r4.getAction();	 Catch:{ all -> 0x004a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x004a }
        r1 = r1.toString();	 Catch:{ all -> 0x004a }
        android.util.Log.d(r0, r1);	 Catch:{ all -> 0x004a }
    L_0x002b:
        r3.m3764b();	 Catch:{ all -> 0x004a }
        android.support.v4.p004a.C0042k.m115a(r4);
        return;
    L_0x0032:
        r2 = "com.google.android.c2dm.intent.RECEIVE";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x000c;
    L_0x003a:
        r0 = 0;
        goto L_0x000c;
    L_0x003c:
        r2 = "com.google.android.gms.gcm.NOTIFICATION_DISMISS";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x000c;
    L_0x0044:
        r0 = 1;
        goto L_0x000c;
    L_0x0046:
        r3.m3768e(r4);	 Catch:{ all -> 0x004a }
        goto L_0x002b;
    L_0x004a:
        r0 = move-exception;
        android.support.v4.p004a.C0042k.m115a(r4);
        throw r0;
    L_0x004f:
        com.google.android.gms.gcm.C1047d.m3790c(r3, r4);	 Catch:{ all -> 0x004a }
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.a.d(android.content.Intent):void");
    }

    private void m3768e(Intent intent) {
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        Object obj = -1;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals("deleted_messages")) {
                    obj = 1;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals("gcm")) {
                    obj = null;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals("send_error")) {
                    obj = 3;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals("send_event")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (C1043a.m3762a(intent)) {
                    C1047d.m3787a(this, intent);
                }
                m3769f(intent);
                return;
            case 1:
                m3770a();
                return;
            case 2:
                m3771a(intent.getStringExtra("google.message_id"));
                return;
            case 3:
                m3773a(intent.getStringExtra("google.message_id"), intent.getStringExtra(CLConstants.OUTPUT_KEY_ERROR));
                return;
            default:
                Log.w("GcmListenerService", "Received message with unknown type: " + stringExtra);
                return;
        }
    }

    private void m3769f(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.remove("message_type");
        extras.remove("android.support.content.wakelockid");
        if (C1050e.m3800a(extras)) {
            if (C1050e.m3799a((Context) this)) {
                C1050e.m3803b(extras);
                if (C1043a.m3762a(intent)) {
                    C1047d.m3791d(this, intent);
                }
            } else {
                C1050e.m3794a((Context) this, getClass()).m3808c(extras);
                return;
            }
        }
        String string = extras.getString("from");
        extras.remove("from");
        mo803a(string, extras);
    }

    public void m3770a() {
    }

    public void m3771a(String str) {
    }

    public void mo803a(String str, Bundle bundle) {
    }

    public void m3773a(String str, String str2) {
    }

    boolean m3774a(int i) {
        return stopSelfResult(i);
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f2074a) {
            this.f2075b = i2;
            this.f2076c++;
        }
        if ("com.google.android.gms.gcm.NOTIFICATION_OPEN".equals(intent.getAction())) {
            m3765b(intent);
            m3764b();
            C0042k.m115a(intent);
        } else {
            m3766c(intent);
        }
        return 3;
    }
}
