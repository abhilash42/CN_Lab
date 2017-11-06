package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.p009e.C0188i;
import android.util.Log;

public class C1040e {
    private final long f2065a;
    private final int f2066b;
    private final C0188i<String, Long> f2067c;

    public C1040e() {
        this.f2065a = 60000;
        this.f2066b = 10;
        this.f2067c = new C0188i(10);
    }

    public C1040e(int i, long j) {
        this.f2065a = j;
        this.f2066b = i;
        this.f2067c = new C0188i();
    }

    private void m3756a(long j, long j2) {
        for (int size = this.f2067c.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.f2067c.m769c(size)).longValue() > j) {
                this.f2067c.m770d(size);
            }
        }
    }

    public Long m3757a(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f2065a;
        synchronized (this) {
            while (this.f2067c.size() >= this.f2066b) {
                m3756a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.f2066b + " is not enough. Current durationThreshold is: " + j);
            }
            l = (Long) this.f2067c.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean m3758b(String str) {
        boolean z;
        synchronized (this) {
            z = this.f2067c.remove(str) != null;
        }
        return z;
    }
}
