package org.npci.upi.security.pinactivitycomponent;

import android.util.Base64;
import java.security.Key;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class aa {
    Cipher f4318a = Cipher.getInstance("AES/CBC/PKCS7Padding");
    byte[] f4319b = new byte[32];
    byte[] f4320c = new byte[16];

    public String m6474a(String str, PublicKey publicKey) {
        String str2 = "";
        byte[] bytes = str.getBytes();
        byte[] bArr = null;
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            bArr = instance.doFinal(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(bArr, 2);
    }

    public String m6475a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return stringBuilder.toString();
    }

    public byte[] m6476a(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(str.getBytes("UTF-8"));
        return instance.digest();
    }

    public byte[] m6477a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    public byte[] m6478b(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public byte[] m6479b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }
}
