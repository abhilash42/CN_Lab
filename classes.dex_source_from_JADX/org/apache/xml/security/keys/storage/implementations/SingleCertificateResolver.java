package org.apache.xml.security.keys.storage.implementations;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.xml.security.keys.storage.StorageResolverSpi;

public class SingleCertificateResolver extends StorageResolverSpi {
    X509Certificate f4136a;

    class InternalIterator implements Iterator {
        boolean f4134a = false;
        X509Certificate f4135b = null;

        public InternalIterator(X509Certificate x509Certificate) {
            this.f4135b = x509Certificate;
        }

        public boolean hasNext() {
            return !this.f4134a;
        }

        public Object next() {
            if (this.f4134a) {
                throw new NoSuchElementException();
            }
            this.f4134a = true;
            return this.f4135b;
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    public Iterator mo882a() {
        return new InternalIterator(this.f4136a);
    }
}
