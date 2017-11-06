package org.apache.xml.security.transforms.implementations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Node;

public class TransformXSLT extends TransformSpi {
    static Log f4193b;
    static Class f4194c;
    static Class f4195d;
    private static Class f4196e;

    static {
        Class a;
        f4196e = null;
        try {
            f4196e = Class.forName("javax.xml.XMLConstants");
        } catch (Exception e) {
        }
        if (f4194c == null) {
            a = m6298a("org.apache.xml.security.transforms.implementations.TransformXSLT");
            f4194c = a;
        } else {
            a = f4194c;
        }
        f4193b = LogFactory.getLog(a.getName());
    }

    static Class m6298a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected XMLSignatureInput mo883a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        if (f4196e == null) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{"SECURE_PROCESSING_FEATURE not supported"});
        }
        try {
            Node a = XMLUtils.m6386a(transform.m5944k().getFirstChild(), "http://www.w3.org/1999/XSL/Transform", "stylesheet", 0);
            if (a == null) {
                throw new TransformationException("xml.WrongContent", new Object[]{"xslt:stylesheet", "Transform"});
            }
            Class a2;
            TransformerFactory newInstance = TransformerFactory.newInstance();
            Class cls = newInstance.getClass();
            String str = "setFeature";
            Class[] clsArr = new Class[2];
            if (f4195d == null) {
                a2 = m6298a("java.lang.String");
                f4195d = a2;
            } else {
                a2 = f4195d;
            }
            clsArr[0] = a2;
            clsArr[1] = Boolean.TYPE;
            cls.getMethod(str, clsArr).invoke(newInstance, new Object[]{"http://javax.xml.XMLConstants/feature/secure-processing", Boolean.TRUE});
            Source streamSource = new StreamSource(new ByteArrayInputStream(xMLSignatureInput.m6244e()));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            newInstance.newTransformer().transform(new DOMSource(a), new StreamResult(byteArrayOutputStream));
            Transformer newTransformer = newInstance.newTransformer(new StreamSource(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
            try {
                newTransformer.setOutputProperty("{http://xml.apache.org/xalan}line-separator", "\n");
            } catch (Exception e) {
                f4193b.warn(new StringBuffer().append("Unable to set Xalan line-separator property: ").append(e.getMessage()).toString());
            }
            if (outputStream == null) {
                OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                newTransformer.transform(streamSource, new StreamResult(byteArrayOutputStream2));
                return new XMLSignatureInput(byteArrayOutputStream2.toByteArray());
            }
            newTransformer.transform(streamSource, new StreamResult(outputStream));
            XMLSignatureInput xMLSignatureInput2 = new XMLSignatureInput((byte[]) null);
            xMLSignatureInput2.m6238b(outputStream);
            return xMLSignatureInput2;
        } catch (Exception e2) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e2.getMessage()}, e2);
        } catch (Exception e22) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e22.getMessage()}, e22);
        } catch (Exception e222) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e222.getMessage()}, e222);
        } catch (Exception e2222) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e2222.getMessage()}, e2222);
        } catch (Exception e22222) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e22222.getMessage()}, e22222);
        } catch (Exception e222222) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e222222.getMessage()}, e222222);
        }
    }

    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return mo883a(xMLSignatureInput, null, transform);
    }
}
