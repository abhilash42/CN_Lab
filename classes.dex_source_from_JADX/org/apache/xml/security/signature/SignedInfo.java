package org.apache.xml.security.signature;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SignedInfo extends Manifest {
    private SignatureAlgorithm f4153g = null;
    private byte[] f4154h = null;
    private Element f4155i;
    private Element f4156q;

    public SignedInfo(Element element, String str) {
        super(m6216a(element), str);
        this.f4155i = XMLUtils.m6384a(element.getFirstChild());
        this.f4156q = XMLUtils.m6384a(this.f4155i.getNextSibling());
        this.f4153g = new SignatureAlgorithm(this.f4156q, m5945l());
    }

    private static Element m6216a(Element element) {
        String attributeNS = XMLUtils.m6384a(element.getFirstChild()).getAttributeNS(null, "Algorithm");
        if (attributeNS.equals("http://www.w3.org/TR/2001/REC-xml-c14n-20010315") || attributeNS.equals("http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments") || attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#") || attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#WithComments") || attributeNS.equals("http://www.w3.org/2006/12/xml-c14n11") || attributeNS.equals("http://www.w3.org/2006/12/xml-c14n11#WithComments")) {
            return element;
        }
        try {
            byte[] a = Canonicalizer.m6053a(attributeNS).m6058a((Node) element);
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            Node importNode = element.getOwnerDocument().importNode(newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(a)).getDocumentElement(), true);
            element.getParentNode().replaceChild(importNode, element);
            return (Element) importNode;
        } catch (Exception e) {
            throw new XMLSecurityException("empty", e);
        } catch (Exception e2) {
            throw new XMLSecurityException("empty", e2);
        } catch (Exception e22) {
            throw new XMLSecurityException("empty", e22);
        }
    }

    public void m6217a(OutputStream outputStream) {
        if (this.f4154h == null) {
            Canonicalizer a = Canonicalizer.m6053a(m6218b());
            a.m6057a(outputStream);
            String f = m6222f();
            if (f == null) {
                a.m6058a(this.k);
                return;
            } else {
                a.m6059a(this.k, f);
                return;
            }
        }
        try {
            outputStream.write(this.f4154h);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String m6218b() {
        return this.f4155i.getAttributeNS(null, "Algorithm");
    }

    public boolean m6219b(boolean z) {
        return super.m6196a(z);
    }

    protected SignatureAlgorithm m6220c() {
        return this.f4153g;
    }

    public String mo861e() {
        return "SignedInfo";
    }

    public String m6222f() {
        String str = null;
        String attributeNS = this.f4155i.getAttributeNS(str, "Algorithm");
        if (attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#") || attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#WithComments")) {
            Element a = XMLUtils.m6384a(this.f4155i.getFirstChild());
            if (a != null) {
                try {
                    str = new InclusiveNamespaces(a, "http://www.w3.org/2001/10/xml-exc-c14n#").m6306a();
                } catch (XMLSecurityException e) {
                }
            }
        }
        return str;
    }
}
