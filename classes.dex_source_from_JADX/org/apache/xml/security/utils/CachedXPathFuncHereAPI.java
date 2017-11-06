package org.apache.xml.security.utils;

import java.lang.reflect.Method;
import javax.xml.transform.TransformerException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.dtm.DTMManager;
import org.apache.xml.security.transforms.implementations.FuncHere;
import org.apache.xml.security.transforms.implementations.FuncHereContext;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.PrefixResolverDefault;
import org.apache.xpath.CachedXPathAPI;
import org.apache.xpath.XPath;
import org.apache.xpath.XPathContext;
import org.apache.xpath.compiler.FunctionTable;
import org.apache.xpath.objects.XObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

public class CachedXPathFuncHereAPI {
    static Log f4210a;
    static FunctionTable f4211g = null;
    static Class f4212h;
    static Class f4213i;
    static Class f4214j;
    static Class f4215k;
    static Class f4216l;
    static Class f4217m;
    static Class f4218n;
    static Class f4219o;
    static Class f4220p;
    static Class f4221q;
    FuncHereContext f4222b = null;
    DTMManager f4223c = null;
    XPathContext f4224d = null;
    String f4225e = null;
    XPath f4226f = null;

    static {
        Class a;
        if (f4212h == null) {
            a = m6337a("org.apache.xml.security.utils.CachedXPathFuncHereAPI");
            f4212h = a;
        } else {
            a = f4212h;
        }
        f4210a = LogFactory.getLog(a.getName());
        m6340a();
    }

    private CachedXPathFuncHereAPI() {
    }

    public CachedXPathFuncHereAPI(CachedXPathAPI cachedXPathAPI) {
        this.f4223c = cachedXPathAPI.getXPathContext().getDTMManager();
        this.f4224d = cachedXPathAPI.getXPathContext();
    }

    static Class m6337a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static String m6338a(Node node) {
        if (node.getNodeType() != (short) 3) {
            return node.getNodeType() == (short) 2 ? ((Attr) node).getNodeValue() : node.getNodeType() == (short) 7 ? ((ProcessingInstruction) node).getNodeValue() : null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (Node firstChild = node.getParentNode().getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild.getNodeType() == (short) 3) {
                    stringBuffer.append(((Text) firstChild).getData());
                }
            }
            return stringBuffer.toString();
        }
    }

    private XPath m6339a(String str, PrefixResolver prefixResolver) {
        Class a;
        XPath xPath;
        Class[] clsArr = new Class[6];
        if (f4213i == null) {
            a = m6337a("java.lang.String");
            f4213i = a;
        } else {
            a = f4213i;
        }
        clsArr[0] = a;
        if (f4214j == null) {
            a = m6337a("javax.xml.transform.SourceLocator");
            f4214j = a;
        } else {
            a = f4214j;
        }
        clsArr[1] = a;
        if (f4215k == null) {
            a = m6337a("org.apache.xml.utils.PrefixResolver");
            f4215k = a;
        } else {
            a = f4215k;
        }
        clsArr[2] = a;
        clsArr[3] = Integer.TYPE;
        if (f4216l == null) {
            a = m6337a("javax.xml.transform.ErrorListener");
            f4216l = a;
        } else {
            a = f4216l;
        }
        clsArr[4] = a;
        if (f4217m == null) {
            a = m6337a("org.apache.xpath.compiler.FunctionTable");
            f4217m = a;
        } else {
            a = f4217m;
        }
        clsArr[5] = a;
        Object[] objArr = new Object[]{str, null, prefixResolver, new Integer(0), null, f4211g};
        try {
            if (f4218n == null) {
                a = m6337a("org.apache.xpath.XPath");
                f4218n = a;
            } else {
                a = f4218n;
            }
            xPath = (XPath) a.getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            xPath = null;
        }
        return xPath == null ? new XPath(str, null, prefixResolver, 0, null) : xPath;
    }

    private static void m6340a() {
        Class a;
        Log log;
        StringBuffer append;
        Class a2;
        Object obj = null;
        Object obj2 = 1;
        f4210a.info("Registering Here function");
        try {
            Class[] clsArr = new Class[2];
            if (f4213i == null) {
                a = m6337a("java.lang.String");
                f4213i = a;
            } else {
                a = f4213i;
            }
            clsArr[0] = a;
            if (f4219o == null) {
                a = m6337a("org.apache.xpath.Expression");
                f4219o = a;
            } else {
                a = f4219o;
            }
            clsArr[1] = a;
            if (f4217m == null) {
                a = m6337a("org.apache.xpath.compiler.FunctionTable");
                f4217m = a;
            } else {
                a = f4217m;
            }
            Method method = a.getMethod("installFunction", clsArr);
            if ((method.getModifiers() & 8) != 0) {
                method.invoke(null, new Object[]{"here", new FuncHere()});
                obj = 1;
            }
        } catch (Throwable th) {
            f4210a.debug("Error installing function using the static installFunction method", th);
        }
        if (obj == null) {
            try {
                f4211g = new FunctionTable();
                clsArr = new Class[2];
                if (f4213i == null) {
                    a = m6337a("java.lang.String");
                    f4213i = a;
                } else {
                    a = f4213i;
                }
                clsArr[0] = a;
                if (f4220p == null) {
                    a = m6337a("java.lang.Class");
                    f4220p = a;
                } else {
                    a = f4220p;
                }
                clsArr[1] = a;
                if (f4217m == null) {
                    a = m6337a("org.apache.xpath.compiler.FunctionTable");
                    f4217m = a;
                } else {
                    a = f4217m;
                }
                Method method2 = a.getMethod("installFunction", clsArr);
                Object[] objArr = new Object[2];
                objArr[0] = "here";
                if (f4221q == null) {
                    a = m6337a("org.apache.xml.security.transforms.implementations.FuncHere");
                    f4221q = a;
                } else {
                    a = f4221q;
                }
                objArr[1] = a;
                method2.invoke(f4211g, objArr);
            } catch (Throwable th2) {
                f4210a.debug("Error installing function using the static installFunction method", th2);
            }
            if (!f4210a.isDebugEnabled()) {
                if (obj2 == null) {
                    log = f4210a;
                    append = new StringBuffer().append("Registered class ");
                    if (f4221q != null) {
                        a2 = m6337a("org.apache.xml.security.transforms.implementations.FuncHere");
                        f4221q = a2;
                    } else {
                        a2 = f4221q;
                    }
                    log.debug(append.append(a2.getName()).append(" for XPath function 'here()' function in internal table").toString());
                }
                log = f4210a;
                append = new StringBuffer().append("Unable to register class ");
                if (f4221q != null) {
                    a2 = m6337a("org.apache.xml.security.transforms.implementations.FuncHere");
                    f4221q = a2;
                } else {
                    a2 = f4221q;
                }
                log.debug(append.append(a2.getName()).append(" for XPath function 'here()' function in internal table").toString());
                return;
            }
            return;
        }
        obj2 = obj;
        if (!f4210a.isDebugEnabled()) {
            return;
        }
        if (obj2 == null) {
            log = f4210a;
            append = new StringBuffer().append("Unable to register class ");
            if (f4221q != null) {
                a2 = f4221q;
            } else {
                a2 = m6337a("org.apache.xml.security.transforms.implementations.FuncHere");
                f4221q = a2;
            }
            log.debug(append.append(a2.getName()).append(" for XPath function 'here()' function in internal table").toString());
            return;
        }
        log = f4210a;
        append = new StringBuffer().append("Registered class ");
        if (f4221q != null) {
            a2 = f4221q;
        } else {
            a2 = m6337a("org.apache.xml.security.transforms.implementations.FuncHere");
            f4221q = a2;
        }
        log.debug(append.append(a2.getName()).append(" for XPath function 'here()' function in internal table").toString());
    }

    public XObject m6341a(Node node, Node node2, String str, PrefixResolver prefixResolver) {
        if (str != this.f4225e) {
            if (str.indexOf("here()") > 0) {
                this.f4224d.reset();
                this.f4223c = this.f4224d.getDTMManager();
            }
            try {
                this.f4226f = m6339a(str, prefixResolver);
                this.f4225e = str;
            } catch (TransformerException e) {
                Throwable cause = e.getCause();
                if (!(cause instanceof ClassNotFoundException) || cause.getMessage().indexOf("FuncHere") <= 0) {
                    throw e;
                }
                throw new RuntimeException(new StringBuffer().append(I18n.m6349a("endorsed.jdk1.4.0")).append(e).toString());
            }
        }
        if (this.f4222b == null) {
            this.f4222b = new FuncHereContext(node2, this.f4223c);
        }
        return this.f4226f.execute(this.f4222b, this.f4222b.getDTMHandleFromNode(node), prefixResolver);
    }

    public NodeList m6342a(Node node, Node node2, String str, Node node3) {
        return m6343b(node, node2, str, node3).nodelist();
    }

    public XObject m6343b(Node node, Node node2, String str, Node node3) {
        if (this.f4222b == null) {
            this.f4222b = new FuncHereContext(node2, this.f4223c);
        }
        if (node3.getNodeType() == (short) 9) {
            node3 = ((Document) node3).getDocumentElement();
        }
        PrefixResolver prefixResolverDefault = new PrefixResolverDefault(node3);
        if (str != this.f4225e) {
            if (str.indexOf("here()") > 0) {
                this.f4224d.reset();
                this.f4223c = this.f4224d.getDTMManager();
            }
            this.f4226f = m6339a(str, prefixResolverDefault);
            this.f4225e = str;
        }
        return this.f4226f.execute(this.f4222b, this.f4222b.getDTMHandleFromNode(node), prefixResolverDefault);
    }
}
