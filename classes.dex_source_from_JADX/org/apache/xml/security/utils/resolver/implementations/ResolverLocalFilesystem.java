package org.apache.xml.security.utils.resolver.implementations;

import java.io.FileInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.apache.xml.utils.URI;
import org.w3c.dom.Attr;

public class ResolverLocalFilesystem extends ResourceResolverSpi {
    static Log f4284d;
    static Class f4285e;
    private static int f4286f = "file:/".length();

    static {
        Class c;
        if (f4285e == null) {
            c = m6425c("org.apache.xml.security.utils.resolver.implementations.ResolverLocalFilesystem");
            f4285e = c;
        } else {
            c = f4285e;
        }
        f4284d = LogFactory.getLog(c.getName());
    }

    private static URI m6424a(String str, String str2) {
        return (str2 == null || "".equals(str2)) ? new URI(str) : new URI(new URI(str2), str);
    }

    static Class m6425c(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static String m6426d(String str) {
        String stringBuffer;
        String substring = str.substring(f4286f);
        if (substring.indexOf("%20") > -1) {
            int i = 0;
            StringBuffer stringBuffer2 = new StringBuffer(substring.length());
            int indexOf;
            do {
                indexOf = substring.indexOf("%20", i);
                if (indexOf == -1) {
                    stringBuffer2.append(substring.substring(i));
                    continue;
                } else {
                    stringBuffer2.append(substring.substring(i, indexOf));
                    stringBuffer2.append(' ');
                    i = indexOf + 3;
                    continue;
                }
            } while (indexOf != -1);
            stringBuffer = stringBuffer2.toString();
        } else {
            stringBuffer = substring;
        }
        return stringBuffer.charAt(1) == ':' ? stringBuffer : new StringBuffer().append("/").append(stringBuffer).toString();
    }

    public XMLSignatureInput mo887a(Attr attr, String str) {
        try {
            URI a = m6424a(attr.getNodeValue(), str);
            URI uri = new URI(a);
            uri.setFragment(null);
            XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(new FileInputStream(m6426d(uri.toString())));
            xMLSignatureInput.m6239b(a.toString());
            return xMLSignatureInput;
        } catch (Exception e) {
            throw new ResourceResolverException("generic.EmptyMessage", e, attr, str);
        }
    }

    public boolean mo889a() {
        return true;
    }

    public boolean mo888b(Attr attr, String str) {
        if (attr == null) {
            return false;
        }
        String nodeValue = attr.getNodeValue();
        if (nodeValue.equals("") || nodeValue.charAt(0) == '#' || nodeValue.startsWith("http:")) {
            return false;
        }
        try {
            if (f4284d.isDebugEnabled()) {
                f4284d.debug(new StringBuffer().append("I was asked whether I can resolve ").append(nodeValue).toString());
            }
            if (nodeValue.startsWith("file:") || str.startsWith("file:")) {
                if (f4284d.isDebugEnabled()) {
                    f4284d.debug(new StringBuffer().append("I state that I can resolve ").append(nodeValue).toString());
                }
                return true;
            }
        } catch (Exception e) {
        }
        f4284d.debug("But I can't");
        return false;
    }
}
