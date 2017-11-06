package in.org.npci.commonlibrary;

import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class C1359i {
    Cipher f3175a = Cipher.getInstance("AES/CBC/PKCS5Padding");
    byte[] f3176b = new byte[32];
    byte[] f3177c = new byte[16];

    public byte[] m5179a(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(str.getBytes("UTF-8"));
        return instance.digest();
    }

    public byte[] m5180a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    public byte[] m5181b(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public byte[] m5182b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }
}
