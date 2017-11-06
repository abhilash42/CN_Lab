package org.apache.xml.security.transforms;

import java.io.OutputStream;
import org.apache.xml.security.signature.XMLSignatureInput;

public abstract class TransformSpi {
    protected Transform f4187a = null;

    protected XMLSignatureInput m6268a(XMLSignatureInput xMLSignatureInput) {
        throw new UnsupportedOperationException();
    }

    protected XMLSignatureInput mo883a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        return mo884a(xMLSignatureInput, transform);
    }

    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        try {
            TransformSpi transformSpi = (TransformSpi) getClass().newInstance();
            transformSpi.m6271a(transform);
            return transformSpi.m6268a(xMLSignatureInput);
        } catch (Exception e) {
            throw new TransformationException("", e);
        } catch (Exception e2) {
            throw new TransformationException("", e2);
        }
    }

    protected void m6271a(Transform transform) {
        this.f4187a = transform;
    }
}
