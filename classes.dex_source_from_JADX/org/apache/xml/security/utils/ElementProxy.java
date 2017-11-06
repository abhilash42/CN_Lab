package org.apache.xml.security.utils;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public abstract class ElementProxy {
    static Log f3962j;
    static HashMap f3963n = new HashMap();
    static HashMap f3964o = new HashMap();
    static Class f3965p;
    protected Element f3966k = null;
    protected String f3967l = null;
    protected Document f3968m = null;

    static {
        Class c;
        if (f3965p == null) {
            c = m5938c("org.apache.xml.security.utils.ElementProxy");
            f3965p = c;
        } else {
            c = f3965p;
        }
        f3962j = LogFactory.getLog(c.getName());
    }

    public ElementProxy(Element element, String str) {
        if (element == null) {
            throw new XMLSecurityException("ElementProxy.nullElement");
        }
        if (f3962j.isDebugEnabled()) {
            f3962j.debug(new StringBuffer().append("setElement(\"").append(element.getTagName()).append("\", \"").append(str).append("\")").toString());
        }
        this.f3968m = element.getOwnerDocument();
        this.f3966k = element;
        this.f3967l = str;
        m5946m();
    }

    static Class m5938c(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void m5939d(String str, String str2) {
        if (f3963n.containsValue(str2)) {
            if (!f3963n.get(str).equals(str2)) {
                throw new XMLSecurityException("prefix.AlreadyAssigned", new Object[]{str2, str, f3963n.get(str)});
            }
        }
        if ("http://www.w3.org/2000/09/xmldsig#".equals(str)) {
            XMLUtils.f4263a = str2;
        }
        if ("http://www.w3.org/2001/04/xmlenc#".equals(str)) {
            XMLUtils.f4264b = str2;
        }
        f3963n.put(str, str2.intern());
        if (str2.length() == 0) {
            f3964o.put(str, "xmlns");
        } else {
            f3964o.put(str, new StringBuffer().append("xmlns:").append(str2).toString().intern());
        }
    }

    public String m5940b(String str, String str2) {
        return ((Text) XMLUtils.m6386a(this.f3966k.getFirstChild(), str2, str, 0).getFirstChild()).getData();
    }

    public int m5941c(String str, String str2) {
        int i = 0;
        Node firstChild = this.f3966k.getFirstChild();
        while (firstChild != null) {
            if (str2.equals(firstChild.getLocalName()) && str.equals(firstChild.getNamespaceURI())) {
                i++;
            }
            firstChild = firstChild.getNextSibling();
        }
        return i;
    }

    public abstract String mo860d();

    public abstract String mo861e();

    public final Element m5944k() {
        return this.f3966k;
    }

    public String m5945l() {
        return this.f3967l;
    }

    void m5946m() {
        String e = mo861e();
        String d = mo860d();
        String localName = this.f3966k.getLocalName();
        if (!d.equals(this.f3966k.getNamespaceURI()) && !e.equals(localName)) {
            throw new XMLSecurityException("xml.WrongElement", new Object[]{new StringBuffer().append(r3).append(":").append(localName).toString(), new StringBuffer().append(d).append(":").append(e).toString()});
        }
    }

    public byte[] m5947n() {
        return Base64.m6328a(XMLUtils.m6381a(this.f3966k));
    }

    public String m5948o() {
        return XMLUtils.m6381a(this.f3966k);
    }
}
