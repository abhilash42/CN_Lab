package org.apache.xml.security.utils;

import java.util.Enumeration;

public final class ClassLoaderUtils {
    static Class f4227a;

    class C15851 implements Enumeration {
        C15851() {
        }

        public boolean hasMoreElements() {
            return false;
        }

        public Object nextElement() {
            return null;
        }
    }

    private ClassLoaderUtils() {
    }

    static Class m6344a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static Class m6345a(String str, Class cls) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader.loadClass(str);
            }
        } catch (ClassNotFoundException e) {
        }
        return m6346b(str, cls);
    }

    private static Class m6346b(String str, Class cls) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            try {
                Class a;
                if (f4227a == null) {
                    a = m6344a("org.apache.xml.security.utils.ClassLoaderUtils");
                    f4227a = a;
                } else {
                    a = f4227a;
                }
                if (a.getClassLoader() != null) {
                    if (f4227a == null) {
                        a = m6344a("org.apache.xml.security.utils.ClassLoaderUtils");
                        f4227a = a;
                    } else {
                        a = f4227a;
                    }
                    return a.getClassLoader().loadClass(str);
                }
            } catch (ClassNotFoundException e2) {
                if (!(cls == null || cls.getClassLoader() == null)) {
                    return cls.getClassLoader().loadClass(str);
                }
            }
            throw e;
        }
    }
}
