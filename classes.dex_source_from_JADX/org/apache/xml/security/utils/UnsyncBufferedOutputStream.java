package org.apache.xml.security.utils;

import java.io.OutputStream;

public class UnsyncBufferedOutputStream extends OutputStream {
    private static ThreadLocal f4255d = new C15861();
    final OutputStream f4256a;
    final byte[] f4257b = ((byte[]) f4255d.get());
    int f4258c = 0;

    class C15861 extends ThreadLocal {
        C15861() {
        }

        protected synchronized Object initialValue() {
            return new byte[8192];
        }
    }

    public UnsyncBufferedOutputStream(OutputStream outputStream) {
        this.f4256a = outputStream;
    }

    private final void m6377a() {
        if (this.f4258c > 0) {
            this.f4256a.write(this.f4257b, 0, this.f4258c);
        }
        this.f4258c = 0;
    }

    public void close() {
        flush();
    }

    public void flush() {
        m6377a();
        this.f4256a.flush();
    }

    public void write(int i) {
        if (this.f4258c >= 8192) {
            m6377a();
        }
        byte[] bArr = this.f4257b;
        int i2 = this.f4258c;
        this.f4258c = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = this.f4258c + i2;
        if (i3 > 8192) {
            m6377a();
            if (i2 > 8192) {
                this.f4256a.write(bArr, i, i2);
                return;
            }
            i3 = i2;
        }
        System.arraycopy(bArr, i, this.f4257b, this.f4258c, i2);
        this.f4258c = i3;
    }
}
