package io.fabric.sdk.android.services.p037d;

import android.content.Context;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import java.io.File;

/* compiled from: FileStoreImpl */
public class C1532b implements C1531a {
    private final Context f3825a;
    private final String f3826b;
    private final String f3827c;

    public C1532b(C0653h c0653h) {
        if (c0653h.getContext() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f3825a = c0653h.getContext();
        this.f3826b = c0653h.getPath();
        this.f3827c = "Android/" + this.f3825a.getPackageName();
    }

    public File mo842a() {
        return m5792a(this.f3825a.getFilesDir());
    }

    File m5792a(File file) {
        if (file == null) {
            C1457c.m5546h().mo811a("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            C1457c.m5546h().mo816d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
