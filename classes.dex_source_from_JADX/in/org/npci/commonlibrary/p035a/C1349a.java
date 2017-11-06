package in.org.npci.commonlibrary.p035a;

import java.io.StringReader;
import java.security.Key;
import java.security.PublicKey;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.security.signature.XMLSignature;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class C1349a {
    public static Document m5159a(String str) {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        return newInstance.newDocumentBuilder().parse(new InputSource(new StringReader(str)));
    }

    public static boolean m5160a(Document document, PublicKey publicKey) {
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "Signature");
        if (elementsByTagNameNS.getLength() != 0) {
            return new XMLSignature((Element) elementsByTagNameNS.item(0), "").m6225a((Key) publicKey);
        }
        throw new Exception("Signature not found");
    }
}
