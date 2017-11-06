package io.fabric.sdk.android.services.p020b;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: TimingMetric */
public class C1502t {
    private final String f3773a;
    private final String f3774b;
    private final boolean f3775c;
    private long f3776d;
    private long f3777e;

    public C1502t(String str, String str2) {
        this.f3773a = str;
        this.f3774b = str2;
        this.f3775c = !Log.isLoggable(str2, 2);
    }

    public synchronized void m5741a() {
        if (!this.f3775c) {
            this.f3776d = SystemClock.elapsedRealtime();
            this.f3777e = 0;
        }
    }

    public synchronized void m5742b() {
        if (!this.f3775c) {
            if (this.f3777e == 0) {
                this.f3777e = SystemClock.elapsedRealtime() - this.f3776d;
                m5740c();
            }
        }
    }

    private void m5740c() {
        Log.v(this.f3774b, this.f3773a + ": " + this.f3777e + "ms");
    }
}
