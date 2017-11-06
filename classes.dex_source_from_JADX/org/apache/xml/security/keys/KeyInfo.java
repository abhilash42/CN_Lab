package org.apache.xml.security.keys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.w3c.dom.Element;

public class KeyInfo extends SignatureElementProxy {
    static Log f4080a;
    static final List f4081d;
    static boolean f4082g = false;
    static Class f4083h;
    List f4084b = null;
    List f4085c = null;
    List f4086e = null;
    List f4087f = f4081d;

    static {
        Class a;
        if (f4083h == null) {
            a = m6149a("org.apache.xml.security.keys.KeyInfo");
            f4083h = a;
        } else {
            a = f4083h;
        }
        f4080a = LogFactory.getLog(a.getName());
        List arrayList = new ArrayList();
        arrayList.add(null);
        f4081d = Collections.unmodifiableList(arrayList);
    }

    public KeyInfo(Element element, String str) {
        super(element, str);
    }

    static Class m6149a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void m6150a() {
        if (!f4082g) {
            if (f4080a == null) {
                Class a;
                if (f4083h == null) {
                    a = m6149a("org.apache.xml.security.keys.KeyInfo");
                    f4083h = a;
                } else {
                    a = f4083h;
                }
                f4080a = LogFactory.getLog(a.getName());
                f4080a.error("Had to assign log in the init() function");
            }
            f4082g = true;
        }
    }

    public String mo861e() {
        return "KeyInfo";
    }
}
