package org.apache.xml.security.algorithms;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.AlgorithmAlreadyRegisteredException;
import org.apache.xml.security.signature.XMLSignatureException;
import org.w3c.dom.Element;

public class SignatureAlgorithm extends Algorithm {
    static Log f3979a;
    static boolean f3980b = false;
    static HashMap f3981c = null;
    static ThreadLocal f3982d = new C15781();
    static ThreadLocal f3983e = new C15792();
    static ThreadLocal f3984f = new C15803();
    static ThreadLocal f3985g = new C15814();
    static Class f3986i;
    protected SignatureAlgorithmSpi f3987h = null;
    private String f3988q = m5984g();

    class C15781 extends ThreadLocal {
        C15781() {
        }

        protected Object initialValue() {
            return new HashMap();
        }
    }

    class C15792 extends ThreadLocal {
        C15792() {
        }

        protected Object initialValue() {
            return new HashMap();
        }
    }

    class C15803 extends ThreadLocal {
        C15803() {
        }

        protected Object initialValue() {
            return new HashMap();
        }
    }

    class C15814 extends ThreadLocal {
        C15814() {
        }

        protected Object initialValue() {
            return new HashMap();
        }
    }

    static {
        Class b;
        if (f3986i == null) {
            b = m5968b("org.apache.xml.security.algorithms.SignatureAlgorithm");
            f3986i = b;
        } else {
            b = f3986i;
        }
        f3979a = LogFactory.getLog(b.getName());
    }

    public SignatureAlgorithm(Element element, String str) {
        super(element, str);
    }

    public static void m5966a(String str, String str2) {
        if (f3979a.isDebugEnabled()) {
            f3979a.debug(new StringBuffer().append("Try to register ").append(str).append(" ").append(str2).toString());
        }
        Class g = m5972g(str);
        if (g != null) {
            String name = g.getName();
            if (!(name == null || name.length() == 0)) {
                throw new AlgorithmAlreadyRegisteredException("algorithm.alreadyRegistered", new Object[]{str, name});
            }
        }
        try {
            f3981c.put(str, Class.forName(str2));
        } catch (Exception e) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e.getMessage()}, e);
        } catch (Exception e2) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e2.getMessage()}, e2);
        }
    }

    private void m5967a(boolean z) {
        this.f3987h = z ? m5969d(this.f3988q) : m5970e(this.f3988q);
        this.f3987h.mo865a(this.k);
    }

    static Class m5968b(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static SignatureAlgorithmSpi m5969d(String str) {
        SignatureAlgorithmSpi signatureAlgorithmSpi = (SignatureAlgorithmSpi) ((Map) f3982d.get()).get(str);
        if (signatureAlgorithmSpi != null) {
            signatureAlgorithmSpi.mo870c();
            return signatureAlgorithmSpi;
        }
        SignatureAlgorithmSpi f = m5971f(str);
        ((Map) f3982d.get()).put(str, f);
        return f;
    }

    private static SignatureAlgorithmSpi m5970e(String str) {
        SignatureAlgorithmSpi signatureAlgorithmSpi = (SignatureAlgorithmSpi) ((Map) f3983e.get()).get(str);
        if (signatureAlgorithmSpi != null) {
            signatureAlgorithmSpi.mo870c();
            return signatureAlgorithmSpi;
        }
        SignatureAlgorithmSpi f = m5971f(str);
        ((Map) f3983e.get()).put(str, f);
        return f;
    }

    private static SignatureAlgorithmSpi m5971f(String str) {
        try {
            Class g = m5972g(str);
            if (f3979a.isDebugEnabled()) {
                f3979a.debug(new StringBuffer().append("Create URI \"").append(str).append("\" class \"").append(g).append("\"").toString());
            }
            return (SignatureAlgorithmSpi) g.newInstance();
        } catch (Exception e) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e.getMessage()}, e);
        } catch (Exception e2) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e2.getMessage()}, e2);
        } catch (Exception e22) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{str, e22.getMessage()}, e22);
        }
    }

    private static Class m5972g(String str) {
        return f3981c == null ? null : (Class) f3981c.get(str);
    }

    public static void m5973h() {
        if (f3979a == null) {
            Class b;
            if (f3986i == null) {
                b = m5968b("org.apache.xml.security.algorithms.SignatureAlgorithm");
                f3986i = b;
            } else {
                b = f3986i;
            }
            f3979a = LogFactory.getLog(b.getName());
        }
        f3979a.debug("Init() called");
        if (!f3980b) {
            f3981c = new HashMap(10);
            f3980b = true;
        }
    }

    public void m5974a(byte b) {
        this.f3987h.mo863a(b);
    }

    public void m5975a(Key key) {
        m5967a(false);
        Map map = (Map) f3985g.get();
        if (map.get(this.f3988q) != key) {
            map.put(this.f3988q, key);
            this.f3987h.mo864a(key);
        }
    }

    public void m5976a(byte[] bArr) {
        this.f3987h.mo866a(bArr);
    }

    public void m5977a(byte[] bArr, int i, int i2) {
        this.f3987h.mo867a(bArr, i, i2);
    }

    public String m5978b() {
        try {
            return m5970e(this.f3988q).mo862a();
        } catch (XMLSignatureException e) {
            return null;
        }
    }

    public boolean m5979b(byte[] bArr) {
        return this.f3987h.mo869b(bArr);
    }

    public String m5980c() {
        try {
            return m5970e(this.f3988q).mo868b();
        } catch (XMLSignatureException e) {
            return null;
        }
    }

    public String mo860d() {
        return "http://www.w3.org/2000/09/xmldsig#";
    }

    public String mo861e() {
        return "SignatureMethod";
    }

    public void m5983f() {
        ((Map) f3985g.get()).clear();
        ((Map) f3983e.get()).clear();
    }

    public final String m5984g() {
        return this.k.getAttributeNS(null, "Algorithm");
    }
}
