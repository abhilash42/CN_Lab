package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

import in.juspay.widget.qrscanner.com.google.zxing.C1283d;
import in.juspay.widget.qrscanner.com.google.zxing.FormatException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1269c;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1270d;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1271e;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1278l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class C1235d {
    private static final char[] f2715a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    static C1271e m4691a(byte[] bArr, C1243j c1243j, C1237f c1237f, Map<C1283d, ?> map) {
        int i;
        int i2;
        String str;
        C1269c c1269c = new C1269c(bArr);
        StringBuilder stringBuilder = new StringBuilder(50);
        List arrayList = new ArrayList(1);
        C1270d c1270d = null;
        int i3 = -1;
        int i4 = -1;
        boolean z = false;
        while (true) {
            C1239h c1239h;
            boolean z2;
            if (c1269c.m4872a() < 4) {
                c1239h = C1239h.TERMINATOR;
            } else {
                c1239h = C1239h.m4707a(c1269c.m4873a(4));
            }
            if (c1239h == C1239h.TERMINATOR) {
                z2 = z;
                i = i4;
                i2 = i3;
            } else if (c1239h == C1239h.FNC1_FIRST_POSITION || c1239h == C1239h.FNC1_SECOND_POSITION) {
                z2 = true;
                i = i4;
                i2 = i3;
            } else if (c1239h == C1239h.STRUCTURED_APPEND) {
                if (c1269c.m4872a() < 16) {
                    throw FormatException.m4638a();
                }
                try {
                    z2 = z;
                    i = c1269c.m4873a(8);
                    i2 = c1269c.m4873a(8);
                } catch (IllegalArgumentException e) {
                    throw FormatException.m4638a();
                }
            } else if (c1239h == C1239h.ECI) {
                c1270d = C1270d.m4874a(C1235d.m4690a(c1269c));
                if (c1270d == null) {
                    throw FormatException.m4638a();
                }
                z2 = z;
                i = i4;
                i2 = i3;
            } else if (c1239h == C1239h.HANZI) {
                r2 = c1269c.m4873a(4);
                i = c1269c.m4873a(c1239h.m4709a(c1243j));
                if (r2 == 1) {
                    C1235d.m4692a(c1269c, stringBuilder, i);
                }
                z2 = z;
                i = i4;
                i2 = i3;
            } else {
                r2 = c1269c.m4873a(c1239h.m4709a(c1243j));
                if (c1239h == C1239h.NUMERIC) {
                    C1235d.m4696c(c1269c, stringBuilder, r2);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else if (c1239h == C1239h.ALPHANUMERIC) {
                    C1235d.m4694a(c1269c, stringBuilder, r2, z);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else if (c1239h == C1239h.BYTE) {
                    C1235d.m4693a(c1269c, stringBuilder, r2, c1270d, arrayList, map);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else if (c1239h == C1239h.KANJI) {
                    C1235d.m4695b(c1269c, stringBuilder, r2);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else {
                    throw FormatException.m4638a();
                }
            }
            if (c1239h == C1239h.TERMINATOR) {
                break;
            }
            i3 = i2;
            i4 = i;
            z = z2;
        }
        String stringBuilder2 = stringBuilder.toString();
        List list = arrayList.isEmpty() ? null : arrayList;
        if (c1237f == null) {
            str = null;
        } else {
            str = c1237f.toString();
        }
        return new C1271e(bArr, stringBuilder2, list, str, i, i2);
    }

    private static void m4692a(C1269c c1269c, StringBuilder stringBuilder, int i) {
        if (i * 13 > c1269c.m4872a()) {
            throw FormatException.m4638a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = c1269c.m4873a(13);
            a = (a % 96) | ((a / 96) << 8);
            if (a < 959) {
                a += 41377;
            } else {
                a += 42657;
            }
            bArr[i2] = (byte) ((a >> 8) & 255);
            bArr[i2 + 1] = (byte) (a & 255);
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.m4638a();
        }
    }

    private static void m4695b(C1269c c1269c, StringBuilder stringBuilder, int i) {
        if (i * 13 > c1269c.m4872a()) {
            throw FormatException.m4638a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = c1269c.m4873a(13);
            a = (a % 192) | ((a / 192) << 8);
            if (a < 7936) {
                a += 33088;
            } else {
                a += 49472;
            }
            bArr[i2] = (byte) (a >> 8);
            bArr[i2 + 1] = (byte) a;
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.m4638a();
        }
    }

    private static void m4693a(C1269c c1269c, StringBuilder stringBuilder, int i, C1270d c1270d, Collection<byte[]> collection, Map<C1283d, ?> map) {
        if (i * 8 > c1269c.m4872a()) {
            throw FormatException.m4638a();
        }
        String a;
        Object obj = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            obj[i2] = (byte) c1269c.m4873a(8);
        }
        if (c1270d == null) {
            a = C1278l.m4906a(obj, map);
        } else {
            a = c1270d.name();
        }
        try {
            stringBuilder.append(new String(obj, a));
            collection.add(obj);
        } catch (UnsupportedEncodingException e) {
            throw FormatException.m4638a();
        }
    }

    private static char m4689a(int i) {
        if (i < f2715a.length) {
            return f2715a[i];
        }
        throw FormatException.m4638a();
    }

    private static void m4694a(C1269c c1269c, StringBuilder stringBuilder, int i, boolean z) {
        int length = stringBuilder.length();
        while (i > 1) {
            if (c1269c.m4872a() < 11) {
                throw FormatException.m4638a();
            }
            int a = c1269c.m4873a(11);
            stringBuilder.append(C1235d.m4689a(a / 45));
            stringBuilder.append(C1235d.m4689a(a % 45));
            i -= 2;
        }
        if (i == 1) {
            if (c1269c.m4872a() < 6) {
                throw FormatException.m4638a();
            }
            stringBuilder.append(C1235d.m4689a(c1269c.m4873a(6)));
        }
        if (z) {
            while (length < stringBuilder.length()) {
                if (stringBuilder.charAt(length) == '%') {
                    if (length >= stringBuilder.length() - 1 || stringBuilder.charAt(length + 1) != '%') {
                        stringBuilder.setCharAt(length, '\u001d');
                    } else {
                        stringBuilder.deleteCharAt(length + 1);
                    }
                }
                length++;
            }
        }
    }

    private static void m4696c(C1269c c1269c, StringBuilder stringBuilder, int i) {
        while (i >= 3) {
            if (c1269c.m4872a() < 10) {
                throw FormatException.m4638a();
            }
            int a = c1269c.m4873a(10);
            if (a >= 1000) {
                throw FormatException.m4638a();
            }
            stringBuilder.append(C1235d.m4689a(a / 100));
            stringBuilder.append(C1235d.m4689a((a / 10) % 10));
            stringBuilder.append(C1235d.m4689a(a % 10));
            i -= 3;
        }
        if (i == 2) {
            if (c1269c.m4872a() < 7) {
                throw FormatException.m4638a();
            }
            a = c1269c.m4873a(7);
            if (a >= 100) {
                throw FormatException.m4638a();
            }
            stringBuilder.append(C1235d.m4689a(a / 10));
            stringBuilder.append(C1235d.m4689a(a % 10));
        } else if (i != 1) {
        } else {
            if (c1269c.m4872a() < 4) {
                throw FormatException.m4638a();
            }
            a = c1269c.m4873a(4);
            if (a >= 10) {
                throw FormatException.m4638a();
            }
            stringBuilder.append(C1235d.m4689a(a));
        }
    }

    private static int m4690a(C1269c c1269c) {
        int a = c1269c.m4873a(8);
        if ((a & 128) == 0) {
            return a & 127;
        }
        if ((a & 192) == 128) {
            return ((a & 63) << 8) | c1269c.m4873a(8);
        } else if ((a & 224) == 192) {
            return ((a & 31) << 16) | c1269c.m4873a(16);
        } else {
            throw FormatException.m4638a();
        }
    }
}
