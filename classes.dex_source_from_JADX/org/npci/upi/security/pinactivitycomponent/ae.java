package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class ae {
    private static ByteArrayOutputStream m6488a(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) {
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

    public static byte[] m6489a(String str, Context context) {
        try {
            return m6488a(new ByteArrayOutputStream(), context.getAssets().open("npci/" + str)).toByteArray();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        }
    }
}
