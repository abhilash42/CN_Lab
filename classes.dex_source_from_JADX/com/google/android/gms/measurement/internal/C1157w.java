package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.C1032p;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.UUID;

class C1157w extends ab {
    static final Pair<String, Long> f2445a = new Pair("", Long.valueOf(0));
    public final C1156b f2446b = new C1156b("health_monitor", mo745n().m4251H());
    public final C1155a f2447c = new C1155a(this, "last_upload", 0);
    public final C1155a f2448d = new C1155a(this, "last_upload_attempt", 0);
    public final C1155a f2449e = new C1155a(this, "backoff", 0);
    public final C1155a f2450f = new C1155a(this, "last_delete_stale", 0);
    private SharedPreferences f2451h;
    private String f2452i;
    private boolean f2453j;
    private long f2454k;
    private final SecureRandom f2455l = new SecureRandom();

    public final class C1155a {
        final /* synthetic */ C1157w f2435a;
        private final String f2436b;
        private final long f2437c;
        private boolean f2438d;
        private long f2439e;

        public C1155a(C1157w c1157w, String str, long j) {
            this.f2435a = c1157w;
            C1032p.m3680a(str);
            this.f2436b = str;
            this.f2437c = j;
        }

        private void m4444b() {
            if (!this.f2438d) {
                this.f2438d = true;
                this.f2439e = this.f2435a.f2451h.getLong(this.f2436b, this.f2437c);
            }
        }

        public long m4445a() {
            m4444b();
            return this.f2439e;
        }

        public void m4446a(long j) {
            Editor edit = this.f2435a.f2451h.edit();
            edit.putLong(this.f2436b, j);
            edit.apply();
            this.f2439e = j;
        }
    }

    public final class C1156b {
        final String f2440a;
        final /* synthetic */ C1157w f2441b;
        private final String f2442c;
        private final String f2443d;
        private final long f2444e;

        private C1156b(C1157w c1157w, String str, long j) {
            this.f2441b = c1157w;
            C1032p.m3680a(str);
            C1032p.m3685b(j > 0);
            this.f2440a = str + ":start";
            this.f2442c = str + ":count";
            this.f2443d = str + ":value";
            this.f2444e = j;
        }

        private void m4447b() {
            this.f2441b.mo736e();
            long a = this.f2441b.mo739h().mo728a();
            Editor edit = this.f2441b.f2451h.edit();
            edit.remove(this.f2442c);
            edit.remove(this.f2443d);
            edit.putLong(this.f2440a, a);
            edit.apply();
        }

        private long m4448c() {
            this.f2441b.mo736e();
            long d = m4449d();
            if (d != 0) {
                return Math.abs(d - this.f2441b.mo739h().mo728a());
            }
            m4447b();
            return 0;
        }

        private long m4449d() {
            return this.f2441b.m4457s().getLong(this.f2440a, 0);
        }

        public Pair<String, Long> m4450a() {
            this.f2441b.mo736e();
            long c = m4448c();
            if (c < this.f2444e) {
                return null;
            }
            if (c > this.f2444e * 2) {
                m4447b();
                return null;
            }
            String string = this.f2441b.m4457s().getString(this.f2443d, null);
            c = this.f2441b.m4457s().getLong(this.f2442c, 0);
            m4447b();
            return (string == null || c <= 0) ? C1157w.f2445a : new Pair(string, Long.valueOf(c));
        }

        public void m4451a(String str) {
            m4452a(str, 1);
        }

        public void m4452a(String str, long j) {
            this.f2441b.mo736e();
            if (m4449d() == 0) {
                m4447b();
            }
            if (str == null) {
                str = "";
            }
            long j2 = this.f2441b.f2451h.getLong(this.f2442c, 0);
            if (j2 <= 0) {
                Editor edit = this.f2441b.f2451h.edit();
                edit.putString(this.f2443d, str);
                edit.putLong(this.f2442c, j);
                edit.apply();
                return;
            }
            Object obj = (this.f2441b.f2455l.nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
            Editor edit2 = this.f2441b.f2451h.edit();
            if (obj != null) {
                edit2.putString(this.f2443d, str);
            }
            edit2.putLong(this.f2442c, j2 + j);
            edit2.apply();
        }
    }

    C1157w(C1164y c1164y) {
        super(c1164y);
    }

    static MessageDigest m4454a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    private SharedPreferences m4457s() {
        mo736e();
        m4091y();
        return this.f2451h;
    }

    protected void mo733a() {
        this.f2451h = mo740i().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    }

    void m4459a(boolean z) {
        mo736e();
        mo743l().m4417t().m4388a("Setting useService", Boolean.valueOf(z));
        Editor edit = m4457s().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    Pair<String, Boolean> m4460b() {
        mo736e();
        long b = mo739h().mo729b();
        if (this.f2452i != null && b < this.f2454k) {
            return new Pair(this.f2452i, Boolean.valueOf(this.f2453j));
        }
        this.f2454k = b + mo745n().m4284x();
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(mo740i());
            this.f2452i = advertisingIdInfo.getId();
            this.f2453j = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            mo743l().m4416s().m4388a("Unable to get advertising id", th);
            this.f2452i = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f2452i, Boolean.valueOf(this.f2453j));
    }

    void m4461b(boolean z) {
        mo736e();
        mo743l().m4417t().m4388a("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = m4457s().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    String m4462o() {
        String str = (String) m4460b().first;
        if (C1157w.m4454a("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, C1157w.m4454a("MD5").digest(str.getBytes()))});
    }

    String m4463p() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    Boolean m4464q() {
        mo736e();
        return !m4457s().contains("use_service") ? null : Boolean.valueOf(m4457s().getBoolean("use_service", false));
    }

    boolean m4465r() {
        mo736e();
        return m4457s().getBoolean("measurement_enabled", true);
    }
}
