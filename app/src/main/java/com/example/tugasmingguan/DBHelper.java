package com.example.tugasmingguan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "registration.db";
    public static final String TABLE_NAME = "userRegis";
    public static final String COLUMN_1 = "ID";
    public static final String COLUMN_2 = "email";
    public static final String COLUMN_3 = "password";

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS userRegis");
        onCreate(db);
    }

    public long addUsers(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long res = db.insert("userRegis", null, contentValues);
        db.close();
        return res;
    }

    public boolean cekUsers(String email, String password) {
        String[] columns = {COLUMN_1};
        SQLiteDatabase db = getReadableDatabase();
        String select = COLUMN_2 + "=?" + "and" + COLUMN_3 + "=?";
        String[] selectArgs = {email, password};
        Cursor cursor = db.query(TABLE_NAME, columns, select, selectArgs, null, null, null);
        int src = cursor.getCount();
        cursor.close();
        db.close();

        if (src > 0) {
            return true;
        } else {
            return false;
        }
    }
}
