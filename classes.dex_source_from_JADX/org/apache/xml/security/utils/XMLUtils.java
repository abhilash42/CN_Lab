package org.apache.xml.security.utils;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XMLUtils {
    static String f4263a = null;
    static String f4264b = null;
    private static boolean f4265c = ((Boolean) AccessController.doPrivileged(new C15881())).booleanValue();
    private static Map f4266d = Collections.synchronizedMap(new HashMap());

    class C15881 implements PrivilegedAction {
        C15881() {
        }

        public Object run() {
            return Boolean.valueOf(Boolean.getBoolean("org.apache.xml.security.ignoreLineBreaks"));
        }
    }

    private XMLUtils() {
    }

    public static String m6381a(Element element) {
        StringBuffer stringBuffer = new StringBuffer();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == (short) 3) {
                stringBuffer.append(((Text) item).getData());
            }
        }
        return stringBuffer.toString();
    }

    public static Document m6382a(Set set) {
        NullPointerException nullPointerException = null;
        for (Node node : set) {
            short nodeType = node.getNodeType();
            if (nodeType == (short) 9) {
                return (Document) node;
            }
            if (nodeType != (short) 2) {
                return node.getOwnerDocument();
            }
            try {
                return ((Attr) node).getOwnerElement().getOwnerDocument();
            } catch (NullPointerException e) {
                nullPointerException = e;
            }
        }
        throw new NullPointerException(new StringBuffer().append(I18n.m6349a("endorsed.jdk1.4.0")).append(" Original message was \"").append(nullPointerException == null ? "" : nullPointerException.getMessage()).append("\"").toString());
    }

    public static Element m6383a(Document document, String str) {
        if (document == null) {
            throw new RuntimeException("Document is null");
        } else if (f4263a == null || f4263a.length() == 0) {
            return document.createElementNS("http://www.w3.org/2000/09/xmldsig#", str);
        } else {
            String str2 = (String) f4266d.get(str);
            if (str2 == null) {
                StringBuffer stringBuffer = new StringBuffer(f4263a);
                stringBuffer.append(':');
                stringBuffer.append(str);
                str2 = stringBuffer.toString();
                f4266d.put(str, str2);
            }
            return document.createElementNS("http://www.w3.org/2000/09/xmldsig#", str2);
        }
    }

    public static Element m6384a(Node node) {
        Node node2 = node;
        while (node2 != null && node2.getNodeType() != (short) 1) {
            node2 = node2.getNextSibling();
        }
        return (Element) node2;
    }

    public static Element m6385a(Node node, String str, int i) {
        int i2 = i;
        Node node2 = node;
        while (node2 != null) {
            if ("http://www.w3.org/2000/09/xmldsig#".equals(node2.getNamespaceURI()) && node2.getLocalName().equals(str)) {
                if (i2 == 0) {
                    return (Element) node2;
                }
                i2--;
            }
            node2 = node2.getNextSibling();
        }
        return null;
    }

    public static Element m6386a(Node node, String str, String str2, int i) {
        int i2 = i;
        Node node2 = node;
        while (node2 != null) {
            if (node2.getNamespaceURI() != null && node2.getNamespaceURI().equals(str) && node2.getLocalName().equals(str2)) {
                if (i2 == 0) {
                    return (Element) node2;
                }
                i2--;
            }
            node2 = node2.getNextSibling();
        }
        return null;
    }

    public static void m6387a(Document document) {
        Element documentElement = document.getDocumentElement();
        if (documentElement.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns") == null) {
            documentElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "");
        }
        m6397c(document);
    }

    public static void m6388a(Node node, Set set, Node node2, boolean z) {
        if (node2 == null || !m6390a(node2, node)) {
            m6396b(node, set, node2, z);
        }
    }

    public static boolean m6389a() {
        return f4265c;
    }

    public static boolean m6390a(Node node, Node node2) {
        if (node == node2) {
            return true;
        }
        Node node3 = node2;
        while (node3 != null) {
            if (node3 == node) {
                return true;
            }
            node3 = node3.getNodeType() == (short) 2 ? ((Attr) node3).getOwnerElement() : node3.getParentNode();
        }
        return false;
    }

    public static Element[] m6391a(Node node, String str) {
        return m6392a(node, "http://www.w3.org/2000/09/xmldsig#", str);
    }

    public static Element[] m6392a(Node node, String str, String str2) {
        Object obj;
        int i = 20;
        Object obj2 = new Element[20];
        int i2 = 0;
        Node node2 = node;
        while (node2 != null) {
            Object obj3;
            int i3;
            if (node2.getNamespaceURI() != null && node2.getNamespaceURI().equals(str) && node2.getLocalName().equals(str2)) {
                int i4 = i2 + 1;
                obj2[i2] = (Element) node2;
                if (i <= i4) {
                    i2 = i << 2;
                    obj = new Element[i2];
                    System.arraycopy(obj2, 0, obj, 0, i);
                    int i5 = i4;
                    obj3 = obj;
                    i3 = i5;
                } else {
                    i3 = i4;
                    i2 = i;
                    obj3 = obj2;
                }
            } else {
                i3 = i2;
                obj3 = obj2;
                i2 = i;
            }
            node2 = node2.getNextSibling();
            obj2 = obj3;
            i = i2;
            i2 = i3;
        }
        obj = new Element[i2];
        System.arraycopy(obj2, 0, obj, 0, i2);
        return obj;
    }

    public static Document m6393b(Node node) {
        if (node.getNodeType() == (short) 9) {
            return (Document) node;
        }
        try {
            return node.getOwnerDocument();
        } catch (NullPointerException e) {
            throw new NullPointerException(new StringBuffer().append(I18n.m6349a("endorsed.jdk1.4.0")).append(" Original message was \"").append(e.getMessage()).append("\"").toString());
        }
    }

    public static Text m6394b(Node node, String str, int i) {
        Node a = m6385a(node, str, i);
        if (a == null) {
            return null;
        }
        a = a.getFirstChild();
        while (a != null && a.getNodeType() != (short) 3) {
            a = a.getNextSibling();
        }
        return (Text) a;
    }

    public static void m6395b(Element element) {
        if (!f4265c) {
            element.appendChild(element.getOwnerDocument().createTextNode("\n"));
        }
    }

    static final void m6396b(Node node, Set set, Node node2, boolean z) {
        if (node != node2) {
            switch (node.getNodeType()) {
                case (short) 1:
                    set.add(node);
                    if (((Element) node).hasAttributes()) {
                        NamedNodeMap attributes = ((Element) node).getAttributes();
                        for (int i = 0; i < attributes.getLength(); i++) {
                            set.add(attributes.item(i));
                        }
                        break;
                    }
                    break;
                case (short) 8:
                    if (z) {
                        set.add(node);
                        return;
                    }
                    return;
                case (short) 9:
                    break;
                case (short) 10:
                    return;
                default:
                    set.add(node);
                    return;
            }
            Node firstChild = node.getFirstChild();
            while (firstChild != null) {
                if (firstChild.getNodeType() == (short) 3) {
                    set.add(firstChild);
                    while (firstChild != null && firstChild.getNodeType() == (short) 3) {
                        firstChild = firstChild.getNextSibling();
                    }
                    if (firstChild == null) {
                        return;
                    }
                }
                m6396b(firstChild, set, node2, z);
                firstChild = firstChild.getNextSibling();
            }
        }
    }

    private static void m6397c(Node node) {
        Node node2 = null;
        Node node3 = null;
        Node node4 = node;
        while (true) {
            switch (node4.getNodeType()) {
                case (short) 1:
                    Element element = (Element) node4;
                    if (!element.hasChildNodes()) {
                        node = node2;
                        node4 = node3;
                        break;
                    } else if (element.hasAttributes()) {
                        NamedNodeMap attributes = element.getAttributes();
                        int length = attributes.getLength();
                        for (node2 = element.getFirstChild(); node2 != null; node2 = node2.getNextSibling()) {
                            if (node2.getNodeType() == (short) 1) {
                                element = (Element) node2;
                                for (int i = 0; i < length; i++) {
                                    Attr attr = (Attr) attributes.item(i);
                                    if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI()) && !element.hasAttributeNS("http://www.w3.org/2000/xmlns/", attr.getLocalName())) {
                                        element.setAttributeNS("http://www.w3.org/2000/xmlns/", attr.getName(), attr.getNodeValue());
                                    }
                                }
                            }
                        }
                    }
                case (short) 5:
                case (short) 9:
                    node = node4.getFirstChild();
                    break;
                default:
                    node = node2;
                    node4 = node3;
                    break;
            }
            while (node == null && node4 != null) {
                node2 = node4.getNextSibling();
                node4 = node4.getParentNode();
                node = node2;
            }
            if (node != null) {
                node2 = node.getNextSibling();
                node3 = node4;
                node4 = node;
            } else {
                return;
            }
        }
    }
}
