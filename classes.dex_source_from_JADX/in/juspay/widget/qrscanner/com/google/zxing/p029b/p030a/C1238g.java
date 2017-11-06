package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

final class C1238g {
    private static final int[][] f2724a = new int[][]{new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    private final C1237f f2725b;
    private final byte f2726c;

    private C1238g(int i) {
        this.f2725b = C1237f.m4700a((i >> 3) & 3);
        this.f2726c = (byte) (i & 7);
    }

    static int m4702a(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    static C1238g m4703b(int i, int i2) {
        C1238g c = C1238g.m4704c(i, i2);
        return c != null ? c : C1238g.m4704c(i ^ 21522, i2 ^ 21522);
    }

    private static C1238g m4704c(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        int[][] iArr = f2724a;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr2 = iArr[i4];
            int i6 = iArr2[0];
            if (i6 == i || i6 == i2) {
                return new C1238g(iArr2[1]);
            }
            int i7;
            int a = C1238g.m4702a(i, i6);
            if (a < i3) {
                i3 = iArr2[1];
            } else {
                a = i3;
                i3 = i5;
            }
            if (i != i2) {
                i5 = C1238g.m4702a(i2, i6);
                if (i5 < a) {
                    i3 = iArr2[1];
                    i4++;
                    i7 = i3;
                    i3 = i5;
                    i5 = i7;
                }
            }
            i5 = a;
            i4++;
            i7 = i3;
            i3 = i5;
            i5 = i7;
        }
        if (i3 <= 3) {
            return new C1238g(i5);
        }
        return null;
    }

    C1237f m4705a() {
        return this.f2725b;
    }

    byte m4706b() {
        return this.f2726c;
    }

    public int hashCode() {
        return (this.f2725b.ordinal() << 3) | this.f2726c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1238g)) {
            return false;
        }
        C1238g c1238g = (C1238g) obj;
        if (this.f2725b == c1238g.f2725b && this.f2726c == c1238g.f2726c) {
            return true;
        }
        return false;
    }
}
