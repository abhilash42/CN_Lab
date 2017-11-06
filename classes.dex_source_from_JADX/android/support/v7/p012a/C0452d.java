package android.support.v7.p012a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.p012a.C0449c.C0446a;
import android.support.v7.p013b.C0509a.C0498a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

/* compiled from: AlertDialog */
public class C0452d extends C0451m implements DialogInterface {
    private C0449c f802a = new C0449c(getContext(), this, getWindow());

    /* compiled from: AlertDialog */
    public static class C0450a {
        private final C0446a f799a;
        private int f800b;

        public C0450a(Context context) {
            this(context, C0452d.m2002a(context, 0));
        }

        public C0450a(Context context, int i) {
            this.f799a = new C0446a(new ContextThemeWrapper(context, C0452d.m2002a(context, i)));
            this.f800b = i;
        }

        public Context m1989a() {
            return this.f799a.f732a;
        }

        public C0450a m1994a(CharSequence charSequence) {
            this.f799a.f737f = charSequence;
            return this;
        }

        public C0450a m1992a(View view) {
            this.f799a.f738g = view;
            return this;
        }

        public C0450a m1991a(Drawable drawable) {
            this.f799a.f735d = drawable;
            return this;
        }

        public C0450a m1990a(OnKeyListener onKeyListener) {
            this.f799a.f749r = onKeyListener;
            return this;
        }

        public C0450a m1993a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f799a.f751t = listAdapter;
            this.f799a.f752u = onClickListener;
            return this;
        }

        public C0452d m1995b() {
            C0452d c0452d = new C0452d(this.f799a.f732a, this.f800b, false);
            this.f799a.m1947a(c0452d.f802a);
            c0452d.setCancelable(this.f799a.f746o);
            if (this.f799a.f746o) {
                c0452d.setCanceledOnTouchOutside(true);
            }
            c0452d.setOnCancelListener(this.f799a.f747p);
            c0452d.setOnDismissListener(this.f799a.f748q);
            if (this.f799a.f749r != null) {
                c0452d.setOnKeyListener(this.f799a.f749r);
            }
            return c0452d;
        }
    }

    C0452d(Context context, int i, boolean z) {
        super(context, C0452d.m2002a(context, i));
    }

    static int m2002a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0498a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f802a.m1981a(charSequence);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f802a.m1976a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f802a.m1982a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f802a.m1986b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
