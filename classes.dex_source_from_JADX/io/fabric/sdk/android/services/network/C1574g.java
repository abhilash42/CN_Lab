package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.C1457c;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: PinningTrustManager */
class C1574g implements X509TrustManager {
    private static final X509Certificate[] f3951a = new X509Certificate[0];
    private final TrustManager[] f3952b;
    private final C1575h f3953c;
    private final long f3954d;
    private final List<byte[]> f3955e = new LinkedList();
    private final Set<X509Certificate> f3956f = Collections.synchronizedSet(new HashSet());

    public C1574g(C1575h c1575h, C0701f c0701f) {
        this.f3952b = m5930a(c1575h);
        this.f3953c = c1575h;
        this.f3954d = c0701f.getPinCreationTimeInMillis();
        for (String a : c0701f.getPins()) {
            this.f3955e.add(m5929a(a));
        }
    }

    private TrustManager[] m5930a(C1575h c1575h) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(c1575h.f3957a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean m5928a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f3955e) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private void m5927a(X509Certificate[] x509CertificateArr, String str) {
        for (TrustManager trustManager : this.f3952b) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void m5926a(X509Certificate[] x509CertificateArr) {
        if (this.f3954d == -1 || System.currentTimeMillis() - this.f3954d <= 15552000000L) {
            X509Certificate[] a = C1568a.m5914a(x509CertificateArr, this.f3953c);
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!m5928a(a[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        C1457c.m5546h().mo816d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f3954d) + " millis vs " + 15552000000L + " millis) " + "falling back to system trust.");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.f3956f.contains(x509CertificateArr[0])) {
            m5927a(x509CertificateArr, str);
            m5926a(x509CertificateArr);
            this.f3956f.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f3951a;
    }

    private byte[] m5929a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
