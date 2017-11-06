package org.npci.upi.security.pinactivitycomponent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class ab extends SQLiteOpenHelper {
    public ab(Context context) {
        super(context, "contactsManager", null, 1);
    }

    public String m6480a(String str, String str2, String str3) {
        List a = m6481a();
        return (a == null || a.isEmpty()) ? null : ((C1618u) a.get(0)).m6568a();
    }

    public List m6481a() {
        List arrayList = new ArrayList();
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT  * FROM contacts", null);
        if (rawQuery.moveToFirst()) {
            do {
                C1618u c1618u = new C1618u();
                c1618u.m6569a(rawQuery.getString(1));
                c1618u.m6571b(rawQuery.getString(2));
                c1618u.m6573c(rawQuery.getString(3));
                arrayList.add(c1618u);
            } while (rawQuery.moveToNext());
        }
        return arrayList;
    }

    void m6482a(C1618u c1618u) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("k0", c1618u.m6568a());
        contentValues.put("token", c1618u.m6570b());
        contentValues.put("date", c1618u.m6572c());
        writableDatabase.insert("contacts", null, contentValues);
        writableDatabase.close();
    }

    public int m6483b(C1618u c1618u) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("k0", c1618u.m6568a());
        contentValues.put("token", c1618u.m6570b());
        contentValues.put("date", c1618u.m6572c());
        return writableDatabase.update("contacts", contentValues, "k0 = ?", new String[]{c1618u.m6568a()});
    }

    public String m6484b() {
        String str = "";
        List a = m6481a();
        return (a == null || a.isEmpty()) ? str : ((C1618u) a.get(0)).m6570b();
    }

    public void m6485c() {
        C1605g.m6536b("DB Handler", "Deleting all");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.execSQL("delete from contacts");
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE contacts(id INTEGER PRIMARY KEY,k0 TEXT,token TEXT,date TEXT)");
        Log.e("Dynamic DB", "tables created");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sQLiteDatabase);
    }
}
