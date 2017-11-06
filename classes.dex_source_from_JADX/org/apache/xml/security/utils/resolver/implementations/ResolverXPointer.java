package org.apache.xml.security.utils.resolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.IdResolver;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ResolverXPointer extends ResourceResolverSpi {
    static Log f4287d;
    static Class f4288e;
    private static final int f4289f = "#xpointer(id(".length();

    static {
        Class c;
        if (f4288e == null) {
            c = m6430c("org.apache.xml.security.utils.resolver.implementations.ResolverXPointer");
            f4288e = c;
        } else {
            c = f4288e;
        }
        f4287d = LogFactory.getLog(c.getName());
    }

    static Class m6430c(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static boolean m6431d(String str) {
        return str.equals("#xpointer(/)");
    }

    private static boolean m6432e(String str) {
        if (str.startsWith("#xpointer(id(") && str.endsWith("))")) {
            String substring = str.substring(f4289f, str.length() - 2);
            int length = substring.length() - 1;
            if ((substring.charAt(0) == '\"' && substring.charAt(length) == '\"') || (substring.charAt(0) == '\'' && substring.charAt(length) == '\'')) {
                if (!f4287d.isDebugEnabled()) {
                    return true;
                }
                f4287d.debug(new StringBuffer().append("Id=").append(substring.substring(1, length)).toString());
                return true;
            }
        }
        return false;
    }

    private static String m6433f(String str) {
        if (str.startsWith("#xpointer(id(") && str.endsWith("))")) {
            String substring = str.substring(f4289f, str.length() - 2);
            int length = substring.length() - 1;
            if ((substring.charAt(0) == '\"' && substring.charAt(length) == '\"') || (substring.charAt(0) == '\'' && substring.charAt(length) == '\'')) {
                return substring.substring(1, length);
            }
        }
        return null;
    }

    public XMLSignatureInput mo887a(Attr attr, String str) {
        Node a;
        Document ownerDocument = attr.getOwnerElement().getOwnerDocument();
        String nodeValue = attr.getNodeValue();
        if (!m6431d(nodeValue)) {
            if (m6432e(nodeValue)) {
                a = IdResolver.m6359a(ownerDocument, m6433f(nodeValue));
                if (a == null) {
                    throw new ResourceResolverException("signature.Verification.MissingID", new Object[]{r1}, attr, str);
                }
            }
            a = null;
        }
        XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(a);
        xMLSignatureInput.m6231a("text/xml");
        if (str == null || str.length() <= 0) {
            xMLSignatureInput.m6239b(attr.getNodeValue());
        } else {
            xMLSignatureInput.m6239b(str.concat(attr.getNodeValue()));
        }
        return xMLSignatureInput;
    }

    public boolean mo889a() {
        return true;
    }

    public boolean mo888b(Attr attr, String str) {
        if (attr == null) {
            return false;
        }
        String nodeValue = attr.getNodeValue();
        return m6431d(nodeValue) || m6432e(nodeValue);
    }
}
