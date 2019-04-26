package thinking.preparing.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName5.db";
    public static final String CONTACTS_TABLE_NAME = "contacts4";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table CONTACTS_TABLE_NAME " +
                        "(name text,phone text,email text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS CONTACTS_TABLE_NAME");
        onCreate(db);
    }

    public boolean insertData(String name, String phone, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
//        values.put(CONTACTS_COLUMN_ID,1);
        values.put(CONTACTS_COLUMN_NAME,name);
        values.put(CONTACTS_COLUMN_PHONE,phone);
        values.put(CONTACTS_COLUMN_EMAIL,email);
        long result = db.insert(CONTACTS_TABLE_NAME,null,values);
        if(result == -1){
            return false;
        }else
            return true;


    }








}
