package org.apache.xml.security.transforms.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.params.XPath2FilterContainer;
import org.apache.xml.security.utils.CachedXPathAPIHolder;
import org.apache.xml.security.utils.CachedXPathFuncHereAPI;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TransformXPath2Filter extends TransformSpi {
    static Set m6293a(List list) {
        Set hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            NodeList nodeList = (NodeList) list.get(i);
            int length = nodeList.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                hashSet.add(nodeList.item(i2));
            }
        }
        return hashSet;
    }

    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        int i = 0;
        CachedXPathAPIHolder.m6336a(transform.m5944k().getOwnerDocument());
        try {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            CachedXPathFuncHereAPI cachedXPathFuncHereAPI = new CachedXPathFuncHereAPI(CachedXPathAPIHolder.m6335a());
            int length = XMLUtils.m6392a(transform.m5944k().getFirstChild(), "http://www.w3.org/2002/06/xmldsig-filter2", "XPath").length;
            if (length == 0) {
                throw new TransformationException("xml.WrongContent", new Object[]{"http://www.w3.org/2002/06/xmldsig-filter2", "XPath"});
            }
            Node b = xMLSignatureInput.m6252m() != null ? XMLUtils.m6393b(xMLSignatureInput.m6252m()) : XMLUtils.m6382a(xMLSignatureInput.m6236b());
            while (i < length) {
                XPath2FilterContainer a = XPath2FilterContainer.m6311a(XMLUtils.m6386a(transform.m5944k().getFirstChild(), "http://www.w3.org/2002/06/xmldsig-filter2", "XPath", i), xMLSignatureInput.m6250k());
                NodeList a2 = cachedXPathFuncHereAPI.m6342a(b, a.m6317f(), CachedXPathFuncHereAPI.m6338a(a.m6317f()), a.m5944k());
                if (a.m6312a()) {
                    arrayList3.add(a2);
                } else if (a.m6313b()) {
                    arrayList2.add(a2);
                } else if (a.m6314c()) {
                    arrayList.add(a2);
                }
                i++;
            }
            xMLSignatureInput.m6232a(new XPath2NodeFilter(m6293a(arrayList), m6293a(arrayList2), m6293a(arrayList3)));
            xMLSignatureInput.m6243d(true);
            return xMLSignatureInput;
        } catch (Exception e) {
            throw new TransformationException("empty", e);
        } catch (Exception e2) {
            throw new TransformationException("empty", e2);
        } catch (Exception e22) {
            throw new TransformationException("empty", e22);
        } catch (Exception e222) {
            throw new TransformationException("empty", e222);
        } catch (Exception e2222) {
            throw new TransformationException("empty", e2222);
        } catch (Exception e22222) {
            throw new TransformationException("empty", e22222);
        } catch (Exception e222222) {
            throw new TransformationException("empty", e222222);
        } catch (Exception e2222222) {
            throw new TransformationException("empty", e2222222);
        }
    }
}
