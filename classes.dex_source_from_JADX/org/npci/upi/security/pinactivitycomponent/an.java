package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import in.org.npci.commonlibrary.C1355e;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class an {
    private static ResultReceiver f4335k;
    private String f4336a;
    private String f4337b;
    private JSONObject f4338c;
    private JSONObject f4339d;
    private JSONObject f4340e;
    private JSONArray f4341f;
    private Locale f4342g;
    private C1355e f4343h;
    private String f4344i;
    private ab f4345j;

    private void m6493a(Context context) {
        String optString = this.f4340e.optString(CLConstants.SALT_FIELD_TXN_ID);
        String optString2 = this.f4340e.optString("txnAmount");
        String optString3 = this.f4340e.optString(CLConstants.SALT_FIELD_APP_ID);
        String optString4 = this.f4340e.optString(CLConstants.SALT_FIELD_DEVICE_ID);
        String optString5 = this.f4340e.optString(CLConstants.SALT_FIELD_MOBILE_NUMBER);
        String optString6 = this.f4340e.optString(CLConstants.SALT_FIELD_PAYER_ADDR);
        String optString7 = this.f4340e.optString(CLConstants.SALT_FIELD_PAYEE_ADDR);
        try {
            StringBuilder stringBuilder = new StringBuilder(100);
            if (!(optString2 == null || optString2.isEmpty())) {
                stringBuilder.append(optString2).append(CLConstants.SALT_DELIMETER);
            }
            if (!(optString == null || optString.isEmpty())) {
                stringBuilder.append(optString).append(CLConstants.SALT_DELIMETER);
            }
            if (!(optString6 == null || optString6.isEmpty())) {
                stringBuilder.append(optString6).append(CLConstants.SALT_DELIMETER);
            }
            if (!(optString7 == null || optString7.isEmpty())) {
                stringBuilder.append(optString7).append(CLConstants.SALT_DELIMETER);
            }
            if (!(optString3 == null || optString3.isEmpty())) {
                stringBuilder.append(optString3).append(CLConstants.SALT_DELIMETER);
            }
            if (!(optString5 == null || optString5.isEmpty())) {
                stringBuilder.append(optString5).append(CLConstants.SALT_DELIMETER);
            }
            if (!(optString4 == null || optString4.isEmpty())) {
                stringBuilder.append(optString4);
            }
            int lastIndexOf = stringBuilder.lastIndexOf(CLConstants.SALT_DELIMETER);
            if (lastIndexOf != -1 && lastIndexOf == stringBuilder.length() - 1) {
                stringBuilder.deleteCharAt(lastIndexOf);
            }
            optString = this.f4345j.m6484b();
            C1605g.m6536b("CL Trust Token", optString);
            C1605g.m6536b("CL Trust Param Message", stringBuilder.toString());
            this.f4343h.m5175a(this.f4344i, stringBuilder.toString(), optString);
        } catch (Exception e) {
            e.printStackTrace();
            throw new C1603d(context, CLConstants.ERROR_KEY_TRUST_NOT_VALID, CLConstants.ERROR_MSG_KEY_TRUST_NOT_VALID);
        }
    }

    public static void m6494a(CLServerResultReceiver cLServerResultReceiver) {
        f4335k = cLServerResultReceiver;
    }

    public String m6495a() {
        return this.f4336a;
    }

    public void m6496a(Bundle bundle, Context context) {
        this.f4345j = new ab(context);
        try {
            this.f4336a = bundle.getString(CLConstants.INPUT_KEY_KEY_CODE);
            if (this.f4336a == null || this.f4336a.isEmpty()) {
                throw new C1603d(context, CLConstants.ERROR_KEY_CODE_MISSING, CLConstants.ERROR_MSG_KEY_CODE_MISSING);
            }
            C1605g.m6536b("Common Library", this.f4336a);
            try {
                this.f4337b = bundle.getString(CLConstants.INPUT_KEY_XML_PAYLOAD);
                if (this.f4337b == null || this.f4337b.isEmpty()) {
                    throw new C1603d(context, CLConstants.ERROR_KEY_XML_PAYLOAD_MISSING, CLConstants.ERROR_MSG_KEY_XML_PAYLOAD_MISSING);
                }
                C1605g.m6536b("Common Library", this.f4337b);
                this.f4343h = new C1355e(this.f4337b);
                try {
                    String string = bundle.getString(CLConstants.INPUT_KEY_CONTROLS);
                    if (string == null || string.isEmpty()) {
                        C1605g.m6536b("Common Library", "Controls is not received. Setting MPIN as default. ");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(CLConstants.FIELD_TYPE, "PIN");
                        jSONObject.put(CLConstants.FIELD_SUBTYPE, CLConstants.CREDTYPE_MPIN);
                        jSONObject.put(CLConstants.FIELD_DTYPE, "NUM|ALPH");
                        jSONObject.put(CLConstants.FIELD_DLENGTH, 6);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.f4338c = new JSONObject();
                        this.f4338c.put(CLConstants.FIELD_CRED_ALLOWED, jSONArray);
                    } else {
                        C1605g.m6536b("Common Library", "Controls received: " + string);
                        this.f4338c = new JSONObject(string);
                    }
                    try {
                        string = bundle.getString(CLConstants.INPUT_KEY_CONFIGURATION);
                        if (string == null || string.isEmpty()) {
                            C1605g.m6536b("Common Library", "Configuration is not received");
                        } else {
                            C1605g.m6536b("Common Library", "Configuration received: " + string);
                            this.f4339d = new JSONObject(string);
                        }
                        try {
                            string = bundle.getString(CLConstants.INPUT_KEY_SALT);
                            if (string == null || string.isEmpty()) {
                                throw new C1603d(context, CLConstants.ERROR_SALT_MISSING, CLConstants.ERROR_MSG_SALT_MISSING);
                            }
                            C1605g.m6536b("Common Library", string);
                            this.f4340e = new JSONObject(string);
                            try {
                                this.f4344i = bundle.getString(CLConstants.INPUT_KEY_TRUST);
                                if (this.f4344i == null || this.f4344i.isEmpty()) {
                                    throw new C1603d(context, CLConstants.ERROR_KEY_TRUST_MISSING, CLConstants.ERROR_MSG_KEY_TRUST_MISSING);
                                }
                                C1605g.m6536b("Common Library", this.f4344i);
                                m6493a(context);
                                try {
                                    string = bundle.getString(CLConstants.INPUT_KEY_PAY_INFO);
                                    if (string == null || string.isEmpty()) {
                                        C1605g.m6536b("Common Library", "Pay Info not received");
                                    } else {
                                        C1605g.m6536b("Common Library", "Pay Info Received" + string);
                                        this.f4341f = new JSONArray(string);
                                    }
                                    try {
                                        String string2 = bundle.getString(CLConstants.INPUT_KEY_LANGUAGE_PREFERENCE);
                                        string = (string2 == null || string2.isEmpty()) ? CLConstants.DEFAULT_LANGUAGE_PREFERENCE : string2;
                                        this.f4342g = new Locale(string);
                                        C1605g.m6536b("Common Library", string2);
                                    } catch (Exception e) {
                                        throw new C1603d(context, CLConstants.ERROR_LOCALE_PARSE, CLConstants.ERROR_MSG_LOCALE_PARSE);
                                    }
                                } catch (Exception e2) {
                                    throw new C1603d(context, CLConstants.ERROR_PAY_INFO_PARSE, CLConstants.ERROR_MSG_PAY_INFO_PARSE);
                                }
                            } catch (C1603d e3) {
                                throw e3;
                            } catch (Throwable e4) {
                                throw new C1603d(context, CLConstants.ERROR_XML_PAYLOAD_PARSE, CLConstants.ERROR_MSG_XML_PAYLOAD_PARSE, e4);
                            }
                        } catch (C1603d e32) {
                            throw e32;
                        } catch (Throwable e42) {
                            throw new C1603d(context, CLConstants.ERROR_SALT_PARSE, CLConstants.ERROR_MSG_SALT_PARSE, e42);
                        }
                    } catch (Throwable e422) {
                        throw new C1603d(context, CLConstants.ERROR_CONFIG_PARSE, CLConstants.ERROR_MSG_CONFIG_PARSE, e422);
                    }
                } catch (Throwable e4222) {
                    throw new C1603d(context, CLConstants.ERROR_CONTROLS_PARSE, CLConstants.ERROR_MSG_CONTROLS_PARSE, e4222);
                }
            } catch (Throwable e42222) {
                C1605g.m6535a("CommonLibraryException", e42222.getMessage());
                throw new C1603d(context, CLConstants.ERROR_XMLPAYLOAD_VALIDATE, CLConstants.ERROR_MSG_XMLPAYLOAD_VALIDATE, e42222);
            } catch (C1603d e322) {
                throw e322;
            } catch (Throwable e422222) {
                throw new C1603d(context, CLConstants.ERROR_XML_PAYLOAD_PARSE, CLConstants.ERROR_MSG_XML_PAYLOAD_PARSE, e422222);
            }
        } catch (C1603d e3222) {
            throw e3222;
        } catch (Throwable e4222222) {
            throw new C1603d(context, CLConstants.ERROR_KEY_CODE_PARSE, CLConstants.ERROR_MSG_KEY_CODE_PARSE, e4222222);
        }
    }

    public Locale m6497b() {
        return this.f4342g;
    }

    public C1355e m6498c() {
        return this.f4343h;
    }

    public ab m6499d() {
        return this.f4345j;
    }

    public ResultReceiver m6500e() {
        return f4335k;
    }
}
