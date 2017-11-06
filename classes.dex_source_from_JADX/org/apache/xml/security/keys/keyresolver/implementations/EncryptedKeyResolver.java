package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class EncryptedKeyResolver extends KeyResolverSpi {
    static Log f4104c;
    static Class f4105d;

    static {
        Class a;
        if (f4105d == null) {
            a = m6178a("org.apache.xml.security.keys.keyresolver.implementations.RSAKeyValueResolver");
            f4105d = a;
        } else {
            a = f4105d;
        }
        f4104c = LogFactory.getLog(a.getName());
    }

    static Class m6178a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
