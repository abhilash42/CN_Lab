package in.org.npci.commonlibrary;

import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class C1362l {
    private static Certificate f3184a;

    static {
        try {
            f3184a = C1358h.m5178a("signer.crt");
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

    public static PublicKey m5190a() {
        return f3184a != null ? f3184a.getPublicKey() : null;
    }
}
