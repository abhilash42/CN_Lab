package org.apache.xml.security.encryption;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.transforms.Transforms;

public class XMLCipher {
    static Class f4074a;
    private static Log f4075b;

    class C15821 {
    }

    class Factory {

        class AgreementMethodImpl implements AgreementMethod {
        }

        class CipherDataImpl implements CipherData {
        }

        class CipherReferenceImpl implements CipherReference {
        }

        class CipherValueImpl implements CipherValue {
        }

        abstract class EncryptedTypeImpl {
        }

        class EncryptedDataImpl extends EncryptedTypeImpl implements EncryptedData {
        }

        class EncryptedKeyImpl extends EncryptedTypeImpl implements EncryptedKey {
        }

        class EncryptionMethodImpl implements EncryptionMethod {
        }

        class EncryptionPropertiesImpl implements EncryptionProperties {
        }

        class EncryptionPropertyImpl implements EncryptionProperty {
        }

        class ReferenceListImpl implements ReferenceList {

            abstract class ReferenceImpl implements Reference {
            }

            class DataReference extends ReferenceImpl {
            }

            class KeyReference extends ReferenceImpl {
            }
        }

        class TransformsImpl extends Transforms implements Transforms {
            public String mo860d() {
                return "http://www.w3.org/2001/04/xmlenc#";
            }
        }
    }

    class Serializer {
    }

    static {
        Class a;
        if (f4074a == null) {
            a = m6147a("org.apache.xml.security.encryption.XMLCipher");
            f4074a = a;
        } else {
            a = f4074a;
        }
        f4075b = LogFactory.getLog(a.getName());
    }

    static Class m6147a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
