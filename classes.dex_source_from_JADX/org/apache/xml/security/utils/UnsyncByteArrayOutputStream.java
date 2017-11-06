package org.apache.xml.security.utils;

import java.io.OutputStream;

public class UnsyncByteArrayOutputStream extends OutputStream {
    private static ThreadLocal f4259a = new C15871();
    private byte[] f4260b = ((byte[]) f4259a.get());
    private int f4261c = 8192;
    private int f4262d = 0;

    class C15871 extends ThreadLocal {
        C15871() {
        }

        protected synchronized Object initialValue() {
            return new byte[8192];
        }
    }

    private void m6378a(int i) {
        int i2 = this.f4261c;
        while (i > i2) {
            i2 <<= 2;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f4260b, 0, obj, 0, this.f4262d);
        this.f4260b = obj;
        this.f4261c = i2;
    }

    public byte[] m6379a() {
        Object obj = new byte[this.f4262d];
        System.arraycopy(this.f4260b, 0, obj, 0, this.f4262d);
        return obj;
    }

    public void m6380b() {
        this.f4262d = 0;
    }

    public void write(int i) {
        int i2 = this.f4262d + 1;
        if (i2 > this.f4261c) {
            m6378a(i2);
        }
        byte[] bArr = this.f4260b;
        int i3 = this.f4262d;
        this.f4262d = i3 + 1;
        bArr[i3] = (byte) i;
    }

    public void write(byte[] bArr) {
        int length = this.f4262d + bArr.length;
        if (length > this.f4261c) {
            m6378a(length);
        }
        System.arraycopy(bArr, 0, this.f4260b, this.f4262d, bArr.length);
        this.f4262d = length;
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = this.f4262d + i2;
        if (i3 > this.f4261c) {
            m6378a(i3);
        }
        System.arraycopy(bArr, i, this.f4260b, this.f4262d, i2);
        this.f4262d = i3;
    }
}
