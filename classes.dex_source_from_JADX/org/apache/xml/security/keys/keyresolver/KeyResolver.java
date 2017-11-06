package org.apache.xml.security.keys.keyresolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.storage.StorageResolver;

public class KeyResolver {
    static Log f4096a;
    static boolean f4097b = false;
    static List f4098c = null;
    static Class f4099f;
    protected KeyResolverSpi f4100d = null;
    protected StorageResolver f4101e = null;

    class ResolverIterator implements Iterator {
        Iterator f4094a;
        int f4095b;

        public boolean hasNext() {
            return this.f4094a.hasNext();
        }

        public Object next() {
            this.f4095b++;
            KeyResolver keyResolver = (KeyResolver) this.f4094a.next();
            if (keyResolver != null) {
                return keyResolver.f4100d;
            }
            throw new RuntimeException("utils.resolver.noClass");
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove resolvers using the iterator");
        }
    }

    static {
        Class b;
        if (f4099f == null) {
            b = m6176b("org.apache.xml.security.keys.keyresolver.KeyResolver");
            f4099f = b;
        } else {
            b = f4099f;
        }
        f4096a = LogFactory.getLog(b.getName());
    }

    private KeyResolver(String str) {
        this.f4100d = (KeyResolverSpi) Class.forName(str).newInstance();
        this.f4100d.m6177a(true);
    }

    public static void m6174a() {
        if (!f4097b) {
            f4098c = new ArrayList(10);
            f4097b = true;
        }
    }

    public static void m6175a(String str) {
        f4098c.add(new KeyResolver(str));
    }

    static Class m6176b(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
