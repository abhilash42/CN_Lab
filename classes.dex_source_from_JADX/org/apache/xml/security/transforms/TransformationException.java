package org.apache.xml.security.transforms;

import org.apache.xml.security.exceptions.XMLSecurityException;

public class TransformationException extends XMLSecurityException {
    public TransformationException(String str) {
        super(str);
    }

    public TransformationException(String str, Exception exception) {
        super(str, exception);
    }

    public TransformationException(String str, Object[] objArr) {
        super(str, objArr);
    }

    public TransformationException(String str, Object[] objArr, Exception exception) {
        super(str, objArr, exception);
    }
}
