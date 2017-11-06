package android.support.v4.p004a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

/* compiled from: WakefulBroadcastReceiver */
public abstract class C0042k extends BroadcastReceiver {
    private static final SparseArray<WakeLock> f111a = new SparseArray();
    private static int f112b = 1;

    public static ComponentName m114a(Context context, Intent intent) {
        synchronized (f111a) {
            int i = f112b;
            f112b++;
            if (f112b <= 0) {
                f112b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            f111a.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean m115a(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (f111a) {
            WakeLock wakeLock = (WakeLock) f111a.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                f111a.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
