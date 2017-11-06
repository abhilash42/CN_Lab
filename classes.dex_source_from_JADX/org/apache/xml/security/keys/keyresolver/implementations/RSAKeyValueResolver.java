package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class RSAKeyValueResolver extends KeyResolverSpi {
    static Log f4106c;
    static Class f4107d;

    static {
        Class a;
        if (f4107d == null) {
            a = m6179a("org.apache.xml.security.keys.keyresolver.implementations.RSAKeyValueResolver");
            f4107d = a;
        } else {
            a = f4107d;
        }
        f4106c = LogFactory.getLog(a.getName());
    }

    static Class m6179a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
