package io.fabric.sdk.android.services.p020b;

/* compiled from: ResponseParser */
public class C1500r {
    public static int m5738a(int i) {
        if (i >= 200 && i <= 299) {
            return 0;
        }
        if (i >= 300 && i <= 399) {
            return 1;
        }
        if (i >= 400 && i <= 499) {
            return 0;
        }
        if (i >= 500) {
            return 1;
        }
        return 1;
    }
}
