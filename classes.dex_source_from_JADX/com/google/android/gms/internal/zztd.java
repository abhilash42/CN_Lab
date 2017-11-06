package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zztd {
    private final ByteBuffer f2236a;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zztd(ByteBuffer byteBuffer) {
        this.f2236a = byteBuffer;
        this.f2236a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zztd(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int m4002a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'ࠀ') {
                i += m4003a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m4003a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'ࠀ') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('?' <= charAt && charAt <= '?') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m4004a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else if ('?' > charAt2 || charAt2 > '?' || (i3 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            } else {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static zztd m4005a(byte[] bArr) {
        return m4006a(bArr, 0, bArr.length);
    }

    public static zztd m4006a(byte[] bArr, int i, int i2) {
        return new zztd(bArr, i, i2);
    }

    private static void m4007a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m4004a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m4020b(charSequence, byteBuffer);
        }
    }

    public static int m4008b(float f) {
        return 4;
    }

    public static int m4009b(int i) {
        return i >= 0 ? m4023f(i) : 10;
    }

    public static int m4010b(int i, float f) {
        return m4021d(i) + m4008b(f);
    }

    public static int m4011b(int i, int i2) {
        return m4021d(i) + m4009b(i2);
    }

    public static int m4012b(int i, long j) {
        return m4021d(i) + m4016b(j);
    }

    public static int m4013b(int i, C1080p c1080p) {
        return m4021d(i) + m4017b(c1080p);
    }

    public static int m4014b(int i, String str) {
        return m4021d(i) + m4018b(str);
    }

    public static int m4015b(int i, boolean z) {
        return m4021d(i) + m4019b(z);
    }

    public static int m4016b(long j) {
        return m4022d(j);
    }

    public static int m4017b(C1080p c1080p) {
        int e = c1080p.m3932e();
        return e + m4023f(e);
    }

    public static int m4018b(String str) {
        int a = m4002a((CharSequence) str);
        return a + m4023f(a);
    }

    public static int m4019b(boolean z) {
        return 1;
    }

    private static void m4020b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int m4021d(int i) {
        return m4023f(C1096r.m3998a(i, 0));
    }

    public static int m4022d(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static int m4023f(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public int m4024a() {
        return this.f2236a.remaining();
    }

    public void m4025a(byte b) {
        if (this.f2236a.hasRemaining()) {
            this.f2236a.put(b);
            return;
        }
        throw new zza(this.f2236a.position(), this.f2236a.limit());
    }

    public void m4026a(float f) {
        m4043g(Float.floatToIntBits(f));
    }

    public void m4027a(int i) {
        if (i >= 0) {
            m4042e(i);
        } else {
            m4041c((long) i);
        }
    }

    public void m4028a(int i, float f) {
        m4040c(i, 5);
        m4026a(f);
    }

    public void m4029a(int i, int i2) {
        m4040c(i, 0);
        m4027a(i2);
    }

    public void m4030a(int i, long j) {
        m4040c(i, 0);
        m4034a(j);
    }

    public void m4031a(int i, C1080p c1080p) {
        m4040c(i, 2);
        m4035a(c1080p);
    }

    public void m4032a(int i, String str) {
        m4040c(i, 2);
        m4036a(str);
    }

    public void m4033a(int i, boolean z) {
        m4040c(i, 0);
        m4037a(z);
    }

    public void m4034a(long j) {
        m4041c(j);
    }

    public void m4035a(C1080p c1080p) {
        m4042e(c1080p.m3931d());
        c1080p.mo730a(this);
    }

    public void m4036a(String str) {
        try {
            int f = m4023f(str.length());
            if (f == m4023f(str.length() * 3)) {
                int position = this.f2236a.position();
                if (this.f2236a.remaining() < f) {
                    throw new zza(f + position, this.f2236a.limit());
                }
                this.f2236a.position(position + f);
                m4007a((CharSequence) str, this.f2236a);
                int position2 = this.f2236a.position();
                this.f2236a.position(position);
                m4042e((position2 - position) - f);
                this.f2236a.position(position2);
                return;
            }
            m4042e(m4002a((CharSequence) str));
            m4007a((CharSequence) str, this.f2236a);
        } catch (Throwable e) {
            zza com_google_android_gms_internal_zztd_zza = new zza(this.f2236a.position(), this.f2236a.limit());
            com_google_android_gms_internal_zztd_zza.initCause(e);
            throw com_google_android_gms_internal_zztd_zza;
        }
    }

    public void m4037a(boolean z) {
        m4039c(z ? 1 : 0);
    }

    public void m4038b() {
        if (m4024a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m4039c(int i) {
        m4025a((byte) i);
    }

    public void m4040c(int i, int i2) {
        m4042e(C1096r.m3998a(i, i2));
    }

    public void m4041c(long j) {
        while ((-128 & j) != 0) {
            m4039c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m4039c((int) j);
    }

    public void m4042e(int i) {
        while ((i & -128) != 0) {
            m4039c((i & 127) | 128);
            i >>>= 7;
        }
        m4039c(i);
    }

    public void m4043g(int i) {
        if (this.f2236a.remaining() < 4) {
            throw new zza(this.f2236a.position(), this.f2236a.limit());
        }
        this.f2236a.putInt(i);
    }
}
