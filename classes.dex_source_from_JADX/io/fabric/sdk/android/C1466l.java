package io.fabric.sdk.android;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.network.C1571b;
import io.fabric.sdk.android.services.p020b.C1479g;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1487l;
import io.fabric.sdk.android.services.p022e.C1538d;
import io.fabric.sdk.android.services.p022e.C1539e;
import io.fabric.sdk.android.services.p022e.C1542h;
import io.fabric.sdk.android.services.p022e.C1551n;
import io.fabric.sdk.android.services.p022e.C1556q;
import io.fabric.sdk.android.services.p022e.C1558t;
import io.fabric.sdk.android.services.p022e.C1561y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: Onboarding */
class C1466l extends C0653h<Boolean> {
    private final C1570d f3676a = new C1571b();
    private PackageManager f3677b;
    private String f3678c;
    private PackageInfo f3679d;
    private String f3680e;
    private String f3681f;
    private String f3682g;
    private String f3683h;
    private String f3684i;
    private final Future<Map<String, C1465j>> f3685j;
    private final Collection<C0653h> f3686k;

    protected /* synthetic */ Object doInBackground() {
        return m5600a();
    }

    public C1466l(Future<Map<String, C1465j>> future, Collection<C0653h> collection) {
        this.f3685j = future;
        this.f3686k = collection;
    }

    public String getVersion() {
        return "1.3.14.143";
    }

    protected boolean onPreExecute() {
        try {
            this.f3682g = getIdManager().m5704j();
            this.f3677b = getContext().getPackageManager();
            this.f3678c = getContext().getPackageName();
            this.f3679d = this.f3677b.getPackageInfo(this.f3678c, 0);
            this.f3680e = Integer.toString(this.f3679d.versionCode);
            this.f3681f = this.f3679d.versionName == null ? "0.0" : this.f3679d.versionName;
            this.f3683h = this.f3677b.getApplicationLabel(getContext().getApplicationInfo()).toString();
            this.f3684i = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            C1457c.m5546h().mo819e("Fabric", "Failed init", e);
            return false;
        }
    }

    protected Boolean m5600a() {
        boolean a;
        String k = C1482i.m5677k(getContext());
        C1558t c = m5598c();
        if (c != null) {
            try {
                Map map;
                if (this.f3685j != null) {
                    map = (Map) this.f3685j.get();
                } else {
                    map = new HashMap();
                }
                a = m5596a(k, c.f3900a, m5601a(map, this.f3686k).values());
            } catch (Throwable e) {
                C1457c.m5546h().mo819e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a);
        }
        a = false;
        return Boolean.valueOf(a);
    }

    private C1558t m5598c() {
        try {
            C1556q.m5839a().m5841a(this, this.idManager, this.f3676a, this.f3680e, this.f3681f, m5602b()).m5844c();
            return C1556q.m5839a().m5843b();
        } catch (Throwable e) {
            C1457c.m5546h().mo819e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, C1465j> m5601a(Map<String, C1465j> map, Collection<C0653h> collection) {
        for (C0653h c0653h : collection) {
            if (!map.containsKey(c0653h.getIdentifier())) {
                map.put(c0653h.getIdentifier(), new C1465j(c0653h.getIdentifier(), c0653h.getVersion(), "binary"));
            }
        }
        return map;
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean m5596a(String str, C1539e c1539e, Collection<C1465j> collection) {
        if ("new".equals(c1539e.f3855b)) {
            if (m5597b(str, c1539e, collection)) {
                return C1556q.m5839a().m5845d();
            }
            C1457c.m5546h().mo819e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(c1539e.f3855b)) {
            return C1556q.m5839a().m5845d();
        } else {
            if (!c1539e.f3858e) {
                return true;
            }
            C1457c.m5546h().mo811a("Fabric", "Server says an update is required - forcing a full App update.");
            m5599c(str, c1539e, collection);
            return true;
        }
    }

    private boolean m5597b(String str, C1539e c1539e, Collection<C1465j> collection) {
        return new C1542h(this, m5602b(), c1539e.f3856c, this.f3676a).mo846a(m5594a(C1551n.m5837a(getContext(), str), (Collection) collection));
    }

    private boolean m5599c(String str, C1539e c1539e, Collection<C1465j> collection) {
        return m5595a(c1539e, C1551n.m5837a(getContext(), str), (Collection) collection);
    }

    private boolean m5595a(C1539e c1539e, C1551n c1551n, Collection<C1465j> collection) {
        return new C1561y(this, m5602b(), c1539e.f3856c, this.f3676a).mo846a(m5594a(c1551n, (Collection) collection));
    }

    private C1538d m5594a(C1551n c1551n, Collection<C1465j> collection) {
        return new C1538d(new C1479g().m5631a(getContext()), getIdManager().m5697c(), this.f3681f, this.f3680e, C1482i.m5651a(C1482i.m5679m(r0)), this.f3683h, C1487l.m5684a(this.f3682g).m5685a(), this.f3684i, "0", c1551n, collection);
    }

    String m5602b() {
        return C1482i.m5664b(getContext(), "com.crashlytics.ApiEndpoint");
    }
}
