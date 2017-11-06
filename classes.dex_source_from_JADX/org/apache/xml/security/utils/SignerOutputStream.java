package org.apache.xml.security.utils;

import java.io.ByteArrayOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.signature.XMLSignatureException;

public class SignerOutputStream extends ByteArrayOutputStream {
    static Log f4252b;
    static Class f4253c;
    final SignatureAlgorithm f4254a;

    static {
        Class a;
        if (f4253c == null) {
            a = m6376a("org.apache.xml.security.utils.SignerOutputStream");
            f4253c = a;
        } else {
            a = f4253c;
        }
        f4252b = LogFactory.getLog(a.getName());
    }

    public SignerOutputStream(SignatureAlgorithm signatureAlgorithm) {
        this.f4254a = signatureAlgorithm;
    }

    static Class m6376a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public void write(int i) {
        try {
            this.f4254a.m5974a((byte) i);
        } catch (XMLSignatureException e) {
            throw new RuntimeException(new StringBuffer().append("").append(e).toString());
        }
    }

    public void write(byte[] bArr) {
        try {
            this.f4254a.m5976a(bArr);
        } catch (XMLSignatureException e) {
            throw new RuntimeException(new StringBuffer().append("").append(e).toString());
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        if (f4252b.isDebugEnabled()) {
            f4252b.debug("Canonicalized SignedInfo:");
            StringBuffer stringBuffer = new StringBuffer(i2);
            for (int i3 = i; i3 < i + i2; i3++) {
                stringBuffer.append((char) bArr[i3]);
            }
            f4252b.debug(stringBuffer.toString());
        }
        try {
            this.f4254a.m5977a(bArr, i, i2);
        } catch (XMLSignatureException e) {
            throw new RuntimeException(new StringBuffer().append("").append(e).toString());
        }
    }
}
