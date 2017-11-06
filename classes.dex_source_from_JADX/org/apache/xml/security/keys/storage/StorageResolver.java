package org.apache.xml.security.keys.storage;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StorageResolver {
    static Log f4120a;
    static Class f4121d;
    List f4122b = null;
    Iterator f4123c = null;

    class StorageResolverIterator implements Iterator {
        Iterator f4118a;
        Iterator f4119b;

        private Iterator m6185a() {
            while (this.f4118a.hasNext()) {
                Iterator a = ((StorageResolverSpi) this.f4118a.next()).mo882a();
                if (a.hasNext()) {
                    return a;
                }
            }
            return null;
        }

        public boolean hasNext() {
            if (this.f4119b == null) {
                return false;
            }
            if (this.f4119b.hasNext()) {
                return true;
            }
            this.f4119b = m6185a();
            return this.f4119b != null;
        }

        public Object next() {
            if (hasNext()) {
                return this.f4119b.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    static {
        Class a;
        if (f4121d == null) {
            a = m6186a("org.apache.xml.security.keys.storage.StorageResolver");
            f4121d = a;
        } else {
            a = f4121d;
        }
        f4120a = LogFactory.getLog(a.getName());
    }

    static Class m6186a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
