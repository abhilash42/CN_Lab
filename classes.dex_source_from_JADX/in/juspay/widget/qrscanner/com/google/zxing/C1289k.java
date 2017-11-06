package in.juspay.widget.qrscanner.com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class C1289k {
    private final String f2919a;
    private final byte[] f2920b;
    private final int f2921c;
    private C1246m[] f2922d;
    private final C1223a f2923e;
    private Map<C1290l, Object> f2924f;
    private final long f2925g;

    public C1289k(String str, byte[] bArr, C1246m[] c1246mArr, C1223a c1223a) {
        this(str, bArr, c1246mArr, c1223a, System.currentTimeMillis());
    }

    public C1289k(String str, byte[] bArr, C1246m[] c1246mArr, C1223a c1223a, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, c1246mArr, c1223a, j);
    }

    public C1289k(String str, byte[] bArr, int i, C1246m[] c1246mArr, C1223a c1223a, long j) {
        this.f2919a = str;
        this.f2920b = bArr;
        this.f2921c = i;
        this.f2922d = c1246mArr;
        this.f2923e = c1223a;
        this.f2924f = null;
        this.f2925g = j;
    }

    public String m4948a() {
        return this.f2919a;
    }

    public void m4949a(C1290l c1290l, Object obj) {
        if (this.f2924f == null) {
            this.f2924f = new EnumMap(C1290l.class);
        }
        this.f2924f.put(c1290l, obj);
    }

    public String toString() {
        return this.f2919a;
    }
}
