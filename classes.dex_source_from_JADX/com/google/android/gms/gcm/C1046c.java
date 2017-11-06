package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.iid.C1055a;
import com.google.android.gms.iid.C1062e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class C1046c {
    public static int f2081a = 5000000;
    public static int f2082b = 6500000;
    public static int f2083c = 7000000;
    static C1046c f2084d;
    private static final AtomicInteger f2085i = new AtomicInteger(1);
    final Messenger f2086e = new Messenger(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ C1046c f2080a;

        public void handleMessage(Message message) {
            if (message == null || !(message.obj instanceof Intent)) {
                Log.w("GCM", "Dropping invalid message");
            }
            Intent intent = (Intent) message.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                this.f2080a.f2090j.add(intent);
            } else if (!this.f2080a.m3783b(intent)) {
                intent.setPackage(this.f2080a.f2087f.getPackageName());
                this.f2080a.f2087f.sendBroadcast(intent);
            }
        }
    });
    private Context f2087f;
    private PendingIntent f2088g;
    private Map<String, Handler> f2089h = Collections.synchronizedMap(new HashMap());
    private final BlockingQueue<Intent> f2090j = new LinkedBlockingQueue();

    public static synchronized C1046c m3777a(Context context) {
        C1046c c1046c;
        synchronized (C1046c.class) {
            if (f2084d == null) {
                f2084d = new C1046c();
                f2084d.f2087f = context.getApplicationContext();
            }
            c1046c = f2084d;
        }
        return c1046c;
    }

    private void m3779a(String str, String str2, long j, int i, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        m3785a(intent);
        intent.setPackage(C1046c.m3782b(this.f2087f));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        intent.putExtra("google.delay", Integer.toString(i));
        if (C1046c.m3782b(this.f2087f).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    bundle2.putString("gcm." + str3, (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            C1055a.m3822b(this.f2087f).m3825b("GCM", "upstream", bundle2);
            return;
        }
        this.f2087f.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public static String m3782b(Context context) {
        return C1062e.m3841a(context);
    }

    private boolean m3783b(Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra(CLConstants.OUTPUT_KEY_ERROR)) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) this.f2089h.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    public static int m3784c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(C1046c.m3782b(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    synchronized void m3785a(Intent intent) {
        if (this.f2088g == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f2088g = PendingIntent.getBroadcast(this.f2087f, 0, intent2, 0);
        }
        intent.putExtra("app", this.f2088g);
    }

    public void m3786a(String str, String str2, long j, Bundle bundle) {
        m3779a(str, str2, j, -1, bundle);
    }
}
