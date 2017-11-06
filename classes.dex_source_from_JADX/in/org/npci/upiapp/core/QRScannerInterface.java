package in.org.npci.upiapp.core;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.p004a.C0023a;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import in.juspay.mystique.C1178d;
import in.juspay.widget.qrscanner.com.google.zxing.C1246m;
import in.juspay.widget.qrscanner.com.google.zxing.C1265c;
import in.juspay.widget.qrscanner.com.google.zxing.C1286g;
import in.juspay.widget.qrscanner.com.google.zxing.C1288i;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1276j;
import in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a.C1218b;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1296a;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1324b;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1336d;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.DecoratedBarcodeView;
import in.org.npci.upiapp.p036a.C1380a;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class QRScannerInterface {
    private static final String f3496a = QRScannerInterface.class.getSimpleName();
    private Activity f3497b;
    private C1178d f3498c;
    private C1336d f3499d;
    private C1218b f3500e;
    private String f3501f;

    class C14101 implements Runnable {
        final /* synthetic */ QRScannerInterface f3490a;

        C14101(QRScannerInterface qRScannerInterface) {
            this.f3490a = qRScannerInterface;
        }

        public void run() {
            this.f3490a.f3499d.m5115c();
            this.f3490a.f3499d.m5116d();
            this.f3490a.f3499d = null;
        }
    }

    public QRScannerInterface(Activity activity, C1178d c1178d) {
        this.f3497b = activity;
        this.f3498c = c1178d;
    }

    @JavascriptInterface
    public void openQRScanner(String str) {
        C1380a.m5275a(f3496a, "JSInterface openQRScanner Called");
        this.f3501f = str;
        if (m5334b()) {
            m5338a();
        } else {
            C1380a.m5275a(f3496a, "Requesting for Camera Access Permission.");
        }
    }

    @JavascriptInterface
    public void closeQRScanner() {
        C1380a.m5275a(f3496a, "JSInterface closeQRScanner Called");
        if (this.f3499d != null) {
            C1380a.m5275a(f3496a, "JSInterface closeQRScanner 2 Called");
            this.f3497b.runOnUiThread(new C14101(this));
            return;
        }
        C1380a.m5275a(f3496a, "JSInterface closeQRScanner 3 Called");
        C1380a.m5279b(f3496a, "ERROR: CaptureManager NULL!!");
    }

    @JavascriptInterface
    public void captureManager(final String str) {
        this.f3497b.runOnUiThread(new Runnable(this) {
            final /* synthetic */ QRScannerInterface f3492b;

            public void run() {
                if (this.f3492b.f3499d != null && !TextUtils.isEmpty(str)) {
                    String str = str;
                    Object obj = -1;
                    switch (str.hashCode()) {
                        case -1401315045:
                            if (str.equals("onDestroy")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case -1340212393:
                            if (str.equals("onPause")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 1463983852:
                            if (str.equals("onResume")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            this.f3492b.f3499d.m5114b();
                            return;
                        case 1:
                            this.f3492b.f3499d.m5115c();
                            return;
                        case 2:
                            this.f3492b.f3499d.m5116d();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    public void m5339a(int i, String[] strArr, int[] iArr) {
        if (this.f3498c == null) {
            C1380a.m5279b(f3496a, "ERROR: Empty Dynamic UI!!");
            return;
        }
        switch (i) {
            case 101:
                if (m5334b()) {
                    C1380a.m5275a(f3496a, "Camera Access Permission Granted.");
                    m5338a();
                    return;
                }
                C1380a.m5279b(f3496a, "ERROR: Camera Access Permission Not Granted!!");
                return;
            default:
                return;
        }
    }

    public String m5337a(Bitmap bitmap) {
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        try {
            String a = new C1286g().mo762a(new C1265c(new C1276j(new C1288i(bitmap.getWidth(), bitmap.getHeight(), iArr)))).m4948a();
            this.f3498c.m4567a("window.BarcodeResult(\"" + new String(Base64.encode(a.toString().getBytes("UTF-8"), 0), "UTF-8") + "\");");
            return a;
        } catch (Exception e) {
            this.f3498c.m4567a("window.BarcodeResult(\"" + new String(Base64.encode("upi://pay?pa=invalid&pn=invalid image&tn=&am=00&cu=INR".toString().getBytes("UTF-8"), 0), "UTF-8") + "\");");
            return null;
        }
    }

    public void m5338a() {
        if (this.f3499d != null) {
            this.f3499d.m5116d();
        }
        if (TextUtils.isEmpty(this.f3501f)) {
            C1380a.m5279b(f3496a, "ERROR: Frame ID null!!");
            return;
        }
        final int parseInt = Integer.parseInt(this.f3501f);
        this.f3497b.runOnUiThread(new Runnable(this) {
            final /* synthetic */ QRScannerInterface f3495b;

            class C14121 implements C1296a {
                final /* synthetic */ C14133 f3493a;

                C14121(C14133 c14133) {
                    this.f3493a = c14133;
                }

                public void mo773a(C1324b c1324b) {
                    if (this.f3493a.f3495b.f3500e == null) {
                        this.f3493a.f3495b.f3500e = new C1218b(this.f3493a.f3495b.f3497b);
                    }
                    this.f3493a.f3495b.f3500e.m4659a(true);
                    this.f3493a.f3495b.f3500e.m4658a();
                    if (this.f3493a.f3495b.f3498c != null) {
                        try {
                            this.f3493a.f3495b.f3498c.m4567a("window.BarcodeResult(\"" + new String(Base64.encode(c1324b.toString().getBytes("UTF-8"), 0), "UTF-8") + "\");");
                        } catch (UnsupportedEncodingException e) {
                        }
                    }
                }

                public void mo774a(List<C1246m> list) {
                }
            }

            public void run() {
                View decoratedBarcodeView = new DecoratedBarcodeView(this.f3495b.f3497b);
                decoratedBarcodeView.setLayoutParams(new LayoutParams(-1, -1));
                FrameLayout frameLayout = (FrameLayout) this.f3495b.f3497b.findViewById(parseInt);
                if (frameLayout != null) {
                    frameLayout.addView(decoratedBarcodeView);
                    this.f3495b.f3499d = new C1336d(this.f3495b.f3497b, decoratedBarcodeView);
                    this.f3495b.f3499d.m5113a(new C14121(this));
                    this.f3495b.f3499d.m5114b();
                    this.f3495b.f3499d.m5112a();
                }
            }
        });
    }

    private boolean m5334b() {
        return C0023a.m76a(this.f3497b, "android.permission.CAMERA") == 0;
    }
}
