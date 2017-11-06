package io.fabric.sdk.android.services.p020b;

import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.network.C1572c;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: AbstractSpiCall */
public abstract class C0671a {
    public static final String ACCEPT_JSON_VALUE = "application/json";
    public static final String ANDROID_CLIENT_TYPE = "android";
    public static final String CLS_ANDROID_SDK_DEVELOPER_TOKEN = "470fa2b4ae81cd56ecbcda9735803434cec591fa";
    public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
    public static final int DEFAULT_TIMEOUT = 10000;
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_API_KEY = "X-CRASHLYTICS-API-KEY";
    public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
    public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
    public static final String HEADER_DEVELOPER_TOKEN = "X-CRASHLYTICS-DEVELOPER-TOKEN";
    public static final String HEADER_REQUEST_ID = "X-REQUEST-ID";
    public static final String HEADER_USER_AGENT = "User-Agent";
    private static final Pattern PROTOCOL_AND_HOST_PATTERN = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final C0653h kit;
    private final C1572c method;
    private final String protocolAndHostOverride;
    private final C1570d requestFactory;
    private final String url;

    public C0671a(C0653h c0653h, String str, String str2, C1570d c1570d, C1572c c1572c) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (c1570d == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else {
            this.kit = c0653h;
            this.protocolAndHostOverride = str;
            this.url = overrideProtocolAndHost(str2);
            this.requestFactory = c1570d;
            this.method = c1572c;
        }
    }

    protected String getUrl() {
        return this.url;
    }

    protected HttpRequest getHttpRequest() {
        return getHttpRequest(Collections.emptyMap());
    }

    protected HttpRequest getHttpRequest(Map<String, String> map) {
        return this.requestFactory.mo858a(this.method, getUrl(), map).m5885a(false).m5875a((int) DEFAULT_TIMEOUT).m5878a(HEADER_USER_AGENT, CRASHLYTICS_USER_AGENT + this.kit.getVersion()).m5878a(HEADER_DEVELOPER_TOKEN, CLS_ANDROID_SDK_DEVELOPER_TOKEN);
    }

    private String overrideProtocolAndHost(String str) {
        if (C1482i.m5669c(this.protocolAndHostOverride)) {
            return str;
        }
        return PROTOCOL_AND_HOST_PATTERN.matcher(str).replaceFirst(this.protocolAndHostOverride);
    }
}
