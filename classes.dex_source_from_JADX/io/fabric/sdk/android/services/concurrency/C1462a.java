package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask */
public abstract class C1462a<Params, Progress, Result> {
    private static final int f3657a = Runtime.getRuntime().availableProcessors();
    public static final Executor f3658b = new ThreadPoolExecutor(f3660d, f3661e, 1, TimeUnit.SECONDS, f3663g, f3662f);
    public static final Executor f3659c = new C1521c();
    private static final int f3660d = (f3657a + 1);
    private static final int f3661e = ((f3657a * 2) + 1);
    private static final ThreadFactory f3662f = new C15091();
    private static final BlockingQueue<Runnable> f3663g = new LinkedBlockingQueue(128);
    private static final C1520b f3664h = new C1520b();
    private static volatile Executor f3665i = f3659c;
    private final C1522e<Params, Result> f3666j = new C15112(this);
    private final FutureTask<Result> f3667k = new FutureTask<Result>(this, this.f3666j) {
        final /* synthetic */ C1462a f3792a;

        protected void done() {
            try {
                this.f3792a.m5569c(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f3792a.m5569c(null);
            }
        }
    };
    private volatile C1519d f3668l = C1519d.PENDING;
    private final AtomicBoolean f3669m = new AtomicBoolean();
    private final AtomicBoolean f3670n = new AtomicBoolean();

    /* compiled from: AsyncTask */
    static class C15091 implements ThreadFactory {
        private final AtomicInteger f3789a = new AtomicInteger(1);

        C15091() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f3789a.getAndIncrement());
        }
    }

    /* compiled from: AsyncTask */
    private static abstract class C1522e<Params, Result> implements Callable<Result> {
        Params[] f3790b;

        private C1522e() {
        }
    }

    /* compiled from: AsyncTask */
    class C15112 extends C1522e<Params, Result> {
        final /* synthetic */ C1462a f3791a;

        C15112(C1462a c1462a) {
            this.f3791a = c1462a;
            super();
        }

        public Result call() {
            this.f3791a.f3670n.set(true);
            Process.setThreadPriority(10);
            return this.f3791a.m5570d(this.f3791a.mo822a(this.b));
        }
    }

    /* compiled from: AsyncTask */
    private static class C1514a<Data> {
        final C1462a f3794a;
        final Data[] f3795b;

        C1514a(C1462a c1462a, Data... dataArr) {
            this.f3794a = c1462a;
            this.f3795b = dataArr;
        }
    }

    /* compiled from: AsyncTask */
    private static class C1520b extends Handler {
        public C1520b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C1514a c1514a = (C1514a) message.obj;
            switch (message.what) {
                case 1:
                    c1514a.f3794a.m5571e(c1514a.f3795b[0]);
                    return;
                case 2:
                    c1514a.f3794a.m5579b(c1514a.f3795b);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AsyncTask */
    private static class C1521c implements Executor {
        final LinkedList<Runnable> f3798a;
        Runnable f3799b;

        private C1521c() {
            this.f3798a = new LinkedList();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f3798a.offer(new Runnable(this) {
                final /* synthetic */ C1521c f3797b;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.f3797b.m5766a();
                    }
                }
            });
            if (this.f3799b == null) {
                m5766a();
            }
        }

        protected synchronized void m5766a() {
            Runnable runnable = (Runnable) this.f3798a.poll();
            this.f3799b = runnable;
            if (runnable != null) {
                C1462a.f3658b.execute(this.f3799b);
            }
        }
    }

    /* compiled from: AsyncTask */
    public enum C1519d {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result mo822a(Params... paramsArr);

    private void m5569c(Result result) {
        if (!this.f3670n.get()) {
            m5570d(result);
        }
    }

    private Result m5570d(Result result) {
        f3664h.obtainMessage(1, new C1514a(this, result)).sendToTarget();
        return result;
    }

    public final C1519d m5577b() {
        return this.f3668l;
    }

    protected void mo823a() {
    }

    protected void mo824a(Result result) {
    }

    protected void m5579b(Progress... progressArr) {
    }

    protected void mo825b(Result result) {
        m5580c();
    }

    protected void m5580c() {
    }

    public final boolean m5581d() {
        return this.f3669m.get();
    }

    public final boolean m5576a(boolean z) {
        this.f3669m.set(true);
        return this.f3667k.cancel(z);
    }

    public final C1462a<Params, Progress, Result> m5572a(Executor executor, Params... paramsArr) {
        if (this.f3668l != C1519d.PENDING) {
            switch (this.f3668l) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f3668l = C1519d.RUNNING;
        mo823a();
        this.f3666j.f3790b = paramsArr;
        executor.execute(this.f3667k);
        return this;
    }

    private void m5571e(Result result) {
        if (m5581d()) {
            mo825b((Object) result);
        } else {
            mo824a((Object) result);
        }
        this.f3668l = C1519d.FINISHED;
    }
}
