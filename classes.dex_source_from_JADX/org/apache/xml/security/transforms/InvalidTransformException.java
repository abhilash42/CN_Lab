package org.apache.xml.security.transforms;

import org.apache.xml.security.exceptions.XMLSecurityException;

public class InvalidTransformException extends XMLSecurityException {
    public InvalidTransformException(String str, Object[] objArr) {
        super(str, objArr);
    }

    public InvalidTransformException(String str, Object[] objArr, Exception exception) {
        super(str, objArr, exception);
    }
}
