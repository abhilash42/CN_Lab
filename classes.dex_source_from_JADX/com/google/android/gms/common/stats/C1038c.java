package com.google.android.gms.common.stats;

import com.google.android.gms.internal.C1067b;

public final class C1038c {
    public static C1067b<Integer> f2054a = C1067b.m3883a("gms:common:stats:max_num_of_events", Integer.valueOf(100));
    public static C1067b<Integer> f2055b = C1067b.m3883a("gms:common:stats:max_chunk_size", Integer.valueOf(100));

    public static final class C1037a {
        public static C1067b<Integer> f2048a = C1067b.m3883a("gms:common:stats:connections:level", Integer.valueOf(C1039d.f2057b));
        public static C1067b<String> f2049b = C1067b.m3885a("gms:common:stats:connections:ignored_calling_processes", "");
        public static C1067b<String> f2050c = C1067b.m3885a("gms:common:stats:connections:ignored_calling_services", "");
        public static C1067b<String> f2051d = C1067b.m3885a("gms:common:stats:connections:ignored_target_processes", "");
        public static C1067b<String> f2052e = C1067b.m3885a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static C1067b<Long> f2053f = C1067b.m3884a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }
}
