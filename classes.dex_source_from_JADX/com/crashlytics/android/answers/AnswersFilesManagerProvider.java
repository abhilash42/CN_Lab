package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.services.p018c.C1507g;
import io.fabric.sdk.android.services.p020b.C1501s;
import io.fabric.sdk.android.services.p037d.C1531a;

class AnswersFilesManagerProvider {
    static final String SESSION_ANALYTICS_FILE_NAME = "session_analytics.tap";
    static final String SESSION_ANALYTICS_TO_SEND_DIR = "session_analytics_to_send";
    final Context context;
    final C1531a fileStore;

    public AnswersFilesManagerProvider(Context context, C1531a c1531a) {
        this.context = context;
        this.fileStore = c1531a;
    }

    public SessionAnalyticsFilesManager getAnalyticsFilesManager() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new SessionAnalyticsFilesManager(this.context, new SessionEventTransform(), new C1501s(), new C1507g(this.context, this.fileStore.mo842a(), SESSION_ANALYTICS_FILE_NAME, SESSION_ANALYTICS_TO_SEND_DIR));
    }
}
