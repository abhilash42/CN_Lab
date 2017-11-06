package org.apache.xml.security.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class IgnoreAllErrorHandler implements ErrorHandler {
    static Log f4244a;
    static final boolean f4245b = System.getProperty("org.apache.xml.security.test.warn.on.exceptions", "false").equals("true");
    static final boolean f4246c = System.getProperty("org.apache.xml.security.test.throw.exceptions", "false").equals("true");
    static Class f4247d;

    static {
        Class a;
        if (f4247d == null) {
            a = m6364a("org.apache.xml.security.utils.IgnoreAllErrorHandler");
            f4247d = a;
        } else {
            a = f4247d;
        }
        f4244a = LogFactory.getLog(a.getName());
    }

    static Class m6364a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public void error(SAXParseException sAXParseException) {
        if (f4245b) {
            f4244a.error("", sAXParseException);
        }
        if (f4246c) {
            throw sAXParseException;
        }
    }

    public void fatalError(SAXParseException sAXParseException) {
        if (f4245b) {
            f4244a.warn("", sAXParseException);
        }
        if (f4246c) {
            throw sAXParseException;
        }
    }

    public void warning(SAXParseException sAXParseException) {
        if (f4245b) {
            f4244a.warn("", sAXParseException);
        }
        if (f4246c) {
            throw sAXParseException;
        }
    }
}
