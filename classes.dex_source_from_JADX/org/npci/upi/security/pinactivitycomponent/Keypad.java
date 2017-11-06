package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.p004a.C0023a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1589a;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1590b;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1591c;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1596h;

public class Keypad extends TableLayout {
    private int f4313a;
    private int f4314b;
    private int f4315c;
    private float f4316d;
    private C1598f f4317e;

    public Keypad(Context context) {
        this(context, null);
    }

    public Keypad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4313a = 61;
        m6473a(attributeSet);
        m6472a();
    }

    private int m6470a(float f) {
        return (int) (((float) (getResources().getDisplayMetrics().densityDpi / 160)) * f);
    }

    private void m6472a() {
        setBackgroundColor(this.f4314b);
        LayoutParams layoutParams = new TableLayout.LayoutParams(-1, 0, 1.0f);
        int i = 0;
        boolean z = true;
        while (i < 3) {
            View tableRow = new TableRow(getContext());
            tableRow.setLayoutParams(layoutParams);
            tableRow.setWeightSum(3.0f);
            boolean z2 = z;
            for (int i2 = 0; i2 < 3; i2++) {
                View textView = new TextView(getContext());
                textView.setGravity(17);
                textView.setLayoutParams(getItemParams());
                textView.setTextColor(this.f4315c);
                textView.setTextSize(2, this.f4316d);
                textView.setText(String.valueOf(z2));
                textView.setClickable(true);
                setClickFeedback(textView);
                textView.setOnClickListener(new aq(this, z2));
                tableRow.addView(textView);
                z2++;
            }
            addView(tableRow);
            i++;
            z = z2;
        }
        View imageView = new ImageView(getContext());
        imageView.setImageResource(C1591c.ic_action_backspace);
        imageView.setLayoutParams(getItemParams());
        imageView.setClickable(true);
        setClickFeedback(imageView);
        imageView.setOnClickListener(new ar(this));
        View textView2 = new TextView(getContext());
        textView2.setLayoutParams(getItemParams());
        textView2.setGravity(17);
        textView2.setText(String.valueOf(0));
        textView2.setTextColor(this.f4315c);
        textView2.setTextSize(2, this.f4316d);
        textView2.setClickable(true);
        setClickFeedback(textView2);
        textView2.setOnClickListener(new C1602c(this));
        View imageView2 = new ImageView(getContext());
        imageView2.setImageResource(C1591c.ic_action_submit);
        imageView2.setScaleType(ScaleType.CENTER_INSIDE);
        imageView2.setAdjustViewBounds(true);
        LayoutParams itemParams = getItemParams();
        itemParams.height = (int) (((float) m6470a((float) this.f4313a)) * 1.25f);
        imageView2.setLayoutParams(itemParams);
        imageView2.setClickable(true);
        setClickFeedback(imageView2);
        imageView2.setOnClickListener(new C1604e(this));
        View tableRow2 = new TableRow(getContext());
        tableRow2.setLayoutParams(layoutParams);
        tableRow2.setWeightSum(3.0f);
        tableRow2.addView(imageView);
        tableRow2.addView(textView2);
        tableRow2.addView(imageView2);
        addView(tableRow2);
    }

    private void m6473a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1596h.Keypad, 0, 0);
        this.f4314b = obtainStyledAttributes.getColor(C1596h.Keypad_keypad_bg_color, C0023a.m81c(getContext(), C1590b.npci_keypad_bg_color));
        this.f4315c = obtainStyledAttributes.getColor(C1596h.Keypad_key_digit_color, C0023a.m81c(getContext(), C1590b.npci_key_digit_color));
        this.f4316d = (float) obtainStyledAttributes.getDimensionPixelSize(C1596h.Keypad_key_digit_size, 36);
        this.f4313a = obtainStyledAttributes.getDimensionPixelSize(C1596h.Keypad_key_digit_height, this.f4313a);
        obtainStyledAttributes.recycle();
    }

    private TableRow.LayoutParams getItemParams() {
        return new TableRow.LayoutParams(0, m6470a((float) this.f4313a), 1.0f);
    }

    private void setClickFeedback(View view) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(C1589a.selectableItemBackground, typedValue, true);
        view.setBackgroundResource(typedValue.resourceId);
    }

    public void setOnKeyPressCallback(C1598f c1598f) {
        this.f4317e = c1598f;
    }
}
