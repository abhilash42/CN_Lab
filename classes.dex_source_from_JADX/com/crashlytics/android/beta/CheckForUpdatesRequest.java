package com.crashlytics.android.beta;

import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.network.C1570d;
import io.fabric.sdk.android.services.network.C1572c;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.p020b.C0671a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class CheckForUpdatesRequest extends C0671a {
    static final String BETA_SOURCE = "3";
    static final String BUILD_VERSION = "build_version";
    static final String DISPLAY_VERSION = "display_version";
    static final String HEADER_BETA_TOKEN = "X-CRASHLYTICS-BETA-TOKEN";
    static final String INSTANCE = "instance";
    static final String SDK_ANDROID_DIR_TOKEN_TYPE = "3";
    static final String SOURCE = "source";
    private final CheckForUpdatesResponseTransform responseTransform;

    static String createBetaTokenHeaderValueFor(String str) {
        return "3:" + str;
    }

    public CheckForUpdatesRequest(C0653h c0653h, String str, String str2, C1570d c1570d, CheckForUpdatesResponseTransform checkForUpdatesResponseTransform) {
        super(c0653h, str, str2, c1570d, C1572c.GET);
        this.responseTransform = checkForUpdatesResponseTransform;
    }

    public CheckForUpdatesResponse invoke(String str, String str2, BuildProperties buildProperties) {
        HttpRequest applyHeadersTo;
        Throwable e;
        Throwable th;
        CheckForUpdatesResponse checkForUpdatesResponse = null;
        try {
            Map queryParamsFor = getQueryParamsFor(buildProperties);
            try {
                applyHeadersTo = applyHeadersTo(getHttpRequest(queryParamsFor), str, str2);
                C1457c.m5546h().mo811a(Beta.TAG, "Checking for updates from " + getUrl());
                C1457c.m5546h().mo811a(Beta.TAG, "Checking for updates query params are: " + queryParamsFor);
                if (applyHeadersTo.m5894c()) {
                    C1457c.m5546h().mo811a(Beta.TAG, "Checking for updates was successful");
                    checkForUpdatesResponse = this.responseTransform.fromJson(new JSONObject(applyHeadersTo.m5899e()));
                    if (applyHeadersTo != null) {
                        C1457c.m5546h().mo811a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m5890b(C0671a.HEADER_REQUEST_ID));
                    }
                } else {
                    C1457c.m5546h().mo818e(Beta.TAG, "Checking for updates failed. Response code: " + applyHeadersTo.m5888b());
                    if (applyHeadersTo != null) {
                        C1457c.m5546h().mo811a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m5890b(C0671a.HEADER_REQUEST_ID));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    C1457c.m5546h().mo819e(Beta.TAG, "Error while checking for updates from " + getUrl(), e);
                    if (applyHeadersTo != null) {
                        C1457c.m5546h().mo811a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m5890b(C0671a.HEADER_REQUEST_ID));
                    }
                    return checkForUpdatesResponse;
                } catch (Throwable th2) {
                    th = th2;
                    if (applyHeadersTo != null) {
                        C1457c.m5546h().mo811a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m5890b(C0671a.HEADER_REQUEST_ID));
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            applyHeadersTo = null;
            C1457c.m5546h().mo819e(Beta.TAG, "Error while checking for updates from " + getUrl(), e);
            if (applyHeadersTo != null) {
                C1457c.m5546h().mo811a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m5890b(C0671a.HEADER_REQUEST_ID));
            }
            return checkForUpdatesResponse;
        } catch (Throwable e4) {
            applyHeadersTo = null;
            th = e4;
            if (applyHeadersTo != null) {
                C1457c.m5546h().mo811a("Fabric", "Checking for updates request ID: " + applyHeadersTo.m5890b(C0671a.HEADER_REQUEST_ID));
            }
            throw th;
        }
        return checkForUpdatesResponse;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, String str, String str2) {
        return httpRequest.m5878a(C0671a.HEADER_ACCEPT, C0671a.ACCEPT_JSON_VALUE).m5878a(C0671a.HEADER_USER_AGENT, C0671a.CRASHLYTICS_USER_AGENT + this.kit.getVersion()).m5878a(C0671a.HEADER_DEVELOPER_TOKEN, C0671a.CLS_ANDROID_SDK_DEVELOPER_TOKEN).m5878a(C0671a.HEADER_CLIENT_TYPE, C0671a.ANDROID_CLIENT_TYPE).m5878a(C0671a.HEADER_CLIENT_VERSION, this.kit.getVersion()).m5878a(C0671a.HEADER_API_KEY, str).m5878a(HEADER_BETA_TOKEN, createBetaTokenHeaderValueFor(str2));
    }

    private Map<String, String> getQueryParamsFor(BuildProperties buildProperties) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(BUILD_VERSION, buildProperties.versionCode);
        hashMap.put(DISPLAY_VERSION, buildProperties.versionName);
        hashMap.put(INSTANCE, buildProperties.buildId);
        hashMap.put(SOURCE, "3");
        return hashMap;
    }
}
