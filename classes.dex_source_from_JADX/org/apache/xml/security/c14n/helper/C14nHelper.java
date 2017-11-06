package org.apache.xml.security.c14n.helper;

import org.w3c.dom.Attr;

public class C14nHelper {
    private C14nHelper() {
    }

    public static boolean m6064a(String str) {
        return !m6066b(str);
    }

    public static boolean m6065a(Attr attr) {
        return !m6067b(attr);
    }

    public static boolean m6066b(String str) {
        return str.length() == 0 || str.indexOf(58) > 0;
    }

    public static boolean m6067b(Attr attr) {
        return m6066b(attr.getValue());
    }
}
