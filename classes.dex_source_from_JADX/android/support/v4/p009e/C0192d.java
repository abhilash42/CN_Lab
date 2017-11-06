package android.support.v4.p009e;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter */
public class C0192d extends Writer {
    private final String f470a;
    private StringBuilder f471b = new StringBuilder(128);

    public C0192d(String str) {
        this.f470a = str;
    }

    public void close() {
        m780a();
    }

    public void flush() {
        m780a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m780a();
            } else {
                this.f471b.append(c);
            }
        }
    }

    private void m780a() {
        if (this.f471b.length() > 0) {
            Log.d(this.f470a, this.f471b.toString());
            this.f471b.delete(0, this.f471b.length());
        }
    }
}
