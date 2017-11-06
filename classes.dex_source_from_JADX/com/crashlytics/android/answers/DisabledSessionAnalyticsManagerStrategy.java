package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.p022e.C1536b;

class DisabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    DisabledSessionAnalyticsManagerStrategy() {
    }

    public void setAnalyticsSettingsData(C1536b c1536b, String str) {
    }

    public void processEvent(Builder builder) {
    }

    public void sendEvents() {
    }

    public void deleteAllEvents() {
    }

    public boolean rollFileOver() {
        return false;
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
    }

    public void cancelTimeBasedFileRollOver() {
    }
}
