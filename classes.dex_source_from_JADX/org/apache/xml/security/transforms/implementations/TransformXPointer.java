package org.apache.xml.security.transforms.implementations;

import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;

public class TransformXPointer extends TransformSpi {
    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        throw new TransformationException("signature.Transform.NotYetImplemented", new Object[]{"http://www.w3.org/TR/2001/WD-xptr-20010108"});
    }
}
