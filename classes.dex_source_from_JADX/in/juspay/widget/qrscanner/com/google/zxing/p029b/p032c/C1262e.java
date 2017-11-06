package in.juspay.widget.qrscanner.com.google.zxing.p029b.p032c;

import in.juspay.widget.qrscanner.com.google.zxing.WriterException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1267a;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1237f;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1243j;

final class C1262e {
    private static final int[][] f2786a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] f2787b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] f2788c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] f2789d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void m4825a(C1258b c1258b) {
        c1258b.m4783a((byte) -1);
    }

    static void m4827a(C1267a c1267a, C1237f c1237f, C1243j c1243j, int i, C1258b c1258b) {
        C1262e.m4825a(c1258b);
        C1262e.m4823a(c1243j, c1258b);
        C1262e.m4821a(c1237f, i, c1258b);
        C1262e.m4829b(c1243j, c1258b);
        C1262e.m4826a(c1267a, i, c1258b);
    }

    static void m4823a(C1243j c1243j, C1258b c1258b) {
        C1262e.m4836d(c1258b);
        C1262e.m4834c(c1258b);
        C1262e.m4833c(c1243j, c1258b);
        C1262e.m4830b(c1258b);
    }

    static void m4821a(C1237f c1237f, int i, C1258b c1258b) {
        C1267a c1267a = new C1267a();
        C1262e.m4822a(c1237f, i, c1267a);
        for (int i2 = 0; i2 < c1267a.m4852a(); i2++) {
            boolean a = c1267a.m4857a((c1267a.m4852a() - 1) - i2);
            c1258b.m4785a(f2789d[i2][0], f2789d[i2][1], a);
            if (i2 < 8) {
                c1258b.m4785a((c1258b.m4786b() - i2) - 1, 8, a);
            } else {
                c1258b.m4785a(8, (c1258b.m4782a() - 7) + (i2 - 8), a);
            }
        }
    }

    static void m4829b(C1243j c1243j, C1258b c1258b) {
        if (c1243j.m4721a() >= 7) {
            C1267a c1267a = new C1267a();
            C1262e.m4824a(c1243j, c1267a);
            int i = 17;
            int i2 = 0;
            while (i2 < 6) {
                int i3 = i;
                for (i = 0; i < 3; i++) {
                    boolean a = c1267a.m4857a(i3);
                    i3--;
                    c1258b.m4785a(i2, (c1258b.m4782a() - 11) + i, a);
                    c1258b.m4785a((c1258b.m4782a() - 11) + i, i2, a);
                }
                i2++;
                i = i3;
            }
        }
    }

    static void m4826a(C1267a c1267a, int i, C1258b c1258b) {
        int b = c1258b.m4786b() - 1;
        int a = c1258b.m4782a() - 1;
        int i2 = -1;
        int i3 = 0;
        while (b > 0) {
            int i4;
            int i5;
            if (b == 6) {
                i4 = a;
                i5 = b - 1;
                a = i3;
            } else {
                i4 = a;
                i5 = b;
                a = i3;
            }
            while (i4 >= 0 && i4 < c1258b.m4782a()) {
                for (i3 = 0; i3 < 2; i3++) {
                    int i6 = i5 - i3;
                    if (C1262e.m4831b(c1258b.m4781a(i6, i4))) {
                        boolean z;
                        if (a < c1267a.m4852a()) {
                            boolean a2 = c1267a.m4857a(a);
                            b = a + 1;
                            z = a2;
                        } else {
                            b = a;
                            z = false;
                        }
                        if (i != -1 && C1261d.m4812a(i, i6, i4)) {
                            if (z) {
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                        c1258b.m4785a(i6, i4, z);
                        a = b;
                    }
                }
                i4 += i2;
            }
            i2 = -i2;
            b = i5 - 2;
            i3 = a;
            a = i4 + i2;
        }
        if (i3 != c1267a.m4852a()) {
            throw new WriterException("Not all bits consumed: " + i3 + '/' + c1267a.m4852a());
        }
    }

    static int m4818a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    static int m4819a(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int a = C1262e.m4818a(i2);
        int i3 = i << (a - 1);
        while (C1262e.m4818a(i3) >= a) {
            i3 ^= i2 << (C1262e.m4818a(i3) - a);
        }
        return i3;
    }

    static void m4822a(C1237f c1237f, int i, C1267a c1267a) {
        if (C1263f.m4837b(i)) {
            int a = (c1237f.m4701a() << 3) | i;
            c1267a.m4853a(a, 5);
            c1267a.m4853a(C1262e.m4819a(a, 1335), 10);
            C1267a c1267a2 = new C1267a();
            c1267a2.m4853a(21522, 15);
            c1267a.m4859b(c1267a2);
            if (c1267a.m4852a() != 15) {
                throw new WriterException("should not happen but we got: " + c1267a.m4852a());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void m4824a(C1243j c1243j, C1267a c1267a) {
        c1267a.m4853a(c1243j.m4721a(), 6);
        c1267a.m4853a(C1262e.m4819a(c1243j.m4721a(), 7973), 12);
        if (c1267a.m4852a() != 18) {
            throw new WriterException("should not happen but we got: " + c1267a.m4852a());
        }
    }

    private static boolean m4831b(int i) {
        return i == -1;
    }

    private static void m4830b(C1258b c1258b) {
        for (int i = 8; i < c1258b.m4786b() - 8; i++) {
            int i2 = (i + 1) % 2;
            if (C1262e.m4831b(c1258b.m4781a(i, 6))) {
                c1258b.m4784a(i, 6, i2);
            }
            if (C1262e.m4831b(c1258b.m4781a(6, i))) {
                c1258b.m4784a(6, i, i2);
            }
        }
    }

    private static void m4834c(C1258b c1258b) {
        if (c1258b.m4781a(8, c1258b.m4782a() - 8) == (byte) 0) {
            throw new WriterException();
        }
        c1258b.m4784a(8, c1258b.m4782a() - 8, 1);
    }

    private static void m4820a(int i, int i2, C1258b c1258b) {
        int i3 = 0;
        while (i3 < 8) {
            if (C1262e.m4831b(c1258b.m4781a(i + i3, i2))) {
                c1258b.m4784a(i + i3, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void m4828b(int i, int i2, C1258b c1258b) {
        int i3 = 0;
        while (i3 < 7) {
            if (C1262e.m4831b(c1258b.m4781a(i, i2 + i3))) {
                c1258b.m4784a(i, i2 + i3, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void m4832c(int i, int i2, C1258b c1258b) {
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                c1258b.m4784a(i + i4, i2 + i3, f2787b[i3][i4]);
            }
        }
    }

    private static void m4835d(int i, int i2, C1258b c1258b) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                c1258b.m4784a(i + i4, i2 + i3, f2786a[i3][i4]);
            }
        }
    }

    private static void m4836d(C1258b c1258b) {
        int length = f2786a[0].length;
        C1262e.m4835d(0, 0, c1258b);
        C1262e.m4835d(c1258b.m4786b() - length, 0, c1258b);
        C1262e.m4835d(0, c1258b.m4786b() - length, c1258b);
        C1262e.m4820a(0, 7, c1258b);
        C1262e.m4820a(c1258b.m4786b() - 8, 7, c1258b);
        C1262e.m4820a(0, c1258b.m4786b() - 8, c1258b);
        C1262e.m4828b(7, 0, c1258b);
        C1262e.m4828b((c1258b.m4782a() - 7) - 1, 0, c1258b);
        C1262e.m4828b(7, c1258b.m4782a() - 7, c1258b);
    }

    private static void m4833c(C1243j c1243j, C1258b c1258b) {
        if (c1243j.m4721a() >= 2) {
            int a = c1243j.m4721a() - 1;
            int[] iArr = f2788c[a];
            int length = f2788c[a].length;
            for (int i = 0; i < length; i++) {
                for (a = 0; a < length; a++) {
                    int i2 = iArr[i];
                    int i3 = iArr[a];
                    if (!(i3 == -1 || i2 == -1 || !C1262e.m4831b(c1258b.m4781a(i3, i2)))) {
                        C1262e.m4832c(i3 - 2, i2 - 2, c1258b);
                    }
                }
            }
        }
    }
}
