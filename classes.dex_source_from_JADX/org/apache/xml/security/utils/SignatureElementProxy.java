package org.apache.xml.security.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class SignatureElementProxy extends ElementProxy {
    protected SignatureElementProxy() {
    }

    public SignatureElementProxy(Document document) {
        if (document == null) {
            throw new RuntimeException("Document is null");
        }
        this.m = document;
        this.k = XMLUtils.m6383a(this.m, mo861e());
    }

    public SignatureElementProxy(Element element, String str) {
        super(element, str);
    }

    public String mo860d() {
        return "http://www.w3.org/2000/09/xmldsig#";
    }
}
