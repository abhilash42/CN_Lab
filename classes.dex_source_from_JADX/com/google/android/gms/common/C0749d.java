package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class C0749d implements ServiceConnection {
    boolean f1795a = false;
    private final BlockingQueue<IBinder> f1796b = new LinkedBlockingQueue();

    public IBinder m3213a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.f1795a) {
            throw new IllegalStateException();
        } else {
            this.f1795a = true;
            return (IBinder) this.f1796b.take();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f1796b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
