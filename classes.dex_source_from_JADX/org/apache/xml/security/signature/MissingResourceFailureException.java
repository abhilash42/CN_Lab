package org.apache.xml.security.signature;

public class MissingResourceFailureException extends XMLSignatureException {
    Reference f4144c = null;

    public MissingResourceFailureException(String str, Reference reference) {
        super(str);
        this.f4144c = reference;
    }

    public MissingResourceFailureException(String str, Object[] objArr, Exception exception, Reference reference) {
        super(str, objArr, exception);
        this.f4144c = reference;
    }
}
