package io.fabric.sdk.android.services.p018c;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: GZIPQueueFileEventStorage */
public class C1507g extends C1506h {
    public C1507g(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    public OutputStream mo840a(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
