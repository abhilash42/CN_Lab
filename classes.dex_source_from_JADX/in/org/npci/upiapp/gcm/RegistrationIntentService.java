package in.org.npci.upiapp.gcm;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.p004a.C0040i;
import com.google.android.gms.gcm.C1044b;
import com.google.android.gms.iid.C1055a;
import in.org.npci.upiapp.p036a.C1380a;

public class RegistrationIntentService extends IntentService {
    private static final String[] f3552a = new String[]{"allcustomers"};

    public RegistrationIntentService() {
        super("RegistrationIntentService");
    }

    protected void onHandleIntent(Intent intent) {
        try {
            String a = C1055a.m3822b(this).m3823a(getString(2131165267), "GCM", null);
            m5414a(a);
            m5415b(a);
        } catch (Throwable e) {
            C1380a.m5276a("RegistrationIntentService", "Failed to complete token refresh", e);
        }
    }

    private void m5414a(String str) {
        C1380a.m5275a("RegistrationIntentService", "Token for my GCM Listener is : " + str);
        try {
            Intent intent = new Intent("in.org.npci.upiapp.uibroadcastreceiver");
            intent.putExtra("onTokenReceived", str);
            C0040i.m106a((Context) this).m111a(intent);
        } catch (Exception e) {
        }
    }

    private void m5415b(String str) {
        try {
            C1044b a = C1044b.m3775a(this);
            for (String str2 : f3552a) {
                a.m3776a(str, "/topics/" + str2, null);
            }
        } catch (Exception e) {
        }
    }
}
