package org.apache.xml.security.signature;

import org.apache.xml.security.exceptions.XMLSecurityException;

public class XMLSignatureException extends XMLSecurityException {
    public XMLSignatureException(String str) {
        super(str);
    }

    public XMLSignatureException(String str, Exception exception) {
        super(str, exception);
    }

    public XMLSignatureException(String str, Object[] objArr) {
        super(str, objArr);
    }

    public XMLSignatureException(String str, Object[] objArr, Exception exception) {
        super(str, objArr, exception);
    }
}
