package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

public class HttpRequest {
    private static final String[] f3929b = new String[0];
    private static C1565b f3930c = C1565b.f3927a;
    public final URL f3931a;
    private HttpURLConnection f3932d = null;
    private final String f3933e;
    private C1567d f3934f;
    private boolean f3935g;
    private boolean f3936h = true;
    private boolean f3937i = false;
    private int f3938j = 8192;
    private String f3939k;
    private int f3940l;

    protected static abstract class C1562c<V> implements Callable<V> {
        protected abstract V mo854b();

        protected abstract void mo853c();

        protected C1562c() {
        }

        public V call() {
            Throwable th;
            Object obj = 1;
            try {
                V b = mo854b();
                try {
                    mo853c();
                    return b;
                } catch (IOException e) {
                    throw new HttpRequestException(e);
                }
            } catch (HttpRequestException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new HttpRequestException(e3);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                mo853c();
            } catch (IOException e4) {
                if (obj == null) {
                    throw new HttpRequestException(e4);
                }
            }
            throw th;
        }
    }

    protected static abstract class C1563a<V> extends C1562c<V> {
        private final Closeable f3922a;
        private final boolean f3923b;

        protected C1563a(Closeable closeable, boolean z) {
            this.f3922a = closeable;
            this.f3923b = z;
        }

        protected void mo853c() {
            if (this.f3922a instanceof Flushable) {
                ((Flushable) this.f3922a).flush();
            }
            if (this.f3923b) {
                try {
                    this.f3922a.close();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.f3922a.close();
        }
    }

    public static class HttpRequestException extends RuntimeException {
        public /* synthetic */ Throwable getCause() {
            return m5853a();
        }

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        public IOException m5853a() {
            return (IOException) super.getCause();
        }
    }

    public interface C1565b {
        public static final C1565b f3927a = new C15661();

        static class C15661 implements C1565b {
            C15661() {
            }

            public HttpURLConnection mo855a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            public HttpURLConnection mo856a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        HttpURLConnection mo855a(URL url);

        HttpURLConnection mo856a(URL url, Proxy proxy);
    }

    public static class C1567d extends BufferedOutputStream {
        private final CharsetEncoder f3928a;

        public C1567d(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f3928a = Charset.forName(HttpRequest.m5871f(str)).newEncoder();
        }

        public C1567d m5858a(String str) {
            ByteBuffer encode = this.f3928a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    private static String m5871f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static StringBuilder m5863a(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    private static StringBuilder m5866b(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static String m5861a(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String toASCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = toASCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < toASCIIString.length()) {
                    toASCIIString = toASCIIString.substring(0, indexOf + 1) + toASCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return toASCIIString;
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static String m5862a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        m5863a(charSequence2, stringBuilder);
        m5866b(charSequence2, stringBuilder);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static HttpRequest m5864b(CharSequence charSequence) {
        return new HttpRequest(charSequence, "GET");
    }

    public static HttpRequest m5860a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m5862a(charSequence, (Map) map);
        if (z) {
            a = m5861a(a);
        }
        return m5864b(a);
    }

    public static HttpRequest m5867c(CharSequence charSequence) {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest m5865b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m5862a(charSequence, (Map) map);
        if (z) {
            a = m5861a(a);
        }
        return m5867c(a);
    }

    public static HttpRequest m5868d(CharSequence charSequence) {
        return new HttpRequest(charSequence, "PUT");
    }

    public static HttpRequest m5869e(CharSequence charSequence) {
        return new HttpRequest(charSequence, "DELETE");
    }

    public HttpRequest(CharSequence charSequence, String str) {
        try {
            this.f3931a = new URL(charSequence.toString());
            this.f3933e = str;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    private Proxy m5872q() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f3939k, this.f3940l));
    }

    private HttpURLConnection m5873r() {
        try {
            HttpURLConnection a;
            if (this.f3939k != null) {
                a = f3930c.mo856a(this.f3931a, m5872q());
            } else {
                a = f3930c.mo855a(this.f3931a);
            }
            a.setRequestMethod(this.f3933e);
            return a;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        return m5912p() + ' ' + m5911o();
    }

    public HttpURLConnection m5887a() {
        if (this.f3932d == null) {
            this.f3932d = m5873r();
        }
        return this.f3932d;
    }

    public int m5888b() {
        try {
            m5907k();
            return m5887a().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public boolean m5894c() {
        return 200 == m5888b();
    }

    protected ByteArrayOutputStream m5897d() {
        int j = m5906j();
        if (j > 0) {
            return new ByteArrayOutputStream(j);
        }
        return new ByteArrayOutputStream();
    }

    public String m5886a(String str) {
        OutputStream d = m5897d();
        try {
            m5876a(m5902f(), d);
            return d.toString(m5871f(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String m5899e() {
        return m5886a(m5904h());
    }

    public BufferedInputStream m5902f() {
        return new BufferedInputStream(m5903g(), this.f3938j);
    }

    public InputStream m5903g() {
        if (m5888b() < 400) {
            try {
                InputStream inputStream = m5887a().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        }
        inputStream = m5887a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = m5887a().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        }
        if (!this.f3937i || !"gzip".equals(m5905i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new HttpRequestException(e22);
        }
    }

    public HttpRequest m5875a(int i) {
        m5887a().setConnectTimeout(i);
        return this;
    }

    public HttpRequest m5878a(String str, String str2) {
        m5887a().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest m5884a(Entry<String, String> entry) {
        return m5878a((String) entry.getKey(), (String) entry.getValue());
    }

    public String m5890b(String str) {
        m5908l();
        return m5887a().getHeaderField(str);
    }

    public int m5892c(String str) {
        return m5874a(str, -1);
    }

    public int m5874a(String str, int i) {
        m5908l();
        return m5887a().getHeaderFieldInt(str, i);
    }

    public String m5891b(String str, String str2) {
        return m5893c(m5890b(str), str2);
    }

    protected String m5893c(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length) {
            return null;
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = indexOf;
            indexOf = length;
        } else {
            int i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        while (indexOf2 < indexOf) {
            int indexOf3 = str.indexOf(61, indexOf2);
            if (indexOf3 != -1 && indexOf3 < indexOf && str2.equals(str.substring(indexOf2, indexOf3).trim())) {
                String trim = str.substring(indexOf3 + 1, indexOf).trim();
                indexOf3 = trim.length();
                if (indexOf3 != 0) {
                    if (indexOf3 > 2 && '\"' == trim.charAt(0) && '\"' == trim.charAt(indexOf3 - 1)) {
                        return trim.substring(1, indexOf3 - 1);
                    }
                    return trim;
                }
            }
            indexOf++;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length;
            }
            i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        return null;
    }

    public String m5904h() {
        return m5891b("Content-Type", "charset");
    }

    public HttpRequest m5885a(boolean z) {
        m5887a().setUseCaches(z);
        return this;
    }

    public String m5905i() {
        return m5890b("Content-Encoding");
    }

    public HttpRequest m5895d(String str) {
        return m5896d(str, null);
    }

    public HttpRequest m5896d(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return m5878a("Content-Type", str);
        }
        String str3 = "; charset=";
        return m5878a("Content-Type", str + "; charset=" + str2);
    }

    public int m5906j() {
        return m5892c("Content-Length");
    }

    protected HttpRequest m5876a(InputStream inputStream, OutputStream outputStream) {
        final InputStream inputStream2 = inputStream;
        final OutputStream outputStream2 = outputStream;
        return (HttpRequest) new C1563a<HttpRequest>(this, inputStream, this.f3936h) {
            final /* synthetic */ HttpRequest f3926c;

            public /* synthetic */ Object mo854b() {
                return m5851a();
            }

            public HttpRequest m5851a() {
                byte[] bArr = new byte[this.f3926c.f3938j];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        return this.f3926c;
                    }
                    outputStream2.write(bArr, 0, read);
                }
            }
        }.call();
    }

    protected HttpRequest m5907k() {
        if (this.f3934f != null) {
            if (this.f3935g) {
                this.f3934f.m5858a("\r\n--00content0boundary00--\r\n");
            }
            if (this.f3936h) {
                try {
                    this.f3934f.close();
                } catch (IOException e) {
                }
            } else {
                this.f3934f.close();
            }
            this.f3934f = null;
        }
        return this;
    }

    protected HttpRequest m5908l() {
        try {
            return m5907k();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest m5909m() {
        if (this.f3934f == null) {
            m5887a().setDoOutput(true);
            this.f3934f = new C1567d(m5887a().getOutputStream(), m5893c(m5887a().getRequestProperty("Content-Type"), "charset"), this.f3938j);
        }
        return this;
    }

    protected HttpRequest m5910n() {
        if (this.f3935g) {
            this.f3934f.m5858a("\r\n--00content0boundary00\r\n");
        } else {
            this.f3935g = true;
            m5895d("multipart/form-data; boundary=00content0boundary00").m5909m();
            this.f3934f.m5858a("--00content0boundary00\r\n");
        }
        return this;
    }

    protected HttpRequest m5880a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"").append(str2);
        }
        stringBuilder.append('\"');
        m5901f("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            m5901f("Content-Type", str3);
        }
        return m5900f((CharSequence) "\r\n");
    }

    public HttpRequest m5898e(String str, String str2) {
        return m5889b(str, null, str2);
    }

    public HttpRequest m5889b(String str, String str2, String str3) {
        return m5883a(str, str2, null, str3);
    }

    public HttpRequest m5883a(String str, String str2, String str3, String str4) {
        try {
            m5910n();
            m5880a(str, str2, str3);
            this.f3934f.m5858a(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m5877a(String str, Number number) {
        return m5879a(str, null, number);
    }

    public HttpRequest m5879a(String str, String str2, Number number) {
        return m5889b(str, str2, number != null ? number.toString() : null);
    }

    public HttpRequest m5881a(String str, String str2, String str3, File file) {
        InputStream bufferedInputStream;
        IOException e;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                HttpRequest a = m5882a(str, str2, str3, bufferedInputStream);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return a;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new HttpRequestException(e);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            throw new HttpRequestException(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public HttpRequest m5882a(String str, String str2, String str3, InputStream inputStream) {
        try {
            m5910n();
            m5880a(str, str2, str3);
            m5876a(inputStream, this.f3934f);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m5901f(String str, String str2) {
        return m5900f((CharSequence) str).m5900f((CharSequence) ": ").m5900f((CharSequence) str2).m5900f((CharSequence) "\r\n");
    }

    public HttpRequest m5900f(CharSequence charSequence) {
        try {
            m5909m();
            this.f3934f.m5858a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public URL m5911o() {
        return m5887a().getURL();
    }

    public String m5912p() {
        return m5887a().getRequestMethod();
    }
}
