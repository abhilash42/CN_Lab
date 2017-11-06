package org.apache.xml.security.keys.content.x509;

import org.apache.xml.security.utils.RFC2253Parser;
import org.apache.xml.security.utils.SignatureElementProxy;

public class XMLX509SubjectName extends SignatureElementProxy implements XMLX509DataContent {
    public String m6172a() {
        return RFC2253Parser.m6368a(m5948o());
    }

    public String mo861e() {
        return "X509SubjectName";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XMLX509SubjectName)) {
            return false;
        }
        return m6172a().equals(((XMLX509SubjectName) obj).m6172a());
    }

    public int hashCode() {
        return m6172a().hashCode() + 527;
    }
}
