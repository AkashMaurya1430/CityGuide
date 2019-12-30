package com.example.cityguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class EMERGENCY extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private Button policestation, fire, hospitals, shelterhomes, garage, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        policestation = (Button) findViewById(R.id.policestation);
        fire = (Button) findViewById(R.id.fire);
        hospitals = (Button) findViewById(R.id.hospitals);
        shelterhomes = (Button) findViewById(R.id.shelterhomes);
        garage = (Button) findViewById(R.id.garage);
        phone = (Button) findViewById(R.id.phone);

        policestation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=police station");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=fire brigade");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        hospitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospitals");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        shelterhomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q= shelterhomes");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        garage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=garages");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9870941743"));
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
            case R.id.policestation:
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=police stations");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;
            case R.id.fire:
                Uri gmm1IntentUri= Uri.parse("geo:0,0?q=fire brigade");
                Intent intent1 = new Intent(Intent.ACTION_VIEW,gmm1IntentUri);
                intent1.setPackage("com.google.android.apps.maps");
                startActivity(intent1);
                break;
            case R.id.hospitals:
                Uri gmm2IntentUri= Uri.parse("geo:0,0?q=hospitals");
                Intent intent2 = new Intent(Intent.ACTION_VIEW,gmm2IntentUri);
                intent2.setPackage("com.google.android.apps.maps");
                startActivity(intent2);
                break;
            case R.id.shelterhomes:
                Uri gmm3IntentUri= Uri.parse("geo:0,0?q=shelter homes");
                Intent intent3 = new Intent(Intent.ACTION_VIEW,gmm3IntentUri);
                intent3.setPackage("com.google.android.apps.maps");
                startActivity(intent3);                break;
            case R.id.garage:
                Uri gmm4IntentUri= Uri.parse("geo:0,0?q=garages");
                Intent intent4 = new Intent(Intent.ACTION_VIEW,gmm4IntentUri);
                intent4.setPackage("com.google.android.apps.maps");
                startActivity(intent4);                break;


        }
        return false;
    }

    public void logout(View view) {
        startActivity(new Intent (EMERGENCY.this,login.class));
    }
}
