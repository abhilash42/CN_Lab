package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.BackgroundManager.Listener;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1450a;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.network.C1571b;
import io.fabric.sdk.android.services.p020b.C1491n;
import io.fabric.sdk.android.services.p020b.C1493o;
import io.fabric.sdk.android.services.p022e.C1536b;
import io.fabric.sdk.android.services.p037d.C1532b;
import java.util.concurrent.ScheduledExecutorService;

class SessionAnalyticsManager implements Listener {
    static final String EXECUTOR_SERVICE = "Answers Events Handler";
    static final String ON_CRASH_ERROR_MSG = "onCrash called from main thread!!!";
    final BackgroundManager backgroundManager;
    final AnswersEventsHandler eventsHandler;
    private final long installedAt;
    final C1450a lifecycleManager;
    final AnswersPreferenceManager preferenceManager;

    public static SessionAnalyticsManager build(C0653h c0653h, Context context, C1493o c1493o, String str, String str2, long j) {
        SessionMetadataCollector sessionMetadataCollector = new SessionMetadataCollector(context, c1493o, str, str2);
        AnswersFilesManagerProvider answersFilesManagerProvider = new AnswersFilesManagerProvider(context, new C1532b(c0653h));
        C1570d c1571b = new C1571b(C1457c.m5546h());
        C1450a c1450a = new C1450a(context);
        ScheduledExecutorService b = C1491n.m5689b(EXECUTOR_SERVICE);
        BackgroundManager backgroundManager = new BackgroundManager(b);
        return new SessionAnalyticsManager(new AnswersEventsHandler(c0653h, context, answersFilesManagerProvider, sessionMetadataCollector, c1571b, b), c1450a, backgroundManager, AnswersPreferenceManager.build(context), j);
    }

    SessionAnalyticsManager(AnswersEventsHandler answersEventsHandler, C1450a c1450a, BackgroundManager backgroundManager, AnswersPreferenceManager answersPreferenceManager, long j) {
        this.eventsHandler = answersEventsHandler;
        this.lifecycleManager = c1450a;
        this.backgroundManager = backgroundManager;
        this.preferenceManager = answersPreferenceManager;
        this.installedAt = j;
    }

    public void enable() {
        this.eventsHandler.enable();
        this.lifecycleManager.m5505a(new AnswersLifecycleCallbacks(this, this.backgroundManager));
        this.backgroundManager.registerListener(this);
        if (isFirstLaunch()) {
            onInstall(this.installedAt);
            this.preferenceManager.setAnalyticsLaunched();
        }
    }

    public void disable() {
        this.lifecycleManager.m5504a();
        this.eventsHandler.disable();
    }

    public void onCustom(CustomEvent customEvent) {
        C1457c.m5546h().mo811a(Answers.TAG, "Logged custom event: " + customEvent);
        this.eventsHandler.processEventAsync(SessionEvent.customEventBuilder(customEvent));
    }

    public void onPredefined(PredefinedEvent predefinedEvent) {
        C1457c.m5546h().mo811a(Answers.TAG, "Logged predefined event: " + predefinedEvent);
        this.eventsHandler.processEventAsync(SessionEvent.predefinedEventBuilder(predefinedEvent));
    }

    public void onCrash(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(ON_CRASH_ERROR_MSG);
        }
        C1457c.m5546h().mo811a(Answers.TAG, "Logged crash");
        this.eventsHandler.processEventSync(SessionEvent.crashEventBuilder(str, str2));
    }

    public void onError(String str) {
    }

    public void onInstall(long j) {
        C1457c.m5546h().mo811a(Answers.TAG, "Logged install");
        this.eventsHandler.processEventAsyncAndFlush(SessionEvent.installEventBuilder(j));
    }

    public void onLifecycle(Activity activity, Type type) {
        C1457c.m5546h().mo811a(Answers.TAG, "Logged lifecycle event: " + type.name());
        this.eventsHandler.processEventAsync(SessionEvent.lifecycleEventBuilder(type, activity));
    }

    public void onBackground() {
        C1457c.m5546h().mo811a(Answers.TAG, "Flush events when app is backgrounded");
        this.eventsHandler.flushEvents();
    }

    public void setAnalyticsSettingsData(C1536b c1536b, String str) {
        this.backgroundManager.setFlushOnBackground(c1536b.f3838h);
        this.eventsHandler.setAnalyticsSettingsData(c1536b, str);
    }

    boolean isFirstLaunch() {
        return !this.preferenceManager.hasAnalyticsLaunched();
    }
}
