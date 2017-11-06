package io.fabric.sdk.android.services.p020b;

/* compiled from: AdvertisingInfo */
class C1470b {
    public final String f3689a;
    public final boolean f3690b;

    C1470b(String str, boolean z) {
        this.f3689a = str;
        this.f3690b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1470b c1470b = (C1470b) obj;
        if (this.f3690b != c1470b.f3690b) {
            return false;
        }
        if (this.f3689a != null) {
            if (this.f3689a.equals(c1470b.f3689a)) {
                return true;
            }
        } else if (c1470b.f3689a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f3689a != null) {
            hashCode = this.f3689a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f3690b) {
            i = 1;
        }
        return hashCode + i;
    }
}
