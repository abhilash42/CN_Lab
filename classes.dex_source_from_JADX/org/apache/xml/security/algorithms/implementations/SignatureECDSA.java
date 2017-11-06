package org.apache.xml.security.algorithms.implementations;

import java.io.IOException;
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
import org.apache.xml.security.utils.Base64;

public abstract class SignatureECDSA extends SignatureAlgorithmSpi {
    static Log f4003a;
    static Class f4004b;
    static Class f4005c;
    private Signature f4006d = null;

    public class SignatureECDSASHA1 extends SignatureECDSA {
        public String mo874d() {
            return "http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha1";
        }
    }

    static {
        Class a;
        if (f4004b == null) {
            a = m6042a("org.apache.xml.security.algorithms.implementations.SignatureECDSA");
            f4004b = a;
        } else {
            a = f4004b;
        }
        f4003a = LogFactory.getLog(a.getName());
    }

    public SignatureECDSA() {
        String a = JCEMapper.m5953a(mo874d());
        if (f4003a.isDebugEnabled()) {
            f4003a.debug(new StringBuffer().append("Created SignatureECDSA using ").append(a).toString());
        }
        String a2 = JCEMapper.m5952a();
        if (a2 == null) {
            try {
                this.f4006d = Signature.getInstance(a);
                return;
            } catch (NoSuchAlgorithmException e) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a, e.getLocalizedMessage()});
            } catch (NoSuchProviderException e2) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a, e2.getLocalizedMessage()});
            }
        }
        this.f4006d = Signature.getInstance(a, a2);
    }

    static Class m6042a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static byte[] m6043c(byte[] bArr) {
        if (bArr.length < 48) {
            throw new IOException("Invalid XMLDSIG format of ECDSA signature");
        }
        int length = bArr.length / 2;
        int i = length;
        while (i > 0 && bArr[length - i] == (byte) 0) {
            i--;
        }
        int i2 = bArr[length - i] < (byte) 0 ? i + 1 : i;
        int i3 = length;
        while (i3 > 0 && bArr[(length * 2) - i3] == (byte) 0) {
            i3--;
        }
        int i4 = bArr[(length * 2) - i3] < (byte) 0 ? i3 + 1 : i3;
        Object obj = new byte[((i2 + 6) + i4)];
        obj[0] = 48;
        obj[1] = (byte) ((i2 + 4) + i4);
        obj[2] = 2;
        obj[3] = (byte) i2;
        System.arraycopy(bArr, length - i, obj, (i2 + 4) - i, i);
        obj[i2 + 4] = 2;
        obj[i2 + 5] = (byte) i4;
        System.arraycopy(bArr, (length * 2) - i3, obj, ((i2 + 6) + i4) - i3, i3);
        return obj;
    }

    protected String mo862a() {
        return this.f4006d.getAlgorithm();
    }

    protected void mo863a(byte b) {
        try {
            this.f4006d.update(b);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected void mo864a(Key key) {
        if (key instanceof PublicKey) {
            try {
                this.f4006d.initVerify((PublicKey) key);
                return;
            } catch (Exception e) {
                Signature signature = this.f4006d;
                try {
                    this.f4006d = Signature.getInstance(this.f4006d.getAlgorithm());
                } catch (Exception e2) {
                    if (f4003a.isDebugEnabled()) {
                        f4003a.debug(new StringBuffer().append("Exception when reinstantiating Signature:").append(e2).toString());
                    }
                    this.f4006d = signature;
                }
                throw new XMLSignatureException("empty", e);
            }
        }
        Class a;
        String name = key.getClass().getName();
        if (f4005c == null) {
            a = m6042a("java.security.PublicKey");
            f4005c = a;
        } else {
            a = f4005c;
        }
        String name2 = a.getName();
        throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, name2});
    }

    protected void mo866a(byte[] bArr) {
        try {
            this.f4006d.update(bArr);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected void mo867a(byte[] bArr, int i, int i2) {
        try {
            this.f4006d.update(bArr, i, i2);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected String mo868b() {
        return this.f4006d.getProvider().getName();
    }

    protected boolean mo869b(byte[] bArr) {
        try {
            byte[] c = m6043c(bArr);
            if (f4003a.isDebugEnabled()) {
                f4003a.debug(new StringBuffer().append("Called ECDSA.verify() on ").append(Base64.m6331b(bArr)).toString());
            }
            return this.f4006d.verify(c);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        } catch (Exception e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    public abstract String mo874d();
}
