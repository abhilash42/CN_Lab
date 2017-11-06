package in.juspay.widget.qrscanner.com.google.zxing.p029b.p032c;

import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1237f;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1239h;
import in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a.C1243j;

public final class C1263f {
    private C1239h f2790a;
    private C1237f f2791b;
    private C1243j f2792c;
    private int f2793d = -1;
    private C1258b f2794e;

    public C1258b m4838a() {
        return this.f2794e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.f2790a);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.f2791b);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.f2792c);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.f2793d);
        if (this.f2794e == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.f2794e);
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }

    public void m4841a(C1239h c1239h) {
        this.f2790a = c1239h;
    }

    public void m4840a(C1237f c1237f) {
        this.f2791b = c1237f;
    }

    public void m4842a(C1243j c1243j) {
        this.f2792c = c1243j;
    }

    public void m4839a(int i) {
        this.f2793d = i;
    }

    public void m4843a(C1258b c1258b) {
        this.f2794e = c1258b;
    }

    public static boolean m4837b(int i) {
        return i >= 0 && i < 8;
    }
}
