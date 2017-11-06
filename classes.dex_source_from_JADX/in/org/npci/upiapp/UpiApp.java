package in.org.npci.upiapp;

import android.app.Application;
import android.content.Context;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import in.org.npci.upiapp.utils.RestClient;
import io.fabric.sdk.android.C1457c;

public class UpiApp extends Application {
    public static boolean f3250a = false;

    public void onCreate() {
        boolean z = true;
        super.onCreate();
        C1457c.m5537a((Context) this, new Crashlytics());
        C1457c.m5537a((Context) this, new Answers());
        RestClient.m5435a(getApplicationContext());
        if ((getApplicationInfo().flags & 2) == 0) {
            z = false;
        }
        f3250a = z;
    }
}
