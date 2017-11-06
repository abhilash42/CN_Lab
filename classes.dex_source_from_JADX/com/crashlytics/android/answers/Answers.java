package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import io.fabric.sdk.android.C0653h;
import io.fabric.sdk.android.C1457c;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1483j.C1484a;
import io.fabric.sdk.android.services.p020b.C1483j.C1485b;
import io.fabric.sdk.android.services.p022e.C1556q;
import io.fabric.sdk.android.services.p022e.C1558t;
import java.io.File;

public class Answers extends C0653h<Boolean> {
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    public static final String TAG = "Answers";
    SessionAnalyticsManager analyticsManager;

    public static Answers getInstance() {
        return (Answers) C1457c.m5538a(Answers.class);
    }

    public void logCustom(CustomEvent customEvent) {
        if (customEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onCustom(customEvent);
        }
    }

    public void logPurchase(PurchaseEvent purchaseEvent) {
        if (purchaseEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(purchaseEvent);
        }
    }

    public void logLogin(LoginEvent loginEvent) {
        if (loginEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(loginEvent);
        }
    }

    public void logShare(ShareEvent shareEvent) {
        if (shareEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(shareEvent);
        }
    }

    public void logInvite(InviteEvent inviteEvent) {
        if (inviteEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(inviteEvent);
        }
    }

    public void logSignUp(SignUpEvent signUpEvent) {
        if (signUpEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(signUpEvent);
        }
    }

    public void logLevelStart(LevelStartEvent levelStartEvent) {
        if (levelStartEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(levelStartEvent);
        }
    }

    public void logLevelEnd(LevelEndEvent levelEndEvent) {
        if (levelEndEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(levelEndEvent);
        }
    }

    public void logAddToCart(AddToCartEvent addToCartEvent) {
        if (addToCartEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(addToCartEvent);
        }
    }

    public void logStartCheckout(StartCheckoutEvent startCheckoutEvent) {
        if (startCheckoutEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(startCheckoutEvent);
        }
    }

    public void logRating(RatingEvent ratingEvent) {
        if (ratingEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(ratingEvent);
        }
    }

    public void logContentView(ContentViewEvent contentViewEvent) {
        if (contentViewEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(contentViewEvent);
        }
    }

    public void logSearch(SearchEvent searchEvent) {
        if (searchEvent == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.analyticsManager != null) {
            this.analyticsManager.onPredefined(searchEvent);
        }
    }

    public void onException(C1485b c1485b) {
        if (this.analyticsManager != null) {
            this.analyticsManager.onError(c1485b.m5681a());
        }
    }

    public void onException(C1484a c1484a) {
        if (this.analyticsManager != null) {
            this.analyticsManager.onCrash(c1484a.m5681a(), c1484a.m5682b());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean onPreExecute() {
        try {
            long j;
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                j = packageInfo.firstInstallTime;
            } else {
                j = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.analyticsManager = SessionAnalyticsManager.build(this, context, getIdManager(), num, str, j);
            this.analyticsManager.enable();
            return true;
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(TAG, "Error retrieving app properties", e);
            return false;
        }
    }

    protected Boolean doInBackground() {
        try {
            C1558t b = C1556q.m5839a().m5843b();
            if (b == null) {
                C1457c.m5546h().mo818e(TAG, "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (b.f3903d.f3873d) {
                C1457c.m5546h().mo811a(TAG, "Analytics collection enabled");
                this.analyticsManager.setAnalyticsSettingsData(b.f3904e, getOverridenSpiEndpoint());
                return Boolean.valueOf(true);
            } else {
                C1457c.m5546h().mo811a(TAG, "Analytics collection disabled");
                this.analyticsManager.disable();
                return Boolean.valueOf(false);
            }
        } catch (Throwable e) {
            C1457c.m5546h().mo819e(TAG, "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String getVersion() {
        return "1.3.10.143";
    }

    String getOverridenSpiEndpoint() {
        return C1482i.m5664b(getContext(), CRASHLYTICS_API_ENDPOINT);
    }
}
