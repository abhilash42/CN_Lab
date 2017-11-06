package in.juspay.mystique;

import io.fabric.sdk.android.services.p020b.C0671a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class RestClient {
    private static final String f2518a = RestClient.class.getName();
    private static DefaultHttpClient f2519b;
    private static DefaultHttpClient f2520c;

    public static class UnsuccessfulRestCall extends RuntimeException {
        private final HttpResponse f2516a;
        private final HttpRequestBase f2517b;

        public UnsuccessfulRestCall(HttpRequestBase httpRequestBase, HttpResponse httpResponse) {
            super(httpRequestBase.getURI() + " returned " + httpResponse.getStatusLine().getStatusCode());
            this.f2516a = httpResponse;
            this.f2517b = httpRequestBase;
        }
    }

    static {
        m4548a();
    }

    private static DefaultHttpClient m4547a(HttpParams httpParams) {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        SocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        socketFactory.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        schemeRegistry.register(new Scheme("https", socketFactory, 443));
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
    }

    public static void m4548a() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, C0671a.DEFAULT_TIMEOUT);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        f2519b = m4547a(basicHttpParams);
        basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 5000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, C0671a.DEFAULT_TIMEOUT);
        f2520c = m4547a(basicHttpParams);
    }

    public static byte[] m4550a(String str, String str2, HashMap<String, String> hashMap) {
        HttpRequestBase httpPost = new HttpPost(str);
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                httpPost.setHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        httpPost.setEntity(new ByteArrayEntity(str2.getBytes("UTF-8")));
        return m4552a(httpPost);
    }

    private static byte[] m4553a(HttpRequestBase httpRequestBase, HttpResponse httpResponse) {
        GZIPInputStream gZIPInputStream;
        try {
            if (m4549a(httpResponse)) {
                Header contentEncoding = httpResponse.getEntity().getContentEncoding();
                if (contentEncoding == null || !contentEncoding.getValue().equals("gzip")) {
                    return EntityUtils.toByteArray(httpResponse.getEntity());
                }
                gZIPInputStream = new GZIPInputStream(httpResponse.getEntity().getContent());
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                if (gZIPInputStream == null) {
                    return bArr;
                }
                gZIPInputStream.close();
                return bArr;
            }
            throw new UnsuccessfulRestCall(httpRequestBase, httpResponse);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ClientProtocolException e2) {
            throw new RuntimeException(e2.getMessage());
        } catch (Throwable th) {
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
        }
    }

    private static byte[] m4552a(HttpRequestBase httpRequestBase) {
        try {
            httpRequestBase.setHeader("Accept-Encoding", "gzip");
            return m4553a(httpRequestBase, f2519b.execute(httpRequestBase));
        } catch (IOException e) {
            return null;
        }
    }

    private static boolean m4549a(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return statusCode >= 200 && statusCode < 300;
    }

    public static byte[] m4551a(String str, Map<String, String> map) {
        HttpRequestBase httpGet = new HttpGet();
        for (Entry entry : map.entrySet()) {
            httpGet.setHeader((String) entry.getKey(), (String) entry.getValue());
        }
        httpGet.setURI(URI.create(str));
        HttpResponse execute = f2519b.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() == 200) {
            return m4553a(httpGet, execute);
        }
        if (execute.getStatusLine().getStatusCode() == 304) {
            return null;
        }
        return null;
    }
}
