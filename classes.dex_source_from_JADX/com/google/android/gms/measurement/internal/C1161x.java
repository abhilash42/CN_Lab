package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1075e;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class C1161x extends ab {
    private C1160c f2463a;
    private C1160c f2464b;
    private final BlockingQueue<FutureTask<?>> f2465c = new LinkedBlockingQueue();
    private final BlockingQueue<FutureTask<?>> f2466d = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler f2467e = new C1159b(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler f2468f = new C1159b(this, "Thread death: Uncaught exception on network thread");
    private final Object f2469h = new Object();
    private final Semaphore f2470i = new Semaphore(2);
    private volatile boolean f2471j;

    private final class C1158a<V> extends FutureTask<V> {
        final /* synthetic */ C1161x f2456a;
        private final String f2457b;

        C1158a(C1161x c1161x, Runnable runnable, String str) {
            this.f2456a = c1161x;
            super(runnable, null);
            C1032p.m3678a((Object) str);
            this.f2457b = str;
        }

        protected void setException(Throwable th) {
            this.f2456a.mo743l().m4399b().m4388a(this.f2457b, th);
            super.setException(th);
        }
    }

    private final class C1159b implements UncaughtExceptionHandler {
        final /* synthetic */ C1161x f2458a;
        private final String f2459b;

        public C1159b(C1161x c1161x, String str) {
            this.f2458a = c1161x;
            C1032p.m3678a((Object) str);
            this.f2459b = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            this.f2458a.mo743l().m4399b().m4388a(this.f2459b, th);
        }
    }

    private final class C1160c extends Thread {
        final /* synthetic */ C1161x f2460a;
        private final Object f2461b = new Object();
        private final BlockingQueue<FutureTask<?>> f2462c;

        public C1160c(C1161x c1161x, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            this.f2460a = c1161x;
            C1032p.m3678a((Object) str);
            this.f2462c = blockingQueue;
            setName(str);
        }

        private void m4466a(InterruptedException interruptedException) {
            this.f2460a.mo743l().m4412o().m4388a(getName() + " was interrupted", interruptedException);
        }

        public void m4467a() {
            synchronized (this.f2461b) {
                this.f2461b.notifyAll();
            }
        }

        public void run() {
            while (true) {
                FutureTask futureTask = (FutureTask) this.f2462c.poll();
                if (futureTask == null) {
                    synchronized (this.f2461b) {
                        if (this.f2462c.peek() == null && !this.f2460a.f2471j) {
                            try {
                                this.f2461b.wait(30000);
                            } catch (InterruptedException e) {
                                m4466a(e);
                            }
                        }
                    }
                    synchronized (this.f2460a.f2469h) {
                        if (this.f2462c.peek() == null) {
                            break;
                        }
                    }
                }
                futureTask.run();
            }
            this.f2460a.f2470i.release();
            this.f2460a.f2469h.notifyAll();
            if (this == this.f2460a.f2463a) {
                this.f2460a.f2463a = null;
            } else if (this == this.f2460a.f2464b) {
                this.f2460a.f2464b = null;
            } else {
                this.f2460a.mo743l().m4399b().m4387a("Current scheduler thread is neither worker nor network");
            }
        }
    }

    C1161x(C1164y c1164y) {
        super(c1164y);
    }

    private void m4469a(FutureTask<?> futureTask) {
        synchronized (this.f2469h) {
            this.f2465c.add(futureTask);
            if (this.f2463a == null) {
                this.f2463a = new C1160c(this, "Measurement Worker", this.f2465c);
                this.f2463a.setUncaughtExceptionHandler(this.f2467e);
                this.f2463a.start();
            } else {
                this.f2463a.m4467a();
            }
        }
    }

    private void m4473b(FutureTask<?> futureTask) {
        synchronized (this.f2469h) {
            this.f2466d.add(futureTask);
            if (this.f2464b == null) {
                this.f2464b = new C1160c(this, "Measurement Network", this.f2466d);
                this.f2464b.setUncaughtExceptionHandler(this.f2468f);
                this.f2464b.start();
            } else {
                this.f2464b.m4467a();
            }
        }
    }

    protected void mo733a() {
    }

    public void m4478a(Runnable runnable) {
        m4091y();
        C1032p.m3678a((Object) runnable);
        m4469a(new C1158a(this, runnable, "Task exception on worker thread"));
    }

    public void m4479b(Runnable runnable) {
        m4091y();
        C1032p.m3678a((Object) runnable);
        m4473b(new C1158a(this, runnable, "Task exception on network thread"));
    }

    public /* bridge */ /* synthetic */ void mo734c() {
        super.mo734c();
    }

    public void mo735d() {
        if (Thread.currentThread() != this.f2464b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public void mo736e() {
        if (Thread.currentThread() != this.f2463a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public /* bridge */ /* synthetic */ C1142r mo737f() {
        return super.mo737f();
    }

    public /* bridge */ /* synthetic */ ae mo738g() {
        return super.mo738g();
    }

    public /* bridge */ /* synthetic */ C1075e mo739h() {
        return super.mo739h();
    }

    public /* bridge */ /* synthetic */ Context mo740i() {
        return super.mo740i();
    }

    public /* bridge */ /* synthetic */ C1126f mo741j() {
        return super.mo741j();
    }

    public /* bridge */ /* synthetic */ C1161x mo742k() {
        return super.mo742k();
    }

    public /* bridge */ /* synthetic */ C1146t mo743l() {
        return super.mo743l();
    }

    public /* bridge */ /* synthetic */ C1157w mo744m() {
        return super.mo744m();
    }

    public /* bridge */ /* synthetic */ C1128h mo745n() {
        return super.mo745n();
    }
}
