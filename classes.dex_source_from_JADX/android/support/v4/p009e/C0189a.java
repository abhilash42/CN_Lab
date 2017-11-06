package android.support.v4.p009e;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ArrayMap */
public class C0189a<K, V> extends C0188i<K, V> implements Map<K, V> {
    C0186g<K, V> f466a;

    /* compiled from: ArrayMap */
    class C01871 extends C0186g<K, V> {
        final /* synthetic */ C0189a f458a;

        C01871(C0189a c0189a) {
            this.f458a = c0189a;
        }

        protected int mo111a() {
            return this.f458a.h;
        }

        protected Object mo113a(int i, int i2) {
            return this.f458a.g[(i << 1) + i2];
        }

        protected int mo112a(Object obj) {
            return this.f458a.m763a(obj);
        }

        protected int mo117b(Object obj) {
            return this.f458a.m767b(obj);
        }

        protected Map<K, V> mo118b() {
            return this.f458a;
        }

        protected void mo116a(K k, V v) {
            this.f458a.put(k, v);
        }

        protected V mo114a(int i, V v) {
            return this.f458a.m765a(i, (Object) v);
        }

        protected void mo115a(int i) {
            this.f458a.m770d(i);
        }

        protected void mo119c() {
            this.f458a.clear();
        }
    }

    public C0189a(int i) {
        super(i);
    }

    private C0186g<K, V> m771b() {
        if (this.f466a == null) {
            this.f466a = new C01871(this);
        }
        return this.f466a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m766a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean m772a(Collection<?> collection) {
        return C0186g.m736c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m771b().m748d();
    }

    public Set<K> keySet() {
        return m771b().m749e();
    }

    public Collection<V> values() {
        return m771b().m750f();
    }
}
