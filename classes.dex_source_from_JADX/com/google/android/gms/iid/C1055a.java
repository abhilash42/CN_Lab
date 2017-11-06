package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class C1055a {
    static Map<String, C1055a> f2100a = new HashMap();
    static String f2101f;
    private static C1063f f2102g;
    private static C1062e f2103h;
    Context f2104b;
    KeyPair f2105c;
    String f2106d = "";
    long f2107e;

    protected C1055a(Context context, String str, Bundle bundle) {
        this.f2104b = context.getApplicationContext();
        this.f2106d = str;
    }

    static int m3818a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return i;
        }
    }

    public static synchronized C1055a m3819a(Context context, Bundle bundle) {
        C1055a c1055a;
        synchronized (C1055a.class) {
            String string = bundle == null ? "" : bundle.getString(CLConstants.FIELD_SUBTYPE);
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (f2102g == null) {
                f2102g = new C1063f(applicationContext);
                f2103h = new C1062e(applicationContext);
            }
            f2101f = Integer.toString(C1055a.m3818a(applicationContext));
            c1055a = (C1055a) f2100a.get(str);
            if (c1055a == null) {
                c1055a = new C1055a(applicationContext, str, bundle);
                f2100a.put(str, c1055a);
            }
        }
        return c1055a;
    }

    static String m3820a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String m3821a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static C1055a m3822b(Context context) {
        return C1055a.m3819a(context, null);
    }

    public String m3823a(String str, String str2, Bundle bundle) {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        Object obj2 = 1;
        String a = m3829e() ? null : f2102g.m3862a(this.f2106d, str, str2);
        if (a == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(bundle.getString(CLConstants.FIELD_TYPE))) {
                obj = obj2;
            }
            a = m3825b(str, str2, bundle);
            Log.w("InstanceID", "token: " + a);
            if (!(a == null || r1 == null)) {
                f2102g.m3865a(this.f2106d, str, str2, a, f2101f);
            }
        }
        return a;
    }

    KeyPair m3824a() {
        if (this.f2105c == null) {
            this.f2105c = f2102g.m3869c(this.f2106d);
        }
        if (this.f2105c == null) {
            this.f2107e = System.currentTimeMillis();
            this.f2105c = f2102g.m3863a(this.f2106d, this.f2107e);
        }
        return this.f2105c;
    }

    public String m3825b(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.f2106d) ? str : this.f2106d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString(CLConstants.FIELD_SUBTYPE, str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return f2103h.m3855b(f2103h.m3849a(bundle, m3824a()));
    }

    void m3826b() {
        this.f2107e = 0;
        f2102g.m3870d(this.f2106d);
        this.f2105c = null;
    }

    C1063f m3827c() {
        return f2102g;
    }

    C1062e m3828d() {
        return f2103h;
    }

    boolean m3829e() {
        String a = f2102g.m3860a("appVersion");
        if (a == null || !a.equals(f2101f)) {
            return true;
        }
        a = f2102g.m3860a("lastToken");
        if (a == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(a)).longValue() > 604800;
    }
}
