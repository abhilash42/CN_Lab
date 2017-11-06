package io.fabric.sdk.android.services.network;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: NetworkUtils */
public final class C1573e {
    public static final SSLSocketFactory m5925a(C0701f c0701f) {
        SSLContext instance = SSLContext.getInstance("TLS");
        C1574g c1574g = new C1574g(new C1575h(c0701f.getKeyStoreStream(), c0701f.getKeyStorePassword()), c0701f);
        instance.init(null, new TrustManager[]{c1574g}, null);
        return instance.getSocketFactory();
    }
}
