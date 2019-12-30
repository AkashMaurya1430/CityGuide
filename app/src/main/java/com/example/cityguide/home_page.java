package com.example.cityguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class home_page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button but1 = (Button) findViewById(R.id.button1);
        Button but2 = (Button) findViewById(R.id.button2);
        Button but3 = (Button) findViewById(R.id.button3);
        Button but4 = (Button) findViewById(R.id.button4);
        Button but5 = (Button) findViewById(R.id.button5);
        Button but6 = (Button) findViewById(R.id.button6);


        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(getApplicationContext(),BASIC_AMENITIES.class);
                startActivity(int1);
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(getApplicationContext(),ENTERTAINMENT.class);
                startActivity(int2);
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(getApplicationContext(),TRANSPORT.class);
                startActivity(int3);
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(getApplicationContext(), EMERGENCY.class);
                startActivity(int4);
            }
        });

        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5 = new Intent(getApplicationContext(), ATTRACTIONS.class);
                startActivity(int5);
            }
        });


        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(getApplicationContext(), RELIGIOUS_PLACES.class);
                startActivity(int6);
            }
        });






        drawerLayout= findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.religious_places:
                Intent intent = new Intent(home_page.this, RELIGIOUS_PLACES.class);
                startActivity(intent);
                break;
            case R.id.entertainment:
                startActivity(new Intent(home_page.this, ENTERTAINMENT.class));
                break;
            case R.id.basic_amenities:
                Intent i = new Intent(home_page.this, BASIC_AMENITIES.class);
                startActivity(i);
                break;
            case R.id.attraction:
                startActivity(new Intent(home_page.this, ATTRACTIONS.class));
                break;
            case R.id.transport:
                startActivity(new Intent(home_page.this, TRANSPORT.class));
                break;
            case R.id.emergency:
                startActivity(new Intent(home_page.this, EMERGENCY.class));
                break;



        }

        return false;
    }

    public void logout(View view) {
        startActivity(new Intent(home_page.this,login.class));
    }
}


