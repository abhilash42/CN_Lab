package in.org.npci.upiapp.gcm;

import android.content.Intent;
import com.google.android.gms.iid.C1058b;

public class GalileoInstanceIDListenerService extends C1058b {
    public void mo802b() {
        startService(new Intent(this, RegistrationIntentService.class));
    }
}
