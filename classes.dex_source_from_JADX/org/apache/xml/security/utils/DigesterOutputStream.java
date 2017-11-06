package org.apache.xml.security.utils;

import java.io.ByteArrayOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;

public class DigesterOutputStream extends ByteArrayOutputStream {
    static Log f4228b;
    static Class f4229c;
    final MessageDigestAlgorithm f4230a;

    static {
        Class a;
        if (f4229c == null) {
            a = m6347a("org.apache.xml.security.utils.DigesterOutputStream");
            f4229c = a;
        } else {
            a = f4229c;
        }
        f4228b = LogFactory.getLog(a.getName());
    }

    public DigesterOutputStream(MessageDigestAlgorithm messageDigestAlgorithm) {
        this.f4230a = messageDigestAlgorithm;
    }

    static Class m6347a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public byte[] m6348a() {
        return this.f4230a.m5962b();
    }

    public void write(int i) {
        this.f4230a.m5960a((byte) i);
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (f4228b.isDebugEnabled()) {
            f4228b.debug("Pre-digested input:");
            StringBuffer stringBuffer = new StringBuffer(i2);
            for (int i3 = i; i3 < i + i2; i3++) {
                stringBuffer.append((char) bArr[i3]);
            }
            f4228b.debug(stringBuffer.toString());
        }
        this.f4230a.m5961a(bArr, i, i2);
    }
}
