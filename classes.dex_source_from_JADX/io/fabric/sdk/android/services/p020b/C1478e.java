package io.fabric.sdk.android.services.p020b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import io.fabric.sdk.android.C1457c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: AdvertisingInfoServiceStrategy */
class C1478e implements C1473f {
    private final Context f3699a;

    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C1476a implements ServiceConnection {
        private boolean f3696a;
        private final LinkedBlockingQueue<IBinder> f3697b;

        private C1476a() {
            this.f3696a = false;
            this.f3697b = new LinkedBlockingQueue(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f3697b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f3697b.clear();
        }

        public IBinder m5626a() {
            if (this.f3696a) {
                C1457c.m5546h().mo818e("Fabric", "getBinder already called");
            }
            this.f3696a = true;
            try {
                return (IBinder) this.f3697b.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C1477b implements IInterface {
        private final IBinder f3698a;

        public boolean m5628b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r0 = 1;
            r1 = 0;
            r2 = android.os.Parcel.obtain();
            r3 = android.os.Parcel.obtain();
            r4 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInterfaceToken(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = 1;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInt(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r7.f3698a;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = 2;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r6 = 0;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4.transact(r5, r2, r3, r6);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.readException();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r3.readInt();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            if (r4 == 0) goto L_0x002a;
        L_0x0023:
            r3.recycle();
            r2.recycle();
        L_0x0029:
            return r0;
        L_0x002a:
            r0 = r1;
            goto L_0x0023;
        L_0x002c:
            r0 = move-exception;
            r0 = io.fabric.sdk.android.C1457c.m5546h();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = "Fabric";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r0.mo811a(r4, r5);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.recycle();
            r2.recycle();
            r0 = r1;
            goto L_0x0029;
        L_0x0040:
            r0 = move-exception;
            r3.recycle();
            r2.recycle();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.b.e.b.b():boolean");
        }

        public C1477b(IBinder iBinder) {
            this.f3698a = iBinder;
        }

        public IBinder asBinder() {
            return this.f3698a;
        }

        public String m5627a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str = null;
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3698a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Exception e) {
                C1457c.m5546h().mo811a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
            return str;
        }
    }

    public C1478e(Context context) {
        this.f3699a = context.getApplicationContext();
    }

    public C1470b mo829a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C1457c.m5546h().mo811a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f3699a.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            ServiceConnection c1476a = new C1476a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            try {
                if (this.f3699a.bindService(intent, c1476a, 1)) {
                    C1477b c1477b = new C1477b(c1476a.m5626a());
                    C1470b c1470b = new C1470b(c1477b.m5627a(), c1477b.m5628b());
                    this.f3699a.unbindService(c1476a);
                    return c1470b;
                }
                C1457c.m5546h().mo811a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                return null;
            } catch (Throwable e) {
                C1457c.m5546h().mo817d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                this.f3699a.unbindService(c1476a);
                return null;
            } catch (Throwable e2) {
                C1457c.m5546h().mo812a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", e2);
                return null;
            }
        } catch (NameNotFoundException e3) {
            C1457c.m5546h().mo811a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Throwable e22) {
            C1457c.m5546h().mo812a("Fabric", "Unable to determine if Google Play Services is available", e22);
            return null;
        }
    }
}
