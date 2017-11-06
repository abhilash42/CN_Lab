package org.apache.xml.security;

import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.keys.keyresolver.KeyResolver;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.utils.ElementProxy;
import org.apache.xml.security.utils.I18n;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xml.security.utils.resolver.ResourceResolver;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Init {
    static Log f3959a;
    static Class f3960b;
    private static boolean f3961c = false;

    class C15761 implements PrivilegedAction {
        C15761() {
        }

        public Object run() {
            String property = System.getProperty("org.apache.xml.security.resource.config");
            Class cls = getClass();
            if (property == null) {
                property = "resource/config.xml";
            }
            return cls.getResourceAsStream(property);
        }
    }

    static {
        Class a;
        if (f3960b == null) {
            a = m5935a("org.apache.xml.security.Init");
            f3960b = a;
        } else {
            a = f3960b;
        }
        f3959a = LogFactory.getLog(a.getName());
    }

    static Class m5935a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static final boolean m5936a() {
        return f3961c;
    }

    public static synchronized void m5937b() {
        String attributeNS;
        synchronized (Init.class) {
            if (!f3961c) {
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                long j7 = 0;
                long j8 = 0;
                long j9 = 0;
                long j10 = 0;
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis();
                long currentTimeMillis3 = System.currentTimeMillis();
                long currentTimeMillis4 = System.currentTimeMillis();
                DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
                newInstance.setNamespaceAware(true);
                newInstance.setValidating(false);
                Document parse = newInstance.newDocumentBuilder().parse((InputStream) AccessController.doPrivileged(new C15761()));
                long currentTimeMillis5 = System.currentTimeMillis();
                long j11 = 0;
                long currentTimeMillis6 = System.currentTimeMillis();
                try {
                    KeyInfo.m6150a();
                    long currentTimeMillis7 = System.currentTimeMillis();
                    long j12 = 0;
                    long j13 = 0;
                    long j14 = 0;
                    long j15 = 0;
                    long j16 = 0;
                    Node firstChild = parse.getFirstChild();
                    while (firstChild != null && !"Configuration".equals(firstChild.getLocalName())) {
                        firstChild = firstChild.getNextSibling();
                    }
                    Node firstChild2 = firstChild.getFirstChild();
                    while (firstChild2 != null) {
                        if (firstChild2 != null && (short) 1 == firstChild2.getNodeType()) {
                            int i;
                            String localName = firstChild2.getLocalName();
                            if (localName.equals("ResourceBundles")) {
                                j11 = System.currentTimeMillis();
                                Element element = (Element) firstChild2;
                                Attr attributeNode = element.getAttributeNode("defaultLanguageCode");
                                Attr attributeNode2 = element.getAttributeNode("defaultCountryCode");
                                I18n.m6352a(attributeNode == null ? null : attributeNode.getNodeValue(), attributeNode2 == null ? null : attributeNode2.getNodeValue());
                                j = System.currentTimeMillis();
                            }
                            if (localName.equals("CanonicalizationMethods")) {
                                j2 = System.currentTimeMillis();
                                Canonicalizer.m6054a();
                                Element[] a = XMLUtils.m6392a(firstChild2.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "CanonicalizationMethod");
                                for (i = 0; i < a.length; i++) {
                                    String attributeNS2 = a[i].getAttributeNS(null, "URI");
                                    attributeNS = a[i].getAttributeNS(null, "JAVACLASS");
                                    try {
                                        Class.forName(attributeNS);
                                        if (f3959a.isDebugEnabled()) {
                                            f3959a.debug(new StringBuffer().append("Canonicalizer.register(").append(attributeNS2).append(", ").append(attributeNS).append(")").toString());
                                        }
                                        Canonicalizer.m6055a(attributeNS2, attributeNS);
                                    } catch (ClassNotFoundException e) {
                                        f3959a.fatal(I18n.m6351a("algorithm.classDoesNotExist", new Object[]{attributeNS2, attributeNS}));
                                    }
                                }
                                j3 = System.currentTimeMillis();
                            }
                            if (localName.equals("TransformAlgorithms")) {
                                j12 = System.currentTimeMillis();
                                Transform.m6260a();
                                Element[] a2 = XMLUtils.m6392a(firstChild2.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "TransformAlgorithm");
                                for (i = 0; i < a2.length; i++) {
                                    String attributeNS3 = a2[i].getAttributeNS(null, "URI");
                                    attributeNS = a2[i].getAttributeNS(null, "JAVACLASS");
                                    try {
                                        Class.forName(attributeNS);
                                        if (f3959a.isDebugEnabled()) {
                                            f3959a.debug(new StringBuffer().append("Transform.register(").append(attributeNS3).append(", ").append(attributeNS).append(")").toString());
                                        }
                                        Transform.m6261a(attributeNS3, attributeNS);
                                    } catch (ClassNotFoundException e2) {
                                        f3959a.fatal(I18n.m6351a("algorithm.classDoesNotExist", new Object[]{attributeNS3, attributeNS}));
                                    } catch (NoClassDefFoundError e3) {
                                        f3959a.warn("Not able to found dependecies for algorithm, I'm keep working.");
                                    }
                                }
                                j9 = System.currentTimeMillis();
                            }
                            if ("JCEAlgorithmMappings".equals(localName)) {
                                j13 = System.currentTimeMillis();
                                JCEMapper.m5954a((Element) firstChild2);
                                j4 = System.currentTimeMillis();
                            }
                            if (localName.equals("SignatureAlgorithms")) {
                                j14 = System.currentTimeMillis();
                                SignatureAlgorithm.m5973h();
                                Element[] a3 = XMLUtils.m6392a(firstChild2.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "SignatureAlgorithm");
                                for (i = 0; i < a3.length; i++) {
                                    String attributeNS4 = a3[i].getAttributeNS(null, "URI");
                                    attributeNS = a3[i].getAttributeNS(null, "JAVACLASS");
                                    try {
                                        Class.forName(attributeNS);
                                        if (f3959a.isDebugEnabled()) {
                                            f3959a.debug(new StringBuffer().append("SignatureAlgorithm.register(").append(attributeNS4).append(", ").append(attributeNS).append(")").toString());
                                        }
                                        SignatureAlgorithm.m5966a(attributeNS4, attributeNS);
                                    } catch (ClassNotFoundException e4) {
                                        f3959a.fatal(I18n.m6351a("algorithm.classDoesNotExist", new Object[]{attributeNS4, attributeNS}));
                                    }
                                }
                                j8 = System.currentTimeMillis();
                            }
                            if (localName.equals("ResourceResolvers")) {
                                j7 = System.currentTimeMillis();
                                ResourceResolver.m6400a();
                                Element[] a4 = XMLUtils.m6392a(firstChild2.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "Resolver");
                                for (i = 0; i < a4.length; i++) {
                                    String attributeNS5 = a4[i].getAttributeNS(null, "JAVACLASS");
                                    String attributeNS6 = a4[i].getAttributeNS(null, "DESCRIPTION");
                                    if (attributeNS6 == null || attributeNS6.length() <= 0) {
                                        if (f3959a.isDebugEnabled()) {
                                            f3959a.debug(new StringBuffer().append("Register Resolver: ").append(attributeNS5).append(": For unknown purposes").toString());
                                        }
                                    } else if (f3959a.isDebugEnabled()) {
                                        f3959a.debug(new StringBuffer().append("Register Resolver: ").append(attributeNS5).append(": ").append(attributeNS6).toString());
                                    }
                                    try {
                                        ResourceResolver.m6401a(attributeNS5);
                                    } catch (Throwable th) {
                                        f3959a.warn(new StringBuffer().append("Cannot register:").append(attributeNS5).append(" perhaps some needed jars are not installed").toString(), th);
                                    }
                                    j15 = System.currentTimeMillis();
                                }
                            }
                            if (localName.equals("KeyResolver")) {
                                j10 = System.currentTimeMillis();
                                KeyResolver.m6174a();
                                Element[] a5 = XMLUtils.m6392a(firstChild2.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "Resolver");
                                for (i = 0; i < a5.length; i++) {
                                    String attributeNS7 = a5[i].getAttributeNS(null, "JAVACLASS");
                                    attributeNS = a5[i].getAttributeNS(null, "DESCRIPTION");
                                    if (attributeNS == null || attributeNS.length() <= 0) {
                                        if (f3959a.isDebugEnabled()) {
                                            f3959a.debug(new StringBuffer().append("Register Resolver: ").append(attributeNS7).append(": For unknown purposes").toString());
                                        }
                                    } else if (f3959a.isDebugEnabled()) {
                                        f3959a.debug(new StringBuffer().append("Register Resolver: ").append(attributeNS7).append(": ").append(attributeNS).toString());
                                    }
                                    KeyResolver.m6175a(attributeNS7);
                                }
                                j5 = System.currentTimeMillis();
                            }
                            if (localName.equals("PrefixMappings")) {
                                j6 = System.currentTimeMillis();
                                if (f3959a.isDebugEnabled()) {
                                    f3959a.debug("Now I try to bind prefixes:");
                                }
                                Element[] a6 = XMLUtils.m6392a(firstChild2.getFirstChild(), "http://www.xmlsecurity.org/NS/#configuration", "PrefixMapping");
                                for (i = 0; i < a6.length; i++) {
                                    String attributeNS8 = a6[i].getAttributeNS(null, "namespace");
                                    localName = a6[i].getAttributeNS(null, "prefix");
                                    if (f3959a.isDebugEnabled()) {
                                        f3959a.debug(new StringBuffer().append("Now I try to bind ").append(localName).append(" to ").append(attributeNS8).toString());
                                    }
                                    ElementProxy.m5939d(attributeNS8, localName);
                                }
                                j16 = System.currentTimeMillis();
                            }
                        }
                        firstChild2 = firstChild2.getNextSibling();
                    }
                    long currentTimeMillis8 = System.currentTimeMillis();
                    if (f3959a.isDebugEnabled()) {
                        f3959a.debug(new StringBuffer().append("XX_init                             ").append((int) (currentTimeMillis8 - currentTimeMillis)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_prng                           ").append((int) (currentTimeMillis3 - currentTimeMillis2)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_parsing                        ").append((int) (currentTimeMillis5 - currentTimeMillis4)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_configure_i18n                 ").append((int) (j - j11)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_configure_reg_c14n             ").append((int) (j3 - j2)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_configure_reg_jcemapper        ").append((int) (j4 - j13)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_configure_reg_keyInfo          ").append((int) (currentTimeMillis7 - currentTimeMillis6)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_configure_reg_keyResolver      ").append((int) (j5 - j10)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_configure_reg_prefixes         ").append((int) (j16 - j6)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_configure_reg_resourceresolver ").append((int) (j15 - j7)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_configure_reg_sigalgos         ").append((int) (j8 - j14)).append(" ms").toString());
                        f3959a.debug(new StringBuffer().append("  XX_configure_reg_transforms       ").append((int) (j9 - j12)).append(" ms").toString());
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                    throw e5;
                } catch (Throwable e6) {
                    f3959a.fatal("Bad: ", e6);
                    e6.printStackTrace();
                }
                f3961c = true;
            }
        }
    }
}
