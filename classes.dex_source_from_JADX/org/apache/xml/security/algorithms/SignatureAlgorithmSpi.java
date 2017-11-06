package org.apache.xml.security.algorithms;

import java.security.Key;
import org.w3c.dom.Element;

public abstract class SignatureAlgorithmSpi {
    protected abstract String mo862a();

    protected abstract void mo863a(byte b);

    protected abstract void mo864a(Key key);

    protected void mo865a(Element element) {
    }

    protected abstract void mo866a(byte[] bArr);

    protected abstract void mo867a(byte[] bArr, int i, int i2);

    protected abstract String mo868b();

    protected abstract boolean mo869b(byte[] bArr);

    public void mo870c() {
    }
}
