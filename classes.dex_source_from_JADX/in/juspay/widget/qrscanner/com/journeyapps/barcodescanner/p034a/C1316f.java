package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a;

import android.os.Handler;
import android.os.HandlerThread;

class C1316f {
    private static final String f3063a = C1316f.class.getSimpleName();
    private static C1316f f3064b;
    private Handler f3065c;
    private HandlerThread f3066d;
    private int f3067e = 0;
    private final Object f3068f = new Object();

    public static C1316f m5075a() {
        if (f3064b == null) {
            f3064b = new C1316f();
        }
        return f3064b;
    }

    private C1316f() {
    }

    protected void m5078a(Runnable runnable) {
        synchronized (this.f3068f) {
            m5076c();
            this.f3065c.post(runnable);
        }
    }

    private void m5076c() {
        synchronized (this.f3068f) {
            if (this.f3065c == null) {
                if (this.f3067e <= 0) {
                    throw new IllegalStateException("CameraThread is not open");
                }
                this.f3066d = new HandlerThread("CameraThread");
                this.f3066d.start();
                this.f3065c = new Handler(this.f3066d.getLooper());
            }
        }
    }

    private void m5077d() {
        synchronized (this.f3068f) {
            this.f3066d.quit();
            this.f3066d = null;
            this.f3065c = null;
        }
    }

    protected void m5079b() {
        synchronized (this.f3068f) {
            this.f3067e--;
            if (this.f3067e == 0) {
                m5077d();
            }
        }
    }

    protected void m5080b(Runnable runnable) {
        synchronized (this.f3068f) {
            this.f3067e++;
            m5078a(runnable);
        }
    }
}
