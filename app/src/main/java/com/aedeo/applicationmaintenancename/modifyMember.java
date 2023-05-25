package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class modifyMember extends AppCompatActivity {
    private EditText editTextUpdateName, editTextUpdateNum;
    private Button btnUpdateMember, btnDeleteMember, btnCancelModify;

    Contact x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_member);
        ContactHandler contact = new ContactHandler(this);

        editTextUpdateName = (EditText) findViewById(R.id.editTextUpdateName);
        editTextUpdateNum = (EditText) findViewById(R.id.editTextUpdateNum);
        btnUpdateMember = (Button) findViewById(R.id.btnUpdateMember);
        btnDeleteMember = (Button) findViewById(R.id.btnDeleteMember);
        btnCancelModify = (Button) findViewById(R.id.btnCancelModify);

        Intent intent = getIntent();
        Integer position = Integer.valueOf(intent.getExtras().getString("id")) - 1;
        Log.d("TAG", String.valueOf(position));


        x = contact.getContact(position);

        editTextUpdateName.setText(x.getNama());
        editTextUpdateNum.setText(x.getNoHp());

        Log.d("XX",  x.getNama().toString());
        Log.d("XX",  x.getNoHp().toString());

        btnUpdateMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BTN UPDATE position",String.valueOf(position));
                Log.d("BTN UPDATE",editTextUpdateName.getText().toString() );
                Log.d("BTN UPDATE",editTextUpdateNum.getText().toString() );
                x.setNama(editTextUpdateName.getText().toString());
                x.setNoHp(editTextUpdateNum.getText().toString());
//                x = new Contact(editTextUpdateName.getText().toString(), editTextUpdateNum.getText().toString());
                Log.d("AFTER UPDATE",String.valueOf(x.getId()));
                Log.d("AFTER UPDATE",x.getNama());
                Log.d("AFTER UPDATE",x.getNoHp() );
                contact.updateContact(x);
                finish();
            }
        });

        btnDeleteMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact.deleteContact(x);
                finish();
            }
        });

        btnCancelModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}