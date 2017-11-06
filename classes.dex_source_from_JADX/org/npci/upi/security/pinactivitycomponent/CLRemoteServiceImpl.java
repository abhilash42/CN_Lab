package org.npci.upi.security.pinactivitycomponent;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import org.npci.upi.security.services.C1637b;
import org.npci.upi.security.services.C1640d;

public class CLRemoteServiceImpl extends Service {
    private C1637b f4290a = null;
    private C1639z f4291b = null;

    private Bundle m6437a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, C1640d c1640d) {
        Bundle bundle = new Bundle();
        bundle.putString(CLConstants.INPUT_KEY_KEY_CODE, str);
        bundle.putString(CLConstants.INPUT_KEY_XML_PAYLOAD, str2);
        bundle.putString(CLConstants.INPUT_KEY_CONTROLS, str3);
        bundle.putString(CLConstants.INPUT_KEY_CONFIGURATION, str4);
        bundle.putString(CLConstants.INPUT_KEY_SALT, str5);
        bundle.putString(CLConstants.INPUT_KEY_PAY_INFO, str6);
        bundle.putString(CLConstants.INPUT_KEY_TRUST, str7);
        bundle.putString(CLConstants.INPUT_KEY_LANGUAGE_PREFERENCE, str8);
        an.m6494a(new CLServerResultReceiver(c1640d));
        return bundle;
    }

    public IBinder onBind(Intent intent) {
        if (this.f4290a == null) {
            this.f4290a = new C1638y(this, getBaseContext(), null);
        }
        try {
            this.f4291b = new C1639z(getBaseContext());
            return this.f4290a;
        } catch (Exception e) {
            throw new RuntimeException("Could not initialize service provider");
        }
    }
}
