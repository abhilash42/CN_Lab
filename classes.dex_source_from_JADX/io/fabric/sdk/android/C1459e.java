package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.p020b.C1482i;
import java.io.Closeable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: FabricKitsFinder */
class C1459e implements Callable<Map<String, C1465j>> {
    final String f3656a;

    public /* synthetic */ Object call() {
        return m5561a();
    }

    C1459e(String str) {
        this.f3656a = str;
    }

    public Map<String, C1465j> m5561a() {
        Map<String, C1465j> hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ZipFile b = m5562b();
        Enumeration entries = b.entries();
        int i = 0;
        while (entries.hasMoreElements()) {
            int i2 = i + 1;
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > "fabric/".length()) {
                C1465j a = m5560a(zipEntry, b);
                if (a != null) {
                    hashMap.put(a.m5591a(), a);
                    C1457c.m5546h().mo814b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.m5591a(), a.m5592b()}));
                }
            }
            i = i2;
        }
        if (b != null) {
            try {
                b.close();
            } catch (IOException e) {
            }
        }
        C1457c.m5546h().mo814b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " reading:" + i);
        return hashMap;
    }

    private C1465j m5560a(ZipEntry zipEntry, ZipFile zipFile) {
        Closeable inputStream;
        Throwable e;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                C1465j c1465j = new C1465j(property, property2, property3);
                C1482i.m5655a(inputStream);
                return c1465j;
            } catch (IOException e2) {
                e = e2;
                try {
                    C1457c.m5546h().mo819e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    C1482i.m5655a(inputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    C1482i.m5655a(inputStream);
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            C1457c.m5546h().mo819e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
            C1482i.m5655a(inputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            inputStream = null;
            C1482i.m5655a(inputStream);
            throw e;
        }
    }

    protected ZipFile m5562b() {
        return new ZipFile(this.f3656a);
    }
}
