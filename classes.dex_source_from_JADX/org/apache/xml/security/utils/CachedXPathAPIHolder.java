package org.apache.xml.security.utils;

import org.apache.xpath.CachedXPathAPI;
import org.w3c.dom.Document;

public class CachedXPathAPIHolder {
    static ThreadLocal f4208a = new ThreadLocal();
    static ThreadLocal f4209b = new ThreadLocal();

    public static CachedXPathAPI m6335a() {
        CachedXPathAPI cachedXPathAPI = (CachedXPathAPI) f4208a.get();
        if (cachedXPathAPI != null) {
            return cachedXPathAPI;
        }
        cachedXPathAPI = new CachedXPathAPI();
        f4208a.set(cachedXPathAPI);
        f4209b.set(null);
        return cachedXPathAPI;
    }

    public static void m6336a(Document document) {
        if (f4209b.get() != document) {
            CachedXPathAPI cachedXPathAPI = (CachedXPathAPI) f4208a.get();
            if (cachedXPathAPI == null) {
                f4208a.set(new CachedXPathAPI());
                f4209b.set(document);
                return;
            }
            cachedXPathAPI.getXPathContext().reset();
            f4209b.set(document);
        }
    }
}
