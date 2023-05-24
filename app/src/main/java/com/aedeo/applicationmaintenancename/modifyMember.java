package com.aedeo.applicationmaintenancename;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class modifyMember extends AppCompatActivity {
    private EditText editTextUpdateName, editTextUpdateNum;
    private Button btnUpdateMember, btnDeleteMember, btnCancelModify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editTextUpdateName = (EditText) findViewById(R.id.editTextUpdateName);
        editTextUpdateName = (EditText) findViewById(R.id.editTextUpdateNum);
        btnUpdateMember = (Button) findViewById(R.id.btnUpdateMember);
        btnDeleteMember = (Button) findViewById(R.id.btnDeleteMember);
        btnCancelModify = (Button) findViewById(R.id.btnCancelModify);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_member);

        btnCancelModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}