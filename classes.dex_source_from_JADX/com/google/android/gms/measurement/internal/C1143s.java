package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C0744c.C0740b;
import com.google.android.gms.common.api.C0744c.C0741c;
import com.google.android.gms.common.internal.C1002d;
import com.google.android.gms.common.internal.C1017h;
import com.google.android.gms.measurement.internal.C1139q.C1141a;

public class C1143s extends C1017h<C1139q> {
    public C1143s(Context context, Looper looper, C1002d c1002d, C0740b c0740b, C0741c c0741c) {
        super(context, looper, 93, c1002d, c0740b, c0741c);
    }

    public /* synthetic */ IInterface mo755a(IBinder iBinder) {
        return m4385b(iBinder);
    }

    protected String mo756a() {
        return "com.google.android.gms.measurement.START";
    }

    public C1139q m4385b(IBinder iBinder) {
        return C1141a.m4364a(iBinder);
    }

    protected String mo757b() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
