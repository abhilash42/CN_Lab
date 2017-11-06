package in.juspay.widget.qrscanner.com.google.zxing;

import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;

public final class C1265c {
    private final C1264b f2796a;
    private C1268b f2797b;

    public C1265c(C1264b c1264b) {
        if (c1264b == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f2796a = c1264b;
    }

    public C1268b m4846a() {
        if (this.f2797b == null) {
            this.f2797b = this.f2796a.mo766b();
        }
        return this.f2797b;
    }

    public String toString() {
        try {
            return m4846a().toString();
        } catch (NotFoundException e) {
            return "";
        }
    }
}
