package io.fabric.sdk.android.services.concurrency.p019a;

/* compiled from: ExponentialBackoff */
public class C1521c implements C1514a {
    private final long f3805a;
    private final int f3806b;

    public C1521c(long j, int i) {
        this.f3805a = j;
        this.f3806b = i;
    }

    public long getDelayMillis(int i) {
        return (long) (((double) this.f3805a) * Math.pow((double) this.f3806b, (double) i));
    }
}
