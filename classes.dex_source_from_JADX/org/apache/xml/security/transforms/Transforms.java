package org.apache.xml.security.transforms;

import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Transforms extends SignatureElementProxy {
    static Log f4071a;
    static Class f4072c;
    Element[] f4073b;

    static {
        Class b;
        if (f4072c == null) {
            b = m6140b("org.apache.xml.security.transforms.Transforms");
            f4072c = b;
        } else {
            b = f4072c;
        }
        f4071a = LogFactory.getLog(b.getName());
    }

    protected Transforms() {
    }

    public Transforms(Document document) {
        super(document);
        XMLUtils.m6395b(this.k);
    }

    public Transforms(Element element, String str) {
        super(element, str);
        if (m6141a() == 0) {
            throw new TransformationException("xml.WrongContent", new Object[]{"Transform", "Transforms"});
        }
    }

    private void m6139a(Transform transform) {
        if (f4071a.isDebugEnabled()) {
            f4071a.debug(new StringBuffer().append("Transforms.addTransform(").append(transform.m6266b()).append(")").toString());
        }
        this.k.appendChild(transform.m5944k());
        XMLUtils.m6395b(this.k);
    }

    static Class m6140b(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public int m6141a() {
        if (this.f4073b == null) {
            this.f4073b = XMLUtils.m6391a(this.k.getFirstChild(), "Transform");
        }
        return this.f4073b.length;
    }

    public XMLSignatureInput m6142a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream) {
        try {
            int a = m6141a() - 1;
            int i = 0;
            XMLSignatureInput xMLSignatureInput2 = xMLSignatureInput;
            while (i < a) {
                Transform a2 = m6143a(i);
                if (f4071a.isDebugEnabled()) {
                    f4071a.debug(new StringBuffer().append("Perform the (").append(i).append(")th ").append(a2.m6266b()).append(" transform").toString());
                }
                i++;
                xMLSignatureInput2 = a2.m6264a(xMLSignatureInput2);
            }
            if (a >= 0) {
                xMLSignatureInput2 = m6143a(a).m6265a(xMLSignatureInput2, outputStream);
            }
            return xMLSignatureInput2;
        } catch (Exception e) {
            throw new TransformationException("empty", e);
        } catch (Exception e2) {
            throw new TransformationException("empty", e2);
        } catch (Exception e22) {
            throw new TransformationException("empty", e22);
        }
    }

    public Transform m6143a(int i) {
        try {
            if (this.f4073b == null) {
                this.f4073b = XMLUtils.m6391a(this.k.getFirstChild(), "Transform");
            }
            return new Transform(this.f4073b[i], this.l);
        } catch (Exception e) {
            throw new TransformationException("empty", e);
        }
    }

    public void m6144a(String str) {
        try {
            if (f4071a.isDebugEnabled()) {
                f4071a.debug(new StringBuffer().append("Transforms.addTransform(").append(str).append(")").toString());
            }
            m6139a(Transform.m6258a(this.m, str));
        } catch (Exception e) {
            throw new TransformationException("empty", e);
        }
    }

    public String mo861e() {
        return "Transforms";
    }
}
