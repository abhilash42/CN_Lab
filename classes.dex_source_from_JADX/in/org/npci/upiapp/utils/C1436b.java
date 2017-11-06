package in.org.npci.upiapp.utils;

import android.util.Base64;
import in.org.npci.upiapp.p036a.C1380a;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: CryptoUtils */
public class C1436b {
    private static final String f3564a = C1436b.class.getName();

    public static byte[] m5447a(String str) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            C1380a.m5276a(f3564a, "Error generating hash ", e);
            return null;
        }
    }

    public static byte[] m5449a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    private static byte[] m5452b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    private static String m5446a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append('0');
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString();
    }

    private static byte[] m5448a(String str, String str2) {
        return SecretKeyFactory.getInstance("PBEWITHSHA256AND128BITAES-CBC-BC").generateSecret(new PBEKeySpec(str.toCharArray(), str2.getBytes("UTF-8"), 1, 256)).getEncoded();
    }

    public static String m5445a(String str, String str2, String str3) {
        return Base64.encodeToString(C1436b.m5449a(str.getBytes("UTF-8"), C1436b.m5448a(str2, str3)), 0);
    }

    public static String m5451b(String str, String str2, String str3) {
        return new String(C1436b.m5452b(Base64.decode(str, 0), C1436b.m5448a(str2, str3)), "UTF-8");
    }

    public static String m5450b(String str) {
        return C1436b.m5446a(C1436b.m5447a(str));
    }
}
