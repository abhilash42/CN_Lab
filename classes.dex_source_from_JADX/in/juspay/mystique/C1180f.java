package in.juspay.mystique;

import android.content.Context;
import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class C1180f {
    private static final String f2535a = C1180f.class.getSimpleName();

    public static byte[] m4577a(Context context, String str) {
        byte[] b = C1180f.m4579b(context, str);
        if (b == null) {
            return C1180f.m4580c(context, str);
        }
        return b;
    }

    public static byte[] m4578a(String str, String str2) {
        return C1180f.m4574a(new ByteArrayOutputStream(), new FileInputStream(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str, str2))).toByteArray();
    }

    public static byte[] m4579b(Context context, String str) {
        return C1180f.m4574a(new ByteArrayOutputStream(), new FileInputStream(new File(context.getDir("juspay", 0), str))).toByteArray();
    }

    public static byte[] m4580c(Context context, String str) {
        return C1180f.m4574a(new ByteArrayOutputStream(), context.getAssets().open(str, 0)).toByteArray();
    }

    private static ByteArrayOutputStream m4574a(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) {
        byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream;
            }
        }
    }

    public static String m4575a(byte[] bArr) {
        String str = "MD5";
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr);
        byte[] digest = instance.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            str = Integer.toHexString(b & 255);
            while (str.length() < 2) {
                str = "0" + str;
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static void m4576a(Context context, String str, byte[] bArr) {
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(context.getDir("juspay", 0), str));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileOutputStream.close();
            throw th;
        }
    }
}
