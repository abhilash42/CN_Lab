package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.support.v4.app.al.C0083a;

/* compiled from: RemoteInputCompatApi20 */
class ak {
    static RemoteInput[] m289a(C0083a[] c0083aArr) {
        if (c0083aArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0083aArr.length];
        for (int i = 0; i < c0083aArr.length; i++) {
            C0083a c0083a = c0083aArr[i];
            remoteInputArr[i] = new Builder(c0083a.mo38a()).setLabel(c0083a.mo39b()).setChoices(c0083a.mo40c()).setAllowFreeFormInput(c0083a.mo41d()).addExtras(c0083a.mo42e()).build();
        }
        return remoteInputArr;
    }
}
