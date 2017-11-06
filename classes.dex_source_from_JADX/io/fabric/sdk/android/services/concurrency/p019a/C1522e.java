package io.fabric.sdk.android.services.concurrency.p019a;

/* compiled from: RetryState */
public class C1522e {
    private final int f3807a;
    private final C1514a f3808b;
    private final C1519d f3809c;

    public C1522e(C1514a c1514a, C1519d c1519d) {
        this(0, c1514a, c1519d);
    }

    public C1522e(int i, C1514a c1514a, C1519d c1519d) {
        this.f3807a = i;
        this.f3808b = c1514a;
        this.f3809c = c1519d;
    }

    public long m5767a() {
        return this.f3808b.getDelayMillis(this.f3807a);
    }

    public C1522e m5768b() {
        return new C1522e(this.f3807a + 1, this.f3808b, this.f3809c);
    }

    public C1522e m5769c() {
        return new C1522e(this.f3808b, this.f3809c);
    }
}
