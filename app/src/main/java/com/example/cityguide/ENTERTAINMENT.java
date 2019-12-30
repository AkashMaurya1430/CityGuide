package com.example.cityguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class ENTERTAINMENT extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
        DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private Button malls,theaters, restaurants,amusements,cafes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);

        malls =(Button) findViewById(R.id.malls);
        theaters =(Button) findViewById(R.id.theaters);
        restaurants = (Button) findViewById(R.id.restaurants);
        amusements =(Button) findViewById(R.id.amusements);
        cafes = (Button)findViewById(R.id.cafes);

        malls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=malls");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        theaters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=theaters");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=restaurants ");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        amusements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=amusements");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        cafes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=cafes");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
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

    public void logout(View view) {
        startActivity(new Intent(ENTERTAINMENT.this,login.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.malls:
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=malls");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;
            case R.id.theaters:
                Uri gmm1IntentUri= Uri.parse("geo:0,0?q=theaters");
                Intent intent1 = new Intent(Intent.ACTION_VIEW,gmm1IntentUri);
                intent1.setPackage("com.google.android.apps.maps");
                startActivity(intent1);
                break;
            case R.id.restaurants:
                Uri gmm2IntentUri= Uri.parse("geo:0,0?q=restaurants");
                Intent intent2 = new Intent(Intent.ACTION_VIEW,gmm2IntentUri);
                intent2.setPackage("com.google.android.apps.maps");
                startActivity(intent2);
                break;
            case R.id.amusements:
                Uri gmm3IntentUri= Uri.parse("geo:0,0?q=amusement parks");
                Intent intent3 = new Intent(Intent.ACTION_VIEW,gmm3IntentUri);
                intent3.setPackage("com.google.android.apps.maps");
                startActivity(intent3);                break;
            case R.id.cafes:
                Uri gmm4IntentUri= Uri.parse("geo:0,0?q=cafes");
                Intent intent4 = new Intent(Intent.ACTION_VIEW,gmm4IntentUri);
                intent4.setPackage("com.google.android.apps.maps");
                startActivity(intent4);                break;


        }
        return false;
    }
}
