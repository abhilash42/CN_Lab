package org.apache.xml.security.c14n.helper;

import java.io.Serializable;
import java.util.Comparator;
import org.w3c.dom.Attr;

public class AttrCompare implements Serializable, Comparator {
    public int compare(Object obj, Object obj2) {
        Attr attr = (Attr) obj;
        Attr attr2 = (Attr) obj2;
        String namespaceURI = attr.getNamespaceURI();
        String namespaceURI2 = attr2.getNamespaceURI();
        boolean equals = "http://www.w3.org/2000/xmlns/".equals(namespaceURI);
        boolean equals2 = "http://www.w3.org/2000/xmlns/".equals(namespaceURI2);
        if (equals) {
            if (!equals2) {
                return -1;
            }
            String localName = attr.getLocalName();
            String localName2 = attr2.getLocalName();
            if ("xmlns".equals(localName)) {
                localName = "";
            }
            if ("xmlns".equals(localName2)) {
                localName2 = "";
            }
            return localName.compareTo(localName2);
        } else if (equals2) {
            return 1;
        } else {
            if (namespaceURI == null) {
                return namespaceURI2 == null ? attr.getName().compareTo(attr2.getName()) : -1;
            } else {
                if (namespaceURI2 == null) {
                    return 1;
                }
                int compareTo = namespaceURI.compareTo(namespaceURI2);
                return compareTo == 0 ? attr.getLocalName().compareTo(attr2.getLocalName()) : compareTo;
            }
        }
    }
}
