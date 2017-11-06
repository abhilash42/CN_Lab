package org.apache.xml.security.utils;

import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JavaUtils {
    static Log f4248a;
    static Class f4249b;

    static {
        Class a;
        if (f4249b == null) {
            a = m6365a("org.apache.xml.security.utils.JavaUtils");
            f4249b = a;
        } else {
            a = f4249b;
        }
        f4248a = LogFactory.getLog(a.getName());
    }

    private JavaUtils() {
    }

    static Class m6365a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static byte[] m6366a(InputStream inputStream) {
        UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return unsyncByteArrayOutputStream.m6379a();
            }
            unsyncByteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
