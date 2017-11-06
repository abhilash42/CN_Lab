package org.apache.xml.security.keys.storage.implementations;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.keys.storage.StorageResolverSpi;

public class CertsInFilesystemDirectoryResolver extends StorageResolverSpi {
    static Log f4126a;
    static Class f4127b;
    private List f4128c;

    class FilesystemIterator implements Iterator {
        List f4124a = null;
        int f4125b;

        public FilesystemIterator(List list) {
            this.f4124a = list;
            this.f4125b = 0;
        }

        public boolean hasNext() {
            return this.f4125b < this.f4124a.size();
        }

        public Object next() {
            List list = this.f4124a;
            int i = this.f4125b;
            this.f4125b = i + 1;
            return list.get(i);
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove keys from KeyStore");
        }
    }

    static {
        Class a;
        if (f4127b == null) {
            a = m6188a("org.apache.xml.security.keys.storage.implementations.CertsInFilesystemDirectoryResolver");
            f4127b = a;
        } else {
            a = f4127b;
        }
        f4126a = LogFactory.getLog(a.getName());
    }

    static Class m6188a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public Iterator mo882a() {
        return new FilesystemIterator(this.f4128c);
    }
}
