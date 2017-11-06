package in.juspay.mystique;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class C1203i {
    private static final String f2643a = C1203i.class.getSimpleName();

    public static Boolean m4626a(Context context, String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        byte[] b = C1203i.m4627b(context, str);
        if (b == null) {
            return Boolean.valueOf(false);
        }
        C1180f.m4576a(context, substring, b);
        return Boolean.valueOf(true);
    }

    private static byte[] m4627b(Context context, String str) {
        Object obj = null;
        byte[] a = C1180f.m4577a(context, str.substring(str.lastIndexOf("/") + 1));
        if (a != null) {
            obj = C1180f.m4575a(a);
        }
        Map hashMap = new HashMap();
        hashMap.put("ts", String.valueOf(System.currentTimeMillis()));
        hashMap.put("If-None-Match", obj);
        return RestClient.m4551a(str, hashMap);
    }
}
