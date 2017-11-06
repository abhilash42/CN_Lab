package org.apache.xml.security.c14n;

import org.apache.xml.security.exceptions.XMLSecurityException;

public class InvalidCanonicalizerException extends XMLSecurityException {
    public InvalidCanonicalizerException(String str, Object[] objArr) {
        super(str, objArr);
    }
}
