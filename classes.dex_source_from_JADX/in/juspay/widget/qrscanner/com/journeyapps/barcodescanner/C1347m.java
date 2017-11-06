package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.graphics.Rect;
import in.juspay.widget.qrscanner.com.google.zxing.C1287h;

public class C1347m {
    private byte[] f3132a;
    private int f3133b;
    private int f3134c;
    private int f3135d;
    private int f3136e;
    private Rect f3137f;

    public C1347m(byte[] bArr, int i, int i2, int i3, int i4) {
        this.f3132a = bArr;
        this.f3133b = i;
        this.f3134c = i2;
        this.f3136e = i4;
        this.f3135d = i3;
        if (i * i2 > bArr.length) {
            throw new IllegalArgumentException("Image data does not match the resolution. " + i + "x" + i2 + " > " + bArr.length);
        }
    }

    public void m5155a(Rect rect) {
        this.f3137f = rect;
    }

    public boolean m5156a() {
        return this.f3136e % 180 != 0;
    }

    public C1287h m5157b() {
        byte[] a = C1347m.m5151a(this.f3136e, this.f3132a, this.f3133b, this.f3134c);
        if (m5156a()) {
            return new C1287h(a, this.f3134c, this.f3133b, this.f3137f.left, this.f3137f.top, this.f3137f.width(), this.f3137f.height(), false);
        }
        return new C1287h(a, this.f3133b, this.f3134c, this.f3137f.left, this.f3137f.top, this.f3137f.width(), this.f3137f.height(), false);
    }

    public static byte[] m5151a(int i, byte[] bArr, int i2, int i3) {
        switch (i) {
            case 90:
                return C1347m.m5152a(bArr, i2, i3);
            case 180:
                return C1347m.m5153b(bArr, i2, i3);
            case 270:
                return C1347m.m5154c(bArr, i2, i3);
            default:
                return bArr;
        }
    }

    public static byte[] m5152a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i * i2)];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        return bArr2;
    }

    public static byte[] m5153b(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i4] = bArr[i5];
            i4--;
        }
        return bArr2;
    }

    public static byte[] m5154c(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i; i5++) {
            for (i3 = i2 - 1; i3 >= 0; i3--) {
                bArr2[i4] = bArr[(i3 * i) + i5];
                i4--;
            }
        }
        return bArr2;
    }
}
