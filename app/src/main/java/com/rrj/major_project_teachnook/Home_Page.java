package com.rrj.major_project_teachnook;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.rrj.major_project_teachnook.databinding.ActivityHomePageBinding;
import com.rrj.major_project_teachnook.ui.slideshow.SlideshowFragment;

import java.util.Locale;

public class Home_Page extends AppCompatActivity {
    DBHelper2 db2;
    DBHelper d;
    TextView t1,t2,t14;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        d = new DBHelper(Home_Page.this);
        Intent g = getIntent();
        String s = g.getStringExtra("email");
//        System.out.println(s);
        setSupportActionBar(binding.appBarHomePage.toolbar);
//        binding.appBarHomePage.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.getMenu().findItem(R.id.per_info).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent f = new Intent(Home_Page.this, personal_info.class);
                f.putExtra("name",t2.getText().toString());
                f.putExtra("email",t1.getText().toString());
                startActivity(f);
                return false;
            }
        });

        View headView = navigationView.getHeaderView(0);
        t1 = headView.findViewById(R.id.textView);
        t1.setText(s);
        t2 = headView.findViewById(R.id.tv);
        String n="";
        Cursor c = d.getName1(s);
        while(c.moveToNext()){
            n = c.getString(0);
        }
        System.out.println(n);
        t2.setText(n.toUpperCase(Locale.ROOT));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home__page, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
//            case R.id.sign_out:
//                finish();
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void test(MenuItem item) {
        db2 = new DBHelper2(this);
        db2.deleteTable();

        Intent x = new Intent(this,MainActivity.class);
        x.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(x);

        Toast.makeText(this, "LOGOUT SUCCESSFULLY!!", Toast.LENGTH_SHORT).show();
    }
//    public void test2(MenuItem item){
//        Intent f = new Intent(this, personal_info.class);
//        f.putExtra("name",t2.getText().toString());
//        f.putExtra("email",t1.getText().toString());
//        startActivity(f);
//    }
}