package org.apache.xml.security.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.xml.security.Init;

public class I18n {
    static String f4233a;
    static String f4234b;
    static ResourceBundle f4235c;
    static boolean f4236d = false;
    static String f4237e = null;
    static String f4238f = null;

    private I18n() {
    }

    public static String m6349a(String str) {
        return m6353b(str);
    }

    public static String m6350a(String str, Exception exception) {
        try {
            return MessageFormat.format(f4235c.getString(str), new Object[]{exception.getMessage()});
        } catch (Throwable th) {
            return Init.m5936a() ? new StringBuffer().append("No message with ID \"").append(str).append("\" found in resource bundle \"").append("org/apache/xml/security/resource/xmlsecurity").append("\". Original Exception was a ").append(exception.getClass().getName()).append(" and message ").append(exception.getMessage()).toString() : "You must initialize the xml-security library correctly before you use it. Call the static method \"org.apache.xml.security.Init.init();\" to do that before you use any functionality from that library.";
        }
    }

    public static String m6351a(String str, Object[] objArr) {
        return m6354b(str, objArr);
    }

    public static void m6352a(String str, String str2) {
        f4233a = str;
        if (f4233a == null) {
            f4233a = Locale.getDefault().getLanguage();
        }
        f4234b = str2;
        if (f4234b == null) {
            f4234b = Locale.getDefault().getCountry();
        }
        m6355b(f4233a, f4234b);
    }

    public static String m6353b(String str) {
        try {
            return f4235c.getString(str);
        } catch (Throwable th) {
            return Init.m5936a() ? new StringBuffer().append("No message with ID \"").append(str).append("\" found in resource bundle \"").append("org/apache/xml/security/resource/xmlsecurity").append("\"").toString() : "You must initialize the xml-security library correctly before you use it. Call the static method \"org.apache.xml.security.Init.init();\" to do that before you use any functionality from that library.";
        }
    }

    public static String m6354b(String str, Object[] objArr) {
        try {
            return MessageFormat.format(f4235c.getString(str), objArr);
        } catch (Throwable th) {
            return Init.m5936a() ? new StringBuffer().append("No message with ID \"").append(str).append("\" found in resource bundle \"").append("org/apache/xml/security/resource/xmlsecurity").append("\"").toString() : "You must initialize the xml-security library correctly before you use it. Call the static method \"org.apache.xml.security.Init.init();\" to do that before you use any functionality from that library.";
        }
    }

    public static void m6355b(String str, String str2) {
        if (!f4236d || !str.equals(f4237e) || !str2.equals(f4238f)) {
            if (str == null || str2 == null || str.length() <= 0 || str2.length() <= 0) {
                f4238f = f4234b;
                f4237e = f4233a;
            } else {
                f4237e = str;
                f4238f = str2;
            }
            f4235c = ResourceBundle.getBundle("org/apache/xml/security/resource/xmlsecurity", new Locale(f4237e, f4238f));
        }
    }
}
