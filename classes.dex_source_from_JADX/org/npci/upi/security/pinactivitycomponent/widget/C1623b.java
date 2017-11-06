package org.npci.upi.security.pinactivitycomponent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1592d;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1593e;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1596h;

public class C1623b extends LinearLayout implements C1621c {
    private boolean f4447a = false;
    private String f4448b;
    private String f4449c;
    private int f4450d;
    private TextView f4451e;
    private FormItemEditText f4452f;
    private C1599o f4453g;
    private int f4454h;
    private Object f4455i;
    private LinearLayout f4456j;
    private Button f4457k;
    private ProgressBar f4458l;
    private ImageView f4459m;
    private String f4460n = "";
    private boolean f4461o = false;
    private boolean f4462p;
    private boolean f4463q;
    private RelativeLayout f4464r;

    public C1623b(Context context) {
        super(context);
        m6613a(context, null);
    }

    public aw m6611a(View view, boolean z) {
        float f = 0.0f;
        float f2 = 1.0f;
        aw d = ag.m1290l(view).m1464d(z ? 1.0f : 0.0f);
        if (z) {
            f = 1.0f;
        }
        d = d.m1462c(f).m1458a(new AccelerateInterpolator()).m1456a(new C1634n(this, z));
        if (!z) {
            f2 = 0.5f;
        }
        return d.m1454a(f2);
    }

    public void m6612a() {
        this.f4447a = true;
    }

    public void m6613a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1596h.FormItemView);
        if (obtainStyledAttributes != null) {
            this.f4448b = obtainStyledAttributes.getString(C1596h.FormItemView_formTitle);
            this.f4449c = obtainStyledAttributes.getString(C1596h.FormItemView_formValidationError);
            this.f4450d = obtainStyledAttributes.getInteger(C1596h.FormItemView_formInputLength, 6);
            this.f4462p = obtainStyledAttributes.getBoolean(C1596h.FormItemView_formActionOnTop, false);
            obtainStyledAttributes.recycle();
        }
        C1623b.inflate(context, C1593e.layout_form_item, this);
        this.f4464r = (RelativeLayout) findViewById(C1592d.form_item_root);
        this.f4456j = (LinearLayout) findViewById(C1592d.form_item_action_bar);
        this.f4451e = (TextView) findViewById(C1592d.form_item_title);
        this.f4452f = (FormItemEditText) findViewById(C1592d.form_item_input);
        this.f4457k = (Button) findViewById(C1592d.form_item_button);
        this.f4458l = (ProgressBar) findViewById(C1592d.form_item_progress);
        this.f4459m = (ImageView) findViewById(C1592d.form_item_image);
        this.f4452f.setInputType(0);
        setTitle(this.f4448b);
        setInputLength(this.f4450d);
        this.f4452f.addTextChangedListener(new C1632l(this));
        this.f4452f.setOnTouchListener(new C1633m(this));
        setActionBarPositionTop(this.f4462p);
    }

    public void m6614a(Drawable drawable, boolean z) {
        if (drawable != null) {
            this.f4459m.setImageDrawable(drawable);
        }
        m6611a(this.f4459m, z);
    }

    public void mo899a(String str, Drawable drawable, OnClickListener onClickListener, int i, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            this.f4457k.setText(str);
        }
        Button button = this.f4457k;
        Drawable drawable2 = i == 0 ? drawable : null;
        Drawable drawable3 = i == 1 ? drawable : null;
        Drawable drawable4 = i == 2 ? drawable : null;
        if (i != 3) {
            drawable = null;
        }
        button.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable);
        this.f4457k.setOnClickListener(onClickListener);
        this.f4457k.setEnabled(z2);
        m6611a(this.f4457k, z);
    }

    public void m6616a(String str, OnClickListener onClickListener, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            this.f4457k.setText(str);
        }
        m6611a(this.f4457k, z);
        this.f4457k.setEnabled(z2);
        this.f4457k.setOnClickListener(onClickListener);
    }

    public void m6617a(boolean z) {
        aw a = m6611a(this.f4458l, z);
        a.m1458a(new AccelerateDecelerateInterpolator());
        a.m1463c();
    }

    public boolean mo900c() {
        if (this.f4461o) {
            this.f4461o = false;
            this.f4452f.setText(this.f4460n.replaceAll(".", "●"));
        } else {
            this.f4461o = true;
            setText(this.f4460n);
        }
        return this.f4461o;
    }

    public boolean mo901d() {
        this.f4452f.requestFocus();
        return true;
    }

    public Object getFormDataTag() {
        return this.f4455i;
    }

    public FormItemEditText getFormInputView() {
        return this.f4452f;
    }

    public C1599o getFormItemListener() {
        return this.f4453g;
    }

    public int getInputLength() {
        return this.f4450d;
    }

    public String getInputValue() {
        return (this.f4447a || this.f4461o) ? this.f4452f.getText().toString() : this.f4460n;
    }

    public void setActionBarPositionTop(boolean z) {
        this.f4463q = z;
        LayoutParams layoutParams = (LayoutParams) this.f4456j.getLayoutParams();
        if (this.f4463q) {
            layoutParams.addRule(10);
            layoutParams.addRule(8, 0);
        } else {
            layoutParams.addRule(10, 0);
            layoutParams.addRule(8, C1592d.form_item_input);
        }
        this.f4456j.setLayoutParams(layoutParams);
    }

    public void setFormDataTag(Object obj) {
        this.f4455i = obj;
    }

    public void setFormItemListener(C1599o c1599o) {
        this.f4453g = c1599o;
    }

    public void setFormItemTag(int i) {
        this.f4454h = i;
    }

    public void setInputLength(int i) {
        this.f4452f.setMaxLength(i);
        this.f4450d = i;
    }

    public void setText(String str) {
        this.f4452f.setText(str);
        this.f4452f.setSelection(str.length());
    }

    public void setTitle(String str) {
        this.f4451e.setText(str);
        this.f4448b = str;
    }
}
