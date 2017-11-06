package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask */
public class C1526h<V> extends FutureTask<V> implements C0685b<C0687l>, C0686i, C0687l {
    final Object f3817b;

    public /* synthetic */ void addDependency(Object obj) {
        m5784a((C0687l) obj);
    }

    public C1526h(Callable<V> callable) {
        super(callable);
        this.f3817b = m5783a((Object) callable);
    }

    public C1526h(Runnable runnable, V v) {
        super(runnable, v);
        this.f3817b = m5783a((Object) runnable);
    }

    public int compareTo(Object obj) {
        return ((C0686i) mo841a()).compareTo(obj);
    }

    public void m5784a(C0687l c0687l) {
        ((C0685b) ((C0686i) mo841a())).addDependency(c0687l);
    }

    public Collection<C0687l> getDependencies() {
        return ((C0685b) ((C0686i) mo841a())).getDependencies();
    }

    public boolean areDependenciesMet() {
        return ((C0685b) ((C0686i) mo841a())).areDependenciesMet();
    }

    public C1525e getPriority() {
        return ((C0686i) mo841a()).getPriority();
    }

    public void setFinished(boolean z) {
        ((C0687l) ((C0686i) mo841a())).setFinished(z);
    }

    public boolean isFinished() {
        return ((C0687l) ((C0686i) mo841a())).isFinished();
    }

    public void setError(Throwable th) {
        ((C0687l) ((C0686i) mo841a())).setError(th);
    }

    public <T extends C0685b<C0687l> & C0686i & C0687l> T mo841a() {
        return (C0685b) this.f3817b;
    }

    protected <T extends C0685b<C0687l> & C0686i & C0687l> T m5783a(Object obj) {
        if (C0688j.isProperDelegate(obj)) {
            return (C0685b) obj;
        }
        return new C0688j();
    }
}
