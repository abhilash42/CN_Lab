package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.C1462a.C1519d;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: PriorityAsyncTask */
public abstract class C1463f<Params, Progress, Result> extends C1462a<Params, Progress, Result> implements C0685b<C0687l>, C0686i, C0687l {
    private final C0688j f3671a = new C0688j();

    /* compiled from: PriorityAsyncTask */
    private static class C1528a<Result> implements Executor {
        private final Executor f3819a;
        private final C1463f f3820b;

        public C1528a(Executor executor, C1463f c1463f) {
            this.f3819a = executor;
            this.f3820b = c1463f;
        }

        public void execute(Runnable runnable) {
            this.f3819a.execute(new C1526h<Result>(this, runnable, null) {
                final /* synthetic */ C1528a f3818a;

                public <T extends C0685b<C0687l> & C0686i & C0687l> T mo841a() {
                    return this.f3818a.f3820b;
                }
            });
        }
    }

    public /* synthetic */ void addDependency(Object obj) {
        m5582a((C0687l) obj);
    }

    public final void m5583a(ExecutorService executorService, Params... paramsArr) {
        super.m5572a(new C1528a(executorService, this), (Object[]) paramsArr);
    }

    public int compareTo(Object obj) {
        return C1525e.m5781a(this, obj);
    }

    public void m5582a(C0687l c0687l) {
        if (m5577b() != C1519d.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((C0685b) ((C0686i) m5584e())).addDependency(c0687l);
    }

    public Collection<C0687l> getDependencies() {
        return ((C0685b) ((C0686i) m5584e())).getDependencies();
    }

    public boolean areDependenciesMet() {
        return ((C0685b) ((C0686i) m5584e())).areDependenciesMet();
    }

    public C1525e getPriority() {
        return ((C0686i) m5584e()).getPriority();
    }

    public void setFinished(boolean z) {
        ((C0687l) ((C0686i) m5584e())).setFinished(z);
    }

    public boolean isFinished() {
        return ((C0687l) ((C0686i) m5584e())).isFinished();
    }

    public void setError(Throwable th) {
        ((C0687l) ((C0686i) m5584e())).setError(th);
    }

    public <T extends C0685b<C0687l> & C0686i & C0687l> T m5584e() {
        return this.f3671a;
    }
}
