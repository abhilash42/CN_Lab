package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C1000c;
import com.google.android.gms.common.stats.C1038c.C1037a;
import com.google.android.gms.internal.C1074d;
import com.google.android.gms.internal.C1079i;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class C1036b {
    private static final Object f2039a = new Object();
    private static C1036b f2040b;
    private static Integer f2041h;
    private final List<String> f2042c;
    private final List<String> f2043d;
    private final List<String> f2044e;
    private final List<String> f2045f;
    private C1040e f2046g;
    private C1040e f2047i;

    private C1036b() {
        if (C1036b.m3750c() == C1039d.f2057b) {
            this.f2042c = Collections.EMPTY_LIST;
            this.f2043d = Collections.EMPTY_LIST;
            this.f2044e = Collections.EMPTY_LIST;
            this.f2045f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) C1037a.f2049b.m3890c();
        this.f2042c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1037a.f2050c.m3890c();
        this.f2043d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1037a.f2051d.m3890c();
        this.f2044e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1037a.f2052e.m3890c();
        this.f2045f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.f2046g = new C1040e(1024, ((Long) C1037a.f2053f.m3890c()).longValue());
        this.f2047i = new C1040e(1024, ((Long) C1037a.f2053f.m3890c()).longValue());
    }

    public static C1036b m3742a() {
        synchronized (f2039a) {
            if (f2040b == null) {
                f2040b = new C1036b();
            }
        }
        return f2040b;
    }

    private String m3743a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private void m3744a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((C1036b.m3750c() & C1039d.f2061f) == 0 || i == 13)) {
            str6 = C1079i.m3924a(3, 5);
        }
        long j = 0;
        if ((C1036b.m3750c() & C1039d.f2063h) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(C1039d.f2056a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void m3745a(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        if (m3749b() && this.f2046g != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                ServiceInfo b = C1036b.m3748b(context, intent);
                if (b == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = b.processName;
                str5 = b.name;
                str3 = C1079i.m3925a(context);
                if (m3747a(str3, str2, str4, str5)) {
                    this.f2046g.m3757a(str);
                } else {
                    return;
                }
            } else if (this.f2046g.m3758b(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            m3744a(context, str, i, str3, str2, str4, str5);
        }
    }

    private boolean m3746a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return (component == null || (C1000c.f1951a && GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(component.getPackageName()))) ? false : C1074d.m3907a(context, component.getPackageName());
    }

    private boolean m3747a(String str, String str2, String str3, String str4) {
        return (this.f2042c.contains(str) || this.f2043d.contains(str2) || this.f2044e.contains(str3) || this.f2045f.contains(str4) || (str3.equals(str) && (C1036b.m3750c() & C1039d.f2062g) != 0)) ? false : true;
    }

    private static ServiceInfo m3748b(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), C1079i.m3924a(3, 20)}));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), C1079i.m3924a(3, 20)}));
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", ((ResolveInfo) it.next()).serviceInfo.name);
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    private boolean m3749b() {
        return C1000c.f1951a && C1036b.m3750c() != C1039d.f2057b;
    }

    private static int m3750c() {
        if (f2041h == null) {
            try {
                f2041h = Integer.valueOf(C1074d.m3906a() ? ((Integer) C1037a.f2048a.m3890c()).intValue() : C1039d.f2057b);
            } catch (SecurityException e) {
                f2041h = Integer.valueOf(C1039d.f2057b);
            }
        }
        return f2041h.intValue();
    }

    public void m3751a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        m3745a(context, m3743a(serviceConnection), null, null, 1);
    }

    public void m3752a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m3745a(context, m3743a(serviceConnection), str, intent, 3);
    }

    public boolean m3753a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m3754a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public boolean m3754a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (m3746a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            m3745a(context, m3743a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void m3755b(Context context, ServiceConnection serviceConnection) {
        m3745a(context, m3743a(serviceConnection), null, null, 4);
    }
}
