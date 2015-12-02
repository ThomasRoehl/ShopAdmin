package com.example.iuliia.mydbapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shop_admin.db";
    public static final String TABLE_LOGIN = "login";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";


    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_LOGIN + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT );";
        db.execSQL(query);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        this.onCreate(db);
    }




    //Add new row to database
    public void addUser(Users user){

        Log.d("addUsers", user.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.get_username());
        values.put(COLUMN_EMAIL, user.get_email());
        values.put(COLUMN_PASSWORD, user.get_password());

        // 3. insert
        db.insert(TABLE_LOGIN, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        db.close();

    }



    // Get All Users
    public List<Users> getAllUsers() {
        List<Users> users = new LinkedList<Users>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_LOGIN;

       // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build user and add it to list
        Users user = null;
        if (cursor.moveToFirst()) {
            do {
                user = new Users();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setUsername(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPassword(cursor.getString(3));

                // Add user to users
                users.add(user);
            } while (cursor.moveToNext());
        }

        Log.d("getAllUsers()", users.toString());

        // return users
        return users;
    }






















//    //Delete product from the database
//    public void deleteProduct(String productName){
//        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");
//    }
//
    //Print out the database as a string
//    public String databaseToString(){
//        String dbString = "";
//        SQLiteDatabase db =  getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_LOGIN + " WHERE 1";
//
//        //Cursor point to a location in your result
//        Cursor c = db.rawQuery(query, null);
//        //Move to first row in your result
//        c.moveToFirst();
//
//        //Position after the last row means the end of the results
//        while (!c.isAfterLast()) {
//            if (c.getString(c.getColumnIndex("productname")) != null) {
//                dbString += c.getString(c.getColumnIndex("productname"));
//                dbString += "\n";
//            }
//            c.moveToNext();
//        }
//        db.close();
//        return dbString;
//    }
}
