package com.google.android.gms.internal;

public interface C1086j {

    public static final class C1081a extends C1080p {
        private static volatile C1081a[] f2148f;
        public C1082b[] f2149a;
        public String f2150b;
        public Long f2151c;
        public Long f2152d;
        public Integer f2153e;

        public C1081a() {
            m3937b();
        }

        public static C1081a[] m3934a() {
            if (f2148f == null) {
                synchronized (C1094o.f2227a) {
                    if (f2148f == null) {
                        f2148f = new C1081a[0];
                    }
                }
            }
            return f2148f;
        }

        public C1081a m3935a(C1093n c1093n) {
            while (true) {
                int a = c1093n.m3967a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int b = C1096r.m4001b(c1093n, 10);
                        a = this.f2149a == null ? 0 : this.f2149a.length;
                        Object obj = new C1082b[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f2149a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1082b();
                            c1093n.m3969a(obj[a]);
                            c1093n.m3967a();
                            a++;
                        }
                        obj[a] = new C1082b();
                        c1093n.m3969a(obj[a]);
                        this.f2149a = obj;
                        continue;
                    case 18:
                        this.f2150b = c1093n.m3980g();
                        continue;
                    case 24:
                        this.f2151c = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 32:
                        this.f2152d = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 40:
                        this.f2153e = Integer.valueOf(c1093n.m3976e());
                        continue;
                    default:
                        if (!C1096r.m3999a(c1093n, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo730a(zztd com_google_android_gms_internal_zztd) {
            if (this.f2149a != null && this.f2149a.length > 0) {
                for (C1080p c1080p : this.f2149a) {
                    if (c1080p != null) {
                        com_google_android_gms_internal_zztd.m4031a(1, c1080p);
                    }
                }
            }
            if (this.f2150b != null) {
                com_google_android_gms_internal_zztd.m4032a(2, this.f2150b);
            }
            if (this.f2151c != null) {
                com_google_android_gms_internal_zztd.m4030a(3, this.f2151c.longValue());
            }
            if (this.f2152d != null) {
                com_google_android_gms_internal_zztd.m4030a(4, this.f2152d.longValue());
            }
            if (this.f2153e != null) {
                com_google_android_gms_internal_zztd.m4029a(5, this.f2153e.intValue());
            }
            super.mo730a(com_google_android_gms_internal_zztd);
        }

        public C1081a m3937b() {
            this.f2149a = C1082b.m3940a();
            this.f2150b = null;
            this.f2151c = null;
            this.f2152d = null;
            this.f2153e = null;
            this.A = -1;
            return this;
        }

        public /* synthetic */ C1080p mo731b(C1093n c1093n) {
            return m3935a(c1093n);
        }

        protected int mo732c() {
            int c = super.mo732c();
            if (this.f2149a != null && this.f2149a.length > 0) {
                for (C1080p c1080p : this.f2149a) {
                    if (c1080p != null) {
                        c += zztd.m4013b(1, c1080p);
                    }
                }
            }
            if (this.f2150b != null) {
                c += zztd.m4014b(2, this.f2150b);
            }
            if (this.f2151c != null) {
                c += zztd.m4012b(3, this.f2151c.longValue());
            }
            if (this.f2152d != null) {
                c += zztd.m4012b(4, this.f2152d.longValue());
            }
            return this.f2153e != null ? c + zztd.m4011b(5, this.f2153e.intValue()) : c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1081a)) {
                return false;
            }
            C1081a c1081a = (C1081a) obj;
            if (!C1094o.m3990a(this.f2149a, c1081a.f2149a)) {
                return false;
            }
            if (this.f2150b == null) {
                if (c1081a.f2150b != null) {
                    return false;
                }
            } else if (!this.f2150b.equals(c1081a.f2150b)) {
                return false;
            }
            if (this.f2151c == null) {
                if (c1081a.f2151c != null) {
                    return false;
                }
            } else if (!this.f2151c.equals(c1081a.f2151c)) {
                return false;
            }
            if (this.f2152d == null) {
                if (c1081a.f2152d != null) {
                    return false;
                }
            } else if (!this.f2152d.equals(c1081a.f2152d)) {
                return false;
            }
            return this.f2153e == null ? c1081a.f2153e == null : this.f2153e.equals(c1081a.f2153e);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f2152d == null ? 0 : this.f2152d.hashCode()) + (((this.f2151c == null ? 0 : this.f2151c.hashCode()) + (((this.f2150b == null ? 0 : this.f2150b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + C1094o.m3989a(this.f2149a)) * 31)) * 31)) * 31)) * 31;
            if (this.f2153e != null) {
                i = this.f2153e.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1082b extends C1080p {
        private static volatile C1082b[] f2154e;
        public String f2155a;
        public String f2156b;
        public Long f2157c;
        public Float f2158d;

        public C1082b() {
            m3943b();
        }

        public static C1082b[] m3940a() {
            if (f2154e == null) {
                synchronized (C1094o.f2227a) {
                    if (f2154e == null) {
                        f2154e = new C1082b[0];
                    }
                }
            }
            return f2154e;
        }

        public C1082b m3941a(C1093n c1093n) {
            while (true) {
                int a = c1093n.m3967a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f2155a = c1093n.m3980g();
                        continue;
                    case 18:
                        this.f2156b = c1093n.m3980g();
                        continue;
                    case 24:
                        this.f2157c = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 37:
                        this.f2158d = Float.valueOf(c1093n.m3972c());
                        continue;
                    default:
                        if (!C1096r.m3999a(c1093n, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo730a(zztd com_google_android_gms_internal_zztd) {
            if (this.f2155a != null) {
                com_google_android_gms_internal_zztd.m4032a(1, this.f2155a);
            }
            if (this.f2156b != null) {
                com_google_android_gms_internal_zztd.m4032a(2, this.f2156b);
            }
            if (this.f2157c != null) {
                com_google_android_gms_internal_zztd.m4030a(3, this.f2157c.longValue());
            }
            if (this.f2158d != null) {
                com_google_android_gms_internal_zztd.m4028a(4, this.f2158d.floatValue());
            }
            super.mo730a(com_google_android_gms_internal_zztd);
        }

        public C1082b m3943b() {
            this.f2155a = null;
            this.f2156b = null;
            this.f2157c = null;
            this.f2158d = null;
            this.A = -1;
            return this;
        }

        public /* synthetic */ C1080p mo731b(C1093n c1093n) {
            return m3941a(c1093n);
        }

        protected int mo732c() {
            int c = super.mo732c();
            if (this.f2155a != null) {
                c += zztd.m4014b(1, this.f2155a);
            }
            if (this.f2156b != null) {
                c += zztd.m4014b(2, this.f2156b);
            }
            if (this.f2157c != null) {
                c += zztd.m4012b(3, this.f2157c.longValue());
            }
            return this.f2158d != null ? c + zztd.m4010b(4, this.f2158d.floatValue()) : c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1082b)) {
                return false;
            }
            C1082b c1082b = (C1082b) obj;
            if (this.f2155a == null) {
                if (c1082b.f2155a != null) {
                    return false;
                }
            } else if (!this.f2155a.equals(c1082b.f2155a)) {
                return false;
            }
            if (this.f2156b == null) {
                if (c1082b.f2156b != null) {
                    return false;
                }
            } else if (!this.f2156b.equals(c1082b.f2156b)) {
                return false;
            }
            if (this.f2157c == null) {
                if (c1082b.f2157c != null) {
                    return false;
                }
            } else if (!this.f2157c.equals(c1082b.f2157c)) {
                return false;
            }
            return this.f2158d == null ? c1082b.f2158d == null : this.f2158d.equals(c1082b.f2158d);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f2157c == null ? 0 : this.f2157c.hashCode()) + (((this.f2156b == null ? 0 : this.f2156b.hashCode()) + (((this.f2155a == null ? 0 : this.f2155a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.f2158d != null) {
                i = this.f2158d.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1083c extends C1080p {
        public C1084d[] f2159a;

        public C1083c() {
            m3946a();
        }

        public C1083c m3946a() {
            this.f2159a = C1084d.m3951a();
            this.A = -1;
            return this;
        }

        public C1083c m3947a(C1093n c1093n) {
            while (true) {
                int a = c1093n.m3967a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int b = C1096r.m4001b(c1093n, 10);
                        a = this.f2159a == null ? 0 : this.f2159a.length;
                        Object obj = new C1084d[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f2159a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1084d();
                            c1093n.m3969a(obj[a]);
                            c1093n.m3967a();
                            a++;
                        }
                        obj[a] = new C1084d();
                        c1093n.m3969a(obj[a]);
                        this.f2159a = obj;
                        continue;
                    default:
                        if (!C1096r.m3999a(c1093n, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo730a(zztd com_google_android_gms_internal_zztd) {
            if (this.f2159a != null && this.f2159a.length > 0) {
                for (C1080p c1080p : this.f2159a) {
                    if (c1080p != null) {
                        com_google_android_gms_internal_zztd.m4031a(1, c1080p);
                    }
                }
            }
            super.mo730a(com_google_android_gms_internal_zztd);
        }

        public /* synthetic */ C1080p mo731b(C1093n c1093n) {
            return m3947a(c1093n);
        }

        protected int mo732c() {
            int c = super.mo732c();
            if (this.f2159a != null && this.f2159a.length > 0) {
                for (C1080p c1080p : this.f2159a) {
                    if (c1080p != null) {
                        c += zztd.m4013b(1, c1080p);
                    }
                }
            }
            return c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1083c)) {
                return false;
            }
            return C1094o.m3990a(this.f2159a, ((C1083c) obj).f2159a);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + C1094o.m3989a(this.f2159a);
        }
    }

    public static final class C1084d extends C1080p {
        private static volatile C1084d[] f2160B;
        public Integer f2161a;
        public C1081a[] f2162b;
        public C1085e[] f2163c;
        public Long f2164d;
        public Long f2165e;
        public Long f2166f;
        public Long f2167g;
        public Long f2168h;
        public String f2169i;
        public String f2170j;
        public String f2171k;
        public String f2172l;
        public Integer f2173m;
        public String f2174n;
        public String f2175o;
        public String f2176p;
        public Long f2177q;
        public Long f2178r;
        public String f2179s;
        public Boolean f2180t;
        public String f2181u;
        public Long f2182v;
        public Integer f2183w;
        public String f2184x;
        public String f2185y;
        public Boolean f2186z;

        public C1084d() {
            m3954b();
        }

        public static C1084d[] m3951a() {
            if (f2160B == null) {
                synchronized (C1094o.f2227a) {
                    if (f2160B == null) {
                        f2160B = new C1084d[0];
                    }
                }
            }
            return f2160B;
        }

        public C1084d m3952a(C1093n c1093n) {
            while (true) {
                int a = c1093n.m3967a();
                int b;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f2161a = Integer.valueOf(c1093n.m3976e());
                        continue;
                    case 18:
                        b = C1096r.m4001b(c1093n, 18);
                        a = this.f2162b == null ? 0 : this.f2162b.length;
                        obj = new C1081a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f2162b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1081a();
                            c1093n.m3969a(obj[a]);
                            c1093n.m3967a();
                            a++;
                        }
                        obj[a] = new C1081a();
                        c1093n.m3969a(obj[a]);
                        this.f2162b = obj;
                        continue;
                    case 26:
                        b = C1096r.m4001b(c1093n, 26);
                        a = this.f2163c == null ? 0 : this.f2163c.length;
                        obj = new C1085e[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f2163c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1085e();
                            c1093n.m3969a(obj[a]);
                            c1093n.m3967a();
                            a++;
                        }
                        obj[a] = new C1085e();
                        c1093n.m3969a(obj[a]);
                        this.f2163c = obj;
                        continue;
                    case 32:
                        this.f2164d = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 40:
                        this.f2165e = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 48:
                        this.f2166f = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 56:
                        this.f2168h = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 66:
                        this.f2169i = c1093n.m3980g();
                        continue;
                    case 74:
                        this.f2170j = c1093n.m3980g();
                        continue;
                    case 82:
                        this.f2171k = c1093n.m3980g();
                        continue;
                    case 90:
                        this.f2172l = c1093n.m3980g();
                        continue;
                    case 96:
                        this.f2173m = Integer.valueOf(c1093n.m3976e());
                        continue;
                    case 106:
                        this.f2174n = c1093n.m3980g();
                        continue;
                    case 114:
                        this.f2175o = c1093n.m3980g();
                        continue;
                    case 130:
                        this.f2176p = c1093n.m3980g();
                        continue;
                    case 136:
                        this.f2177q = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 144:
                        this.f2178r = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 154:
                        this.f2179s = c1093n.m3980g();
                        continue;
                    case 160:
                        this.f2180t = Boolean.valueOf(c1093n.m3978f());
                        continue;
                    case 170:
                        this.f2181u = c1093n.m3980g();
                        continue;
                    case 176:
                        this.f2182v = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 184:
                        this.f2183w = Integer.valueOf(c1093n.m3976e());
                        continue;
                    case 194:
                        this.f2184x = c1093n.m3980g();
                        continue;
                    case 202:
                        this.f2185y = c1093n.m3980g();
                        continue;
                    case 208:
                        this.f2167g = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 224:
                        this.f2186z = Boolean.valueOf(c1093n.m3978f());
                        continue;
                    default:
                        if (!C1096r.m3999a(c1093n, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo730a(zztd com_google_android_gms_internal_zztd) {
            int i = 0;
            if (this.f2161a != null) {
                com_google_android_gms_internal_zztd.m4029a(1, this.f2161a.intValue());
            }
            if (this.f2162b != null && this.f2162b.length > 0) {
                for (C1080p c1080p : this.f2162b) {
                    if (c1080p != null) {
                        com_google_android_gms_internal_zztd.m4031a(2, c1080p);
                    }
                }
            }
            if (this.f2163c != null && this.f2163c.length > 0) {
                while (i < this.f2163c.length) {
                    C1080p c1080p2 = this.f2163c[i];
                    if (c1080p2 != null) {
                        com_google_android_gms_internal_zztd.m4031a(3, c1080p2);
                    }
                    i++;
                }
            }
            if (this.f2164d != null) {
                com_google_android_gms_internal_zztd.m4030a(4, this.f2164d.longValue());
            }
            if (this.f2165e != null) {
                com_google_android_gms_internal_zztd.m4030a(5, this.f2165e.longValue());
            }
            if (this.f2166f != null) {
                com_google_android_gms_internal_zztd.m4030a(6, this.f2166f.longValue());
            }
            if (this.f2168h != null) {
                com_google_android_gms_internal_zztd.m4030a(7, this.f2168h.longValue());
            }
            if (this.f2169i != null) {
                com_google_android_gms_internal_zztd.m4032a(8, this.f2169i);
            }
            if (this.f2170j != null) {
                com_google_android_gms_internal_zztd.m4032a(9, this.f2170j);
            }
            if (this.f2171k != null) {
                com_google_android_gms_internal_zztd.m4032a(10, this.f2171k);
            }
            if (this.f2172l != null) {
                com_google_android_gms_internal_zztd.m4032a(11, this.f2172l);
            }
            if (this.f2173m != null) {
                com_google_android_gms_internal_zztd.m4029a(12, this.f2173m.intValue());
            }
            if (this.f2174n != null) {
                com_google_android_gms_internal_zztd.m4032a(13, this.f2174n);
            }
            if (this.f2175o != null) {
                com_google_android_gms_internal_zztd.m4032a(14, this.f2175o);
            }
            if (this.f2176p != null) {
                com_google_android_gms_internal_zztd.m4032a(16, this.f2176p);
            }
            if (this.f2177q != null) {
                com_google_android_gms_internal_zztd.m4030a(17, this.f2177q.longValue());
            }
            if (this.f2178r != null) {
                com_google_android_gms_internal_zztd.m4030a(18, this.f2178r.longValue());
            }
            if (this.f2179s != null) {
                com_google_android_gms_internal_zztd.m4032a(19, this.f2179s);
            }
            if (this.f2180t != null) {
                com_google_android_gms_internal_zztd.m4033a(20, this.f2180t.booleanValue());
            }
            if (this.f2181u != null) {
                com_google_android_gms_internal_zztd.m4032a(21, this.f2181u);
            }
            if (this.f2182v != null) {
                com_google_android_gms_internal_zztd.m4030a(22, this.f2182v.longValue());
            }
            if (this.f2183w != null) {
                com_google_android_gms_internal_zztd.m4029a(23, this.f2183w.intValue());
            }
            if (this.f2184x != null) {
                com_google_android_gms_internal_zztd.m4032a(24, this.f2184x);
            }
            if (this.f2185y != null) {
                com_google_android_gms_internal_zztd.m4032a(25, this.f2185y);
            }
            if (this.f2167g != null) {
                com_google_android_gms_internal_zztd.m4030a(26, this.f2167g.longValue());
            }
            if (this.f2186z != null) {
                com_google_android_gms_internal_zztd.m4033a(28, this.f2186z.booleanValue());
            }
            super.mo730a(com_google_android_gms_internal_zztd);
        }

        public C1084d m3954b() {
            this.f2161a = null;
            this.f2162b = C1081a.m3934a();
            this.f2163c = C1085e.m3957a();
            this.f2164d = null;
            this.f2165e = null;
            this.f2166f = null;
            this.f2167g = null;
            this.f2168h = null;
            this.f2169i = null;
            this.f2170j = null;
            this.f2171k = null;
            this.f2172l = null;
            this.f2173m = null;
            this.f2174n = null;
            this.f2175o = null;
            this.f2176p = null;
            this.f2177q = null;
            this.f2178r = null;
            this.f2179s = null;
            this.f2180t = null;
            this.f2181u = null;
            this.f2182v = null;
            this.f2183w = null;
            this.f2184x = null;
            this.f2185y = null;
            this.f2186z = null;
            this.A = -1;
            return this;
        }

        public /* synthetic */ C1080p mo731b(C1093n c1093n) {
            return m3952a(c1093n);
        }

        protected int mo732c() {
            int i = 0;
            int c = super.mo732c();
            if (this.f2161a != null) {
                c += zztd.m4011b(1, this.f2161a.intValue());
            }
            if (this.f2162b != null && this.f2162b.length > 0) {
                int i2 = c;
                for (C1080p c1080p : this.f2162b) {
                    if (c1080p != null) {
                        i2 += zztd.m4013b(2, c1080p);
                    }
                }
                c = i2;
            }
            if (this.f2163c != null && this.f2163c.length > 0) {
                while (i < this.f2163c.length) {
                    C1080p c1080p2 = this.f2163c[i];
                    if (c1080p2 != null) {
                        c += zztd.m4013b(3, c1080p2);
                    }
                    i++;
                }
            }
            if (this.f2164d != null) {
                c += zztd.m4012b(4, this.f2164d.longValue());
            }
            if (this.f2165e != null) {
                c += zztd.m4012b(5, this.f2165e.longValue());
            }
            if (this.f2166f != null) {
                c += zztd.m4012b(6, this.f2166f.longValue());
            }
            if (this.f2168h != null) {
                c += zztd.m4012b(7, this.f2168h.longValue());
            }
            if (this.f2169i != null) {
                c += zztd.m4014b(8, this.f2169i);
            }
            if (this.f2170j != null) {
                c += zztd.m4014b(9, this.f2170j);
            }
            if (this.f2171k != null) {
                c += zztd.m4014b(10, this.f2171k);
            }
            if (this.f2172l != null) {
                c += zztd.m4014b(11, this.f2172l);
            }
            if (this.f2173m != null) {
                c += zztd.m4011b(12, this.f2173m.intValue());
            }
            if (this.f2174n != null) {
                c += zztd.m4014b(13, this.f2174n);
            }
            if (this.f2175o != null) {
                c += zztd.m4014b(14, this.f2175o);
            }
            if (this.f2176p != null) {
                c += zztd.m4014b(16, this.f2176p);
            }
            if (this.f2177q != null) {
                c += zztd.m4012b(17, this.f2177q.longValue());
            }
            if (this.f2178r != null) {
                c += zztd.m4012b(18, this.f2178r.longValue());
            }
            if (this.f2179s != null) {
                c += zztd.m4014b(19, this.f2179s);
            }
            if (this.f2180t != null) {
                c += zztd.m4015b(20, this.f2180t.booleanValue());
            }
            if (this.f2181u != null) {
                c += zztd.m4014b(21, this.f2181u);
            }
            if (this.f2182v != null) {
                c += zztd.m4012b(22, this.f2182v.longValue());
            }
            if (this.f2183w != null) {
                c += zztd.m4011b(23, this.f2183w.intValue());
            }
            if (this.f2184x != null) {
                c += zztd.m4014b(24, this.f2184x);
            }
            if (this.f2185y != null) {
                c += zztd.m4014b(25, this.f2185y);
            }
            if (this.f2167g != null) {
                c += zztd.m4012b(26, this.f2167g.longValue());
            }
            return this.f2186z != null ? c + zztd.m4015b(28, this.f2186z.booleanValue()) : c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1084d)) {
                return false;
            }
            C1084d c1084d = (C1084d) obj;
            if (this.f2161a == null) {
                if (c1084d.f2161a != null) {
                    return false;
                }
            } else if (!this.f2161a.equals(c1084d.f2161a)) {
                return false;
            }
            if (!C1094o.m3990a(this.f2162b, c1084d.f2162b)) {
                return false;
            }
            if (!C1094o.m3990a(this.f2163c, c1084d.f2163c)) {
                return false;
            }
            if (this.f2164d == null) {
                if (c1084d.f2164d != null) {
                    return false;
                }
            } else if (!this.f2164d.equals(c1084d.f2164d)) {
                return false;
            }
            if (this.f2165e == null) {
                if (c1084d.f2165e != null) {
                    return false;
                }
            } else if (!this.f2165e.equals(c1084d.f2165e)) {
                return false;
            }
            if (this.f2166f == null) {
                if (c1084d.f2166f != null) {
                    return false;
                }
            } else if (!this.f2166f.equals(c1084d.f2166f)) {
                return false;
            }
            if (this.f2167g == null) {
                if (c1084d.f2167g != null) {
                    return false;
                }
            } else if (!this.f2167g.equals(c1084d.f2167g)) {
                return false;
            }
            if (this.f2168h == null) {
                if (c1084d.f2168h != null) {
                    return false;
                }
            } else if (!this.f2168h.equals(c1084d.f2168h)) {
                return false;
            }
            if (this.f2169i == null) {
                if (c1084d.f2169i != null) {
                    return false;
                }
            } else if (!this.f2169i.equals(c1084d.f2169i)) {
                return false;
            }
            if (this.f2170j == null) {
                if (c1084d.f2170j != null) {
                    return false;
                }
            } else if (!this.f2170j.equals(c1084d.f2170j)) {
                return false;
            }
            if (this.f2171k == null) {
                if (c1084d.f2171k != null) {
                    return false;
                }
            } else if (!this.f2171k.equals(c1084d.f2171k)) {
                return false;
            }
            if (this.f2172l == null) {
                if (c1084d.f2172l != null) {
                    return false;
                }
            } else if (!this.f2172l.equals(c1084d.f2172l)) {
                return false;
            }
            if (this.f2173m == null) {
                if (c1084d.f2173m != null) {
                    return false;
                }
            } else if (!this.f2173m.equals(c1084d.f2173m)) {
                return false;
            }
            if (this.f2174n == null) {
                if (c1084d.f2174n != null) {
                    return false;
                }
            } else if (!this.f2174n.equals(c1084d.f2174n)) {
                return false;
            }
            if (this.f2175o == null) {
                if (c1084d.f2175o != null) {
                    return false;
                }
            } else if (!this.f2175o.equals(c1084d.f2175o)) {
                return false;
            }
            if (this.f2176p == null) {
                if (c1084d.f2176p != null) {
                    return false;
                }
            } else if (!this.f2176p.equals(c1084d.f2176p)) {
                return false;
            }
            if (this.f2177q == null) {
                if (c1084d.f2177q != null) {
                    return false;
                }
            } else if (!this.f2177q.equals(c1084d.f2177q)) {
                return false;
            }
            if (this.f2178r == null) {
                if (c1084d.f2178r != null) {
                    return false;
                }
            } else if (!this.f2178r.equals(c1084d.f2178r)) {
                return false;
            }
            if (this.f2179s == null) {
                if (c1084d.f2179s != null) {
                    return false;
                }
            } else if (!this.f2179s.equals(c1084d.f2179s)) {
                return false;
            }
            if (this.f2180t == null) {
                if (c1084d.f2180t != null) {
                    return false;
                }
            } else if (!this.f2180t.equals(c1084d.f2180t)) {
                return false;
            }
            if (this.f2181u == null) {
                if (c1084d.f2181u != null) {
                    return false;
                }
            } else if (!this.f2181u.equals(c1084d.f2181u)) {
                return false;
            }
            if (this.f2182v == null) {
                if (c1084d.f2182v != null) {
                    return false;
                }
            } else if (!this.f2182v.equals(c1084d.f2182v)) {
                return false;
            }
            if (this.f2183w == null) {
                if (c1084d.f2183w != null) {
                    return false;
                }
            } else if (!this.f2183w.equals(c1084d.f2183w)) {
                return false;
            }
            if (this.f2184x == null) {
                if (c1084d.f2184x != null) {
                    return false;
                }
            } else if (!this.f2184x.equals(c1084d.f2184x)) {
                return false;
            }
            if (this.f2185y == null) {
                if (c1084d.f2185y != null) {
                    return false;
                }
            } else if (!this.f2185y.equals(c1084d.f2185y)) {
                return false;
            }
            return this.f2186z == null ? c1084d.f2186z == null : this.f2186z.equals(c1084d.f2186z);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f2185y == null ? 0 : this.f2185y.hashCode()) + (((this.f2184x == null ? 0 : this.f2184x.hashCode()) + (((this.f2183w == null ? 0 : this.f2183w.hashCode()) + (((this.f2182v == null ? 0 : this.f2182v.hashCode()) + (((this.f2181u == null ? 0 : this.f2181u.hashCode()) + (((this.f2180t == null ? 0 : this.f2180t.hashCode()) + (((this.f2179s == null ? 0 : this.f2179s.hashCode()) + (((this.f2178r == null ? 0 : this.f2178r.hashCode()) + (((this.f2177q == null ? 0 : this.f2177q.hashCode()) + (((this.f2176p == null ? 0 : this.f2176p.hashCode()) + (((this.f2175o == null ? 0 : this.f2175o.hashCode()) + (((this.f2174n == null ? 0 : this.f2174n.hashCode()) + (((this.f2173m == null ? 0 : this.f2173m.hashCode()) + (((this.f2172l == null ? 0 : this.f2172l.hashCode()) + (((this.f2171k == null ? 0 : this.f2171k.hashCode()) + (((this.f2170j == null ? 0 : this.f2170j.hashCode()) + (((this.f2169i == null ? 0 : this.f2169i.hashCode()) + (((this.f2168h == null ? 0 : this.f2168h.hashCode()) + (((this.f2167g == null ? 0 : this.f2167g.hashCode()) + (((this.f2166f == null ? 0 : this.f2166f.hashCode()) + (((this.f2165e == null ? 0 : this.f2165e.hashCode()) + (((this.f2164d == null ? 0 : this.f2164d.hashCode()) + (((((((this.f2161a == null ? 0 : this.f2161a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + C1094o.m3989a(this.f2162b)) * 31) + C1094o.m3989a(this.f2163c)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f2186z != null) {
                i = this.f2186z.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1085e extends C1080p {
        private static volatile C1085e[] f2187f;
        public Long f2188a;
        public String f2189b;
        public String f2190c;
        public Long f2191d;
        public Float f2192e;

        public C1085e() {
            m3960b();
        }

        public static C1085e[] m3957a() {
            if (f2187f == null) {
                synchronized (C1094o.f2227a) {
                    if (f2187f == null) {
                        f2187f = new C1085e[0];
                    }
                }
            }
            return f2187f;
        }

        public C1085e m3958a(C1093n c1093n) {
            while (true) {
                int a = c1093n.m3967a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f2188a = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 18:
                        this.f2189b = c1093n.m3980g();
                        continue;
                    case 26:
                        this.f2190c = c1093n.m3980g();
                        continue;
                    case 32:
                        this.f2191d = Long.valueOf(c1093n.m3974d());
                        continue;
                    case 45:
                        this.f2192e = Float.valueOf(c1093n.m3972c());
                        continue;
                    default:
                        if (!C1096r.m3999a(c1093n, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo730a(zztd com_google_android_gms_internal_zztd) {
            if (this.f2188a != null) {
                com_google_android_gms_internal_zztd.m4030a(1, this.f2188a.longValue());
            }
            if (this.f2189b != null) {
                com_google_android_gms_internal_zztd.m4032a(2, this.f2189b);
            }
            if (this.f2190c != null) {
                com_google_android_gms_internal_zztd.m4032a(3, this.f2190c);
            }
            if (this.f2191d != null) {
                com_google_android_gms_internal_zztd.m4030a(4, this.f2191d.longValue());
            }
            if (this.f2192e != null) {
                com_google_android_gms_internal_zztd.m4028a(5, this.f2192e.floatValue());
            }
            super.mo730a(com_google_android_gms_internal_zztd);
        }

        public C1085e m3960b() {
            this.f2188a = null;
            this.f2189b = null;
            this.f2190c = null;
            this.f2191d = null;
            this.f2192e = null;
            this.A = -1;
            return this;
        }

        public /* synthetic */ C1080p mo731b(C1093n c1093n) {
            return m3958a(c1093n);
        }

        protected int mo732c() {
            int c = super.mo732c();
            if (this.f2188a != null) {
                c += zztd.m4012b(1, this.f2188a.longValue());
            }
            if (this.f2189b != null) {
                c += zztd.m4014b(2, this.f2189b);
            }
            if (this.f2190c != null) {
                c += zztd.m4014b(3, this.f2190c);
            }
            if (this.f2191d != null) {
                c += zztd.m4012b(4, this.f2191d.longValue());
            }
            return this.f2192e != null ? c + zztd.m4010b(5, this.f2192e.floatValue()) : c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1085e)) {
                return false;
            }
            C1085e c1085e = (C1085e) obj;
            if (this.f2188a == null) {
                if (c1085e.f2188a != null) {
                    return false;
                }
            } else if (!this.f2188a.equals(c1085e.f2188a)) {
                return false;
            }
            if (this.f2189b == null) {
                if (c1085e.f2189b != null) {
                    return false;
                }
            } else if (!this.f2189b.equals(c1085e.f2189b)) {
                return false;
            }
            if (this.f2190c == null) {
                if (c1085e.f2190c != null) {
                    return false;
                }
            } else if (!this.f2190c.equals(c1085e.f2190c)) {
                return false;
            }
            if (this.f2191d == null) {
                if (c1085e.f2191d != null) {
                    return false;
                }
            } else if (!this.f2191d.equals(c1085e.f2191d)) {
                return false;
            }
            return this.f2192e == null ? c1085e.f2192e == null : this.f2192e.equals(c1085e.f2192e);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f2191d == null ? 0 : this.f2191d.hashCode()) + (((this.f2190c == null ? 0 : this.f2190c.hashCode()) + (((this.f2189b == null ? 0 : this.f2189b.hashCode()) + (((this.f2188a == null ? 0 : this.f2188a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f2192e != null) {
                i = this.f2192e.hashCode();
            }
            return hashCode + i;
        }
    }
}
