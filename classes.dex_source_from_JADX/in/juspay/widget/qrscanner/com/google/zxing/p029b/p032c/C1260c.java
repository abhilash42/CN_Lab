package in.juspay.widget.qrscanner.com.google.zxing.p029b.p032c;

import in.juspay.widget.qrscanner.com.google.zxing.C1284e;
import in.juspay.widget.qrscanner.com.google.zxing.WriterException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1267a;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1270d;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.C1279a;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.C1282d;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1237f;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1239h;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1243j;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1243j.C1242b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class C1260c {
    private static final int[] f2785a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int m4790a(C1258b c1258b) {
        return ((C1261d.m4810a(c1258b) + C1261d.m4815b(c1258b)) + C1261d.m4816c(c1258b)) + C1261d.m4817d(c1258b);
    }

    public static C1263f m4795a(String str, C1237f c1237f, Map<C1284e, ?> map) {
        C1243j a;
        String str2 = "ISO-8859-1";
        Object obj = (map == null || !map.containsKey(C1284e.CHARACTER_SET)) ? null : 1;
        if (obj != null) {
            str2 = map.get(C1284e.CHARACTER_SET).toString();
        }
        C1239h a2 = C1260c.m4792a(str, str2);
        C1267a c1267a = new C1267a();
        if (a2 == C1239h.BYTE && !(obj == null && "ISO-8859-1".equals(str2))) {
            C1270d a3 = C1270d.m4875a(str2);
            if (a3 != null) {
                C1260c.m4801a(a3, c1267a);
            }
        }
        C1260c.m4800a(a2, c1267a);
        C1267a c1267a2 = new C1267a();
        C1260c.m4803a(str, a2, c1267a2, str2);
        if (map == null || !map.containsKey(C1284e.QR_VERSION)) {
            a = C1260c.m4794a(c1237f, a2, c1267a, c1267a2);
        } else {
            a = C1243j.m4718b(Integer.parseInt(map.get(C1284e.QR_VERSION).toString()));
            if (!C1260c.m4806a(C1260c.m4789a(a2, c1267a, c1267a2, a), a, c1237f)) {
                throw new WriterException("Data too big for requested version");
            }
        }
        C1267a c1267a3 = new C1267a();
        c1267a3.m4855a(c1267a);
        C1260c.m4798a(a2 == C1239h.BYTE ? c1267a2.m4858b() : str.length(), a, a2, c1267a3);
        c1267a3.m4855a(c1267a2);
        C1242b a4 = a.m4722a(c1237f);
        int c = a.m4724c() - a4.m4715c();
        C1260c.m4799a(c, c1267a3);
        C1267a a5 = C1260c.m4796a(c1267a3, a.m4724c(), c, a4.m4714b());
        C1263f c1263f = new C1263f();
        c1263f.m4840a(c1237f);
        c1263f.m4841a(a2);
        c1263f.m4842a(a);
        int d = a.m4725d();
        C1258b c1258b = new C1258b(d, d);
        d = C1260c.m4791a(a5, c1237f, a, c1258b);
        c1263f.m4839a(d);
        C1262e.m4827a(a5, c1237f, a, d, c1258b);
        c1263f.m4843a(c1258b);
        return c1263f;
    }

    private static C1243j m4794a(C1237f c1237f, C1239h c1239h, C1267a c1267a, C1267a c1267a2) {
        return C1260c.m4793a(C1260c.m4789a(c1239h, c1267a, c1267a2, C1260c.m4793a(C1260c.m4789a(c1239h, c1267a, c1267a2, C1243j.m4718b(1)), c1237f)), c1237f);
    }

    private static int m4789a(C1239h c1239h, C1267a c1267a, C1267a c1267a2, C1243j c1243j) {
        return (c1267a.m4852a() + c1239h.m4709a(c1243j)) + c1267a2.m4852a();
    }

    static int m4788a(int i) {
        if (i < f2785a.length) {
            return f2785a[i];
        }
        return -1;
    }

    private static C1239h m4792a(String str, String str2) {
        int i = 0;
        if ("Shift_JIS".equals(str2) && C1260c.m4807a(str)) {
            return C1239h.KANJI;
        }
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            int charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i3 = 1;
            } else if (C1260c.m4788a(charAt) == -1) {
                return C1239h.BYTE;
            } else {
                i2 = 1;
            }
            i++;
        }
        if (i2 != 0) {
            return C1239h.ALPHANUMERIC;
        }
        if (i3 != 0) {
            return C1239h.NUMERIC;
        }
        return C1239h.BYTE;
    }

    private static boolean m4807a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    private static int m4791a(C1267a c1267a, C1237f c1237f, C1243j c1243j, C1258b c1258b) {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            C1262e.m4827a(c1267a, c1237f, c1243j, i3, c1258b);
            int a = C1260c.m4790a(c1258b);
            if (a < i) {
                i2 = i3;
            } else {
                a = i;
            }
            i3++;
            i = a;
        }
        return i2;
    }

    private static C1243j m4793a(int i, C1237f c1237f) {
        for (int i2 = 1; i2 <= 40; i2++) {
            C1243j b = C1243j.m4718b(i2);
            if (C1260c.m4806a(i, b, c1237f)) {
                return b;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean m4806a(int i, C1243j c1243j, C1237f c1237f) {
        return c1243j.m4724c() - c1243j.m4722a(c1237f).m4715c() >= (i + 7) / 8;
    }

    static void m4799a(int i, C1267a c1267a) {
        int i2 = i * 8;
        if (c1267a.m4852a() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + c1267a.m4852a() + " > " + i2);
        }
        int i3;
        for (i3 = 0; i3 < 4 && c1267a.m4852a() < i2; i3++) {
            c1267a.m4856a(false);
        }
        i3 = c1267a.m4852a() & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                c1267a.m4856a(false);
                i3++;
            }
        }
        int b = i - c1267a.m4858b();
        for (i3 = 0; i3 < b; i3++) {
            c1267a.m4853a((i3 & 1) == 0 ? 236 : 17, 8);
        }
        if (c1267a.m4852a() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    static void m4797a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        i7 -= i9;
        i8 -= i10;
        if (i7 != i8) {
            throw new WriterException("EC bytes mismatch");
        } else if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        } else {
            if (i != (i5 * (i10 + i8)) + ((i9 + i7) * i6)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i7;
            } else {
                iArr[0] = i10;
                iArr2[0] = i8;
            }
        }
    }

    static C1267a m4796a(C1267a c1267a, int i, int i2, int i3) {
        if (c1267a.m4858b() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        Collection<C1257a> arrayList = new ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            C1260c.m4797a(i, i2, i3, i4, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            c1267a.m4854a(i7 * 8, bArr, 0, i8);
            byte[] a = C1260c.m4808a(bArr, iArr2[0]);
            arrayList.add(new C1257a(bArr, a));
            int max = Math.max(i6, i8);
            i4++;
            i5 = Math.max(i5, a.length);
            i6 = max;
            i7 = iArr[0] + i7;
        }
        if (i2 != i7) {
            throw new WriterException("Data bytes does not match offset");
        }
        C1267a c1267a2 = new C1267a();
        for (max = 0; max < i6; max++) {
            for (C1257a a2 : arrayList) {
                byte[] a3 = a2.m4779a();
                if (max < a3.length) {
                    c1267a2.m4853a(a3[max], 8);
                }
            }
        }
        for (max = 0; max < i5; max++) {
            for (C1257a a22 : arrayList) {
                a3 = a22.m4780b();
                if (max < a3.length) {
                    c1267a2.m4853a(a3[max], 8);
                }
            }
        }
        if (i == c1267a2.m4858b()) {
            return c1267a2;
        }
        throw new WriterException("Interleaving error: " + i + " and " + c1267a2.m4858b() + " differ.");
    }

    static byte[] m4808a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new C1282d(C1279a.f2869e).m4932a(iArr, i);
        byte[] bArr2 = new byte[i];
        while (i2 < i) {
            bArr2[i2] = (byte) iArr[length + i2];
            i2++;
        }
        return bArr2;
    }

    static void m4800a(C1239h c1239h, C1267a c1267a) {
        c1267a.m4853a(c1239h.m4708a(), 4);
    }

    static void m4798a(int i, C1243j c1243j, C1239h c1239h, C1267a c1267a) {
        int a = c1239h.m4709a(c1243j);
        if (i >= (1 << a)) {
            throw new WriterException(i + " is bigger than " + ((1 << a) - 1));
        }
        c1267a.m4853a(i, a);
    }

    static void m4803a(String str, C1239h c1239h, C1267a c1267a, String str2) {
        switch (c1239h) {
            case NUMERIC:
                C1260c.m4802a((CharSequence) str, c1267a);
                return;
            case ALPHANUMERIC:
                C1260c.m4809b(str, c1267a);
                return;
            case BYTE:
                C1260c.m4805a(str, c1267a, str2);
                return;
            case KANJI:
                C1260c.m4804a(str, c1267a);
                return;
            default:
                throw new WriterException("Invalid mode: " + c1239h);
        }
    }

    static void m4802a(CharSequence charSequence, C1267a c1267a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - 48;
            if (i + 2 < length) {
                c1267a.m4853a(((charAt * 100) + ((charSequence.charAt(i + 1) - 48) * 10)) + (charSequence.charAt(i + 2) - 48), 10);
                i += 3;
            } else if (i + 1 < length) {
                c1267a.m4853a((charAt * 10) + (charSequence.charAt(i + 1) - 48), 7);
                i += 2;
            } else {
                c1267a.m4853a(charAt, 4);
                i++;
            }
        }
    }

    static void m4809b(CharSequence charSequence, C1267a c1267a) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a = C1260c.m4788a(charSequence.charAt(i));
            if (a == -1) {
                throw new WriterException();
            } else if (i + 1 < length) {
                int a2 = C1260c.m4788a(charSequence.charAt(i + 1));
                if (a2 == -1) {
                    throw new WriterException();
                }
                c1267a.m4853a((a * 45) + a2, 11);
                i += 2;
            } else {
                c1267a.m4853a(a, 6);
                i++;
            }
        }
    }

    static void m4805a(String str, C1267a c1267a, String str2) {
        try {
            for (byte a : str.getBytes(str2)) {
                c1267a.m4853a(a, 8);
            }
        } catch (Throwable e) {
            throw new WriterException(e);
        }
    }

    static void m4804a(String str, C1267a c1267a) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                if (i2 >= 33088 && i2 <= 40956) {
                    i2 -= 33088;
                } else if (i2 < 57408 || i2 > 60351) {
                    i2 = -1;
                } else {
                    i2 -= 49472;
                }
                if (i2 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                c1267a.m4853a((i2 & 255) + ((i2 >> 8) * 192), 13);
            }
        } catch (Throwable e) {
            throw new WriterException(e);
        }
    }

    private static void m4801a(C1270d c1270d, C1267a c1267a) {
        c1267a.m4853a(C1239h.ECI.m4708a(), 4);
        c1267a.m4853a(c1270d.m4876a(), 8);
    }
}
