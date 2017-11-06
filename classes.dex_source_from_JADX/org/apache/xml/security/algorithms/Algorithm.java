package org.apache.xml.security.algorithms;

import org.apache.xml.security.utils.SignatureElementProxy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class Algorithm extends SignatureElementProxy {
    public Algorithm(Document document, String str) {
        super(document);
        m5951a(str);
    }

    public Algorithm(Element element, String str) {
        super(element, str);
    }

    public String m5950a() {
        return this.k.getAttributeNS(null, "Algorithm");
    }

    protected void m5951a(String str) {
        if (str != null) {
            this.k.setAttributeNS(null, "Algorithm", str);
        }
    }
}
