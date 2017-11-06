package in.org.npci.commonlibrary;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class C1358h {
    public static Certificate m5178a(String str) {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        InputStream resourceAsStream = C1358h.class.getClassLoader().getResourceAsStream(str);
        InputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
        try {
            Certificate generateCertificate = instance.generateCertificate(bufferedInputStream);
            try {
                resourceAsStream.close();
            } catch (IOException e) {
            }
            return generateCertificate;
        } finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e2) {
            }
            try {
                resourceAsStream.close();
            } catch (IOException e3) {
            }
        }
    }
}
