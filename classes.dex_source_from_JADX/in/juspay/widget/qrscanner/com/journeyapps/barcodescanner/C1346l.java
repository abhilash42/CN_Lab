package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

public class C1346l implements Comparable<C1346l> {
    public final int f3130a;
    public final int f3131b;

    public /* synthetic */ int compareTo(Object obj) {
        return m5150c((C1346l) obj);
    }

    public C1346l(int i, int i2) {
        this.f3130a = i;
        this.f3131b = i2;
    }

    public C1346l m5147a() {
        return new C1346l(this.f3131b, this.f3130a);
    }

    public C1346l m5148a(C1346l c1346l) {
        if (this.f3130a * c1346l.f3131b >= c1346l.f3130a * this.f3131b) {
            return new C1346l(c1346l.f3130a, (this.f3131b * c1346l.f3130a) / this.f3130a);
        }
        return new C1346l((this.f3130a * c1346l.f3131b) / this.f3131b, c1346l.f3131b);
    }

    public C1346l m5149b(C1346l c1346l) {
        if (this.f3130a * c1346l.f3131b <= c1346l.f3130a * this.f3131b) {
            return new C1346l(c1346l.f3130a, (this.f3131b * c1346l.f3130a) / this.f3130a);
        }
        return new C1346l((this.f3130a * c1346l.f3131b) / this.f3131b, c1346l.f3131b);
    }

    public int m5150c(C1346l c1346l) {
        int i = this.f3131b * this.f3130a;
        int i2 = c1346l.f3131b * c1346l.f3130a;
        if (i2 < i) {
            return 1;
        }
        if (i2 > i) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        return this.f3130a + "x" + this.f3131b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1346l c1346l = (C1346l) obj;
        if (this.f3130a == c1346l.f3130a && this.f3131b == c1346l.f3131b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f3130a * 31) + this.f3131b;
    }
}
