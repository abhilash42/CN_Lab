package io.fabric.sdk.android.services.p018c;

import android.content.Context;
import io.fabric.sdk.android.services.p020b.C1482i;
import io.fabric.sdk.android.services.p020b.C1486k;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventsFilesManager */
public abstract class C0670b<T> {
    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    protected final C1486k currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final C1505c eventStorage;
    protected volatile long lastRollOverTime;
    protected final List<C0662d> rollOverListeners = new CopyOnWriteArrayList();
    protected final C0673a<T> transform;

    /* compiled from: EventsFilesManager */
    class C15031 implements Comparator<C1504a> {
        final /* synthetic */ C0670b f3778a;

        C15031(C0670b c0670b) {
            this.f3778a = c0670b;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5743a((C1504a) obj, (C1504a) obj2);
        }

        public int m5743a(C1504a c1504a, C1504a c1504a2) {
            return (int) (c1504a.f3780b - c1504a2.f3780b);
        }
    }

    /* compiled from: EventsFilesManager */
    static class C1504a {
        final File f3779a;
        final long f3780b;

        public C1504a(File file, long j) {
            this.f3779a = file;
            this.f3780b = j;
        }
    }

    protected abstract String generateUniqueRollOverFileName();

    public C0670b(Context context, C0673a<T> c0673a, C1486k c1486k, C1505c c1505c, int i) {
        this.context = context.getApplicationContext();
        this.transform = c0673a;
        this.eventStorage = c1505c;
        this.currentTimeProvider = c1486k;
        this.lastRollOverTime = this.currentTimeProvider.mo830a();
        this.defaultMaxFilesToKeep = i;
    }

    public void writeEvent(T t) {
        byte[] toBytes = this.transform.toBytes(t);
        rollFileOverIfNeeded(toBytes.length);
        this.eventStorage.mo835a(toBytes);
    }

    public void registerRollOverListener(C0662d c0662d) {
        if (c0662d != null) {
            this.rollOverListeners.add(c0662d);
        }
    }

    public boolean rollFileOver() {
        boolean z = true;
        String str = null;
        if (this.eventStorage.mo837b()) {
            z = false;
        } else {
            str = generateUniqueRollOverFileName();
            this.eventStorage.mo833a(str);
            C1482i.m5652a(this.context, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.lastRollOverTime = this.currentTimeProvider.mo830a();
        }
        triggerRollOverOnListeners(str);
        return z;
    }

    private void rollFileOverIfNeeded(int i) {
        if (!this.eventStorage.mo836a(i, getMaxByteSizePerFile())) {
            C1482i.m5652a(this.context, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.eventStorage.mo831a()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())}));
            rollFileOver();
        }
    }

    protected int getMaxFilesToKeep() {
        return this.defaultMaxFilesToKeep;
    }

    protected int getMaxByteSizePerFile() {
        return MAX_BYTE_SIZE_PER_FILE;
    }

    public long getLastRollOverTime() {
        return this.lastRollOverTime;
    }

    private void triggerRollOverOnListeners(String str) {
        for (C0662d onRollOver : this.rollOverListeners) {
            try {
                onRollOver.onRollOver(str);
            } catch (Throwable e) {
                C1482i.m5654a(this.context, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> getBatchOfFilesToSend() {
        return this.eventStorage.mo832a(1);
    }

    public void deleteSentFiles(List<File> list) {
        this.eventStorage.mo834a((List) list);
    }

    public void deleteAllEventsFiles() {
        this.eventStorage.mo834a(this.eventStorage.mo838c());
        this.eventStorage.mo839d();
    }

    public void deleteOldestInRollOverIfOverMax() {
        List<File> c = this.eventStorage.mo838c();
        int maxFilesToKeep = getMaxFilesToKeep();
        if (c.size() > maxFilesToKeep) {
            int size = c.size() - maxFilesToKeep;
            C1482i.m5653a(this.context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(maxFilesToKeep), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new C15031(this));
            for (File file : c) {
                treeSet.add(new C1504a(file, parseCreationTimestampFromFileName(file.getName())));
            }
            List arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((C1504a) it.next()).f3779a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.eventStorage.mo834a(arrayList);
        }
    }

    public long parseCreationTimestampFromFileName(String str) {
        long j = 0;
        String[] split = str.split(ROLL_OVER_FILE_NAME_SEPARATOR);
        if (split.length == 3) {
            try {
                j = Long.valueOf(split[2]).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}
