package com.rrj.major_project_teachnook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    TextView t;
    EditText e1,e2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.textView);
        e1 = findViewById(R.id.editTextTextPersonName);
        e2 = findViewById(R.id.editTextTextPassword);
        b = findViewById(R.id.button);

        db = new DBHelper(MainActivity.this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean checkNamePass = db.checkUsernamePassword(username,password);
                if(username.isEmpty()||password.isEmpty()){
                    Toast.makeText(MainActivity.this, "ALL FIELDS ARE MANDATORY", Toast.LENGTH_SHORT).show();
                }
                else if(checkNamePass){
                    Intent i = new Intent(MainActivity.this,Home_Page.class);
                    i.putExtra("email",username);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "INVALID ENTRY", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(t);
            }
        });
    }
}