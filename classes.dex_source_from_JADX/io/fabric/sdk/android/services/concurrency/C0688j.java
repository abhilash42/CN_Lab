package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PriorityTask */
public class C0688j implements C0685b<C0687l>, C0686i, C0687l {
    private final List<C0687l> dependencies = new ArrayList();
    private final AtomicBoolean hasRun = new AtomicBoolean(false);
    private final AtomicReference<Throwable> throwable = new AtomicReference(null);

    public synchronized Collection<C0687l> getDependencies() {
        return Collections.unmodifiableCollection(this.dependencies);
    }

    public synchronized void addDependency(C0687l c0687l) {
        this.dependencies.add(c0687l);
    }

    public boolean areDependenciesMet() {
        for (C0687l isFinished : getDependencies()) {
            if (!isFinished.isFinished()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void setFinished(boolean z) {
        this.hasRun.set(z);
    }

    public boolean isFinished() {
        return this.hasRun.get();
    }

    public C1525e getPriority() {
        return C1525e.NORMAL;
    }

    public void setError(Throwable th) {
        this.throwable.set(th);
    }

    public Throwable getError() {
        return (Throwable) this.throwable.get();
    }

    public int compareTo(Object obj) {
        return C1525e.m5781a(this, obj);
    }

    public static boolean isProperDelegate(Object obj) {
        try {
            C0685b c0685b = (C0685b) obj;
            C0687l c0687l = (C0687l) obj;
            C0686i c0686i = (C0686i) obj;
            if (c0685b == null || c0687l == null || c0686i == null) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
