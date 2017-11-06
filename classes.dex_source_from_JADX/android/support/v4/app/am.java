package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.al.C0083a;

/* compiled from: RemoteInputCompatJellybean */
class am {
    static Bundle m290a(C0083a c0083a) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0083a.mo38a());
        bundle.putCharSequence("label", c0083a.mo39b());
        bundle.putCharSequenceArray("choices", c0083a.mo40c());
        bundle.putBoolean("allowFreeFormInput", c0083a.mo41d());
        bundle.putBundle("extras", c0083a.mo42e());
        return bundle;
    }

    static Bundle[] m291a(C0083a[] c0083aArr) {
        if (c0083aArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0083aArr.length];
        for (int i = 0; i < c0083aArr.length; i++) {
            bundleArr[i] = m290a(c0083aArr[i]);
        }
        return bundleArr;
    }
}
