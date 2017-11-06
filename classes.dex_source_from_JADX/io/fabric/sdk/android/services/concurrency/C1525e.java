package io.fabric.sdk.android.services.concurrency;

/* compiled from: Priority */
public enum C1525e {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int m5781a(C0686i c0686i, Y y) {
        C1525e priority;
        if (y instanceof C0686i) {
            priority = ((C0686i) y).getPriority();
        } else {
            priority = NORMAL;
        }
        return priority.ordinal() - c0686i.getPriority().ordinal();
    }
}
