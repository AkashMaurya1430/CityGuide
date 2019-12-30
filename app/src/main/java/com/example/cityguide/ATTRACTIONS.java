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

public class ATTRACTIONS extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    private Button gardens,museums, histoplaces,zoo,artgallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);

        gardens =(Button) findViewById(R.id.gardens);
        museums =(Button) findViewById(R.id.museums);
        zoo = (Button) findViewById(R.id.zoo);
        histoplaces =(Button) findViewById(R.id.histoplaces);
        artgallery = (Button)findViewById(R.id.artgallery);

        gardens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=gardens");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        museums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=museums");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        histoplaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=historical places");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        zoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=zoos");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        artgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=art gallery");
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.gardens:
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=gardens");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;
            case R.id.museums:
                Uri gmm1IntentUri= Uri.parse("geo:0,0?q=museums");
                Intent intent1 = new Intent(Intent.ACTION_VIEW,gmm1IntentUri);
                intent1.setPackage("com.google.android.apps.maps");
                startActivity(intent1);                break;
            case R.id.histoplaces:
                Uri gmm2IntentUri= Uri.parse("geo:0,0?q=historical places");
                Intent intent2 = new Intent(Intent.ACTION_VIEW,gmm2IntentUri);
                intent2.setPackage("com.google.android.apps.maps");
                startActivity(intent2);
                break;
            case R.id.zoo:
                Uri gmm3IntentUri= Uri.parse("geo:0,0?q=zoos");
                Intent intent3 = new Intent(Intent.ACTION_VIEW,gmm3IntentUri);
                intent3.setPackage("com.google.android.apps.maps");
                startActivity(intent3);                break;
            case R.id.artgallery:
                Uri gmm4IntentUri= Uri.parse("geo:0,0?q=art gallery");
                Intent intent4 = new Intent(Intent.ACTION_VIEW,gmm4IntentUri);
                intent4.setPackage("com.google.android.apps.maps");
                startActivity(intent4);                break;
        }


            return false;
    }

    public void logout(View view) {
        startActivity(new Intent(ATTRACTIONS.this,login.class));
    }
}
