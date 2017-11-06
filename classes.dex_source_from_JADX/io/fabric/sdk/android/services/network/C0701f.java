package io.fabric.sdk.android.services.network;

import java.io.InputStream;

/* compiled from: PinningInfoProvider */
public interface C0701f {
    String getKeyStorePassword();

    InputStream getKeyStoreStream();

    long getPinCreationTimeInMillis();

    String[] getPins();
}
