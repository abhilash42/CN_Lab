package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1075e;
import com.google.android.gms.internal.C1086j.C1082b;
import com.google.android.gms.internal.C1086j.C1083c;
import com.google.android.gms.internal.C1086j.C1085e;
import com.google.android.gms.internal.zztd;
import io.fabric.sdk.android.services.p018c.C0670b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class C1126f extends aa {
    C1126f(C1164y c1164y) {
        super(c1164y);
    }

    private Object m4209a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Float)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Double) {
            return Float.valueOf((float) ((Double) obj).doubleValue());
        } else {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return null;
            }
            String valueOf = String.valueOf(obj);
            return valueOf.length() > i ? z ? valueOf.substring(0, i) : null : valueOf;
        }
    }

    private void m4210a(String str, String str2, int i, Object obj) {
        if (obj == null) {
            mo743l().m4414q().m4388a(str + " value can't be null. Ignoring " + str, str2);
        } else if (!(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                String valueOf = String.valueOf(obj);
                if (valueOf.length() > i) {
                    mo743l().m4414q().m4389a("Ignoring " + str + ". Value is too long. name, value length", str2, Integer.valueOf(valueOf.length()));
                }
            }
        }
    }

    public static boolean m4211a(Context context, Class<? extends Service> cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean m4212a(Context context, Class<? extends BroadcastReceiver> cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    private int m4213e(String str) {
        return "_ldl".equals(str) ? mo745n().m4279s() : mo745n().m4278r();
    }

    public Object m4214a(String str, Object obj) {
        int p = (TextUtils.isEmpty(str) || !str.startsWith(C0670b.ROLL_OVER_FILE_NAME_SEPARATOR)) ? mo745n().m4276p() : mo745n().m4277q();
        return m4209a(p, obj, false);
    }

    public void m4215a(Bundle bundle, String str, Object obj) {
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (str != null) {
            mo743l().m4414q().m4389a("Not putting event parameter. Invalid value type. name, type", str, obj.getClass().getSimpleName());
        }
    }

    public void m4216a(C1082b c1082b, Object obj) {
        C1032p.m3678a(obj);
        c1082b.f2156b = null;
        c1082b.f2157c = null;
        c1082b.f2158d = null;
        if (obj instanceof String) {
            c1082b.f2156b = (String) obj;
        } else if (obj instanceof Long) {
            c1082b.f2157c = (Long) obj;
        } else if (obj instanceof Float) {
            c1082b.f2158d = (Float) obj;
        } else {
            mo743l().m4399b().m4388a("Ignoring invalid (type) event param value", obj);
        }
    }

    public void m4217a(C1085e c1085e, Object obj) {
        C1032p.m3678a(obj);
        c1085e.f2190c = null;
        c1085e.f2191d = null;
        c1085e.f2192e = null;
        if (obj instanceof String) {
            c1085e.f2190c = (String) obj;
        } else if (obj instanceof Long) {
            c1085e.f2191d = (Long) obj;
        } else if (obj instanceof Float) {
            c1085e.f2192e = (Float) obj;
        } else {
            mo743l().m4399b().m4388a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public void m4218a(String str) {
        m4219a("event", mo745n().m4262b(), str);
    }

    void m4219a(String str, int i, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException(str + " name is required and can't be null");
        } else if (str2.length() == 0) {
            throw new IllegalArgumentException(str + " name is required and can't be empty");
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i2 = 1;
                while (i2 < str2.length()) {
                    char charAt2 = str2.charAt(i2);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException(str + " name must consist of letters, digits or _ (underscores)");
                    }
                }
                if (str2.length() > i) {
                    throw new IllegalArgumentException(str + " name is too long. The maximum supported length is " + i);
                }
                return;
            }
            throw new IllegalArgumentException(str + " name must start with a letter or _");
        }
    }

    public boolean m4220a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(mo739h().mo728a() - j) > j2;
    }

    public byte[] m4221a(C1083c c1083c) {
        try {
            byte[] bArr = new byte[c1083c.m3932e()];
            zztd a = zztd.m4005a(bArr);
            c1083c.mo730a(a);
            a.m4038b();
            return bArr;
        } catch (IOException e) {
            mo743l().m4399b().m4388a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] m4222a(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            mo743l().m4399b().m4388a("Failed to gzip content", e);
            throw e;
        }
    }

    public void m4223b(String str) {
        m4219a("user attribute", mo745n().m4275o(), str);
    }

    public void m4224b(String str, Object obj) {
        if ("_ldl".equals(str)) {
            m4210a("user attribute referrer", str, m4213e(str), obj);
        } else {
            m4210a("user attribute", str, m4213e(str), obj);
        }
    }

    public byte[] m4225b(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            mo743l().m4399b().m4388a("Failed to ungzip content", e);
            throw e;
        }
    }

    public Object m4226c(String str, Object obj) {
        return "_ldl".equals(str) ? m4209a(m4213e(str), obj, true) : m4209a(m4213e(str), obj, false);
    }

    public /* bridge */ /* synthetic */ void mo734c() {
        super.mo734c();
    }

    public void m4228c(String str) {
        m4219a("event param", mo745n().m4275o(), str);
    }

    public /* bridge */ /* synthetic */ void mo735d() {
        super.mo735d();
    }

    public boolean m4230d(String str) {
        mo736e();
        return mo740i().checkCallingOrSelfPermission(str) == 0;
    }

    public /* bridge */ /* synthetic */ void mo736e() {
        super.mo736e();
    }

    public /* bridge */ /* synthetic */ C1142r mo737f() {
        return super.mo737f();
    }

    public /* bridge */ /* synthetic */ ae mo738g() {
        return super.mo738g();
    }

    public /* bridge */ /* synthetic */ C1075e mo739h() {
        return super.mo739h();
    }

    public /* bridge */ /* synthetic */ Context mo740i() {
        return super.mo740i();
    }

    public /* bridge */ /* synthetic */ C1126f mo741j() {
        return super.mo741j();
    }

    public /* bridge */ /* synthetic */ C1161x mo742k() {
        return super.mo742k();
    }

    public /* bridge */ /* synthetic */ C1146t mo743l() {
        return super.mo743l();
    }

    public /* bridge */ /* synthetic */ C1157w mo744m() {
        return super.mo744m();
    }

    public /* bridge */ /* synthetic */ C1128h mo745n() {
        return super.mo745n();
    }
}
