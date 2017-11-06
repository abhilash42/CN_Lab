package org.apache.xml.security.keys.keyresolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.keyresolver.KeyResolverSpi;

public class RetrievalMethodResolver extends KeyResolverSpi {
    static Log f4108c;
    static Class f4109d;

    static {
        Class a;
        if (f4109d == null) {
            a = m6180a("org.apache.xml.security.keys.keyresolver.implementations.RetrievalMethodResolver");
            f4109d = a;
        } else {
            a = f4109d;
        }
        f4108c = LogFactory.getLog(a.getName());
    }

    static Class m6180a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
