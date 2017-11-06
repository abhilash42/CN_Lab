package org.npci.upi.security.pinactivitycomponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import java.util.Date;

class am extends BroadcastReceiver {
    final /* synthetic */ GetCredential f4334a;

    private am(GetCredential getCredential) {
        this.f4334a = getCredential;
    }

    private void m6492a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object[] objArr = (Object[]) extras.get("pdus");
            SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
            for (int i = 0; i < smsMessageArr.length; i++) {
                smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                String toUpperCase = smsMessageArr[i].getOriginatingAddress().toUpperCase();
                String toUpperCase2 = smsMessageArr[i].getMessageBody().toUpperCase();
                Date date = new Date(smsMessageArr[i].getTimestampMillis());
                C1613p a = new C1614q(this.f4334a.f4309w).m6553a(this.f4334a.f4298E, toUpperCase, toUpperCase2);
                if (a != null) {
                    this.f4334a.f4308v.m6520b(a);
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                m6492a(intent);
            }
        } catch (Exception e) {
            C1605g.m6534a(GetCredential.f4293m, e);
        }
    }
}
