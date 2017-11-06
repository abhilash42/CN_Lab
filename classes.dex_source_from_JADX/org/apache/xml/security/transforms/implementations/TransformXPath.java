package org.apache.xml.security.transforms.implementations;

import org.apache.xml.security.exceptions.XMLSecurityRuntimeException;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.CachedXPathAPIHolder;
import org.apache.xml.security.utils.CachedXPathFuncHereAPI;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xml.utils.PrefixResolverDefault;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class TransformXPath extends TransformSpi {

    class XPathNodeFilter implements NodeFilter {
        PrefixResolverDefault f4189a;
        CachedXPathFuncHereAPI f4190b = new CachedXPathFuncHereAPI(CachedXPathAPIHolder.m6335a());
        Node f4191c;
        String f4192d;

        XPathNodeFilter(Element element, Node node, String str) {
            this.f4191c = node;
            this.f4192d = str;
            this.f4189a = new PrefixResolverDefault(element);
        }

        public int mo885a(Node node) {
            try {
                return this.f4190b.m6341a(node, this.f4191c, this.f4192d, this.f4189a).bool() ? 1 : 0;
            } catch (Exception e) {
                throw new XMLSecurityRuntimeException("signature.Transform.node", new Object[]{node}, e);
            } catch (Exception e2) {
                throw new XMLSecurityRuntimeException("signature.Transform.nodeAndType", new Object[]{node, new Short(node.getNodeType())}, e2);
            }
        }

        public int mo886a(Node node, int i) {
            return mo885a(node);
        }
    }

    private boolean m6295a(String str) {
        return (str.indexOf("namespace") == -1 && str.indexOf("name()") == -1) ? false : true;
    }

    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        try {
            CachedXPathAPIHolder.m6336a(transform.m5944k().getOwnerDocument());
            Element a = XMLUtils.m6385a(transform.m5944k().getFirstChild(), "XPath", 0);
            if (a == null) {
                throw new TransformationException("xml.WrongContent", new Object[]{"ds:XPath", "Transform"});
            }
            Node item = a.getChildNodes().item(0);
            String a2 = CachedXPathFuncHereAPI.m6338a(item);
            xMLSignatureInput.m6234a(m6295a(a2));
            if (item == null) {
                throw new DOMException((short) 3, "Text must be in ds:Xpath");
            }
            xMLSignatureInput.m6232a(new XPathNodeFilter(a, item, a2));
            xMLSignatureInput.m6243d(true);
            return xMLSignatureInput;
        } catch (Exception e) {
            throw new TransformationException("empty", e);
        }
    }
}
