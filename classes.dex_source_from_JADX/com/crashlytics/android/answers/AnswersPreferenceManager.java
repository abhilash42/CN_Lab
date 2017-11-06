package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.services.p037d.C1533c;
import io.fabric.sdk.android.services.p037d.C1534d;

class AnswersPreferenceManager {
    static final String PREFKEY_ANALYTICS_LAUNCHED = "analytics_launched";
    static final String PREF_STORE_NAME = "settings";
    private final C1533c prefStore;

    public static AnswersPreferenceManager build(Context context) {
        return new AnswersPreferenceManager(new C1534d(context, PREF_STORE_NAME));
    }

    AnswersPreferenceManager(C1533c c1533c) {
        this.prefStore = c1533c;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void setAnalyticsLaunched() {
        this.prefStore.mo844a(this.prefStore.mo845b().putBoolean(PREFKEY_ANALYTICS_LAUNCHED, true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean hasAnalyticsLaunched() {
        return this.prefStore.mo843a().getBoolean(PREFKEY_ANALYTICS_LAUNCHED, false);
    }
}
