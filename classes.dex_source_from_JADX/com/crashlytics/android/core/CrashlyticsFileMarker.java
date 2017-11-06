package com.crashlytics.android.core;

import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p037d.C1531a;
import java.io.File;

class CrashlyticsFileMarker {
    private final C1531a fileStore;
    private final String markerName;

    public CrashlyticsFileMarker(String str, C1531a c1531a) {
        this.markerName = str;
        this.fileStore = c1531a;
    }

    public boolean create() {
        boolean z = false;
        try {
            z = getMarkerFile().createNewFile();
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error creating marker: " + this.markerName, e);
        }
        return z;
    }

    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    public boolean remove() {
        return getMarkerFile().delete();
    }

    private File getMarkerFile() {
        return new File(this.fileStore.mo842a(), this.markerName);
    }
}
