package in.org.npci.commonlibrary;

import java.io.UnsupportedEncodingException;

public class C1351a {
    static final /* synthetic */ boolean f3139a = (!C1351a.class.desiredAssertionStatus());

    private C1351a() {
    }

    public static byte[] m5163a(String str, int i) {
        return C1351a.m5164a(str.getBytes(), i);
    }

    public static byte[] m5164a(byte[] bArr, int i) {
        return C1351a.m5165a(bArr, 0, bArr.length, i);
    }

    public static byte[] m5165a(byte[] bArr, int i, int i2, int i3) {
        C1353c c1353c = new C1353c(i3, new byte[((i2 * 3) / 4)]);
        if (!c1353c.m5169a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c1353c.b == c1353c.a.length) {
            return c1353c.a;
        } else {
            Object obj = new byte[c1353c.b];
            System.arraycopy(c1353c.a, 0, obj, 0, c1353c.b);
            return obj;
        }
    }

    public static String m5166b(byte[] bArr, int i) {
        try {
            return new String(C1351a.m5168c(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] m5167b(byte[] bArr, int i, int i2, int i3) {
        C1354d c1354d = new C1354d(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c1354d.f3151d) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c1354d.f3152e && i2 > 0) {
            i4 += (c1354d.f3153f ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        c1354d.a = new byte[i4];
        c1354d.m5170a(bArr, i, i2, true);
        if (f3139a || c1354d.b == i4) {
            return c1354d.a;
        }
        throw new AssertionError();
    }

    public static byte[] m5168c(byte[] bArr, int i) {
        return C1351a.m5167b(bArr, 0, bArr.length, i);
    }
}
