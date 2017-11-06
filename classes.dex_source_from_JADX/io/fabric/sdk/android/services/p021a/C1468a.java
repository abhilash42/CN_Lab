package io.fabric.sdk.android.services.p021a;

import android.content.Context;

/* compiled from: AbstractValueCache */
public abstract class C1468a<T> implements C1467c<T> {
    private final C1467c<T> f3687a;

    protected abstract T mo827a(Context context);

    protected abstract void mo828a(Context context, T t);

    public C1468a(C1467c<T> c1467c) {
        this.f3687a = c1467c;
    }

    public final synchronized T mo826a(Context context, C0677d<T> c0677d) {
        T a;
        a = mo827a(context);
        if (a == null) {
            a = this.f3687a != null ? this.f3687a.mo826a(context, c0677d) : c0677d.load(context);
            m5604b(context, a);
        }
        return a;
    }

    private void m5604b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        mo828a(context, (Object) t);
    }
}
