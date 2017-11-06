package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.p018c.C0666e;
import io.fabric.sdk.android.services.p022e.C1536b;

interface SessionAnalyticsManagerStrategy extends C0666e {
    void deleteAllEvents();

    void processEvent(Builder builder);

    void sendEvents();

    void setAnalyticsSettingsData(C1536b c1536b, String str);
}
