package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class X509IssuerSerialResolver extends KeyResolverSpi {
    static Log f4112c;
    static Class f4113d;

    static {
        Class a;
        if (f4113d == null) {
            a = m6182a("org.apache.xml.security.keys.keyresolver.implementations.X509IssuerSerialResolver");
            f4113d = a;
        } else {
            a = f4113d;
        }
        f4112c = LogFactory.getLog(a.getName());
    }

    static Class m6182a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
