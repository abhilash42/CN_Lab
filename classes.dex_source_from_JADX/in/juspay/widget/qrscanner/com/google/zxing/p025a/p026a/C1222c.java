package in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

public final class C1222c {
    private static final String f2675a = C1222c.class.getSimpleName();
    private final Context f2676b;
    private final BroadcastReceiver f2677c;
    private boolean f2678d = false;
    private Handler f2679e;
    private Runnable f2680f;
    private boolean f2681g;

    private final class C1221a extends BroadcastReceiver {
        final /* synthetic */ C1222c f2674a;

        private C1221a(C1222c c1222c) {
            this.f2674a = c1222c;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z = intent.getIntExtra("plugged", -1) <= 0;
                this.f2674a.f2679e.post(new Runnable(this) {
                    final /* synthetic */ C1221a f2673b;

                    public void run() {
                        this.f2673b.f2674a.m4662a(z);
                    }
                });
            }
        }
    }

    public C1222c(Context context, Runnable runnable) {
        this.f2676b = context;
        this.f2680f = runnable;
        this.f2677c = new C1221a();
        this.f2679e = new Handler();
    }

    public void m4666a() {
        m4665f();
        if (this.f2681g) {
            this.f2679e.postDelayed(this.f2680f, 300000);
        }
    }

    public void m4667b() {
        m4664e();
        m4666a();
    }

    public void m4668c() {
        m4665f();
        m4663d();
    }

    private void m4663d() {
        if (this.f2678d) {
            this.f2676b.unregisterReceiver(this.f2677c);
            this.f2678d = false;
        }
    }

    private void m4664e() {
        if (!this.f2678d) {
            this.f2676b.registerReceiver(this.f2677c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f2678d = true;
        }
    }

    private void m4665f() {
        this.f2679e.removeCallbacksAndMessages(null);
    }

    private void m4662a(boolean z) {
        this.f2681g = z;
        if (this.f2678d) {
            m4666a();
        }
    }
}
