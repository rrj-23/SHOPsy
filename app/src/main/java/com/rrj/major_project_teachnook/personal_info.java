package com.rrj.major_project_teachnook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rrj.major_project_teachnook.ui.home.HomeFragment;

import java.util.Locale;

public class personal_info extends AppCompatActivity {
    TextView t13,t14;
    Button b;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        t13 = findViewById(R.id.textView13);
        t14 = findViewById(R.id.textView14);
        b = findViewById(R.id.button4);

        Intent g = getIntent();
        t13.setText(g.getStringExtra("name").toUpperCase(Locale.ROOT));
        t14.setText(g.getStringExtra("email"));
//        b.setVisibility(View.GONE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent h = new Intent(personal_info.this,Home_Page.class);
//                startActivity(h);
                Toast.makeText(personal_info.this, "            Not working \n Use physical back button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}