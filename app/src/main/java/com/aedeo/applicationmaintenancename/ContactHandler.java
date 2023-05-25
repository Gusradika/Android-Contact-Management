package com.aedeo.applicationmaintenancename;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    private static final String DICTIONARY_TABLE_NAME = "contactsManager";
    private static final String DATABASE_NAME = "contacts";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "nama";
    private static final String COL_NO = "no_hp";
    private static final String DICTIONARY_TABLE_CREATE = "CREATE TABLE " + DICTIONARY_TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + "  TEXT," + COL_NO + " TEXT)";

    SQLiteDatabase db;

    public ContactHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DICTIONARY_TABLE_NAME);
        onCreate(db);
    }

    public void addContact(Contact contact) {
        db = this.getWritableDatabase();    // mendapatkan db yang ada di dalam file ini
                                            // yang dapat dimodify (CREATE)

        ContentValues values = new ContentValues();     // menciptakan element yang dapat digunakan
                                                        // untuk menyimpan value yang akan dimasukkan ke db

        values.put(COL_NAME, contact.getNama());    // memasukkan contact name ke dalam value
        values.put(COL_NO, contact.getNoHp());      // memasukkan contact phone ke dalam value

        db.insert(DICTIONARY_TABLE_NAME, null, values);     // masukkan data yang telah
                                                                        // dimasukkan ke values ke dalam database

        db.close();         // tutup database
    }

    public Contact getContact(Integer id) {
        db = this.getReadableDatabase();            // dapatkan database yang dapat dibaca (READ)
        id++;
        Log.d("ID SEKARANG", String.valueOf(id));



        Cursor cursor = db.query(
                DICTIONARY_TABLE_NAME,                      // nama table
                new String[]{COL_ID, COL_NAME, COL_NO},
                COL_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();       // jika cursor telah terisi maka pindahkan cursor ke bagian paling awal
            int idx = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME));
            int number = cursor.getInt(cursor.getColumnIndexOrThrow(COL_NO));

            Log.d("FF", String.valueOf(idx));
            Log.d("GG", name);
            Log.d("HH", String.valueOf(number));

        }

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        return contact;
    }

    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contactArrayList = new ArrayList<Contact>();
        String selectQuery = "SELECT * FROM " + DICTIONARY_TABLE_NAME;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();  // declare class contact baru

//                contact.setId(Integer.valueOf(cursor.getString(0)));   // set id
                contact.setId(cursor.getInt(0));        // set id
                contact.setNama(cursor.getString(1));   // set nama contact
                contact.setNoHp(cursor.getString(2));   // set no hp contact

                contactArrayList.add(contact);  // tambahkan class contact ke dalam Arraylist contact
            } while (cursor.moveToNext());
        }
        return contactArrayList;
    }

    public void updateContact(Contact contact) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        Log.d("IN CONTACT",contact.getNama());
        Log.d("IN CONTACT",contact.getNoHp() );
        values.put(COL_NAME, contact.getNama());
        values.put(COL_NO, contact.getNoHp());

        db.update(DICTIONARY_TABLE_NAME, values, COL_ID + "=?",
                new String[]{String.valueOf(contact.getId())});
    }

    public void deleteContact(Contact contact) {
        db = this.getWritableDatabase();
        db.delete(DICTIONARY_TABLE_NAME, COL_ID + "=?", new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    public Integer getContactsCount() {
        String countQuery="SELECT * FROM "+DICTIONARY_TABLE_NAME;
        db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}
