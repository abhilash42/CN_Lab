package org.npci.upi.security.services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;

public class CLRemoteResultReceiver extends Service {
    private IBinder mBinder = new C16421(this);
    private ResultReceiver mResultReceiver;

    class C16421 extends C1641e {
        final /* synthetic */ CLRemoteResultReceiver f4484a;

        C16421(CLRemoteResultReceiver cLRemoteResultReceiver) {
            this.f4484a = cLRemoteResultReceiver;
        }

        public void mo908a(Bundle bundle) {
            this.f4484a.mResultReceiver.send(1, bundle);
        }

        public void mo909b(Bundle bundle) {
            this.f4484a.mResultReceiver.send(2, bundle);
        }
    }

    public CLRemoteResultReceiver(ResultReceiver resultReceiver) {
        this.mResultReceiver = resultReceiver;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public IBinder getBinder() {
        return this.mBinder;
    }
}
