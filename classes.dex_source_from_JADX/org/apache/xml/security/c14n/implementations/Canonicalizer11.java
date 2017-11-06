package org.apache.xml.security.c14n.implementations;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.helper.C14nHelper;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public abstract class Canonicalizer11 extends CanonicalizerBase {
    static Log f4040d;
    static Class f4041f;
    boolean f4042b = true;
    final SortedSet f4043c = new TreeSet(g);
    XmlAttrStack f4044e = new XmlAttrStack();

    class XmlAttrStack {
        int f4016a = 0;
        int f4017b = 0;
        XmlsStackElement f4018c;
        List f4019d = new ArrayList();

        class XmlsStackElement {
            int f4013a;
            boolean f4014b = false;
            List f4015c = new ArrayList();

            XmlsStackElement() {
            }
        }

        XmlAttrStack() {
        }

        void m6068a(int i) {
            this.f4016a = i;
            if (this.f4016a != -1) {
                this.f4018c = null;
                while (this.f4017b >= this.f4016a) {
                    this.f4019d.remove(this.f4019d.size() - 1);
                    if (this.f4019d.size() == 0) {
                        this.f4017b = 0;
                        return;
                    }
                    this.f4017b = ((XmlsStackElement) this.f4019d.get(this.f4019d.size() - 1)).f4013a;
                }
            }
        }

        void m6069a(Collection collection) {
            boolean z;
            String str = null;
            if (this.f4018c == null) {
                this.f4018c = new XmlsStackElement();
                this.f4018c.f4013a = this.f4016a;
                this.f4017b = this.f4016a;
                this.f4019d.add(this.f4018c);
            }
            int size = this.f4019d.size() - 2;
            if (size == -1) {
                z = true;
            } else {
                XmlsStackElement xmlsStackElement = (XmlsStackElement) this.f4019d.get(size);
                z = xmlsStackElement.f4014b && xmlsStackElement.f4013a + 1 == this.f4016a;
            }
            if (z) {
                collection.addAll(this.f4018c.f4015c);
                this.f4018c.f4014b = true;
                return;
            }
            Map hashMap = new HashMap();
            List<Attr> arrayList = new ArrayList();
            boolean z2 = true;
            for (int i = size; i >= 0; i--) {
                xmlsStackElement = (XmlsStackElement) this.f4019d.get(i);
                boolean z3 = xmlsStackElement.f4014b ? false : z2;
                Iterator it = xmlsStackElement.f4015c.iterator();
                while (it.hasNext() && z3) {
                    Attr attr = (Attr) it.next();
                    if (attr.getLocalName().equals("base")) {
                        if (!xmlsStackElement.f4014b) {
                            arrayList.add(attr);
                        }
                    } else if (!hashMap.containsKey(attr.getName())) {
                        hashMap.put(attr.getName(), attr);
                    }
                }
                z2 = z3;
            }
            if (!arrayList.isEmpty()) {
                for (Attr attr2 : this.f4018c.f4015c) {
                    if (attr2.getLocalName().equals("base")) {
                        str = attr2.getValue();
                        break;
                    }
                }
                Attr attr22 = null;
                attr = attr22;
                for (Attr attr222 : arrayList) {
                    if (str == null) {
                        str = attr222.getValue();
                        attr = attr222;
                    } else {
                        try {
                            str = Canonicalizer11.m6092a(attr222.getValue(), str);
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (!(str == null || str.length() == 0)) {
                    attr.setValue(str);
                    collection.add(attr);
                }
            }
            this.f4018c.f4014b = true;
            collection.addAll(hashMap.values());
        }

        void m6070a(Attr attr) {
            if (this.f4018c == null) {
                this.f4018c = new XmlsStackElement();
                this.f4018c.f4013a = this.f4016a;
                this.f4019d.add(this.f4018c);
                this.f4017b = this.f4016a;
            }
            this.f4018c.f4015c.add(attr);
        }
    }

    static {
        Class a;
        if (f4041f == null) {
            a = m6091a("org.apache.xml.security.c14n.implementations.Canonicalizer11");
            f4041f = a;
        } else {
            a = f4041f;
        }
        f4040d = LogFactory.getLog(a.getName());
    }

    public Canonicalizer11(boolean z) {
        super(z);
    }

    static Class m6091a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    static String m6092a(String str, String str2) {
        return m6095b(str, str2);
    }

    private static void m6093a(String str, String str2, String str3) {
        if (f4040d.isDebugEnabled()) {
            f4040d.debug(new StringBuffer().append(" ").append(str).append(":   ").append(str2).toString());
            if (str2.length() == 0) {
                f4040d.debug(new StringBuffer().append("\t\t\t\t").append(str3).toString());
            } else {
                f4040d.debug(new StringBuffer().append("\t\t\t").append(str3).toString());
            }
        }
    }

    private static String m6094b(String str) {
        f4040d.debug("STEP   OUTPUT BUFFER\t\tINPUT BUFFER");
        while (str.indexOf("//") > -1) {
            str = str.replaceAll("//", "/");
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (str.charAt(0) == '/') {
            stringBuffer.append("/");
            str = str.substring(1);
        }
        m6093a("1 ", stringBuffer.toString(), str);
        while (str.length() != 0) {
            if (str.startsWith("./")) {
                str = str.substring(2);
                m6093a("2A", stringBuffer.toString(), str);
            } else if (str.startsWith("../")) {
                str = str.substring(3);
                if (!stringBuffer.toString().equals("/")) {
                    stringBuffer.append("../");
                }
                m6093a("2A", stringBuffer.toString(), str);
            } else if (str.startsWith("/./")) {
                str = str.substring(2);
                m6093a("2B", stringBuffer.toString(), str);
            } else if (str.equals("/.")) {
                str = str.replaceFirst("/.", "/");
                m6093a("2B", stringBuffer.toString(), str);
            } else if (str.startsWith("/../")) {
                str = str.substring(3);
                if (stringBuffer.length() == 0) {
                    stringBuffer.append("/");
                } else if (stringBuffer.toString().endsWith("../")) {
                    stringBuffer.append("..");
                } else if (stringBuffer.toString().endsWith("..")) {
                    stringBuffer.append("/..");
                } else {
                    r1 = stringBuffer.lastIndexOf("/");
                    if (r1 == -1) {
                        stringBuffer = new StringBuffer();
                        if (str.charAt(0) == '/') {
                            str = str.substring(1);
                        }
                    } else {
                        stringBuffer = stringBuffer.delete(r1, stringBuffer.length());
                    }
                }
                m6093a("2C", stringBuffer.toString(), str);
            } else if (str.equals("/..")) {
                str = str.replaceFirst("/..", "/");
                if (stringBuffer.length() == 0) {
                    stringBuffer.append("/");
                } else if (stringBuffer.toString().endsWith("../")) {
                    stringBuffer.append("..");
                } else if (stringBuffer.toString().endsWith("..")) {
                    stringBuffer.append("/..");
                } else {
                    r1 = stringBuffer.lastIndexOf("/");
                    if (r1 == -1) {
                        stringBuffer = new StringBuffer();
                        if (str.charAt(0) == '/') {
                            str = str.substring(1);
                        }
                    } else {
                        stringBuffer = stringBuffer.delete(r1, stringBuffer.length());
                    }
                }
                m6093a("2C", stringBuffer.toString(), str);
            } else if (str.equals(".")) {
                str = "";
                m6093a("2D", stringBuffer.toString(), str);
            } else if (str.equals("..")) {
                if (!stringBuffer.toString().equals("/")) {
                    stringBuffer.append("..");
                }
                str = "";
                m6093a("2D", stringBuffer.toString(), str);
            } else {
                int indexOf;
                String substring;
                r1 = str.indexOf(47);
                if (r1 == 0) {
                    indexOf = str.indexOf(47, 1);
                } else {
                    indexOf = r1;
                    r1 = 0;
                }
                if (indexOf == -1) {
                    substring = str.substring(r1);
                    str = "";
                } else {
                    substring = str.substring(r1, indexOf);
                    str = str.substring(indexOf);
                }
                stringBuffer.append(substring);
                m6093a("2E", stringBuffer.toString(), str);
            }
        }
        if (stringBuffer.toString().endsWith("..")) {
            stringBuffer.append("/");
            m6093a("3 ", stringBuffer.toString(), str);
        }
        return stringBuffer.toString();
    }

    private static String m6095b(String str, String str2) {
        String scheme;
        String authority;
        String path;
        String str3 = "";
        if (str != null) {
            if (str.endsWith("..")) {
                str = new StringBuffer().append(str).append("/").toString();
            }
            URI uri = new URI(str);
            scheme = uri.getScheme();
            authority = uri.getAuthority();
            path = uri.getPath();
            str3 = uri.getQuery();
            uri.getFragment();
        } else {
            path = str3;
            authority = null;
            scheme = null;
            str3 = null;
        }
        URI uri2 = new URI(str2);
        String scheme2 = uri2.getScheme();
        String authority2 = uri2.getAuthority();
        String path2 = uri2.getPath();
        String query = uri2.getQuery();
        if (scheme2 != null && scheme2.equals(scheme)) {
            scheme2 = null;
        }
        if (scheme2 != null) {
            scheme = m6094b(path2);
            path2 = query;
            authority = authority2;
            path = scheme2;
        } else {
            if (authority2 != null) {
                path = m6094b(path2);
                authority = authority2;
            } else {
                if (path2.length() != 0) {
                    if (path2.startsWith("/")) {
                        str3 = m6094b(path2);
                    } else {
                        if (authority == null || path.length() != 0) {
                            int lastIndexOf = path.lastIndexOf(47);
                            str3 = lastIndexOf == -1 ? path2 : new StringBuffer().append(path.substring(0, lastIndexOf + 1)).append(path2).toString();
                        } else {
                            str3 = new StringBuffer().append("/").append(path2).toString();
                        }
                        str3 = m6094b(str3);
                    }
                    path = str3;
                    str3 = query;
                } else if (query != null) {
                    str3 = query;
                }
                query = str3;
            }
            path2 = query;
            String str4 = path;
            path = scheme;
            scheme = str4;
        }
        return new URI(path, authority, scheme, path2, null).toString();
    }

    Iterator mo877a(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        if (!element.hasAttributes() && !this.f4042b) {
            return null;
        }
        Collection collection = this.f4043c;
        collection.clear();
        NamedNodeMap attributes = element.getAttributes();
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Attr attr = (Attr) attributes.item(i);
            if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                String localName = attr.getLocalName();
                String value = attr.getValue();
                if (!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(value)) {
                    Node b = nameSpaceSymbTable.m6121b(localName, value, attr);
                    if (b != null) {
                        collection.add(b);
                        if (C14nHelper.m6065a(attr)) {
                            throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                collection.add(attr);
            }
        }
        if (this.f4042b) {
            nameSpaceSymbTable.m6118a(collection);
            this.f4044e.m6069a(collection);
            this.f4042b = false;
        }
        return collection.iterator();
    }

    void mo878a(XMLSignatureInput xMLSignatureInput) {
        if (xMLSignatureInput.m6235a()) {
            XMLUtils.m6387a(xMLSignatureInput.m6252m() != null ? XMLUtils.m6393b(xMLSignatureInput.m6252m()) : XMLUtils.m6382a(xMLSignatureInput.m6236b()));
        }
    }

    public byte[] mo879a(Node node, String str) {
        throw new CanonicalizationException("c14n.Canonicalizer.UnsupportedOperation");
    }

    Iterator mo880b(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        NamedNodeMap namedNodeMap;
        int length;
        Object obj = null;
        this.f4044e.m6068a(nameSpaceSymbTable.m6129f());
        int i = m6076a((Node) element, nameSpaceSymbTable.m6129f()) == 1 ? 1 : 0;
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            namedNodeMap = attributes;
            length = attributes.getLength();
        } else {
            length = 0;
            namedNodeMap = null;
        }
        Collection collection = this.f4043c;
        collection.clear();
        for (int i2 = 0; i2 < length; i2++) {
            Attr attr = (Attr) namedNodeMap.item(i2);
            String namespaceURI = attr.getNamespaceURI();
            if ("http://www.w3.org/2000/xmlns/".equals(namespaceURI)) {
                namespaceURI = attr.getLocalName();
                String value = attr.getValue();
                if (!"xml".equals(namespaceURI) || !"http://www.w3.org/XML/1998/namespace".equals(value)) {
                    if (m6089c(attr)) {
                        if (i != 0 || !nameSpaceSymbTable.m6128e(namespaceURI)) {
                            Node b = nameSpaceSymbTable.m6121b(namespaceURI, value, attr);
                            if (b != null) {
                                collection.add(b);
                                if (C14nHelper.m6065a(attr)) {
                                    throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), namespaceURI, attr.getNodeValue()});
                                }
                            } else {
                                continue;
                            }
                        }
                    } else if (i == 0 || "xmlns".equals(namespaceURI)) {
                        nameSpaceSymbTable.m6119a(namespaceURI, value, attr);
                    } else {
                        nameSpaceSymbTable.m6124c(namespaceURI);
                    }
                }
            } else if ("http://www.w3.org/XML/1998/namespace".equals(namespaceURI)) {
                if (!attr.getLocalName().equals("id")) {
                    this.f4044e.m6070a(attr);
                } else if (i != 0) {
                    collection.add(attr);
                }
            } else if (i != 0) {
                collection.add(attr);
            }
        }
        if (i != 0) {
            Node attributeNodeNS = element.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            if (attributeNodeNS == null) {
                obj = nameSpaceSymbTable.m6116a("xmlns");
            } else if (!m6089c(attributeNodeNS)) {
                obj = nameSpaceSymbTable.m6121b("xmlns", "", i);
            }
            if (obj != null) {
                collection.add(obj);
            }
            this.f4044e.m6069a(collection);
            nameSpaceSymbTable.m6118a(collection);
        }
        return collection.iterator();
    }

    void mo881c(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        if (element.hasAttributes()) {
            this.f4044e.m6068a(-1);
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                Attr attr = (Attr) attributes.item(i);
                if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                    String localName = attr.getLocalName();
                    String nodeValue = attr.getNodeValue();
                    if (!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(nodeValue)) {
                        nameSpaceSymbTable.m6119a(localName, nodeValue, attr);
                    }
                } else if (!"http://www.w3.org/XML/1998/namespace".equals(attr.getNamespaceURI())) {
                    this.f4044e.m6070a(attr);
                }
            }
        }
    }
}
