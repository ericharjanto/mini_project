package com.eric.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    DBHandler mydb;
    DataModel usermodel;
    Button toList, btn_save;
    EditText input_nama, input_pass;

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.button2:
                    goToListUser();
                    break;
                case R.id.button3:
                    addUser();
                    break;
            }
        }
    };

    private void goToListUser(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toList = findViewById(R.id.button2);
        toList.setOnClickListener(myClickListener);
        input_nama = findViewById(R.id.et_nama);
        input_pass = findViewById(R.id.et_pass);
        btn_save = findViewById(R.id.button3);
        btn_save.setOnClickListener(myClickListener);

        mydb = new DBHandler(this);
    }

    private void addUser() {
        String nama = input_nama.getText().toString();
        String pass = input_pass.getText().toString();

        usermodel = new DataModel(1, nama, pass);
        mydb.insertUser(usermodel);
    }
}
