package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0747b;
import com.google.android.gms.common.C0749d;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.common.stats.C1036b;
import com.google.android.gms.internal.C1064a;
import com.google.android.gms.internal.C1064a.C1066a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private static boolean zzoN = false;
    private final Context mContext;
    C0749d zzoH;
    C1064a zzoI;
    boolean zzoJ;
    Object zzoK;
    C0730a zzoL;
    final long zzoM;

    public static final class Info {
        private final String zzoS;
        private final boolean zzoT;

        public Info(String str, boolean z) {
            this.zzoS = str;
            this.zzoT = z;
        }

        public String getId() {
            return this.zzoS;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzoT;
        }

        public String toString() {
            return "{" + this.zzoS + "}" + this.zzoT;
        }
    }

    static class C0730a extends Thread {
        CountDownLatch f1744a = new CountDownLatch(1);
        boolean f1745b = false;
        private WeakReference<AdvertisingIdClient> f1746c;
        private long f1747d;

        public C0730a(AdvertisingIdClient advertisingIdClient, long j) {
            this.f1746c = new WeakReference(advertisingIdClient);
            this.f1747d = j;
            start();
        }

        private void m3173c() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f1746c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.f1745b = true;
            }
        }

        public void m3174a() {
            this.f1744a.countDown();
        }

        public boolean m3175b() {
            return this.f1745b;
        }

        public void run() {
            try {
                if (!this.f1744a.await(this.f1747d, TimeUnit.MILLISECONDS)) {
                    m3173c();
                }
            } catch (InterruptedException e) {
                m3173c();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.zzoK = new Object();
        C1032p.m3678a((Object) context);
        this.mContext = context;
        this.zzoJ = false;
        this.zzoM = j;
    }

    public static Info getAdvertisingIdInfo(Context context) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzb(false);
            Info info = advertisingIdClient.getInfo();
            return info;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
        zzoN = z;
    }

    static C1064a zza(Context context, C0749d c0749d) {
        try {
            return C1066a.m3881a(c0749d.m3213a());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void zzaL() {
        synchronized (this.zzoK) {
            if (this.zzoL != null) {
                this.zzoL.m3174a();
                try {
                    this.zzoL.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzoM > 0) {
                this.zzoL = new C0730a(this, this.zzoM);
            }
        }
    }

    static C0749d zzp(Context context) {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            if (zzoN) {
                Log.d("Ads", "Skipping gmscore version check");
                switch (C0747b.m3202a().m3204a(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                GooglePlayServicesUtil.zzac(context);
            } catch (Throwable e) {
                throw new IOException(e);
            }
            ServiceConnection c0749d = new C0749d();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            try {
                if (C1036b.m3742a().m3753a(context, intent, c0749d, 1)) {
                    return c0749d;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e2) {
                IOException iOException = new IOException(e2);
            }
        } catch (NameNotFoundException e3) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.C1032p.m3687c(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.zzoH;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.zzoJ;	 Catch:{ IllegalArgumentException -> 0x002d }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.stats.C1036b.m3742a();	 Catch:{ IllegalArgumentException -> 0x002d }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002d }
        r2 = r3.zzoH;	 Catch:{ IllegalArgumentException -> 0x002d }
        r0.m3751a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d }
    L_0x001f:
        r0 = 0;
        r3.zzoJ = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzoI = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzoH = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() {
        Info info;
        C1032p.m3687c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzoJ) {
                synchronized (this.zzoK) {
                    if (this.zzoL == null || !this.zzoL.m3175b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.zzoJ) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            C1032p.m3678a(this.zzoH);
            C1032p.m3678a(this.zzoI);
            info = new Info(this.zzoI.mo723a(), this.zzoI.mo726a(true));
        }
        zzaL();
        return info;
    }

    public void start() {
        zzb(true);
    }

    protected void zzb(boolean z) {
        C1032p.m3687c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzoJ) {
                finish();
            }
            this.zzoH = zzp(this.mContext);
            this.zzoI = zza(this.mContext, this.zzoH);
            this.zzoJ = true;
            if (z) {
                zzaL();
            }
        }
    }
}
