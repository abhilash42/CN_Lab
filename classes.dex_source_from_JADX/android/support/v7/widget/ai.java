package android.support.v7.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

/* compiled from: ResourcesWrapper */
class ai extends Resources {
    private final Resources f1494a;

    public ai(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1494a = resources;
    }

    public CharSequence getText(int i) {
        return this.f1494a.getText(i);
    }

    public CharSequence getQuantityText(int i, int i2) {
        return this.f1494a.getQuantityText(i, i2);
    }

    public String getString(int i) {
        return this.f1494a.getString(i);
    }

    public String getString(int i, Object... objArr) {
        return this.f1494a.getString(i, objArr);
    }

    public String getQuantityString(int i, int i2, Object... objArr) {
        return this.f1494a.getQuantityString(i, i2, objArr);
    }

    public String getQuantityString(int i, int i2) {
        return this.f1494a.getQuantityString(i, i2);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f1494a.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f1494a.getTextArray(i);
    }

    public String[] getStringArray(int i) {
        return this.f1494a.getStringArray(i);
    }

    public int[] getIntArray(int i) {
        return this.f1494a.getIntArray(i);
    }

    public TypedArray obtainTypedArray(int i) {
        return this.f1494a.obtainTypedArray(i);
    }

    public float getDimension(int i) {
        return this.f1494a.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) {
        return this.f1494a.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) {
        return this.f1494a.getDimensionPixelSize(i);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.f1494a.getFraction(i, i2, i3);
    }

    public Drawable getDrawable(int i) {
        return this.f1494a.getDrawable(i);
    }

    public Drawable getDrawable(int i, Theme theme) {
        return this.f1494a.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) {
        return this.f1494a.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        return this.f1494a.getDrawableForDensity(i, i2, theme);
    }

    public Movie getMovie(int i) {
        return this.f1494a.getMovie(i);
    }

    public int getColor(int i) {
        return this.f1494a.getColor(i);
    }

    public ColorStateList getColorStateList(int i) {
        return this.f1494a.getColorStateList(i);
    }

    public boolean getBoolean(int i) {
        return this.f1494a.getBoolean(i);
    }

    public int getInteger(int i) {
        return this.f1494a.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) {
        return this.f1494a.getLayout(i);
    }

    public XmlResourceParser getAnimation(int i) {
        return this.f1494a.getAnimation(i);
    }

    public XmlResourceParser getXml(int i) {
        return this.f1494a.getXml(i);
    }

    public InputStream openRawResource(int i) {
        return this.f1494a.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.f1494a.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.f1494a.openRawResourceFd(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) {
        this.f1494a.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        this.f1494a.getValueForDensity(i, i2, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) {
        this.f1494a.getValue(str, typedValue, z);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f1494a.obtainAttributes(attributeSet, iArr);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.f1494a != null) {
            this.f1494a.updateConfiguration(configuration, displayMetrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f1494a.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.f1494a.getConfiguration();
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f1494a.getIdentifier(str, str2, str3);
    }

    public String getResourceName(int i) {
        return this.f1494a.getResourceName(i);
    }

    public String getResourcePackageName(int i) {
        return this.f1494a.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) {
        return this.f1494a.getResourceTypeName(i);
    }

    public String getResourceEntryName(int i) {
        return this.f1494a.getResourceEntryName(i);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f1494a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f1494a.parseBundleExtra(str, attributeSet, bundle);
    }
}
