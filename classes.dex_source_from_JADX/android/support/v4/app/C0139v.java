package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.p004a.C0032f;
import android.util.Log;

/* compiled from: NavUtils */
public final class C0139v {
    private static final C0136a f431a;

    /* compiled from: NavUtils */
    interface C0136a {
        Intent mo83a(Activity activity);

        String mo84a(Context context, ActivityInfo activityInfo);

        boolean mo85a(Activity activity, Intent intent);

        void mo86b(Activity activity, Intent intent);
    }

    /* compiled from: NavUtils */
    static class C0137b implements C0136a {
        C0137b() {
        }

        public Intent mo83a(Activity activity) {
            String b = C0139v.m597b(activity);
            if (b == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b);
            try {
                return C0139v.m598b((Context) activity, componentName) == null ? C0032f.m92a(componentName) : new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + b + "' in manifest");
                return null;
            }
        }

        public boolean mo85a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void mo86b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public String mo84a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            if (string == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
    }

    /* compiled from: NavUtils */
    static class C0138c extends C0137b {
        C0138c() {
        }

        public Intent mo83a(Activity activity) {
            Intent a = C0140w.m600a(activity);
            if (a == null) {
                return m592b(activity);
            }
            return a;
        }

        Intent m592b(Activity activity) {
            return super.mo83a(activity);
        }

        public boolean mo85a(Activity activity, Intent intent) {
            return C0140w.m602a(activity, intent);
        }

        public void mo86b(Activity activity, Intent intent) {
            C0140w.m603b(activity, intent);
        }

        public String mo84a(Context context, ActivityInfo activityInfo) {
            String a = C0140w.m601a(activityInfo);
            if (a == null) {
                return super.mo84a(context, activityInfo);
            }
            return a;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f431a = new C0138c();
        } else {
            f431a = new C0137b();
        }
    }

    public static boolean m596a(Activity activity, Intent intent) {
        return f431a.mo85a(activity, intent);
    }

    public static void m599b(Activity activity, Intent intent) {
        f431a.mo86b(activity, intent);
    }

    public static Intent m594a(Activity activity) {
        return f431a.mo83a(activity);
    }

    public static Intent m595a(Context context, ComponentName componentName) {
        String b = C0139v.m598b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return C0139v.m598b(context, componentName2) == null ? C0032f.m92a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String m597b(Activity activity) {
        try {
            return C0139v.m598b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m598b(Context context, ComponentName componentName) {
        return f431a.mo84a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }
}
