package com.example.app.database;

import static com.example.app.database.CountriesDbSchema.CountriesTable.NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.app.ImageItem;

public class CountriesBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "CountriesBase.db";
    public CountriesBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + NAME+"(" +
                " _id integer primary key autoincrement, " +
                        CountriesDbSchema.CountriesTable.Cols.continent + ", " +
                        CountriesDbSchema.CountriesTable.Cols.name + ", " +
                        CountriesDbSchema.CountriesTable.Cols.isfav   );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private static ContentValues getContentValues(ImageItem imageitem) {
        ContentValues values = new ContentValues();
        values.put(CountriesDbSchema.CountriesTable.Cols.continent, imageitem.getContinent());
        values.put(CountriesDbSchema.CountriesTable.Cols.name, imageitem.getText());
        values.put(CountriesDbSchema.CountriesTable.Cols.isfav,imageitem.isFav() ? 1 : 0);
        return values;
    }
}
