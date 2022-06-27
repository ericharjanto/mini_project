package com.eric.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DBHandler mydb;
    ListView lv_data;

    Button toAdd;

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.button:
                    goToAddUser();
                    break;
            }
        }
    };

    private void goToAddUser(){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toAdd = findViewById(R.id.button);
        toAdd.setOnClickListener(myClickListener);

        mydb = new DBHandler(this);

        List<ArrayList> data = mydb.getAll();
        Log.d("Data", String.valueOf(data));

        lv_data = (ListView) findViewById(R.id.lv);
//        ArrayAdapter<String> aAdapter =
//                new ArrayAdapter<String>(this,
//                        R.layout.listview,
//                        R.id.textView4);

        CustomAdapter cAdapter = new CustomAdapter(getApplicationContext(), data);
        lv_data.setAdapter(cAdapter);

    }
}