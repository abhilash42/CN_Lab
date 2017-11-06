package in.juspay.widget.qrscanner.com.google.zxing;

public final class C1287h extends C1285f {
    private final byte[] f2909a;
    private final int f2910b;
    private final int f2911c;
    private final int f2912d;
    private final int f2913e;

    public C1287h(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f2909a = bArr;
        this.f2910b = i;
        this.f2911c = i2;
        this.f2912d = i3;
        this.f2913e = i4;
        if (z) {
            m4943a(i5, i6);
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
        System.arraycopy(this.f2909a, ((this.f2913e + i) * this.f2910b) + this.f2912d, bArr, 0, b);
        return bArr;
    }

    public byte[] mo767a() {
        int i = 0;
        int b = m4935b();
        int c = m4936c();
        if (b == this.f2910b && c == this.f2911c) {
            return this.f2909a;
        }
        int i2 = b * c;
        byte[] bArr = new byte[i2];
        int i3 = (this.f2913e * this.f2910b) + this.f2912d;
        if (b == this.f2910b) {
            System.arraycopy(this.f2909a, i3, bArr, 0, i2);
            return bArr;
        }
        while (i < c) {
            System.arraycopy(this.f2909a, i3, bArr, i * b, b);
            i3 += this.f2910b;
            i++;
        }
        return bArr;
    }

    private void m4943a(int i, int i2) {
        byte[] bArr = this.f2909a;
        int i3 = this.f2912d + (this.f2913e * this.f2910b);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + (i / 2);
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i3 += this.f2910b;
        }
    }
}
