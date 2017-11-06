package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.p008d.C0184d;
import android.support.v4.view.ag;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode.Callback;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import java.util.Locale;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1589a;
import org.npci.upi.security.pinactivitycomponent.C1597a.C1596h;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class FormItemEditText extends EditText {
    private int[][] f4414A;
    private int[] f4415B;
    private ColorStateList f4416C;
    private String f4417a = null;
    private StringBuilder f4418b = null;
    private String f4419c = null;
    private int f4420d = 0;
    private float f4421e = 24.0f;
    private float f4422f;
    private float f4423g = 4.0f;
    private float f4424h = 8.0f;
    private int f4425i = 4;
    private RectF[] f4426j;
    private float[] f4427k;
    private Paint f4428l;
    private Paint f4429m;
    private Paint f4430n;
    private Drawable f4431o;
    private Rect f4432p = new Rect();
    private boolean f4433q = false;
    private OnClickListener f4434r;
    private C1631k f4435s = null;
    private boolean f4436t;
    private float f4437u = 1.0f;
    private float f4438v = 2.0f;
    private Paint f4439w;
    private boolean f4440x = false;
    private boolean f4441y = false;
    private ColorStateList f4442z;

    public FormItemEditText(Context context) {
        super(context);
        int[][] iArr = new int[4][];
        iArr[0] = new int[]{16842913};
        iArr[1] = new int[]{16842914};
        iArr[2] = new int[]{16842908};
        iArr[3] = new int[]{-16842908};
        this.f4414A = iArr;
        this.f4415B = new int[]{-16711936, -65536, -16777216, -7829368};
        this.f4416C = new ColorStateList(this.f4414A, this.f4415B);
    }

    public FormItemEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[][] iArr = new int[4][];
        iArr[0] = new int[]{16842913};
        iArr[1] = new int[]{16842914};
        iArr[2] = new int[]{16842908};
        iArr[3] = new int[]{-16842908};
        this.f4414A = iArr;
        this.f4415B = new int[]{-16711936, -65536, -16777216, -7829368};
        this.f4416C = new ColorStateList(this.f4414A, this.f4415B);
        m6582a(context, attributeSet);
    }

    public FormItemEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int[][] iArr = new int[4][];
        iArr[0] = new int[]{16842913};
        iArr[1] = new int[]{16842914};
        iArr[2] = new int[]{16842908};
        iArr[3] = new int[]{-16842908};
        this.f4414A = iArr;
        this.f4415B = new int[]{-16711936, -65536, -16777216, -7829368};
        this.f4416C = new ColorStateList(this.f4414A, this.f4415B);
        m6582a(context, attributeSet);
    }

    @TargetApi(21)
    public FormItemEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int[][] iArr = new int[4][];
        iArr[0] = new int[]{16842913};
        iArr[1] = new int[]{16842914};
        iArr[2] = new int[]{16842908};
        iArr[3] = new int[]{-16842908};
        this.f4414A = iArr;
        this.f4415B = new int[]{-16711936, -65536, -16777216, -7829368};
        this.f4416C = new ColorStateList(this.f4414A, this.f4415B);
        m6582a(context, attributeSet);
    }

    private int m6580a(int... iArr) {
        return this.f4416C.getColorForState(iArr, -7829368);
    }

    private void m6582a(Context context, AttributeSet attributeSet) {
        boolean z = true;
        this.f4437u = (float) m6590a(this.f4437u);
        this.f4438v = (float) m6590a(this.f4438v);
        this.f4421e = (float) m6590a(this.f4421e);
        this.f4424h = (float) m6590a(this.f4424h);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1596h.FormItemEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            obtainStyledAttributes.getValue(C1596h.FormItemEditText_pinAnimationType, typedValue);
            this.f4420d = typedValue.data;
            this.f4417a = obtainStyledAttributes.getString(C1596h.FormItemEditText_pinCharacterMask);
            this.f4419c = obtainStyledAttributes.getString(C1596h.FormItemEditText_pinRepeatedHint);
            this.f4437u = obtainStyledAttributes.getDimension(C1596h.FormItemEditText_pinLineStroke, this.f4437u);
            this.f4438v = obtainStyledAttributes.getDimension(C1596h.FormItemEditText_pinLineStrokeSelected, this.f4438v);
            this.f4436t = obtainStyledAttributes.getBoolean(C1596h.FormItemEditText_pinLineStrokeCentered, false);
            this.f4422f = obtainStyledAttributes.getDimension(C1596h.FormItemEditText_pinCharacterSize, 0.0f);
            this.f4421e = obtainStyledAttributes.getDimension(C1596h.FormItemEditText_pinCharacterSpacing, this.f4421e);
            this.f4424h = obtainStyledAttributes.getDimension(C1596h.FormItemEditText_pinTextBottomPadding, this.f4424h);
            this.f4433q = obtainStyledAttributes.getBoolean(C1596h.FormItemEditText_pinBackgroundIsSquare, this.f4433q);
            this.f4431o = obtainStyledAttributes.getDrawable(C1596h.FormItemEditText_pinBackgroundDrawable);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C1596h.FormItemEditText_pinLineColors);
            if (colorStateList != null) {
                this.f4416C = colorStateList;
            }
            obtainStyledAttributes.recycle();
            this.f4428l = new Paint(getPaint());
            this.f4429m = new Paint(getPaint());
            this.f4430n = new Paint(getPaint());
            this.f4439w = new Paint(getPaint());
            this.f4439w.setStrokeWidth(this.f4437u);
            setFontSize(this.f4422f);
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(C1589a.colorControlActivated, typedValue2, true);
            this.f4415B[0] = typedValue2.data;
            this.f4415B[1] = -7829368;
            this.f4415B[2] = -7829368;
            setBackgroundResource(0);
            this.f4425i = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLength", 4);
            this.f4423g = (float) this.f4425i;
            super.setOnClickListener(new C1624d(this));
            super.setOnLongClickListener(new C1625e(this));
            if ((getInputType() & 128) == 128 && TextUtils.isEmpty(this.f4417a)) {
                this.f4417a = "●";
            } else if ((getInputType() & 16) == 16 && TextUtils.isEmpty(this.f4417a)) {
                this.f4417a = "●";
            }
            if (!TextUtils.isEmpty(this.f4417a)) {
                this.f4418b = getMaskChars();
            }
            getPaint().getTextBounds(CLConstants.SALT_DELIMETER, 0, 1, this.f4432p);
            if (this.f4420d <= -1) {
                z = false;
            }
            this.f4440x = z;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    @TargetApi(11)
    private void m6583a(CharSequence charSequence) {
        this.f4429m.setAlpha(125);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{125, 255});
        ofInt.setDuration(150);
        ofInt.addUpdateListener(new C1626f(this));
        AnimatorSet animatorSet = new AnimatorSet();
        if (charSequence.length() == this.f4425i && this.f4435s != null) {
            animatorSet.addListener(new C1627g(this));
        }
        animatorSet.playTogether(new Animator[]{ofInt});
        animatorSet.start();
    }

    @TargetApi(11)
    private void m6584a(CharSequence charSequence, int i) {
        this.f4427k[i] = this.f4426j[i].bottom - this.f4424h;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f4427k[i] + getPaint().getTextSize(), this.f4427k[i]});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.addUpdateListener(new C1628h(this, i));
        this.f4429m.setAlpha(255);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 255});
        ofInt.setDuration(300);
        ofInt.addUpdateListener(new C1629i(this));
        AnimatorSet animatorSet = new AnimatorSet();
        if (charSequence.length() == this.f4425i && this.f4435s != null) {
            animatorSet.addListener(new C1630j(this));
        }
        animatorSet.playTogether(new Animator[]{ofFloat, ofInt});
        animatorSet.start();
    }

    private void m6585a(boolean z, boolean z2) {
        if (this.f4441y) {
            this.f4439w.setColor(m6580a(16842914));
            return;
        }
        this.f4439w.setStrokeWidth(isFocused() ? this.f4438v : this.f4437u);
        if (z) {
            this.f4439w.setColor(m6580a(16842913));
        } else if (z2) {
            this.f4439w.setColor(isFocused() ? m6580a(16842918) : m6580a(-16842918));
        } else {
            this.f4439w.setColor(isFocused() ? m6580a(16842908) : m6580a(-16842908));
        }
    }

    private void m6587b(boolean z, boolean z2) {
        if (this.f4441y) {
            this.f4431o.setState(new int[]{16842914});
        } else if (isFocused()) {
            this.f4431o.setState(new int[]{16842908});
            if (z2) {
                this.f4431o.setState(new int[]{16842908, 16842913});
            } else if (z) {
                this.f4431o.setState(new int[]{16842908, 16842912});
            }
        } else {
            this.f4431o.setState(new int[]{-16842908});
        }
    }

    private CharSequence getFullText() {
        return this.f4417a == null ? getText() : getMaskChars();
    }

    private StringBuilder getMaskChars() {
        if (this.f4418b == null) {
            this.f4418b = new StringBuilder();
        }
        int length = getText().length();
        while (this.f4418b.length() != length) {
            if (this.f4418b.length() < length) {
                this.f4418b.append(this.f4417a);
            } else {
                this.f4418b.deleteCharAt(this.f4418b.length() - 1);
            }
        }
        return this.f4418b;
    }

    int m6590a(float f) {
        return (int) (((float) (getResources().getDisplayMetrics().densityDpi / 160)) * f);
    }

    protected void onDraw(Canvas canvas) {
        int i;
        CharSequence fullText = getFullText();
        int length = fullText.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(fullText, 0, length, fArr);
        float f = 0.0f;
        if (this.f4419c != null) {
            float[] fArr2 = new float[this.f4419c.length()];
            getPaint().getTextWidths(this.f4419c, fArr2);
            i = 0;
            while (i < fArr2.length) {
                float f2 = fArr2[i] + f;
                i++;
                f = f2;
            }
        }
        float f3 = f;
        i = 0;
        while (((float) i) < this.f4423g) {
            if (this.f4431o != null) {
                m6587b(i < length, i == length);
                this.f4431o.setBounds((int) this.f4426j[i].left, (int) this.f4426j[i].top, (int) this.f4426j[i].right, (int) this.f4426j[i].bottom);
                this.f4431o.draw(canvas);
            }
            f = this.f4426j[i].left + (this.f4422f / 2.0f);
            if (length > i) {
                if (this.f4440x && i == length - 1) {
                    canvas.drawText(fullText, i, i + 1, f - (fArr[i] / 2.0f), this.f4427k[i], this.f4429m);
                } else {
                    canvas.drawText(fullText, i, i + 1, f - (fArr[i] / 2.0f), this.f4427k[i], this.f4428l);
                }
            } else if (this.f4419c != null) {
                canvas.drawText(this.f4419c, f - (f3 / 2.0f), this.f4427k[i], this.f4430n);
            }
            if (this.f4431o == null) {
                m6585a(i < length, i == length);
                canvas.drawLine(this.f4426j[i].left, this.f4426j[i].top, this.f4426j[i].right, this.f4426j[i].bottom, this.f4439w);
            }
            i++;
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int width;
        super.onSizeChanged(i, i2, i3, i4);
        this.f4442z = getTextColors();
        if (this.f4442z != null) {
            this.f4429m.setColor(this.f4442z.getDefaultColor());
            this.f4428l.setColor(this.f4442z.getDefaultColor());
            this.f4430n.setColor(getCurrentHintTextColor());
        }
        int width2 = (getWidth() - ag.m1287i(this)) - ag.m1286h(this);
        if (this.f4421e < 0.0f) {
            this.f4422f = ((float) width2) / ((this.f4423g * 2.0f) - 1.0f);
        } else if (this.f4422f == 0.0f) {
            this.f4422f = (((float) width2) - (this.f4421e * (this.f4423g - 1.0f))) / this.f4423g;
        }
        this.f4426j = new RectF[((int) this.f4423g)];
        this.f4427k = new float[((int) this.f4423g)];
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if ((C0184d.m729a(Locale.getDefault()) == 1 ? 1 : null) != null) {
            width2 = -1;
            width = (int) (((float) (getWidth() - ag.m1286h(this))) - this.f4422f);
        } else {
            width2 = 1;
            width = ag.m1286h(this);
        }
        int i5 = width;
        width = 0;
        while (((float) width) < this.f4423g) {
            this.f4426j[width] = new RectF((float) i5, (float) height, ((float) i5) + this.f4422f, (float) height);
            if (this.f4431o != null) {
                if (this.f4433q) {
                    this.f4426j[width].top = (float) getPaddingTop();
                    this.f4426j[width].right = ((float) i5) + this.f4426j[width].height();
                } else {
                    RectF rectF = this.f4426j[width];
                    rectF.top -= ((float) this.f4432p.height()) + (this.f4424h * 2.0f);
                }
            }
            i5 = this.f4421e < 0.0f ? (int) (((float) i5) + ((((float) width2) * this.f4422f) * 2.0f)) : (int) (((float) i5) + (((float) width2) * (this.f4422f + this.f4421e)));
            this.f4427k[width] = this.f4426j[width].bottom - this.f4424h;
            if (this.f4436t) {
                this.f4426j[width].top /= 2.0f;
                this.f4426j[width].bottom /= 2.0f;
            }
            width++;
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        setError(false);
        if (this.f4426j == null || !this.f4440x) {
            if (this.f4435s != null && charSequence.length() == this.f4425i) {
                this.f4435s.m6620a(charSequence);
            }
        } else if (this.f4420d == -1) {
            invalidate();
        } else if (i3 <= i2) {
        } else {
            if (this.f4420d == 0) {
                m6583a(charSequence);
            } else {
                m6584a(charSequence, i);
            }
        }
    }

    public void setAnimateText(boolean z) {
        this.f4440x = z;
    }

    public void setCharSize(float f) {
        this.f4422f = f;
        invalidate();
    }

    public void setColorStates(ColorStateList colorStateList) {
        this.f4416C = colorStateList;
        invalidate();
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    public void setError(boolean z) {
        this.f4441y = z;
    }

    public void setFontSize(float f) {
        this.f4428l.setTextSize(f);
        this.f4429m.setTextSize(f);
        this.f4430n.setTextSize(f);
    }

    public void setLineStroke(float f) {
        this.f4437u = f;
        invalidate();
    }

    public void setLineStrokeCentered(boolean z) {
        this.f4436t = z;
        invalidate();
    }

    public void setLineStrokeSelected(float f) {
        this.f4438v = f;
        invalidate();
    }

    public void setMargin(int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        marginLayoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        setLayoutParams(marginLayoutParams);
    }

    public void setMaxLength(int i) {
        this.f4425i = i;
        this.f4423g = (float) i;
        setFilters(new InputFilter[]{new LengthFilter(i)});
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f4434r = onClickListener;
    }

    public void setOnPinEnteredListener(C1631k c1631k) {
        this.f4435s = c1631k;
    }

    public void setSpace(float f) {
        this.f4421e = f;
        invalidate();
    }
}
