package org.apache.xml.security.utils.resolver;

import org.apache.xml.security.exceptions.XMLSecurityException;
import org.w3c.dom.Attr;

public class ResourceResolverException extends XMLSecurityException {
    Attr f4273c = null;
    String f4274d;

    public ResourceResolverException(String str, Exception exception, Attr attr, String str2) {
        super(str, exception);
        this.f4273c = attr;
        this.f4274d = str2;
    }

    public ResourceResolverException(String str, Object[] objArr, Attr attr, String str2) {
        super(str, objArr);
        this.f4273c = attr;
        this.f4274d = str2;
    }
}
