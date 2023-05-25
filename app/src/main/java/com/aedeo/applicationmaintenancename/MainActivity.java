package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdapterContact adapterContact;
    private Button btnAddMember;
    private ListView listViewMember;
    private ArrayList<Contact> contactArrayList;

    private ContactHandler contactHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        deklarasi
        btnAddMember = (Button) findViewById(R.id.btnAddMember);
        listViewMember = (ListView) findViewById(R.id.listViewMember);

        contactHandler = new ContactHandler(MainActivity.this);
        Log.d("ADD", "TAMBAH DATA");

//        tambahkan data contact
        contactHandler.addContact(new Contact("Abiyansyah", "083472384444"));
        contactHandler.addContact(new Contact("Linus Torvald", "0834722365555"));
        contactHandler.addContact(new Contact("Gabe Newell", "083234312125"));

//        tampilkan data
        Log.d("VIEW", "TAMPILKAN DATA");
        contactArrayList = contactHandler.getAllContacts();

        adapterContact = new AdapterContact(MainActivity.this, contactArrayList);
        listViewMember.setAdapter(adapterContact);

        clickBtnAddMember();
        listViewMember();
    }

    @Override
    protected void onResume() {
        super.onResume();

        contactArrayList = contactHandler.getAllContacts();
        adapterContact = new AdapterContact(MainActivity.this, contactArrayList);
        listViewMember.setAdapter(adapterContact);
//        adapterContact.notifyDataSetChanged();
    }

    public void listViewMember() {
        listViewMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                  @Override
                                                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                      Log.d("POSITION", String.valueOf(position));
                                                      Intent intent = new Intent(MainActivity.this, modifyMember.class);
//                intent.putExtra("contactArraylist", contactArrayList);
                                                      intent.putExtra("id",String.valueOf(id));
//                                                      Log.d(TAG, "onItemClick: ");
                                                      startActivity(intent);
                                                  }
                                              }
        );
    }

    public void clickBtnAddMember() {
        btnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, addMember.class);
//                intent.putExtra("contactArraylist", contactArrayList);
                startActivity(intent);
            }
        });
    }
}