package in.org.npci.upiapp.utils;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import in.org.npci.upiapp.p036a.C1380a;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;

/* compiled from: TlsSniSocketFactory */
public class C1446i implements LayeredSocketFactory {
    private static final HostnameVerifier f3613a = SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    private static final StrictHostnameVerifier f3614b = new StrictHostnameVerifier();
    private final boolean f3615c = false;
    private final boolean f3616d = false;
    private final String f3617e = null;

    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) {
        return null;
    }

    public Socket createSocket() {
        return null;
    }

    public boolean isSecure(Socket socket) {
        if (socket instanceof SSLSocket) {
            return socket.isConnected();
        }
        return false;
    }

    @TargetApi(17)
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(InetAddress.getByName(str), i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
        if (VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        } else {
            try {
                sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(sSLSocket, new Object[]{str});
            } catch (Exception e) {
                C1380a.m5279b(C1446i.class.getSimpleName(), "SNI not usable: " + e);
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (!this.f3616d && this.f3617e == null && !f3613a.verify(str, session)) {
            throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
        } else if (this.f3616d || this.f3617e != null || !this.f3615c || f3614b.verify(str, session)) {
            return sSLSocket;
        } else {
            throw new SSLPeerUnverifiedException("Cannot verify hostname strict : " + str);
        }
    }
}
