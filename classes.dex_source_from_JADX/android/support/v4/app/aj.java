package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.al.C0083a;
import android.support.v4.app.al.C0083a.C0077a;

/* compiled from: RemoteInput */
public final class aj extends C0083a {
    public static final C0077a f245a = new C00781();
    private static final C0079a f246g;
    private final String f247b;
    private final CharSequence f248c;
    private final CharSequence[] f249d;
    private final boolean f250e;
    private final Bundle f251f;

    /* compiled from: RemoteInput */
    static class C00781 implements C0077a {
        C00781() {
        }
    }

    /* compiled from: RemoteInput */
    interface C0079a {
    }

    /* compiled from: RemoteInput */
    static class C0080b implements C0079a {
        C0080b() {
        }
    }

    /* compiled from: RemoteInput */
    static class C0081c implements C0079a {
        C0081c() {
        }
    }

    /* compiled from: RemoteInput */
    static class C0082d implements C0079a {
        C0082d() {
        }
    }

    public String mo38a() {
        return this.f247b;
    }

    public CharSequence mo39b() {
        return this.f248c;
    }

    public CharSequence[] mo40c() {
        return this.f249d;
    }

    public boolean mo41d() {
        return this.f250e;
    }

    public Bundle mo42e() {
        return this.f251f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f246g = new C0080b();
        } else if (VERSION.SDK_INT >= 16) {
            f246g = new C0082d();
        } else {
            f246g = new C0081c();
        }
    }
}
