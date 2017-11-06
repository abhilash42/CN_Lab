package com.google.android.gms.internal;

public final class C1096r {
    public static final int[] f2228a = new int[0];
    public static final long[] f2229b = new long[0];
    public static final float[] f2230c = new float[0];
    public static final double[] f2231d = new double[0];
    public static final boolean[] f2232e = new boolean[0];
    public static final String[] f2233f = new String[0];
    public static final byte[][] f2234g = new byte[0][];
    public static final byte[] f2235h = new byte[0];

    static int m3997a(int i) {
        return i & 7;
    }

    static int m3998a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean m3999a(C1093n c1093n, int i) {
        return c1093n.m3971b(i);
    }

    public static int m4000b(int i) {
        return i >>> 3;
    }

    public static final int m4001b(C1093n c1093n, int i) {
        int i2 = 1;
        int m = c1093n.m3987m();
        c1093n.m3971b(i);
        while (c1093n.m3967a() == i) {
            c1093n.m3971b(i);
            i2++;
        }
        c1093n.m3977e(m);
        return i2;
    }
}
