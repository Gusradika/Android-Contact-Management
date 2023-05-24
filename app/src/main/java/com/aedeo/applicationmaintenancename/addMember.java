package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addMember extends AppCompatActivity {
    private Button btnAddName, btnCancelAddMember;
    private EditText editTextAddName, editTextAddNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        btnAddName=(Button) findViewById(R.id.btnAddName);
        btnCancelAddMember=(Button) findViewById(R.id.btnCancelAddMember);
        editTextAddName=(EditText) findViewById(R.id.editTextAddName);
        editTextAddNum=(EditText) findViewById(R.id.editTextAddNum);

        btnCancelAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}