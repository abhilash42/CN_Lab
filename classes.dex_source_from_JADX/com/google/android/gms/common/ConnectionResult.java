package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1031o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionResult implements SafeParcelable {
    public static final Creator<ConnectionResult> CREATOR = new C0753e();
    public static final ConnectionResult f1748a = new ConnectionResult(0);
    final int f1749b;
    private final int f1750c;
    private final PendingIntent f1751d;
    private final String f1752e;

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f1749b = i;
        this.f1750c = i2;
        this.f1751d = pendingIntent;
        this.f1752e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String m3176a(int i) {
        switch (i) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public boolean m3177a() {
        return this.f1750c == 0;
    }

    public int m3178b() {
        return this.f1750c;
    }

    public PendingIntent m3179c() {
        return this.f1751d;
    }

    public String m3180d() {
        return this.f1752e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f1750c == connectionResult.f1750c && C1031o.m3677a(this.f1751d, connectionResult.f1751d) && C1031o.m3677a(this.f1752e, connectionResult.f1752e);
    }

    public int hashCode() {
        return C1031o.m3675a(Integer.valueOf(this.f1750c), this.f1751d, this.f1752e);
    }

    public String toString() {
        return C1031o.m3676a((Object) this).m3674a("statusCode", m3176a(this.f1750c)).m3674a("resolution", this.f1751d).m3674a("message", this.f1752e).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0753e.m3225a(this, parcel, i);
    }
}
