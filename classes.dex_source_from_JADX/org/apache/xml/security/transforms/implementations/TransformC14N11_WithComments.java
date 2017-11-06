package org.apache.xml.security.transforms.implementations;

import java.io.OutputStream;
import org.apache.xml.security.c14n.implementations.Canonicalizer11_WithComments;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;

public class TransformC14N11_WithComments extends TransformSpi {
    protected XMLSignatureInput mo883a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        Canonicalizer11_WithComments canonicalizer11_WithComments = new Canonicalizer11_WithComments();
        if (outputStream != null) {
            canonicalizer11_WithComments.mo875a(outputStream);
        }
        XMLSignatureInput xMLSignatureInput2 = new XMLSignatureInput(canonicalizer11_WithComments.m6087b(xMLSignatureInput));
        if (outputStream != null) {
            xMLSignatureInput2.m6238b(outputStream);
        }
        return xMLSignatureInput2;
    }

    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return mo883a(xMLSignatureInput, null, transform);
    }
}
