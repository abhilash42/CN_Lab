package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* compiled from: NotificationCompatIceCreamSandwich */
class ag {

    /* compiled from: NotificationCompatIceCreamSandwich */
    public static class C0074a implements C0071z {
        private Builder f234a;

        public C0074a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z) {
            boolean z2;
            Builder lights = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            lights = lights.setOngoing(z2);
            if ((notification.flags & 8) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            lights = lights.setOnlyAlertOnce(z2);
            if ((notification.flags & 16) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            lights = lights.setAutoCancel(z2).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f234a = lights.setFullScreenIntent(pendingIntent2, z2).setLargeIcon(bitmap).setNumber(i).setProgress(i2, i3, z);
        }

        public Builder mo35a() {
            return this.f234a;
        }

        public Notification mo37b() {
            return this.f234a.getNotification();
        }
    }
}
