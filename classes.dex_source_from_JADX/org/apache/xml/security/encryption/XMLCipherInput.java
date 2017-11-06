package org.apache.xml.security.encryption;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class XMLCipherInput {
    static Class f4076a;
    private static Log f4077b;

    static {
        Class a;
        if (f4076a == null) {
            a = m6148a("org.apache.xml.security.encryption.XMLCipher");
            f4076a = a;
        } else {
            a = f4076a;
        }
        f4077b = LogFactory.getLog(a.getName());
    }

    static Class m6148a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
