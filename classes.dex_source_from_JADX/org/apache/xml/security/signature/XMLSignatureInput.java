package org.apache.xml.security.signature;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.implementations.Canonicalizer11_OmitComments;
import org.apache.xml.security.c14n.implementations.Canonicalizer20010315OmitComments;
import org.apache.xml.security.c14n.implementations.CanonicalizerBase;
import org.apache.xml.security.exceptions.XMLSecurityRuntimeException;
import org.apache.xml.security.utils.IgnoreAllErrorHandler;
import org.apache.xml.security.utils.JavaUtils;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLSignatureInput implements Cloneable {
    static Log f4164a;
    static Class f4165l;
    InputStream f4166b = null;
    Set f4167c = null;
    Node f4168d = null;
    Node f4169e = null;
    boolean f4170f = false;
    boolean f4171g = false;
    byte[] f4172h = null;
    List f4173i = new ArrayList();
    boolean f4174j = false;
    OutputStream f4175k = null;
    private String f4176m = null;
    private String f4177n = null;

    static {
        Class c;
        if (f4165l == null) {
            c = m6228c("org.apache.xml.security.signature.XMLSignatureInput");
            f4165l = c;
        } else {
            c = f4165l;
        }
        f4164a = LogFactory.getLog(c.getName());
    }

    public XMLSignatureInput(InputStream inputStream) {
        this.f4166b = inputStream;
    }

    public XMLSignatureInput(Node node) {
        this.f4168d = node;
    }

    public XMLSignatureInput(byte[] bArr) {
        this.f4172h = bArr;
    }

    static Class m6228c(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public void m6229a(OutputStream outputStream) {
        m6230a(outputStream, false);
    }

    public void m6230a(OutputStream outputStream, boolean z) {
        if (outputStream != this.f4175k) {
            if (this.f4172h != null) {
                outputStream.write(this.f4172h);
            } else if (this.f4166b == null) {
                CanonicalizerBase canonicalizer11_OmitComments = z ? new Canonicalizer11_OmitComments() : new Canonicalizer20010315OmitComments();
                canonicalizer11_OmitComments.mo875a(outputStream);
                canonicalizer11_OmitComments.m6087b(this);
            } else if (this.f4166b instanceof FileInputStream) {
                byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
                while (true) {
                    int read = this.f4166b.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                }
            } else {
                InputStream o = m6254o();
                if (this.f4172h != null) {
                    outputStream.write(this.f4172h, 0, this.f4172h.length);
                    return;
                }
                o.reset();
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read2 = o.read(bArr2);
                    if (read2 > 0) {
                        outputStream.write(bArr2, 0, read2);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void m6231a(String str) {
        this.f4176m = str;
    }

    public void m6232a(NodeFilter nodeFilter) {
        if (m6247h()) {
            try {
                m6256q();
            } catch (Exception e) {
                throw new XMLSecurityRuntimeException("signature.XMLSignatureInput.nodesetReference", e);
            }
        }
        this.f4173i.add(nodeFilter);
    }

    public void m6233a(Node node) {
        this.f4169e = node;
    }

    public void m6234a(boolean z) {
        this.f4174j = z;
    }

    public boolean m6235a() {
        return this.f4174j;
    }

    public Set m6236b() {
        return m6237b(false);
    }

    public Set m6237b(boolean z) {
        if (this.f4167c != null) {
            return this.f4167c;
        }
        if (this.f4166b == null && this.f4168d != null) {
            if (z) {
                XMLUtils.m6387a(XMLUtils.m6393b(this.f4168d));
            }
            this.f4167c = new HashSet();
            XMLUtils.m6388a(this.f4168d, this.f4167c, this.f4169e, this.f4170f);
            return this.f4167c;
        } else if (m6247h()) {
            m6256q();
            Set hashSet = new HashSet();
            XMLUtils.m6388a(this.f4168d, hashSet, null, false);
            return hashSet;
        } else {
            throw new RuntimeException("getNodeSet() called but no input data present");
        }
    }

    public void m6238b(OutputStream outputStream) {
        this.f4175k = outputStream;
    }

    public void m6239b(String str) {
        this.f4177n = str;
    }

    public InputStream m6240c() {
        return this.f4166b instanceof FileInputStream ? this.f4166b : m6254o();
    }

    public void m6241c(boolean z) {
        this.f4170f = z;
    }

    public InputStream m6242d() {
        return this.f4166b;
    }

    public void m6243d(boolean z) {
        this.f4171g = z;
    }

    public byte[] m6244e() {
        if (this.f4172h != null) {
            return this.f4172h;
        }
        InputStream o = m6254o();
        if (o != null) {
            if (this.f4172h == null) {
                o.reset();
                this.f4172h = JavaUtils.m6366a(o);
            }
            return this.f4172h;
        }
        this.f4172h = new Canonicalizer20010315OmitComments().m6087b(this);
        return this.f4172h;
    }

    public boolean m6245f() {
        return (this.f4166b == null && this.f4167c != null) || this.f4171g;
    }

    public boolean m6246g() {
        return this.f4166b == null && this.f4168d != null && this.f4167c == null && !this.f4171g;
    }

    public boolean m6247h() {
        return !(this.f4166b == null && this.f4172h == null) && this.f4167c == null && this.f4168d == null;
    }

    public boolean m6248i() {
        return this.f4175k != null;
    }

    public boolean m6249j() {
        return this.f4172h != null && this.f4167c == null && this.f4168d == null;
    }

    public String m6250k() {
        return this.f4177n;
    }

    public Node m6251l() {
        return this.f4169e;
    }

    public Node m6252m() {
        return this.f4168d;
    }

    public boolean m6253n() {
        return this.f4170f;
    }

    protected InputStream m6254o() {
        if (this.f4166b instanceof ByteArrayInputStream) {
            if (this.f4166b.markSupported()) {
                return this.f4166b;
            }
            throw new RuntimeException(new StringBuffer().append("Accepted as Markable but not truly been").append(this.f4166b).toString());
        } else if (this.f4172h != null) {
            this.f4166b = new ByteArrayInputStream(this.f4172h);
            return this.f4166b;
        } else if (this.f4166b == null) {
            return null;
        } else {
            if (this.f4166b.markSupported()) {
                f4164a.info("Mark Suported but not used as reset");
            }
            this.f4172h = JavaUtils.m6366a(this.f4166b);
            this.f4166b.close();
            this.f4166b = new ByteArrayInputStream(this.f4172h);
            return this.f4166b;
        }
    }

    public List m6255p() {
        return this.f4173i;
    }

    void m6256q() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setValidating(false);
        newInstance.setNamespaceAware(true);
        DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
        try {
            newDocumentBuilder.setErrorHandler(new IgnoreAllErrorHandler());
            this.f4168d = newDocumentBuilder.parse(m6240c());
        } catch (SAXException e) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write("<container>".getBytes());
            byteArrayOutputStream.write(m6244e());
            byteArrayOutputStream.write("</container>".getBytes());
            this.f4168d = newDocumentBuilder.parse(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).getDocumentElement().getFirstChild().getFirstChild();
        }
        this.f4166b = null;
        this.f4172h = null;
    }

    public String toString() {
        if (m6245f()) {
            return new StringBuffer().append("XMLSignatureInput/NodeSet/").append(this.f4167c.size()).append(" nodes/").append(m6250k()).toString();
        }
        if (m6246g()) {
            return new StringBuffer().append("XMLSignatureInput/Element/").append(this.f4168d).append(" exclude ").append(this.f4169e).append(" comments:").append(this.f4170f).append("/").append(m6250k()).toString();
        }
        try {
            return new StringBuffer().append("XMLSignatureInput/OctetStream/").append(m6244e().length).append(" octets/").append(m6250k()).toString();
        } catch (IOException e) {
            return new StringBuffer().append("XMLSignatureInput/OctetStream//").append(m6250k()).toString();
        } catch (CanonicalizationException e2) {
            return new StringBuffer().append("XMLSignatureInput/OctetStream//").append(m6250k()).toString();
        }
    }
}
