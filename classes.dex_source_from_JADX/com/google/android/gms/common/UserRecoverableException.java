package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception {
    private final Intent f1754a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f1754a = intent;
    }
}
