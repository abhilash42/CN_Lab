package org.apache.xml.security.c14n.implementations;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.helper.C14nHelper;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public abstract class Canonicalizer20010315Excl extends CanonicalizerBase {
    TreeSet f4055b = new TreeSet();
    final SortedSet f4056c = new TreeSet(g);

    public Canonicalizer20010315Excl(boolean z) {
        super(z);
    }

    Iterator mo877a(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        int length;
        NamedNodeMap namedNodeMap;
        Object prefix;
        SortedSet sortedSet = this.f4056c;
        sortedSet.clear();
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            length = attributes.getLength();
            namedNodeMap = attributes;
        } else {
            length = 0;
            namedNodeMap = null;
        }
        SortedSet<String> sortedSet2 = (SortedSet) this.f4055b.clone();
        for (int i = 0; i < length; i++) {
            Attr attr = (Attr) namedNodeMap.item(i);
            String localName;
            if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                localName = attr.getLocalName();
                String nodeValue = attr.getNodeValue();
                if (!("xml".equals(localName) && "http://www.w3.org/XML/1998/namespace".equals(nodeValue)) && nameSpaceSymbTable.m6119a(localName, nodeValue, attr) && C14nHelper.m6064a(nodeValue)) {
                    throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                }
            }
            localName = attr.getPrefix();
            if (!(localName == null || localName.equals("xml") || localName.equals("xmlns"))) {
                sortedSet2.add(localName);
            }
            sortedSet.add(attr);
        }
        if (element.getNamespaceURI() != null) {
            prefix = element.getPrefix();
            if (prefix == null || prefix.length() == 0) {
                prefix = "xmlns";
            }
        } else {
            prefix = "xmlns";
        }
        sortedSet2.add(prefix);
        for (String a : sortedSet2) {
            Attr a2 = nameSpaceSymbTable.m6116a(a);
            if (a2 != null) {
                sortedSet.add(a2);
            }
        }
        return sortedSet.iterator();
    }

    void mo878a(XMLSignatureInput xMLSignatureInput) {
        if (xMLSignatureInput.m6235a() && !this.f4055b.isEmpty()) {
            XMLUtils.m6387a(xMLSignatureInput.m6252m() != null ? XMLUtils.m6393b(xMLSignatureInput.m6252m()) : XMLUtils.m6382a(xMLSignatureInput.m6236b()));
        }
    }

    public byte[] m6111a(XMLSignatureInput xMLSignatureInput, String str) {
        this.f4055b = (TreeSet) InclusiveNamespaces.m6305a(str);
        return super.m6087b(xMLSignatureInput);
    }

    public byte[] mo876a(Node node) {
        return m6114a(node, "", null);
    }

    public byte[] mo879a(Node node, String str) {
        return m6114a(node, str, null);
    }

    public byte[] m6114a(Node node, String str, Node node2) {
        this.f4055b = (TreeSet) InclusiveNamespaces.m6305a(str);
        return super.m6083a(node, node2);
    }

    final Iterator mo880b(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        NamedNodeMap namedNodeMap;
        int length;
        SortedSet sortedSet = this.f4056c;
        sortedSet.clear();
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            namedNodeMap = attributes;
            length = attributes.getLength();
        } else {
            namedNodeMap = null;
            length = 0;
        }
        Object obj = m6076a((Node) element, nameSpaceSymbTable.m6129f()) == 1 ? 1 : null;
        Set<String> set = obj != null ? (Set) this.f4055b.clone() : null;
        for (int i = 0; i < length; i++) {
            Attr attr = (Attr) namedNodeMap.item(i);
            String localName;
            if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                localName = attr.getLocalName();
                if (obj == null || m6089c(attr) || "xmlns".equals(localName)) {
                    String nodeValue = attr.getNodeValue();
                    if (obj == null && m6089c(attr) && this.f4055b.contains(localName) && !nameSpaceSymbTable.m6128e(localName)) {
                        Node b = nameSpaceSymbTable.m6121b(localName, nodeValue, attr);
                        if (b != null) {
                            sortedSet.add(b);
                            if (C14nHelper.m6065a(attr)) {
                                throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                            }
                        }
                    }
                    if (nameSpaceSymbTable.m6119a(localName, nodeValue, attr) && C14nHelper.m6064a(nodeValue)) {
                        throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                    }
                }
                nameSpaceSymbTable.m6126d(localName);
            } else if (m6089c(attr) && obj != null) {
                localName = attr.getPrefix();
                if (!(localName == null || localName.equals("xml") || localName.equals("xmlns"))) {
                    set.add(localName);
                }
                sortedSet.add(attr);
            }
        }
        if (obj != null) {
            String prefix;
            Node attributeNodeNS = element.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            if (!(attributeNodeNS == null || m6089c(attributeNodeNS))) {
                nameSpaceSymbTable.m6119a("xmlns", "", i);
            }
            if (element.getNamespaceURI() != null) {
                prefix = element.getPrefix();
                if (prefix == null || prefix.length() == 0) {
                    set.add("xmlns");
                } else {
                    set.add(prefix);
                }
            } else {
                set.add("xmlns");
            }
            for (String prefix2 : set) {
                attr = nameSpaceSymbTable.m6116a(prefix2);
                if (attr != null) {
                    sortedSet.add(attr);
                }
            }
        }
        return sortedSet.iterator();
    }
}
