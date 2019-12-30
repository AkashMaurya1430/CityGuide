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

public class BASIC_AMENITIES extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private Button pp,schools, colleges,markets,orphanage,oah,accomadation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic__amenities);

        pp =(Button) findViewById(R.id.pp);
        schools =(Button) findViewById(R.id.schools);
        colleges = (Button) findViewById(R.id.colleges);
        markets =(Button) findViewById(R.id.markets);
        orphanage = (Button)findViewById(R.id.orphanage);
        oah = (Button)findViewById(R.id.oah);
        accomadation = (Button)findViewById(R.id.accomadation);

        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=petrol pumps");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        schools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=schools");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        colleges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=colleges");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        markets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=markets");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        orphanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=orpahanges");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        oah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=old age homes");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        accomadation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=hostels");
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
            case R.id.petrol_pump:
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=petrol pumps");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;
            case R.id.schools:
                Uri gmm1IntentUri= Uri.parse("geo:0,0?q=schools");
                Intent intent1 = new Intent(Intent.ACTION_VIEW,gmm1IntentUri);
                intent1.setPackage("com.google.android.apps.maps");
                startActivity(intent1);
                break;
            case R.id.colleges:
                Uri gmm2IntentUri= Uri.parse("geo:0,0?q=colleges");
                Intent intent2 = new Intent(Intent.ACTION_VIEW,gmm2IntentUri);
                intent2.setPackage("com.google.android.apps.maps");
                startActivity(intent2);
                break;
            case R.id.markets:
                Uri gmm3IntentUri= Uri.parse("geo:0,0?q=markets");
                Intent intent3 = new Intent(Intent.ACTION_VIEW,gmm3IntentUri);
                intent3.setPackage("com.google.android.apps.maps");
                startActivity(intent3);                break;
            case R.id.orphanage:
                Uri gmm4IntentUri= Uri.parse("geo:0,0?q=orpahanges");
                Intent intent4 = new Intent(Intent.ACTION_VIEW,gmm4IntentUri);
                intent4.setPackage("com.google.android.apps.maps");
                startActivity(intent4);                break;
            case R.id.old_age:
                Uri gmm5IntentUri= Uri.parse("geo:0,0?q=old age homes");
                Intent intent5 = new Intent(Intent.ACTION_VIEW,gmm5IntentUri);
                intent5.setPackage("com.google.android.apps.maps");
                startActivity(intent5);                break;
            case R.id.accomadation:
                Uri gmm6IntentUri= Uri.parse("geo:0,0?q=hostels");
                Intent intent6 = new Intent(Intent.ACTION_VIEW,gmm6IntentUri);
                intent6.setPackage("com.google.android.apps.maps");
                startActivity(intent6);                break;

        }

        return false;
    }

    public void logout(View view) {
        startActivity(new Intent(BASIC_AMENITIES.this,login.class));

    }
}
