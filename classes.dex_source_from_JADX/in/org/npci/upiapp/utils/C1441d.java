package in.org.npci.upiapp.utils;

import android.content.Context;
import in.org.npci.upiapp.p036a.C1380a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* compiled from: FileUtil */
public class C1441d {
    public static byte[] m5476a(Context context, String str, String str2) {
        try {
            byte[] b = C1441d.m5477b(context, str);
            if (b == null) {
                return C1441d.m5480c(context, str2 + "/" + str);
            }
            return b;
        } catch (Throwable e) {
            C1380a.m5276a("FileUtil", "not found in internal storage.", e);
            return C1441d.m5480c(context, str2 + "/" + str);
        }
    }

    public static byte[] m5475a(Context context, String str) {
        return C1441d.m5476a(context, str, "");
    }

    public static byte[] m5477b(Context context, String str) {
        File file = new File(context.getDir("bhim", 0), str);
        if (!file.exists()) {
            return null;
        }
        ByteArrayOutputStream a = C1441d.m5472a(new ByteArrayOutputStream(), new FileInputStream(file));
        byte[] toByteArray = a.toByteArray();
        a.flush();
        a.close();
        C1380a.m5275a("FileUtil", str + " found in internal storage.");
        return toByteArray;
    }

    public static File m5473a(String str, Context context) {
        return new File(context.getDir("bhim", 0), str);
    }

    public static byte[] m5480c(Context context, String str) {
        ByteArrayOutputStream a = C1441d.m5472a(new ByteArrayOutputStream(), context.getAssets().open(str, 0));
        C1380a.m5275a("FileUtil", str + " found in assets.");
        byte[] toByteArray = a.toByteArray();
        a.flush();
        a.close();
        return toByteArray;
    }

    private static ByteArrayOutputStream m5472a(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) {
        byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream;
            }
        }
    }

    public static void m5474a(Context context, String str, byte[] bArr) {
        Throwable e;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(new File(context.getDir("bhim", 0), str));
            try {
                fileOutputStream2.write(bArr);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable e2) {
                        C1380a.m5276a("FileUtil", "Exception while closing stream", e2);
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    C1380a.m5276a("FileUtil", "Exception while writing stream", e2);
                    C1380a.m5278a(e2);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable e22) {
                            C1380a.m5276a("FileUtil", "Exception while closing stream", e22);
                        }
                    }
                } catch (Throwable th) {
                    e22 = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            C1380a.m5276a("FileUtil", "Exception while closing stream", e4);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream2 = null;
            C1380a.m5276a("FileUtil", "Exception while writing stream", e22);
            C1380a.m5278a(e22);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            e22 = th2;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }

    public static byte[] m5478b(String str, Context context) {
        try {
            return C1441d.m5472a(new ByteArrayOutputStream(), new FileInputStream(C1441d.m5473a(str, context))).toByteArray();
        } catch (Throwable e) {
            C1380a.m5276a("FileUtil", "Could not read " + str, e);
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            C1380a.m5276a("FileUtil", "Could not read " + str, e2);
            C1441d.m5479c(str, context);
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            C1380a.m5276a("FileUtil", "Could not read " + str, e22);
            C1441d.m5479c(str, context);
            throw new RuntimeException(e22);
        }
    }

    public static boolean m5479c(String str, Context context) {
        File a = C1441d.m5473a(str, context);
        if (a.exists()) {
            C1380a.m5279b("FileUtil", "FILE CORRUPTED. DISABLING GODEL");
            return a.delete();
        }
        C1380a.m5275a("FileUtil", str + " not found");
        return false;
    }
}
