package io.fabric.sdk.android.services.p022e;

import com.crashlytics.android.beta.BuildConfig;
import io.fabric.sdk.android.services.p018c.C0670b;
import io.fabric.sdk.android.services.p020b.C1486k;
import org.json.JSONObject;

/* compiled from: DefaultSettingsJsonTransform */
class C1547k implements C1546v {
    C1547k() {
    }

    public C1558t mo851a(C1486k c1486k, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new C1558t(m5820a(c1486k, (long) optInt2, jSONObject), m5821a(jSONObject.getJSONObject("app")), m5825e(jSONObject.getJSONObject("session")), m5826f(jSONObject.getJSONObject("prompt")), m5823c(jSONObject.getJSONObject("features")), m5824d(jSONObject.getJSONObject("analytics")), m5827g(jSONObject.getJSONObject(BuildConfig.ARTIFACT_ID)), optInt, optInt2);
    }

    private C1539e m5821a(JSONObject jSONObject) {
        String string = jSONObject.getString("identifier");
        String string2 = jSONObject.getString("status");
        String string3 = jSONObject.getString("url");
        String string4 = jSONObject.getString("reports_url");
        boolean optBoolean = jSONObject.optBoolean("update_required", false);
        C1537c c1537c = null;
        if (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) {
            c1537c = m5822b(jSONObject.getJSONObject("icon"));
        }
        return new C1539e(string, string2, string3, string4, optBoolean, c1537c);
    }

    private C1537c m5822b(JSONObject jSONObject) {
        return new C1537c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    private C1550m m5823c(JSONObject jSONObject) {
        return new C1550m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    private C1536b m5824d(JSONObject jSONObject) {
        return new C1536b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", C0670b.MAX_BYTE_SIZE_PER_FILE), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    private C1553p m5825e(JSONObject jSONObject) {
        return new C1553p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false));
    }

    private C1552o m5826f(JSONObject jSONObject) {
        return new C1552o(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    private C1540f m5827g(JSONObject jSONObject) {
        return new C1540f(jSONObject.optString("update_endpoint", C1559u.f3909a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    private long m5820a(C1486k c1486k, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return c1486k.mo830a() + (1000 * j);
    }
}
