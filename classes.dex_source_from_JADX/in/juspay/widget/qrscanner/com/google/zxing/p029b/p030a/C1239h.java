package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

public enum C1239h {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int[] f2738k;
    private final int f2739l;

    private C1239h(int[] iArr, int i) {
        this.f2738k = iArr;
        this.f2739l = i;
    }

    public static C1239h m4707a(int i) {
        switch (i) {
            case 0:
                return TERMINATOR;
            case 1:
                return NUMERIC;
            case 2:
                return ALPHANUMERIC;
            case 3:
                return STRUCTURED_APPEND;
            case 4:
                return BYTE;
            case 5:
                return FNC1_FIRST_POSITION;
            case 7:
                return ECI;
            case 8:
                return KANJI;
            case 9:
                return FNC1_SECOND_POSITION;
            case 13:
                return HANZI;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int m4709a(C1243j c1243j) {
        int a = c1243j.m4721a();
        if (a <= 9) {
            a = 0;
        } else if (a <= 26) {
            a = 1;
        } else {
            a = 2;
        }
        return this.f2738k[a];
    }

    public int m4708a() {
        return this.f2739l;
    }
}
