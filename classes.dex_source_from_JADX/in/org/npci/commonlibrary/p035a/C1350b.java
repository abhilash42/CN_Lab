package in.org.npci.commonlibrary.p035a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class C1350b {
    private Certificate f3138a;

    public C1350b() {
        try {
            this.f3138a = m5161b("signer.crt");
        } catch (CertificateException e) {
            System.out.println("Error in loading exception");
            e.printStackTrace();
        }
    }

    private Certificate m5161b(String str) {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(str);
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

    public boolean m5162a(String str) {
        boolean a;
        Exception e;
        if (this.f3138a == null) {
            try {
                this.f3138a = m5161b("signer.crt");
            } catch (CertificateException e2) {
                System.out.println("Error in loading certificate.");
                e2.printStackTrace();
                return false;
            }
        }
        try {
            a = C1349a.m5160a(C1349a.m5159a(str), this.f3138a.getPublicKey());
        } catch (SAXException e3) {
            e = e3;
            System.err.println("Parsing failed for message:" + str);
            e.printStackTrace();
            a = false;
        } catch (ParserConfigurationException e4) {
            e = e4;
            System.err.println("Parsing failed for message:" + str);
            e.printStackTrace();
            a = false;
        } catch (Exception e5) {
            e5.printStackTrace();
            a = false;
        }
        return a;
    }
}
