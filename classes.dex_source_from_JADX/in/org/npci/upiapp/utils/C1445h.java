package in.org.npci.upiapp.utils;

import android.content.Context;
import android.util.Base64;
import in.org.npci.upiapp.models.ApiResponse;
import in.org.npci.upiapp.p036a.C1380a;
import io.fabric.sdk.android.services.p018c.C0670b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.security.PublicKey;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: RemoteAssetService */
public class C1445h {
    public static Boolean m5495a(Context context, String str, boolean z) {
        String a = C1445h.m5496a(str.substring(str.lastIndexOf("/") + 1));
        byte[] b = C1445h.m5497b(context, str, z);
        if (b != null) {
            if (z) {
                a = a.replace(".zip", ".jsa");
            }
            C1441d.m5474a(context, a, b);
            C1380a.m5275a("RemoteAssetService", a + " downloaded successfully");
            return Boolean.valueOf(true);
        }
        C1380a.m5279b("RemoteAssetService", a + " null");
        return Boolean.valueOf(false);
    }

    private static byte[] m5497b(Context context, String str, boolean z) {
        Object string;
        Throwable e;
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        String a = C1445h.m5496a(str.substring(str.lastIndexOf("/") + 1));
        if (z && str.endsWith(".zip")) {
            string = context.getSharedPreferences("BHIMPreferences", 0).getString(a + "_hash", null);
        } else {
            string = C1441d.m5477b(context, a);
            if (string != null) {
                string = C1436b.m5450b(String.valueOf(string));
            } else {
                string = null;
            }
        }
        Map hashMap = new HashMap();
        hashMap.put("ts", String.valueOf(System.currentTimeMillis()));
        hashMap.put("If-None-Match", string);
        ApiResponse a2 = RestClient.m5425a(context, str, hashMap);
        if (a2 != null && a2.getData() != null && str.endsWith(".zip") && z) {
            string = a2.getData();
            String b = C1436b.m5450b(String.valueOf(string));
            ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(string));
            byte[] bArr = null;
            byte[] bArr2 = null;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    byte[] decode;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int read = zipInputStream.read(); read != -1; read = zipInputStream.read()) {
                        byteArrayOutputStream.write(read);
                    }
                    zipInputStream.closeEntry();
                    byteArrayOutputStream.close();
                    if (nextEntry.getName().endsWith(".signature")) {
                        decode = Base64.decode(byteArrayOutputStream.toByteArray(), 2);
                        bArr = bArr2;
                    } else if (nextEntry.getName().endsWith(".jsa")) {
                        byte[] bArr3 = bArr;
                        bArr = byteArrayOutputStream.toByteArray();
                        decode = bArr3;
                    } else {
                        decode = bArr;
                        bArr = bArr2;
                    }
                    bArr2 = bArr;
                    bArr = decode;
                } catch (Throwable e2) {
                    C1380a.m5276a("RemoteAssetService", "Got Out of Memory Error", e2);
                } catch (Throwable e22) {
                    C1380a.m5276a("RemoteAssetService", "Exception while checking digital signature of asset", e22);
                }
            }
            if (bArr2 == null && bArr == null) {
                return null;
            }
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(C1441d.m5480c(context, "remoteAssetPublicKey")));
                try {
                    PublicKey publicKey = (PublicKey) objectInputStream.readObject();
                    Signature instance = Signature.getInstance("DSA");
                    instance.initVerify(publicKey);
                    instance.update(bArr2);
                    if (instance.verify(bArr)) {
                        context.getSharedPreferences("BHIMPreferences", 0).edit().putString(a + "_hash", b).commit();
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    objectInputStream2 = objectInputStream;
                    try {
                        C1380a.m5276a("RemoteAssetService", "Exception while checking digital signature of asset", e22);
                        if (objectInputStream2 != null) {
                            objectInputStream2.close();
                        }
                        if (a2 != null) {
                            return null;
                        }
                        return a2.getData();
                    } catch (Throwable th) {
                        e22 = th;
                        objectInputStream = objectInputStream2;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        throw e22;
                    }
                } catch (Throwable th2) {
                    e22 = th2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw e22;
                }
            } catch (Exception e4) {
                e22 = e4;
                objectInputStream2 = null;
                C1380a.m5276a("RemoteAssetService", "Exception while checking digital signature of asset", e22);
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                }
                if (a2 != null) {
                    return a2.getData();
                }
                return null;
            } catch (Throwable th3) {
                e22 = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw e22;
            }
        }
        if (a2 != null) {
            return a2.getData();
        }
        return null;
    }

    public static String m5496a(String str) {
        return str.split("\\?")[0].split("#")[0].replaceAll("[^a-zA-Z0-9.]", C0670b.ROLL_OVER_FILE_NAME_SEPARATOR);
    }
}
