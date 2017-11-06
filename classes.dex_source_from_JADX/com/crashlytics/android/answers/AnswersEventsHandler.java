package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.p018c.C0662d;
import io.fabric.sdk.android.services.p022e.C1536b;
import java.util.concurrent.ScheduledExecutorService;

class AnswersEventsHandler implements C0662d {
    private final Context context;
    final ScheduledExecutorService executor;
    private final AnswersFilesManagerProvider filesManagerProvider;
    private final C0653h kit;
    private final SessionMetadataCollector metadataCollector;
    private final C1570d requestFactory;
    SessionAnalyticsManagerStrategy strategy = new DisabledSessionAnalyticsManagerStrategy();

    class C06572 implements Runnable {
        C06572() {
        }

        public void run() {
            try {
                SessionAnalyticsManagerStrategy sessionAnalyticsManagerStrategy = AnswersEventsHandler.this.strategy;
                AnswersEventsHandler.this.strategy = new DisabledSessionAnalyticsManagerStrategy();
                sessionAnalyticsManagerStrategy.deleteAllEvents();
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(Answers.TAG, "Failed to disable events", e);
            }
        }
    }

    class C06583 implements Runnable {
        C06583() {
        }

        public void run() {
            try {
                AnswersEventsHandler.this.strategy.sendEvents();
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(Answers.TAG, "Failed to send events files", e);
            }
        }
    }

    class C06594 implements Runnable {
        C06594() {
        }

        public void run() {
            try {
                SessionEventMetadata metadata = AnswersEventsHandler.this.metadataCollector.getMetadata();
                SessionAnalyticsFilesManager analyticsFilesManager = AnswersEventsHandler.this.filesManagerProvider.getAnalyticsFilesManager();
                analyticsFilesManager.registerRollOverListener(AnswersEventsHandler.this);
                AnswersEventsHandler.this.strategy = new EnabledSessionAnalyticsManagerStrategy(AnswersEventsHandler.this.kit, AnswersEventsHandler.this.context, AnswersEventsHandler.this.executor, analyticsFilesManager, AnswersEventsHandler.this.requestFactory, metadata);
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(Answers.TAG, "Failed to enable events", e);
            }
        }
    }

    class C06605 implements Runnable {
        C06605() {
        }

        public void run() {
            try {
                AnswersEventsHandler.this.strategy.rollFileOver();
            } catch (Throwable e) {
                C1457c.m5546h().mo819e(Answers.TAG, "Failed to flush events", e);
            }
        }
    }

    public AnswersEventsHandler(C0653h c0653h, Context context, AnswersFilesManagerProvider answersFilesManagerProvider, SessionMetadataCollector sessionMetadataCollector, C1570d c1570d, ScheduledExecutorService scheduledExecutorService) {
        this.kit = c0653h;
        this.context = context;
        this.filesManagerProvider = answersFilesManagerProvider;
        this.metadataCollector = sessionMetadataCollector;
        this.requestFactory = c1570d;
        this.executor = scheduledExecutorService;
    }

    public void processEventAsync(Builder builder) {
        processEvent(builder, false, false);
    }

    public void processEventAsyncAndFlush(Builder builder) {
        processEvent(builder, false, true);
    }

    public void processEventSync(Builder builder) {
        processEvent(builder, true, false);
    }

    public void setAnalyticsSettingsData(final C1536b c1536b, final String str) {
        executeAsync(new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.setAnalyticsSettingsData(c1536b, str);
                } catch (Throwable e) {
                    C1457c.m5546h().mo819e(Answers.TAG, "Failed to set analytics settings data", e);
                }
            }
        });
    }

    public void disable() {
        executeAsync(new C06572());
    }

    public void onRollOver(String str) {
        executeAsync(new C06583());
    }

    public void enable() {
        executeAsync(new C06594());
    }

    public void flushEvents() {
        executeAsync(new C06605());
    }

    void processEvent(final Builder builder, boolean z, final boolean z2) {
        Runnable c06616 = new Runnable() {
            public void run() {
                try {
                    AnswersEventsHandler.this.strategy.processEvent(builder);
                    if (z2) {
                        AnswersEventsHandler.this.strategy.rollFileOver();
                    }
                } catch (Throwable e) {
                    C1457c.m5546h().mo819e(Answers.TAG, "Failed to process event", e);
                }
            }
        };
        if (z) {
            executeSync(c06616);
        } else {
            executeAsync(c06616);
        }
    }

    private void executeSync(Runnable runnable) {
        try {
            this.executor.submit(runnable).get();
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(Answers.TAG, "Failed to run events task", e);
        }
    }

    private void executeAsync(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(Answers.TAG, "Failed to submit events task", e);
        }
    }
}
