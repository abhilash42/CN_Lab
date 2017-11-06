package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import in.juspay.widget.qrscanner.C1211a.C1206b;
import in.juspay.widget.qrscanner.com.google.zxing.C1285f;
import in.juspay.widget.qrscanner.com.google.zxing.C1289k;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1310b;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1322k;

public class C1342h {
    private static final String f3111a = C1342h.class.getSimpleName();
    private C1310b f3112b;
    private HandlerThread f3113c;
    private Handler f3114d;
    private C1337e f3115e;
    private Handler f3116f;
    private Rect f3117g;
    private boolean f3118h = false;
    private final Object f3119i = new Object();
    private final Callback f3120j = new C13401(this);
    private final C1322k f3121k = new C13412(this);

    class C13401 implements Callback {
        final /* synthetic */ C1342h f3109a;

        C13401(C1342h c1342h) {
            this.f3109a = c1342h;
        }

        public boolean handleMessage(Message message) {
            if (message.what == C1206b.zxing_decode) {
                this.f3109a.m5131b((C1347m) message.obj);
            } else if (message.what == C1206b.zxing_preview_failed) {
                this.f3109a.m5132c();
            }
            return true;
        }
    }

    class C13412 implements C1322k {
        final /* synthetic */ C1342h f3110a;

        C13412(C1342h c1342h) {
            this.f3110a = c1342h;
        }

        public void mo783a(C1347m c1347m) {
            synchronized (this.f3110a.f3119i) {
                if (this.f3110a.f3118h) {
                    this.f3110a.f3114d.obtainMessage(C1206b.zxing_decode, c1347m).sendToTarget();
                }
            }
        }

        public void mo784a(Exception exception) {
            synchronized (this.f3110a.f3119i) {
                if (this.f3110a.f3118h) {
                    this.f3110a.f3114d.obtainMessage(C1206b.zxing_preview_failed).sendToTarget();
                }
            }
        }
    }

    public C1342h(C1310b c1310b, C1337e c1337e, Handler handler) {
        C1348n.m5158a();
        this.f3112b = c1310b;
        this.f3115e = c1337e;
        this.f3116f = handler;
    }

    public void m5138a(C1337e c1337e) {
        this.f3115e = c1337e;
    }

    public void m5137a(Rect rect) {
        this.f3117g = rect;
    }

    public void m5136a() {
        C1348n.m5158a();
        this.f3113c = new HandlerThread(f3111a);
        this.f3113c.start();
        this.f3114d = new Handler(this.f3113c.getLooper(), this.f3120j);
        this.f3118h = true;
        m5132c();
    }

    public void m5139b() {
        C1348n.m5158a();
        synchronized (this.f3119i) {
            this.f3118h = false;
            this.f3114d.removeCallbacksAndMessages(null);
            this.f3113c.quit();
        }
    }

    private void m5132c() {
        if (this.f3112b.m5043f()) {
            this.f3112b.m5037a(this.f3121k);
        }
    }

    protected C1285f m5135a(C1347m c1347m) {
        if (this.f3117g == null) {
            return null;
        }
        return c1347m.m5157b();
    }

    private void m5131b(C1347m c1347m) {
        System.currentTimeMillis();
        C1289k c1289k = null;
        c1347m.m5155a(this.f3117g);
        C1285f a = m5135a(c1347m);
        if (a != null) {
            c1289k = this.f3115e.m5119a(a);
        }
        if (c1289k != null) {
            System.currentTimeMillis();
            if (this.f3116f != null) {
                Message obtain = Message.obtain(this.f3116f, C1206b.zxing_decode_succeeded, new C1324b(c1289k, c1347m));
                obtain.setData(new Bundle());
                obtain.sendToTarget();
            }
        } else if (this.f3116f != null) {
            Message.obtain(this.f3116f, C1206b.zxing_decode_failed).sendToTarget();
        }
        if (this.f3116f != null) {
            Message.obtain(this.f3116f, C1206b.zxing_possible_result_points, this.f3115e.m5120a()).sendToTarget();
        }
        m5132c();
    }
}
