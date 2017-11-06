package in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1312c;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.p034a.C1314d;

public final class C1215a implements SensorEventListener {
    private C1312c f2661a;
    private C1314d f2662b;
    private Sensor f2663c;
    private Context f2664d;
    private Handler f2665e = new Handler();

    public C1215a(Context context, C1312c c1312c, C1314d c1314d) {
        this.f2664d = context;
        this.f2661a = c1312c;
        this.f2662b = c1314d;
    }

    public void m4656a() {
        if (this.f2662b.m5073h()) {
            SensorManager sensorManager = (SensorManager) this.f2664d.getSystemService("sensor");
            this.f2663c = sensorManager.getDefaultSensor(5);
            if (this.f2663c != null) {
                sensorManager.registerListener(this, this.f2663c, 3);
            }
        }
    }

    public void m4657b() {
        if (this.f2663c != null) {
            ((SensorManager) this.f2664d.getSystemService("sensor")).unregisterListener(this);
            this.f2663c = null;
        }
    }

    private void m4655a(final boolean z) {
        this.f2665e.post(new Runnable(this) {
            final /* synthetic */ C1215a f2658b;

            public void run() {
                this.f2658b.f2661a.m5057a(z);
            }
        });
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.f2661a == null) {
            return;
        }
        if (f <= 45.0f) {
            m4655a(true);
        } else if (f >= 450.0f) {
            m4655a(false);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
