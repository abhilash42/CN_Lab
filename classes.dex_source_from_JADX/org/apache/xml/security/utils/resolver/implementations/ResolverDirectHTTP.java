package org.apache.xml.security.utils.resolver.implementations;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.Base64;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.apache.xml.utils.URI;
import org.w3c.dom.Attr;

public class ResolverDirectHTTP extends ResourceResolverSpi {
    static Log f4279d;
    static Class f4280e;
    private static final String[] f4281f = new String[]{"http.proxy.host", "http.proxy.port", "http.proxy.username", "http.proxy.password", "http.basic.username", "http.basic.password"};

    static {
        Class c;
        if (f4280e == null) {
            c = m6416c("org.apache.xml.security.utils.resolver.implementations.ResolverDirectHTTP");
            f4280e = c;
        } else {
            c = f4280e;
        }
        f4279d = LogFactory.getLog(c.getName());
    }

    private URI m6415a(String str, String str2) {
        return (str2 == null || "".equals(str2)) ? new URI(str) : new URI(new URI(str2), str);
    }

    static Class m6416c(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public XMLSignatureInput mo887a(Attr attr, String str) {
        int i = 0;
        try {
            String property;
            String property2;
            String a = m6408a(f4281f[0]);
            String a2 = m6408a(f4281f[1]);
            int i2 = (a == null || a2 == null) ? 0 : 1;
            if (i2 != 0) {
                if (f4279d.isDebugEnabled()) {
                    f4279d.debug(new StringBuffer().append("Use of HTTP proxy enabled: ").append(a).append(":").append(a2).toString());
                }
                property = System.getProperty("http.proxySet");
                property2 = System.getProperty("http.proxyHost");
                String property3 = System.getProperty("http.proxyPort");
                System.setProperty("http.proxySet", "true");
                System.setProperty("http.proxyHost", a);
                System.setProperty("http.proxyPort", a2);
                a = property;
                property = property2;
                property2 = property3;
            } else {
                property2 = null;
                property = null;
                a = null;
            }
            int i3 = (a == null || property == null || property2 == null) ? 0 : 1;
            URI a3 = m6415a(attr.getNodeValue(), str);
            URI uri = new URI(a3);
            uri.setFragment(null);
            URL url = new URL(uri.toString());
            URLConnection openConnection = url.openConnection();
            String a4 = m6408a(f4281f[2]);
            String a5 = m6408a(f4281f[3]);
            if (!(a4 == null || a5 == null)) {
                openConnection.setRequestProperty("Proxy-Authorization", Base64.m6331b(new StringBuffer().append(a4).append(":").append(a5).toString().getBytes()));
            }
            a4 = openConnection.getHeaderField("WWW-Authenticate");
            if (a4 != null && a4.startsWith("Basic")) {
                a4 = m6408a(f4281f[4]);
                a5 = m6408a(f4281f[5]);
                if (!(a4 == null || a5 == null)) {
                    openConnection = url.openConnection();
                    openConnection.setRequestProperty("Authorization", new StringBuffer().append("Basic ").append(Base64.m6331b(new StringBuffer().append(a4).append(":").append(a5).toString().getBytes())).toString());
                }
            }
            String headerField = openConnection.getHeaderField("Content-Type");
            InputStream inputStream = openConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                i += read;
            }
            f4279d.debug(new StringBuffer().append("Fetched ").append(i).append(" bytes from URI ").append(a3.toString()).toString());
            XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(byteArrayOutputStream.toByteArray());
            xMLSignatureInput.m6239b(a3.toString());
            xMLSignatureInput.m6231a(headerField);
            if (!(i2 == 0 || i3 == 0)) {
                System.setProperty("http.proxySet", a);
                System.setProperty("http.proxyHost", property);
                System.setProperty("http.proxyPort", property2);
            }
            return xMLSignatureInput;
        } catch (Exception e) {
            throw new ResourceResolverException("generic.EmptyMessage", e, attr, str);
        } catch (Exception e2) {
            throw new ResourceResolverException("generic.EmptyMessage", e2, attr, str);
        }
    }

    public boolean mo889a() {
        return true;
    }

    public boolean mo888b(Attr attr, String str) {
        if (attr == null) {
            f4279d.debug("quick fail, uri == null");
            return false;
        }
        String nodeValue = attr.getNodeValue();
        if (nodeValue.equals("") || nodeValue.charAt(0) == '#') {
            f4279d.debug("quick fail for empty URIs and local ones");
            return false;
        }
        if (f4279d.isDebugEnabled()) {
            f4279d.debug(new StringBuffer().append("I was asked whether I can resolve ").append(nodeValue).toString());
        }
        if (nodeValue.startsWith("http:") || (str != null && str.startsWith("http:"))) {
            if (f4279d.isDebugEnabled()) {
                f4279d.debug(new StringBuffer().append("I state that I can resolve ").append(nodeValue).toString());
            }
            return true;
        } else if (!f4279d.isDebugEnabled()) {
            return false;
        } else {
            f4279d.debug(new StringBuffer().append("I state that I can't resolve ").append(nodeValue).toString());
            return false;
        }
    }
}
