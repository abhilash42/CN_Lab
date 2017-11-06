package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p022e.C1552o;

class DialogStringResolver {
    private static final String PROMPT_MESSAGE_RES_NAME = "com.crashlytics.CrashSubmissionPromptMessage";
    private static final String PROMPT_TITLE_RES_NAME = "com.crashlytics.CrashSubmissionPromptTitle";
    private static final String SUBMISSION_ALWAYS_SEND_RES_NAME = "com.crashlytics.CrashSubmissionAlwaysSendTitle";
    private static final String SUBMISSION_CANCEL_RES_NAME = "com.crashlytics.CrashSubmissionCancelTitle";
    private static final String SUBMISSION_SEND_RES_NAME = "com.crashlytics.CrashSubmissionSendTitle";
    private final Context context;
    private final C1552o promptData;

    public DialogStringResolver(Context context, C1552o c1552o) {
        this.context = context;
        this.promptData = c1552o;
    }

    public String getTitle() {
        return resourceOrFallbackValue(PROMPT_TITLE_RES_NAME, this.promptData.f3878a);
    }

    public String getMessage() {
        return resourceOrFallbackValue(PROMPT_MESSAGE_RES_NAME, this.promptData.f3879b);
    }

    public String getSendButtonTitle() {
        return resourceOrFallbackValue(SUBMISSION_SEND_RES_NAME, this.promptData.f3880c);
    }

    public String getAlwaysSendButtonTitle() {
        return resourceOrFallbackValue(SUBMISSION_ALWAYS_SEND_RES_NAME, this.promptData.f3884g);
    }

    public String getCancelButtonTitle() {
        return resourceOrFallbackValue(SUBMISSION_CANCEL_RES_NAME, this.promptData.f3882e);
    }

    private String resourceOrFallbackValue(String str, String str2) {
        return stringOrFallback(C1482i.m5664b(this.context, str), str2);
    }

    private String stringOrFallback(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
