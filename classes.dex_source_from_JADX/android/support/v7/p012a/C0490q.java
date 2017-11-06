package android.support.v7.p012a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.p004a.C0041j;
import android.util.Log;
import java.util.Calendar;

/* compiled from: TwilightManager */
class C0490q {
    private static final C0489a f922a = new C0489a();
    private final Context f923b;
    private final LocationManager f924c;

    /* compiled from: TwilightManager */
    private static class C0489a {
        boolean f916a;
        long f917b;
        long f918c;
        long f919d;
        long f920e;
        long f921f;

        private C0489a() {
        }
    }

    C0490q(Context context) {
        this.f923b = context;
        this.f924c = (LocationManager) context.getSystemService("location");
    }

    boolean m2199a() {
        C0489a c0489a = f922a;
        if (m2197a(c0489a)) {
            return c0489a.f916a;
        }
        Location b = m2198b();
        if (b != null) {
            m2196a(b);
            return c0489a.f916a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location m2198b() {
        Location a;
        Location location = null;
        if (C0041j.m112a(this.f923b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            a = m2195a("network");
        } else {
            a = null;
        }
        if (C0041j.m112a(this.f923b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m2195a("gps");
        }
        if (location == null || a == null) {
            if (location == null) {
                location = a;
            }
            return location;
        } else if (location.getTime() > a.getTime()) {
            return location;
        } else {
            return a;
        }
    }

    private Location m2195a(String str) {
        if (this.f924c != null) {
            try {
                if (this.f924c.isProviderEnabled(str)) {
                    return this.f924c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private boolean m2197a(C0489a c0489a) {
        return c0489a != null && c0489a.f921f > System.currentTimeMillis();
    }

    private void m2196a(Location location) {
        long j;
        C0489a c0489a = f922a;
        long currentTimeMillis = System.currentTimeMillis();
        C0487p a = C0487p.m2193a();
        a.m2194a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f913a;
        a.m2194a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f915c == 1;
        long j3 = a.f914b;
        long j4 = a.f913a;
        a.m2194a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f914b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        c0489a.f916a = z;
        c0489a.f917b = j2;
        c0489a.f918c = j3;
        c0489a.f919d = j4;
        c0489a.f920e = j5;
        c0489a.f921f = j;
    }
}
