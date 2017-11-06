package org.apache.xml.security.algorithms.implementations;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.algorithms.SignatureAlgorithmSpi;
import org.apache.xml.security.signature.XMLSignatureException;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public abstract class IntegrityHmac extends SignatureAlgorithmSpi {
    static Log f3989a;
    static Class f3990c;
    static Class f3991d;
    int f3992b = 0;
    private Mac f3993e = null;
    private boolean f3994f = false;

    public class IntegrityHmacMD5 extends IntegrityHmac {
        public String mo871d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-md5";
        }

        int mo872e() {
            return 128;
        }
    }

    public class IntegrityHmacRIPEMD160 extends IntegrityHmac {
        public String mo871d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-ripemd160";
        }

        int mo872e() {
            return 160;
        }
    }

    public class IntegrityHmacSHA1 extends IntegrityHmac {
        public String mo871d() {
            return "http://www.w3.org/2000/09/xmldsig#hmac-sha1";
        }

        int mo872e() {
            return 160;
        }
    }

    public class IntegrityHmacSHA256 extends IntegrityHmac {
        public String mo871d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-sha256";
        }

        int mo872e() {
            return 256;
        }
    }

    public class IntegrityHmacSHA384 extends IntegrityHmac {
        public String mo871d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-sha384";
        }

        int mo872e() {
            return 384;
        }
    }

    public class IntegrityHmacSHA512 extends IntegrityHmac {
        public String mo871d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-sha512";
        }

        int mo872e() {
            return 512;
        }
    }

    static {
        Class a;
        if (f3990c == null) {
            a = m5994a("org.apache.xml.security.algorithms.implementations.IntegrityHmac$IntegrityHmacSHA1");
            f3990c = a;
        } else {
            a = f3990c;
        }
        f3989a = LogFactory.getLog(a.getName());
    }

    public IntegrityHmac() {
        String a = JCEMapper.m5953a(mo871d());
        if (f3989a.isDebugEnabled()) {
            f3989a.debug(new StringBuffer().append("Created IntegrityHmacSHA1 using ").append(a).toString());
        }
        try {
            this.f3993e = Mac.getInstance(a);
        } catch (NoSuchAlgorithmException e) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a, e.getLocalizedMessage()});
        }
    }

    static Class m5994a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected String mo862a() {
        f3989a.debug("engineGetJCEAlgorithmString()");
        return this.f3993e.getAlgorithm();
    }

    protected void mo863a(byte b) {
        try {
            this.f3993e.update(b);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected void mo864a(Key key) {
        if (key instanceof SecretKey) {
            try {
                this.f3993e.init(key);
                return;
            } catch (Exception e) {
                Mac mac = this.f3993e;
                try {
                    this.f3993e = Mac.getInstance(this.f3993e.getAlgorithm());
                } catch (Exception e2) {
                    if (f3989a.isDebugEnabled()) {
                        f3989a.debug(new StringBuffer().append("Exception when reinstantiating Mac:").append(e2).toString());
                    }
                    this.f3993e = mac;
                }
                throw new XMLSignatureException("empty", e);
            }
        }
        Class a;
        String name = key.getClass().getName();
        if (f3991d == null) {
            a = m5994a("javax.crypto.SecretKey");
            f3991d = a;
        } else {
            a = f3991d;
        }
        String name2 = a.getName();
        throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, name2});
    }

    protected void mo865a(Element element) {
        super.mo865a(element);
        if (element == null) {
            throw new IllegalArgumentException("element null");
        }
        Text b = XMLUtils.m6394b(element.getFirstChild(), "HMACOutputLength", 0);
        if (b != null) {
            this.f3992b = Integer.parseInt(b.getData());
            this.f3994f = true;
        }
    }

    protected void mo866a(byte[] bArr) {
        try {
            this.f3993e.update(bArr);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected void mo867a(byte[] bArr, int i, int i2) {
        try {
            this.f3993e.update(bArr, i, i2);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected String mo868b() {
        return this.f3993e.getProvider().getName();
    }

    protected boolean mo869b(byte[] bArr) {
        try {
            if (!this.f3994f || this.f3992b >= mo872e()) {
                return MessageDigestAlgorithm.m5958a(this.f3993e.doFinal(), bArr);
            }
            if (f3989a.isDebugEnabled()) {
                f3989a.debug(new StringBuffer().append("HMACOutputLength must not be less than ").append(mo872e()).toString());
            }
            throw new XMLSignatureException("algorithms.HMACOutputLengthMin", new Object[]{String.valueOf(mo872e())});
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    public void mo870c() {
        this.f3992b = 0;
        this.f3994f = false;
        this.f3993e.reset();
    }

    public abstract String mo871d();

    abstract int mo872e();
}
