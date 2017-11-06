package android.support.v4.p004a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.io.File;

/* compiled from: ContextCompat */
public class C0023a {
    public static boolean m79a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0027e.m88a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0026d.m87a(context, intentArr);
            return true;
        }
    }

    public static final Drawable m77a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return C0024b.m83a(context, i);
        }
        return context.getResources().getDrawable(i);
    }

    public static final ColorStateList m80b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return C0025c.m85a(context, i);
        }
        return context.getResources().getColorStateList(i);
    }

    public static final int m81c(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return C0025c.m86b(context, i);
        }
        return context.getResources().getColor(i);
    }

    public static int m76a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public final File m82a(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return C0024b.m84a(context);
        }
        return C0023a.m78a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File m78a(File file) {
        synchronized (C0023a.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}
