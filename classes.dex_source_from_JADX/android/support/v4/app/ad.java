package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.al.C0083a;

/* compiled from: NotificationCompatBase */
public class ad {

    /* compiled from: NotificationCompatBase */
    public static abstract class C0053a {

        /* compiled from: NotificationCompatBase */
        public interface C0051a {
        }

        public abstract int mo29a();

        public abstract CharSequence mo30b();

        public abstract PendingIntent mo31c();

        public abstract Bundle mo32d();

        public abstract C0083a[] mo33f();
    }

    public static Notification m262a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        return notification;
    }
}
