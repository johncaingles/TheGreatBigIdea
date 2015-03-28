package com.example.john.thegreatbigidea;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jolo Simeon on 3/28/2015.
 */
public class IdeasDBHelper extends SQLiteOpenHelper {
    private static final String COLUMN_IDEA_ID = "IDEA_ID";
    private static final String COLUMN_IDEA_NAME = "IDEA_NAME";
    private static final String COLUMN_IDEA_CATEGORY = "IDEA_CATEGORY";
    private static final String COLUMN_IDEA_IMAGE = "IDEA_IMAGE";
    private static final String COLUMN_IDEA_NOTE = "IDEA_NOTE";
    private static final String DATABASE_NAME = "SAVED_IDEAS";
    private static final String DATABASE_CREATE =
            "create table " + DATABASE_NAME + "("
                    + COLUMN_IDEA_ID + " integer primary key autoincrement, "
                    + COLUMN_IDEA_NAME + " text not null, "
                    + COLUMN_IDEA_CATEGORY + " text not null,"
                    + COLUMN_IDEA_IMAGE + " text not null,"
                    + COLUMN_IDEA_NOTE + " text " + ");";


    public IdeasDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
