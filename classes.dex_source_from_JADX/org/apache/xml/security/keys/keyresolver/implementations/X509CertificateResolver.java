package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class X509CertificateResolver extends KeyResolverSpi {
    static Log f4110c;
    static Class f4111d;

    static {
        Class a;
        if (f4111d == null) {
            a = m6181a("org.apache.xml.security.keys.keyresolver.implementations.X509CertificateResolver");
            f4111d = a;
        } else {
            a = f4111d;
        }
        f4110c = LogFactory.getLog(a.getName());
    }

    static Class m6181a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
