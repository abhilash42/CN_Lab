package android.support.v4.p009e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: MapCollections */
abstract class C0186g<K, V> {
    C0196b f455b;
    C0197c f456c;
    C0199e f457d;

    /* compiled from: MapCollections */
    final class C0195a<T> implements Iterator<T> {
        final int f485a;
        int f486b;
        int f487c;
        boolean f488d = false;
        final /* synthetic */ C0186g f489e;

        C0195a(C0186g c0186g, int i) {
            this.f489e = c0186g;
            this.f485a = i;
            this.f486b = c0186g.mo111a();
        }

        public boolean hasNext() {
            return this.f487c < this.f486b;
        }

        public T next() {
            T a = this.f489e.mo113a(this.f487c, this.f485a);
            this.f487c++;
            this.f488d = true;
            return a;
        }

        public void remove() {
            if (this.f488d) {
                this.f487c--;
                this.f486b--;
                this.f488d = false;
                this.f489e.mo115a(this.f487c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections */
    final class C0196b implements Set<Entry<K, V>> {
        final /* synthetic */ C0186g f490a;

        C0196b(C0186g c0186g) {
            this.f490a = c0186g;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m797a((Entry) obj);
        }

        public boolean m797a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f490a.mo111a();
            for (Entry entry : collection) {
                this.f490a.mo116a(entry.getKey(), entry.getValue());
            }
            return a != this.f490a.mo111a();
        }

        public void clear() {
            this.f490a.mo119c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f490a.mo112a(entry.getKey());
            if (a >= 0) {
                return C0190b.m776a(this.f490a.mo113a(a, 1), entry.getValue());
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f490a.mo111a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0198d(this.f490a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f490a.mo111a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return C0186g.m734a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f490a.mo111a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.f490a.mo113a(a, 0);
                Object a3 = this.f490a.mo113a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }
    }

    /* compiled from: MapCollections */
    final class C0197c implements Set<K> {
        final /* synthetic */ C0186g f491a;

        C0197c(C0186g c0186g) {
            this.f491a = c0186g;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f491a.mo119c();
        }

        public boolean contains(Object obj) {
            return this.f491a.mo112a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0186g.m733a(this.f491a.mo118b(), (Collection) collection);
        }

        public boolean isEmpty() {
            return this.f491a.mo111a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0195a(this.f491a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f491a.mo112a(obj);
            if (a < 0) {
                return false;
            }
            this.f491a.mo115a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0186g.m735b(this.f491a.mo118b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0186g.m736c(this.f491a.mo118b(), collection);
        }

        public int size() {
            return this.f491a.mo111a();
        }

        public Object[] toArray() {
            return this.f491a.m746b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f491a.m743a((Object[]) tArr, 0);
        }

        public boolean equals(Object obj) {
            return C0186g.m734a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f491a.mo111a() - 1; a >= 0; a--) {
                Object a2 = this.f491a.mo113a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }
    }

    /* compiled from: MapCollections */
    final class C0198d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f492a;
        int f493b;
        boolean f494c = false;
        final /* synthetic */ C0186g f495d;

        public /* synthetic */ Object next() {
            return m798a();
        }

        C0198d(C0186g c0186g) {
            this.f495d = c0186g;
            this.f492a = c0186g.mo111a() - 1;
            this.f493b = -1;
        }

        public boolean hasNext() {
            return this.f493b < this.f492a;
        }

        public Entry<K, V> m798a() {
            this.f493b++;
            this.f494c = true;
            return this;
        }

        public void remove() {
            if (this.f494c) {
                this.f495d.mo115a(this.f493b);
                this.f493b--;
                this.f492a--;
                this.f494c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f494c) {
                return this.f495d.mo113a(this.f493b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f494c) {
                return this.f495d.mo113a(this.f493b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f494c) {
                return this.f495d.mo114a(this.f493b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f494c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C0190b.m776a(entry.getKey(), this.f495d.mo113a(this.f493b, 0)) && C0190b.m776a(entry.getValue(), this.f495d.mo113a(this.f493b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f494c) {
                Object a = this.f495d.mo113a(this.f493b, 0);
                Object a2 = this.f495d.mo113a(this.f493b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: MapCollections */
    final class C0199e implements Collection<V> {
        final /* synthetic */ C0186g f496a;

        C0199e(C0186g c0186g) {
            this.f496a = c0186g;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f496a.mo119c();
        }

        public boolean contains(Object obj) {
            return this.f496a.mo117b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f496a.mo111a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0195a(this.f496a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f496a.mo117b(obj);
            if (b < 0) {
                return false;
            }
            this.f496a.mo115a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f496a.mo111a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f496a.mo113a(i, 1))) {
                    this.f496a.mo115a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f496a.mo111a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f496a.mo113a(i, 1))) {
                    this.f496a.mo115a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f496a.mo111a();
        }

        public Object[] toArray() {
            return this.f496a.m746b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f496a.m743a((Object[]) tArr, 1);
        }
    }

    protected abstract int mo111a();

    protected abstract int mo112a(Object obj);

    protected abstract Object mo113a(int i, int i2);

    protected abstract V mo114a(int i, V v);

    protected abstract void mo115a(int i);

    protected abstract void mo116a(K k, V v);

    protected abstract int mo117b(Object obj);

    protected abstract Map<K, V> mo118b();

    protected abstract void mo119c();

    C0186g() {
    }

    public static <K, V> boolean m733a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean m735b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m736c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] m746b(int i) {
        int a = mo111a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo113a(i2, i);
        }
        return objArr;
    }

    public <T> T[] m743a(T[] tArr, int i) {
        T[] tArr2;
        int a = mo111a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo113a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    public static <T> boolean m734a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Set<Entry<K, V>> m748d() {
        if (this.f455b == null) {
            this.f455b = new C0196b(this);
        }
        return this.f455b;
    }

    public Set<K> m749e() {
        if (this.f456c == null) {
            this.f456c = new C0197c(this);
        }
        return this.f456c;
    }

    public Collection<V> m750f() {
        if (this.f457d == null) {
            this.f457d = new C0199e(this);
        }
        return this.f457d;
    }
}
