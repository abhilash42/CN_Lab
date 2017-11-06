package org.npci.upi.security.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class CLServices {
    private static final Uri GET_CHALLENGE_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/getChallenge");
    private static final Uri GET_CREDENTIAL_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/getCredential");
    private static final String PROVIDER_NAME = "org.npci.upi.security.pinactivitycomponent.clservices";
    private static final Uri REGISTER_APP_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/registerApp");
    private static CLServices clServices = null;
    private C1636a clRemoteService = null;
    private Context mContext;
    private ServiceConnectionStatusNotifier notifier;
    private ServiceConnection serviceConnection = new C16431(this);

    class C16431 implements ServiceConnection {
        final /* synthetic */ CLServices f4485a;

        C16431(CLServices cLServices) {
            this.f4485a = cLServices;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f4485a.clRemoteService = C1637b.m6625a(iBinder);
            this.f4485a.notifier.serviceConnected(CLServices.clServices);
            Log.d("Remote Service", "Service Connected");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f4485a.clRemoteService = null;
            this.f4485a.notifier.serviceDisconnected();
            Log.d("Remote Service", "Service Disconnected");
        }
    }

    public static void initService(Context context, ServiceConnectionStatusNotifier serviceConnectionStatusNotifier) {
        if (clServices != null) {
            throw new RuntimeException("Service already initiated");
        }
        clServices = new CLServices(context, serviceConnectionStatusNotifier);
    }

    public void unbindService() {
        this.mContext.unbindService(this.serviceConnection);
    }

    private CLServices(Context context, ServiceConnectionStatusNotifier serviceConnectionStatusNotifier) {
        this.mContext = context;
        this.notifier = serviceConnectionStatusNotifier;
        Intent intent = new Intent();
        intent.setAction("org.npci.upi.security.services.CLRemoteService");
        intent.setPackage(this.mContext.getPackageName());
        this.mContext.bindService(intent, this.serviceConnection, 1);
    }

    public String getChallenge(String str, String str2) {
        String str3 = null;
        Log.d(CLServices.class.getName(), "GetChallenge called");
        if (str == null || str.trim().isEmpty() || str2 == null || str2.trim().isEmpty()) {
            Log.d(CLServices.class.getName(), "In-sufficient arguments provided");
        } else {
            try {
                str3 = this.clRemoteService.mo905a(str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return str3;
    }

    public boolean registerApp(String str, String str2, String str3, String str4) {
        boolean z = false;
        Log.d(CLServices.class.getName(), "Register App called");
        if (str == null || str.trim().isEmpty() || str2 == null || str2.trim().isEmpty() || str3 == null || str3.trim().isEmpty() || str4 == null || str4.trim().isEmpty()) {
            Log.d(CLServices.class.getName(), "In-sufficient arguments provided");
        } else {
            try {
                z = this.clRemoteService.mo907a(str, str2, str3, str4);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    public void getCredential(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLRemoteResultReceiver cLRemoteResultReceiver) {
        Log.d(CLServices.class.getName(), "Get Credential called");
        try {
            this.clRemoteService.mo906a(str, str2, str3, str4, str5, str6, str7, str8, C1641e.m6636a(cLRemoteResultReceiver.getBinder()));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
