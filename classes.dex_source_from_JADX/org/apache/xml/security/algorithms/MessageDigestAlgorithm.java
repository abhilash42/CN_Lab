package org.apache.xml.security.algorithms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;
import org.apache.xml.security.signature.XMLSignatureException;
import org.w3c.dom.Document;

public class MessageDigestAlgorithm extends Algorithm {
    static ThreadLocal f3977b = new C15771();
    MessageDigest f3978a = null;

    class C15771 extends ThreadLocal {
        C15771() {
        }

        protected Object initialValue() {
            return new HashMap();
        }
    }

    private MessageDigestAlgorithm(Document document, MessageDigest messageDigest, String str) {
        super(document, str);
        this.f3978a = messageDigest;
    }

    public static MessageDigestAlgorithm m5957a(Document document, String str) {
        return new MessageDigestAlgorithm(document, m5959b(str), str);
    }

    public static boolean m5958a(byte[] bArr, byte[] bArr2) {
        return MessageDigest.isEqual(bArr, bArr2);
    }

    private static MessageDigest m5959b(String str) {
        MessageDigest messageDigest = (MessageDigest) ((Map) f3977b.get()).get(str);
        if (messageDigest != null) {
            return messageDigest;
        }
        String a = JCEMapper.m5953a(str);
        if (a == null) {
            throw new XMLSignatureException("algorithms.NoSuchMap", new Object[]{str});
        }
        MessageDigest instance;
        String a2 = JCEMapper.m5952a();
        if (a2 == null) {
            try {
                instance = MessageDigest.getInstance(a);
            } catch (NoSuchAlgorithmException e) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a, e.getLocalizedMessage()});
            } catch (NoSuchProviderException e2) {
                throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{a, e2.getLocalizedMessage()});
            }
        }
        instance = MessageDigest.getInstance(a, a2);
        ((Map) f3977b.get()).put(str, instance);
        return instance;
    }

    public void m5960a(byte b) {
        this.f3978a.update(b);
    }

    public void m5961a(byte[] bArr, int i, int i2) {
        this.f3978a.update(bArr, i, i2);
    }

    public byte[] m5962b() {
        return this.f3978a.digest();
    }

    public void m5963c() {
        this.f3978a.reset();
    }

    public String mo860d() {
        return "http://www.w3.org/2000/09/xmldsig#";
    }

    public String mo861e() {
        return "DigestMethod";
    }
}
