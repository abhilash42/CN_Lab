package org.npci.upi.security.pinactivitycomponent;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import org.npci.upi.security.services.C1640d;

public class CLServerResultReceiver extends ResultReceiver {
    private C1640d f4292a;

    public CLServerResultReceiver(C1640d c1640d) {
        super(new Handler());
        this.f4292a = c1640d;
    }

    protected void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        if (i == 2) {
            try {
                this.f4292a.mo909b(bundle);
                return;
            } catch (RemoteException e) {
                e.printStackTrace();
                return;
            }
        }
        this.f4292a.mo908a(bundle);
    }
}
