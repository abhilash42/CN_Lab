package org.apache.xml.security.transforms.implementations;

import java.io.OutputStream;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.implementations.Canonicalizer20010315ExclWithComments;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.XMLUtils;

public class TransformC14NExclusiveWithComments extends TransformSpi {
    protected XMLSignatureInput mo883a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        String str = null;
        try {
            if (transform.m5941c("http://www.w3.org/2001/10/xml-exc-c14n#", "InclusiveNamespaces") == 1) {
                str = new InclusiveNamespaces(XMLUtils.m6386a(transform.m5944k().getFirstChild(), "http://www.w3.org/2001/10/xml-exc-c14n#", "InclusiveNamespaces", 0), transform.m5945l()).m6306a();
            }
            Canonicalizer20010315ExclWithComments canonicalizer20010315ExclWithComments = new Canonicalizer20010315ExclWithComments();
            if (outputStream != null) {
                canonicalizer20010315ExclWithComments.mo875a(outputStream);
            }
            return new XMLSignatureInput(canonicalizer20010315ExclWithComments.m6111a(xMLSignatureInput, str));
        } catch (Exception e) {
            throw new CanonicalizationException("empty", e);
        }
    }

    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return mo883a(xMLSignatureInput, null, transform);
    }
}
