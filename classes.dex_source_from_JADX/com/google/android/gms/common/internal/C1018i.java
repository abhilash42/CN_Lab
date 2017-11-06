package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class C1018i {
    private static final Object f2002a = new Object();
    private static C1018i f2003b;

    public static C1018i m3550a(Context context) {
        synchronized (f2002a) {
            if (f2003b == null) {
                f2003b = new C1022j(context.getApplicationContext());
            }
        }
        return f2003b;
    }

    public abstract boolean mo671a(String str, ServiceConnection serviceConnection, String str2);

    public abstract void mo672b(String str, ServiceConnection serviceConnection, String str2);
}
