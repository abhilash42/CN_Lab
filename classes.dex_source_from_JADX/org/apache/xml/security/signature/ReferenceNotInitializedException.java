package org.apache.xml.security.signature;

public class ReferenceNotInitializedException extends XMLSignatureException {
    public ReferenceNotInitializedException(String str, Exception exception) {
        super(str, exception);
    }

    public ReferenceNotInitializedException(String str, Object[] objArr) {
        super(str, objArr);
    }
}
