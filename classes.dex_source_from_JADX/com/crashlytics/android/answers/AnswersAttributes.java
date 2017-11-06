package com.crashlytics.android.answers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

class AnswersAttributes {
    final Map<String, Object> attributes = new ConcurrentHashMap();
    final AnswersEventValidator validator;

    public AnswersAttributes(AnswersEventValidator answersEventValidator) {
        this.validator = answersEventValidator;
    }

    void put(String str, String str2) {
        if (!this.validator.isNull(str, "key") && !this.validator.isNull(str2, CLConstants.FIELD_PAY_INFO_VALUE)) {
            putAttribute(this.validator.limitStringLength(str), this.validator.limitStringLength(str2));
        }
    }

    void put(String str, Number number) {
        if (!this.validator.isNull(str, "key") && !this.validator.isNull(number, CLConstants.FIELD_PAY_INFO_VALUE)) {
            putAttribute(this.validator.limitStringLength(str), number);
        }
    }

    void putAttribute(String str, Object obj) {
        if (!this.validator.isFullMap(this.attributes, str)) {
            this.attributes.put(str, obj);
        }
    }

    public String toString() {
        return new JSONObject(this.attributes).toString();
    }
}
