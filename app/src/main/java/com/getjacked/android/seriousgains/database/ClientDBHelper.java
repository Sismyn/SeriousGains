package com.getjacked.android.seriousgains.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.getjacked.android.seriousgains.database.ClientDBSchema.ClientTable;

/**
 * :,(
 */

public class ClientDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "clientBase.db";

    public ClientDBHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + ClientDBSchema.ClientTable.NAME + "(" +
        "_id integer primary key autoincrement, " +
                ClientTable.Cols.UUID + ", " +
                ClientTable.Cols.FIRSTNAME + ", " +
                ClientTable.Cols.LASTNAME + ", " +
                ClientTable.Cols.PRONOUNS + ", " +
                ClientTable.Cols.WEIGHT + ", " +
                ClientTable.Cols.HEIGHT + ", " +
                ClientTable.Cols.STREETADDRESS + ", " +
                ClientTable.Cols.CITY + ", " +
                ClientTable.Cols.STATE + ", " +
                ClientTable.Cols.ZIPCODE + ", " +
                ClientTable.Cols.CREDITCARDNUMBER + ", " +
                ClientTable.Cols.CREDITCARDTYPE + ", " +
                ClientTable.Cols.CVC + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }


}
