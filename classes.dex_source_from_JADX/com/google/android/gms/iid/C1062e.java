package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.C1046c;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class C1062e {
    static String f2120a = null;
    static int f2121b = 0;
    static int f2122c = 0;
    static int f2123d = 0;
    Context f2124e;
    Map<String, Object> f2125f = new HashMap();
    Messenger f2126g;
    Messenger f2127h;
    MessengerCompat f2128i;
    PendingIntent f2129j;
    long f2130k;
    long f2131l;
    int f2132m;
    int f2133n;
    long f2134o;

    public C1062e(Context context) {
        this.f2124e = context;
    }

    public static String m3841a(Context context) {
        if (f2120a != null) {
            return f2120a;
        }
        f2121b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    f2122c = applicationInfo.uid;
                    f2120a = resolveInfo.serviceInfo.packageName;
                    return f2120a;
                } catch (NameNotFoundException e) {
                }
            } else {
                Log.w("InstanceID/Rpc", "Possible malicious package " + resolveInfo.serviceInfo.packageName + " declares " + "com.google.android.c2dm.intent.REGISTER" + " without permission");
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        ApplicationInfo applicationInfo2;
        try {
            applicationInfo2 = packageManager.getApplicationInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 0);
            f2120a = applicationInfo2.packageName;
            f2122c = applicationInfo2.uid;
            return f2120a;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                f2120a = applicationInfo2.packageName;
                f2122c = applicationInfo2.uid;
                return f2120a;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    static String m3842a(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = C1055a.m3821a(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void m3843a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f2125f.keySet()) {
                Object obj2 = this.f2125f.get(str);
                this.f2125f.put(str, obj);
                m3844a(obj2, obj);
            }
        }
    }

    private void m3844a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                Log.w("InstanceID/Rpc", "Failed to send response " + e);
            }
        }
    }

    private void m3845a(String str) {
        if ("com.google.android.gsf".equals(f2120a)) {
            this.f2132m++;
            if (this.f2132m >= 3) {
                if (this.f2132m == 3) {
                    this.f2133n = new Random().nextInt(1000) + 1000;
                }
                this.f2133n *= 2;
                this.f2134o = SystemClock.elapsedRealtime() + ((long) this.f2133n);
                Log.w("InstanceID/Rpc", "Backoff due to " + str + " for " + this.f2133n);
            }
        }
    }

    private void m3846a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f2125f.get(str);
            this.f2125f.put(str, obj);
            m3844a(obj2, obj);
        }
    }

    private Intent m3847b(Bundle bundle, KeyPair keyPair) {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String b = C1062e.m3848b();
        synchronized (getClass()) {
            this.f2125f.put(b, conditionVariable);
        }
        m3853a(bundle, keyPair, b);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.f2125f.remove(b);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                Log.w("InstanceID/Rpc", "No response " + remove);
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    public static synchronized String m3848b() {
        String num;
        synchronized (C1062e.class) {
            int i = f2123d;
            f2123d = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    Intent m3849a(Bundle bundle, KeyPair keyPair) {
        Intent b = m3847b(bundle, keyPair);
        return (b == null || !b.hasExtra("google.messenger")) ? b : m3847b(bundle, keyPair);
    }

    void m3850a() {
        if (this.f2126g == null) {
            C1062e.m3841a(this.f2124e);
            this.f2126g = new Messenger(new Handler(this, Looper.getMainLooper()) {
                final /* synthetic */ C1062e f2119a;

                public void handleMessage(Message message) {
                    this.f2119a.m3854a(message);
                }
            });
        }
    }

    synchronized void m3851a(Intent intent) {
        if (this.f2129j == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.f2129j = PendingIntent.getBroadcast(this.f2124e, 0, intent2, 0);
        }
        intent.putExtra("app", this.f2129j);
    }

    protected void m3852a(Intent intent, String str) {
        this.f2130k = SystemClock.elapsedRealtime();
        intent.putExtra("kid", "|ID|" + str + CLConstants.SALT_DELIMETER);
        intent.putExtra("X-kid", "|ID|" + str + CLConstants.SALT_DELIMETER);
        boolean equals = "com.google.android.gsf".equals(f2120a);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            equals = "1".equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Sending " + intent.getExtras());
        }
        if (this.f2127h != null) {
            intent.putExtra("google.messenger", this.f2126g);
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                this.f2127h.send(obtain);
                return;
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (equals) {
            Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
            intent2.setPackage(this.f2124e.getPackageName());
            intent2.putExtra("GSF", intent);
            this.f2124e.startService(intent2);
            return;
        }
        intent.putExtra("google.messenger", this.f2126g);
        intent.putExtra("messenger2", "1");
        if (this.f2128i != null) {
            Message obtain2 = Message.obtain();
            obtain2.obj = intent;
            try {
                this.f2128i.m3817b(obtain2);
                return;
            } catch (RemoteException e2) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.f2124e.startService(intent);
    }

    void m3853a(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f2134o == 0 || elapsedRealtime > this.f2134o) {
            m3850a();
            if (f2120a == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.f2130k = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(f2120a);
            bundle.putString("gmsv", Integer.toString(C1046c.m3784c(this.f2124e)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(C1055a.m3818a(this.f2124e)));
            bundle.putString("cliv", "1");
            bundle.putString("appid", C1055a.m3820a(keyPair));
            bundle.putString("pub2", C1055a.m3821a(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", C1062e.m3842a(keyPair, this.f2124e.getPackageName(), r1));
            intent.putExtras(bundle);
            m3851a(intent);
            m3852a(intent, str);
            return;
        }
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.f2134o - elapsedRealtime) + " interval: " + this.f2133n);
        throw new IOException("RETRY_LATER");
    }

    public void m3854a(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.f2128i = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f2127h = (Messenger) parcelableExtra;
                    }
                }
                m3857d((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    String m3855b(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        if (stringExtra != null) {
            if (stringExtra == null) {
                return stringExtra;
            }
            stringExtra = intent.getStringExtra(CLConstants.OUTPUT_KEY_ERROR);
            if (stringExtra == null) {
                throw new IOException(stringExtra);
            }
            Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } else if (stringExtra == null) {
            return stringExtra;
        } else {
            stringExtra = intent.getStringExtra(CLConstants.OUTPUT_KEY_ERROR);
            if (stringExtra == null) {
                Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
            throw new IOException(stringExtra);
        }
    }

    void m3856c(Intent intent) {
        String stringExtra = intent.getStringExtra(CLConstants.OUTPUT_KEY_ERROR);
        if (stringExtra == null) {
            Log.w("InstanceID/Rpc", "Unexpected response, no error or registration id " + intent.getExtras());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Received InstanceID error " + stringExtra);
        }
        String str = null;
        if (stringExtra.startsWith(CLConstants.SALT_DELIMETER)) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
            }
            if (split.length > 2) {
                str = split[2];
                stringExtra = split[3];
                if (stringExtra.startsWith(":")) {
                    stringExtra = stringExtra.substring(1);
                }
            } else {
                stringExtra = "UNKNOWN";
            }
            intent.putExtra(CLConstants.OUTPUT_KEY_ERROR, stringExtra);
        }
        if (str == null) {
            m3843a((Object) stringExtra);
        } else {
            m3846a(str, (Object) stringExtra);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.f2131l = SystemClock.elapsedRealtime();
            this.f2133n = ((int) longExtra) * 1000;
            this.f2134o = SystemClock.elapsedRealtime() + ((long) this.f2133n);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.f2133n);
        } else if ("SERVICE_NOT_AVAILABLE".equals(stringExtra) || "AUTHENTICATION_FAILED".equals(stringExtra)) {
            m3845a(stringExtra);
        }
    }

    void m3857d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
                action = intent.getStringExtra("registration_id");
                String stringExtra = action == null ? intent.getStringExtra("unregistered") : action;
                if (stringExtra == null) {
                    m3856c(intent);
                    return;
                }
                this.f2130k = SystemClock.elapsedRealtime();
                this.f2134o = 0;
                this.f2132m = 0;
                this.f2133n = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "AppIDResponse: " + stringExtra + " " + intent.getExtras());
                }
                action = null;
                if (stringExtra.startsWith(CLConstants.SALT_DELIMETER)) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
                    }
                    stringExtra = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            C1058b.m3830a(this.f2124e);
                        } else if ("RST".equals(split[3])) {
                            C1058b.m3831a(this.f2124e, C1055a.m3822b(this.f2124e).m3827c());
                            intent.removeExtra("registration_id");
                            m3846a(stringExtra, (Object) intent);
                            return;
                        }
                    }
                    action = split[split.length - 1];
                    if (action.startsWith(":")) {
                        action = action.substring(1);
                    }
                    intent.putExtra("registration_id", action);
                    action = stringExtra;
                }
                if (action == null) {
                    m3843a((Object) intent);
                } else {
                    m3846a(action, (Object) intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response " + intent.getAction());
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }
}
