package org.apache.xml.security.utils;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class Base64 {
    private static final byte[] f4206a = new byte[255];
    private static final char[] f4207b = new char[64];

    static {
        int i;
        int i2 = 0;
        for (i = 0; i < 255; i++) {
            f4206a[i] = (byte) -1;
        }
        for (i = 90; i >= 65; i--) {
            f4206a[i] = (byte) (i - 65);
        }
        for (i = 122; i >= 97; i--) {
            f4206a[i] = (byte) ((i - 97) + 26);
        }
        for (i = 57; i >= 48; i--) {
            f4206a[i] = (byte) ((i - 48) + 52);
        }
        f4206a[43] = (byte) 62;
        f4206a[47] = (byte) 63;
        for (i = 0; i <= 25; i++) {
            f4207b[i] = (char) (i + 65);
        }
        int i3 = 26;
        i = 0;
        while (i3 <= 51) {
            f4207b[i3] = (char) (i + 97);
            i3++;
            i++;
        }
        i = 52;
        while (i <= 61) {
            f4207b[i] = (char) (i2 + 48);
            i++;
            i2++;
        }
        f4207b[62] = '+';
        f4207b[63] = '/';
    }

    private Base64() {
    }

    protected static final int m6321a(String str, byte[] bArr) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            byte charAt = (byte) str.charAt(i);
            if (m6327a(charAt)) {
                i3 = i2;
            } else {
                i3 = i2 + 1;
                bArr[i2] = charAt;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    public static final String m6322a(byte[] bArr, int i) {
        if (i < 4) {
            i = Integer.MAX_VALUE;
        }
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i2;
        int i3;
        int i4 = length % 24;
        int i5 = length / 24;
        length = i4 != 0 ? i5 + 1 : i5;
        int i6 = (length - 1) / (i / 4);
        char[] cArr = new char[((length * 4) + i6)];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        length = 0;
        while (i9 < i6) {
            i2 = 0;
            int i10 = length;
            int i11 = i7;
            while (i2 < 19) {
                length = i8 + 1;
                byte b = bArr[i8];
                i7 = length + 1;
                byte b2 = bArr[length];
                i3 = i7 + 1;
                byte b3 = bArr[i7];
                byte b4 = (byte) (b2 & 15);
                byte b5 = (byte) (b & 3);
                if ((b & -128) == 0) {
                    i7 = (byte) (b >> 2);
                } else {
                    byte b6 = (byte) ((b >> 2) ^ 192);
                }
                if ((b2 & -128) == 0) {
                    i8 = (byte) (b2 >> 4);
                } else {
                    b = (byte) ((b2 >> 4) ^ 240);
                }
                length = (b3 & -128) == 0 ? (byte) (b3 >> 6) : (byte) ((b3 >> 6) ^ 252);
                int i12 = i11 + 1;
                cArr[i11] = f4207b[i7];
                i7 = i12 + 1;
                cArr[i12] = f4207b[i8 | (b5 << 4)];
                i8 = i7 + 1;
                cArr[i7] = f4207b[length | (b4 << 2)];
                i7 = i8 + 1;
                cArr[i8] = f4207b[b3 & 63];
                i2++;
                i10++;
                i11 = i7;
                i8 = i3;
            }
            i7 = i11 + 1;
            cArr[i11] = '\n';
            i9++;
            length = i10;
        }
        i2 = length;
        i3 = i7;
        length = i8;
        while (i2 < i5) {
            i8 = length + 1;
            byte b7 = bArr[length];
            i7 = i8 + 1;
            b = bArr[i8];
            i10 = i7 + 1;
            byte b8 = bArr[i7];
            byte b9 = (byte) (b & 15);
            byte b10 = (byte) (b7 & 3);
            if ((b7 & -128) == 0) {
                i7 = (byte) (b7 >> 2);
            } else {
                b6 = (byte) ((b7 >> 2) ^ 192);
            }
            if ((b & -128) == 0) {
                i8 = (byte) (b >> 4);
            } else {
                b = (byte) ((b >> 4) ^ 240);
            }
            length = (b8 & -128) == 0 ? (byte) (b8 >> 6) : (byte) ((b8 >> 6) ^ 252);
            i12 = i3 + 1;
            cArr[i3] = f4207b[i7];
            i7 = i12 + 1;
            cArr[i12] = f4207b[i8 | (b10 << 4)];
            i3 = i7 + 1;
            cArr[i7] = f4207b[length | (b9 << 2)];
            i8 = i3 + 1;
            cArr[i3] = f4207b[b8 & 63];
            i2++;
            i3 = i8;
            length = i10;
        }
        byte b11;
        if (i4 == 8) {
            b7 = bArr[length];
            b11 = (byte) (b7 & 3);
            i8 = i3 + 1;
            cArr[i3] = f4207b[(b7 & -128) == 0 ? (byte) (b7 >> 2) : (byte) ((b7 >> 2) ^ 192)];
            length = i8 + 1;
            cArr[i8] = f4207b[b11 << 4];
            i5 = length + 1;
            cArr[length] = '=';
            length = i5 + 1;
            cArr[i5] = '=';
        } else if (i4 == 16) {
            b11 = bArr[length];
            b = bArr[length + 1];
            b6 = (byte) (b & 15);
            byte b12 = (byte) (b11 & 3);
            if ((b11 & -128) == 0) {
                i5 = (byte) (b11 >> 2);
            } else {
                b11 = (byte) ((b11 >> 2) ^ 192);
            }
            length = (b & -128) == 0 ? (byte) (b >> 4) : (byte) ((b >> 4) ^ 240);
            i8 = i3 + 1;
            cArr[i3] = f4207b[i5];
            i5 = i8 + 1;
            cArr[i8] = f4207b[length | (b12 << 4)];
            length = i5 + 1;
            cArr[i5] = f4207b[b6 << 2];
            i5 = length + 1;
            cArr[length] = '=';
        }
        return new String(cArr);
    }

    public static final void m6323a(InputStream inputStream, OutputStream outputStream) {
        int read;
        byte b;
        byte b2;
        byte b3;
        byte b4;
        byte[] bArr = new byte[4];
        int i = 0;
        while (true) {
            read = inputStream.read();
            if (read <= 0) {
                break;
            }
            b = (byte) read;
            if (!m6327a(b)) {
                if (m6332b(b)) {
                    break;
                }
                read = i + 1;
                bArr[i] = b;
                if (b == (byte) -1) {
                    throw new Base64DecodingException("decoding.general");
                } else if (read != 4) {
                    i = read;
                } else {
                    b2 = f4206a[bArr[0]];
                    b3 = f4206a[bArr[1]];
                    b = f4206a[bArr[2]];
                    b4 = f4206a[bArr[3]];
                    outputStream.write((byte) ((b2 << 2) | (b3 >> 4)));
                    outputStream.write((byte) (((b3 & 15) << 4) | ((b >> 2) & 15)));
                    outputStream.write((byte) ((b << 6) | b4));
                    i = 0;
                }
            }
        }
        read = i + 1;
        bArr[i] = b;
        if (read == 3) {
            i = read + 1;
            bArr[read] = (byte) inputStream.read();
        }
        b2 = bArr[0];
        byte b5 = bArr[1];
        b3 = bArr[2];
        byte b6 = bArr[3];
        b2 = f4206a[b2];
        b5 = f4206a[b5];
        b = f4206a[b3];
        b4 = f4206a[b6];
        if (b != (byte) -1 && b4 != (byte) -1) {
            outputStream.write((byte) ((b2 << 2) | (b5 >> 4)));
            outputStream.write((byte) (((b5 & 15) << 4) | ((b >> 2) & 15)));
            outputStream.write((byte) ((b << 6) | b4));
        } else if (m6332b(b3) && m6332b(b6)) {
            if ((b5 & 15) != 0) {
                throw new Base64DecodingException("decoding.general");
            }
            outputStream.write((byte) ((b2 << 2) | (b5 >> 4)));
        } else if (m6332b(b3) || !m6332b(b6)) {
            throw new Base64DecodingException("decoding.general");
        } else {
            b3 = f4206a[b3];
            if ((b3 & 3) != 0) {
                throw new Base64DecodingException("decoding.general");
            }
            outputStream.write((byte) ((b2 << 2) | (b5 >> 4)));
            outputStream.write((byte) (((b5 & 15) << 4) | ((b3 >> 2) & 15)));
        }
    }

    public static final void m6324a(String str, OutputStream outputStream) {
        byte[] bArr = new byte[str.length()];
        m6326a(bArr, outputStream, m6321a(str, bArr));
    }

    public static final void m6325a(byte[] bArr, OutputStream outputStream) {
        m6326a(bArr, outputStream, -1);
    }

    protected static final void m6326a(byte[] bArr, OutputStream outputStream, int i) {
        if (i == -1) {
            i = m6334c(bArr);
        }
        if (i % 4 != 0) {
            throw new Base64DecodingException("decoding.divisible.four");
        }
        int i2 = i / 4;
        if (i2 != 0) {
            int i3;
            byte b;
            int i4;
            byte b2;
            byte b3;
            byte b4;
            int i5 = 0;
            for (i2--; i2 > 0; i2--) {
                i3 = i5 + 1;
                b = f4206a[bArr[i5]];
                i4 = i3 + 1;
                b2 = f4206a[bArr[i3]];
                int i6 = i4 + 1;
                b3 = f4206a[bArr[i4]];
                i5 = i6 + 1;
                b4 = f4206a[bArr[i6]];
                if (b == (byte) -1 || b2 == (byte) -1 || b3 == (byte) -1 || b4 == (byte) -1) {
                    throw new Base64DecodingException("decoding.general");
                }
                outputStream.write((byte) ((b << 2) | (b2 >> 4)));
                outputStream.write((byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15)));
                outputStream.write((byte) ((b3 << 6) | b4));
            }
            int i7 = i5 + 1;
            byte b5 = f4206a[bArr[i5]];
            i3 = i7 + 1;
            byte b6 = f4206a[bArr[i7]];
            if (b5 == (byte) -1 || b6 == (byte) -1) {
                throw new Base64DecodingException("decoding.general");
            }
            byte[] bArr2 = f4206a;
            i4 = i3 + 1;
            b2 = bArr[i3];
            b = bArr2[b2];
            byte[] bArr3 = f4206a;
            int i8 = i4 + 1;
            b3 = bArr[i4];
            b4 = bArr3[b3];
            if (b != (byte) -1 && b4 != (byte) -1) {
                outputStream.write((byte) ((b5 << 2) | (b6 >> 4)));
                outputStream.write((byte) (((b6 & 15) << 4) | ((b >> 2) & 15)));
                outputStream.write((byte) ((b << 6) | b4));
            } else if (m6332b(b2) && m6332b(b3)) {
                if ((b6 & 15) != 0) {
                    throw new Base64DecodingException("decoding.general");
                }
                outputStream.write((byte) ((b5 << 2) | (b6 >> 4)));
            } else if (m6332b(b2) || !m6332b(b3)) {
                throw new Base64DecodingException("decoding.general");
            } else if ((b & 3) != 0) {
                throw new Base64DecodingException("decoding.general");
            } else {
                outputStream.write((byte) ((b5 << 2) | (b6 >> 4)));
                outputStream.write((byte) (((b6 & 15) << 4) | ((b >> 2) & 15)));
            }
        }
    }

    protected static final boolean m6327a(byte b) {
        return b == (byte) 32 || b == (byte) 13 || b == (byte) 10 || b == (byte) 9;
    }

    public static final byte[] m6328a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bArr = new byte[str.length()];
        return m6333b(bArr, m6321a(str, bArr));
    }

    public static final byte[] m6329a(Element element) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == (short) 3) {
                stringBuffer.append(((Text) firstChild).getData());
            }
        }
        return m6328a(stringBuffer.toString());
    }

    public static final byte[] m6330a(byte[] bArr) {
        return m6333b(bArr, -1);
    }

    public static final String m6331b(byte[] bArr) {
        return XMLUtils.m6389a() ? m6322a(bArr, Integer.MAX_VALUE) : m6322a(bArr, 76);
    }

    protected static final boolean m6332b(byte b) {
        return b == (byte) 61;
    }

    protected static final byte[] m6333b(byte[] bArr, int i) {
        int i2 = 0;
        if (i == -1) {
            i = m6334c(bArr);
        }
        if (i % 4 != 0) {
            throw new Base64DecodingException("decoding.divisible.four");
        }
        int i3 = i / 4;
        if (i3 == 0) {
            return new byte[0];
        }
        int i4 = (i3 - 1) * 4;
        int i5 = (i3 - 1) * 3;
        int i6 = i4 + 1;
        byte b = f4206a[bArr[i4]];
        int i7 = i6 + 1;
        byte b2 = f4206a[bArr[i6]];
        if (b == (byte) -1 || b2 == (byte) -1) {
            throw new Base64DecodingException("decoding.general");
        }
        byte[] bArr2 = f4206a;
        int i8 = i7 + 1;
        byte b3 = bArr[i7];
        byte b4 = bArr2[b3];
        bArr2 = f4206a;
        int i9 = i8 + 1;
        byte b5 = bArr[i8];
        byte b6 = bArr2[b5];
        if (b4 != (byte) -1 && b6 != (byte) -1) {
            bArr2 = new byte[(i5 + 3)];
            i7 = i5 + 1;
            bArr2[i5] = (byte) ((b << 2) | (b2 >> 4));
            i5 = i7 + 1;
            bArr2[i7] = (byte) (((b2 & 15) << 4) | ((b4 >> 2) & 15));
            int i10 = i5 + 1;
            bArr2[i5] = (byte) ((b4 << 6) | b6);
        } else if (m6332b(b3) && m6332b(b5)) {
            if ((b2 & 15) != 0) {
                throw new Base64DecodingException("decoding.general");
            }
            bArr2 = new byte[(i5 + 1)];
            bArr2[i5] = (byte) ((b << 2) | (b2 >> 4));
        } else if (m6332b(b3) || !m6332b(b5)) {
            throw new Base64DecodingException("decoding.general");
        } else if ((b4 & 3) != 0) {
            throw new Base64DecodingException("decoding.general");
        } else {
            bArr2 = new byte[(i5 + 2)];
            i7 = i5 + 1;
            bArr2[i5] = (byte) ((b << 2) | (b2 >> 4));
            bArr2[i7] = (byte) (((b2 & 15) << 4) | ((b4 >> 2) & 15));
        }
        i3 = 0;
        for (i5 = i3 - 1; i5 > 0; i5--) {
            i6 = i2 + 1;
            b = f4206a[bArr[i2]];
            i7 = i6 + 1;
            b2 = f4206a[bArr[i6]];
            i8 = i7 + 1;
            b3 = f4206a[bArr[i7]];
            i2 = i8 + 1;
            b5 = f4206a[bArr[i8]];
            if (b == (byte) -1 || b2 == (byte) -1 || b3 == (byte) -1 || b5 == (byte) -1) {
                throw new Base64DecodingException("decoding.general");
            }
            int i11 = i3 + 1;
            bArr2[i3] = (byte) ((b << 2) | (b2 >> 4));
            i10 = i11 + 1;
            bArr2[i11] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
            i3 = i10 + 1;
            bArr2[i10] = (byte) ((b3 << 6) | b5);
        }
        return bArr2;
    }

    protected static final int m6334c(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            int length = bArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3;
                byte b = bArr[i2];
                if (m6327a(b)) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                    bArr[i] = b;
                }
                i2++;
                i = i3;
            }
        }
        return i;
    }
}
