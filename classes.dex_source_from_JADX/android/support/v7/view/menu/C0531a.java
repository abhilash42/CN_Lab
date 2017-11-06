package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p004a.C0023a;
import android.support.v4.p006c.p007a.C0172b;
import android.support.v4.view.C0321d;
import android.support.v4.view.C0353p.C0352e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionMenuItem */
public class C0531a implements C0172b {
    private final int f1075a;
    private final int f1076b;
    private final int f1077c;
    private final int f1078d;
    private CharSequence f1079e;
    private CharSequence f1080f;
    private Intent f1081g;
    private char f1082h;
    private char f1083i;
    private Drawable f1084j;
    private int f1085k = 0;
    private Context f1086l;
    private OnMenuItemClickListener f1087m;
    private int f1088n = 16;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m2399a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m2402a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m2404b(i);
    }

    public C0531a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1086l = context;
        this.f1075a = i2;
        this.f1076b = i;
        this.f1077c = i3;
        this.f1078d = i4;
        this.f1079e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f1083i;
    }

    public int getGroupId() {
        return this.f1076b;
    }

    public Drawable getIcon() {
        return this.f1084j;
    }

    public Intent getIntent() {
        return this.f1081g;
    }

    public int getItemId() {
        return this.f1075a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f1082h;
    }

    public int getOrder() {
        return this.f1078d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1079e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1080f != null ? this.f1080f : this.f1079e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1088n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1088n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1088n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1088n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1083i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1088n = (z ? 1 : 0) | (this.f1088n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1088n = (z ? 2 : 0) | (this.f1088n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1088n = (z ? 16 : 0) | (this.f1088n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1084j = drawable;
        this.f1085k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1085k = i;
        this.f1084j = C0023a.m77a(this.f1086l, i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1081g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1082h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1087m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1082h = c;
        this.f1083i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1079e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f1079e = this.f1086l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1080f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f1088n = (z ? 0 : 8) | (this.f1088n & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public C0172b m2402a(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public C0172b m2399a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0321d mo461a() {
        return null;
    }

    public C0172b mo459a(C0321d c0321d) {
        throw new UnsupportedOperationException();
    }

    public C0172b m2404b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public C0172b mo460a(C0352e c0352e) {
        return this;
    }
}
