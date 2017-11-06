package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.p019a.C1522e;

class RetryManager {
    private static final long NANOSECONDS_IN_MS = 1000000;
    long lastRetry;
    private C1522e retryState;

    public RetryManager(C1522e c1522e) {
        if (c1522e == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.retryState = c1522e;
    }

    public boolean canRetry(long j) {
        return j - this.lastRetry >= NANOSECONDS_IN_MS * this.retryState.m5767a();
    }

    public void recordRetry(long j) {
        this.lastRetry = j;
        this.retryState = this.retryState.m5768b();
    }

    public void reset() {
        this.lastRetry = 0;
        this.retryState = this.retryState.m5769c();
    }
}
