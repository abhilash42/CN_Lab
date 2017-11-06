package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

import in.juspay.widget.qrscanner.com.google.zxing.C1283d;
import in.juspay.widget.qrscanner.com.google.zxing.ChecksumException;
import in.juspay.widget.qrscanner.com.google.zxing.FormatException;
import in.juspay.widget.qrscanner.com.google.zxing.ReaderException;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;
import in.juspay.widget.qrscanner.com.google.zxing.common.C1271e;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.C1279a;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.C1281c;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class C1236e {
    private final C1281c f2716a = new C1281c(C1279a.f2869e);

    public C1271e m4699a(C1268b c1268b, Map<C1283d, ?> map) {
        C1271e a;
        ChecksumException checksumException;
        FormatException e;
        ReaderException readerException = null;
        C1224a c1224a = new C1224a(c1268b);
        try {
            a = m4697a(c1224a, (Map) map);
        } catch (FormatException e2) {
            FormatException formatException = e2;
            checksumException = readerException;
            try {
                c1224a.m4674d();
                c1224a.m4671a(true);
                c1224a.m4672b();
                c1224a.m4670a();
                c1224a.m4675e();
                a = m4697a(c1224a, (Map) map);
                a.m4877a(new C1240i(true));
                return a;
            } catch (FormatException e3) {
                e = e3;
                if (formatException != null) {
                    throw formatException;
                } else if (checksumException == null) {
                    throw checksumException;
                } else {
                    throw e;
                }
            } catch (ChecksumException e4) {
                e = e4;
                if (formatException != null) {
                    throw formatException;
                } else if (checksumException == null) {
                    throw e;
                } else {
                    throw checksumException;
                }
            }
        } catch (ChecksumException e5) {
            checksumException = e5;
            ReaderException readerException2 = readerException;
            c1224a.m4674d();
            c1224a.m4671a(true);
            c1224a.m4672b();
            c1224a.m4670a();
            c1224a.m4675e();
            a = m4697a(c1224a, (Map) map);
            a.m4877a(new C1240i(true));
            return a;
        }
        return a;
    }

    private C1271e m4697a(C1224a c1224a, Map<C1283d, ?> map) {
        C1243j b = c1224a.m4672b();
        C1237f a = c1224a.m4670a().m4705a();
        C1225b[] a2 = C1225b.m4676a(c1224a.m4673c(), b, a);
        int i = 0;
        for (C1225b a3 : a2) {
            i += a3.m4677a();
        }
        byte[] bArr = new byte[i];
        int length = a2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            C1225b c1225b = a2[i2];
            byte[] b2 = c1225b.m4678b();
            int a4 = c1225b.m4677a();
            m4698a(b2, a4);
            i = i3;
            i3 = 0;
            while (i3 < a4) {
                int i4 = i + 1;
                bArr[i] = b2[i3];
                i3++;
                i = i4;
            }
            i2++;
            i3 = i;
        }
        return C1235d.m4691a(bArr, b, a, (Map) map);
    }

    private void m4698a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f2716a.m4930a(iArr, bArr.length - i);
            while (i2 < i) {
                bArr[i2] = (byte) iArr[i2];
                i2++;
            }
        } catch (ReedSolomonException e) {
            throw ChecksumException.m4637a();
        }
    }
}
