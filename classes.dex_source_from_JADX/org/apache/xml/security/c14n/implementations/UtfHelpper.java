package org.apache.xml.security.c14n.implementations;

import java.io.OutputStream;
import java.util.Map;

public class UtfHelpper {
    static final void m6135a(char c, OutputStream outputStream) {
        if (c < '') {
            outputStream.write(c);
        } else if ((c < '?' || c > '?') && (c < '?' || c > '?')) {
            int i;
            int i2;
            if (c > '߿') {
                char c2 = (char) (c >>> 12);
                i = 224;
                if (c2 > '\u0000') {
                    i = 224 | (c2 & 15);
                }
                outputStream.write(i);
                i = 128;
                i2 = 63;
            } else {
                i = 192;
                i2 = 31;
            }
            char c3 = (char) (c >>> 6);
            if (c3 > '\u0000') {
                i |= i2 & c3;
            }
            outputStream.write(i);
            outputStream.write((c & 63) | 128);
        } else {
            outputStream.write(63);
        }
    }

    static final void m6136a(String str, OutputStream outputStream) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < '') {
                outputStream.write(charAt);
                i = i2;
            } else if ((charAt < '?' || charAt > '?') && (charAt < '?' || charAt > '?')) {
                int i3;
                if (charAt > '߿') {
                    char c = (char) (charAt >>> 12);
                    i = 224;
                    if (c > '\u0000') {
                        i = 224 | (c & 15);
                    }
                    outputStream.write(i);
                    i = 128;
                    i3 = 63;
                } else {
                    i = 192;
                    i3 = 31;
                }
                char c2 = (char) (charAt >>> 6);
                if (c2 > '\u0000') {
                    i |= i3 & c2;
                }
                outputStream.write(i);
                outputStream.write((charAt & 63) | 128);
                i = i2;
            } else {
                outputStream.write(63);
                i = i2;
            }
        }
    }

    static final void m6137a(String str, OutputStream outputStream, Map map) {
        byte[] bArr = (byte[]) map.get(str);
        if (bArr == null) {
            bArr = m6138a(str);
            map.put(str, bArr);
        }
        outputStream.write(bArr);
    }

    public static final byte[] m6138a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < '') {
                i2 = i + 1;
                bArr[i] = (byte) charAt;
                i = i2;
                i2 = i4;
            } else if ((charAt < '?' || charAt > '?') && (charAt < '?' || charAt > '?')) {
                byte[] bArr2;
                int i5;
                byte b;
                int i6;
                if (i3 == 0) {
                    Object obj = new byte[(length * 3)];
                    System.arraycopy(bArr, 0, obj, 0, i);
                    bArr2 = obj;
                    i5 = 1;
                } else {
                    bArr2 = bArr;
                    i5 = i3;
                }
                if (charAt > '߿') {
                    char c = (char) (charAt >>> 12);
                    b = (byte) -32;
                    if (c > '\u0000') {
                        b = (byte) (-32 | (c & 15));
                    }
                    i6 = i + 1;
                    bArr2[i] = b;
                    b = Byte.MIN_VALUE;
                    i = i6;
                    i6 = 63;
                } else {
                    b = (byte) -64;
                    i6 = 31;
                }
                char c2 = (char) (charAt >>> 6);
                if (c2 > '\u0000') {
                    b = (byte) (b | (i6 & c2));
                }
                i6 = i + 1;
                bArr2[i] = b;
                i = i6 + 1;
                bArr2[i6] = (byte) ((charAt & 63) | 128);
                bArr = bArr2;
                i3 = i5;
                i2 = i4;
            } else {
                i2 = i + 1;
                bArr[i] = (byte) 63;
                i = i2;
                i2 = i4;
            }
        }
        if (i3 == 0) {
            return bArr;
        }
        obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        return obj;
    }
}
