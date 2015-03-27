package com.example.john.thegreatbigidea;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jolo Simeon on 3/28/2015.
 */
public class IdeasDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_CREATE =
            "create table " + "saved_ideas" + "("
                    + "IDEA_ID" + " integer primary key, "
                    + "IDEA_NAME" + " text not null, "
                    + "IDEA_COMMENT" + " text not null);";


    public IdeasDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
