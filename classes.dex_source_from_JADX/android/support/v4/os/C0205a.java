package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* compiled from: AsyncTaskCompat */
public final class C0205a {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m818a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0206b.m819a(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
