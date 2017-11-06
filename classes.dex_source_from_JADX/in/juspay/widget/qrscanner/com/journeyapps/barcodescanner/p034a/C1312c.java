package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a.C1215a;
import in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a.p027a.C1214a;
import in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a.p027a.p028a.C1213a;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1346l;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1347m;
import java.util.ArrayList;
import java.util.List;

public final class C1312c {
    private static final String f3033a = C1312c.class.getSimpleName();
    private Camera f3034b;
    private CameraInfo f3035c;
    private C1303a f3036d;
    private C1215a f3037e;
    private boolean f3038f;
    private String f3039g;
    private C1314d f3040h = new C1314d();
    private C1319h f3041i;
    private C1346l f3042j;
    private C1346l f3043k;
    private int f3044l = -1;
    private Context f3045m;
    private final C1311a f3046n;

    private final class C1311a implements PreviewCallback {
        final /* synthetic */ C1312c f3030a;
        private C1322k f3031b;
        private C1346l f3032c;

        public C1311a(C1312c c1312c) {
            this.f3030a = c1312c;
        }

        public void m5045a(C1346l c1346l) {
            this.f3032c = c1346l;
        }

        public void m5044a(C1322k c1322k) {
            this.f3031b = c1322k;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            C1346l c1346l = this.f3032c;
            C1322k c1322k = this.f3031b;
            if (c1346l != null && c1322k != null) {
                int previewFormat = camera.getParameters().getPreviewFormat();
                try {
                    c1322k.mo783a(new C1347m(bArr, c1346l.f3130a, c1346l.f3131b, previewFormat, this.f3030a.m5063g()));
                } catch (Exception e) {
                    c1322k.mo784a(e);
                }
            } else if (c1322k != null) {
                c1322k.mo784a(new Exception("No resolution available"));
            }
        }
    }

    public C1312c(Context context) {
        this.f3045m = context;
        this.f3046n = new C1311a(this);
    }

    public void m5052a() {
        this.f3034b = C1213a.m4641b(this.f3040h.m5066a());
        if (this.f3034b == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int a = C1213a.m4640a(this.f3040h.m5066a());
        this.f3035c = new CameraInfo();
        Camera.getCameraInfo(a, this.f3035c);
    }

    public void m5058b() {
        if (this.f3034b == null) {
            throw new RuntimeException("Camera not open");
        }
        m5051l();
    }

    public void m5054a(C1315e c1315e) {
        c1315e.m5074a(this.f3034b);
    }

    public void m5059c() {
        Camera camera = this.f3034b;
        if (camera != null && !this.f3038f) {
            camera.startPreview();
            this.f3038f = true;
            this.f3036d = new C1303a(this.f3034b, this.f3040h);
            this.f3037e = new C1215a(this.f3045m, this, this.f3040h);
            this.f3037e.m4656a();
        }
    }

    public void m5060d() {
        if (this.f3036d != null) {
            this.f3036d.m5022b();
            this.f3036d = null;
        }
        if (this.f3037e != null) {
            this.f3037e.m4657b();
            this.f3037e = null;
        }
        if (this.f3034b != null && this.f3038f) {
            this.f3034b.stopPreview();
            this.f3046n.m5044a(null);
            this.f3038f = false;
        }
    }

    public void m5061e() {
        if (this.f3034b != null) {
            this.f3034b.release();
            this.f3034b = null;
        }
    }

    public boolean m5062f() {
        if (this.f3044l != -1) {
            return this.f3044l % 180 != 0;
        } else {
            throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
        }
    }

    public int m5063g() {
        return this.f3044l;
    }

    private Parameters m5049j() {
        Parameters parameters = this.f3034b.getParameters();
        if (this.f3039g == null) {
            this.f3039g = parameters.flatten();
        } else {
            parameters.unflatten(this.f3039g);
        }
        return parameters;
    }

    private void m5048b(boolean z) {
        Parameters j = m5049j();
        if (j != null) {
            if (z) {
                C1214a.m4646a(j, this.f3040h.m5072g(), z);
            } else {
                C1214a.m4646a(j, this.f3040h.m5072g(), z);
            }
            if (!z) {
                C1214a.m4647a(j, false);
                if (this.f3040h.m5067b()) {
                    C1214a.m4653f(j);
                }
                if (this.f3040h.m5068c()) {
                    C1214a.m4652e(j);
                }
                if (this.f3040h.m5070e() && VERSION.SDK_INT >= 15) {
                    C1214a.m4651d(j);
                    C1214a.m4648b(j);
                    C1214a.m4650c(j);
                }
            }
            List a = C1312c.m5046a(j);
            if (a.size() == 0) {
                this.f3042j = null;
            } else {
                this.f3042j = this.f3041i.m5089a(a, m5062f());
                j.setPreviewSize(this.f3042j.f3130a, this.f3042j.f3131b);
            }
            if (Build.DEVICE.equals("glass-1")) {
                C1214a.m4644a(j);
            }
            this.f3034b.setParameters(j);
        }
    }

    private static List<C1346l> m5046a(Parameters parameters) {
        List<Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<C1346l> arrayList = new ArrayList();
        Size previewSize;
        if (supportedPreviewSizes == null) {
            previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                arrayList.add(new C1346l(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Size previewSize2 : supportedPreviewSizes) {
            arrayList.add(new C1346l(previewSize2.width, previewSize2.height));
        }
        return arrayList;
    }

    private int m5050k() {
        int i = 0;
        switch (this.f3041i.m5087a()) {
            case 1:
                i = 90;
                break;
            case 2:
                i = 180;
                break;
            case 3:
                i = 270;
                break;
        }
        if (this.f3035c.facing == 1) {
            return (360 - ((i + this.f3035c.orientation) % 360)) % 360;
        }
        return ((this.f3035c.orientation - i) + 360) % 360;
    }

    private void m5047a(int i) {
        this.f3034b.setDisplayOrientation(i);
    }

    private void m5051l() {
        try {
            this.f3044l = m5050k();
            m5047a(this.f3044l);
        } catch (Exception e) {
        }
        try {
            m5048b(false);
        } catch (Exception e2) {
            try {
                m5048b(true);
            } catch (Exception e3) {
            }
        }
        Size previewSize = this.f3034b.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f3043k = this.f3042j;
        } else {
            this.f3043k = new C1346l(previewSize.width, previewSize.height);
        }
        this.f3046n.m5045a(this.f3043k);
    }

    public C1346l m5064h() {
        if (this.f3043k == null) {
            return null;
        }
        if (m5062f()) {
            return this.f3043k.m5147a();
        }
        return this.f3043k;
    }

    public void m5056a(C1322k c1322k) {
        Camera camera = this.f3034b;
        if (camera != null && this.f3038f) {
            this.f3046n.m5044a(c1322k);
            camera.setOneShotPreviewCallback(this.f3046n);
        }
    }

    public void m5053a(C1314d c1314d) {
        this.f3040h = c1314d;
    }

    public void m5055a(C1319h c1319h) {
        this.f3041i = c1319h;
    }

    public void m5057a(boolean z) {
        if (this.f3034b != null && z != m5065i()) {
            if (this.f3036d != null) {
                this.f3036d.m5022b();
            }
            Parameters parameters = this.f3034b.getParameters();
            C1214a.m4647a(parameters, z);
            if (this.f3040h.m5069d()) {
                C1214a.m4649b(parameters, z);
            }
            this.f3034b.setParameters(parameters);
            if (this.f3036d != null) {
                this.f3036d.m5021a();
            }
        }
    }

    public boolean m5065i() {
        Parameters parameters = this.f3034b.getParameters();
        if (parameters == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        if (flashMode == null) {
            return false;
        }
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }
}
