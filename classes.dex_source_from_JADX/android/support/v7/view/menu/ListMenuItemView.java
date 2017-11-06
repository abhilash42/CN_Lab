package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p013b.C0509a.C0503f;
import android.support.v7.p013b.C0509a.C0505h;
import android.support.v7.p013b.C0509a.C0508k;
import android.support.v7.view.menu.C0530m.C0527a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0527a {
    private C0541h f1061a;
    private ImageView f1062b;
    private RadioButton f1063c;
    private TextView f1064d;
    private CheckBox f1065e;
    private TextView f1066f;
    private Drawable f1067g;
    private int f1068h;
    private Context f1069i;
    private boolean f1070j;
    private int f1071k;
    private Context f1072l;
    private LayoutInflater f1073m;
    private boolean f1074n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1072l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0508k.MenuView, i, 0);
        this.f1067g = obtainStyledAttributes.getDrawable(C0508k.MenuView_android_itemBackground);
        this.f1068h = obtainStyledAttributes.getResourceId(C0508k.MenuView_android_itemTextAppearance, -1);
        this.f1070j = obtainStyledAttributes.getBoolean(C0508k.MenuView_preserveIconSpacing, false);
        this.f1069i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f1067g);
        this.f1064d = (TextView) findViewById(C0503f.title);
        if (this.f1068h != -1) {
            this.f1064d.setTextAppearance(this.f1069i, this.f1068h);
        }
        this.f1066f = (TextView) findViewById(C0503f.shortcut);
    }

    public void mo452a(C0541h c0541h, int i) {
        this.f1061a = c0541h;
        this.f1071k = i;
        setVisibility(c0541h.isVisible() ? 0 : 8);
        setTitle(c0541h.m2511a((C0527a) this));
        setCheckable(c0541h.isCheckable());
        m2397a(c0541h.m2524f(), c0541h.m2520d());
        setIcon(c0541h.getIcon());
        setEnabled(c0541h.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.f1074n = z;
        this.f1070j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1064d.setText(charSequence);
            if (this.f1064d.getVisibility() != 0) {
                this.f1064d.setVisibility(0);
            }
        } else if (this.f1064d.getVisibility() != 8) {
            this.f1064d.setVisibility(8);
        }
    }

    public C0541h getItemData() {
        return this.f1061a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f1063c != null || this.f1065e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1061a.m2525g()) {
                if (this.f1063c == null) {
                    m2394c();
                }
                compoundButton = this.f1063c;
                compoundButton2 = this.f1065e;
            } else {
                if (this.f1065e == null) {
                    m2395d();
                }
                compoundButton = this.f1065e;
                compoundButton2 = this.f1063c;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.f1061a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1065e != null) {
                this.f1065e.setVisibility(8);
            }
            if (this.f1063c != null) {
                this.f1063c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1061a.m2525g()) {
            if (this.f1063c == null) {
                m2394c();
            }
            compoundButton = this.f1063c;
        } else {
            if (this.f1065e == null) {
                m2395d();
            }
            compoundButton = this.f1065e;
        }
        compoundButton.setChecked(z);
    }

    public void m2397a(boolean z, char c) {
        int i = (z && this.f1061a.m2524f()) ? 0 : 8;
        if (i == 0) {
            this.f1066f.setText(this.f1061a.m2522e());
        }
        if (this.f1066f.getVisibility() != i) {
            this.f1066f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f1061a.m2527i() || this.f1074n) ? 1 : 0;
        if (i == 0 && !this.f1070j) {
            return;
        }
        if (this.f1062b != null || drawable != null || this.f1070j) {
            if (this.f1062b == null) {
                m2393b();
            }
            if (drawable != null || this.f1070j) {
                ImageView imageView = this.f1062b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1062b.getVisibility() != 0) {
                    this.f1062b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1062b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1062b != null && this.f1070j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1062b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m2393b() {
        this.f1062b = (ImageView) getInflater().inflate(C0505h.abc_list_menu_item_icon, this, false);
        addView(this.f1062b, 0);
    }

    private void m2394c() {
        this.f1063c = (RadioButton) getInflater().inflate(C0505h.abc_list_menu_item_radio, this, false);
        addView(this.f1063c);
    }

    private void m2395d() {
        this.f1065e = (CheckBox) getInflater().inflate(C0505h.abc_list_menu_item_checkbox, this, false);
        addView(this.f1065e);
    }

    public boolean mo453a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f1073m == null) {
            this.f1073m = LayoutInflater.from(this.f1072l);
        }
        return this.f1073m;
    }
}
