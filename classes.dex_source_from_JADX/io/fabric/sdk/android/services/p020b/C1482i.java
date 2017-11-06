package io.fabric.sdk.android.services.p020b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import io.fabric.sdk.android.C1457c;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* compiled from: CommonUtils */
public class C1482i {
    public static final Comparator<File> f3712a = new C14801();
    private static Boolean f3713b = null;
    private static final char[] f3714c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long f3715d = -1;

    /* compiled from: CommonUtils */
    static class C14801 implements Comparator<File> {
        C14801() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5635a((File) obj, (File) obj2);
        }

        public int m5635a(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* compiled from: CommonUtils */
    enum C1481a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, C1481a> f3710k = null;

        static {
            f3710k = new HashMap(4);
            f3710k.put("armeabi-v7a", ARMV7);
            f3710k.put("armeabi", ARMV6);
            f3710k.put("arm64-v8a", ARM64);
            f3710k.put("x86", X86_32);
        }

        static C1481a m5636a() {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(obj)) {
                C1457c.m5546h().mo811a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            C1481a c1481a = (C1481a) f3710k.get(obj.toLowerCase(Locale.US));
            if (c1481a == null) {
                return UNKNOWN;
            }
            return c1481a;
        }
    }

    public static SharedPreferences m5642a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String m5644a(File file, String str) {
        Throwable e;
        Throwable th;
        String str2 = null;
        if (file.exists()) {
            Closeable bufferedReader;
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                str2 = split[1];
                C1482i.m5656a(bufferedReader, "Failed to close system file reader.");
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                try {
                    C1457c.m5546h().mo819e("Fabric", "Error parsing " + file, e);
                    C1482i.m5656a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    C1482i.m5656a(bufferedReader, "Failed to close system file reader.");
                    throw th;
                }
            } catch (Throwable e4) {
                bufferedReader = null;
                th = e4;
                C1482i.m5656a(bufferedReader, "Failed to close system file reader.");
                throw th;
            }
        }
        return str2;
    }

    public static int m5637a() {
        return C1481a.m5636a().ordinal();
    }

    public static synchronized long m5660b() {
        long j;
        synchronized (C1482i.class) {
            if (f3715d == -1) {
                j = 0;
                Object a = C1482i.m5644a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a)) {
                    String toUpperCase = a.toUpperCase(Locale.US);
                    try {
                        if (toUpperCase.endsWith("KB")) {
                            j = C1482i.m5640a(toUpperCase, "KB", 1024);
                        } else if (toUpperCase.endsWith("MB")) {
                            j = C1482i.m5640a(toUpperCase, "MB", 1048576);
                        } else if (toUpperCase.endsWith("GB")) {
                            j = C1482i.m5640a(toUpperCase, "GB", 1073741824);
                        } else {
                            C1457c.m5546h().mo811a("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase);
                        }
                    } catch (Throwable e) {
                        C1457c.m5546h().mo819e("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase, e);
                    }
                }
                f3715d = j;
            }
            j = f3715d;
        }
        return j;
    }

    static long m5640a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo m5641a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String m5645a(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String m5647a(String str) {
        return C1482i.m5648a(str, "SHA-1");
    }

    public static String m5665b(InputStream inputStream) {
        return C1482i.m5646a(inputStream, "SHA-1");
    }

    private static String m5646a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return C1482i.m5649a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            C1457c.m5546h().mo819e("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    private static String m5650a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return C1482i.m5649a(instance.digest());
        } catch (Throwable e) {
            C1457c.m5546h().mo819e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    private static String m5648a(String str, String str2) {
        return C1482i.m5650a(str.getBytes(), str2);
    }

    public static String m5651a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : arrayList) {
            stringBuilder.append(append);
        }
        String append2 = stringBuilder.toString();
        return append2.length() > 0 ? C1482i.m5647a(append2) : null;
    }

    public static long m5661b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long m5662b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    public static Float m5666c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
    }

    public static boolean m5670d(Context context) {
        if (C1482i.m5672f(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static void m5653a(Context context, String str) {
        if (C1482i.m5671e(context)) {
            C1457c.m5546h().mo811a("Fabric", str);
        }
    }

    public static void m5654a(Context context, String str, Throwable th) {
        if (C1482i.m5671e(context)) {
            C1457c.m5546h().mo818e("Fabric", str);
        }
    }

    public static void m5652a(Context context, int i, String str, String str2) {
        if (C1482i.m5671e(context)) {
            C1457c.m5546h().mo809a(i, "Fabric", str2);
        }
    }

    public static boolean m5671e(Context context) {
        if (f3713b == null) {
            f3713b = Boolean.valueOf(C1482i.m5659a(context, "com.crashlytics.Trace", false));
        }
        return f3713b.booleanValue();
    }

    public static boolean m5659a(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return z;
        }
        int a = C1482i.m5638a(context, str, "bool");
        if (a > 0) {
            return resources.getBoolean(a);
        }
        int a2 = C1482i.m5638a(context, str, "string");
        if (a2 > 0) {
            return Boolean.parseBoolean(context.getString(a2));
        }
        return z;
    }

    public static int m5638a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, C1482i.m5676j(context));
    }

    public static boolean m5672f(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean m5673g(Context context) {
        boolean f = C1482i.m5672f(context);
        String str = Build.TAGS;
        if ((!f && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (f || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean m5667c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int m5674h(Context context) {
        int i = 0;
        if (C1482i.m5672f(context)) {
            i = 1;
        }
        if (C1482i.m5673g(context)) {
            i |= 2;
        }
        if (C1482i.m5667c()) {
            return i | 4;
        }
        return i;
    }

    public static int m5639a(Context context, boolean z) {
        Float c = C1482i.m5666c(context);
        if (!z || c == null) {
            return 1;
        }
        if (((double) c.floatValue()) >= 99.0d) {
            return 3;
        }
        if (((double) c.floatValue()) < 99.0d) {
            return 2;
        }
        return 0;
    }

    public static String m5649a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f3714c[i2 >>> 4];
            cArr[(i * 2) + 1] = f3714c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean m5675i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String m5664b(Context context, String str) {
        int a = C1482i.m5638a(context, str, "string");
        if (a > 0) {
            return context.getString(a);
        }
        return "";
    }

    public static void m5656a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                C1457c.m5546h().mo819e("Fabric", str, e);
            }
        }
    }

    public static void m5657a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable e) {
                C1457c.m5546h().mo819e("Fabric", str, e);
            }
        }
    }

    public static boolean m5669c(String str) {
        return str == null || str.length() == 0;
    }

    public static String m5643a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i)}).replace(' ', '0');
    }

    public static String m5676j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static void m5658a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String m5663b(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static String m5677k(Context context) {
        Throwable e;
        Throwable th;
        String str = null;
        Closeable openRawResource;
        try {
            openRawResource = context.getResources().openRawResource(C1482i.m5678l(context));
            try {
                String b = C1482i.m5665b((InputStream) openRawResource);
                if (!C1482i.m5669c(b)) {
                    str = b;
                }
                C1482i.m5656a(openRawResource, "Failed to close icon input stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C1457c.m5546h().mo819e("Fabric", "Could not calculate hash for app icon.", e);
                    C1482i.m5656a(openRawResource, "Failed to close icon input stream.");
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C1482i.m5656a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            C1457c.m5546h().mo819e("Fabric", "Could not calculate hash for app icon.", e);
            C1482i.m5656a(openRawResource, "Failed to close icon input stream.");
            return str;
        } catch (Throwable e4) {
            openRawResource = null;
            th = e4;
            C1482i.m5656a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
        return str;
    }

    public static int m5678l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m5679m(Context context) {
        int a = C1482i.m5638a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = C1482i.m5638a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        C1457c.m5546h().mo811a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void m5655a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean m5668c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean m5680n(Context context) {
        if (!C1482i.m5668c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
