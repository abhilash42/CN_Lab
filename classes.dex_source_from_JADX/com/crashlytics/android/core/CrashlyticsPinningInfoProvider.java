package com.crashlytics.android.core;

import io.fabric.sdk.android.services.network.C0701f;
import java.io.InputStream;

class CrashlyticsPinningInfoProvider implements C0701f {
    private final PinningInfoProvider pinningInfo;

    public CrashlyticsPinningInfoProvider(PinningInfoProvider pinningInfoProvider) {
        this.pinningInfo = pinningInfoProvider;
    }

    public InputStream getKeyStoreStream() {
        return this.pinningInfo.getKeyStoreStream();
    }

    public String getKeyStorePassword() {
        return this.pinningInfo.getKeyStorePassword();
    }

    public String[] getPins() {
        return this.pinningInfo.getPins();
    }

    public long getPinCreationTimeInMillis() {
        return -1;
    }
}
