package android.support.v4.os;

import android.os.AsyncTask;

/* compiled from: AsyncTaskCompatHoneycomb */
class C0206b {
    static <Params, Progress, Result> void m819a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
