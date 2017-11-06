package in.juspay.widget.qrscanner.com.google.zxing.p029b.p030a;

import in.juspay.widget.qrscanner.com.google.zxing.common.C1268b;

enum C1226c {
    DATA_MASK_000 {
        boolean mo761a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    },
    DATA_MASK_001 {
        boolean mo761a(int i, int i2) {
            return (i & 1) == 0;
        }
    },
    DATA_MASK_010 {
        boolean mo761a(int i, int i2) {
            return i2 % 3 == 0;
        }
    },
    DATA_MASK_011 {
        boolean mo761a(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    },
    DATA_MASK_100 {
        boolean mo761a(int i, int i2) {
            return (((i / 2) + (i2 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 {
        boolean mo761a(int i, int i2) {
            return (i * i2) % 6 == 0;
        }
    },
    DATA_MASK_110 {
        boolean mo761a(int i, int i2) {
            return (i * i2) % 6 < 3;
        }
    },
    DATA_MASK_111 {
        boolean mo761a(int i, int i2) {
            return (((i + i2) + ((i * i2) % 3)) & 1) == 0;
        }
    };

    abstract boolean mo761a(int i, int i2);

    final void m4679a(C1268b c1268b, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (mo761a(i2, i3)) {
                    c1268b.m4869c(i3, i2);
                }
            }
        }
    }
}
