package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

public enum C1237f {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final C1237f[] f2721e = null;
    private final int f2723f;

    static {
        f2721e = new C1237f[]{M, L, H, Q};
    }

    private C1237f(int i) {
        this.f2723f = i;
    }

    public int m4701a() {
        return this.f2723f;
    }

    public static C1237f m4700a(int i) {
        if (i >= 0 && i < f2721e.length) {
            return f2721e[i];
        }
        throw new IllegalArgumentException();
    }
}
