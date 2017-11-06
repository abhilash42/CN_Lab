package in.org.npci.upiapp.p036a;

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import in.org.npci.upiapp.UpiApp;

/* compiled from: Logger */
public class C1380a {
    public static void m5275a(String str, String str2) {
        C1380a.m5277a(str, str2, false);
    }

    public static void m5277a(String str, String str2, boolean z) {
        if (UpiApp.f3250a) {
            Crashlytics.log(3, str, str2);
        } else if (z) {
            Crashlytics.log(str2);
        }
    }

    public static void m5279b(String str, String str2) {
        C1380a.m5280b(str, str2, true);
    }

    public static void m5280b(String str, String str2, boolean z) {
        if (UpiApp.f3250a) {
            Crashlytics.log(6, str, str2);
        } else if (z) {
            Crashlytics.log(str2);
        }
    }

    public static void m5276a(String str, String str2, Throwable th) {
        if (UpiApp.f3250a) {
            Crashlytics.log(6, str, str2);
        }
        C1380a.m5278a(th);
    }

    public static void m5278a(Throwable th) {
        if (UpiApp.f3250a) {
            Log.e("Exception", "Exception", th);
        } else {
            Crashlytics.logException(th);
        }
    }
}
