package org.apache.xml.security.utils;

import java.io.IOException;
import java.io.StringReader;

public class RFC2253Parser {
    static boolean f4250a = true;
    static int f4251b = 0;

    private static int m6367a(String str, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            if (str.charAt(i) == '\"') {
                i3++;
            }
            i++;
        }
        return i3;
    }

    public static String m6368a(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            String f = m6374f(str);
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int indexOf = f.indexOf(",", i);
                if (indexOf >= 0) {
                    i = m6367a(f, i, indexOf) + i2;
                    if (!(indexOf <= 0 || f.charAt(indexOf - 1) == '\\' || i % 2 == 1)) {
                        stringBuffer.append(new StringBuffer().append(m6370b(f.substring(i3, indexOf).trim())).append(",").toString());
                        i3 = indexOf + 1;
                        i = 0;
                    }
                    i2 = i;
                    i = indexOf + 1;
                } else {
                    stringBuffer.append(m6370b(m6375g(f.substring(i3))));
                    return stringBuffer.toString();
                }
            }
        } catch (IOException e) {
            return str;
        }
    }

    static String m6369a(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i);
            if (indexOf >= 0) {
                i2 += m6367a(str, i, indexOf);
                if (!(indexOf <= 0 || str.charAt(indexOf - 1) == '\\' || i2 % 2 == 1)) {
                    stringBuffer.append(new StringBuffer().append(m6375g(str.substring(i3, indexOf))).append(str3).toString());
                    i3 = indexOf + 1;
                    i2 = 0;
                }
                i = indexOf + 1;
            } else {
                stringBuffer.append(m6375g(str.substring(i3)));
                return stringBuffer.toString();
            }
        }
    }

    static String m6370b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int indexOf = str.indexOf("+", i);
            if (indexOf >= 0) {
                i2 += m6367a(str, i, indexOf);
                if (!(indexOf <= 0 || str.charAt(indexOf - 1) == '\\' || i2 % 2 == 1)) {
                    stringBuffer.append(new StringBuffer().append(m6371c(m6375g(str.substring(i3, indexOf)))).append("+").toString());
                    i3 = indexOf + 1;
                    i2 = 0;
                }
                i = indexOf + 1;
            } else {
                stringBuffer.append(m6371c(m6375g(str.substring(i3))));
                return stringBuffer.toString();
            }
        }
    }

    static String m6371c(String str) {
        int indexOf = str.indexOf("=");
        if (indexOf == -1) {
            return str;
        }
        if (indexOf > 0 && str.charAt(indexOf - 1) == '\\') {
            return str;
        }
        String d = m6372d(str.substring(0, indexOf));
        String e = (d.charAt(0) < '0' || d.charAt(0) > '9') ? m6373e(str.substring(indexOf + 1)) : str.substring(indexOf + 1);
        return new StringBuffer().append(d).append("=").append(e).toString();
    }

    static String m6372d(String str) {
        String trim = str.toUpperCase().trim();
        return trim.startsWith("OID") ? trim.substring(3) : trim;
    }

    static String m6373e(String str) {
        String g = m6375g(str);
        if (g.startsWith("\"")) {
            StringBuffer stringBuffer = new StringBuffer();
            StringReader stringReader = new StringReader(g.substring(1, g.length() - 1));
            while (true) {
                int read = stringReader.read();
                if (read <= -1) {
                    break;
                }
                char c = (char) read;
                if (c == ',' || c == '=' || c == '+' || c == '<' || c == '>' || c == '#' || c == ';') {
                    stringBuffer.append('\\');
                }
                stringBuffer.append(c);
            }
            g = m6375g(stringBuffer.toString());
        }
        return f4250a ? g.startsWith("#") ? new StringBuffer().append('\\').append(g).toString() : g : g.startsWith("\\#") ? g.substring(1) : g;
    }

    static String m6374f(String str) {
        return m6369a(str, ";", ",");
    }

    static String m6375g(String str) {
        String trim = str.trim();
        int indexOf = str.indexOf(trim) + trim.length();
        return (str.length() <= indexOf || !trim.endsWith("\\") || trim.endsWith("\\\\") || str.charAt(indexOf) != ' ') ? trim : new StringBuffer().append(trim).append(" ").toString();
    }
}
