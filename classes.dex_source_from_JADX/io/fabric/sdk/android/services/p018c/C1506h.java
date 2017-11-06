package io.fabric.sdk.android.services.p018c;

import android.content.Context;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1499q;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: QueueFileEventStorage */
public class C1506h implements C1505c {
    private final Context f3781a;
    private final File f3782b;
    private final String f3783c;
    private final File f3784d;
    private C1499q f3785e = new C1499q(this.f3784d);
    private File f3786f;

    public C1506h(Context context, File file, String str, String str2) {
        this.f3781a = context;
        this.f3782b = file;
        this.f3783c = str2;
        this.f3784d = new File(this.f3782b, str);
        m5754e();
    }

    private void m5754e() {
        this.f3786f = new File(this.f3782b, this.f3783c);
        if (!this.f3786f.exists()) {
            this.f3786f.mkdirs();
        }
    }

    public void mo835a(byte[] bArr) {
        this.f3785e.m5732a(bArr);
    }

    public int mo831a() {
        return this.f3785e.m5730a();
    }

    public void mo833a(String str) {
        this.f3785e.close();
        m5753a(this.f3784d, new File(this.f3786f, str));
        this.f3785e = new C1499q(this.f3784d);
    }

    private void m5753a(File file, File file2) {
        Closeable fileInputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                closeable = mo840a(file2);
                C1482i.m5658a((InputStream) fileInputStream, (OutputStream) closeable, new byte[1024]);
                C1482i.m5656a(fileInputStream, "Failed to close file input stream");
                C1482i.m5656a(closeable, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                th = th2;
                C1482i.m5656a(fileInputStream, "Failed to close file input stream");
                C1482i.m5656a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            C1482i.m5656a(fileInputStream, "Failed to close file input stream");
            C1482i.m5656a(closeable, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream mo840a(File file) {
        return new FileOutputStream(file);
    }

    public List<File> mo832a(int i) {
        List<File> arrayList = new ArrayList();
        for (Object add : this.f3786f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void mo834a(List<File> list) {
        for (File file : list) {
            C1482i.m5653a(this.f3781a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public List<File> mo838c() {
        return Arrays.asList(this.f3786f.listFiles());
    }

    public void mo839d() {
        try {
            this.f3785e.close();
        } catch (IOException e) {
        }
        this.f3784d.delete();
    }

    public boolean mo837b() {
        return this.f3785e.m5735b();
    }

    public boolean mo836a(int i, int i2) {
        return this.f3785e.m5734a(i, i2);
    }
}
