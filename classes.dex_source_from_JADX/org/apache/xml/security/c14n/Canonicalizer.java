package org.apache.xml.security.c14n;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.xml.security.exceptions.AlgorithmAlreadyRegisteredException;
import org.w3c.dom.Node;

public class Canonicalizer {
    static boolean f4009a = false;
    static Map f4010b = null;
    protected CanonicalizerSpi f4011c = null;

    private Canonicalizer(String str) {
        try {
            this.f4011c = (CanonicalizerSpi) m6056b(str).newInstance();
            this.f4011c.f4012a = true;
        } catch (Exception e) {
            throw new InvalidCanonicalizerException("signature.Canonicalizer.UnknownCanonicalizer", new Object[]{str});
        }
    }

    public static final Canonicalizer m6053a(String str) {
        return new Canonicalizer(str);
    }

    public static void m6054a() {
        if (!f4009a) {
            f4010b = new HashMap(10);
            f4009a = true;
        }
    }

    public static void m6055a(String str, String str2) {
        if (m6056b(str) != null) {
            throw new AlgorithmAlreadyRegisteredException("algorithm.alreadyRegistered", new Object[]{str, m6056b(str)});
        }
        try {
            f4010b.put(str, Class.forName(str2));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("c14n class not found");
        }
    }

    private static Class m6056b(String str) {
        return (Class) f4010b.get(str);
    }

    public void m6057a(OutputStream outputStream) {
        this.f4011c.mo875a(outputStream);
    }

    public byte[] m6058a(Node node) {
        return this.f4011c.mo876a(node);
    }

    public byte[] m6059a(Node node, String str) {
        return this.f4011c.mo879a(node, str);
    }
}
