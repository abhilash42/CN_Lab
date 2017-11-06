package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p006c.p007a.C0172b;
import android.support.v4.view.C0321d;
import android.support.v4.view.C0353p.C0352e;
import android.support.v7.view.C0514c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
/* compiled from: MenuItemWrapperICS */
public class C0546i extends C0535c<C0172b> implements MenuItem {
    private Method f1175c;

    /* compiled from: MenuItemWrapperICS */
    class C0542a extends C0321d {
        final ActionProvider f1170a;
        final /* synthetic */ C0546i f1171b;

        public C0542a(C0546i c0546i, Context context, ActionProvider actionProvider) {
            this.f1171b = c0546i;
            super(context);
            this.f1170a = actionProvider;
        }

        public View mo478a() {
            return this.f1170a.onCreateActionView();
        }

        public boolean mo480d() {
            return this.f1170a.onPerformDefaultAction();
        }

        public boolean mo481e() {
            return this.f1170a.hasSubMenu();
        }

        public void mo479a(SubMenu subMenu) {
            this.f1170a.onPrepareSubMenu(this.f1171b.m2430a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    static class C0543b extends FrameLayout implements C0514c {
        final CollapsibleActionView f1172a;

        C0543b(View view) {
            super(view.getContext());
            this.f1172a = (CollapsibleActionView) view;
            addView(view);
        }

        public void mo482a() {
            this.f1172a.onActionViewExpanded();
        }

        public void mo483b() {
            this.f1172a.onActionViewCollapsed();
        }

        View m2539c() {
            return (View) this.f1172a;
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class C0544c extends C0534d<OnActionExpandListener> implements C0352e {
        final /* synthetic */ C0546i f1173a;

        C0544c(C0546i c0546i, OnActionExpandListener onActionExpandListener) {
            this.f1173a = c0546i;
            super(onActionExpandListener);
        }

        public boolean mo484a(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f1173a.m2429a(menuItem));
        }

        public boolean mo485b(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f1173a.m2429a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class C0545d extends C0534d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ C0546i f1174a;

        C0545d(C0546i c0546i, OnMenuItemClickListener onMenuItemClickListener) {
            this.f1174a = c0546i;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f1174a.m2429a(menuItem));
        }
    }

    C0546i(Context context, C0172b c0172b) {
        super(context, c0172b);
    }

    public int getItemId() {
        return ((C0172b) this.b).getItemId();
    }

    public int getGroupId() {
        return ((C0172b) this.b).getGroupId();
    }

    public int getOrder() {
        return ((C0172b) this.b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0172b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0172b) this.b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((C0172b) this.b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0172b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((C0172b) this.b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0172b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0172b) this.b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((C0172b) this.b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((C0172b) this.b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((C0172b) this.b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0172b) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0172b) this.b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((C0172b) this.b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0172b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((C0172b) this.b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((C0172b) this.b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((C0172b) this.b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((C0172b) this.b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((C0172b) this.b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((C0172b) this.b).setVisible(z);
    }

    public boolean isVisible() {
        return ((C0172b) this.b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((C0172b) this.b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((C0172b) this.b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((C0172b) this.b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m2430a(((C0172b) this.b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0172b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0545d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0172b) this.b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((C0172b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0172b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0543b(view);
        }
        ((C0172b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0172b) this.b).setActionView(i);
        View actionView = ((C0172b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0172b) this.b).setActionView(new C0543b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((C0172b) this.b).getActionView();
        if (actionView instanceof C0543b) {
            return ((C0543b) actionView).m2539c();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0172b) this.b).mo459a(actionProvider != null ? mo490a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        C0321d a = ((C0172b) this.b).mo461a();
        if (a instanceof C0542a) {
            return ((C0542a) a).f1170a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((C0172b) this.b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((C0172b) this.b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((C0172b) this.b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0172b) this.b).mo460a(onActionExpandListener != null ? new C0544c(this, onActionExpandListener) : null);
        return this;
    }

    public void m2543a(boolean z) {
        try {
            if (this.f1175c == null) {
                this.f1175c = ((C0172b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1175c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    C0542a mo490a(ActionProvider actionProvider) {
        return new C0542a(this, this.a, actionProvider);
    }
}
