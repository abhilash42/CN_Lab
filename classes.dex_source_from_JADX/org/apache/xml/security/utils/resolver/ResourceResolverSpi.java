package org.apache.xml.security.utils.resolver;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.w3c.dom.Attr;

public abstract class ResourceResolverSpi {
    static Log f4275a;
    static Class f4276c;
    protected Map f4277b = null;

    static {
        Class b;
        if (f4276c == null) {
            b = m6407b("org.apache.xml.security.utils.resolver.ResourceResolverSpi");
            f4276c = b;
        } else {
            b = f4276c;
        }
        f4275a = LogFactory.getLog(b.getName());
    }

    static Class m6407b(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public String m6408a(String str) {
        return this.f4277b == null ? null : (String) this.f4277b.get(str);
    }

    public abstract XMLSignatureInput mo887a(Attr attr, String str);

    public void m6410a(Map map) {
        if (map != null) {
            if (this.f4277b == null) {
                this.f4277b = new HashMap();
            }
            this.f4277b.putAll(map);
        }
    }

    public boolean mo889a() {
        return false;
    }

    public abstract boolean mo888b(Attr attr, String str);
}
