package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

public class addMember extends AppCompatActivity {
    private Button btnAddName, btnCancelAddMember;
    private EditText editTextAddName, editTextAddNum;
    ArrayList<Contact> contactArrayList;
    ContactHandler contactHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

//        context = new MainActivity();
        btnAddName = (Button) findViewById(R.id.btnAddName);
        btnCancelAddMember = (Button) findViewById(R.id.btnCancelAddMember);
        editTextAddName = (EditText) findViewById(R.id.editTextAddName);
        editTextAddNum = (EditText) findViewById(R.id.editTextAddNum);

        contactHandler = new ContactHandler(this);

//        contactArrayList = (ArrayList<Contact>) getIntent().getSerializableExtra("contactArraylist");


        setBtnCancelAddMember();
        setBtnAddName();
    }

    public void setBtnAddName() {
        btnAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextAddName.getText().toString();
                String telephoneNum = editTextAddNum.getText().toString();
//                Log.d("ERROR", editTextAddName.getText().toString());
//                Log.d("ERROR", editTextAddNum.getText().toString());

                contactHandler.addContact(new Contact(name, telephoneNum));

//                for (Contact contact : contactArrayList) {
//                    String baris = contact.getId() + " - " + contact.getNama() + " - " + contact.getNoHp();
//                    Log.d("DATA :   ", baris);
//                }
                Log.d("SETTING NAME", name);
                finish();
            }
        });
    }

    public void setBtnCancelAddMember() {
        btnCancelAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}