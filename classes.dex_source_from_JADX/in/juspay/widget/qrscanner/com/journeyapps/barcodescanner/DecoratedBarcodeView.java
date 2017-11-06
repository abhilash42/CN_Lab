package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import in.juspay.widget.qrscanner.C1211a.C1206b;
import in.juspay.widget.qrscanner.C1211a.C1207c;
import in.juspay.widget.qrscanner.C1211a.C1210f;
import in.juspay.widget.qrscanner.com.google.zxing.C1246m;
import java.util.List;

public class DecoratedBarcodeView extends FrameLayout {
    private BarcodeView f2978a;
    private ViewfinderView f2979b;
    private TextView f2980c;
    private C1295a f2981d;

    public interface C1295a {
        void m4989a();

        void m4990b();
    }

    private class C1297b implements C1296a {
        final /* synthetic */ DecoratedBarcodeView f2976a;
        private C1296a f2977b;

        public C1297b(DecoratedBarcodeView decoratedBarcodeView, C1296a c1296a) {
            this.f2976a = decoratedBarcodeView;
            this.f2977b = c1296a;
        }

        public void mo773a(C1324b c1324b) {
            this.f2977b.mo773a(c1324b);
        }

        public void mo774a(List<C1246m> list) {
            for (C1246m a : list) {
                this.f2976a.f2979b.m5012a(a);
            }
            this.f2977b.mo774a((List) list);
        }
    }

    public DecoratedBarcodeView(Context context) {
        super(context);
        m4997e();
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4996a(attributeSet);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4996a(attributeSet);
    }

    private void m4996a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1210f.zxing_view);
        int resourceId = obtainStyledAttributes.getResourceId(C1210f.zxing_view_zxing_scanner_layout, C1207c.zxing_barcode_scanner);
        obtainStyledAttributes.recycle();
        inflate(getContext(), resourceId, this);
        this.f2978a = (BarcodeView) findViewById(C1206b.zxing_barcode_surface);
        if (this.f2978a == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        this.f2978a.m4970a(attributeSet);
        this.f2979b = (ViewfinderView) findViewById(C1206b.zxing_viewfinder_view);
        if (this.f2979b == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        this.f2979b.setCameraPreview(this.f2978a);
        this.f2980c = (TextView) findViewById(C1206b.zxing_status_view);
    }

    private void m4997e() {
        m4996a(null);
    }

    public void setStatusText(String str) {
        if (this.f2980c != null) {
            this.f2980c.setText(str);
        }
    }

    public void m4998a() {
        this.f2978a.mo772d();
    }

    public void m5000b() {
        this.f2978a.m4974e();
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(C1206b.zxing_barcode_surface);
    }

    public ViewfinderView getViewFinder() {
        return this.f2979b;
    }

    public TextView getStatusView() {
        return this.f2980c;
    }

    public void m4999a(C1296a c1296a) {
        this.f2978a.m4985a(new C1297b(this, c1296a));
    }

    public void m5001c() {
        this.f2978a.setTorch(true);
        if (this.f2981d != null) {
            this.f2981d.m4989a();
        }
    }

    public void m5002d() {
        this.f2978a.setTorch(false);
        if (this.f2981d != null) {
            this.f2981d.m4990b();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 24:
                m5001c();
                return true;
            case 25:
                m5002d();
                return true;
            case 27:
            case 80:
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void setTorchListener(C1295a c1295a) {
        this.f2981d = c1295a;
    }
}
