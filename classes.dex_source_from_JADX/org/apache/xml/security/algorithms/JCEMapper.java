package org.apache.xml.security.algorithms;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;

public class JCEMapper {
    static Log f3972a;
    static Class f3973b;
    private static Map f3974c;
    private static Map f3975d;
    private static String f3976e = null;

    public class Algorithm {
        String f3969a;
        String f3970b;
        String f3971c;

        public Algorithm(Element element) {
            this.f3969a = element.getAttribute("AlgorithmClass");
            this.f3970b = element.getAttribute("KeyLength");
            this.f3971c = element.getAttribute("RequiredKey");
        }
    }

    static {
        Class b;
        if (f3973b == null) {
            b = m5955b("org.apache.xml.security.algorithms.JCEMapper");
            f3973b = b;
        } else {
            b = f3973b;
        }
        f3972a = LogFactory.getLog(b.getName());
    }

    public static String m5952a() {
        return f3976e;
    }

    public static String m5953a(String str) {
        if (f3972a.isDebugEnabled()) {
            f3972a.debug(new StringBuffer().append("Request for URI ").append(str).toString());
        }
        return (String) f3974c.get(str);
    }

    public static void m5954a(Element element) {
        m5956b((Element) element.getElementsByTagName("Algorithms").item(0));
    }

    static Class m5955b(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    static void m5956b(Element element) {
        Element[] a = XMLUtils.m6392a(element.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "Algorithm");
        f3974c = new HashMap(a.length * 2);
        f3975d = new HashMap(a.length * 2);
        for (Element element2 : a) {
            String attribute = element2.getAttribute("URI");
            f3974c.put(attribute, element2.getAttribute("JCEName"));
            f3975d.put(attribute, new Algorithm(element2));
        }
    }
}
