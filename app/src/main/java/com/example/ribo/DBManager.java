package com.example.ribo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    private SQLiteOpenHelper sqLiteHelper;

    public DBManager(SQLiteOpenHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public boolean savePersonToDatabase(Plant person) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("first_name", person.getName());
        cv.put("last_name", person.getRaznovidnost());
        cv.put("age", person.getTeplichnoe() ? 1 : 0);
        long rowId = db.insert("TABLE_PERSONS", null, cv);
        cv.clear();
        db.close();
        return rowId != -1;
    }

    public ArrayList<Plant> loadAllPersonsFromDatabase() {
        ArrayList<Plant> persons = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_PERSONS",
                null, null, null,
                null, null, null);
        if (dbCursor.moveToFirst()) {
            do {
                String fName = dbCursor.getString(dbCursor.getColumnIndexOrThrow("first_name"));
                String lName = dbCursor.getString(dbCursor.getColumnIndexOrThrow("last_name"));
                boolean age = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("age")) == 1;
                persons.add(new Plant(fName, lName, age));
            } while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return persons;
    }


}
