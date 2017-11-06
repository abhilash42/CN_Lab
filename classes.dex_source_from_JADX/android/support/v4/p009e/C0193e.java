package android.support.v4.p009e;

/* compiled from: LongSparseArray */
public class C0193e<E> implements Cloneable {
    private static final Object f472a = new Object();
    private boolean f473b;
    private long[] f474c;
    private Object[] f475d;
    private int f476e;

    public /* synthetic */ Object clone() {
        return m783a();
    }

    public C0193e() {
        this(10);
    }

    public C0193e(int i) {
        this.f473b = false;
        if (i == 0) {
            this.f474c = C0190b.f468b;
            this.f475d = C0190b.f469c;
        } else {
            int b = C0190b.m777b(i);
            this.f474c = new long[b];
            this.f475d = new Object[b];
        }
        this.f476e = 0;
    }

    public C0193e<E> m783a() {
        try {
            C0193e<E> c0193e = (C0193e) super.clone();
            try {
                c0193e.f474c = (long[]) this.f474c.clone();
                c0193e.f475d = (Object[]) this.f475d.clone();
                return c0193e;
            } catch (CloneNotSupportedException e) {
                return c0193e;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m784a(long j) {
        return m785a(j, null);
    }

    public E m785a(long j, E e) {
        int a = C0190b.m775a(this.f474c, this.f476e, j);
        return (a < 0 || this.f475d[a] == f472a) ? e : this.f475d[a];
    }

    public void m788b(long j) {
        int a = C0190b.m775a(this.f474c, this.f476e, j);
        if (a >= 0 && this.f475d[a] != f472a) {
            this.f475d[a] = f472a;
            this.f473b = true;
        }
    }

    private void m781c() {
        int i = this.f476e;
        long[] jArr = this.f474c;
        Object[] objArr = this.f475d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f472a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f473b = false;
        this.f476e = i2;
    }

    public void m789b(long j, E e) {
        int a = C0190b.m775a(this.f474c, this.f476e, j);
        if (a >= 0) {
            this.f475d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f476e || this.f475d[a] != f472a) {
            if (this.f473b && this.f476e >= this.f474c.length) {
                m781c();
                a = C0190b.m775a(this.f474c, this.f476e, j) ^ -1;
            }
            if (this.f476e >= this.f474c.length) {
                int b = C0190b.m777b(this.f476e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f474c, 0, obj, 0, this.f474c.length);
                System.arraycopy(this.f475d, 0, obj2, 0, this.f475d.length);
                this.f474c = obj;
                this.f475d = obj2;
            }
            if (this.f476e - a != 0) {
                System.arraycopy(this.f474c, a, this.f474c, a + 1, this.f476e - a);
                System.arraycopy(this.f475d, a, this.f475d, a + 1, this.f476e - a);
            }
            this.f474c[a] = j;
            this.f475d[a] = e;
            this.f476e++;
            return;
        }
        this.f474c[a] = j;
        this.f475d[a] = e;
    }

    public int m786b() {
        if (this.f473b) {
            m781c();
        }
        return this.f476e;
    }

    public long m782a(int i) {
        if (this.f473b) {
            m781c();
        }
        return this.f474c[i];
    }

    public E m787b(int i) {
        if (this.f473b) {
            m781c();
        }
        return this.f475d[i];
    }

    public String toString() {
        if (m786b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f476e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f476e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m782a(i));
            stringBuilder.append('=');
            C0193e b = m787b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
