package org.apache.xml.security.c14n;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public abstract class CanonicalizerSpi {
    protected boolean f4012a = false;

    public abstract void mo875a(OutputStream outputStream);

    public abstract byte[] mo876a(Node node);

    public abstract byte[] mo879a(Node node, String str);

    public byte[] m6063a(byte[] bArr) {
        InputSource inputSource = new InputSource(new ByteArrayInputStream(bArr));
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        return mo876a(newInstance.newDocumentBuilder().parse(inputSource));
    }
}
