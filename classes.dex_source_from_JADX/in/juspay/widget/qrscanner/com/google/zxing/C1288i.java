package in.juspay.widget.qrscanner.com.google.zxing;

public final class C1288i extends C1285f {
    private final byte[] f2914a;
    private final int f2915b;
    private final int f2916c;
    private final int f2917d = 0;
    private final int f2918e = 0;

    public C1288i(int i, int i2, int[] iArr) {
        int i3 = 0;
        super(i, i2);
        this.f2915b = i;
        this.f2916c = i2;
        int i4 = i * i2;
        this.f2914a = new byte[i4];
        while (i3 < i4) {
            int i5 = iArr[i3];
            int i6 = (i5 >> 16) & 255;
            int i7 = (i5 >> 7) & 510;
            this.f2914a[i3] = (byte) (((i5 & 255) + (i6 + i7)) / 4);
            i3++;
        }
    }

    public byte[] mo768a(int i, byte[] bArr) {
        if (i < 0 || i >= m4936c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int b = m4935b();
        if (bArr == null || bArr.length < b) {
            bArr = new byte[b];
        }
        System.arraycopy(this.f2914a, ((this.f2918e + i) * this.f2915b) + this.f2917d, bArr, 0, b);
        return bArr;
    }

    public byte[] mo767a() {
        int i = 0;
        int b = m4935b();
        int c = m4936c();
        if (b == this.f2915b && c == this.f2916c) {
            return this.f2914a;
        }
        int i2 = b * c;
        byte[] bArr = new byte[i2];
        int i3 = (this.f2918e * this.f2915b) + this.f2917d;
        if (b == this.f2915b) {
            System.arraycopy(this.f2914a, i3, bArr, 0, i2);
            return bArr;
        }
        while (i < c) {
            System.arraycopy(this.f2914a, i3, bArr, i * b, b);
            i3 += this.f2915b;
            i++;
        }
        return bArr;
    }
}
