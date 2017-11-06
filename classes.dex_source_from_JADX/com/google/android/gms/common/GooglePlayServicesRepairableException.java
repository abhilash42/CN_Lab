package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int f1755a;

    GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.f1755a = i;
    }
}
