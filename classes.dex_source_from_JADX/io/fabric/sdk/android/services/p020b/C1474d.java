package io.fabric.sdk.android.services.p020b;

import android.content.Context;
import io.fabric.sdk.android.C1457c;

/* compiled from: AdvertisingInfoReflectionStrategy */
class C1474d implements C1473f {
    private final Context f3695a;

    public C1474d(Context context) {
        this.f3695a = context.getApplicationContext();
    }

    boolean m5625a(Context context) {
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public C1470b mo829a() {
        if (m5625a(this.f3695a)) {
            return new C1470b(m5621b(), m5622c());
        }
        return null;
    }

    private String m5621b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m5623d(), new Object[0]);
        } catch (Exception e) {
            C1457c.m5546h().mo816d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean m5622c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m5623d(), new Object[0])).booleanValue();
        } catch (Exception e) {
            C1457c.m5546h().mo816d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object m5623d() {
        Object obj = null;
        try {
            obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f3695a});
        } catch (Exception e) {
            C1457c.m5546h().mo816d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
        }
        return obj;
    }
}
