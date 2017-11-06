package org.apache.xml.security.utils.resolver.implementations;

import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.w3c.dom.Attr;

public class ResolverAnonymous extends ResourceResolverSpi {
    private XMLSignatureInput f4278d;

    public XMLSignatureInput mo887a(Attr attr, String str) {
        return this.f4278d;
    }

    public boolean mo888b(Attr attr, String str) {
        return attr == null;
    }
}
