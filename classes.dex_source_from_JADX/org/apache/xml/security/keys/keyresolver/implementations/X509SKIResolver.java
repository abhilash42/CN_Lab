package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class X509SKIResolver extends KeyResolverSpi {
    static Log f4114c;
    static Class f4115d;

    static {
        Class a;
        if (f4115d == null) {
            a = m6183a("org.apache.xml.security.keys.keyresolver.implementations.X509SKIResolver");
            f4115d = a;
        } else {
            a = f4115d;
        }
        f4114c = LogFactory.getLog(a.getName());
    }

    static Class m6183a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
