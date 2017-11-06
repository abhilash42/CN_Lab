package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import in.juspay.widget.qrscanner.com.google.zxing.C1244j;
import in.juspay.widget.qrscanner.com.google.zxing.C1246m;
import in.juspay.widget.qrscanner.com.google.zxing.C1265c;
import in.juspay.widget.qrscanner.com.google.zxing.C1285f;
import in.juspay.widget.qrscanner.com.google.zxing.C1286g;
import in.juspay.widget.qrscanner.com.google.zxing.C1289k;
import in.juspay.widget.qrscanner.com.google.zxing.C1291n;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1276j;
import java.util.ArrayList;
import java.util.List;

public class C1337e implements C1291n {
    private C1244j f3106a;
    private List<C1246m> f3107b = new ArrayList();

    public C1337e(C1244j c1244j) {
        this.f3106a = c1244j;
    }

    public C1289k m5119a(C1285f c1285f) {
        return m5118a(m5122b(c1285f));
    }

    protected C1265c m5122b(C1285f c1285f) {
        return new C1265c(new C1276j(c1285f));
    }

    protected C1289k m5118a(C1265c c1265c) {
        this.f3107b.clear();
        C1289k b;
        try {
            if (this.f3106a instanceof C1286g) {
                b = ((C1286g) this.f3106a).m4942b(c1265c);
                return b;
            }
            b = this.f3106a.mo762a(c1265c);
            this.f3106a.mo764a();
            return b;
        } catch (Exception e) {
            b = null;
        } finally {
            this.f3106a.mo764a();
        }
    }

    public List<C1246m> m5120a() {
        return new ArrayList(this.f3107b);
    }

    public void mo782a(C1246m c1246m) {
        this.f3107b.add(c1246m);
    }
}
