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

public class TRANSPORT extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private Button bustops,rail, airport,ports;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        bustops =(Button) findViewById(R.id.bustops);
        rail =(Button) findViewById(R.id.rail);
        airport = (Button) findViewById(R.id.airport);
        ports =(Button) findViewById(R.id.ports);


        bustops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=bus stops");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        rail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=railway station");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        airport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=airport");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        ports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=ports");
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
        startActivity(new Intent(TRANSPORT.this,login.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.bustops:
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=bus stops");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;
            case R.id.rail:
                Uri gmm1IntentUri = Uri.parse("geo:0,0?q= railway station");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, gmm1IntentUri);
                intent1.setPackage("com.google.android.apps.maps");
                startActivity(intent1);
                break;
            case R.id.airport:
                Uri gmm2IntentUri = Uri.parse("geo:0,0?q=airport");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, gmm2IntentUri);
                intent2.setPackage("com.google.android.apps.maps");
                startActivity(intent2);
                break;
            case R.id.ports:
                Uri gmm3IntentUri = Uri.parse("geo:0,0?q=ports");
                Intent intent3 = new Intent(Intent.ACTION_VIEW, gmm3IntentUri);
                intent3.setPackage("com.google.android.apps.maps");
                startActivity(intent3);
                break;
        }
        return false;
    }
}
