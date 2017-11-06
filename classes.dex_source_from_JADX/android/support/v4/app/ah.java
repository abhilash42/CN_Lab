package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ad.C0053a;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatJellybean */
class ah {
    private static final Object f238a = new Object();
    private static Field f239b;
    private static boolean f240c;
    private static final Object f241d = new Object();

    /* compiled from: NotificationCompatJellybean */
    public static class C0075a implements C0070y, C0071z {
        private Builder f235a;
        private final Bundle f236b;
        private List<Bundle> f237c = new ArrayList();

        public C0075a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            boolean z5;
            Builder lights = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOngoing(z5);
            if ((notification.flags & 8) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOnlyAlertOnce(z5);
            if ((notification.flags & 16) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setAutoCancel(z5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f235a = lights.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f236b = new Bundle();
            if (bundle != null) {
                this.f236b.putAll(bundle);
            }
            if (z3) {
                this.f236b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f236b.putString("android.support.groupKey", str);
                if (z4) {
                    this.f236b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f236b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f236b.putString("android.support.sortKey", str2);
            }
        }

        public void mo36a(C0053a c0053a) {
            this.f237c.add(ah.m270a(this.f235a, c0053a));
        }

        public Builder mo35a() {
            return this.f235a;
        }

        public Notification mo37b() {
            Notification build = this.f235a.build();
            Bundle a = ah.m271a(build);
            Bundle bundle = new Bundle(this.f236b);
            for (String str : this.f236b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray a2 = ah.m272a(this.f237c);
            if (a2 != null) {
                ah.m271a(build).putSparseParcelableArray("android.support.actionExtras", a2);
            }
            return build;
        }
    }

    public static void m274a(C0071z c0071z, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(c0071z.mo35a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void m273a(C0071z c0071z, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(c0071z.mo35a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void m275a(C0071z c0071z, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(c0071z.mo35a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> m272a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m271a(Notification notification) {
        synchronized (f238a) {
            if (f240c) {
                return null;
            }
            try {
                if (f239b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f239b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f240c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f239b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f239b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f240c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f240c = true;
                return null;
            }
        }
    }

    public static Bundle m270a(Builder builder, C0053a c0053a) {
        builder.addAction(c0053a.mo29a(), c0053a.mo30b(), c0053a.mo31c());
        Bundle bundle = new Bundle(c0053a.mo32d());
        if (c0053a.mo33f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", am.m291a(c0053a.mo33f()));
        }
        return bundle;
    }
}
