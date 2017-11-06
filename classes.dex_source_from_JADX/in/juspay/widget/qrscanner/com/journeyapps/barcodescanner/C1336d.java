package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import in.juspay.widget.qrscanner.C1211a.C1209e;
import in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a.C1218b;
import in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a.C1222c;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1294c.C1298a;

public class C1336d {
    private static final String f3093a = C1336d.class.getSimpleName();
    private static int f3094b = 250;
    private Activity f3095c;
    private DecoratedBarcodeView f3096d;
    private int f3097e = -1;
    private boolean f3098f = false;
    private boolean f3099g = false;
    private C1222c f3100h;
    private C1218b f3101i;
    private Handler f3102j;
    private C1296a f3103k = null;
    private final C1298a f3104l = new C13321(this);
    private boolean f3105m = false;

    class C13321 implements C1298a {
        final /* synthetic */ C1336d f3089a;

        C13321(C1336d c1336d) {
            this.f3089a = c1336d;
        }

        public void mo775a() {
        }

        public void mo777b() {
        }

        public void mo778c() {
        }

        public void mo776a(Exception exception) {
            this.f3089a.m5117e();
        }
    }

    class C13332 implements Runnable {
        final /* synthetic */ C1336d f3090a;

        C13332(C1336d c1336d) {
            this.f3090a = c1336d;
        }

        public void run() {
            this.f3090a.m5111f();
        }
    }

    class C13343 implements OnClickListener {
        final /* synthetic */ C1336d f3091a;

        C13343(C1336d c1336d) {
            this.f3091a = c1336d;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f3091a.m5111f();
        }
    }

    class C13354 implements OnCancelListener {
        final /* synthetic */ C1336d f3092a;

        C13354(C1336d c1336d) {
            this.f3092a = c1336d;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f3092a.m5111f();
        }
    }

    public void m5113a(C1296a c1296a) {
        this.f3103k = c1296a;
    }

    public C1336d(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        this.f3095c = activity;
        this.f3096d = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().m4971a(this.f3104l);
        this.f3102j = new Handler();
        this.f3100h = new C1222c(activity, new C13332(this));
        this.f3101i = new C1218b(activity);
    }

    public void m5112a() {
        this.f3096d.m4999a(this.f3103k);
    }

    public void m5114b() {
        this.f3096d.m5000b();
        this.f3100h.m4667b();
    }

    public void m5115c() {
        this.f3096d.m4998a();
        this.f3100h.m4668c();
    }

    public void m5116d() {
        this.f3099g = true;
        this.f3100h.m4668c();
    }

    private void m5111f() {
        this.f3095c.finish();
    }

    protected void m5117e() {
        if (!this.f3095c.isFinishing() && !this.f3099g) {
            Builder builder = new Builder(this.f3095c);
            builder.setTitle(this.f3095c.getString(C1209e.zxing_app_name));
            builder.setMessage(this.f3095c.getString(C1209e.zxing_msg_camera_framework_bug));
            builder.setPositiveButton(C1209e.zxing_button_ok, new C13343(this));
            builder.setOnCancelListener(new C13354(this));
            builder.show();
        }
    }
}
