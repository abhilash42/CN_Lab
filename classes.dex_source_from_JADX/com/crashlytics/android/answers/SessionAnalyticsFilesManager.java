package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.p018c.C0670b;
import io.fabric.sdk.android.services.p018c.C1505c;
import io.fabric.sdk.android.services.p020b.C1486k;
import io.fabric.sdk.android.services.p022e.C1536b;
import java.util.UUID;

class SessionAnalyticsFilesManager extends C0670b<SessionEvent> {
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private C1536b analyticsSettingsData;

    SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, C1486k c1486k, C1505c c1505c) {
        super(context, sessionEventTransform, c1486k, c1505c, 100);
    }

    protected String generateUniqueRollOverFileName() {
        return SESSION_ANALYTICS_TO_SEND_FILE_PREFIX + C0670b.ROLL_OVER_FILE_NAME_SEPARATOR + UUID.randomUUID().toString() + C0670b.ROLL_OVER_FILE_NAME_SEPARATOR + this.currentTimeProvider.mo830a() + SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION;
    }

    protected int getMaxFilesToKeep() {
        return this.analyticsSettingsData == null ? super.getMaxFilesToKeep() : this.analyticsSettingsData.f3835e;
    }

    protected int getMaxByteSizePerFile() {
        return this.analyticsSettingsData == null ? super.getMaxByteSizePerFile() : this.analyticsSettingsData.f3833c;
    }

    void setAnalyticsSettingsData(C1536b c1536b) {
        this.analyticsSettingsData = c1536b;
    }
}
