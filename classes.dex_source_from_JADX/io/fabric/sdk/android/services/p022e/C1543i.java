package io.fabric.sdk.android.services.p022e;

import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p037d.C1532b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

/* compiled from: DefaultCachedSettingsIo */
class C1543i implements C1541g {
    private final C0653h f3862a;

    public C1543i(C0653h c0653h) {
        this.f3862a = c0653h;
    }

    public JSONObject mo847a() {
        Throwable e;
        Closeable closeable = null;
        C1457c.m5546h().mo811a("Fabric", "Reading cached settings...");
        Closeable fileInputStream;
        try {
            JSONObject jSONObject;
            File file = new File(new C1532b(this.f3862a).mo842a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(C1482i.m5645a((InputStream) fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C1457c.m5546h().mo819e("Fabric", "Failed to fetch cached settings", e);
                        C1482i.m5656a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        C1482i.m5656a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            C1457c.m5546h().mo811a("Fabric", "No cached settings found.");
            jSONObject = null;
            C1482i.m5656a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C1457c.m5546h().mo819e("Fabric", "Failed to fetch cached settings", e);
            C1482i.m5656a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            C1482i.m5656a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    public void mo848a(long j, JSONObject jSONObject) {
        Throwable e;
        C1457c.m5546h().mo811a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            Closeable fileWriter;
            try {
                jSONObject.put("expires_at", j);
                fileWriter = new FileWriter(new File(new C1532b(this.f3862a).mo842a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    C1482i.m5656a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C1457c.m5546h().mo819e("Fabric", "Failed to cache settings", e);
                        C1482i.m5656a(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileWriter;
                        C1482i.m5656a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
                C1457c.m5546h().mo819e("Fabric", "Failed to cache settings", e);
                C1482i.m5656a(fileWriter, "Failed to close settings writer.");
            } catch (Throwable th2) {
                e = th2;
                C1482i.m5656a(closeable, "Failed to close settings writer.");
                throw e;
            }
        }
    }
}
