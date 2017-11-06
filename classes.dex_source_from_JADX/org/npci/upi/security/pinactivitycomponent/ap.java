package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ap {
    private final SharedPreferences f4346a;

    public ap(Context context) {
        this.f4346a = context.getSharedPreferences("NPCIPreferences", 0);
    }

    public void m6503a(String str, String str2) {
        Editor edit = this.f4346a.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String m6504b(String str, String str2) {
        return this.f4346a.getString(str, str2);
    }
}
