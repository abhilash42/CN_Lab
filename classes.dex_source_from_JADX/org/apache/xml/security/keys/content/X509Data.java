package org.apache.xml.security.keys.content;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.SignatureElementProxy;

public class X509Data extends SignatureElementProxy implements KeyInfoContent {
    static Log f4088a;
    static Class f4089b;

    static {
        Class a;
        if (f4089b == null) {
            a = m6158a("org.apache.xml.security.keys.content.X509Data");
            f4089b = a;
        } else {
            a = f4089b;
        }
        f4088a = LogFactory.getLog(a.getName());
    }

    static Class m6158a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public String mo861e() {
        return "X509Data";
    }
}
