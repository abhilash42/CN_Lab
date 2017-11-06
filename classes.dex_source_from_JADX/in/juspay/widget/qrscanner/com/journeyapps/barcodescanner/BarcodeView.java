package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import in.juspay.widget.qrscanner.C1211a.C1206b;
import in.juspay.widget.qrscanner.com.google.zxing.C1283d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BarcodeView extends C1294c {
    private C1293a f2970a = C1293a.NONE;
    private C1296a f2971b = null;
    private C1342h f2972c;
    private C1338f f2973d;
    private Handler f2974e;
    private final Callback f2975f = new C12921(this);

    class C12921 implements Callback {
        final /* synthetic */ BarcodeView f2938a;

        C12921(BarcodeView barcodeView) {
            this.f2938a = barcodeView;
        }

        public boolean handleMessage(Message message) {
            if (message.what == C1206b.zxing_decode_succeeded) {
                C1324b c1324b = (C1324b) message.obj;
                if (!(c1324b == null || this.f2938a.f2971b == null || this.f2938a.f2970a == C1293a.NONE)) {
                    this.f2938a.f2971b.mo773a(c1324b);
                    if (this.f2938a.f2970a == C1293a.SINGLE) {
                        this.f2938a.mo769a();
                    }
                }
                return true;
            } else if (message.what == C1206b.zxing_decode_failed) {
                return true;
            } else {
                if (message.what != C1206b.zxing_possible_result_points) {
                    return false;
                }
                List list = (List) message.obj;
                if (!(this.f2938a.f2971b == null || this.f2938a.f2970a == C1293a.NONE)) {
                    this.f2938a.f2971b.mo774a(list);
                }
                return true;
            }
        }
    }

    private enum C1293a {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context) {
        super(context);
        m4979a(context, null);
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4979a(context, attributeSet);
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4979a(context, attributeSet);
    }

    private void m4979a(Context context, AttributeSet attributeSet) {
        this.f2973d = new C1343i();
        this.f2974e = new Handler(this.f2975f);
    }

    public void setDecoderFactory(C1338f c1338f) {
        C1348n.m5158a();
        this.f2973d = c1338f;
        if (this.f2972c != null) {
            this.f2972c.m5138a(m4981i());
        }
    }

    private C1337e m4981i() {
        if (this.f2973d == null) {
            this.f2973d = mo770b();
        }
        C1339g c1339g = new C1339g();
        Map hashMap = new HashMap();
        hashMap.put(C1283d.NEED_RESULT_POINT_CALLBACK, c1339g);
        C1337e a = this.f2973d.mo785a(hashMap);
        c1339g.m5125a(a);
        return a;
    }

    public C1338f getDecoderFactory() {
        return this.f2973d;
    }

    public void m4985a(C1296a c1296a) {
        this.f2970a = C1293a.SINGLE;
        this.f2971b = c1296a;
        m4982j();
    }

    public void mo769a() {
        this.f2970a = C1293a.NONE;
        this.f2971b = null;
        m4983k();
    }

    protected C1338f mo770b() {
        return new C1343i();
    }

    private void m4982j() {
        m4983k();
        if (this.f2970a != C1293a.NONE && m4977h()) {
            this.f2972c = new C1342h(getCameraInstance(), m4981i(), this.f2974e);
            this.f2972c.m5137a(getPreviewFramingRect());
            this.f2972c.m5136a();
        }
    }

    protected void mo771c() {
        super.mo771c();
        m4982j();
    }

    private void m4983k() {
        if (this.f2972c != null) {
            this.f2972c.m5139b();
            this.f2972c = null;
        }
    }

    public void mo772d() {
        m4983k();
        super.mo772d();
    }
}
