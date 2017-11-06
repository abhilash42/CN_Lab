package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;

public class C1315e {
    private SurfaceHolder f3061a;
    private SurfaceTexture f3062b;

    public C1315e(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalArgumentException("surfaceHolder may not be null");
        }
        this.f3061a = surfaceHolder;
    }

    public C1315e(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("surfaceTexture may not be null");
        }
        this.f3062b = surfaceTexture;
    }

    public void m5074a(Camera camera) {
        if (this.f3061a != null) {
            camera.setPreviewDisplay(this.f3061a);
        } else if (VERSION.SDK_INT >= 11) {
            camera.setPreviewTexture(this.f3062b);
        } else {
            throw new IllegalStateException("SurfaceTexture not supported.");
        }
    }
}
