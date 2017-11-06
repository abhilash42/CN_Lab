package io.fabric.sdk.android.services.p020b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* compiled from: IdManager */
public class C1493o {
    private static final Pattern f3741d = Pattern.compile("[^\\p{Alnum}]");
    private static final String f3742e = Pattern.quote("/");
    C1472c f3743a;
    C1470b f3744b;
    boolean f3745c;
    private final ReentrantLock f3746f = new ReentrantLock();
    private final C1495p f3747g;
    private final boolean f3748h;
    private final boolean f3749i;
    private final Context f3750j;
    private final String f3751k;
    private final String f3752l;
    private final Collection<C0653h> f3753m;

    /* compiled from: IdManager */
    public enum C1492a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        public final int f3740h;

        private C1492a(int i) {
            this.f3740h = i;
        }
    }

    public C1493o(Context context, String str, String str2, Collection<C0653h> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.f3750j = context;
            this.f3751k = str;
            this.f3752l = str2;
            this.f3753m = collection;
            this.f3747g = new C1495p();
            this.f3743a = new C1472c(context);
            this.f3748h = C1482i.m5659a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f3748h) {
                C1457c.m5546h().mo811a("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.f3749i = C1482i.m5659a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.f3749i) {
                C1457c.m5546h().mo811a("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        }
    }

    public boolean m5695a() {
        return this.f3749i;
    }

    private String m5692a(String str) {
        return str == null ? null : f3741d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String m5696b() {
        String str = this.f3752l;
        if (str != null) {
            return str;
        }
        SharedPreferences a = C1482i.m5642a(this.f3750j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m5691a(a);
        }
        return str;
    }

    public String m5697c() {
        return this.f3751k;
    }

    public String m5698d() {
        return m5699e() + "/" + m5700f();
    }

    public String m5699e() {
        return m5694b(VERSION.RELEASE);
    }

    public String m5700f() {
        return m5694b(VERSION.INCREMENTAL);
    }

    public String m5701g() {
        return String.format(Locale.US, "%s/%s", new Object[]{m5694b(Build.MANUFACTURER), m5694b(Build.MODEL)});
    }

    private String m5694b(String str) {
        return str.replaceAll(f3742e, "");
    }

    public String m5702h() {
        String str = "";
        if (!this.f3748h) {
            return str;
        }
        str = m5708n();
        if (str != null) {
            return str;
        }
        SharedPreferences a = C1482i.m5642a(this.f3750j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m5691a(a);
        }
        return str;
    }

    private String m5691a(SharedPreferences sharedPreferences) {
        this.f3746f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m5692a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.f3746f.unlock();
            return string;
        } catch (Throwable th) {
            this.f3746f.unlock();
        }
    }

    public Map<C1492a, String> m5703i() {
        Map hashMap = new HashMap();
        for (C0653h c0653h : this.f3753m) {
            if (c0653h instanceof C0676m) {
                for (Entry entry : ((C0676m) c0653h).getDeviceIdentifiers().entrySet()) {
                    m5693a(hashMap, (C1492a) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m5693a(hashMap, C1492a.ANDROID_ID, m5708n());
        m5693a(hashMap, C1492a.ANDROID_ADVERTISING_ID, m5707m());
        return Collections.unmodifiableMap(hashMap);
    }

    public String m5704j() {
        return this.f3747g.m5710a(this.f3750j);
    }

    synchronized C1470b m5705k() {
        if (!this.f3745c) {
            this.f3744b = this.f3743a.m5616a();
            this.f3745c = true;
        }
        return this.f3744b;
    }

    public Boolean m5706l() {
        if (!this.f3748h) {
            return null;
        }
        C1470b k = m5705k();
        if (k != null) {
            return Boolean.valueOf(k.f3690b);
        }
        return null;
    }

    public String m5707m() {
        if (!this.f3748h) {
            return null;
        }
        C1470b k = m5705k();
        if (k != null) {
            return k.f3689a;
        }
        return null;
    }

    private void m5693a(Map<C1492a, String> map, C1492a c1492a, String str) {
        if (str != null) {
            map.put(c1492a, str);
        }
    }

    public String m5708n() {
        if (!this.f3748h) {
            return null;
        }
        String string = Secure.getString(this.f3750j.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return m5692a(string);
    }
}
