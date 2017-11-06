package org.apache.xml.security.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import org.apache.xml.security.utils.I18n;

public class XMLSecurityRuntimeException extends RuntimeException {
    protected Exception f4078a;
    protected String f4079b;

    public XMLSecurityRuntimeException() {
        super("Missing message string");
        this.f4078a = null;
        this.f4079b = null;
        this.f4078a = null;
    }

    public XMLSecurityRuntimeException(String str, Exception exception) {
        super(I18n.m6350a(str, exception));
        this.f4078a = null;
        this.f4079b = str;
        this.f4078a = exception;
    }

    public XMLSecurityRuntimeException(String str, Object[] objArr, Exception exception) {
        super(MessageFormat.format(I18n.m6353b(str), objArr));
        this.f4078a = null;
        this.f4079b = str;
        this.f4078a = exception;
    }

    public void printStackTrace() {
        synchronized (System.err) {
            super.printStackTrace(System.err);
            if (this.f4078a != null) {
                this.f4078a.printStackTrace(System.err);
            }
        }
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f4078a != null) {
            this.f4078a.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f4078a != null) {
            this.f4078a.printStackTrace(printWriter);
        }
    }

    public String toString() {
        String name = getClass().getName();
        String localizedMessage = super.getLocalizedMessage();
        if (localizedMessage != null) {
            name = new StringBuffer().append(name).append(": ").append(localizedMessage).toString();
        }
        return this.f4078a != null ? new StringBuffer().append(name).append("\nOriginal Exception was ").append(this.f4078a.toString()).toString() : name;
    }
}
