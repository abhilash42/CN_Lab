package org.apache.xml.security.keys.content.x509;

import java.util.Arrays;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.utils.SignatureElementProxy;

public class XMLX509Certificate extends SignatureElementProxy implements XMLX509DataContent {
    public byte[] m6163a() {
        return m5947n();
    }

    public String mo861e() {
        return "X509Certificate";
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof XMLX509Certificate) {
            try {
                z = Arrays.equals(((XMLX509Certificate) obj).m6163a(), m6163a());
            } catch (XMLSecurityException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        int i = 17;
        try {
            byte[] a = m6163a();
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
