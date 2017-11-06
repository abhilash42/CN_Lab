package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class X509SubjectNameResolver extends KeyResolverSpi {
    static Log f4116c;
    static Class f4117d;

    static {
        Class a;
        if (f4117d == null) {
            a = m6184a("org.apache.xml.security.keys.keyresolver.implementations.X509SubjectNameResolver");
            f4117d = a;
        } else {
            a = f4117d;
        }
        f4116c = LogFactory.getLog(a.getName());
    }

    static Class m6184a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
