package android.support.v4.p009e;

import java.util.Map;

/* compiled from: SimpleArrayMap */
public class C0188i<K, V> {
    static Object[] f459b;
    static int f460c;
    static Object[] f461d;
    static int f462e;
    int[] f463f;
    Object[] f464g;
    int f465h;

    int m764a(Object obj, int i) {
        int i2 = this.f465h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0190b.m774a(this.f463f, i2, i);
        if (a < 0 || obj.equals(this.f464g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f463f[i3] == i) {
            if (obj.equals(this.f464g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f463f[a] == i) {
            if (obj.equals(this.f464g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int m762a() {
        int i = this.f465h;
        if (i == 0) {
            return -1;
        }
        int a = C0190b.m774a(this.f463f, i, 0);
        if (a < 0 || this.f464g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f463f[i2] == 0) {
            if (this.f464g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f463f[a] == 0) {
            if (this.f464g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m761e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0189a.class) {
                if (f461d != null) {
                    objArr = f461d;
                    this.f464g = objArr;
                    f461d = (Object[]) objArr[0];
                    this.f463f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f462e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0189a.class) {
                if (f459b != null) {
                    objArr = f459b;
                    this.f464g = objArr;
                    f459b = (Object[]) objArr[0];
                    this.f463f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f460c--;
                    return;
                }
            }
        }
        this.f463f = new int[i];
        this.f464g = new Object[(i << 1)];
    }

    private static void m760a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0189a.class) {
                if (f462e < 10) {
                    objArr[0] = f461d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f461d = objArr;
                    f462e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0189a.class) {
                if (f460c < 10) {
                    objArr[0] = f459b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f459b = objArr;
                    f460c++;
                }
            }
        }
    }

    public C0188i() {
        this.f463f = C0190b.f467a;
        this.f464g = C0190b.f469c;
        this.f465h = 0;
    }

    public C0188i(int i) {
        if (i == 0) {
            this.f463f = C0190b.f467a;
            this.f464g = C0190b.f469c;
        } else {
            m761e(i);
        }
        this.f465h = 0;
    }

    public void clear() {
        if (this.f465h != 0) {
            C0188i.m760a(this.f463f, this.f464g, this.f465h);
            this.f463f = C0190b.f467a;
            this.f464g = C0190b.f469c;
            this.f465h = 0;
        }
    }

    public void m766a(int i) {
        if (this.f463f.length < i) {
            Object obj = this.f463f;
            Object obj2 = this.f464g;
            m761e(i);
            if (this.f465h > 0) {
                System.arraycopy(obj, 0, this.f463f, 0, this.f465h);
                System.arraycopy(obj2, 0, this.f464g, 0, this.f465h << 1);
            }
            C0188i.m760a(obj, obj2, this.f465h);
        }
    }

    public boolean containsKey(Object obj) {
        return m763a(obj) >= 0;
    }

    public int m763a(Object obj) {
        return obj == null ? m762a() : m764a(obj, obj.hashCode());
    }

    int m767b(Object obj) {
        int i = 1;
        int i2 = this.f465h * 2;
        Object[] objArr = this.f464g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m767b(obj) >= 0;
    }

    public V get(Object obj) {
        int a = m763a(obj);
        return a >= 0 ? this.f464g[(a << 1) + 1] : null;
    }

    public K m768b(int i) {
        return this.f464g[i << 1];
    }

    public V m769c(int i) {
        return this.f464g[(i << 1) + 1];
    }

    public V m765a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f464g[i2];
        this.f464g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f465h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m762a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m764a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f464g[i3];
            this.f464g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f465h >= this.f463f.length) {
            if (this.f465h >= 8) {
                i2 = this.f465h + (this.f465h >> 1);
            } else if (this.f465h < 4) {
                i2 = 4;
            }
            Object obj = this.f463f;
            Object obj2 = this.f464g;
            m761e(i2);
            if (this.f463f.length > 0) {
                System.arraycopy(obj, 0, this.f463f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f464g, 0, obj2.length);
            }
            C0188i.m760a(obj, obj2, this.f465h);
        }
        if (a < this.f465h) {
            System.arraycopy(this.f463f, a, this.f463f, a + 1, this.f465h - a);
            System.arraycopy(this.f464g, a << 1, this.f464g, (a + 1) << 1, (this.f465h - a) << 1);
        }
        this.f463f[a] = i;
        this.f464g[a << 1] = k;
        this.f464g[(a << 1) + 1] = v;
        this.f465h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m763a(obj);
        if (a >= 0) {
            return m770d(a);
        }
        return null;
    }

    public V m770d(int i) {
        int i2 = 8;
        V v = this.f464g[(i << 1) + 1];
        if (this.f465h <= 1) {
            C0188i.m760a(this.f463f, this.f464g, this.f465h);
            this.f463f = C0190b.f467a;
            this.f464g = C0190b.f469c;
            this.f465h = 0;
        } else if (this.f463f.length <= 8 || this.f465h >= this.f463f.length / 3) {
            this.f465h--;
            if (i < this.f465h) {
                System.arraycopy(this.f463f, i + 1, this.f463f, i, this.f465h - i);
                System.arraycopy(this.f464g, (i + 1) << 1, this.f464g, i << 1, (this.f465h - i) << 1);
            }
            this.f464g[this.f465h << 1] = null;
            this.f464g[(this.f465h << 1) + 1] = null;
        } else {
            if (this.f465h > 8) {
                i2 = this.f465h + (this.f465h >> 1);
            }
            Object obj = this.f463f;
            Object obj2 = this.f464g;
            m761e(i2);
            this.f465h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f463f, 0, i);
                System.arraycopy(obj2, 0, this.f464g, 0, i << 1);
            }
            if (i < this.f465h) {
                System.arraycopy(obj, i + 1, this.f463f, i, this.f465h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f464g, i << 1, (this.f465h - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.f465h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f465h) {
            try {
                Object b = m768b(i);
                Object c = m769c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f463f;
        Object[] objArr = this.f464g;
        int i = this.f465h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f465h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f465h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0188i b = m768b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m769c(i);
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
