package org.apache.xml.security.transforms.implementations;

import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class TransformEnvelopedSignature extends TransformSpi {

    class EnvelopedNodeFilter implements NodeFilter {
        Node f4188a;

        EnvelopedNodeFilter(Node node) {
            this.f4188a = node;
        }

        public int mo885a(Node node) {
            return (node == this.f4188a || XMLUtils.m6390a(this.f4188a, node)) ? -1 : 1;
        }

        public int mo886a(Node node, int i) {
            return node == this.f4188a ? -1 : 1;
        }
    }

    private static Node m6289a(Node node) {
        Object obj;
        Node node2 = node;
        while (node2 != null) {
            if (node2.getNodeType() != (short) 9) {
                Element element = (Element) node2;
                if (element.getNamespaceURI().equals("http://www.w3.org/2000/09/xmldsig#") && element.getLocalName().equals("Signature")) {
                    obj = 1;
                    break;
                }
                node2 = node2.getParentNode();
            } else {
                obj = null;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            return node2;
        }
        throw new TransformationException("transform.envelopedSignatureTransformNotInSignatureElement");
    }

    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        Node a = m6289a(transform.m5944k());
        xMLSignatureInput.m6233a(a);
        xMLSignatureInput.m6232a(new EnvelopedNodeFilter(a));
        return xMLSignatureInput;
    }
}
