package org.apache.xml.security.utils.resolver.implementations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.IdResolver;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ResolverFragment extends ResourceResolverSpi {
    static Log f4282d;
    static Class f4283e;

    static {
        Class c;
        if (f4283e == null) {
            c = m6420c("org.apache.xml.security.utils.resolver.implementations.ResolverFragment");
            f4283e = c;
        } else {
            c = f4283e;
        }
        f4282d = LogFactory.getLog(c.getName());
    }

    static Class m6420c(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public XMLSignatureInput mo887a(Attr attr, String str) {
        Node a;
        String nodeValue = attr.getNodeValue();
        Document ownerDocument = attr.getOwnerElement().getOwnerDocument();
        if (nodeValue.equals("")) {
            f4282d.debug("ResolverFragment with empty URI (means complete document)");
        } else {
            nodeValue = nodeValue.substring(1);
            a = IdResolver.m6359a(ownerDocument, nodeValue);
            if (a == null) {
                throw new ResourceResolverException("signature.Verification.MissingID", new Object[]{nodeValue}, attr, str);
            } else if (f4282d.isDebugEnabled()) {
                f4282d.debug(new StringBuffer().append("Try to catch an Element with ID ").append(nodeValue).append(" and Element was ").append(a).toString());
            }
        }
        XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(a);
        xMLSignatureInput.m6241c(true);
        xMLSignatureInput.m6231a("text/xml");
        xMLSignatureInput.m6239b(str != null ? str.concat(attr.getNodeValue()) : attr.getNodeValue());
        return xMLSignatureInput;
    }

    public boolean mo889a() {
        return true;
    }

    public boolean mo888b(Attr attr, String str) {
        if (attr == null) {
            f4282d.debug("Quick fail for null uri");
            return false;
        }
        String nodeValue = attr.getNodeValue();
        if (nodeValue.equals("") || (nodeValue.charAt(0) == '#' && !(nodeValue.charAt(1) == 'x' && nodeValue.startsWith("#xpointer(")))) {
            if (f4282d.isDebugEnabled()) {
                f4282d.debug(new StringBuffer().append("State I can resolve reference: \"").append(nodeValue).append("\"").toString());
            }
            return true;
        } else if (!f4282d.isDebugEnabled()) {
            return false;
        } else {
            f4282d.debug(new StringBuffer().append("Do not seem to be able to resolve reference: \"").append(nodeValue).append("\"").toString());
            return false;
        }
    }
}
