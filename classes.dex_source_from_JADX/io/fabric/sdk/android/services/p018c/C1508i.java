package io.fabric.sdk.android.services.p018c;

import android.content.Context;
import io.fabric.sdk.android.services.p020b.C1482i;

/* compiled from: TimeBasedFileRollOverRunnable */
public class C1508i implements Runnable {
    private final Context f3787a;
    private final C0666e f3788b;

    public C1508i(Context context, C0666e c0666e) {
        this.f3787a = context;
        this.f3788b = c0666e;
    }

    public void run() {
        try {
            C1482i.m5653a(this.f3787a, "Performing time based file roll over.");
            if (!this.f3788b.rollFileOver()) {
                this.f3788b.cancelTimeBasedFileRollOver();
            }
        } catch (Throwable e) {
            C1482i.m5654a(this.f3787a, "Failed to roll over file", e);
        }
    }
}
