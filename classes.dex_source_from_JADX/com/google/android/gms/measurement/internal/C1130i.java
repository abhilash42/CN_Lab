package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.v4.p009e.C0189a;
import android.util.Pair;
import com.google.android.gms.common.internal.C1032p;
import com.google.android.gms.internal.C1086j.C1084d;
import com.google.android.gms.internal.C1093n;
import com.google.android.gms.internal.zztd;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

class C1130i extends ab {
    private static final Map<String, String> f2358a = new C0189a(5);
    private final C1129a f2359b = new C1129a(this, mo740i(), m4291A());
    private final C1122b f2360c = new C1122b(mo739h());

    private class C1129a extends SQLiteOpenHelper {
        final /* synthetic */ C1130i f2357a;

        C1129a(C1130i c1130i, Context context, String str) {
            this.f2357a = c1130i;
            super(context, str, null, 1);
        }

        private void m4287a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) {
            if (!m4289a(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                m4288a(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                this.f2357a.mo743l().m4399b().m4388a("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        private void m4288a(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) {
            Set b = m4290b(sQLiteDatabase, str);
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str3 = split[i];
                if (b.remove(str3)) {
                    i++;
                } else {
                    throw new SQLiteException("Database " + str + " is missing required column: " + str3);
                }
            }
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (!b.remove(entry.getKey())) {
                        sQLiteDatabase.execSQL((String) entry.getValue());
                    }
                }
            }
            if (!b.isEmpty()) {
                throw new SQLiteException("Database " + str + " table has extra columns");
            }
        }

        private boolean m4289a(SQLiteDatabase sQLiteDatabase, String str) {
            Cursor query;
            Object e;
            Throwable th;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{CLConstants.FIELD_PAY_INFO_NAME}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        this.f2357a.mo743l().m4412o().m4389a("Error querying for table", str, e);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                this.f2357a.mo743l().m4412o().m4389a("Error querying for table", str, e);
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private Set<String> m4290b(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (this.f2357a.f2360c.m4188a(this.f2357a.mo745n().m4281u())) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.f2357a.f2360c.m4187a();
                    this.f2357a.mo743l().m4399b().m4387a("Opening the database failed, dropping and recreating it");
                    this.f2357a.mo740i().getDatabasePath(this.f2357a.m4291A()).delete();
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.f2357a.f2360c.m4189b();
                    } catch (SQLiteException e2) {
                        this.f2357a.mo743l().m4399b().m4388a("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            m4287a(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            m4287a(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            m4287a(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", C1130i.f2358a);
            m4287a(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        f2358a.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        f2358a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        f2358a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        f2358a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        f2358a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
    }

    C1130i(C1164y c1164y) {
        super(c1164y);
    }

    private String m4291A() {
        if (!mo745n().m4246C()) {
            return mo745n().m4286z();
        }
        if (mo745n().m4247D()) {
            return mo745n().m4286z();
        }
        mo743l().m4413p().m4387a("Using secondary database");
        return mo745n().m4244A();
    }

    private boolean m4292B() {
        return mo740i().getDatabasePath(m4291A()).exists();
    }

    static int m4293a(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    private long m4294a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = m4314q().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            mo743l().m4399b().m4389a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public C1134m m4298a(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        C1032p.m3680a(str);
        C1032p.m3680a(str2);
        mo736e();
        m4091y();
        try {
            Cursor query = m4314q().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    C1134m c1134m = new C1134m(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        mo743l().m4399b().m4387a("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return c1134m;
                    }
                    query.close();
                    return c1134m;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo743l().m4399b().m4390a("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo743l().m4399b().m4390a("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public List<C1124d> m4299a(String str) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        C1032p.m3680a(str);
        mo736e();
        m4091y();
        List<C1124d> arrayList = new ArrayList();
        try {
            query = m4314q().query("user_attributes", new String[]{CLConstants.FIELD_PAY_INFO_NAME, "set_timestamp", CLConstants.FIELD_PAY_INFO_VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(mo745n().m4280t() + 1));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object b = m4309b(query, 2);
                        if (b == null) {
                            mo743l().m4399b().m4387a("Read invalid user attribute value, ignoring it");
                        } else {
                            arrayList.add(new C1124d(str, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (arrayList.size() > mo745n().m4280t()) {
                        mo743l().m4399b().m4387a("Loaded too many user attributes");
                        arrayList.remove(mo745n().m4280t());
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                mo743l().m4399b().m4389a("Error querying user attributes", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public List<Pair<C1084d, Long>> m4300a(String str, int i, int i2) {
        List<Pair<C1084d, Long>> arrayList;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        mo736e();
        m4091y();
        C1032p.m3685b(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        C1032p.m3685b(z);
        C1032p.m3680a(str);
        Cursor query;
        try {
            query = m4314q().query("queue", new String[]{"rowid", CLConstants.FIELD_DATA}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] b = mo741j().m4225b(query.getBlob(1));
                            if (!arrayList.isEmpty() && b.length + i3 > i2) {
                                break;
                            }
                            C1093n a = C1093n.m3964a(b);
                            C1084d c1084d = new C1084d();
                            try {
                                c1084d.m3952a(a);
                                length = b.length + i3;
                                arrayList.add(Pair.create(c1084d, Long.valueOf(j)));
                            } catch (IOException e2) {
                                mo743l().m4399b().m4389a("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            mo743l().m4399b().m4389a("Failed to unzip queued bundle", str, e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    arrayList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                mo743l().m4399b().m4389a("Error querying bundles", str, e);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    protected void mo733a() {
    }

    public void m4302a(long j) {
        mo736e();
        m4091y();
        if (m4314q().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            mo743l().m4399b().m4387a("Deleted fewer rows from queue than expected");
        }
    }

    void m4303a(ContentValues contentValues, String str, Object obj) {
        C1032p.m3680a(str);
        C1032p.m3678a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Float) {
            contentValues.put(str, (Float) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public void m4304a(C1084d c1084d) {
        mo736e();
        m4091y();
        C1032p.m3678a((Object) c1084d);
        C1032p.m3680a(c1084d.f2175o);
        C1032p.m3678a(c1084d.f2166f);
        m4316s();
        long a = mo739h().mo728a();
        if (c1084d.f2166f.longValue() < a - mo745n().m4248E() || c1084d.f2166f.longValue() > mo745n().m4248E() + a) {
            mo743l().m4412o().m4389a("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(a), c1084d.f2166f);
        }
        try {
            byte[] bArr = new byte[c1084d.m3932e()];
            zztd a2 = zztd.m4005a(bArr);
            c1084d.mo730a(a2);
            a2.m4038b();
            bArr = mo741j().m4222a(bArr);
            mo743l().m4417t().m4388a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", c1084d.f2175o);
            contentValues.put("bundle_end_timestamp", c1084d.f2166f);
            contentValues.put(CLConstants.FIELD_DATA, bArr);
            try {
                if (m4314q().insert("queue", null, contentValues) == -1) {
                    mo743l().m4399b().m4387a("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                mo743l().m4399b().m4388a("Error storing bundle", e);
            }
        } catch (IOException e2) {
            mo743l().m4399b().m4388a("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void m4305a(C1103a c1103a) {
        C1032p.m3678a((Object) c1103a);
        mo736e();
        m4091y();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c1103a.f2277a);
        contentValues.put("app_instance_id", c1103a.f2278b);
        contentValues.put("gmp_app_id", c1103a.f2279c);
        contentValues.put("resettable_device_id_hash", c1103a.f2280d);
        contentValues.put("last_bundle_index", Long.valueOf(c1103a.f2281e));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(c1103a.f2282f));
        contentValues.put("app_version", c1103a.f2283g);
        contentValues.put("app_store", c1103a.f2284h);
        contentValues.put("gmp_version", Long.valueOf(c1103a.f2285i));
        contentValues.put("dev_cert_hash", Long.valueOf(c1103a.f2286j));
        contentValues.put("measurement_enabled", Boolean.valueOf(c1103a.f2287k));
        try {
            if (m4314q().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                mo743l().m4399b().m4387a("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            mo743l().m4399b().m4388a("Error storing app", e);
        }
    }

    public void m4306a(C1124d c1124d) {
        C1032p.m3678a((Object) c1124d);
        mo736e();
        m4091y();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c1124d.f2351a);
        contentValues.put(CLConstants.FIELD_PAY_INFO_NAME, c1124d.f2352b);
        contentValues.put("set_timestamp", Long.valueOf(c1124d.f2353c));
        m4303a(contentValues, CLConstants.FIELD_PAY_INFO_VALUE, c1124d.f2354d);
        try {
            if (m4314q().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                mo743l().m4399b().m4387a("Failed to insert/update user attribute (got -1)");
            }
        } catch (SQLiteException e) {
            mo743l().m4399b().m4388a("Error storing user attribute", e);
        }
    }

    public void m4307a(C1134m c1134m) {
        C1032p.m3678a((Object) c1134m);
        mo736e();
        m4091y();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c1134m.f2370a);
        contentValues.put(CLConstants.FIELD_PAY_INFO_NAME, c1134m.f2371b);
        contentValues.put("lifetime_count", Long.valueOf(c1134m.f2372c));
        contentValues.put("current_bundle_count", Long.valueOf(c1134m.f2373d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c1134m.f2374e));
        try {
            if (m4314q().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                mo743l().m4399b().m4387a("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            mo743l().m4399b().m4388a("Error storing event aggregates", e);
        }
    }

    public C1103a m4308b(String str) {
        C1103a c1103a;
        Object e;
        Cursor cursor;
        Throwable th;
        C1032p.m3680a(str);
        mo736e();
        m4091y();
        Cursor cursor2 = null;
        try {
            Cursor query = m4314q().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    c1103a = new C1103a(str, query.getString(0), query.getString(1), query.getString(2), query.getLong(3), query.getLong(4), query.getString(5), query.getString(6), query.getLong(7), query.getLong(8), (query.isNull(9) ? 1 : query.getInt(9)) != 0);
                    if (query.moveToNext()) {
                        mo743l().m4399b().m4387a("Got multiple records for app, expected one");
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    c1103a = null;
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo743l().m4399b().m4389a("Error querying app", str, e);
                    c1103a = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return c1103a;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo743l().m4399b().m4389a("Error querying app", str, e);
            c1103a = null;
            if (cursor != null) {
                cursor.close();
            }
            return c1103a;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return c1103a;
    }

    Object m4309b(Cursor cursor, int i) {
        int a = C1130i.m4293a(cursor, i);
        switch (a) {
            case 0:
                mo743l().m4399b().m4387a("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Float.valueOf(cursor.getFloat(i));
            case 3:
                return cursor.getString(i);
            case 4:
                mo743l().m4399b().m4387a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                mo743l().m4399b().m4388a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a));
                return null;
        }
    }

    public void m4310b() {
        m4091y();
        m4314q().beginTransaction();
    }

    public void m4311b(String str, String str2) {
        C1032p.m3680a(str);
        C1032p.m3680a(str2);
        mo736e();
        m4091y();
        try {
            mo743l().m4417t().m4388a("Deleted user attribute rows:", Integer.valueOf(m4314q().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            mo743l().m4399b().m4390a("Error deleting user attribute", str, str2, e);
        }
    }

    public void m4312o() {
        m4091y();
        m4314q().setTransactionSuccessful();
    }

    public void m4313p() {
        m4091y();
        m4314q().endTransaction();
    }

    SQLiteDatabase m4314q() {
        mo736e();
        try {
            return this.f2359b.getWritableDatabase();
        } catch (SQLiteException e) {
            mo743l().m4412o().m4388a("Error opening database", e);
            throw e;
        }
    }

    public String m4315r() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = m4314q().rawQuery("SELECT q.app_id FROM queue q JOIN apps a ON a.app_id=q.app_id WHERE a.measurement_enabled!=0 ORDER BY q.rowid LIMIT 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo743l().m4399b().m4388a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            mo743l().m4399b().m4388a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void m4316s() {
        mo736e();
        m4091y();
        if (m4292B()) {
            long a = mo744m().f2450f.m4445a();
            long b = mo739h().mo729b();
            if (Math.abs(b - a) > mo745n().m4249F()) {
                mo744m().f2450f.m4446a(b);
                m4317t();
            }
        }
    }

    void m4317t() {
        mo736e();
        m4091y();
        if (m4292B()) {
            int delete = m4314q().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo739h().mo728a()), String.valueOf(mo745n().m4248E())});
            if (delete > 0) {
                mo743l().m4417t().m4388a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public long m4318u() {
        return m4294a("select max(bundle_end_timestamp) from queue", null, 0);
    }
}
