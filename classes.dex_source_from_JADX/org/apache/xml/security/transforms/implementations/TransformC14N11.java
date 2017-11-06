package org.apache.xml.security.transforms.implementations;

import java.io.OutputStream;
import org.apache.xml.security.c14n.implementations.Canonicalizer11_OmitComments;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;

public class TransformC14N11 extends TransformSpi {
    protected XMLSignatureInput mo883a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        Canonicalizer11_OmitComments canonicalizer11_OmitComments = new Canonicalizer11_OmitComments();
        if (outputStream != null) {
            canonicalizer11_OmitComments.mo875a(outputStream);
        }
        XMLSignatureInput xMLSignatureInput2 = new XMLSignatureInput(canonicalizer11_OmitComments.m6087b(xMLSignatureInput));
        if (outputStream != null) {
            xMLSignatureInput2.m6238b(outputStream);
        }
        return xMLSignatureInput2;
    }

    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return mo883a(xMLSignatureInput, null, transform);
    }
}
