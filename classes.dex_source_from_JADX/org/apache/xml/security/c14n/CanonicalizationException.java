package org.apache.xml.security.c14n;

import org.apache.xml.security.exceptions.XMLSecurityException;

public class CanonicalizationException extends XMLSecurityException {
    public CanonicalizationException(String str) {
        super(str);
    }

    public CanonicalizationException(String str, Exception exception) {
        super(str, exception);
    }

    public CanonicalizationException(String str, Object[] objArr) {
        super(str, objArr);
    }

    public CanonicalizationException(String str, Object[] objArr, Exception exception) {
        super(str, objArr, exception);
    }
}
