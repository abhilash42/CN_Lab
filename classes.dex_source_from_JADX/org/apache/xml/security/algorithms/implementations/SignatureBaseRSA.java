package org.apache.xml.security.algorithms.implementations;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.algorithms.SignatureAlgorithmSpi;
import org.apache.xml.security.signature.XMLSignatureException;

public abstract class SignatureBaseRSA extends SignatureAlgorithmSpi {
    static Log f3995a;
    static Class f3996b;
    static Class f3997c;
    private Signature f3998d = null;

    public class SignatureRSAMD5 extends SignatureBaseRSA {
        public String mo873d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-md5";
        }
    }

    public class SignatureRSARIPEMD160 extends SignatureBaseRSA {
        public String mo873d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-ripemd160";
        }
    }

    public class SignatureRSASHA1 extends SignatureBaseRSA {
        public String mo873d() {
            return "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
        }
    }

    public class SignatureRSASHA256 extends SignatureBaseRSA {
        public String mo873d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";
        }
    }

    public class SignatureRSASHA384 extends SignatureBaseRSA {
        public String mo873d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha384";
        }
    }

    public class SignatureRSASHA512 extends SignatureBaseRSA {
        public String mo873d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha512";
        }
    }

    static {
        Class a;
        if (f3996b == null) {
            a = m6018a("org.apache.xml.security.algorithms.implementations.SignatureBaseRSA");
            f3996b = a;
        } else {
            a = f3996b;
        }
        f3995a = LogFactory.getLog(a.getName());
    }

    public SignatureBaseRSA() {
        String a = JCEMapper.m5953a(mo873d());
        if (f3995a.isDebugEnabled()) {
            f3995a.debug(new StringBuffer().append("Created SignatureRSA using ").append(a).toString());
        }
        String a2 = JCEMapper.m5952a();
        if (a2 == null) {
            try {
                this.f3998d = Signature.getInstance(a);
                return;
            } catch (NoSuchAlgorithmException e) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a, e.getLocalizedMessage()});
            } catch (NoSuchProviderException e2) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a, e2.getLocalizedMessage()});
            }
        }
        this.f3998d = Signature.getInstance(a, a2);
    }

    static Class m6018a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected String mo862a() {
        return this.f3998d.getAlgorithm();
    }

    protected void mo863a(byte b) {
        try {
            this.f3998d.update(b);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected void mo864a(Key key) {
        if (key instanceof PublicKey) {
            try {
                this.f3998d.initVerify((PublicKey) key);
                return;
            } catch (Exception e) {
                Signature signature = this.f3998d;
                try {
                    this.f3998d = Signature.getInstance(this.f3998d.getAlgorithm());
                } catch (Exception e2) {
                    if (f3995a.isDebugEnabled()) {
                        f3995a.debug(new StringBuffer().append("Exception when reinstantiating Signature:").append(e2).toString());
                    }
                    this.f3998d = signature;
                }
                throw new XMLSignatureException("empty", e);
            }
        }
        Class a;
        String name = key.getClass().getName();
        if (f3997c == null) {
            a = m6018a("java.security.PublicKey");
            f3997c = a;
        } else {
            a = f3997c;
        }
        String name2 = a.getName();
        throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, name2});
    }

    protected void mo866a(byte[] bArr) {
        try {
            this.f3998d.update(bArr);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected void mo867a(byte[] bArr, int i, int i2) {
        try {
            this.f3998d.update(bArr, i, i2);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected String mo868b() {
        return this.f3998d.getProvider().getName();
    }

    protected boolean mo869b(byte[] bArr) {
        try {
            return this.f3998d.verify(bArr);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    public abstract String mo873d();
}
