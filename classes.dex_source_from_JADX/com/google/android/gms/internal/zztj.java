package com.google.android.gms.internal;

import java.io.IOException;

public class zztj extends IOException {
    public zztj(String str) {
        super(str);
    }

    static zztj m4044a() {
        return new zztj("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zztj m4045b() {
        return new zztj("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zztj m4046c() {
        return new zztj("CodedInputStream encountered a malformed varint.");
    }

    static zztj m4047d() {
        return new zztj("Protocol message contained an invalid tag (zero).");
    }

    static zztj m4048e() {
        return new zztj("Protocol message end-group tag did not match expected tag.");
    }

    static zztj m4049f() {
        return new zztj("Protocol message tag had invalid wire type.");
    }

    static zztj m4050g() {
        return new zztj("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
