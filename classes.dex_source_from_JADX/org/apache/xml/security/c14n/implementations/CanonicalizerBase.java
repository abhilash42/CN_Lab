package org.apache.xml.security.c14n.implementations;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.CanonicalizerSpi;
import org.apache.xml.security.c14n.helper.AttrCompare;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.UnsyncByteArrayOutputStream;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

public abstract class CanonicalizerBase extends CanonicalizerSpi {
    private static final byte[] f4020b = new byte[]{(byte) 63, (byte) 62};
    private static final byte[] f4021c = new byte[]{(byte) 60, (byte) 63};
    private static final byte[] f4022d = new byte[]{(byte) 45, (byte) 45, (byte) 62};
    private static final byte[] f4023e = new byte[]{(byte) 60, (byte) 33, (byte) 45, (byte) 45};
    private static final byte[] f4024f = new byte[]{(byte) 38, (byte) 35, (byte) 120, (byte) 65, (byte) 59};
    static final AttrCompare f4025g = new AttrCompare();
    static final byte[] f4026h = new byte[]{(byte) 61, (byte) 34};
    protected static final Attr f4027i;
    private static final byte[] f4028o = new byte[]{(byte) 38, (byte) 35, (byte) 120, (byte) 57, (byte) 59};
    private static final byte[] f4029p = new byte[]{(byte) 38, (byte) 113, (byte) 117, (byte) 111, (byte) 116, (byte) 59};
    private static final byte[] f4030q = new byte[]{(byte) 38, (byte) 35, (byte) 120, (byte) 68, (byte) 59};
    private static final byte[] f4031r = new byte[]{(byte) 38, (byte) 103, (byte) 116, (byte) 59};
    private static final byte[] f4032s = new byte[]{(byte) 38, (byte) 108, (byte) 116, (byte) 59};
    private static final byte[] f4033t = new byte[]{(byte) 60, (byte) 47};
    private static final byte[] f4034u = new byte[]{(byte) 38, (byte) 97, (byte) 109, (byte) 112, (byte) 59};
    List f4035j;
    boolean f4036k;
    Set f4037l = null;
    Node f4038m = null;
    OutputStream f4039n = new UnsyncByteArrayOutputStream();

    static {
        try {
            f4027i = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            f4027i.setValue("");
        } catch (Exception e) {
            throw new RuntimeException(new StringBuffer().append("Unable to create nullNode").append(e).toString());
        }
    }

    public CanonicalizerBase(boolean z) {
        this.f4036k = z;
    }

    static final void m6071a(String str, OutputStream outputStream) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            byte[] bArr;
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\r':
                    bArr = f4030q;
                    break;
                case '&':
                    bArr = f4034u;
                    break;
                case '<':
                    bArr = f4032s;
                    break;
                case '>':
                    bArr = f4031r;
                    break;
                default:
                    if (charAt >= '') {
                        UtfHelpper.m6135a(charAt, outputStream);
                        break;
                    } else {
                        outputStream.write(charAt);
                        continue;
                    }
            }
            outputStream.write(bArr);
        }
    }

    static final void m6072a(String str, String str2, OutputStream outputStream, Map map) {
        outputStream.write(32);
        UtfHelpper.m6137a(str, outputStream, map);
        outputStream.write(f4026h);
        int length = str2.length();
        int i = 0;
        while (i < length) {
            byte[] bArr;
            int i2 = i + 1;
            char charAt = str2.charAt(i);
            switch (charAt) {
                case '\t':
                    bArr = f4028o;
                    break;
                case '\n':
                    bArr = f4024f;
                    break;
                case '\r':
                    bArr = f4030q;
                    break;
                case '\"':
                    bArr = f4029p;
                    break;
                case '&':
                    bArr = f4034u;
                    break;
                case '<':
                    bArr = f4032s;
                    break;
                default:
                    if (charAt >= '') {
                        UtfHelpper.m6135a(charAt, outputStream);
                        i = i2;
                        break;
                    }
                    outputStream.write(charAt);
                    i = i2;
                    continue;
            }
            outputStream.write(bArr);
            i = i2;
        }
        outputStream.write(34);
    }

    static final void m6073a(Comment comment, OutputStream outputStream, int i) {
        if (i == 1) {
            outputStream.write(10);
        }
        outputStream.write(f4023e);
        String data = comment.getData();
        int length = data.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = data.charAt(i2);
            if (charAt == '\r') {
                outputStream.write(f4030q);
            } else if (charAt < '') {
                outputStream.write(charAt);
            } else {
                UtfHelpper.m6135a(charAt, outputStream);
            }
        }
        outputStream.write(f4022d);
        if (i == -1) {
            outputStream.write(10);
        }
    }

    static final void m6074a(ProcessingInstruction processingInstruction, OutputStream outputStream, int i) {
        int i2 = 0;
        if (i == 1) {
            outputStream.write(10);
        }
        outputStream.write(f4021c);
        String target = processingInstruction.getTarget();
        int length = target.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = target.charAt(i3);
            if (charAt == '\r') {
                outputStream.write(f4030q);
            } else if (charAt < '') {
                outputStream.write(charAt);
            } else {
                UtfHelpper.m6135a(charAt, outputStream);
            }
        }
        String data = processingInstruction.getData();
        int length2 = data.length();
        if (length2 > 0) {
            outputStream.write(32);
            while (i2 < length2) {
                char charAt2 = data.charAt(i2);
                if (charAt2 == '\r') {
                    outputStream.write(f4030q);
                } else {
                    UtfHelpper.m6135a(charAt2, outputStream);
                }
                i2++;
            }
        }
        outputStream.write(f4020b);
        if (i == -1) {
            outputStream.write(10);
        }
    }

    private byte[] m6075d(Node node) {
        try {
            m6086b(node, node);
            this.f4039n.close();
            byte[] toByteArray;
            if (this.f4039n instanceof ByteArrayOutputStream) {
                toByteArray = ((ByteArrayOutputStream) this.f4039n).toByteArray();
                if (this.a) {
                    ((ByteArrayOutputStream) this.f4039n).reset();
                }
                return toByteArray;
            } else if (!(this.f4039n instanceof UnsyncByteArrayOutputStream)) {
                return null;
            } else {
                toByteArray = ((UnsyncByteArrayOutputStream) this.f4039n).m6379a();
                if (this.a) {
                    ((UnsyncByteArrayOutputStream) this.f4039n).m6380b();
                }
                return toByteArray;
            }
        } catch (Exception e) {
            throw new CanonicalizationException("empty", e);
        } catch (Exception e2) {
            throw new CanonicalizationException("empty", e2);
        }
    }

    int m6076a(Node node, int i) {
        if (this.f4035j != null) {
            for (NodeFilter a : this.f4035j) {
                int a2 = a.mo886a(node, i);
                if (a2 != 1) {
                    return a2;
                }
            }
        }
        return (this.f4037l == null || this.f4037l.contains(node)) ? 1 : 0;
    }

    abstract Iterator mo877a(Element element, NameSpaceSymbTable nameSpaceSymbTable);

    public void mo875a(OutputStream outputStream) {
        this.f4039n = outputStream;
    }

    abstract void mo878a(XMLSignatureInput xMLSignatureInput);

    final void m6080a(Node node, NameSpaceSymbTable nameSpaceSymbTable, Node node2, int i) {
        if (m6084b(node) != -1) {
            OutputStream outputStream = this.f4039n;
            Node node3 = this.f4038m;
            boolean z = this.f4036k;
            Map hashMap = new HashMap();
            Node node4 = null;
            Node node5 = null;
            Node node6 = node;
            while (true) {
                switch (node6.getNodeType()) {
                    case (short) 1:
                        i = 0;
                        if (node6 != node3) {
                            Element element = (Element) node6;
                            nameSpaceSymbTable.m6117a();
                            outputStream.write(60);
                            String tagName = element.getTagName();
                            UtfHelpper.m6137a(tagName, outputStream, hashMap);
                            Iterator a = mo877a(element, nameSpaceSymbTable);
                            if (a != null) {
                                while (a.hasNext()) {
                                    Attr attr = (Attr) a.next();
                                    m6072a(attr.getNodeName(), attr.getNodeValue(), outputStream, hashMap);
                                }
                            }
                            outputStream.write(62);
                            node = node6.getFirstChild();
                            if (node == null) {
                                outputStream.write(f4033t);
                                UtfHelpper.m6136a(tagName, outputStream);
                                outputStream.write(62);
                                nameSpaceSymbTable.m6122b();
                                if (node4 == null) {
                                    node5 = node4;
                                    break;
                                }
                                node = node6.getNextSibling();
                                node5 = node4;
                                break;
                            }
                        }
                        node = node5;
                        node5 = node4;
                        break;
                        break;
                    case (short) 2:
                    case (short) 6:
                    case (short) 12:
                        throw new CanonicalizationException("empty");
                    case (short) 3:
                    case (short) 4:
                        m6071a(node6.getNodeValue(), outputStream);
                        node = node5;
                        node5 = node4;
                        break;
                    case (short) 7:
                        m6074a((ProcessingInstruction) node6, outputStream, i);
                        node = node5;
                        node5 = node4;
                        break;
                    case (short) 8:
                        if (!z) {
                            node = node5;
                            node5 = node4;
                            break;
                        }
                        m6073a((Comment) node6, outputStream, i);
                        node = node5;
                        node5 = node4;
                        break;
                    case (short) 9:
                    case (short) 11:
                        nameSpaceSymbTable.m6117a();
                        node = node6.getFirstChild();
                        node5 = node4;
                        break;
                    default:
                        node = node5;
                        node5 = node4;
                        break;
                }
                while (node == null && node5 != null) {
                    outputStream.write(f4033t);
                    UtfHelpper.m6137a(((Element) node5).getTagName(), outputStream, hashMap);
                    outputStream.write(62);
                    nameSpaceSymbTable.m6122b();
                    if (node5 != node2) {
                        node = node5.getNextSibling();
                        node4 = node5.getParentNode();
                        if (node4 == null || (short) 1 != node4.getNodeType()) {
                            i = 1;
                            node5 = null;
                        } else {
                            node5 = node4;
                        }
                    } else {
                        return;
                    }
                }
                if (node != null) {
                    node4 = node5;
                    node5 = node.getNextSibling();
                    node6 = node;
                } else {
                    return;
                }
            }
        }
    }

    public byte[] m6081a(Set set) {
        this.f4037l = set;
        return m6075d(XMLUtils.m6382a(this.f4037l));
    }

    public byte[] mo876a(Node node) {
        return m6083a(node, (Node) null);
    }

    byte[] m6083a(Node node, Node node2) {
        this.f4038m = node2;
        try {
            NameSpaceSymbTable nameSpaceSymbTable = new NameSpaceSymbTable();
            int i = -1;
            if (node != null && (short) 1 == node.getNodeType()) {
                m6090d((Element) node, nameSpaceSymbTable);
                i = 0;
            }
            m6080a(node, nameSpaceSymbTable, node, i);
            this.f4039n.close();
            byte[] toByteArray;
            if (this.f4039n instanceof ByteArrayOutputStream) {
                toByteArray = ((ByteArrayOutputStream) this.f4039n).toByteArray();
                if (this.a) {
                    ((ByteArrayOutputStream) this.f4039n).reset();
                }
                return toByteArray;
            } else if (!(this.f4039n instanceof UnsyncByteArrayOutputStream)) {
                return null;
            } else {
                toByteArray = ((UnsyncByteArrayOutputStream) this.f4039n).m6379a();
                if (this.a) {
                    ((UnsyncByteArrayOutputStream) this.f4039n).m6380b();
                }
                return toByteArray;
            }
        } catch (Exception e) {
            throw new CanonicalizationException("empty", e);
        } catch (Exception e2) {
            throw new CanonicalizationException("empty", e2);
        }
    }

    int m6084b(Node node) {
        if (this.f4035j != null) {
            for (NodeFilter a : this.f4035j) {
                int a2 = a.mo885a(node);
                if (a2 != 1) {
                    return a2;
                }
            }
        }
        return (this.f4037l == null || this.f4037l.contains(node)) ? 1 : 0;
    }

    abstract Iterator mo880b(Element element, NameSpaceSymbTable nameSpaceSymbTable);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m6086b(org.w3c.dom.Node r13, org.w3c.dom.Node r14) {
        /*
        r12 = this;
        r0 = r12.m6084b(r13);
        r1 = -1;
        if (r0 != r1) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r7 = new org.apache.xml.security.c14n.implementations.NameSpaceSymbTable;
        r7.<init>();
        if (r13 == 0) goto L_0x001c;
    L_0x000f:
        r0 = 1;
        r1 = r13.getNodeType();
        if (r0 != r1) goto L_0x001c;
    L_0x0016:
        r0 = r13;
        r0 = (org.w3c.dom.Element) r0;
        r12.m6090d(r0, r7);
    L_0x001c:
        r2 = 0;
        r1 = 0;
        r8 = r12.f4039n;
        r0 = -1;
        r9 = new java.util.HashMap;
        r9.<init>();
        r3 = r1;
        r1 = r0;
        r0 = r13;
    L_0x0029:
        r4 = r0.getNodeType();
        switch(r4) {
            case 1: goto L_0x00d7;
            case 2: goto L_0x006c;
            case 3: goto L_0x00a6;
            case 4: goto L_0x00a6;
            case 5: goto L_0x0030;
            case 6: goto L_0x006c;
            case 7: goto L_0x0097;
            case 8: goto L_0x007f;
            case 9: goto L_0x0074;
            case 10: goto L_0x0030;
            case 11: goto L_0x0074;
            case 12: goto L_0x006c;
            default: goto L_0x0030;
        };
    L_0x0030:
        r13 = r2;
        r2 = r1;
        r1 = r3;
    L_0x0033:
        if (r13 != 0) goto L_0x0164;
    L_0x0035:
        if (r1 == 0) goto L_0x0164;
    L_0x0037:
        r0 = r12.m6089c(r1);
        if (r0 == 0) goto L_0x015f;
    L_0x003d:
        r0 = f4033t;
        r8.write(r0);
        r0 = r1;
        r0 = (org.w3c.dom.Element) r0;
        r0 = r0.getTagName();
        org.apache.xml.security.c14n.implementations.UtfHelpper.m6137a(r0, r8, r9);
        r0 = 62;
        r8.write(r0);
        r7.m6122b();
    L_0x0054:
        if (r1 == r14) goto L_0x0007;
    L_0x0056:
        r13 = r1.getNextSibling();
        r3 = r1.getParentNode();
        if (r3 == 0) goto L_0x0067;
    L_0x0060:
        r0 = 1;
        r1 = r3.getNodeType();
        if (r0 == r1) goto L_0x017a;
    L_0x0067:
        r3 = 0;
        r1 = 1;
        r2 = r1;
        r1 = r3;
        goto L_0x0033;
    L_0x006c:
        r0 = new org.apache.xml.security.c14n.CanonicalizationException;
        r1 = "empty";
        r0.<init>(r1);
        throw r0;
    L_0x0074:
        r7.m6117a();
        r2 = r0.getFirstChild();
        r13 = r2;
        r2 = r1;
        r1 = r3;
        goto L_0x0033;
    L_0x007f:
        r4 = r12.f4036k;
        if (r4 == 0) goto L_0x0175;
    L_0x0083:
        r4 = r7.m6129f();
        r4 = r12.m6076a(r0, r4);
        r5 = 1;
        if (r4 != r5) goto L_0x0175;
    L_0x008e:
        r0 = (org.w3c.dom.Comment) r0;
        m6073a(r0, r8, r1);
        r13 = r2;
        r2 = r1;
        r1 = r3;
        goto L_0x0033;
    L_0x0097:
        r4 = r12.m6089c(r0);
        if (r4 == 0) goto L_0x0175;
    L_0x009d:
        r0 = (org.w3c.dom.ProcessingInstruction) r0;
        m6074a(r0, r8, r1);
        r13 = r2;
        r2 = r1;
        r1 = r3;
        goto L_0x0033;
    L_0x00a6:
        r4 = r12.m6089c(r0);
        if (r4 == 0) goto L_0x0175;
    L_0x00ac:
        r4 = r0.getNodeValue();
        m6071a(r4, r8);
        r0 = r0.getNextSibling();
    L_0x00b7:
        if (r0 == 0) goto L_0x0175;
    L_0x00b9:
        r4 = r0.getNodeType();
        r5 = 3;
        if (r4 == r5) goto L_0x00c7;
    L_0x00c0:
        r4 = r0.getNodeType();
        r5 = 4;
        if (r4 != r5) goto L_0x0175;
    L_0x00c7:
        r2 = r0.getNodeValue();
        m6071a(r2, r8);
        r2 = r0.getNextSibling();
        r0 = r0.getNextSibling();
        goto L_0x00b7;
    L_0x00d7:
        r6 = 0;
        r1 = r0;
        r1 = (org.w3c.dom.Element) r1;
        r2 = 0;
        r4 = r7.m6129f();
        r4 = r12.m6076a(r0, r4);
        r5 = -1;
        if (r4 != r5) goto L_0x00f0;
    L_0x00e7:
        r2 = r0.getNextSibling();
        r1 = r3;
        r13 = r2;
        r2 = r6;
        goto L_0x0033;
    L_0x00f0:
        r5 = 1;
        if (r4 != r5) goto L_0x0125;
    L_0x00f3:
        r4 = 1;
        r5 = r4;
    L_0x00f5:
        if (r5 == 0) goto L_0x0128;
    L_0x00f7:
        r7.m6117a();
        r2 = 60;
        r8.write(r2);
        r2 = r1.getTagName();
        org.apache.xml.security.c14n.implementations.UtfHelpper.m6137a(r2, r8, r9);
        r4 = r2;
    L_0x0107:
        r10 = r12.mo880b(r1, r7);
        if (r10 == 0) goto L_0x012d;
    L_0x010d:
        r2 = r10.hasNext();
        if (r2 == 0) goto L_0x012d;
    L_0x0113:
        r2 = r10.next();
        r2 = (org.w3c.dom.Attr) r2;
        r11 = r2.getNodeName();
        r2 = r2.getNodeValue();
        m6072a(r11, r2, r8, r9);
        goto L_0x010d;
    L_0x0125:
        r4 = 0;
        r5 = r4;
        goto L_0x00f5;
    L_0x0128:
        r7.m6123c();
        r4 = r2;
        goto L_0x0107;
    L_0x012d:
        if (r5 == 0) goto L_0x0134;
    L_0x012f:
        r2 = 62;
        r8.write(r2);
    L_0x0134:
        r2 = r0.getFirstChild();
        if (r2 != 0) goto L_0x015b;
    L_0x013a:
        if (r5 == 0) goto L_0x0157;
    L_0x013c:
        r1 = f4033t;
        r8.write(r1);
        org.apache.xml.security.c14n.implementations.UtfHelpper.m6137a(r4, r8, r9);
        r1 = 62;
        r8.write(r1);
        r7.m6122b();
    L_0x014c:
        if (r3 == 0) goto L_0x0170;
    L_0x014e:
        r2 = r0.getNextSibling();
        r1 = r3;
        r13 = r2;
        r2 = r6;
        goto L_0x0033;
    L_0x0157:
        r7.m6125d();
        goto L_0x014c;
    L_0x015b:
        r13 = r2;
        r2 = r6;
        goto L_0x0033;
    L_0x015f:
        r7.m6125d();
        goto L_0x0054;
    L_0x0164:
        if (r13 == 0) goto L_0x0007;
    L_0x0166:
        r0 = r13.getNextSibling();
        r3 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r13;
        goto L_0x0029;
    L_0x0170:
        r1 = r3;
        r13 = r2;
        r2 = r6;
        goto L_0x0033;
    L_0x0175:
        r13 = r2;
        r2 = r1;
        r1 = r3;
        goto L_0x0033;
    L_0x017a:
        r1 = r3;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.c14n.implementations.CanonicalizerBase.b(org.w3c.dom.Node, org.w3c.dom.Node):void");
    }

    public byte[] m6087b(XMLSignatureInput xMLSignatureInput) {
        try {
            if (xMLSignatureInput.m6253n()) {
                this.f4036k = false;
            }
            if (xMLSignatureInput.m6247h()) {
                return m6063a(xMLSignatureInput.m6244e());
            }
            if (xMLSignatureInput.m6246g()) {
                return m6083a(xMLSignatureInput.m6252m(), xMLSignatureInput.m6251l());
            }
            if (!xMLSignatureInput.m6245f()) {
                return null;
            }
            this.f4035j = xMLSignatureInput.m6255p();
            mo878a(xMLSignatureInput);
            return xMLSignatureInput.m6252m() != null ? m6075d(xMLSignatureInput.m6252m()) : m6081a(xMLSignatureInput.m6236b());
        } catch (Exception e) {
            throw new CanonicalizationException("empty", e);
        } catch (Exception e2) {
            throw new CanonicalizationException("empty", e2);
        } catch (Exception e22) {
            throw new CanonicalizationException("empty", e22);
        } catch (Exception e222) {
            throw new CanonicalizationException("empty", e222);
        }
    }

    void mo881c(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                Attr attr = (Attr) attributes.item(i);
                if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                    String localName = attr.getLocalName();
                    String nodeValue = attr.getNodeValue();
                    if (!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(nodeValue)) {
                        nameSpaceSymbTable.m6119a(localName, nodeValue, attr);
                    }
                }
            }
        }
    }

    boolean m6089c(Node node) {
        if (this.f4035j != null) {
            for (NodeFilter a : this.f4035j) {
                if (a.mo885a(node) != 1) {
                    return false;
                }
            }
        }
        return this.f4037l == null || this.f4037l.contains(node);
    }

    final void m6090d(Element element, NameSpaceSymbTable nameSpaceSymbTable) {
        List arrayList = new ArrayList(10);
        Node parentNode = element.getParentNode();
        if (parentNode != null && (short) 1 == parentNode.getNodeType()) {
            Element element2 = (Element) parentNode;
            while (element2 != null) {
                arrayList.add(element2);
                parentNode = element2.getParentNode();
                if (parentNode == null || (short) 1 != parentNode.getNodeType()) {
                    break;
                }
                element2 = (Element) parentNode;
            }
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                mo881c((Element) listIterator.previous(), nameSpaceSymbTable);
            }
            Attr b = nameSpaceSymbTable.m6120b("xmlns");
            if (b != null && "".equals(b.getValue())) {
                nameSpaceSymbTable.m6121b("xmlns", "", f4027i);
            }
        }
    }
}
