package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0747b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0744c.C0740b;
import com.google.android.gms.common.api.C0744c.C0741c;
import com.google.android.gms.common.api.C0744c.C0743e;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1009m.C1010a;
import com.google.android.gms.common.internal.C1026n.C1028a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class C1017h<T extends IInterface> {
    public static final String[] f1982c = new String[]{"service_esmobile", "service_googleme"};
    final Handler f1983a;
    protected AtomicInteger f1984b;
    private final Context f1985d;
    private final C1002d f1986e;
    private final Looper f1987f;
    private final C1018i f1988g;
    private final C0747b f1989h;
    private final Object f1990i;
    private C1026n f1991j;
    private C0743e f1992k;
    private T f1993l;
    private final ArrayList<C1006c<?>> f1994m;
    private C1012e f1995n;
    private int f1996o;
    private final Set<Scope> f1997p;
    private final Account f1998q;
    private final C0740b f1999r;
    private final C0741c f2000s;
    private final int f2001t;

    protected abstract class C1006c<TListener> {
        private TListener f1966a;
        private boolean f1967b = false;
        final /* synthetic */ C1017h f1968d;

        public C1006c(C1017h c1017h, TListener tListener) {
            this.f1968d = c1017h;
            this.f1966a = tListener;
        }

        protected abstract void mo663a(TListener tListener);

        protected abstract void mo664b();

        public void m3488c() {
            synchronized (this) {
                Object obj = this.f1966a;
                if (this.f1967b) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    mo663a(obj);
                } catch (RuntimeException e) {
                    mo664b();
                    throw e;
                }
            }
            mo664b();
            synchronized (this) {
                this.f1967b = true;
            }
            m3489d();
        }

        public void m3489d() {
            m3490e();
            synchronized (this.f1968d.f1994m) {
                this.f1968d.f1994m.remove(this);
            }
        }

        public void m3490e() {
            synchronized (this) {
                this.f1966a = null;
            }
        }
    }

    private abstract class C1007a extends C1006c<Boolean> {
        public final int f1969a;
        public final Bundle f1970b;
        final /* synthetic */ C1017h f1971c;

        protected C1007a(C1017h c1017h, int i, Bundle bundle) {
            this.f1971c = c1017h;
            super(c1017h, Boolean.valueOf(true));
            this.f1969a = i;
            this.f1970b = bundle;
        }

        protected abstract void mo669a(ConnectionResult connectionResult);

        protected void m3492a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.f1971c.m3519b(1, null);
                return;
            }
            switch (this.f1969a) {
                case 0:
                    if (!mo670a()) {
                        this.f1971c.m3519b(1, null);
                        mo669a(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.f1971c.m3519b(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.f1971c.m3519b(1, null);
                    if (this.f1970b != null) {
                        pendingIntent = (PendingIntent) this.f1970b.getParcelable("pendingIntent");
                    }
                    mo669a(new ConnectionResult(this.f1969a, pendingIntent));
                    return;
            }
        }

        protected /* synthetic */ void mo663a(Object obj) {
            m3492a((Boolean) obj);
        }

        protected abstract boolean mo670a();

        protected void mo664b() {
        }
    }

    final class C1008b extends Handler {
        final /* synthetic */ C1017h f1972a;

        public C1008b(C1017h c1017h, Looper looper) {
            this.f1972a = c1017h;
            super(looper);
        }

        private void m3496a(Message message) {
            C1006c c1006c = (C1006c) message.obj;
            c1006c.mo664b();
            c1006c.m3489d();
        }

        private boolean m3497b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public void handleMessage(Message message) {
            if (this.f1972a.f1984b.get() != message.arg1) {
                if (m3497b(message)) {
                    m3496a(message);
                }
            } else if ((message.what == 1 || message.what == 5 || message.what == 6) && !this.f1972a.m3542g()) {
                m3496a(message);
            } else if (message.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, null);
                this.f1972a.f1992k.mo667a(connectionResult);
                this.f1972a.m3532a(connectionResult);
            } else if (message.what == 4) {
                this.f1972a.m3519b(4, null);
                if (this.f1972a.f1999r != null) {
                    this.f1972a.f1999r.mo747a(message.arg2);
                }
                this.f1972a.m3528a(message.arg2);
                this.f1972a.m3515a(4, 1, null);
            } else if (message.what == 2 && !this.f1972a.m3541f()) {
                m3496a(message);
            } else if (m3497b(message)) {
                ((C1006c) message.obj).m3488c();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    public static final class C1011d extends C1010a {
        private C1017h f1973a;
        private final int f1974b;

        public C1011d(C1017h c1017h, int i) {
            this.f1973a = c1017h;
            this.f1974b = i;
        }

        private void m3501a() {
            this.f1973a = null;
        }

        public void mo665a(int i, Bundle bundle) {
            C1032p.m3679a(this.f1973a, (Object) "onAccountValidationComplete can be called only once per call to validateAccount");
            this.f1973a.m3529a(i, bundle, this.f1974b);
            m3501a();
        }

        public void mo666a(int i, IBinder iBinder, Bundle bundle) {
            C1032p.m3679a(this.f1973a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f1973a.m3530a(i, iBinder, bundle, this.f1974b);
            m3501a();
        }
    }

    public final class C1012e implements ServiceConnection {
        final /* synthetic */ C1017h f1975a;
        private final int f1976b;

        public C1012e(C1017h c1017h, int i) {
            this.f1975a = c1017h;
            this.f1976b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1032p.m3679a((Object) iBinder, (Object) "Expecting a valid IBinder");
            this.f1975a.f1991j = C1028a.m3673a(iBinder);
            this.f1975a.m3538c(this.f1976b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f1975a.f1983a.sendMessage(this.f1975a.f1983a.obtainMessage(4, this.f1976b, 1));
        }
    }

    protected class C1013f implements C0743e {
        final /* synthetic */ C1017h f1977a;

        public C1013f(C1017h c1017h) {
            this.f1977a = c1017h;
        }

        public void mo667a(ConnectionResult connectionResult) {
            if (connectionResult.m3177a()) {
                this.f1977a.m3534a(null, this.f1977a.f1997p);
            } else if (this.f1977a.f2000s != null) {
                this.f1977a.f2000s.mo749a(connectionResult);
            }
        }

        public void mo668b(ConnectionResult connectionResult) {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }
    }

    protected final class C1014g extends C1007a {
        public final IBinder f1978e;
        final /* synthetic */ C1017h f1979f;

        public C1014g(C1017h c1017h, int i, IBinder iBinder, Bundle bundle) {
            this.f1979f = c1017h;
            super(c1017h, i, bundle);
            this.f1978e = iBinder;
        }

        protected void mo669a(ConnectionResult connectionResult) {
            if (this.f1979f.f2000s != null) {
                this.f1979f.f2000s.mo749a(connectionResult);
            }
            this.f1979f.m3532a(connectionResult);
        }

        protected boolean mo670a() {
            try {
                String interfaceDescriptor = this.f1978e.getInterfaceDescriptor();
                if (this.f1979f.mo757b().equals(interfaceDescriptor)) {
                    IInterface a = this.f1979f.mo755a(this.f1978e);
                    if (a == null || !this.f1979f.m3515a(2, 3, a)) {
                        return false;
                    }
                    Bundle k = this.f1979f.m3546k();
                    if (this.f1979f.f1999r != null) {
                        this.f1979f.f1999r.mo748a(k);
                    }
                    return true;
                }
                Log.e("GmsClient", "service descriptor mismatch: " + this.f1979f.mo757b() + " vs. " + interfaceDescriptor);
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class C1015h extends C1007a {
        final /* synthetic */ C1017h f1980e;

        public C1015h(C1017h c1017h) {
            this.f1980e = c1017h;
            super(c1017h, 0, null);
        }

        protected void mo669a(ConnectionResult connectionResult) {
            this.f1980e.f1992k.mo667a(connectionResult);
            this.f1980e.m3532a(connectionResult);
        }

        protected boolean mo670a() {
            this.f1980e.f1992k.mo667a(ConnectionResult.f1748a);
            return true;
        }
    }

    protected final class C1016i extends C1007a {
        final /* synthetic */ C1017h f1981e;

        public C1016i(C1017h c1017h, int i, Bundle bundle) {
            this.f1981e = c1017h;
            super(c1017h, i, bundle);
        }

        protected void mo669a(ConnectionResult connectionResult) {
            this.f1981e.f1992k.mo668b(connectionResult);
            this.f1981e.m3532a(connectionResult);
        }

        protected boolean mo670a() {
            this.f1981e.f1992k.mo668b(ConnectionResult.f1748a);
            return true;
        }
    }

    protected C1017h(Context context, Looper looper, int i, C1002d c1002d, C0740b c0740b, C0741c c0741c) {
        this(context, looper, C1018i.m3550a(context), C0747b.m3202a(), i, c1002d, (C0740b) C1032p.m3678a((Object) c0740b), (C0741c) C1032p.m3678a((Object) c0741c));
    }

    protected C1017h(Context context, Looper looper, C1018i c1018i, C0747b c0747b, int i, C1002d c1002d, C0740b c0740b, C0741c c0741c) {
        this.f1990i = new Object();
        this.f1994m = new ArrayList();
        this.f1996o = 1;
        this.f1984b = new AtomicInteger(0);
        this.f1985d = (Context) C1032p.m3679a((Object) context, (Object) "Context must not be null");
        this.f1987f = (Looper) C1032p.m3679a((Object) looper, (Object) "Looper must not be null");
        this.f1988g = (C1018i) C1032p.m3679a((Object) c1018i, (Object) "Supervisor must not be null");
        this.f1989h = (C0747b) C1032p.m3679a((Object) c0747b, (Object) "API availability must not be null");
        this.f1983a = new C1008b(this, looper);
        this.f2001t = i;
        this.f1986e = (C1002d) C1032p.m3678a((Object) c1002d);
        this.f1998q = c1002d.m3475a();
        this.f1997p = m3518b(c1002d.m3476b());
        this.f1999r = c0740b;
        this.f2000s = c0741c;
    }

    private boolean m3515a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f1990i) {
            if (this.f1996o != i) {
                z = false;
            } else {
                m3519b(i2, t);
                z = true;
            }
        }
        return z;
    }

    private Set<Scope> m3518b(Set<Scope> set) {
        Set<Scope> a = m3527a((Set) set);
        if (a == null) {
            return a;
        }
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    private void m3519b(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        C1032p.m3685b(z);
        synchronized (this.f1990i) {
            this.f1996o = i;
            this.f1993l = t;
            m3531a(i, (IInterface) t);
            switch (i) {
                case 1:
                    m3524p();
                    break;
                case 2:
                    m3523o();
                    break;
                case 3:
                    m3539d();
                    break;
            }
        }
    }

    private void m3523o() {
        if (this.f1995n != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + mo756a());
            this.f1988g.mo672b(mo756a(), this.f1995n, m3537c());
            this.f1984b.incrementAndGet();
        }
        this.f1995n = new C1012e(this, this.f1984b.get());
        if (!this.f1988g.mo671a(mo756a(), this.f1995n, m3537c())) {
            Log.e("GmsClient", "unable to connect to service: " + mo756a());
            this.f1983a.sendMessage(this.f1983a.obtainMessage(3, this.f1984b.get(), 9));
        }
    }

    private void m3524p() {
        if (this.f1995n != null) {
            this.f1988g.mo672b(mo756a(), this.f1995n, m3537c());
            this.f1995n = null;
        }
    }

    protected abstract T mo755a(IBinder iBinder);

    protected abstract String mo756a();

    protected Set<Scope> m3527a(Set<Scope> set) {
        return set;
    }

    protected void m3528a(int i) {
    }

    protected void m3529a(int i, Bundle bundle, int i2) {
        this.f1983a.sendMessage(this.f1983a.obtainMessage(5, i2, -1, new C1016i(this, i, bundle)));
    }

    protected void m3530a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f1983a.sendMessage(this.f1983a.obtainMessage(1, i2, -1, new C1014g(this, i, iBinder, bundle)));
    }

    protected void m3531a(int i, T t) {
    }

    protected void m3532a(ConnectionResult connectionResult) {
    }

    public void m3533a(C0743e c0743e) {
        this.f1992k = (C0743e) C1032p.m3679a((Object) c0743e, (Object) "Connection progress callbacks cannot be null.");
        m3519b(2, null);
    }

    public void m3534a(C0996l c0996l, Set<Scope> set) {
        try {
            GetServiceRequest a = new GetServiceRequest(this.f2001t).m3460a(this.f1985d.getPackageName()).m3458a(m3544i());
            if (set != null) {
                a.m3461a((Collection) set);
            }
            if (m3548m()) {
                a.m3457a(m3543h()).m3459a(c0996l);
            } else if (m3549n()) {
                a.m3457a(this.f1998q);
            }
            this.f1991j.mo685a(new C1011d(this, this.f1984b.get()), a);
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            m3536b(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    protected abstract String mo757b();

    public void m3536b(int i) {
        this.f1983a.sendMessage(this.f1983a.obtainMessage(4, this.f1984b.get(), i));
    }

    protected final String m3537c() {
        return this.f1986e.m3477c();
    }

    protected void m3538c(int i) {
        this.f1983a.sendMessage(this.f1983a.obtainMessage(6, i, -1, new C1015h(this)));
    }

    protected void m3539d() {
    }

    public void m3540e() {
        int a = this.f1989h.m3204a(this.f1985d);
        if (a != 0) {
            m3519b(1, null);
            this.f1992k = new C1013f(this);
            this.f1983a.sendMessage(this.f1983a.obtainMessage(3, this.f1984b.get(), a));
            return;
        }
        m3533a(new C1013f(this));
    }

    public boolean m3541f() {
        boolean z;
        synchronized (this.f1990i) {
            z = this.f1996o == 3;
        }
        return z;
    }

    public boolean m3542g() {
        boolean z;
        synchronized (this.f1990i) {
            z = this.f1996o == 2;
        }
        return z;
    }

    public final Account m3543h() {
        return this.f1998q != null ? this.f1998q : new Account("<<default account>>", "com.google");
    }

    protected Bundle m3544i() {
        return new Bundle();
    }

    protected final void m3545j() {
        if (!m3541f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle m3546k() {
        return null;
    }

    public final T m3547l() {
        T t;
        synchronized (this.f1990i) {
            if (this.f1996o == 4) {
                throw new DeadObjectException();
            }
            m3545j();
            C1032p.m3683a(this.f1993l != null, (Object) "Client is connected but service is null");
            t = this.f1993l;
        }
        return t;
    }

    public boolean m3548m() {
        return false;
    }

    public boolean m3549n() {
        return false;
    }
}
