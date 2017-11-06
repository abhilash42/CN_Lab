package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.p018c.C0664f;
import io.fabric.sdk.android.services.p018c.C1508i;
import io.fabric.sdk.android.services.p020b.C1479g;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p022e.C1536b;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    C1479g apiKey = new C1479g();
    private final Context context;
    boolean customEventsEnabled = true;
    EventFilter eventFilter = new KeepAllEventFilter();
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    C0664f filesSender;
    private final C1570d httpRequestFactory;
    private final C0653h kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled = true;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference();
    volatile int rolloverIntervalSeconds = UNDEFINED_ROLLOVER_INTERVAL_SECONDS;

    public EnabledSessionAnalyticsManagerStrategy(C0653h c0653h, Context context, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, C1570d c1570d, SessionEventMetadata sessionEventMetadata) {
        this.kit = c0653h;
        this.context = context;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = c1570d;
        this.metadata = sessionEventMetadata;
    }

    public void setAnalyticsSettingsData(C1536b c1536b, String str) {
        this.filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(this.kit, str, c1536b.f3831a, this.httpRequestFactory, this.apiKey.m5631a(this.context)));
        this.filesManager.setAnalyticsSettingsData(c1536b);
        this.customEventsEnabled = c1536b.f3836f;
        C1457c.m5546h().mo811a(Answers.TAG, "Custom event tracking " + (this.customEventsEnabled ? "enabled" : "disabled"));
        this.predefinedEventsEnabled = c1536b.f3837g;
        C1457c.m5546h().mo811a(Answers.TAG, "Predefined event tracking " + (this.predefinedEventsEnabled ? "enabled" : "disabled"));
        if (c1536b.f3839i > 1) {
            C1457c.m5546h().mo811a(Answers.TAG, "Event sampling enabled");
            this.eventFilter = new SamplingEventFilter(c1536b.f3839i);
        }
        this.rolloverIntervalSeconds = c1536b.f3832b;
        scheduleTimeBasedFileRollOver(0, (long) this.rolloverIntervalSeconds);
    }

    public void processEvent(Builder builder) {
        SessionEvent build = builder.build(this.metadata);
        if (!this.customEventsEnabled && Type.CUSTOM.equals(build.type)) {
            C1457c.m5546h().mo811a(Answers.TAG, "Custom events tracking disabled - skipping event: " + build);
        } else if (!this.predefinedEventsEnabled && Type.PREDEFINED.equals(build.type)) {
            C1457c.m5546h().mo811a(Answers.TAG, "Predefined events tracking disabled - skipping event: " + build);
        } else if (this.eventFilter.skipEvent(build)) {
            C1457c.m5546h().mo811a(Answers.TAG, "Skipping filtered event: " + build);
        } else {
            try {
                this.filesManager.writeEvent(build);
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(Answers.TAG, "Failed to write event: " + build, e);
            }
            scheduleTimeBasedRollOverIfNeeded();
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
        if ((this.rolloverIntervalSeconds != UNDEFINED_ROLLOVER_INTERVAL_SECONDS ? 1 : null) != null) {
            scheduleTimeBasedFileRollOver((long) this.rolloverIntervalSeconds, (long) this.rolloverIntervalSeconds);
        }
    }

    public void sendEvents() {
        int size;
        if (this.filesSender == null) {
            C1482i.m5653a(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        C1482i.m5653a(this.context, "Sending all files");
        List batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i = 0;
        while (batchOfFilesToSend.size() > 0) {
            C1482i.m5653a(this.context, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(batchOfFilesToSend.size())}));
            boolean send = this.filesSender.send(batchOfFilesToSend);
            if (send) {
                size = batchOfFilesToSend.size() + i;
                try {
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                    i = size;
                } catch (Exception e) {
                    Throwable e2 = e;
                }
            }
            if (!send) {
                break;
            }
            try {
                batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
            } catch (Throwable e3) {
                Throwable th = e3;
                size = i;
                e2 = th;
            }
        }
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
        C1482i.m5654a(this.context, "Failed to send batch of analytics files to server: " + e2.getMessage(), e2);
        i = size;
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }

    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            C1482i.m5653a(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.rolloverFutureRef.get()).cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (Throwable e) {
            C1482i.m5654a(this.context, "Failed to roll file over.", e);
            return false;
        }
    }

    void scheduleTimeBasedFileRollOver(long j, long j2) {
        if ((this.rolloverFutureRef.get() == null ? 1 : null) != null) {
            Runnable c1508i = new C1508i(this.context, this);
            C1482i.m5653a(this.context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(c1508i, j, j2, TimeUnit.SECONDS));
            } catch (Throwable e) {
                C1482i.m5654a(this.context, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
