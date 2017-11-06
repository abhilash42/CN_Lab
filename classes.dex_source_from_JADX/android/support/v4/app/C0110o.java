package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.p009e.C0188i;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback */
public abstract class C0110o<E> extends C0044m {
    private final Activity f318a;
    final Context f319b;
    final int f320c;
    final C0125q f321d;
    private final Handler f322e;
    private C0188i<String, C0133t> f323f;
    private boolean f324g;
    private C0135u f325h;
    private boolean f326i;
    private boolean f327j;

    C0110o(C0113l c0113l) {
        this(c0113l, c0113l, c0113l.f332a, 0);
    }

    C0110o(Activity activity, Context context, Handler handler, int i) {
        this.f321d = new C0125q();
        this.f318a = activity;
        this.f319b = context;
        this.f322e = handler;
        this.f320c = i;
    }

    public void mo63a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean mo64a(Fragment fragment) {
        return true;
    }

    public LayoutInflater mo65b() {
        return (LayoutInflater) this.f319b.getSystemService("layout_inflater");
    }

    public void mo67c() {
    }

    public void mo62a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f319b.startActivity(intent);
    }

    public boolean mo68d() {
        return true;
    }

    public int mo69e() {
        return this.f320c;
    }

    public View mo27a(int i) {
        return null;
    }

    public boolean mo28a() {
        return true;
    }

    Activity m396f() {
        return this.f318a;
    }

    Context m397g() {
        return this.f319b;
    }

    Handler m398h() {
        return this.f322e;
    }

    C0125q m399i() {
        return this.f321d;
    }

    void m385a(String str) {
        if (this.f323f != null) {
            C0135u c0135u = (C0135u) this.f323f.get(str);
            if (c0135u != null && !c0135u.f429f) {
                c0135u.m580h();
                this.f323f.remove(str);
            }
        }
    }

    void mo66b(Fragment fragment) {
    }

    boolean m400j() {
        return this.f324g;
    }

    void m401k() {
        if (!this.f327j) {
            this.f327j = true;
            if (this.f325h != null) {
                this.f325h.m574b();
            } else if (!this.f326i) {
                this.f325h = m381a("(root)", this.f327j, false);
                if (!(this.f325h == null || this.f325h.f428e)) {
                    this.f325h.m574b();
                }
            }
            this.f326i = true;
        }
    }

    void m387a(boolean z) {
        this.f324g = z;
        if (this.f325h != null && this.f327j) {
            this.f327j = false;
            if (z) {
                this.f325h.m576d();
            } else {
                this.f325h.m575c();
            }
        }
    }

    void m402l() {
        if (this.f325h != null) {
            this.f325h.m580h();
        }
    }

    void m403m() {
        if (this.f323f != null) {
            int size = this.f323f.size();
            C0135u[] c0135uArr = new C0135u[size];
            for (int i = size - 1; i >= 0; i--) {
                c0135uArr[i] = (C0135u) this.f323f.m769c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                C0135u c0135u = c0135uArr[i2];
                c0135u.m577e();
                c0135u.m579g();
            }
        }
    }

    C0135u m381a(String str, boolean z, boolean z2) {
        if (this.f323f == null) {
            this.f323f = new C0188i();
        }
        C0135u c0135u = (C0135u) this.f323f.get(str);
        if (c0135u != null) {
            c0135u.m571a(this);
            return c0135u;
        } else if (!z2) {
            return c0135u;
        } else {
            c0135u = new C0135u(str, this, z);
            this.f323f.put(str, c0135u);
            return c0135u;
        }
    }

    C0188i<String, C0133t> m404n() {
        int i;
        int i2 = 0;
        if (this.f323f != null) {
            int size = this.f323f.size();
            C0135u[] c0135uArr = new C0135u[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c0135uArr[i3] = (C0135u) this.f323f.m769c(i3);
            }
            i = 0;
            while (i2 < size) {
                C0135u c0135u = c0135uArr[i2];
                if (c0135u.f429f) {
                    i = 1;
                } else {
                    c0135u.m580h();
                    this.f323f.remove(c0135u.f427d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.f323f;
        }
        return null;
    }

    void m384a(C0188i<String, C0133t> c0188i) {
        this.f323f = c0188i;
    }

    void m392b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f327j);
        if (this.f325h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f325h)));
            printWriter.println(":");
            this.f325h.m572a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
