package org.apache.xml.security.c14n.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.helper.C14nHelper;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public abstract class Canonicalizer20010315 extends CanonicalizerBase {
    boolean f4052b = true;
    final SortedSet f4053c = new TreeSet(g);
    XmlAttrStack f4054d = new XmlAttrStack();

    class XmlAttrStack {
        int f4048a = 0;
        int f4049b = 0;
        XmlsStackElement f4050c;
        List f4051d = new ArrayList();

        class XmlsStackElement {
            int f4045a;
            boolean f4046b = false;
            List f4047c = new ArrayList();

            XmlsStackElement() {
            }
        }

        XmlAttrStack() {
        }

        void m6101a(int i) {
            this.f4048a = i;
            if (this.f4048a != -1) {
                this.f4050c = null;
                while (this.f4049b >= this.f4048a) {
                    this.f4051d.remove(this.f4051d.size() - 1);
                    if (this.f4051d.size() == 0) {
                        this.f4049b = 0;
                        return;
                    }
                    this.f4049b = ((XmlsStackElement) this.f4051d.get(this.f4051d.size() - 1)).f4045a;
                }
            }
        }

        void m6102a(Collection collection) {
            boolean z;
            int size = this.f4051d.size() - 1;
            if (this.f4050c == null) {
                this.f4050c = new XmlsStackElement();
                this.f4050c.f4045a = this.f4048a;
                this.f4049b = this.f4048a;
                this.f4051d.add(this.f4050c);
            }
            if (size == -1) {
                z = true;
            } else {
                XmlsStackElement xmlsStackElement = (XmlsStackElement) this.f4051d.get(size);
                z = xmlsStackElement.f4046b && xmlsStackElement.f4045a + 1 == this.f4048a;
            }
            if (z) {
                collection.addAll(this.f4050c.f4047c);
                this.f4050c.f4046b = true;
                return;
            }
            Map hashMap = new HashMap();
            while (size >= 0) {
                for (Attr attr : ((XmlsStackElement) this.f4051d.get(size)).f4047c) {
                    if (!hashMap.containsKey(attr.getName())) {
                        hashMap.put(attr.getName(), attr);
                    }
                }
                size--;
            }
            this.f4050c.f4046b = true;
            collection.addAll(hashMap.values());
        }

        void m6103a(Attr attr) {
            if (this.f4050c == null) {
                this.f4050c = new XmlsStackElement();
                this.f4050c.f4045a = this.f4048a;
                this.f4051d.add(this.f4050c);
                this.f4049b = this.f4048a;
            }
            this.f4050c.f4047c.add(attr);
        }
    }

    public Canonicalizer20010315(boolean z) {
        super(z);
    }

    Iterator mo877a(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        if (!element.hasAttributes() && !this.f4052b) {
            return null;
        }
        Collection collection = this.f4053c;
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
        if (this.f4052b) {
            nameSpaceSymbTable.m6118a(collection);
            this.f4054d.m6102a(collection);
            this.f4052b = false;
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
        this.f4054d.m6101a(nameSpaceSymbTable.m6129f());
        int i = m6076a((Node) element, nameSpaceSymbTable.m6129f()) == 1 ? 1 : 0;
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            namedNodeMap = attributes;
            length = attributes.getLength();
        } else {
            length = 0;
            namedNodeMap = null;
        }
        Collection collection = this.f4053c;
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
                this.f4054d.m6103a(attr);
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
            this.f4054d.m6102a(collection);
            nameSpaceSymbTable.m6118a(collection);
        }
        return collection.iterator();
    }

    void mo881c(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        if (element.hasAttributes()) {
            this.f4054d.m6101a(-1);
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
                } else if ("http://www.w3.org/XML/1998/namespace".equals(attr.getNamespaceURI())) {
                    this.f4054d.m6103a(attr);
                }
            }
        }
    }
}
