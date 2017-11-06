package com.google.android.gms.internal;

public final class C1093n {
    private final byte[] f2217a;
    private int f2218b;
    private int f2219c;
    private int f2220d;
    private int f2221e;
    private int f2222f;
    private int f2223g = Integer.MAX_VALUE;
    private int f2224h;
    private int f2225i = 64;
    private int f2226j = 67108864;

    private C1093n(byte[] bArr, int i, int i2) {
        this.f2217a = bArr;
        this.f2218b = i;
        this.f2219c = i + i2;
        this.f2221e = i;
    }

    public static C1093n m3964a(byte[] bArr) {
        return C1093n.m3965a(bArr, 0, bArr.length);
    }

    public static C1093n m3965a(byte[] bArr, int i, int i2) {
        return new C1093n(bArr, i, i2);
    }

    private void m3966o() {
        this.f2219c += this.f2220d;
        int i = this.f2219c;
        if (i > this.f2223g) {
            this.f2220d = i - this.f2223g;
            this.f2219c -= this.f2220d;
            return;
        }
        this.f2220d = 0;
    }

    public int m3967a() {
        if (m3986l()) {
            this.f2222f = 0;
            return 0;
        }
        this.f2222f = m3982h();
        if (this.f2222f != 0) {
            return this.f2222f;
        }
        throw zztj.m4047d();
    }

    public void m3968a(int i) {
        if (this.f2222f != i) {
            throw zztj.m4048e();
        }
    }

    public void m3969a(C1080p c1080p) {
        int h = m3982h();
        if (this.f2224h >= this.f2225i) {
            throw zztj.m4050g();
        }
        h = m3973c(h);
        this.f2224h++;
        c1080p.mo731b(this);
        m3968a(0);
        this.f2224h--;
        m3975d(h);
    }

    public void m3970b() {
        int a;
        do {
            a = m3967a();
            if (a == 0) {
                return;
            }
        } while (m3971b(a));
    }

    public boolean m3971b(int i) {
        switch (C1096r.m3997a(i)) {
            case 0:
                m3976e();
                return true;
            case 1:
                m3985k();
                return true;
            case 2:
                m3981g(m3982h());
                return true;
            case 3:
                m3970b();
                m3968a(C1096r.m3998a(C1096r.m4000b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m3984j();
                return true;
            default:
                throw zztj.m4049f();
        }
    }

    public float m3972c() {
        return Float.intBitsToFloat(m3984j());
    }

    public int m3973c(int i) {
        if (i < 0) {
            throw zztj.m4045b();
        }
        int i2 = this.f2221e + i;
        int i3 = this.f2223g;
        if (i2 > i3) {
            throw zztj.m4044a();
        }
        this.f2223g = i2;
        m3966o();
        return i3;
    }

    public long m3974d() {
        return m3983i();
    }

    public void m3975d(int i) {
        this.f2223g = i;
        m3966o();
    }

    public int m3976e() {
        return m3982h();
    }

    public void m3977e(int i) {
        if (i > this.f2221e - this.f2218b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f2221e - this.f2218b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f2221e = this.f2218b + i;
        }
    }

    public boolean m3978f() {
        return m3982h() != 0;
    }

    public byte[] m3979f(int i) {
        if (i < 0) {
            throw zztj.m4045b();
        } else if (this.f2221e + i > this.f2223g) {
            m3981g(this.f2223g - this.f2221e);
            throw zztj.m4044a();
        } else if (i <= this.f2219c - this.f2221e) {
            Object obj = new byte[i];
            System.arraycopy(this.f2217a, this.f2221e, obj, 0, i);
            this.f2221e += i;
            return obj;
        } else {
            throw zztj.m4044a();
        }
    }

    public String m3980g() {
        int h = m3982h();
        if (h > this.f2219c - this.f2221e || h <= 0) {
            return new String(m3979f(h), "UTF-8");
        }
        String str = new String(this.f2217a, this.f2221e, h, "UTF-8");
        this.f2221e = h + this.f2221e;
        return str;
    }

    public void m3981g(int i) {
        if (i < 0) {
            throw zztj.m4045b();
        } else if (this.f2221e + i > this.f2223g) {
            m3981g(this.f2223g - this.f2221e);
            throw zztj.m4044a();
        } else if (i <= this.f2219c - this.f2221e) {
            this.f2221e += i;
        } else {
            throw zztj.m4044a();
        }
    }

    public int m3982h() {
        byte n = m3988n();
        if (n >= (byte) 0) {
            return n;
        }
        int i = n & 127;
        byte n2 = m3988n();
        if (n2 >= (byte) 0) {
            return i | (n2 << 7);
        }
        i |= (n2 & 127) << 7;
        n2 = m3988n();
        if (n2 >= (byte) 0) {
            return i | (n2 << 14);
        }
        i |= (n2 & 127) << 14;
        n2 = m3988n();
        if (n2 >= (byte) 0) {
            return i | (n2 << 21);
        }
        i |= (n2 & 127) << 21;
        n2 = m3988n();
        i |= n2 << 28;
        if (n2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m3988n() >= (byte) 0) {
                return i;
            }
        }
        throw zztj.m4046c();
    }

    public long m3983i() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte n = m3988n();
            j |= ((long) (n & 127)) << i;
            if ((n & 128) == 0) {
                return j;
            }
        }
        throw zztj.m4046c();
    }

    public int m3984j() {
        return (((m3988n() & 255) | ((m3988n() & 255) << 8)) | ((m3988n() & 255) << 16)) | ((m3988n() & 255) << 24);
    }

    public long m3985k() {
        byte n = m3988n();
        byte n2 = m3988n();
        return ((((((((((long) n2) & 255) << 8) | (((long) n) & 255)) | ((((long) m3988n()) & 255) << 16)) | ((((long) m3988n()) & 255) << 24)) | ((((long) m3988n()) & 255) << 32)) | ((((long) m3988n()) & 255) << 40)) | ((((long) m3988n()) & 255) << 48)) | ((((long) m3988n()) & 255) << 56);
    }

    public boolean m3986l() {
        return this.f2221e == this.f2219c;
    }

    public int m3987m() {
        return this.f2221e - this.f2218b;
    }

    public byte m3988n() {
        if (this.f2221e == this.f2219c) {
            throw zztj.m4044a();
        }
        byte[] bArr = this.f2217a;
        int i = this.f2221e;
        this.f2221e = i + 1;
        return bArr[i];
    }
}
