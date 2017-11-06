package in.org.npci.commonlibrary;

import in.org.npci.commonlibrary.p035a.C1350b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.xml.security.Init;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class C1355e {
    private static List f3157a;
    private C1359i f3158b;
    private C1361k f3159c;
    private C1350b f3160d;
    private String f3161e = "";

    public C1355e(String str) {
        GeneralSecurityException e;
        Init.m5937b();
        try {
            this.f3160d = new C1350b();
            if (this.f3160d.m5162a(str)) {
                System.out.println("XML Validated");
                this.f3159c = new C1361k(str);
                f3157a = this.f3159c.m5189a();
                try {
                    this.f3158b = new C1359i();
                    return;
                } catch (NoSuchAlgorithmException e2) {
                    e = e2;
                    e.printStackTrace();
                    throw new C1356f(C1357g.UNKNOWN_ERROR);
                } catch (NoSuchPaddingException e3) {
                    e = e3;
                    e.printStackTrace();
                    throw new C1356f(C1357g.UNKNOWN_ERROR);
                }
            }
            System.out.println("XML Not Validated");
            throw new C1356f(C1357g.KEYS_NOT_VALID);
        } catch (C1356f e4) {
            e4.printStackTrace();
            throw e4;
        } catch (Exception e5) {
            e5.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        }
    }

    private String m5171a(String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder(500);
        try {
            stringBuilder.append(str2).append(CLConstants.SALT_DELIMETER).append(str).append(CLConstants.SALT_DELIMETER).append(C1351a.m5166b(this.f3158b.m5180a(this.f3158b.m5179a(str3), this.f3158b.m5181b(str4)), 2));
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        }
    }

    private byte[] m5172a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = null;
        try {
            Key b = m5173b(this.f3161e);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, b);
            bArr = instance.doFinal(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bArr;
    }

    private PublicKey m5173b(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C1351a.m5164a(str.getBytes("utf-8"), 2)));
    }

    public Message m5174a(String str, String str2, String str3, String str4, String str5) {
        if (str == null || !str.isEmpty()) {
            C1360j c1360j;
            List arrayList = new ArrayList();
            for (C1360j c1360j2 : f3157a) {
                if (c1360j2.m5185b().equals(str)) {
                    arrayList.add(c1360j2);
                }
            }
            if (arrayList.size() == 0) {
                throw new C1356f(C1357g.KEY_CODE_INVALID);
            }
            c1360j2 = (C1360j) arrayList.get(new Random().nextInt(arrayList.size()));
            this.f3161e = c1360j2.m5187c();
            return new Message("", "", new Data(c1360j2.m5183a(), c1360j2.m5185b(), C1351a.m5166b(m5172a(m5171a(str2, str3, str4, str5)), 2)));
        }
        throw new C1356f(C1357g.KEY_CODE_EMPTY);
    }

    public void m5175a(String str, String str2, String str3) {
        Exception e;
        try {
            C1359i c1359i = new C1359i();
            String b = C1351a.m5166b(c1359i.m5179a(str2), 2);
            String b2 = C1351a.m5166b(c1359i.m5182b(C1351a.m5163a(str, 2), c1359i.m5181b(str3)), 2);
            if (b2 != null && !b2.equalsIgnoreCase(b)) {
                throw new C1356f(C1357g.TRUST_NOT_VALID);
            }
        } catch (InvalidKeyException e2) {
            e = e2;
            e.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            e.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        } catch (NoSuchPaddingException e4) {
            e = e4;
            e.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        } catch (IllegalBlockSizeException e5) {
            e = e5;
            e.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        } catch (BadPaddingException e6) {
            e = e6;
            e.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        } catch (UnsupportedEncodingException e7) {
            e = e7;
            e.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        } catch (InvalidAlgorithmParameterException e8) {
            e = e8;
            e.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        } catch (Exception e9) {
            e9.printStackTrace();
            throw new C1356f(C1357g.UNKNOWN_ERROR);
        }
    }
}
