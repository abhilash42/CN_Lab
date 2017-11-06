package in.org.npci.upiapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: KeyValueStore */
public class C1442e {
    private final SharedPreferences f3609a;

    public C1442e(Context context) {
        this.f3609a = context.getSharedPreferences("BHIMPreferences", 0);
    }

    public void m5483a(String str, String str2) {
        Editor edit = this.f3609a.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String m5484b(String str, String str2) {
        return this.f3609a.getString(str, str2);
    }

    public void m5482a(String str) {
        Editor edit = this.f3609a.edit();
        edit.remove(str);
        edit.commit();
    }

    public void m5481a(Context context) {
        context.getSharedPreferences("BHIMPreferences", 0).edit().clear().commit();
    }
}
