package org.apache.xml.security.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import org.apache.xml.security.utils.I18n;

public class XMLSecurityException extends Exception {
    protected Exception f4007a;
    protected String f4008b;

    public XMLSecurityException() {
        super("Missing message string");
        this.f4007a = null;
        this.f4008b = null;
        this.f4007a = null;
    }

    public XMLSecurityException(String str) {
        super(I18n.m6353b(str));
        this.f4007a = null;
        this.f4008b = str;
        this.f4007a = null;
    }

    public XMLSecurityException(String str, Exception exception) {
        super(I18n.m6350a(str, exception));
        this.f4007a = null;
        this.f4008b = str;
        this.f4007a = exception;
    }

    public XMLSecurityException(String str, Object[] objArr) {
        super(MessageFormat.format(I18n.m6353b(str), objArr));
        this.f4007a = null;
        this.f4008b = str;
        this.f4007a = null;
    }

    public XMLSecurityException(String str, Object[] objArr, Exception exception) {
        super(MessageFormat.format(I18n.m6353b(str), objArr));
        this.f4007a = null;
        this.f4008b = str;
        this.f4007a = exception;
    }

    public void printStackTrace() {
        synchronized (System.err) {
            super.printStackTrace(System.err);
            if (this.f4007a != null) {
                this.f4007a.printStackTrace(System.err);
            }
        }
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f4007a != null) {
            this.f4007a.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f4007a != null) {
            this.f4007a.printStackTrace(printWriter);
        }
    }

    public String toString() {
        String name = getClass().getName();
        String localizedMessage = super.getLocalizedMessage();
        if (localizedMessage != null) {
            name = new StringBuffer().append(name).append(": ").append(localizedMessage).toString();
        }
        return this.f4007a != null ? new StringBuffer().append(name).append("\nOriginal Exception was ").append(this.f4007a.toString()).toString() : name;
    }
}
