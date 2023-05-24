package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactHandler contactHandler = new ContactHandler(MainActivity.this);
        Log.d("ADD", "TAMBAH DATA");

//        tambahkan data contact
        contactHandler.addContact(new Contact("John", "083472385473"));
        contactHandler.addContact(new Contact("Mawar", "083472236423"));
        contactHandler.addContact(new Contact("Sekar", "083234312325"));

//        tampilkan data
        Log.d("VIEW", "TAMPILKAN DATA");
//        ArrayList<Contact> contactArrayList = contactHandler.getAllContacts();
//
//        for (Contact contact : contactArrayList) {
//            String baris = contact.getId() + " - " + contact.getNama() + " - " + contact.getNoHp();
//            Log.d("DATA KONTAK: ", baris);
//        }
    }
}