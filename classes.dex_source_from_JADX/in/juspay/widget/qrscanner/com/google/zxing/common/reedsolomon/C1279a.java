package in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon;

public final class C1279a {
    public static final C1279a f2865a = new C1279a(4201, CodedOutputStream.DEFAULT_BUFFER_SIZE, 1);
    public static final C1279a f2866b = new C1279a(1033, 1024, 1);
    public static final C1279a f2867c = new C1279a(67, 64, 1);
    public static final C1279a f2868d = new C1279a(19, 16, 1);
    public static final C1279a f2869e = new C1279a(285, 256, 0);
    public static final C1279a f2870f = new C1279a(301, 256, 1);
    public static final C1279a f2871g = f2870f;
    public static final C1279a f2872h = f2867c;
    private final int[] f2873i;
    private final int[] f2874j;
    private final C1280b f2875k;
    private final C1280b f2876l;
    private final int f2877m;
    private final int f2878n;
    private final int f2879o;

    public C1279a(int i, int i2, int i3) {
        this.f2878n = i;
        this.f2877m = i2;
        this.f2879o = i3;
        this.f2873i = new int[i2];
        this.f2874j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f2873i[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (i4 = 0; i4 < i2 - 1; i4++) {
            this.f2874j[this.f2873i[i4]] = i4;
        }
        this.f2875k = new C1280b(this, new int[]{0});
        this.f2876l = new C1280b(this, new int[]{1});
    }

    C1280b m4909a() {
        return this.f2875k;
    }

    C1280b m4912b() {
        return this.f2876l;
    }

    C1280b m4910a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f2875k;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new C1280b(this, iArr);
        }
    }

    static int m4907b(int i, int i2) {
        return i ^ i2;
    }

    int m4908a(int i) {
        return this.f2873i[i];
    }

    int m4911b(int i) {
        if (i != 0) {
            return this.f2874j[i];
        }
        throw new IllegalArgumentException();
    }

    int m4914c(int i) {
        if (i != 0) {
            return this.f2873i[(this.f2877m - this.f2874j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int m4915c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.f2873i[(this.f2874j[i] + this.f2874j[i2]) % (this.f2877m - 1)];
    }

    public int m4913c() {
        return this.f2877m;
    }

    public int m4916d() {
        return this.f2879o;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f2878n) + ',' + this.f2877m + ')';
    }
}
