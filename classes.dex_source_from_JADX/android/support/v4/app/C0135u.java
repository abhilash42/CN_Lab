package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.C0133t.C0132a;
import android.support.v4.p004a.C0036h;
import android.support.v4.p004a.C0036h.C0034a;
import android.support.v4.p004a.C0036h.C0035b;
import android.support.v4.p009e.C0191c;
import android.support.v4.p009e.C0204j;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: LoaderManager */
class C0135u extends C0133t {
    static boolean f424a = false;
    final C0204j<C0134a> f425b = new C0204j();
    final C0204j<C0134a> f426c = new C0204j();
    final String f427d;
    boolean f428e;
    boolean f429f;
    private C0110o f430g;

    /* compiled from: LoaderManager */
    final class C0134a implements C0034a<Object>, C0035b<Object> {
        final int f409a;
        final Bundle f410b;
        C0132a<Object> f411c;
        C0036h<Object> f412d;
        boolean f413e;
        boolean f414f;
        Object f415g;
        boolean f416h;
        boolean f417i;
        boolean f418j;
        boolean f419k;
        boolean f420l;
        boolean f421m;
        C0134a f422n;
        final /* synthetic */ C0135u f423o;

        void m562a() {
            if (this.f417i && this.f418j) {
                this.f416h = true;
            } else if (!this.f416h) {
                this.f416h = true;
                if (C0135u.f424a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f412d == null && this.f411c != null) {
                    this.f412d = this.f411c.m558a(this.f409a, this.f410b);
                }
                if (this.f412d == null) {
                    return;
                }
                if (!this.f412d.getClass().isMemberClass() || Modifier.isStatic(this.f412d.getClass().getModifiers())) {
                    if (!this.f421m) {
                        this.f412d.m96a(this.f409a, this);
                        this.f412d.m97a((C0034a) this);
                        this.f421m = true;
                    }
                    this.f412d.m95a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f412d);
            }
        }

        void m565b() {
            if (C0135u.f424a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f417i = true;
            this.f418j = this.f416h;
            this.f416h = false;
            this.f411c = null;
        }

        void m566c() {
            if (this.f417i) {
                if (C0135u.f424a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f417i = false;
                if (!(this.f416h == this.f418j || this.f416h)) {
                    m568e();
                }
            }
            if (this.f416h && this.f413e && !this.f419k) {
                m563a(this.f412d, this.f415g);
            }
        }

        void m567d() {
            if (this.f416h && this.f419k) {
                this.f419k = false;
                if (this.f413e) {
                    m563a(this.f412d, this.f415g);
                }
            }
        }

        void m568e() {
            if (C0135u.f424a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f416h = false;
            if (!this.f417i && this.f412d != null && this.f421m) {
                this.f421m = false;
                this.f412d.m98a((C0035b) this);
                this.f412d.m101b(this);
                this.f412d.m102c();
            }
        }

        void m569f() {
            String str;
            C0132a c0132a = null;
            if (C0135u.f424a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f420l = true;
            boolean z = this.f414f;
            this.f414f = false;
            if (this.f411c != null && this.f412d != null && this.f413e && z) {
                if (C0135u.f424a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.f423o.f430g != null) {
                    String str2 = this.f423o.f430g.f321d.f382v;
                    this.f423o.f430g.f321d.f382v = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f411c.m559a(this.f412d);
                } finally {
                    c0132a = this.f423o.f430g;
                    if (c0132a != null) {
                        c0132a = this.f423o.f430g.f321d;
                        c0132a.f382v = str;
                    }
                }
            }
            this.f411c = c0132a;
            this.f415g = c0132a;
            this.f413e = false;
            if (this.f412d != null) {
                if (this.f421m) {
                    this.f421m = false;
                    this.f412d.m98a((C0035b) this);
                    this.f412d.m101b(this);
                }
                this.f412d.m104e();
            }
            if (this.f422n != null) {
                this.f422n.m569f();
            }
        }

        void m563a(C0036h<Object> c0036h, Object obj) {
            String str;
            if (this.f411c != null) {
                if (this.f423o.f430g != null) {
                    String str2 = this.f423o.f430g.f321d.f382v;
                    this.f423o.f430g.f321d.f382v = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (C0135u.f424a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + c0036h + ": " + c0036h.m94a(obj));
                    }
                    this.f411c.m560a((C0036h) c0036h, obj);
                    this.f414f = true;
                } finally {
                    if (this.f423o.f430g != null) {
                        this.f423o.f430g.f321d.f382v = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f409a);
            stringBuilder.append(" : ");
            C0191c.m779a(this.f412d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public void m564a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f409a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f410b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f411c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f412d);
            if (this.f412d != null) {
                this.f412d.m99a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f413e || this.f414f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f413e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f414f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f415g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f416h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f419k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f420l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f417i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f418j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f421m);
            if (this.f422n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f422n);
                printWriter.println(":");
                this.f422n.m564a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    C0135u(String str, C0110o c0110o, boolean z) {
        this.f427d = str;
        this.f430g = c0110o;
        this.f428e = z;
    }

    void m571a(C0110o c0110o) {
        this.f430g = c0110o;
    }

    void m574b() {
        if (f424a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f428e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f428e = true;
        for (int b = this.f425b.m810b() - 1; b >= 0; b--) {
            ((C0134a) this.f425b.m816e(b)).m562a();
        }
    }

    void m575c() {
        if (f424a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f428e) {
            for (int b = this.f425b.m810b() - 1; b >= 0; b--) {
                ((C0134a) this.f425b.m816e(b)).m568e();
            }
            this.f428e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m576d() {
        if (f424a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f428e) {
            this.f429f = true;
            this.f428e = false;
            for (int b = this.f425b.m810b() - 1; b >= 0; b--) {
                ((C0134a) this.f425b.m816e(b)).m565b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m577e() {
        if (this.f429f) {
            if (f424a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f429f = false;
            for (int b = this.f425b.m810b() - 1; b >= 0; b--) {
                ((C0134a) this.f425b.m816e(b)).m566c();
            }
        }
    }

    void m578f() {
        for (int b = this.f425b.m810b() - 1; b >= 0; b--) {
            ((C0134a) this.f425b.m816e(b)).f419k = true;
        }
    }

    void m579g() {
        for (int b = this.f425b.m810b() - 1; b >= 0; b--) {
            ((C0134a) this.f425b.m816e(b)).m567d();
        }
    }

    void m580h() {
        int b;
        if (!this.f429f) {
            if (f424a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f425b.m810b() - 1; b >= 0; b--) {
                ((C0134a) this.f425b.m816e(b)).m569f();
            }
            this.f425b.m813c();
        }
        if (f424a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f426c.m810b() - 1; b >= 0; b--) {
            ((C0134a) this.f426c.m816e(b)).m569f();
        }
        this.f426c.m813c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0191c.m779a(this.f430g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m572a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f425b.m810b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f425b.m810b(); i2++) {
                C0134a c0134a = (C0134a) this.f425b.m816e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f425b.m815d(i2));
                printWriter.print(": ");
                printWriter.println(c0134a.toString());
                c0134a.m564a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f426c.m810b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f426c.m810b()) {
                c0134a = (C0134a) this.f426c.m816e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f426c.m815d(i));
                printWriter.print(": ");
                printWriter.println(c0134a.toString());
                c0134a.m564a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo82a() {
        int b = this.f425b.m810b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            C0134a c0134a = (C0134a) this.f425b.m816e(i);
            if (!c0134a.f416h || c0134a.f414f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
