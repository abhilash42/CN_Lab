package org.apache.xml.security.keys.storage.implementations;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.xml.security.keys.storage.StorageResolverSpi;

public class KeyStoreResolver extends StorageResolverSpi {
    KeyStore f4133a;

    class C15831 implements Enumeration {
        private final KeyStoreIterator f4129a;

        C15831(KeyStoreIterator keyStoreIterator) {
            this.f4129a = keyStoreIterator;
        }

        public boolean hasMoreElements() {
            return false;
        }

        public Object nextElement() {
            return null;
        }
    }

    class KeyStoreIterator implements Iterator {
        KeyStore f4130a = null;
        Enumeration f4131b = null;
        Certificate f4132c = null;

        public KeyStoreIterator(KeyStore keyStore) {
            try {
                this.f4130a = keyStore;
                this.f4131b = this.f4130a.aliases();
            } catch (KeyStoreException e) {
                this.f4131b = new C15831(this);
            }
        }

        private Certificate m6190a() {
            while (this.f4131b.hasMoreElements()) {
                try {
                    Certificate certificate = this.f4130a.getCertificate((String) this.f4131b.nextElement());
                    if (certificate != null) {
                        return certificate;
                    }
                } catch (KeyStoreException e) {
                    return null;
                }
            }
            return null;
        }

        public boolean hasNext() {
            if (this.f4132c == null) {
                this.f4132c = m6190a();
            }
            return this.f4132c != null;
        }

        public Object next() {
            if (this.f4132c == null) {
                this.f4132c = m6190a();
                if (this.f4132c == null) {
                    throw new NoSuchElementException();
                }
            }
            Certificate certificate = this.f4132c;
            this.f4132c = null;
            return certificate;
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    public Iterator mo882a() {
        return new KeyStoreIterator(this.f4133a);
    }
}
