package io.fabric.sdk.android.services.concurrency;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DependencyPriorityBlockingQueue */
public class C1523c<E extends C0685b & C0687l & C0686i> extends PriorityBlockingQueue<E> {
    final Queue<E> f3810a = new LinkedList();
    private final ReentrantLock f3811b = new ReentrantLock();

    public /* synthetic */ Object peek() {
        return m5776b();
    }

    public /* synthetic */ Object poll() {
        return m5778c();
    }

    public /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
        return m5772a(j, timeUnit);
    }

    public /* synthetic */ Object take() {
        return m5770a();
    }

    public E m5770a() {
        return m5777b(0, null, null);
    }

    public E m5776b() {
        E e = null;
        try {
            e = m5777b(1, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public E m5772a(long j, TimeUnit timeUnit) {
        return m5777b(3, Long.valueOf(j), timeUnit);
    }

    public E m5778c() {
        E e = null;
        try {
            e = m5777b(2, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public int size() {
        try {
            this.f3811b.lock();
            int size = this.f3810a.size() + super.size();
            return size;
        } finally {
            this.f3811b.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.f3811b.lock();
            T[] a = m5775a(super.toArray(tArr), this.f3810a.toArray(tArr));
            return a;
        } finally {
            this.f3811b.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.f3811b.lock();
            Object[] a = m5775a(super.toArray(), this.f3810a.toArray());
            return a;
        } finally {
            this.f3811b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.f3811b.lock();
            int drainTo = super.drainTo(collection) + this.f3810a.size();
            while (!this.f3810a.isEmpty()) {
                collection.add(this.f3810a.poll());
            }
            return drainTo;
        } finally {
            this.f3811b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f3811b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f3810a.isEmpty() && drainTo <= i) {
                collection.add(this.f3810a.poll());
                drainTo++;
            }
            this.f3811b.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.f3811b.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.f3811b.lock();
            boolean z = super.contains(obj) || this.f3810a.contains(obj);
            this.f3811b.unlock();
            return z;
        } catch (Throwable th) {
            this.f3811b.unlock();
        }
    }

    public void clear() {
        try {
            this.f3811b.lock();
            this.f3810a.clear();
            super.clear();
        } finally {
            this.f3811b.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.f3811b.lock();
            boolean z = super.remove(obj) || this.f3810a.remove(obj);
            this.f3811b.unlock();
            return z;
        } catch (Throwable th) {
            this.f3811b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f3811b.lock();
            boolean removeAll = super.removeAll(collection) | this.f3810a.removeAll(collection);
            return removeAll;
        } finally {
            this.f3811b.unlock();
        }
    }

    E m5771a(int i, Long l, TimeUnit timeUnit) {
        switch (i) {
            case 0:
                return (C0685b) super.take();
            case 1:
                return (C0685b) super.peek();
            case 2:
                return (C0685b) super.poll();
            case 3:
                return (C0685b) super.poll(l.longValue(), timeUnit);
            default:
                return null;
        }
    }

    boolean m5773a(int i, E e) {
        try {
            this.f3811b.lock();
            if (i == 1) {
                super.remove(e);
            }
            boolean offer = this.f3810a.offer(e);
            return offer;
        } finally {
            this.f3811b.unlock();
        }
    }

    E m5777b(int i, Long l, TimeUnit timeUnit) {
        C0685b a;
        while (true) {
            a = m5771a(i, l, timeUnit);
            if (a == null || m5774a(a)) {
                return a;
            }
            m5773a(i, a);
        }
        return a;
    }

    boolean m5774a(E e) {
        return e.areDependenciesMet();
    }

    public void m5779d() {
        try {
            this.f3811b.lock();
            Iterator it = this.f3810a.iterator();
            while (it.hasNext()) {
                C0685b c0685b = (C0685b) it.next();
                if (m5774a(c0685b)) {
                    super.offer(c0685b);
                    it.remove();
                }
            }
        } finally {
            this.f3811b.unlock();
        }
    }

    <T> T[] m5775a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, objArr, 0, length);
        System.arraycopy(tArr2, 0, objArr, length, length2);
        return objArr;
    }
}
