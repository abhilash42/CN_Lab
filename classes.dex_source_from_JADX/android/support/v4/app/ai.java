package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ad.C0053a;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotificationCompatKitKat */
class ai {

    /* compiled from: NotificationCompatKitKat */
    public static class C0076a implements C0070y, C0071z {
        private Builder f242a;
        private Bundle f243b;
        private List<Bundle> f244c = new ArrayList();

        public C0076a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            boolean z6;
            Builder lights = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOngoing(z6);
            if ((notification.flags & 8) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOnlyAlertOnce(z6);
            if ((notification.flags & 16) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setAutoCancel(z6).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f242a = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f243b = new Bundle();
            if (bundle != null) {
                this.f243b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f243b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f243b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f243b.putString("android.support.groupKey", str);
                if (z5) {
                    this.f243b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f243b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f243b.putString("android.support.sortKey", str2);
            }
        }

        public void mo36a(C0053a c0053a) {
            this.f244c.add(ah.m270a(this.f242a, c0053a));
        }

        public Builder mo35a() {
            return this.f242a;
        }

        public Notification mo37b() {
            SparseArray a = ah.m272a(this.f244c);
            if (a != null) {
                this.f243b.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f242a.setExtras(this.f243b);
            return this.f242a.build();
        }
    }
}
