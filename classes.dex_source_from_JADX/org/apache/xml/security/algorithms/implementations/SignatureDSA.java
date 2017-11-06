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

public class SignatureDSA extends SignatureAlgorithmSpi {
    static Log f3999a;
    static Class f4000b;
    static Class f4001c;
    private Signature f4002d = null;

    static {
        Class a;
        if (f4000b == null) {
            a = m6033a("org.apache.xml.security.algorithms.implementations.SignatureDSA");
            f4000b = a;
        } else {
            a = f4000b;
        }
        f3999a = LogFactory.getLog(a.getName());
    }

    public SignatureDSA() {
        String a = JCEMapper.m5953a("http://www.w3.org/2000/09/xmldsig#dsa-sha1");
        if (f3999a.isDebugEnabled()) {
            f3999a.debug(new StringBuffer().append("Created SignatureDSA using ").append(a).toString());
        }
        String a2 = JCEMapper.m5952a();
        if (a2 == null) {
            try {
                this.f4002d = Signature.getInstance(a);
                return;
            } catch (NoSuchAlgorithmException e) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a, e.getLocalizedMessage()});
            } catch (NoSuchProviderException e2) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a, e2.getLocalizedMessage()});
            }
        }
        this.f4002d = Signature.getInstance(a, a2);
    }

    static Class m6033a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static byte[] m6034c(byte[] bArr) {
        int i = 20;
        if (bArr.length != 40) {
            throw new IOException("Invalid XMLDSIG format of DSA signature");
        }
        int i2 = 20;
        while (i2 > 0 && bArr[20 - i2] == (byte) 0) {
            i2--;
        }
        int i3 = bArr[20 - i2] < (byte) 0 ? i2 + 1 : i2;
        while (i > 0 && bArr[40 - i] == (byte) 0) {
            i--;
        }
        int i4 = bArr[40 - i] < (byte) 0 ? i + 1 : i;
        Object obj = new byte[((i3 + 6) + i4)];
        obj[0] = (byte) 48;
        obj[1] = (byte) ((i3 + 4) + i4);
        obj[2] = 2;
        obj[3] = (byte) i3;
        System.arraycopy(bArr, 20 - i2, obj, (i3 + 4) - i2, i2);
        obj[i3 + 4] = 2;
        obj[i3 + 5] = (byte) i4;
        System.arraycopy(bArr, 40 - i, obj, ((i3 + 6) + i4) - i, i);
        return obj;
    }

    protected String mo862a() {
        return this.f4002d.getAlgorithm();
    }

    protected void mo863a(byte b) {
        try {
            this.f4002d.update(b);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected void mo864a(Key key) {
        if (key instanceof PublicKey) {
            try {
                this.f4002d.initVerify((PublicKey) key);
                return;
            } catch (Exception e) {
                Signature signature = this.f4002d;
                try {
                    this.f4002d = Signature.getInstance(this.f4002d.getAlgorithm());
                } catch (Exception e2) {
                    if (f3999a.isDebugEnabled()) {
                        f3999a.debug(new StringBuffer().append("Exception when reinstantiating Signature:").append(e2).toString());
                    }
                    this.f4002d = signature;
                }
                throw new XMLSignatureException("empty", e);
            }
        }
        Class a;
        String name = key.getClass().getName();
        if (f4001c == null) {
            a = m6033a("java.security.PublicKey");
            f4001c = a;
        } else {
            a = f4001c;
        }
        String name2 = a.getName();
        throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, name2});
    }

    protected void mo866a(byte[] bArr) {
        try {
            this.f4002d.update(bArr);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected void mo867a(byte[] bArr, int i, int i2) {
        try {
            this.f4002d.update(bArr, i, i2);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    protected String mo868b() {
        return this.f4002d.getProvider().getName();
    }

    protected boolean mo869b(byte[] bArr) {
        try {
            if (f3999a.isDebugEnabled()) {
                f3999a.debug(new StringBuffer().append("Called DSA.verify() on ").append(Base64.m6331b(bArr)).toString());
            }
            return this.f4002d.verify(m6034c(bArr));
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        } catch (Exception e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }
}
