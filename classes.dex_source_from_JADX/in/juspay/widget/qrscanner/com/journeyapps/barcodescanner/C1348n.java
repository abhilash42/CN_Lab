package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.os.Looper;

public class C1348n {
    public static void m5158a() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }
}
