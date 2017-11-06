package io.fabric.sdk.android.services.p020b;

/* compiled from: DeliveryMechanism */
public enum C1487l {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    private final int f3723e;

    private C1487l(int i) {
        this.f3723e = i;
    }

    public int m5685a() {
        return this.f3723e;
    }

    public String toString() {
        return Integer.toString(this.f3723e);
    }

    public static C1487l m5684a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
