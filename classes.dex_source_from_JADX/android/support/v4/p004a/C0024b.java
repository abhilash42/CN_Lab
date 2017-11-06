package android.support.v4.p004a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: ContextCompatApi21 */
class C0024b {
    public static Drawable m83a(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File m84a(Context context) {
        return context.getNoBackupFilesDir();
    }
}
