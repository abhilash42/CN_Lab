package org.apache.xml.security.signature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.utils.I18n;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Manifest extends SignatureElementProxy {
    static Log f4137a;
    static Class f4138f;
    List f4139b;
    Element[] f4140c = XMLUtils.m6391a(this.k.getFirstChild(), "Reference");
    HashMap f4141d = null;
    List f4142e = null;
    private boolean[] f4143g = null;

    static {
        Class a;
        if (f4138f == null) {
            a = m6193a("org.apache.xml.security.signature.Manifest");
            f4138f = a;
        } else {
            a = f4138f;
        }
        f4137a = LogFactory.getLog(a.getName());
    }

    public Manifest(Element element, String str) {
        int i = 0;
        super(element, str);
        int length = this.f4140c.length;
        if (length == 0) {
            throw new DOMException((short) 4, I18n.m6351a("xml.WrongContent", new Object[]{"Reference", "Manifest"}));
        }
        this.f4139b = new ArrayList(length);
        while (i < length) {
            this.f4139b.add(null);
            i++;
        }
    }

    static Class m6193a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void m6194a(int i, boolean z) {
        if (this.f4143g == null) {
            this.f4143g = new boolean[m6195a()];
        }
        this.f4143g[i] = z;
    }

    public int m6195a() {
        return this.f4139b.size();
    }

    public boolean m6196a(boolean z) {
        if (this.f4140c == null) {
            this.f4140c = XMLUtils.m6391a(this.k.getFirstChild(), "Reference");
        }
        if (f4137a.isDebugEnabled()) {
            f4137a.debug(new StringBuffer().append("verify ").append(this.f4140c.length).append(" References").toString());
            f4137a.debug(new StringBuffer().append("I am ").append(z ? "" : "not").append(" requested to follow nested Manifests").toString());
        }
        if (this.f4140c.length == 0) {
            throw new XMLSecurityException("empty");
        }
        this.f4143g = new boolean[this.f4140c.length];
        int i = 0;
        boolean z2 = true;
        while (i < this.f4140c.length) {
            Reference reference = new Reference(this.f4140c[i], this.l, this);
            this.f4139b.set(i, reference);
            try {
                boolean j = reference.m6213j();
                m6194a(i, j);
                boolean z3 = !j ? false : z2;
                if (f4137a.isDebugEnabled()) {
                    f4137a.debug(new StringBuffer().append("The Reference has Type ").append(reference.m6207c()).toString());
                }
                if (z3 && z && reference.m6209f()) {
                    Manifest manifest;
                    f4137a.debug("We have to follow a nested Manifest");
                    XMLSignatureInput a = reference.m6205a(null);
                    for (Node node : a.m6236b()) {
                        if (node.getNodeType() == (short) 1 && ((Element) node).getNamespaceURI().equals("http://www.w3.org/2000/09/xmldsig#") && ((Element) node).getLocalName().equals("Manifest")) {
                            try {
                                manifest = new Manifest((Element) node, a.m6250k());
                                break;
                            } catch (XMLSecurityException e) {
                            }
                        }
                    }
                    manifest = null;
                    if (manifest == null) {
                        throw new MissingResourceFailureException("empty", reference);
                    }
                    manifest.f4142e = this.f4142e;
                    manifest.f4141d = this.f4141d;
                    if (manifest.m6196a(z)) {
                        f4137a.debug("The nested Manifest was valid (good)");
                        z2 = z3;
                    } else {
                        f4137a.warn("The nested Manifest was invalid (bad)");
                        z2 = false;
                    }
                    j = z2;
                } else {
                    j = z3;
                }
                i++;
                z2 = j;
            } catch (Exception e2) {
                throw new ReferenceNotInitializedException("empty", e2);
            } catch (Exception e22) {
                throw new ReferenceNotInitializedException("empty", e22);
            } catch (Exception e222) {
                throw new ReferenceNotInitializedException("empty", e222);
            } catch (Exception e2222) {
                throw new MissingResourceFailureException("signature.Verification.Reference.NoInput", new Object[]{reference.m6206b()}, e2222, reference);
            }
        }
        return z2;
    }

    public String mo861e() {
        return "Manifest";
    }
}
