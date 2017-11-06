package android.support.v7.widget;

/* compiled from: RtlSpacingHelper */
class aj {
    private int f1495a = 0;
    private int f1496b = 0;
    private int f1497c = Integer.MIN_VALUE;
    private int f1498d = Integer.MIN_VALUE;
    private int f1499e = 0;
    private int f1500f = 0;
    private boolean f1501g = false;
    private boolean f1502h = false;

    aj() {
    }

    public int m2888a() {
        return this.f1495a;
    }

    public int m2891b() {
        return this.f1496b;
    }

    public int m2893c() {
        return this.f1501g ? this.f1496b : this.f1495a;
    }

    public int m2894d() {
        return this.f1501g ? this.f1495a : this.f1496b;
    }

    public void m2889a(int i, int i2) {
        this.f1497c = i;
        this.f1498d = i2;
        this.f1502h = true;
        if (this.f1501g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1495a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1496b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1495a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1496b = i2;
        }
    }

    public void m2892b(int i, int i2) {
        this.f1502h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1499e = i;
            this.f1495a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1500f = i2;
            this.f1496b = i2;
        }
    }

    public void m2890a(boolean z) {
        if (z != this.f1501g) {
            this.f1501g = z;
            if (!this.f1502h) {
                this.f1495a = this.f1499e;
                this.f1496b = this.f1500f;
            } else if (z) {
                this.f1495a = this.f1498d != Integer.MIN_VALUE ? this.f1498d : this.f1499e;
                this.f1496b = this.f1497c != Integer.MIN_VALUE ? this.f1497c : this.f1500f;
            } else {
                this.f1495a = this.f1497c != Integer.MIN_VALUE ? this.f1497c : this.f1499e;
                this.f1496b = this.f1498d != Integer.MIN_VALUE ? this.f1498d : this.f1500f;
            }
        }
    }
}
