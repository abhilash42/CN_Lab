package org.apache.xml.security.transforms.implementations;

import java.io.BufferedInputStream;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.Base64;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class TransformBase64Decode extends TransformSpi {
    protected XMLSignatureInput mo883a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) {
        try {
            StringBuffer stringBuffer;
            XMLSignatureInput xMLSignatureInput2;
            if (xMLSignatureInput.m6246g()) {
                Node m = xMLSignatureInput.m6252m();
                if (xMLSignatureInput.m6252m().getNodeType() == (short) 3) {
                    m = m.getParentNode();
                }
                stringBuffer = new StringBuffer();
                m6274a((Element) m, stringBuffer);
                if (outputStream == null) {
                    return new XMLSignatureInput(Base64.m6328a(stringBuffer.toString()));
                }
                Base64.m6324a(stringBuffer.toString(), outputStream);
                xMLSignatureInput2 = new XMLSignatureInput((byte[]) null);
                xMLSignatureInput2.m6238b(outputStream);
                return xMLSignatureInput2;
            } else if (!xMLSignatureInput.m6247h() && !xMLSignatureInput.m6245f()) {
                Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xMLSignatureInput.m6240c()).getDocumentElement();
                stringBuffer = new StringBuffer();
                m6274a(documentElement, stringBuffer);
                return new XMLSignatureInput(Base64.m6328a(stringBuffer.toString()));
            } else if (outputStream == null) {
                return new XMLSignatureInput(Base64.m6330a(xMLSignatureInput.m6244e()));
            } else {
                if (xMLSignatureInput.m6249j() || xMLSignatureInput.m6245f()) {
                    Base64.m6325a(xMLSignatureInput.m6244e(), outputStream);
                } else {
                    Base64.m6323a(new BufferedInputStream(xMLSignatureInput.m6242d()), outputStream);
                }
                xMLSignatureInput2 = new XMLSignatureInput((byte[]) null);
                xMLSignatureInput2.m6238b(outputStream);
                return xMLSignatureInput2;
            }
        } catch (Exception e) {
            throw new TransformationException("c14n.Canonicalizer.Exception", e);
        } catch (Exception e2) {
            throw new TransformationException("SAX exception", e2);
        } catch (Exception e22) {
            throw new TransformationException("Base64Decoding", e22);
        }
    }

    protected XMLSignatureInput mo884a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return mo883a(xMLSignatureInput, null, transform);
    }

    void m6274a(Element element, StringBuffer stringBuffer) {
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            switch (firstChild.getNodeType()) {
                case (short) 1:
                    m6274a((Element) firstChild, stringBuffer);
                    break;
                case (short) 3:
                    stringBuffer.append(((Text) firstChild).getData());
                    break;
                default:
                    break;
            }
        }
    }
}
