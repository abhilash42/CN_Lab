package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a;

import android.content.Context;
import android.os.Handler;
import in.juspay.widget.qrscanner.C1211a.C1206b;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1346l;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.C1348n;

public class C1310b {
    private static final String f3018a = C1310b.class.getSimpleName();
    private C1316f f3019b;
    private C1315e f3020c;
    private C1312c f3021d;
    private Handler f3022e;
    private C1319h f3023f;
    private boolean f3024g = false;
    private C1314d f3025h = new C1314d();
    private Runnable f3026i = new C13063(this);
    private Runnable f3027j = new C13074(this);
    private Runnable f3028k = new C13085(this);
    private Runnable f3029l = new C13096(this);

    class C13063 implements Runnable {
        final /* synthetic */ C1310b f3014a;

        C13063(C1310b c1310b) {
            this.f3014a = c1310b;
        }

        public void run() {
            try {
                this.f3014a.f3021d.m5052a();
            } catch (Exception e) {
                this.f3014a.m5025a(e);
            }
        }
    }

    class C13074 implements Runnable {
        final /* synthetic */ C1310b f3015a;

        C13074(C1310b c1310b) {
            this.f3015a = c1310b;
        }

        public void run() {
            try {
                this.f3015a.f3021d.m5058b();
                if (this.f3015a.f3022e != null) {
                    this.f3015a.f3022e.obtainMessage(C1206b.zxing_prewiew_size_ready, this.f3015a.m5030g()).sendToTarget();
                }
            } catch (Exception e) {
                this.f3015a.m5025a(e);
            }
        }
    }

    class C13085 implements Runnable {
        final /* synthetic */ C1310b f3016a;

        C13085(C1310b c1310b) {
            this.f3016a = c1310b;
        }

        public void run() {
            try {
                this.f3016a.f3021d.m5054a(this.f3016a.f3020c);
                this.f3016a.f3021d.m5059c();
            } catch (Exception e) {
                this.f3016a.m5025a(e);
            }
        }
    }

    class C13096 implements Runnable {
        final /* synthetic */ C1310b f3017a;

        C13096(C1310b c1310b) {
            this.f3017a = c1310b;
        }

        public void run() {
            try {
                this.f3017a.f3021d.m5060d();
                this.f3017a.f3021d.m5061e();
            } catch (Exception e) {
            }
            this.f3017a.f3019b.m5079b();
        }
    }

    public C1310b(Context context) {
        C1348n.m5158a();
        this.f3019b = C1316f.m5075a();
        this.f3021d = new C1312c(context);
        this.f3021d.m5053a(this.f3025h);
    }

    public void m5036a(C1319h c1319h) {
        this.f3023f = c1319h;
        this.f3021d.m5055a(c1319h);
    }

    public C1319h m5032a() {
        return this.f3023f;
    }

    public void m5033a(Handler handler) {
        this.f3022e = handler;
    }

    public void m5035a(C1315e c1315e) {
        this.f3020c = c1315e;
    }

    public void m5034a(C1314d c1314d) {
        if (!this.f3024g) {
            this.f3025h = c1314d;
            this.f3021d.m5053a(c1314d);
        }
    }

    private C1346l m5030g() {
        return this.f3021d.m5064h();
    }

    public void m5039b() {
        C1348n.m5158a();
        this.f3024g = true;
        this.f3019b.m5080b(this.f3026i);
    }

    public void m5040c() {
        C1348n.m5158a();
        m5031h();
        this.f3019b.m5078a(this.f3027j);
    }

    public void m5041d() {
        C1348n.m5158a();
        m5031h();
        this.f3019b.m5078a(this.f3028k);
    }

    public void m5038a(final boolean z) {
        C1348n.m5158a();
        if (this.f3024g) {
            this.f3019b.m5078a(new Runnable(this) {
                final /* synthetic */ C1310b f3011b;

                public void run() {
                    this.f3011b.f3021d.m5057a(z);
                }
            });
        }
    }

    public void m5042e() {
        C1348n.m5158a();
        if (this.f3024g) {
            this.f3019b.m5078a(this.f3029l);
        }
        this.f3024g = false;
    }

    public boolean m5043f() {
        return this.f3024g;
    }

    public void m5037a(final C1322k c1322k) {
        m5031h();
        this.f3019b.m5078a(new Runnable(this) {
            final /* synthetic */ C1310b f3013b;

            public void run() {
                this.f3013b.f3021d.m5056a(c1322k);
            }
        });
    }

    private void m5031h() {
        if (!this.f3024g) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    private void m5025a(Exception exception) {
        if (this.f3022e != null) {
            this.f3022e.obtainMessage(C1206b.zxing_camera_error, exception).sendToTarget();
        }
    }
}
