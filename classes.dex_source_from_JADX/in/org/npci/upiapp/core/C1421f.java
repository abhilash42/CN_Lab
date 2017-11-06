package in.org.npci.upiapp.core;

import android.app.Activity;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import in.org.npci.upiapp.p036a.C1380a;

/* compiled from: Tracker */
public class C1421f {
    private static C1421f f3527a;

    public C1421f(Activity activity) {
        f3527a = this;
    }

    public static C1421f m5388a() {
        return f3527a;
    }

    public void m5389a(String str, String str2) {
        try {
            Answers.getInstance().logCustom((CustomEvent) new CustomEvent(str2.toUpperCase()).putCustomAttribute(str, str2));
        } catch (Throwable e) {
            C1380a.m5276a("Tracker", "Error in logging Crashlytics answer", e);
        }
    }
}
