package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;
import io.fabric.sdk.android.C1450a.C0663b;

class AnswersLifecycleCallbacks extends C0663b {
    private final SessionAnalyticsManager analyticsManager;
    private final BackgroundManager backgroundManager;

    public AnswersLifecycleCallbacks(SessionAnalyticsManager sessionAnalyticsManager, BackgroundManager backgroundManager) {
        this.analyticsManager = sessionAnalyticsManager;
        this.backgroundManager = backgroundManager;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.analyticsManager.onLifecycle(activity, Type.START);
    }

    public void onActivityResumed(Activity activity) {
        this.analyticsManager.onLifecycle(activity, Type.RESUME);
        this.backgroundManager.onActivityResumed();
    }

    public void onActivityPaused(Activity activity) {
        this.analyticsManager.onLifecycle(activity, Type.PAUSE);
        this.backgroundManager.onActivityPaused();
    }

    public void onActivityStopped(Activity activity) {
        this.analyticsManager.onLifecycle(activity, Type.STOP);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
