package org.apache.xml.security.keys.content.x509;

import java.math.BigInteger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.RFC2253Parser;
import org.apache.xml.security.utils.SignatureElementProxy;

public class XMLX509IssuerSerial extends SignatureElementProxy implements XMLX509DataContent {
    static Log f4090a;
    static Class f4091b;

    static {
        Class a;
        if (f4091b == null) {
            a = m6165a("org.apache.xml.security.keys.content.x509.XMLX509IssuerSerial");
            f4091b = a;
        } else {
            a = f4091b;
        }
        f4090a = LogFactory.getLog(a.getName());
    }

    static Class m6165a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public BigInteger m6166a() {
        String b = m5940b("X509SerialNumber", "http://www.w3.org/2000/09/xmldsig#");
        if (f4090a.isDebugEnabled()) {
            f4090a.debug(new StringBuffer().append("X509SerialNumber text: ").append(b).toString());
        }
        return new BigInteger(b);
    }

    public String m6167b() {
        return RFC2253Parser.m6368a(m5940b("X509IssuerName", "http://www.w3.org/2000/09/xmldsig#"));
    }

    public String mo861e() {
        return "X509IssuerSerial";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XMLX509IssuerSerial)) {
            return false;
        }
        XMLX509IssuerSerial xMLX509IssuerSerial = (XMLX509IssuerSerial) obj;
        return m6166a().equals(xMLX509IssuerSerial.m6166a()) && m6167b().equals(xMLX509IssuerSerial.m6167b());
    }

    public int hashCode() {
        return ((m6166a().hashCode() + 527) * 31) + m6167b().hashCode();
    }
}
