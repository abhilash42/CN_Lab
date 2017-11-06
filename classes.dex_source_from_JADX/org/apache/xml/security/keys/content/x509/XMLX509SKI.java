package org.apache.xml.security.keys.content.x509;

import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.utils.SignatureElementProxy;

public class XMLX509SKI extends SignatureElementProxy implements XMLX509DataContent {
    static Log f4092a;
    static Class f4093b;

    static {
        Class a;
        if (f4093b == null) {
            a = m6169a("org.apache.xml.security.keys.content.x509.XMLX509SKI");
            f4093b = a;
        } else {
            a = f4093b;
        }
        f4092a = LogFactory.getLog(a.getName());
    }

    static Class m6169a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public byte[] m6170a() {
        return m5947n();
    }

    public String mo861e() {
        return "X509SKI";
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof XMLX509SKI) {
            try {
                z = Arrays.equals(((XMLX509SKI) obj).m6170a(), m6170a());
            } catch (XMLSecurityException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        int i = 17;
        try {
            byte[] a = m6170a();
            int i2 = 0;
            while (i2 < a.length) {
                int i3 = (i * 31) + a[i2];
                i2++;
                i = i3;
            }
        } catch (XMLSecurityException e) {
        }
        return i;
    }
}
