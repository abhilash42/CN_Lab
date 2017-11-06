package org.apache.xml.security.transforms.params;

import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.transforms.TransformParam;
import org.apache.xml.security.utils.ElementProxy;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPath2FilterContainer extends ElementProxy implements TransformParam {
    private XPath2FilterContainer() {
    }

    private XPath2FilterContainer(Element element, String str) {
        super(element, str);
        String attributeNS = this.k.getAttributeNS(null, "Filter");
        if (!attributeNS.equals("intersect") && !attributeNS.equals("subtract") && !attributeNS.equals("union")) {
            throw new XMLSecurityException("attributeValueIllegal", new Object[]{"Filter", attributeNS, "intersect, subtract or union"});
        }
    }

    public static XPath2FilterContainer m6311a(Element element, String str) {
        return new XPath2FilterContainer(element, str);
    }

    public boolean m6312a() {
        return this.k.getAttributeNS(null, "Filter").equals("intersect");
    }

    public boolean m6313b() {
        return this.k.getAttributeNS(null, "Filter").equals("subtract");
    }

    public boolean m6314c() {
        return this.k.getAttributeNS(null, "Filter").equals("union");
    }

    public final String mo860d() {
        return "http://www.w3.org/2002/06/xmldsig-filter2";
    }

    public final String mo861e() {
        return "XPath";
    }

    public Node m6317f() {
        NodeList childNodes = this.k.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            if (childNodes.item(i).getNodeType() == (short) 3) {
                return childNodes.item(i);
            }
        }
        return null;
    }
}
