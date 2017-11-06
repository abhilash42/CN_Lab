package org.apache.xml.security.signature;

import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Base64;
import org.apache.xml.security.utils.DigesterOutputStream;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.UnsyncBufferedOutputStream;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xml.security.utils.resolver.ResourceResolver;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

public class Reference extends SignatureElementProxy {
    static Log f4145a;
    static Class f4146d;
    private static boolean f4147e = ((Boolean) AccessController.doPrivileged(new C15841())).booleanValue();
    Manifest f4148b = null;
    XMLSignatureInput f4149c;
    private Transforms f4150f;
    private Element f4151g;
    private Element f4152h;

    class C15841 implements PrivilegedAction {
        C15841() {
        }

        public Object run() {
            return Boolean.valueOf(Boolean.getBoolean("org.apache.xml.security.useC14N11"));
        }
    }

    static {
        Class a;
        if (f4146d == null) {
            a = m6201a("org.apache.xml.security.signature.Reference");
            f4146d = a;
        } else {
            a = f4146d;
        }
        f4145a = LogFactory.getLog(a.getName());
    }

    protected Reference(Element element, String str, Manifest manifest) {
        super(element, str);
        this.l = str;
        Element a = XMLUtils.m6384a(element.getFirstChild());
        if ("Transforms".equals(a.getLocalName()) && "http://www.w3.org/2000/09/xmldsig#".equals(a.getNamespaceURI())) {
            this.f4150f = new Transforms(a, this.l);
            a = XMLUtils.m6384a(a.getNextSibling());
        }
        this.f4151g = a;
        this.f4152h = XMLUtils.m6384a(this.f4151g.getNextSibling());
        this.f4148b = manifest;
    }

    static Class m6201a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private XMLSignatureInput m6202a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream) {
        try {
            Transforms h = m6211h();
            if (h == null) {
                return xMLSignatureInput;
            }
            xMLSignatureInput = h.m6142a(xMLSignatureInput, outputStream);
            this.f4149c = xMLSignatureInput;
            return xMLSignatureInput;
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        } catch (Exception e2) {
            throw new XMLSignatureException("empty", e2);
        } catch (Exception e22) {
            throw new XMLSignatureException("empty", e22);
        } catch (Exception e222) {
            throw new XMLSignatureException("empty", e222);
        } catch (Exception e2222) {
            throw new XMLSignatureException("empty", e2222);
        }
    }

    private byte[] m6203a(boolean z) {
        try {
            MessageDigestAlgorithm a = m6204a();
            a.m5963c();
            OutputStream digesterOutputStream = new DigesterOutputStream(a);
            OutputStream unsyncBufferedOutputStream = new UnsyncBufferedOutputStream(digesterOutputStream);
            XMLSignatureInput a2 = m6205a(unsyncBufferedOutputStream);
            if (!f4147e || z || a2.m6248i() || a2.m6247h()) {
                a2.m6229a(unsyncBufferedOutputStream);
            } else {
                if (this.f4150f == null) {
                    this.f4150f = new Transforms(this.m);
                    this.k.insertBefore(this.f4150f.m5944k(), this.f4151g);
                }
                this.f4150f.m6144a("http://www.w3.org/2006/12/xml-c14n11");
                a2.m6230a(unsyncBufferedOutputStream, true);
            }
            unsyncBufferedOutputStream.flush();
            return digesterOutputStream.m6348a();
        } catch (Exception e) {
            throw new ReferenceNotInitializedException("empty", e);
        } catch (Exception e2) {
            throw new ReferenceNotInitializedException("empty", e2);
        }
    }

    public MessageDigestAlgorithm m6204a() {
        if (this.f4151g == null) {
            return null;
        }
        String attributeNS = this.f4151g.getAttributeNS(null, "Algorithm");
        return attributeNS != null ? MessageDigestAlgorithm.m5957a(this.m, attributeNS) : null;
    }

    protected XMLSignatureInput m6205a(OutputStream outputStream) {
        try {
            XMLSignatureInput a = m6202a(m6210g(), outputStream);
            this.f4149c = a;
            return a;
        } catch (Exception e) {
            throw new ReferenceNotInitializedException("empty", e);
        }
    }

    public String m6206b() {
        return this.k.getAttributeNS(null, "URI");
    }

    public String m6207c() {
        return this.k.getAttributeNS(null, "Type");
    }

    public String mo861e() {
        return "Reference";
    }

    public boolean m6209f() {
        return "http://www.w3.org/2000/09/xmldsig#Manifest".equals(m6207c());
    }

    public XMLSignatureInput m6210g() {
        String str = null;
        try {
            Attr attributeNodeNS = this.k.getAttributeNodeNS(null, "URI");
            if (attributeNodeNS != null) {
                str = attributeNodeNS.getNodeValue();
            }
            ResourceResolver a = ResourceResolver.m6399a(attributeNodeNS, this.l, this.f4148b.f4142e);
            if (a == null) {
                throw new ReferenceNotInitializedException("signature.Verification.Reference.NoInput", new Object[]{str});
            }
            a.m6405a(this.f4148b.f4141d);
            return a.m6406b(attributeNodeNS, this.l);
        } catch (Exception e) {
            throw new ReferenceNotInitializedException("empty", e);
        } catch (Exception e2) {
            throw new ReferenceNotInitializedException("empty", e2);
        }
    }

    public Transforms m6211h() {
        return this.f4150f;
    }

    public byte[] m6212i() {
        if (this.f4152h != null) {
            return Base64.m6329a(this.f4152h);
        }
        throw new XMLSecurityException("signature.Verification.NoSignatureElement", new Object[]{"DigestValue", "http://www.w3.org/2000/09/xmldsig#"});
    }

    public boolean m6213j() {
        byte[] i = m6212i();
        byte[] a = m6203a(true);
        boolean a2 = MessageDigestAlgorithm.m5958a(i, a);
        if (a2) {
            f4145a.debug(new StringBuffer().append("Verification successful for URI \"").append(m6206b()).append("\"").toString());
        } else {
            f4145a.warn(new StringBuffer().append("Verification failed for URI \"").append(m6206b()).append("\"").toString());
            f4145a.warn(new StringBuffer().append("Expected Digest: ").append(Base64.m6331b(i)).toString());
            f4145a.warn(new StringBuffer().append("Actual Digest: ").append(Base64.m6331b(a)).toString());
        }
        return a2;
    }
}
