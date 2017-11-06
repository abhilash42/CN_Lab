package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;

public final class C1303a {
    private static final String f3000a = C1303a.class.getSimpleName();
    private static final Collection<String> f3001h = new ArrayList(2);
    private boolean f3002b;
    private boolean f3003c;
    private final boolean f3004d;
    private final Camera f3005e;
    private Handler f3006f = new Handler(this.f3008i);
    private int f3007g = 1;
    private final Callback f3008i = new C13001(this);
    private final AutoFocusCallback f3009j = new C13022(this);

    class C13001 implements Callback {
        final /* synthetic */ C1303a f2997a;

        C13001(C1303a c1303a) {
            this.f2997a = c1303a;
        }

        public boolean handleMessage(Message message) {
            if (message.what != this.f2997a.f3007g) {
                return false;
            }
            this.f2997a.m5019d();
            return true;
        }
    }

    class C13022 implements AutoFocusCallback {
        final /* synthetic */ C1303a f2999a;

        class C13011 implements Runnable {
            final /* synthetic */ C13022 f2998a;

            C13011(C13022 c13022) {
                this.f2998a = c13022;
            }

            public void run() {
                this.f2998a.f2999a.f3003c = false;
                this.f2998a.f2999a.m5016c();
            }
        }

        C13022(C1303a c1303a) {
            this.f2999a = c1303a;
        }

        public void onAutoFocus(boolean z, Camera camera) {
            this.f2999a.f3006f.post(new C13011(this));
        }
    }

    static {
        f3001h.add("auto");
        f3001h.add("macro");
    }

    public C1303a(Camera camera, C1314d c1314d) {
        boolean z = true;
        this.f3005e = camera;
        String focusMode = camera.getParameters().getFocusMode();
        if (!(c1314d.m5071f() && f3001h.contains(focusMode))) {
            z = false;
        }
        this.f3004d = z;
        m5021a();
    }

    private synchronized void m5016c() {
        if (!(this.f3002b || this.f3006f.hasMessages(this.f3007g))) {
            this.f3006f.sendMessageDelayed(this.f3006f.obtainMessage(this.f3007g), 2000);
        }
    }

    public void m5021a() {
        this.f3002b = false;
        m5019d();
    }

    private void m5019d() {
        if (this.f3004d && !this.f3002b && !this.f3003c) {
            try {
                this.f3005e.autoFocus(this.f3009j);
                this.f3003c = true;
            } catch (RuntimeException e) {
                m5016c();
            }
        }
    }

    private void m5020e() {
        this.f3006f.removeMessages(this.f3007g);
    }

    public void m5022b() {
        this.f3002b = true;
        this.f3003c = false;
        m5020e();
        if (this.f3004d) {
            try {
                this.f3005e.cancelAutoFocus();
            } catch (RuntimeException e) {
            }
        }
    }
}
