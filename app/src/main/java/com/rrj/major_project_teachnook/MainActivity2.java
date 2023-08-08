package com.rrj.major_project_teachnook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rrj.major_project_teachnook.ui.gallery.GalleryFragment;

public class MainActivity2 extends AppCompatActivity {
    DBHelper db;
    EditText e3,e4,e5,e6;
    TextView t15;
    Button b2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e3 = findViewById(R.id.editTextTextPersonName2);
        e4 = findViewById(R.id.editTextTextPassword2);
        e5 = findViewById(R.id.editTextTextPassword3);
        e6 = findViewById(R.id.editTextTextPersonName3);
        t15 = findViewById(R.id.textView15);
        b2 = findViewById(R.id.button2);

        db = new DBHelper(MainActivity2.this);

        t15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(g);
            }
        });
//        Intent j = new Intent(MainActivity2.this, GalleryFragment.class);
//        startActivity(j);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e6.getText().toString();
                String username = e3.getText().toString();
                String password = e4.getText().toString();
                String rePassword = e5.getText().toString();
                if(username.isEmpty()||password.isEmpty()||rePassword.isEmpty()||name.isEmpty()){
                    Toast.makeText(MainActivity2.this, "ALL FIELDS ARE MANDATORY", Toast.LENGTH_SHORT).show();
                }
                else if(!username.contains("@gmail.com")){
                    Toast.makeText(MainActivity2.this, "INVALID E-MAIL", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUsername = db.checkUsername(username);
                    if(checkUsername){
                        Toast.makeText(MainActivity2.this, "USERNAME ALREADY EXIST", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(password.equals(rePassword)){
                            Boolean insert = db.insertData(name,username,password);
                            if(insert){
                                Toast.makeText(MainActivity2.this, "REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                                Intent u = new Intent(MainActivity2.this,MainActivity.class);
                                startActivity(u);
                            }
                            else{
                                Toast.makeText(MainActivity2.this, "REGISTRATION FAILED", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity2.this, "PASSWORDS ARE NOT MATCHING", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}