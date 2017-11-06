package com.crashlytics.android.core;

import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p020b.C1482i;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

class MetaDataStore {
    private static final String KEYDATA_SUFFIX = "keys";
    private static final String KEY_USER_EMAIL = "userEmail";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_USER_NAME = "userName";
    private static final String METADATA_EXT = ".meta";
    private static final String USERDATA_SUFFIX = "user";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final File filesDir;

    public MetaDataStore(File file) {
        this.filesDir = file;
    }

    public void writeUserData(String str, UserMetaData userMetaData) {
        Closeable bufferedWriter;
        Throwable e;
        File userDataFileForSession = getUserDataFileForSession(str);
        Closeable closeable = null;
        try {
            String userDataToJson = userDataToJson(userMetaData);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userDataFileForSession), UTF_8));
            try {
                bufferedWriter.write(userDataToJson);
                bufferedWriter.flush();
                C1482i.m5656a(bufferedWriter, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error serializing user metadata.", e);
                    C1482i.m5656a(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    C1482i.m5656a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error serializing user metadata.", e);
            C1482i.m5656a(bufferedWriter, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            e = th2;
            C1482i.m5656a(closeable, "Failed to close user metadata file.");
            throw e;
        }
    }

    public UserMetaData readUserData(String str) {
        Throwable e;
        File userDataFileForSession = getUserDataFileForSession(str);
        if (!userDataFileForSession.exists()) {
            return UserMetaData.EMPTY;
        }
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(userDataFileForSession);
            try {
                UserMetaData jsonToUserData = jsonToUserData(C1482i.m5645a((InputStream) fileInputStream));
                C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
                return jsonToUserData;
            } catch (Exception e2) {
                e = e2;
                try {
                    C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
                    C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
                    return UserMetaData.EMPTY;
                } catch (Throwable th) {
                    e = th;
                    C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
            C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
            return UserMetaData.EMPTY;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    public void writeKeyData(String str, Map<String, String> map) {
        Throwable e;
        File keysFileForSession = getKeysFileForSession(str);
        Closeable closeable = null;
        Closeable bufferedWriter;
        try {
            String keysDataToJson = keysDataToJson(map);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(keysFileForSession), UTF_8));
            try {
                bufferedWriter.write(keysDataToJson);
                bufferedWriter.flush();
                C1482i.m5656a(bufferedWriter, "Failed to close key/value metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error serializing key/value metadata.", e);
                    C1482i.m5656a(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    C1482i.m5656a(closeable, "Failed to close key/value metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error serializing key/value metadata.", e);
            C1482i.m5656a(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            e = th2;
            C1482i.m5656a(closeable, "Failed to close key/value metadata file.");
            throw e;
        }
    }

    public Map<String, String> readKeyData(String str) {
        Closeable fileInputStream;
        Throwable e;
        File keysFileForSession = getKeysFileForSession(str);
        if (!keysFileForSession.exists()) {
            return Collections.emptyMap();
        }
        try {
            fileInputStream = new FileInputStream(keysFileForSession);
            try {
                Map<String, String> jsonToKeysData = jsonToKeysData(C1482i.m5645a((InputStream) fileInputStream));
                C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
                return jsonToKeysData;
            } catch (Exception e2) {
                e = e2;
                try {
                    C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
                    C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    e = th;
                    C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C1457c.m5546h().mo819e(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
            C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            C1482i.m5656a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    private File getUserDataFileForSession(String str) {
        return new File(this.filesDir, str + USERDATA_SUFFIX + METADATA_EXT);
    }

    private File getKeysFileForSession(String str) {
        return new File(this.filesDir, str + KEYDATA_SUFFIX + METADATA_EXT);
    }

    private static UserMetaData jsonToUserData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new UserMetaData(valueOrNull(jSONObject, KEY_USER_ID), valueOrNull(jSONObject, KEY_USER_NAME), valueOrNull(jSONObject, KEY_USER_EMAIL));
    }

    private static String userDataToJson(final UserMetaData userMetaData) {
        return new JSONObject() {
        }.toString();
    }

    private static Map<String, String> jsonToKeysData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        Map<String, String> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, valueOrNull(jSONObject, str2));
        }
        return hashMap;
    }

    private static String keysDataToJson(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    private static String valueOrNull(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }
}
