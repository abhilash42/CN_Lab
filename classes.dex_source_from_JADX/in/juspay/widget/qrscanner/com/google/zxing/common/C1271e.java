package in.juspay.widget.qrscanner.com.google.zxing.common;

import java.util.List;

public final class C1271e {
    private final byte[] f2839a;
    private int f2840b;
    private final String f2841c;
    private final List<byte[]> f2842d;
    private final String f2843e;
    private Object f2844f;
    private final int f2845g;
    private final int f2846h;

    public C1271e(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.f2839a = bArr;
        this.f2840b = bArr == null ? 0 : bArr.length * 8;
        this.f2841c = str;
        this.f2842d = list;
        this.f2843e = str2;
        this.f2845g = i2;
        this.f2846h = i;
    }

    public byte[] m4878a() {
        return this.f2839a;
    }

    public String m4879b() {
        return this.f2841c;
    }

    public List<byte[]> m4880c() {
        return this.f2842d;
    }

    public String m4881d() {
        return this.f2843e;
    }

    public Object m4882e() {
        return this.f2844f;
    }

    public void m4877a(Object obj) {
        this.f2844f = obj;
    }

    public boolean m4883f() {
        return this.f2845g >= 0 && this.f2846h >= 0;
    }

    public int m4884g() {
        return this.f2845g;
    }

    public int m4885h() {
        return this.f2846h;
    }
}
