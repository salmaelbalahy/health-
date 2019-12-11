package com.iscoapps.healthapp.DataBase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 *We need to create a class that extends from SQLiteOpenHelper.
 * This class perform CRUD operations (Create, Read, Update and Delete) on the database.
 *
 * We also need a model class to create Note objects to manage the notes easily.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "olx.db";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(User.CREATE_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);


        // Create tables again
        onCreate(db);
    }


    //-----------------start function of user --------------------------//
    public long insertUser(String name, String email, String password
            , String mobile, String city)
    {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(User.COLUMN_NAME, name);
        values.put(User.COLUMN_EMAIL, email);
        values.put(User.COLUMN_PASSWORD, password);
        values.put(User.COLUMN_DB, mobile);
        values.put(User.COLUMN_Gender, city);


        // insert row
        long id = db.insert(User.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public User getUser(String email) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        // cursor java class to hold rows from database
        Cursor cursor = db.query(User.TABLE_NAME,
                new String[]{User.COLUMN_ID, User.COLUMN_NAME, User.COLUMN_EMAIL
                        , User.COLUMN_PASSWORD, User.COLUMN_DB,
                        User.COLUMN_Gender,
                        User.COLUMN_TIMESTAMP},
                User.COLUMN_EMAIL + "=?",
                new String[]{email}, null, null, null, null);

        User user = null;
        if (cursor.moveToFirst())
        {

            // prepare user object
             user = new User(
                    cursor.getInt(cursor.getColumnIndex(User.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(User.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(User.COLUMN_EMAIL)),
                    cursor.getString(cursor.getColumnIndex(User.COLUMN_PASSWORD)),
                     cursor.getString(cursor.getColumnIndex(User.COLUMN_DB)),
                     cursor.getString(cursor.getColumnIndex(User.COLUMN_Gender)),
                    cursor.getString(cursor.getColumnIndex(User.COLUMN_TIMESTAMP)));
        }


        // close the db connection
        cursor.close();

        return user;
    }


}