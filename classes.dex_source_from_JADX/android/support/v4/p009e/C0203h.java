package android.support.v4.p009e;

/* compiled from: Pools */
public final class C0203h {

    /* compiled from: Pools */
    public interface C0200a<T> {
        T mo120a();

        boolean mo121a(T t);
    }

    /* compiled from: Pools */
    public static class C0201b<T> implements C0200a<T> {
        private final Object[] f497a;
        private int f498b;

        public C0201b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f497a = new Object[i];
        }

        public T mo120a() {
            if (this.f498b <= 0) {
                return null;
            }
            int i = this.f498b - 1;
            T t = this.f497a[i];
            this.f497a[i] = null;
            this.f498b--;
            return t;
        }

        public boolean mo121a(T t) {
            if (m801b(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f498b >= this.f497a.length) {
                return false;
            } else {
                this.f497a[this.f498b] = t;
                this.f498b++;
                return true;
            }
        }

        private boolean m801b(T t) {
            for (int i = 0; i < this.f498b; i++) {
                if (this.f497a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: Pools */
    public static class C0202c<T> extends C0201b<T> {
        private final Object f499a = new Object();

        public C0202c(int i) {
            super(i);
        }

        public T mo120a() {
            T a;
            synchronized (this.f499a) {
                a = super.mo120a();
            }
            return a;
        }

        public boolean mo121a(T t) {
            boolean a;
            synchronized (this.f499a) {
                a = super.mo121a(t);
            }
            return a;
        }
    }
}
