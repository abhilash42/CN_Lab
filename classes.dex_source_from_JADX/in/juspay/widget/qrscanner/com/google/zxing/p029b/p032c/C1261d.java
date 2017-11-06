package in.juspay.widget.qrscanner.com.google.zxing.p029b.p032c;

final class C1261d {
    static int m4810a(C1258b c1258b) {
        return C1261d.m4811a(c1258b, true) + C1261d.m4811a(c1258b, false);
    }

    static int m4815b(C1258b c1258b) {
        byte[][] c = c1258b.m4787c();
        int b = c1258b.m4786b();
        int a = c1258b.m4782a();
        int i = 0;
        int i2 = 0;
        while (i < a - 1) {
            int i3 = 0;
            while (i3 < b - 1) {
                byte b2 = c[i][i3];
                if (b2 == c[i][i3 + 1] && b2 == c[i + 1][i3] && b2 == c[i + 1][i3 + 1]) {
                    i2++;
                }
                i3++;
            }
            i++;
        }
        return i2 * 3;
    }

    static int m4816c(C1258b c1258b) {
        byte[][] c = c1258b.m4787c();
        int b = c1258b.m4786b();
        int a = c1258b.m4782a();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            int i3 = 0;
            while (i3 < b) {
                byte[] bArr = c[i];
                if (i3 + 6 < b && bArr[i3] == (byte) 1 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 1 && bArr[i3 + 3] == (byte) 1 && bArr[i3 + 4] == (byte) 1 && bArr[i3 + 5] == (byte) 0 && bArr[i3 + 6] == (byte) 1 && (C1261d.m4813a(bArr, i3 - 4, i3) || C1261d.m4813a(bArr, i3 + 7, i3 + 11))) {
                    i2++;
                }
                if (i + 6 < a && c[i][i3] == (byte) 1 && c[i + 1][i3] == (byte) 0 && c[i + 2][i3] == (byte) 1 && c[i + 3][i3] == (byte) 1 && c[i + 4][i3] == (byte) 1 && c[i + 5][i3] == (byte) 0 && c[i + 6][i3] == (byte) 1 && (C1261d.m4814a(c, i3, i - 4, i) || C1261d.m4814a(c, i3, i + 7, i + 11))) {
                    i2++;
                }
                i3++;
            }
            i++;
        }
        return i2 * 40;
    }

    private static boolean m4813a(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean m4814a(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    static int m4817d(C1258b c1258b) {
        int i;
        byte[][] c = c1258b.m4787c();
        int b = c1258b.m4786b();
        int a = c1258b.m4782a();
        int i2 = 0;
        for (int i3 = 0; i3 < a; i3++) {
            byte[] bArr = c[i3];
            for (i = 0; i < b; i++) {
                if (bArr[i] == (byte) 1) {
                    i2++;
                }
            }
        }
        i = c1258b.m4782a() * c1258b.m4786b();
        return ((Math.abs((i2 * 2) - i) * 10) / i) * 10;
    }

    static boolean m4812a(int i, int i2, int i3) {
        int i4;
        switch (i) {
            case 0:
                i4 = (i3 + i2) & 1;
                break;
            case 1:
                i4 = i3 & 1;
                break;
            case 2:
                i4 = i2 % 3;
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                break;
            case 4:
                i4 = ((i3 / 2) + (i2 / 3)) & 1;
                break;
            case 5:
                i4 = i3 * i2;
                i4 = (i4 % 3) + (i4 & 1);
                break;
            case 6:
                i4 = i3 * i2;
                i4 = ((i4 % 3) + (i4 & 1)) & 1;
                break;
            case 7:
                i4 = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i);
        }
        if (i4 == 0) {
            return true;
        }
        return false;
    }

    private static int m4811a(C1258b c1258b, boolean z) {
        int a = z ? c1258b.m4782a() : c1258b.m4786b();
        int b = z ? c1258b.m4786b() : c1258b.m4782a();
        byte[][] c = c1258b.m4787c();
        int i = 0;
        int i2 = 0;
        while (i < a) {
            byte b2 = (byte) -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < b) {
                int i5;
                int i6;
                byte b3;
                byte b4 = z ? c[i][i3] : c[i3][i];
                byte b5;
                if (b4 == b2) {
                    b5 = b2;
                    i5 = i4 + 1;
                    i6 = i2;
                    b3 = b5;
                } else {
                    if (i4 >= 5) {
                        i2 += (i4 - 5) + 3;
                    }
                    i5 = 1;
                    b5 = b4;
                    i6 = i2;
                    b3 = b5;
                }
                i3++;
                i4 = i5;
                b2 = b3;
                i2 = i6;
            }
            if (i4 >= 5) {
                i2 += (i4 - 5) + 3;
            }
            i++;
        }
        return i2;
    }
}
