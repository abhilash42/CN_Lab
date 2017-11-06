package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.p004a.C0023a;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class C1063f {
    SharedPreferences f2135a;
    Context f2136b;

    public C1063f(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public C1063f(Context context, String str) {
        this.f2136b = context;
        this.f2135a = context.getSharedPreferences(str, 4);
        m3859g(str + "-no-backup");
    }

    private String m3858b(String str, String str2, String str3) {
        return str + "|T|" + str2 + CLConstants.SALT_DELIMETER + str3;
    }

    private void m3859g(String str) {
        File file = new File(new C0023a().m82a(this.f2136b), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !m3866a()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    C1058b.m3831a(this.f2136b, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    Log.d("InstanceID/Store", "Error creating file in no backup dir: " + e.getMessage());
                }
            }
        }
    }

    synchronized String m3860a(String str) {
        return this.f2135a.getString(str, null);
    }

    synchronized String m3861a(String str, String str2) {
        return this.f2135a.getString(str + "|S|" + str2, null);
    }

    public synchronized String m3862a(String str, String str2, String str3) {
        return this.f2135a.getString(m3858b(str, str2, str3), null);
    }

    synchronized KeyPair m3863a(String str, long j) {
        KeyPair a;
        a = C1059c.m3839a();
        Editor edit = this.f2135a.edit();
        m3864a(edit, str, "|P|", C1055a.m3821a(a.getPublic().getEncoded()));
        m3864a(edit, str, "|K|", C1055a.m3821a(a.getPrivate().getEncoded()));
        m3864a(edit, str, "cre", Long.toString(j));
        edit.commit();
        return a;
    }

    synchronized void m3864a(Editor editor, String str, String str2, String str3) {
        editor.putString(str + "|S|" + str2, str3);
    }

    public synchronized void m3865a(String str, String str2, String str3, String str4, String str5) {
        String b = m3858b(str, str2, str3);
        Editor edit = this.f2135a.edit();
        edit.putString(b, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    boolean m3866a() {
        return this.f2135a.getAll().isEmpty();
    }

    public synchronized void m3867b() {
        this.f2135a.edit().clear().commit();
    }

    public synchronized void m3868b(String str) {
        Editor edit = this.f2135a.edit();
        for (String str2 : this.f2135a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public KeyPair m3869c(String str) {
        return m3872f(str);
    }

    void m3870d(String str) {
        m3868b(str + CLConstants.SALT_DELIMETER);
    }

    public void m3871e(String str) {
        m3868b(str + "|T|");
    }

    KeyPair m3872f(String str) {
        Object e;
        String a = m3861a(str, "|P|");
        String a2 = m3861a(str, "|K|");
        if (a2 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(a, 8);
            byte[] decode2 = Base64.decode(a2, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (InvalidKeySpecException e2) {
            e = e2;
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            C1058b.m3831a(this.f2136b, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            C1058b.m3831a(this.f2136b, this);
            return null;
        }
    }
}
