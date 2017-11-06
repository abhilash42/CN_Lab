package io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolExecutor */
public class C1530k extends ThreadPoolExecutor {
    private static final int f3822a = Runtime.getRuntime().availableProcessors();
    private static final int f3823b = (f3822a + 1);
    private static final int f3824c = ((f3822a * 2) + 1);

    /* compiled from: PriorityThreadPoolExecutor */
    protected static final class C1529a implements ThreadFactory {
        private final int f3821a;

        public C1529a(int i) {
            this.f3821a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f3821a);
            thread.setName("Queue");
            return thread;
        }
    }

    public /* synthetic */ BlockingQueue getQueue() {
        return m5789b();
    }

    <T extends Runnable & C0685b & C0687l & C0686i> C1530k(int i, int i2, long j, TimeUnit timeUnit, C1523c<T> c1523c, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, c1523c, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & C0685b & C0687l & C0686i> C1530k m5788a(int i, int i2) {
        return new C1530k(i, i2, 1, TimeUnit.SECONDS, new C1523c(), new C1529a(10));
    }

    public static C1530k m5787a() {
        return C1530k.m5788a(f3823b, f3824c);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C1526h(runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C1526h(callable);
    }

    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (C0688j.isProperDelegate(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        C0687l c0687l = (C0687l) runnable;
        c0687l.setFinished(true);
        c0687l.setError(th);
        m5789b().m5779d();
        super.afterExecute(runnable, th);
    }

    public C1523c m5789b() {
        return (C1523c) super.getQueue();
    }
}
