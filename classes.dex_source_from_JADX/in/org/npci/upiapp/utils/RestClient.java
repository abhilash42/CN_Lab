package in.org.npci.upiapp.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import in.org.npci.upiapp.HomeActivity;
import in.org.npci.upiapp.models.ApiResponse;
import in.org.npci.upiapp.p036a.C1380a;
import io.fabric.sdk.android.services.p020b.C0671a;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class RestClient {
    private static final String f3560a = RestClient.class.getName();
    private static DefaultHttpClient f3561b;
    private static DefaultHttpClient f3562c;

    static class C14321 implements RedirectHandler {
        C14321() {
        }

        public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
            return false;
        }

        public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
            return null;
        }
    }

    static class C14332 implements RedirectHandler {
        C14332() {
        }

        public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
            return false;
        }

        public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
            return null;
        }
    }

    static class C14343 implements Runnable {
        C14343() {
        }

        public void run() {
            HomeActivity.m5212p();
        }
    }

    public static class UnsuccessfulRestCall extends RuntimeException {
    }

    private static DefaultHttpClient m5434a(HttpParams httpParams) {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("https", new C1446i(), 443));
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
    }

    private static DefaultHttpClient m5433a(Context context, HttpParams httpParams) {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        schemeRegistry.register(new Scheme("https", m5440b(context), 443));
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
    }

    private static SSLSocketFactory m5440b(Context context) {
        InputStream openRawResource;
        try {
            KeyStore instance = KeyStore.getInstance("BKS");
            openRawResource = context.getResources().openRawResource(2131099648);
            instance.load(openRawResource, "fv#EWU}v8VRxF7X'".toCharArray());
            openRawResource.close();
            SSLSocketFactory sSLSocketFactory = new SSLSocketFactory(instance);
            sSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            return sSLSocketFactory;
        } catch (Exception e) {
            throw new AssertionError(e);
        } catch (Throwable th) {
            openRawResource.close();
        }
    }

    public static void m5435a(Context context) {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, C0671a.DEFAULT_TIMEOUT);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        f3561b = m5434a(basicHttpParams);
        basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        f3562c = m5433a(context, basicHttpParams);
        f3562c.setRedirectHandler(new C14321());
        f3561b.setRedirectHandler(new C14332());
    }

    public static ApiResponse m5427a(String str, HashMap<String, String> hashMap, boolean z) {
        HttpRequestBase httpGet = new HttpGet(str);
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                httpGet.setHeader((String) entry.getKey(), (String) entry.getValue());
                C1380a.m5275a(f3560a, "RestClientHeader : Header -> " + entry.getKey() + "=>" + entry.getValue());
            }
        }
        return m5430a(httpGet, z);
    }

    public static ApiResponse m5428a(String str, Map<String, String> map, HashMap<String, String> hashMap, boolean z) {
        try {
            return m5427a(str, (HashMap) hashMap, z);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static ApiResponse m5438b(String str, HashMap<String, String> hashMap, boolean z) {
        HttpRequestBase httpDelete = new HttpDelete(str);
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                httpDelete.setHeader((String) entry.getKey(), (String) entry.getValue());
                C1380a.m5275a(f3560a, "RestClientHeader : Header -> " + entry.getKey() + "=>" + entry.getValue());
            }
        }
        return m5430a(httpDelete, z);
    }

    public static ApiResponse m5439b(String str, Map<String, String> map, HashMap<String, String> hashMap, boolean z) {
        try {
            C1380a.m5275a("URL", str);
            C1380a.m5275a("PARAMETER", m5431a((Map) map));
            return m5438b(str, hashMap, z);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String m5431a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map.size() > 0) {
            stringBuilder.append("?");
        }
        for (Entry entry : map.entrySet()) {
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            if (entry.getValue() == null) {
                stringBuilder.append("");
            } else {
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), "utf-8"));
            }
            stringBuilder.append("&");
        }
        return stringBuilder.toString();
    }

    private static ApiResponse m5429a(HttpRequestBase httpRequestBase, HttpResponse httpResponse) {
        GZIPInputStream gZIPInputStream;
        try {
            ApiResponse apiResponse;
            if (m5437a(httpResponse)) {
                apiResponse = new ApiResponse();
                apiResponse.setStatusCode(httpResponse.getStatusLine().getStatusCode());
                Header contentEncoding = httpResponse.getEntity().getContentEncoding();
                if (contentEncoding == null || !contentEncoding.getValue().equals("gzip")) {
                    apiResponse.setData(EntityUtils.toByteArray(httpResponse.getEntity()));
                } else {
                    C1380a.m5275a(f3560a, "GZIP Header Present");
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
                    apiResponse.setData(byteArrayOutputStream.toByteArray());
                    if (gZIPInputStream != null) {
                        C1380a.m5275a(f3560a, "CLOSING GZIP STREAM");
                        gZIPInputStream.close();
                    }
                }
            } else {
                apiResponse = new ApiResponse();
                apiResponse.setStatusCode(httpResponse.getStatusLine().getStatusCode());
                apiResponse.setData(null);
            }
            return apiResponse;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ClientProtocolException e2) {
            throw new RuntimeException(e2.getMessage());
        } catch (Throwable th) {
            if (gZIPInputStream != null) {
                C1380a.m5275a(f3560a, "CLOSING GZIP STREAM");
                gZIPInputStream.close();
            }
        }
    }

    private static String m5432a(Header[] headerArr) {
        for (Header header : headerArr) {
            if ("Location".equals(header.getName())) {
                return header.getValue();
            }
        }
        return null;
    }

    private static boolean m5436a(String str) {
        return str.indexOf("https://upi.npci.org.in") == 0;
    }

    private static ApiResponse m5430a(HttpRequestBase httpRequestBase, boolean z) {
        C1380a.m5275a(f3560a, "Executing " + httpRequestBase.getMethod() + " " + httpRequestBase.getURI());
        String a;
        try {
            HttpResponse execute;
            httpRequestBase.setHeader("Accept-Encoding", "gzip");
            if (z) {
                execute = f3562c.execute(httpRequestBase);
                if (execute.getStatusLine() != null && 301 == execute.getStatusLine().getStatusCode()) {
                    a = m5432a(execute.getAllHeaders());
                    if (a != null) {
                        execute = m5436a(a) ? f3562c.execute(new HttpGet(a)) : f3561b.execute(new HttpGet(a));
                    } else {
                        throw new Exception("No location in redirect");
                    }
                }
            }
            execute = f3561b.execute(httpRequestBase);
            C1380a.m5275a(f3560a, "Got response for " + httpRequestBase.getURI() + ", response code " + execute.getStatusLine().getStatusCode());
            return m5429a(httpRequestBase, execute);
        } catch (SSLHandshakeException e) {
            a = e.getMessage();
            if (a != null) {
                C1380a.m5279b(f3560a, a);
                if (a.contains("java.security.cert.CertPathValidatorException")) {
                    new Handler(Looper.getMainLooper()).post(new C14343());
                }
            }
            return null;
        } catch (Throwable e2) {
            Throwable th = e2;
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setStatusCode(-1);
            apiResponse.setData(th.getMessage().getBytes("UTF-8"));
            C1380a.m5278a(th);
            return apiResponse;
        }
    }

    private static boolean m5437a(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return statusCode >= 200 && statusCode < 300;
    }

    public static ApiResponse m5426a(String str, String str2, HashMap<String, String> hashMap, boolean z) {
        HttpRequestBase httpPost = new HttpPost(str);
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                httpPost.setHeader((String) entry.getKey(), (String) entry.getValue());
                C1380a.m5275a(f3560a, "RestClientHeader : Header -> " + entry.getKey() + "=>" + entry.getValue());
            }
        }
        C1380a.m5275a("RestClient", str2);
        httpPost.setEntity(new ByteArrayEntity(str2.getBytes("UTF-8")));
        C1380a.m5275a("REQUEST HTTP POST", "<URL>" + str + "<HEADER>" + hashMap + "<BODY>" + str2);
        return m5430a(httpPost, z);
    }

    public static ApiResponse m5425a(Context context, String str, Map<String, String> map) {
        HttpRequestBase httpGet = new HttpGet();
        for (Entry entry : map.entrySet()) {
            httpGet.setHeader((String) entry.getKey(), (String) entry.getValue());
        }
        httpGet.setURI(URI.create(str));
        HttpResponse execute = f3561b.execute(httpGet);
        C1380a.m5275a(f3560a, str + " " + execute.getStatusLine().getStatusCode() + "");
        if (execute.getStatusLine().getStatusCode() == 200) {
            return m5429a(httpGet, execute);
        }
        if (execute.getStatusLine().getStatusCode() == 304) {
            String a = C1445h.m5496a(str.substring(str.lastIndexOf("/") + 1));
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setStatusCode(304);
            apiResponse.setData(C1441d.m5477b(context, a));
            return apiResponse;
        }
        C1380a.m5275a(f3560a, "Error While Downloading " + str + " . Response Code:  " + execute.getStatusLine().getStatusCode());
        return null;
    }
}
