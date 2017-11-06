package org.apache.xml.security.transforms;

import java.io.OutputStream;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.exceptions.AlgorithmAlreadyRegisteredException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.ClassLoaderUtils;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class Transform extends SignatureElementProxy {
    static Class f4181a;
    private static Log f4182b;
    private static boolean f4183c = false;
    private static HashMap f4184d = null;
    private static HashMap f4185e = new HashMap();
    private TransformSpi f4186f = null;

    static {
        Class a;
        if (f4181a == null) {
            a = m6257a("org.apache.xml.security.transforms.Transform");
            f4181a = a;
        } else {
            a = f4181a;
        }
        f4182b = LogFactory.getLog(a.getName());
    }

    public Transform(Document document, String str, NodeList nodeList) {
        int i = 0;
        super(document);
        this.k.setAttributeNS(null, "Algorithm", str);
        this.f4186f = m6263d(str);
        if (this.f4186f == null) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{str});
        }
        if (f4182b.isDebugEnabled()) {
            f4182b.debug(new StringBuffer().append("Create URI \"").append(str).append("\" class \"").append(this.f4186f.getClass()).append("\"").toString());
            f4182b.debug(new StringBuffer().append("The NodeList is ").append(nodeList).toString());
        }
        if (nodeList != null) {
            while (i < nodeList.getLength()) {
                this.k.appendChild(nodeList.item(i).cloneNode(true));
                i++;
            }
        }
    }

    public Transform(Element element, String str) {
        super(element, str);
        String attributeNS = element.getAttributeNS(null, "Algorithm");
        if (attributeNS == null || attributeNS.length() == 0) {
            throw new TransformationException("xml.WrongContent", new Object[]{"Algorithm", "Transform"});
        }
        this.f4186f = m6263d(attributeNS);
        if (this.f4186f == null) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{attributeNS});
        }
    }

    static Class m6257a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static Transform m6258a(Document document, String str) {
        return m6259a(document, str, (NodeList) null);
    }

    public static Transform m6259a(Document document, String str, NodeList nodeList) {
        return new Transform(document, str, nodeList);
    }

    public static void m6260a() {
        if (!f4183c) {
            f4184d = new HashMap(10);
            f4183c = true;
        }
    }

    public static void m6261a(String str, String str2) {
        if (m6262b(str) != null) {
            throw new AlgorithmAlreadyRegisteredException("algorithm.alreadyRegistered", new Object[]{str, m6262b(str)});
        }
        try {
            Class a;
            HashMap hashMap = f4184d;
            if (f4181a == null) {
                a = m6257a("org.apache.xml.security.transforms.Transform");
                f4181a = a;
            } else {
                a = f4181a;
            }
            hashMap.put(str, ClassLoaderUtils.m6345a(str2, a));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static Class m6262b(String str) {
        return (Class) f4184d.get(str);
    }

    private static TransformSpi m6263d(String str) {
        try {
            Object obj = f4185e.get(str);
            if (obj != null) {
                return (TransformSpi) obj;
            }
            Class cls = (Class) f4184d.get(str);
            if (cls == null) {
                return null;
            }
            TransformSpi transformSpi = (TransformSpi) cls.newInstance();
            f4185e.put(str, transformSpi);
            return transformSpi;
        } catch (Exception e) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{str}, e);
        } catch (Exception e2) {
            throw new InvalidTransformException("signature.Transform.UnknownTransform", new Object[]{str}, e2);
        }
    }

    public XMLSignatureInput m6264a(XMLSignatureInput xMLSignatureInput) {
        try {
            return this.f4186f.mo884a(xMLSignatureInput, this);
        } catch (Exception e) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{m6266b(), "ParserConfigurationException"}, e);
        } catch (Exception e2) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{m6266b(), "SAXException"}, e2);
        }
    }

    public XMLSignatureInput m6265a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream) {
        try {
            return this.f4186f.mo883a(xMLSignatureInput, outputStream, this);
        } catch (Exception e) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{m6266b(), "ParserConfigurationException"}, e);
        } catch (Exception e2) {
            throw new CanonicalizationException("signature.Transform.ErrorDuringTransform", new Object[]{m6266b(), "SAXException"}, e2);
        }
    }

    public String m6266b() {
        return this.k.getAttributeNS(null, "Algorithm");
    }

    public String mo861e() {
        return "Transform";
    }
}
