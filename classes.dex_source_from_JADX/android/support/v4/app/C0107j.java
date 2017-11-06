package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: BaseFragmentActivityHoneycomb */
abstract class C0107j extends C0106i {
    C0107j() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo70a(view, str, context, attributeSet);
        if (a != null || VERSION.SDK_INT < 11) {
            return a;
        }
        return super.onCreateView(view, str, context, attributeSet);
    }
}
