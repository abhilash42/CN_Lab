package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.p019a.C1520b;
import io.fabric.sdk.android.services.concurrency.p019a.C1521c;
import io.fabric.sdk.android.services.concurrency.p019a.C1522e;
import io.fabric.sdk.android.services.p018c.C0664f;
import java.io.File;
import java.util.List;

class AnswersRetryFilesSender implements C0664f {
    private static final int BACKOFF_MS = 1000;
    private static final int BACKOFF_POWER = 8;
    private static final double JITTER_PERCENT = 0.1d;
    private static final int MAX_RETRIES = 5;
    private final SessionAnalyticsFilesSender filesSender;
    private final RetryManager retryManager;

    public static AnswersRetryFilesSender build(SessionAnalyticsFilesSender sessionAnalyticsFilesSender) {
        return new AnswersRetryFilesSender(sessionAnalyticsFilesSender, new RetryManager(new C1522e(new RandomBackoff(new C1521c(1000, 8), JITTER_PERCENT), new C1520b(5))));
    }

    AnswersRetryFilesSender(SessionAnalyticsFilesSender sessionAnalyticsFilesSender, RetryManager retryManager) {
        this.filesSender = sessionAnalyticsFilesSender;
        this.retryManager = retryManager;
    }

    public boolean send(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.retryManager.canRetry(nanoTime)) {
            return false;
        }
        if (this.filesSender.send(list)) {
            this.retryManager.reset();
            return true;
        }
        this.retryManager.recordRetry(nanoTime);
        return false;
    }
}
