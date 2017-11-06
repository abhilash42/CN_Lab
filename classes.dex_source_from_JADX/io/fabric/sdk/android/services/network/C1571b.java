package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.C1451k;
import io.fabric.sdk.android.C1452b;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: DefaultHttpRequestFactory */
public class C1571b implements C1570d {
    private final C1451k f3942a;
    private C0701f f3943b;
    private SSLSocketFactory f3944c;
    private boolean f3945d;

    public C1571b() {
        this(new C1452b());
    }

    public C1571b(C1451k c1451k) {
        this.f3942a = c1451k;
    }

    public void mo859a(C0701f c0701f) {
        if (this.f3943b != c0701f) {
            this.f3943b = c0701f;
            m5918a();
        }
    }

    private synchronized void m5918a() {
        this.f3945d = false;
        this.f3944c = null;
    }

    public HttpRequest mo857a(C1572c c1572c, String str) {
        return mo858a(c1572c, str, Collections.emptyMap());
    }

    public HttpRequest mo858a(C1572c c1572c, String str, Map<String, String> map) {
        HttpRequest a;
        switch (c1572c) {
            case GET:
                a = HttpRequest.m5860a((CharSequence) str, (Map) map, true);
                break;
            case POST:
                a = HttpRequest.m5865b((CharSequence) str, (Map) map, true);
                break;
            case PUT:
                a = HttpRequest.m5868d((CharSequence) str);
                break;
            case DELETE:
                a = HttpRequest.m5869e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m5919a(str) && this.f3943b != null) {
            SSLSocketFactory b = m5920b();
            if (b != null) {
                ((HttpsURLConnection) a.m5887a()).setSSLSocketFactory(b);
            }
        }
        return a;
    }

    private boolean m5919a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory m5920b() {
        if (this.f3944c == null && !this.f3945d) {
            this.f3944c = m5921c();
        }
        return this.f3944c;
    }

    private synchronized SSLSocketFactory m5921c() {
        SSLSocketFactory a;
        this.f3945d = true;
        try {
            a = C1573e.m5925a(this.f3943b);
            this.f3942a.mo811a("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.f3942a.mo819e("Fabric", "Exception while validating pinned certs", e);
            a = null;
        }
        return a;
    }
}
