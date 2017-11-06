package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.C1000c;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1067b;

public final class C1138p {
    public static C1137a<Boolean> f2378a = C1137a.m4351a("measurement.service_enabled", true);
    public static C1137a<Boolean> f2379b = C1137a.m4351a("measurement.service_client_enabled", true);
    public static C1137a<String> f2380c = C1137a.m4350a("measurement.log_tag", "GMPM", "GMPM-SVC");
    public static C1137a<Long> f2381d = C1137a.m4347a("measurement.ad_id_cache_time", 10000);
    public static C1137a<Long> f2382e = C1137a.m4347a("measurement.monitoring.sample_period_millis", 86400000);
    public static C1137a<Integer> f2383f = C1137a.m4345a("measurement.upload.max_bundles", 100);
    public static C1137a<Integer> f2384g = C1137a.m4345a("measurement.upload.max_batch_size", 65536);
    public static C1137a<String> f2385h = C1137a.m4349a("measurement.upload.url", "https://app-measurement.com/a");
    public static C1137a<Long> f2386i = C1137a.m4347a("measurement.upload.backoff_period", 43200000);
    public static C1137a<Long> f2387j = C1137a.m4347a("measurement.upload.window_interval", 3600000);
    public static C1137a<Long> f2388k = C1137a.m4347a("measurement.upload.interval", 3600000);
    public static C1137a<Long> f2389l = C1137a.m4347a("measurement.upload.stale_data_deletion_interval", 86400000);
    public static C1137a<Long> f2390m = C1137a.m4347a("measurement.upload.initial_upload_delay_time", 15000);
    public static C1137a<Long> f2391n = C1137a.m4347a("measurement.upload.retry_time", 1800000);
    public static C1137a<Integer> f2392o = C1137a.m4345a("measurement.upload.retry_count", 6);
    public static C1137a<Long> f2393p = C1137a.m4347a("measurement.upload.max_queue_time", 2419200000L);
    public static C1137a<Long> f2394q = C1137a.m4347a("measurement.service_client.idle_disconnect_millis", 5000);

    public static final class C1137a<V> {
        private final V f2375a;
        private final C1067b<V> f2376b;
        private V f2377c;

        private C1137a(C1067b<V> c1067b, V v) {
            C1032p.m3678a((Object) c1067b);
            this.f2376b = c1067b;
            this.f2375a = v;
        }

        static C1137a<Integer> m4345a(String str, int i) {
            return C1137a.m4346a(str, i, i);
        }

        static C1137a<Integer> m4346a(String str, int i, int i2) {
            return new C1137a(C1067b.m3883a(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static C1137a<Long> m4347a(String str, long j) {
            return C1137a.m4348a(str, j, j);
        }

        static C1137a<Long> m4348a(String str, long j, long j2) {
            return new C1137a(C1067b.m3884a(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static C1137a<String> m4349a(String str, String str2) {
            return C1137a.m4350a(str, str2, str2);
        }

        static C1137a<String> m4350a(String str, String str2, String str3) {
            return new C1137a(C1067b.m3885a(str, str3), str2);
        }

        static C1137a<Boolean> m4351a(String str, boolean z) {
            return C1137a.m4352a(str, z, z);
        }

        static C1137a<Boolean> m4352a(String str, boolean z, boolean z2) {
            return new C1137a(C1067b.m3886a(str, z2), Boolean.valueOf(z));
        }

        public V m4353a() {
            return this.f2377c != null ? this.f2377c : (C1000c.f1951a && C1067b.m3887b()) ? this.f2376b.m3891d() : this.f2375a;
        }
    }
}
