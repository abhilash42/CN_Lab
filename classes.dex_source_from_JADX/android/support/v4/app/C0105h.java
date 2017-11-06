package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: BaseFragmentActivityDonut */
abstract class C0105h extends Activity {
    abstract View mo70a(View view, String str, Context context, AttributeSet attributeSet);

    C0105h() {
    }

    protected void onCreate(Bundle bundle) {
        if (VERSION.SDK_INT < 11 && getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a = mo70a(null, str, context, attributeSet);
        if (a == null) {
            return super.onCreateView(str, context, attributeSet);
        }
        return a;
    }

    void a_() {
        finish();
    }
}
