package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.stats.C1036b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class C1022j extends C1018i implements Callback {
    private final HashMap<C1019a, C1021b> f2015a = new HashMap();
    private final Context f2016b;
    private final Handler f2017c;
    private final C1036b f2018d;
    private final long f2019e;

    private static final class C1019a {
        private final String f2004a;
        private final ComponentName f2005b = null;

        public C1019a(String str) {
            this.f2004a = C1032p.m3680a(str);
        }

        public Intent m3553a() {
            return this.f2004a != null ? new Intent(this.f2004a).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) : new Intent().setComponent(this.f2005b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1019a)) {
                return false;
            }
            C1019a c1019a = (C1019a) obj;
            return C1031o.m3677a(this.f2004a, c1019a.f2004a) && C1031o.m3677a(this.f2005b, c1019a.f2005b);
        }

        public int hashCode() {
            return C1031o.m3675a(this.f2004a, this.f2005b);
        }

        public String toString() {
            return this.f2004a == null ? this.f2005b.flattenToString() : this.f2004a;
        }
    }

    private final class C1021b {
        final /* synthetic */ C1022j f2007a;
        private final C1020a f2008b = new C1020a(this);
        private final Set<ServiceConnection> f2009c = new HashSet();
        private int f2010d = 2;
        private boolean f2011e;
        private IBinder f2012f;
        private final C1019a f2013g;
        private ComponentName f2014h;

        public class C1020a implements ServiceConnection {
            final /* synthetic */ C1021b f2006a;

            public C1020a(C1021b c1021b) {
                this.f2006a = c1021b;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.f2006a.f2007a.f2015a) {
                    this.f2006a.f2012f = iBinder;
                    this.f2006a.f2014h = componentName;
                    for (ServiceConnection onServiceConnected : this.f2006a.f2009c) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.f2006a.f2010d = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.f2006a.f2007a.f2015a) {
                    this.f2006a.f2012f = null;
                    this.f2006a.f2014h = componentName;
                    for (ServiceConnection onServiceDisconnected : this.f2006a.f2009c) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.f2006a.f2010d = 2;
                }
            }
        }

        public C1021b(C1022j c1022j, C1019a c1019a) {
            this.f2007a = c1022j;
            this.f2013g = c1019a;
        }

        public void m3559a(ServiceConnection serviceConnection, String str) {
            this.f2007a.f2018d.m3752a(this.f2007a.f2016b, serviceConnection, str, this.f2013g.m3553a());
            this.f2009c.add(serviceConnection);
        }

        public void m3560a(String str) {
            this.f2010d = 3;
            this.f2011e = this.f2007a.f2018d.m3754a(this.f2007a.f2016b, str, this.f2013g.m3553a(), this.f2008b, 129);
            if (!this.f2011e) {
                this.f2010d = 2;
                try {
                    this.f2007a.f2018d.m3751a(this.f2007a.f2016b, this.f2008b);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public boolean m3561a() {
            return this.f2011e;
        }

        public boolean m3562a(ServiceConnection serviceConnection) {
            return this.f2009c.contains(serviceConnection);
        }

        public int m3563b() {
            return this.f2010d;
        }

        public void m3564b(ServiceConnection serviceConnection, String str) {
            this.f2007a.f2018d.m3755b(this.f2007a.f2016b, serviceConnection);
            this.f2009c.remove(serviceConnection);
        }

        public void m3565b(String str) {
            this.f2007a.f2018d.m3751a(this.f2007a.f2016b, this.f2008b);
            this.f2011e = false;
            this.f2010d = 2;
        }

        public boolean m3566c() {
            return this.f2009c.isEmpty();
        }

        public IBinder m3567d() {
            return this.f2012f;
        }

        public ComponentName m3568e() {
            return this.f2014h;
        }
    }

    C1022j(Context context) {
        this.f2016b = context.getApplicationContext();
        this.f2017c = new Handler(context.getMainLooper(), this);
        this.f2018d = C1036b.m3742a();
        this.f2019e = 5000;
    }

    private boolean m3570a(C1019a c1019a, ServiceConnection serviceConnection, String str) {
        boolean a;
        C1032p.m3679a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f2015a) {
            C1021b c1021b = (C1021b) this.f2015a.get(c1019a);
            if (c1021b != null) {
                this.f2017c.removeMessages(0, c1021b);
                if (!c1021b.m3562a(serviceConnection)) {
                    c1021b.m3559a(serviceConnection, str);
                    switch (c1021b.m3563b()) {
                        case 1:
                            serviceConnection.onServiceConnected(c1021b.m3568e(), c1021b.m3567d());
                            break;
                        case 2:
                            c1021b.m3560a(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + c1019a);
            }
            c1021b = new C1021b(this, c1019a);
            c1021b.m3559a(serviceConnection, str);
            c1021b.m3560a(str);
            this.f2015a.put(c1019a, c1021b);
            a = c1021b.m3561a();
        }
        return a;
    }

    private void m3572b(C1019a c1019a, ServiceConnection serviceConnection, String str) {
        C1032p.m3679a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f2015a) {
            C1021b c1021b = (C1021b) this.f2015a.get(c1019a);
            if (c1021b == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + c1019a);
            } else if (c1021b.m3562a(serviceConnection)) {
                c1021b.m3564b(serviceConnection, str);
                if (c1021b.m3566c()) {
                    this.f2017c.sendMessageDelayed(this.f2017c.obtainMessage(0, c1021b), this.f2019e);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + c1019a);
            }
        }
    }

    public boolean mo671a(String str, ServiceConnection serviceConnection, String str2) {
        return m3570a(new C1019a(str), serviceConnection, str2);
    }

    public void mo672b(String str, ServiceConnection serviceConnection, String str2) {
        m3572b(new C1019a(str), serviceConnection, str2);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                C1021b c1021b = (C1021b) message.obj;
                synchronized (this.f2015a) {
                    if (c1021b.m3566c()) {
                        if (c1021b.m3561a()) {
                            c1021b.m3565b("GmsClientSupervisor");
                        }
                        this.f2015a.remove(c1021b.f2013g);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
