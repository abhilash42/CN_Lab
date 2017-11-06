package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1075e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class C1151u extends ab {

    interface C1148a {
        void mo758a(int i, Throwable th, byte[] bArr);
    }

    private static class C1149b implements Runnable {
        private final C1148a f2421a;
        private final int f2422b;
        private final Throwable f2423c;
        private final byte[] f2424d;

        private C1149b(C1148a c1148a, int i, Throwable th, byte[] bArr) {
            this.f2421a = c1148a;
            this.f2422b = i;
            this.f2423c = th;
            this.f2424d = bArr;
        }

        public void run() {
            this.f2421a.mo758a(this.f2422b, this.f2423c, this.f2424d);
        }
    }

    private class C1150c implements Runnable {
        final /* synthetic */ C1151u f2425a;
        private final URL f2426b;
        private final byte[] f2427c;
        private final C1148a f2428d;

        public C1150c(C1151u c1151u, URL url, byte[] bArr, C1148a c1148a) {
            this.f2425a = c1151u;
            this.f2426b = url;
            this.f2427c = bArr;
            this.f2428d = c1148a;
        }

        public void run() {
            Throwable e;
            int i;
            Throwable th;
            this.f2425a.mo735d();
            int i2 = 0;
            HttpURLConnection a;
            OutputStream outputStream;
            try {
                byte[] a2 = this.f2425a.mo741j().m4222a(this.f2427c);
                a = this.f2425a.m4422a(this.f2426b);
                try {
                    a.setDoOutput(true);
                    a.addRequestProperty("Content-Encoding", "gzip");
                    a.setFixedLengthStreamingMode(a2.length);
                    a.connect();
                    outputStream = a.getOutputStream();
                } catch (IOException e2) {
                    e = e2;
                    i = i2;
                    outputStream = null;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            this.f2425a.mo743l().m4399b().m4388a("Error closing HTTP compressed POST connection output stream", e3);
                        }
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f2425a.mo742k().m4478a(new C1149b(this.f2428d, i, e, null));
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e32) {
                            this.f2425a.mo743l().m4399b().m4388a("Error closing HTTP compressed POST connection output stream", e32);
                        }
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f2425a.mo742k().m4478a(new C1149b(this.f2428d, i2, null, null));
                    throw th;
                }
                try {
                    outputStream.write(a2);
                    outputStream.close();
                    outputStream = null;
                    i2 = a.getResponseCode();
                    a2 = this.f2425a.m4421a(a);
                    if (null != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e322) {
                            this.f2425a.mo743l().m4399b().m4388a("Error closing HTTP compressed POST connection output stream", e322);
                        }
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f2425a.mo742k().m4478a(new C1149b(this.f2428d, i2, null, a2));
                } catch (IOException e4) {
                    e = e4;
                    i = 0;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f2425a.mo742k().m4478a(new C1149b(this.f2428d, i, e, null));
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f2425a.mo742k().m4478a(new C1149b(this.f2428d, i2, null, null));
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                i = 0;
                outputStream = null;
                a = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f2425a.mo742k().m4478a(new C1149b(this.f2428d, i, e, null));
            } catch (Throwable th22) {
                th = th22;
                a = null;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f2425a.mo742k().m4478a(new C1149b(this.f2428d, i2, null, null));
                throw th;
            }
        }
    }

    public C1151u(C1164y c1164y) {
        super(c1164y);
    }

    private byte[] m4421a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected HttpURLConnection m4422a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout((int) mo745n().m4282v());
            httpURLConnection.setReadTimeout((int) mo745n().m4283w());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    protected void mo733a() {
    }

    public void m4424a(URL url, byte[] bArr, C1148a c1148a) {
        mo736e();
        m4091y();
        C1032p.m3678a((Object) url);
        C1032p.m3678a((Object) bArr);
        C1032p.m3678a((Object) c1148a);
        mo742k().m4479b(new C1150c(this, url, bArr, c1148a));
    }

    public boolean m4425b() {
        NetworkInfo activeNetworkInfo;
        m4091y();
        try {
            activeNetworkInfo = ((ConnectivityManager) mo740i().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public /* bridge */ /* synthetic */ void mo734c() {
        super.mo734c();
    }

    public /* bridge */ /* synthetic */ void mo735d() {
        super.mo735d();
    }

    public /* bridge */ /* synthetic */ void mo736e() {
        super.mo736e();
    }

    public /* bridge */ /* synthetic */ C1142r mo737f() {
        return super.mo737f();
    }

    public /* bridge */ /* synthetic */ ae mo738g() {
        return super.mo738g();
    }

    public /* bridge */ /* synthetic */ C1075e mo739h() {
        return super.mo739h();
    }

    public /* bridge */ /* synthetic */ Context mo740i() {
        return super.mo740i();
    }

    public /* bridge */ /* synthetic */ C1126f mo741j() {
        return super.mo741j();
    }

    public /* bridge */ /* synthetic */ C1161x mo742k() {
        return super.mo742k();
    }

    public /* bridge */ /* synthetic */ C1146t mo743l() {
        return super.mo743l();
    }

    public /* bridge */ /* synthetic */ C1157w mo744m() {
        return super.mo744m();
    }

    public /* bridge */ /* synthetic */ C1128h mo745n() {
        return super.mo745n();
    }
}
