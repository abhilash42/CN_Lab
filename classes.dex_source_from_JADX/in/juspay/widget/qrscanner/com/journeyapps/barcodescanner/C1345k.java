package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

public class C1345k {
    private int f3126a;
    private WindowManager f3127b;
    private OrientationEventListener f3128c;
    private C1329j f3129d;

    public void m5146a(Context context, C1329j c1329j) {
        m5145a();
        Context applicationContext = context.getApplicationContext();
        this.f3129d = c1329j;
        this.f3127b = (WindowManager) applicationContext.getSystemService("window");
        this.f3128c = new OrientationEventListener(this, applicationContext, 3) {
            final /* synthetic */ C1345k f3125a;

            public void onOrientationChanged(int i) {
                WindowManager a = this.f3125a.f3127b;
                C1329j b = this.f3125a.f3129d;
                if (this.f3125a.f3127b != null && b != null) {
                    int rotation = a.getDefaultDisplay().getRotation();
                    if (rotation != this.f3125a.f3126a) {
                        this.f3125a.f3126a = rotation;
                        b.mo781a(rotation);
                    }
                }
            }
        };
        this.f3128c.enable();
        this.f3126a = this.f3127b.getDefaultDisplay().getRotation();
    }

    public void m5145a() {
        if (this.f3128c != null) {
            this.f3128c.disable();
        }
        this.f3128c = null;
        this.f3127b = null;
        this.f3129d = null;
    }
}
