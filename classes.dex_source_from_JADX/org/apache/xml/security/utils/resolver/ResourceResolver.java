package org.apache.xml.security.utils.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.w3c.dom.Attr;

public class ResourceResolver {
    static Log f4267a;
    static boolean f4268b = false;
    static List f4269c = null;
    static boolean f4270d = true;
    static Class f4271f;
    protected ResourceResolverSpi f4272e = null;

    static {
        Class b;
        if (f4271f == null) {
            b = m6403b("org.apache.xml.security.utils.resolver.ResourceResolver");
            f4271f = b;
        } else {
            b = f4271f;
        }
        f4267a = LogFactory.getLog(b.getName());
    }

    private ResourceResolver(String str) {
        this.f4272e = (ResourceResolverSpi) Class.forName(str).newInstance();
    }

    public ResourceResolver(ResourceResolverSpi resourceResolverSpi) {
        this.f4272e = resourceResolverSpi;
    }

    public static final ResourceResolver m6398a(Attr attr, String str) {
        int size = f4269c.size();
        int i = 0;
        while (i < size) {
            ResourceResolver resourceResolver = (ResourceResolver) f4269c.get(i);
            try {
                ResourceResolver resourceResolver2 = (f4270d || resourceResolver.f4272e.mo889a()) ? resourceResolver : new ResourceResolver((ResourceResolverSpi) resourceResolver.f4272e.getClass().newInstance());
                if (f4267a.isDebugEnabled()) {
                    f4267a.debug(new StringBuffer().append("check resolvability by class ").append(resourceResolver.f4272e.getClass().getName()).toString());
                }
                if (resourceResolver == null || !resourceResolver2.m6404c(attr, str)) {
                    i++;
                } else {
                    if (i != 0) {
                        List list = (List) ((ArrayList) f4269c).clone();
                        list.remove(i);
                        list.add(0, resourceResolver);
                        f4269c = list;
                    }
                    return resourceResolver2;
                }
            } catch (Exception e) {
                throw new ResourceResolverException("", e, attr, str);
            } catch (Exception e2) {
                throw new ResourceResolverException("", e2, attr, str);
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = attr != null ? attr.getNodeValue() : "null";
        objArr[1] = str;
        throw new ResourceResolverException("utils.resolver.noClass", objArr, attr, str);
    }

    public static final ResourceResolver m6399a(Attr attr, String str, List list) {
        int i = 0;
        if (f4267a.isDebugEnabled()) {
            f4267a.debug(new StringBuffer().append("I was asked to create a ResourceResolver and got ").append(list == null ? 0 : list.size()).toString());
            f4267a.debug(new StringBuffer().append(" extra resolvers to my existing ").append(f4269c.size()).append(" system-wide resolvers").toString());
        }
        if (list != null) {
            int size = list.size();
            if (size > 0) {
                while (i < size) {
                    ResourceResolver resourceResolver = (ResourceResolver) list.get(i);
                    if (resourceResolver != null) {
                        String name = resourceResolver.f4272e.getClass().getName();
                        if (f4267a.isDebugEnabled()) {
                            f4267a.debug(new StringBuffer().append("check resolvability by class ").append(name).toString());
                        }
                        if (resourceResolver.m6404c(attr, str)) {
                            return resourceResolver;
                        }
                    }
                    i++;
                }
            }
        }
        return m6398a(attr, str);
    }

    public static void m6400a() {
        if (!f4268b) {
            f4269c = new ArrayList(10);
            f4268b = true;
        }
    }

    public static void m6401a(String str) {
        m6402a(str, false);
    }

    private static void m6402a(String str, boolean z) {
        try {
            ResourceResolver resourceResolver = new ResourceResolver(str);
            if (z) {
                f4269c.add(0, resourceResolver);
                f4267a.debug("registered resolver");
            } else {
                f4269c.add(resourceResolver);
            }
            if (!resourceResolver.f4272e.mo889a()) {
                f4270d = false;
            }
        } catch (Exception e) {
            f4267a.warn(new StringBuffer().append("Error loading resolver ").append(str).append(" disabling it").toString());
        } catch (NoClassDefFoundError e2) {
            f4267a.warn(new StringBuffer().append("Error loading resolver ").append(str).append(" disabling it").toString());
        }
    }

    static Class m6403b(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private boolean m6404c(Attr attr, String str) {
        return this.f4272e.mo888b(attr, str);
    }

    public void m6405a(Map map) {
        this.f4272e.m6410a(map);
    }

    public XMLSignatureInput m6406b(Attr attr, String str) {
        return this.f4272e.mo887a(attr, str);
    }
}
