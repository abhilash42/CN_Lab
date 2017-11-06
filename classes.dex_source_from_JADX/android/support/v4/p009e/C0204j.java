package android.support.v4.p009e;

/* compiled from: SparseArrayCompat */
public class C0204j<E> implements Cloneable {
    private static final Object f500a = new Object();
    private boolean f501b;
    private int[] f502c;
    private Object[] f503d;
    private int f504e;

    public /* synthetic */ Object clone() {
        return m807a();
    }

    public C0204j() {
        this(10);
    }

    public C0204j(int i) {
        this.f501b = false;
        if (i == 0) {
            this.f502c = C0190b.f467a;
            this.f503d = C0190b.f469c;
        } else {
            int a = C0190b.m773a(i);
            this.f502c = new int[a];
            this.f503d = new Object[a];
        }
        this.f504e = 0;
    }

    public C0204j<E> m807a() {
        try {
            C0204j<E> c0204j = (C0204j) super.clone();
            try {
                c0204j.f502c = (int[]) this.f502c.clone();
                c0204j.f503d = (Object[]) this.f503d.clone();
                return c0204j;
            } catch (CloneNotSupportedException e) {
                return c0204j;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m808a(int i) {
        return m809a(i, null);
    }

    public E m809a(int i, E e) {
        int a = C0190b.m774a(this.f502c, this.f504e, i);
        return (a < 0 || this.f503d[a] == f500a) ? e : this.f503d[a];
    }

    public void m811b(int i) {
        int a = C0190b.m774a(this.f502c, this.f504e, i);
        if (a >= 0 && this.f503d[a] != f500a) {
            this.f503d[a] = f500a;
            this.f501b = true;
        }
    }

    public void m814c(int i) {
        m811b(i);
    }

    private void m806d() {
        int i = this.f504e;
        int[] iArr = this.f502c;
        Object[] objArr = this.f503d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f500a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f501b = false;
        this.f504e = i2;
    }

    public void m812b(int i, E e) {
        int a = C0190b.m774a(this.f502c, this.f504e, i);
        if (a >= 0) {
            this.f503d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f504e || this.f503d[a] != f500a) {
            if (this.f501b && this.f504e >= this.f502c.length) {
                m806d();
                a = C0190b.m774a(this.f502c, this.f504e, i) ^ -1;
            }
            if (this.f504e >= this.f502c.length) {
                int a2 = C0190b.m773a(this.f504e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f502c, 0, obj, 0, this.f502c.length);
                System.arraycopy(this.f503d, 0, obj2, 0, this.f503d.length);
                this.f502c = obj;
                this.f503d = obj2;
            }
            if (this.f504e - a != 0) {
                System.arraycopy(this.f502c, a, this.f502c, a + 1, this.f504e - a);
                System.arraycopy(this.f503d, a, this.f503d, a + 1, this.f504e - a);
            }
            this.f502c[a] = i;
            this.f503d[a] = e;
            this.f504e++;
            return;
        }
        this.f502c[a] = i;
        this.f503d[a] = e;
    }

    public int m810b() {
        if (this.f501b) {
            m806d();
        }
        return this.f504e;
    }

    public int m815d(int i) {
        if (this.f501b) {
            m806d();
        }
        return this.f502c[i];
    }

    public E m816e(int i) {
        if (this.f501b) {
            m806d();
        }
        return this.f503d[i];
    }

    public int m817f(int i) {
        if (this.f501b) {
            m806d();
        }
        return C0190b.m774a(this.f502c, this.f504e, i);
    }

    public void m813c() {
        int i = this.f504e;
        Object[] objArr = this.f503d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f504e = 0;
        this.f501b = false;
    }

    public String toString() {
        if (m810b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f504e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f504e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m815d(i));
            stringBuilder.append('=');
            C0204j e = m816e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
