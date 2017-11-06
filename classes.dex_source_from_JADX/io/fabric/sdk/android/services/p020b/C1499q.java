package io.fabric.sdk.android.services.p020b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile */
public class C1499q implements Closeable {
    private static final Logger f3766b = Logger.getLogger(C1499q.class.getName());
    int f3767a;
    private final RandomAccessFile f3768c;
    private int f3769d;
    private C1497a f3770e;
    private C1497a f3771f;
    private final byte[] f3772g = new byte[16];

    /* compiled from: QueueFile */
    public interface C0715c {
        void read(InputStream inputStream, int i);
    }

    /* compiled from: QueueFile */
    static class C1497a {
        static final C1497a f3760a = new C1497a(0, 0);
        final int f3761b;
        final int f3762c;

        C1497a(int i, int i2) {
            this.f3761b = i;
            this.f3762c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[" + "position = " + this.f3761b + ", length = " + this.f3762c + "]";
        }
    }

    /* compiled from: QueueFile */
    private final class C1498b extends InputStream {
        final /* synthetic */ C1499q f3763a;
        private int f3764b;
        private int f3765c;

        private C1498b(C1499q c1499q, C1497a c1497a) {
            this.f3763a = c1499q;
            this.f3764b = c1499q.m5721b(c1497a.f3761b + 4);
            this.f3765c = c1497a.f3762c;
        }

        public int read(byte[] bArr, int i, int i2) {
            C1499q.m5723b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.f3765c <= 0) {
                return -1;
            } else {
                if (i2 > this.f3765c) {
                    i2 = this.f3765c;
                }
                this.f3763a.m5724b(this.f3764b, bArr, i, i2);
                this.f3764b = this.f3763a.m5721b(this.f3764b + i2);
                this.f3765c -= i2;
                return i2;
            }
        }

        public int read() {
            if (this.f3765c == 0) {
                return -1;
            }
            this.f3763a.f3768c.seek((long) this.f3764b);
            int read = this.f3763a.f3768c.read();
            this.f3764b = this.f3763a.m5721b(this.f3764b + 1);
            this.f3765c--;
            return read;
        }
    }

    public C1499q(File file) {
        if (!file.exists()) {
            C1499q.m5719a(file);
        }
        this.f3768c = C1499q.m5722b(file);
        m5728e();
    }

    private static void m5725b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void m5720a(byte[] bArr, int... iArr) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            C1499q.m5725b(bArr, i2, iArr[i]);
            i2 += 4;
            i++;
        }
    }

    private static int m5712a(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16)) + ((bArr[i + 2] & 255) << 8)) + (bArr[i + 3] & 255);
    }

    private void m5728e() {
        this.f3768c.seek(0);
        this.f3768c.readFully(this.f3772g);
        this.f3767a = C1499q.m5712a(this.f3772g, 0);
        if (((long) this.f3767a) > this.f3768c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f3767a + ", Actual length: " + this.f3768c.length());
        }
        this.f3769d = C1499q.m5712a(this.f3772g, 4);
        int a = C1499q.m5712a(this.f3772g, 8);
        int a2 = C1499q.m5712a(this.f3772g, 12);
        this.f3770e = m5713a(a);
        this.f3771f = m5713a(a2);
    }

    private void m5716a(int i, int i2, int i3, int i4) {
        C1499q.m5720a(this.f3772g, i, i2, i3, i4);
        this.f3768c.seek(0);
        this.f3768c.write(this.f3772g);
    }

    private C1497a m5713a(int i) {
        if (i == 0) {
            return C1497a.f3760a;
        }
        this.f3768c.seek((long) i);
        return new C1497a(i, this.f3768c.readInt());
    }

    private static void m5719a(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b = C1499q.m5722b(file2);
        try {
            b.setLength(4096);
            b.seek(0);
            byte[] bArr = new byte[16];
            C1499q.m5720a(bArr, CodedOutputStream.DEFAULT_BUFFER_SIZE, 0, 0, 0);
            b.write(bArr);
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } finally {
            b.close();
        }
    }

    private static RandomAccessFile m5722b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private int m5721b(int i) {
        return i < this.f3767a ? i : (i + 16) - this.f3767a;
    }

    private void m5717a(int i, byte[] bArr, int i2, int i3) {
        int b = m5721b(i);
        if (b + i3 <= this.f3767a) {
            this.f3768c.seek((long) b);
            this.f3768c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f3767a - b;
        this.f3768c.seek((long) b);
        this.f3768c.write(bArr, i2, i4);
        this.f3768c.seek(16);
        this.f3768c.write(bArr, i2 + i4, i3 - i4);
    }

    private void m5724b(int i, byte[] bArr, int i2, int i3) {
        int b = m5721b(i);
        if (b + i3 <= this.f3767a) {
            this.f3768c.seek((long) b);
            this.f3768c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f3767a - b;
        this.f3768c.seek((long) b);
        this.f3768c.readFully(bArr, i2, i4);
        this.f3768c.seek(16);
        this.f3768c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void m5732a(byte[] bArr) {
        m5733a(bArr, 0, bArr.length);
    }

    public synchronized void m5733a(byte[] bArr, int i, int i2) {
        C1499q.m5723b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3;
        m5726c(i2);
        boolean b = m5735b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m5721b((this.f3771f.f3761b + 4) + this.f3771f.f3762c);
        }
        C1497a c1497a = new C1497a(i3, i2);
        C1499q.m5725b(this.f3772g, 0, i2);
        m5717a(c1497a.f3761b, this.f3772g, 0, 4);
        m5717a(c1497a.f3761b + 4, bArr, i, i2);
        m5716a(this.f3767a, this.f3769d + 1, b ? c1497a.f3761b : this.f3770e.f3761b, c1497a.f3761b);
        this.f3771f = c1497a;
        this.f3769d++;
        if (b) {
            this.f3770e = this.f3771f;
        }
    }

    public int m5730a() {
        if (this.f3769d == 0) {
            return 16;
        }
        if (this.f3771f.f3761b >= this.f3770e.f3761b) {
            return (((this.f3771f.f3761b - this.f3770e.f3761b) + 4) + this.f3771f.f3762c) + 16;
        }
        return (((this.f3771f.f3761b + 4) + this.f3771f.f3762c) + this.f3767a) - this.f3770e.f3761b;
    }

    private int m5729f() {
        return this.f3767a - m5730a();
    }

    public synchronized boolean m5735b() {
        return this.f3769d == 0;
    }

    private void m5726c(int i) {
        int i2 = i + 4;
        int f = m5729f();
        if (f < i2) {
            int i3 = this.f3767a;
            do {
                f += i3;
                i3 <<= 1;
            } while (f < i2);
            m5727d(i3);
            i2 = m5721b((this.f3771f.f3761b + 4) + this.f3771f.f3762c);
            if (i2 < this.f3770e.f3761b) {
                FileChannel channel = this.f3768c.getChannel();
                channel.position((long) this.f3767a);
                int i4 = i2 - 4;
                if (channel.transferTo(16, (long) i4, channel) != ((long) i4)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f3771f.f3761b < this.f3770e.f3761b) {
                f = (this.f3767a + this.f3771f.f3761b) - 16;
                m5716a(i3, this.f3769d, this.f3770e.f3761b, f);
                this.f3771f = new C1497a(f, this.f3771f.f3762c);
            } else {
                m5716a(i3, this.f3769d, this.f3770e.f3761b, this.f3771f.f3761b);
            }
            this.f3767a = i3;
        }
    }

    private void m5727d(int i) {
        this.f3768c.setLength((long) i);
        this.f3768c.getChannel().force(true);
    }

    public synchronized void m5731a(C0715c c0715c) {
        int i = this.f3770e.f3761b;
        for (int i2 = 0; i2 < this.f3769d; i2++) {
            C1497a a = m5713a(i);
            c0715c.read(new C1498b(a), a.f3762c);
            i = m5721b(a.f3762c + (a.f3761b + 4));
        }
    }

    private static <T> T m5723b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void m5736c() {
        if (m5735b()) {
            throw new NoSuchElementException();
        } else if (this.f3769d == 1) {
            m5737d();
        } else {
            int b = m5721b((this.f3770e.f3761b + 4) + this.f3770e.f3762c);
            m5724b(b, this.f3772g, 0, 4);
            int a = C1499q.m5712a(this.f3772g, 0);
            m5716a(this.f3767a, this.f3769d - 1, b, this.f3771f.f3761b);
            this.f3769d--;
            this.f3770e = new C1497a(b, a);
        }
    }

    public synchronized void m5737d() {
        m5716a((int) CodedOutputStream.DEFAULT_BUFFER_SIZE, 0, 0, 0);
        this.f3769d = 0;
        this.f3770e = C1497a.f3760a;
        this.f3771f = C1497a.f3760a;
        if (this.f3767a > CodedOutputStream.DEFAULT_BUFFER_SIZE) {
            m5727d(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        }
        this.f3767a = CodedOutputStream.DEFAULT_BUFFER_SIZE;
    }

    public synchronized void close() {
        this.f3768c.close();
    }

    public boolean m5734a(int i, int i2) {
        return (m5730a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.f3767a);
        stringBuilder.append(", size=").append(this.f3769d);
        stringBuilder.append(", first=").append(this.f3770e);
        stringBuilder.append(", last=").append(this.f3771f);
        stringBuilder.append(", element lengths=[");
        try {
            m5731a(new C0715c(this) {
                boolean f3757a = true;
                final /* synthetic */ C1499q f3759c;

                public void read(InputStream inputStream, int i) {
                    if (this.f3757a) {
                        this.f3757a = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(i);
                }
            });
        } catch (Throwable e) {
            f3766b.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
