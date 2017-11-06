package org.apache.xml.security.utils;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class IdResolver {
    static Class f4239a;
    private static Log f4240b;
    private static WeakHashMap f4241c = new WeakHashMap();
    private static List f4242d = Arrays.asList(new String[]{"http://www.w3.org/2000/09/xmldsig#", "http://www.w3.org/2001/04/xmlenc#", "http://schemas.xmlsoap.org/soap/security/2000-12", "http://www.w3.org/2002/03/xkms#", "urn:oasis:names:tc:SAML:1.0:assertion", "urn:oasis:names:tc:SAML:1.0:protocol"});
    private static int f4243e = f4242d.size();

    static {
        Class a;
        if (f4239a == null) {
            a = m6358a("org.apache.xml.security.utils.IdResolver");
            f4239a = a;
        } else {
            a = f4239a;
        }
        f4240b = LogFactory.getLog(a.getName());
    }

    private IdResolver() {
    }

    public static int m6356a(Element element, String str, Element[] elementArr) {
        if (!element.hasAttributes()) {
            return 0;
        }
        NamedNodeMap attributes = element.getAttributes();
        int indexOf = f4242d.indexOf(element.getNamespaceURI());
        int i = indexOf < 0 ? f4243e : indexOf;
        int length = attributes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            Attr attr = (Attr) attributes.item(i2);
            int indexOf2 = attr.getNamespaceURI() == null ? i : f4242d.indexOf(attr.getNamespaceURI());
            if (indexOf2 < 0) {
                indexOf2 = f4243e;
            }
            String localName = attr.getLocalName();
            if (localName == null) {
                localName = attr.getName();
            }
            if (localName.length() <= 2) {
                String nodeValue = attr.getNodeValue();
                if (localName.charAt(0) == 'I') {
                    char charAt = localName.charAt(1);
                    if (charAt == 'd' && nodeValue.equals(str)) {
                        elementArr[indexOf2] = element;
                        if (indexOf2 == 0) {
                            return 1;
                        }
                    } else if (charAt == 'D' && nodeValue.endsWith(str)) {
                        if (indexOf2 != 3) {
                            indexOf2 = f4243e;
                        }
                        elementArr[indexOf2] = element;
                    }
                } else if ("id".equals(localName) && nodeValue.equals(str)) {
                    if (indexOf2 != 2) {
                        indexOf2 = f4243e;
                    }
                    elementArr[indexOf2] = element;
                }
            }
        }
        if (i == 3 && (element.getAttribute("OriginalRequestID").equals(str) || element.getAttribute("RequestID").equals(str) || element.getAttribute("ResponseID").equals(str))) {
            elementArr[3] = element;
        } else if (i == 4 && element.getAttribute("AssertionID").equals(str)) {
            elementArr[4] = element;
        } else if (i == 5 && (element.getAttribute("RequestID").equals(str) || element.getAttribute("ResponseID").equals(str))) {
            elementArr[5] = element;
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m6357a(org.w3c.dom.Node r6, java.lang.String r7, org.w3c.dom.Element[] r8) {
        /*
        r3 = 0;
        r5 = 1;
        r2 = r3;
        r0 = r3;
        r1 = r6;
    L_0x0005:
        r4 = r1.getNodeType();
        switch(r4) {
            case 1: goto L_0x002a;
            case 9: goto L_0x0024;
            case 11: goto L_0x0024;
            default: goto L_0x000c;
        };
    L_0x000c:
        r6 = r0;
        r0 = r2;
    L_0x000e:
        if (r6 != 0) goto L_0x0042;
    L_0x0010:
        if (r0 == 0) goto L_0x0042;
    L_0x0012:
        r6 = r0.getNextSibling();
        r2 = r0.getParentNode();
        if (r2 == 0) goto L_0x004e;
    L_0x001c:
        r0 = r2.getNodeType();
        if (r5 == r0) goto L_0x004e;
    L_0x0022:
        r0 = r3;
        goto L_0x000e;
    L_0x0024:
        r6 = r1.getFirstChild();
        r0 = r2;
        goto L_0x000e;
    L_0x002a:
        r0 = r1;
        r0 = (org.w3c.dom.Element) r0;
        r4 = m6356a(r0, r7, r8);
        if (r4 != r5) goto L_0x0034;
    L_0x0033:
        return r5;
    L_0x0034:
        r6 = r1.getFirstChild();
        if (r6 != 0) goto L_0x000e;
    L_0x003a:
        if (r2 == 0) goto L_0x004c;
    L_0x003c:
        r6 = r1.getNextSibling();
        r0 = r2;
        goto L_0x000e;
    L_0x0042:
        if (r6 == 0) goto L_0x0033;
    L_0x0044:
        r1 = r6.getNextSibling();
        r2 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0005;
    L_0x004c:
        r0 = r2;
        goto L_0x000e;
    L_0x004e:
        r0 = r2;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.utils.IdResolver.a(org.w3c.dom.Node, java.lang.String, org.w3c.dom.Element[]):int");
    }

    static Class m6358a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static Element m6359a(Document document, String str) {
        Element c = m6363c(document, str);
        if (c != null) {
            f4240b.debug(new StringBuffer().append("I could find an Element using the simple getElementByIdType method: ").append(c.getTagName()).toString());
            return c;
        }
        c = m6362b(document, str);
        if (c != null) {
            f4240b.debug(new StringBuffer().append("I could find an Element using the simple getElementByIdUsingDOM method: ").append(c.getTagName()).toString());
            return c;
        }
        c = m6360a((Node) document, str);
        if (c == null) {
            return null;
        }
        m6361a(c, str);
        return c;
    }

    private static Element m6360a(Node node, String str) {
        Element[] elementArr = new Element[(f4243e + 1)];
        m6357a(node, str, elementArr);
        for (int i = 0; i < elementArr.length; i++) {
            if (elementArr[i] != null) {
                return elementArr[i];
            }
        }
        return null;
    }

    public static void m6361a(Element element, String str) {
        WeakHashMap weakHashMap;
        Document ownerDocument = element.getOwnerDocument();
        synchronized (f4241c) {
            weakHashMap = (WeakHashMap) f4241c.get(ownerDocument);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap();
                f4241c.put(ownerDocument, weakHashMap);
            }
        }
        weakHashMap.put(str, new WeakReference(element));
    }

    private static Element m6362b(Document document, String str) {
        if (f4240b.isDebugEnabled()) {
            f4240b.debug(new StringBuffer().append("getElementByIdUsingDOM() Search for ID ").append(str).toString());
        }
        return document.getElementById(str);
    }

    private static Element m6363c(Document document, String str) {
        if (f4240b.isDebugEnabled()) {
            f4240b.debug(new StringBuffer().append("getElementByIdType() Search for ID ").append(str).toString());
        }
        synchronized (f4241c) {
            WeakHashMap weakHashMap = (WeakHashMap) f4241c.get(document);
        }
        if (weakHashMap != null) {
            WeakReference weakReference = (WeakReference) weakHashMap.get(str);
            if (weakReference != null) {
                return (Element) weakReference.get();
            }
        }
        return null;
    }
}
