package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

import in.juspay.widget.qrscanner.com.google.zxing.FormatException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;

public final class C1243j {
    private static final int[] f2745a = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final C1243j[] f2746b = C1243j.m4720f();
    private final int f2747c;
    private final int[] f2748d;
    private final C1242b[] f2749e;
    private final int f2750f;

    public static final class C1241a {
        private final int f2741a;
        private final int f2742b;

        C1241a(int i, int i2) {
            this.f2741a = i;
            this.f2742b = i2;
        }

        public int m4711a() {
            return this.f2741a;
        }

        public int m4712b() {
            return this.f2742b;
        }
    }

    public static final class C1242b {
        private final int f2743a;
        private final C1241a[] f2744b;

        C1242b(int i, C1241a... c1241aArr) {
            this.f2743a = i;
            this.f2744b = c1241aArr;
        }

        public int m4713a() {
            return this.f2743a;
        }

        public int m4714b() {
            int i = 0;
            C1241a[] c1241aArr = this.f2744b;
            int i2 = 0;
            while (i < c1241aArr.length) {
                i2 += c1241aArr[i].m4711a();
                i++;
            }
            return i2;
        }

        public int m4715c() {
            return this.f2743a * m4714b();
        }

        public C1241a[] m4716d() {
            return this.f2744b;
        }
    }

    private C1243j(int i, int[] iArr, C1242b... c1242bArr) {
        int i2 = 0;
        this.f2747c = i;
        this.f2748d = iArr;
        this.f2749e = c1242bArr;
        int a = c1242bArr[0].m4713a();
        C1241a[] d = c1242bArr[0].m4716d();
        int length = d.length;
        int i3 = 0;
        while (i2 < length) {
            C1241a c1241a = d[i2];
            i3 += (c1241a.m4712b() + a) * c1241a.m4711a();
            i2++;
        }
        this.f2750f = i3;
    }

    public int m4721a() {
        return this.f2747c;
    }

    public int[] m4723b() {
        return this.f2748d;
    }

    public int m4724c() {
        return this.f2750f;
    }

    public int m4725d() {
        return (this.f2747c * 4) + 17;
    }

    public C1242b m4722a(C1237f c1237f) {
        return this.f2749e[c1237f.ordinal()];
    }

    public static C1243j m4717a(int i) {
        if (i % 4 != 1) {
            throw FormatException.m4638a();
        }
        try {
            return C1243j.m4718b((i - 17) / 4);
        } catch (IllegalArgumentException e) {
            throw FormatException.m4638a();
        }
    }

    public static C1243j m4718b(int i) {
        if (i >= 1 && i <= 40) {
            return f2746b[i - 1];
        }
        throw new IllegalArgumentException();
    }

    static C1243j m4719c(int i) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (i2 < f2745a.length) {
            int i5 = f2745a[i2];
            if (i5 == i) {
                return C1243j.m4718b(i2 + 7);
            }
            i5 = C1238g.m4702a(i, i5);
            if (i5 < i3) {
                i4 = i2 + 7;
                i3 = i5;
            }
            i2++;
        }
        if (i3 <= 3) {
            return C1243j.m4718b(i4);
        }
        return null;
    }

    C1268b m4726e() {
        int d = m4725d();
        C1268b c1268b = new C1268b(d);
        c1268b.m4863a(0, 0, 9, 9);
        c1268b.m4863a(d - 8, 0, 8, 9);
        c1268b.m4863a(0, d - 8, 9, 8);
        int length = this.f2748d.length;
        int i = 0;
        while (i < length) {
            int i2 = this.f2748d[i] - 2;
            int i3 = 0;
            while (i3 < length) {
                if (!((i == 0 && (i3 == 0 || i3 == length - 1)) || (i == length - 1 && i3 == 0))) {
                    c1268b.m4863a(this.f2748d[i3] - 2, i2, 5, 5);
                }
                i3++;
            }
            i++;
        }
        c1268b.m4863a(6, 9, 1, d - 17);
        c1268b.m4863a(9, 6, d - 17, 1);
        if (this.f2747c > 6) {
            c1268b.m4863a(d - 11, 0, 3, 6);
            c1268b.m4863a(0, d - 11, 6, 3);
        }
        return c1268b;
    }

    public String toString() {
        return String.valueOf(this.f2747c);
    }

    private static C1243j[] m4720f() {
        r0 = new C1243j[40];
        int[] iArr = new int[0];
        C1242b[] c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(7, new C1241a(1, 19));
        c1242bArr[1] = new C1242b(10, new C1241a(1, 16));
        c1242bArr[2] = new C1242b(13, new C1241a(1, 13));
        c1242bArr[3] = new C1242b(17, new C1241a(1, 9));
        r0[0] = new C1243j(1, iArr, c1242bArr);
        iArr = new int[]{6, 18};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(10, new C1241a(1, 34));
        c1242bArr[1] = new C1242b(16, new C1241a(1, 28));
        c1242bArr[2] = new C1242b(22, new C1241a(1, 22));
        c1242bArr[3] = new C1242b(28, new C1241a(1, 16));
        r0[1] = new C1243j(2, iArr, c1242bArr);
        iArr = new int[]{6, 22};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(15, new C1241a(1, 55));
        c1242bArr[1] = new C1242b(26, new C1241a(1, 44));
        c1242bArr[2] = new C1242b(18, new C1241a(2, 17));
        c1242bArr[3] = new C1242b(22, new C1241a(2, 13));
        r0[2] = new C1243j(3, iArr, c1242bArr);
        iArr = new int[]{6, 26};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(20, new C1241a(1, 80));
        c1242bArr[1] = new C1242b(18, new C1241a(2, 32));
        c1242bArr[2] = new C1242b(26, new C1241a(2, 24));
        c1242bArr[3] = new C1242b(16, new C1241a(4, 9));
        r0[3] = new C1243j(4, iArr, c1242bArr);
        iArr = new int[]{6, 30};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(26, new C1241a(1, 108));
        c1242bArr[1] = new C1242b(24, new C1241a(2, 43));
        c1242bArr[2] = new C1242b(18, new C1241a(2, 15), new C1241a(2, 16));
        c1242bArr[3] = new C1242b(22, new C1241a(2, 11), new C1241a(2, 12));
        r0[4] = new C1243j(5, iArr, c1242bArr);
        iArr = new int[]{6, 34};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(18, new C1241a(2, 68));
        c1242bArr[1] = new C1242b(16, new C1241a(4, 27));
        c1242bArr[2] = new C1242b(24, new C1241a(4, 19));
        c1242bArr[3] = new C1242b(28, new C1241a(4, 15));
        r0[5] = new C1243j(6, iArr, c1242bArr);
        iArr = new int[]{6, 22, 38};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(20, new C1241a(2, 78));
        c1242bArr[1] = new C1242b(18, new C1241a(4, 31));
        c1242bArr[2] = new C1242b(18, new C1241a(2, 14), new C1241a(4, 15));
        c1242bArr[3] = new C1242b(26, new C1241a(4, 13), new C1241a(1, 14));
        r0[6] = new C1243j(7, iArr, c1242bArr);
        iArr = new int[]{6, 24, 42};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(24, new C1241a(2, 97));
        c1242bArr[1] = new C1242b(22, new C1241a(2, 38), new C1241a(2, 39));
        c1242bArr[2] = new C1242b(22, new C1241a(4, 18), new C1241a(2, 19));
        c1242bArr[3] = new C1242b(26, new C1241a(4, 14), new C1241a(2, 15));
        r0[7] = new C1243j(8, iArr, c1242bArr);
        iArr = new int[]{6, 26, 46};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(2, 116));
        c1242bArr[1] = new C1242b(22, new C1241a(3, 36), new C1241a(2, 37));
        c1242bArr[2] = new C1242b(20, new C1241a(4, 16), new C1241a(4, 17));
        c1242bArr[3] = new C1242b(24, new C1241a(4, 12), new C1241a(4, 13));
        r0[8] = new C1243j(9, iArr, c1242bArr);
        iArr = new int[]{6, 28, 50};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(18, new C1241a(2, 68), new C1241a(2, 69));
        c1242bArr[1] = new C1242b(26, new C1241a(4, 43), new C1241a(1, 44));
        c1242bArr[2] = new C1242b(24, new C1241a(6, 19), new C1241a(2, 20));
        c1242bArr[3] = new C1242b(28, new C1241a(6, 15), new C1241a(2, 16));
        r0[9] = new C1243j(10, iArr, c1242bArr);
        iArr = new int[]{6, 30, 54};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(20, new C1241a(4, 81));
        c1242bArr[1] = new C1242b(30, new C1241a(1, 50), new C1241a(4, 51));
        c1242bArr[2] = new C1242b(28, new C1241a(4, 22), new C1241a(4, 23));
        c1242bArr[3] = new C1242b(24, new C1241a(3, 12), new C1241a(8, 13));
        r0[10] = new C1243j(11, iArr, c1242bArr);
        iArr = new int[]{6, 32, 58};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(24, new C1241a(2, 92), new C1241a(2, 93));
        c1242bArr[1] = new C1242b(22, new C1241a(6, 36), new C1241a(2, 37));
        c1242bArr[2] = new C1242b(26, new C1241a(4, 20), new C1241a(6, 21));
        c1242bArr[3] = new C1242b(28, new C1241a(7, 14), new C1241a(4, 15));
        r0[11] = new C1243j(12, iArr, c1242bArr);
        iArr = new int[]{6, 34, 62};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(26, new C1241a(4, 107));
        c1242bArr[1] = new C1242b(22, new C1241a(8, 37), new C1241a(1, 38));
        c1242bArr[2] = new C1242b(24, new C1241a(8, 20), new C1241a(4, 21));
        c1242bArr[3] = new C1242b(22, new C1241a(12, 11), new C1241a(4, 12));
        r0[12] = new C1243j(13, iArr, c1242bArr);
        iArr = new int[]{6, 26, 46, 66};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(3, 115), new C1241a(1, 116));
        c1242bArr[1] = new C1242b(24, new C1241a(4, 40), new C1241a(5, 41));
        c1242bArr[2] = new C1242b(20, new C1241a(11, 16), new C1241a(5, 17));
        c1242bArr[3] = new C1242b(24, new C1241a(11, 12), new C1241a(5, 13));
        r0[13] = new C1243j(14, iArr, c1242bArr);
        iArr = new int[]{6, 26, 48, 70};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(22, new C1241a(5, 87), new C1241a(1, 88));
        c1242bArr[1] = new C1242b(24, new C1241a(5, 41), new C1241a(5, 42));
        c1242bArr[2] = new C1242b(30, new C1241a(5, 24), new C1241a(7, 25));
        c1242bArr[3] = new C1242b(24, new C1241a(11, 12), new C1241a(7, 13));
        r0[14] = new C1243j(15, iArr, c1242bArr);
        iArr = new int[]{6, 26, 50, 74};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(24, new C1241a(5, 98), new C1241a(1, 99));
        c1242bArr[1] = new C1242b(28, new C1241a(7, 45), new C1241a(3, 46));
        c1242bArr[2] = new C1242b(24, new C1241a(15, 19), new C1241a(2, 20));
        c1242bArr[3] = new C1242b(30, new C1241a(3, 15), new C1241a(13, 16));
        r0[15] = new C1243j(16, iArr, c1242bArr);
        iArr = new int[]{6, 30, 54, 78};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(28, new C1241a(1, 107), new C1241a(5, 108));
        c1242bArr[1] = new C1242b(28, new C1241a(10, 46), new C1241a(1, 47));
        c1242bArr[2] = new C1242b(28, new C1241a(1, 22), new C1241a(15, 23));
        c1242bArr[3] = new C1242b(28, new C1241a(2, 14), new C1241a(17, 15));
        r0[16] = new C1243j(17, iArr, c1242bArr);
        iArr = new int[]{6, 30, 56, 82};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(5, 120), new C1241a(1, 121));
        c1242bArr[1] = new C1242b(26, new C1241a(9, 43), new C1241a(4, 44));
        c1242bArr[2] = new C1242b(28, new C1241a(17, 22), new C1241a(1, 23));
        c1242bArr[3] = new C1242b(28, new C1241a(2, 14), new C1241a(19, 15));
        r0[17] = new C1243j(18, iArr, c1242bArr);
        iArr = new int[]{6, 30, 58, 86};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(28, new C1241a(3, 113), new C1241a(4, 114));
        c1242bArr[1] = new C1242b(26, new C1241a(3, 44), new C1241a(11, 45));
        c1242bArr[2] = new C1242b(26, new C1241a(17, 21), new C1241a(4, 22));
        c1242bArr[3] = new C1242b(26, new C1241a(9, 13), new C1241a(16, 14));
        r0[18] = new C1243j(19, iArr, c1242bArr);
        iArr = new int[]{6, 34, 62, 90};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(28, new C1241a(3, 107), new C1241a(5, 108));
        c1242bArr[1] = new C1242b(26, new C1241a(3, 41), new C1241a(13, 42));
        c1242bArr[2] = new C1242b(30, new C1241a(15, 24), new C1241a(5, 25));
        c1242bArr[3] = new C1242b(28, new C1241a(15, 15), new C1241a(10, 16));
        r0[19] = new C1243j(20, iArr, c1242bArr);
        iArr = new int[]{6, 28, 50, 72, 94};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(28, new C1241a(4, 116), new C1241a(4, 117));
        c1242bArr[1] = new C1242b(26, new C1241a(17, 42));
        c1242bArr[2] = new C1242b(28, new C1241a(17, 22), new C1241a(6, 23));
        c1242bArr[3] = new C1242b(30, new C1241a(19, 16), new C1241a(6, 17));
        r0[20] = new C1243j(21, iArr, c1242bArr);
        iArr = new int[]{6, 26, 50, 74, 98};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(28, new C1241a(2, 111), new C1241a(7, 112));
        c1242bArr[1] = new C1242b(28, new C1241a(17, 46));
        c1242bArr[2] = new C1242b(30, new C1241a(7, 24), new C1241a(16, 25));
        c1242bArr[3] = new C1242b(24, new C1241a(34, 13));
        r0[21] = new C1243j(22, iArr, c1242bArr);
        iArr = new int[]{6, 30, 54, 78, 102};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(4, 121), new C1241a(5, 122));
        c1242bArr[1] = new C1242b(28, new C1241a(4, 47), new C1241a(14, 48));
        c1242bArr[2] = new C1242b(30, new C1241a(11, 24), new C1241a(14, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(16, 15), new C1241a(14, 16));
        r0[22] = new C1243j(23, iArr, c1242bArr);
        iArr = new int[]{6, 28, 54, 80, 106};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(6, 117), new C1241a(4, 118));
        c1242bArr[1] = new C1242b(28, new C1241a(6, 45), new C1241a(14, 46));
        c1242bArr[2] = new C1242b(30, new C1241a(11, 24), new C1241a(16, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(30, 16), new C1241a(2, 17));
        r0[23] = new C1243j(24, iArr, c1242bArr);
        iArr = new int[]{6, 32, 58, 84, 110};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(26, new C1241a(8, 106), new C1241a(4, 107));
        c1242bArr[1] = new C1242b(28, new C1241a(8, 47), new C1241a(13, 48));
        c1242bArr[2] = new C1242b(30, new C1241a(7, 24), new C1241a(22, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(22, 15), new C1241a(13, 16));
        r0[24] = new C1243j(25, iArr, c1242bArr);
        iArr = new int[]{6, 30, 58, 86, 114};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(28, new C1241a(10, 114), new C1241a(2, 115));
        c1242bArr[1] = new C1242b(28, new C1241a(19, 46), new C1241a(4, 47));
        c1242bArr[2] = new C1242b(28, new C1241a(28, 22), new C1241a(6, 23));
        c1242bArr[3] = new C1242b(30, new C1241a(33, 16), new C1241a(4, 17));
        r0[25] = new C1243j(26, iArr, c1242bArr);
        iArr = new int[]{6, 34, 62, 90, 118};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(8, 122), new C1241a(4, 123));
        c1242bArr[1] = new C1242b(28, new C1241a(22, 45), new C1241a(3, 46));
        c1242bArr[2] = new C1242b(30, new C1241a(8, 23), new C1241a(26, 24));
        c1242bArr[3] = new C1242b(30, new C1241a(12, 15), new C1241a(28, 16));
        r0[26] = new C1243j(27, iArr, c1242bArr);
        iArr = new int[]{6, 26, 50, 74, 98, 122};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(3, 117), new C1241a(10, 118));
        c1242bArr[1] = new C1242b(28, new C1241a(3, 45), new C1241a(23, 46));
        c1242bArr[2] = new C1242b(30, new C1241a(4, 24), new C1241a(31, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(11, 15), new C1241a(31, 16));
        r0[27] = new C1243j(28, iArr, c1242bArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(7, 116), new C1241a(7, 117));
        c1242bArr[1] = new C1242b(28, new C1241a(21, 45), new C1241a(7, 46));
        c1242bArr[2] = new C1242b(30, new C1241a(1, 23), new C1241a(37, 24));
        c1242bArr[3] = new C1242b(30, new C1241a(19, 15), new C1241a(26, 16));
        r0[28] = new C1243j(29, iArr, c1242bArr);
        iArr = new int[]{6, 26, 52, 78, 104, 130};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(5, 115), new C1241a(10, 116));
        c1242bArr[1] = new C1242b(28, new C1241a(19, 47), new C1241a(10, 48));
        c1242bArr[2] = new C1242b(30, new C1241a(15, 24), new C1241a(25, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(23, 15), new C1241a(25, 16));
        r0[29] = new C1243j(30, iArr, c1242bArr);
        iArr = new int[]{6, 30, 56, 82, 108, 134};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(13, 115), new C1241a(3, 116));
        c1242bArr[1] = new C1242b(28, new C1241a(2, 46), new C1241a(29, 47));
        c1242bArr[2] = new C1242b(30, new C1241a(42, 24), new C1241a(1, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(23, 15), new C1241a(28, 16));
        r0[30] = new C1243j(31, iArr, c1242bArr);
        iArr = new int[]{6, 34, 60, 86, 112, 138};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(17, 115));
        c1242bArr[1] = new C1242b(28, new C1241a(10, 46), new C1241a(23, 47));
        c1242bArr[2] = new C1242b(30, new C1241a(10, 24), new C1241a(35, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(19, 15), new C1241a(35, 16));
        r0[31] = new C1243j(32, iArr, c1242bArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(17, 115), new C1241a(1, 116));
        c1242bArr[1] = new C1242b(28, new C1241a(14, 46), new C1241a(21, 47));
        c1242bArr[2] = new C1242b(30, new C1241a(29, 24), new C1241a(19, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(11, 15), new C1241a(46, 16));
        r0[32] = new C1243j(33, iArr, c1242bArr);
        iArr = new int[]{6, 34, 62, 90, 118, 146};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(13, 115), new C1241a(6, 116));
        c1242bArr[1] = new C1242b(28, new C1241a(14, 46), new C1241a(23, 47));
        c1242bArr[2] = new C1242b(30, new C1241a(44, 24), new C1241a(7, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(59, 16), new C1241a(1, 17));
        r0[33] = new C1243j(34, iArr, c1242bArr);
        iArr = new int[]{6, 30, 54, 78, 102, 126, 150};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(12, 121), new C1241a(7, 122));
        c1242bArr[1] = new C1242b(28, new C1241a(12, 47), new C1241a(26, 48));
        c1242bArr[2] = new C1242b(30, new C1241a(39, 24), new C1241a(14, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(22, 15), new C1241a(41, 16));
        r0[34] = new C1243j(35, iArr, c1242bArr);
        iArr = new int[]{6, 24, 50, 76, 102, 128, 154};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(6, 121), new C1241a(14, 122));
        c1242bArr[1] = new C1242b(28, new C1241a(6, 47), new C1241a(34, 48));
        c1242bArr[2] = new C1242b(30, new C1241a(46, 24), new C1241a(10, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(2, 15), new C1241a(64, 16));
        r0[35] = new C1243j(36, iArr, c1242bArr);
        iArr = new int[]{6, 28, 54, 80, 106, 132, 158};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(17, 122), new C1241a(4, 123));
        c1242bArr[1] = new C1242b(28, new C1241a(29, 46), new C1241a(14, 47));
        c1242bArr[2] = new C1242b(30, new C1241a(49, 24), new C1241a(10, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(24, 15), new C1241a(46, 16));
        r0[36] = new C1243j(37, iArr, c1242bArr);
        iArr = new int[]{6, 32, 58, 84, 110, 136, 162};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(4, 122), new C1241a(18, 123));
        c1242bArr[1] = new C1242b(28, new C1241a(13, 46), new C1241a(32, 47));
        c1242bArr[2] = new C1242b(30, new C1241a(48, 24), new C1241a(14, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(42, 15), new C1241a(32, 16));
        r0[37] = new C1243j(38, iArr, c1242bArr);
        iArr = new int[]{6, 26, 54, 82, 110, 138, 166};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(20, 117), new C1241a(4, 118));
        c1242bArr[1] = new C1242b(28, new C1241a(40, 47), new C1241a(7, 48));
        c1242bArr[2] = new C1242b(30, new C1241a(43, 24), new C1241a(22, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(10, 15), new C1241a(67, 16));
        r0[38] = new C1243j(39, iArr, c1242bArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142, 170};
        c1242bArr = new C1242b[4];
        c1242bArr[0] = new C1242b(30, new C1241a(19, 118), new C1241a(6, 119));
        c1242bArr[1] = new C1242b(28, new C1241a(18, 47), new C1241a(31, 48));
        c1242bArr[2] = new C1242b(30, new C1241a(34, 24), new C1241a(34, 25));
        c1242bArr[3] = new C1242b(30, new C1241a(20, 15), new C1241a(61, 16));
        r0[39] = new C1243j(40, iArr, c1242bArr);
        return r0;
    }
}
