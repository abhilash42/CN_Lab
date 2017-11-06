package org.apache.xml.security.signature;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.utils.Base64;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.SignerOutputStream;
import org.apache.xml.security.utils.UnsyncBufferedOutputStream;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;

public final class XMLSignature extends SignatureElementProxy {
    static Log f4157a;
    static Class f4158b;
    private SignedInfo f4159c = null;
    private KeyInfo f4160d = null;
    private boolean f4161e = false;
    private Element f4162f;
    private int f4163g = 0;

    static {
        Class a;
        if (f4158b == null) {
            a = m6223a("org.apache.xml.security.signature.XMLSignature");
            f4158b = a;
        } else {
            a = f4158b;
        }
        f4157a = LogFactory.getLog(a.getName());
    }

    public XMLSignature(Element element, String str) {
        super(element, str);
        Element a = XMLUtils.m6384a(element.getFirstChild());
        if (a == null) {
            throw new XMLSignatureException("xml.WrongContent", new Object[]{"SignedInfo", "Signature"});
        }
        this.f4159c = new SignedInfo(a, str);
        this.f4162f = XMLUtils.m6384a(XMLUtils.m6384a(element.getFirstChild()).getNextSibling());
        if (this.f4162f == null) {
            throw new XMLSignatureException("xml.WrongContent", new Object[]{"SignatureValue", "Signature"});
        }
        a = XMLUtils.m6384a(this.f4162f.getNextSibling());
        if (a != null && a.getNamespaceURI().equals("http://www.w3.org/2000/09/xmldsig#") && a.getLocalName().equals("KeyInfo")) {
            this.f4160d = new KeyInfo(a, str);
        }
        this.f4163g = 1;
    }

    static Class m6223a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public SignedInfo m6224a() {
        return this.f4159c;
    }

    public boolean m6225a(Key key) {
        boolean z = false;
        if (key == null) {
            throw new XMLSignatureException("empty", new Object[]{"Didn't get a key"});
        }
        SignatureAlgorithm c;
        try {
            SignedInfo a = m6224a();
            c = a.m6220c();
            if (f4157a.isDebugEnabled()) {
                f4157a.debug(new StringBuffer().append("SignatureMethodURI = ").append(c.m5950a()).toString());
                f4157a.debug(new StringBuffer().append("jceSigAlgorithm    = ").append(c.m5978b()).toString());
                f4157a.debug(new StringBuffer().append("jceSigProvider     = ").append(c.m5980c()).toString());
                f4157a.debug(new StringBuffer().append("PublicKey = ").append(key).toString());
            }
            byte[] bArr = null;
            c.m5975a(key);
            OutputStream unsyncBufferedOutputStream = new UnsyncBufferedOutputStream(new SignerOutputStream(c));
            a.m6217a(unsyncBufferedOutputStream);
            unsyncBufferedOutputStream.close();
            bArr = m6226b();
        } catch (IOException e) {
            c.m5983f();
        } catch (XMLSecurityException e2) {
            c.m5983f();
            throw e2;
        } catch (XMLSignatureException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new XMLSignatureException("empty", e4);
        }
        if (c.m5979b(bArr)) {
            z = a.m6219b(this.f4161e);
        } else {
            f4157a.warn("Signature verification failed.");
        }
        return z;
    }

    public byte[] m6226b() {
        try {
            return Base64.m6329a(this.f4162f);
        } catch (Exception e) {
            throw new XMLSignatureException("empty", e);
        }
    }

    public String mo861e() {
        return "Signature";
    }
}
