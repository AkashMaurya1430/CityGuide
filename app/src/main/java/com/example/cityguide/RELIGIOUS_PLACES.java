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

public class RELIGIOUS_PLACES extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private Button temples,mosque,churches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religious__places);

        temples =(Button) findViewById(R.id.temples);
        mosque =(Button) findViewById(R.id.mosques);
        churches = (Button) findViewById(R.id.churches);

        temples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=temples");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        mosque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=mosque");
                Intent intent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        churches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri= Uri.parse("geo:0,0?q=churches");
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
        startActivity(new Intent(RELIGIOUS_PLACES.this,login.class));
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.temples:
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=temples");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
                break;
            case R.id.mosques:
                Uri gmm1IntentUri = Uri.parse("geo:0,0?q=mosques");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, gmm1IntentUri);
                intent1.setPackage("com.google.android.apps.maps");
                startActivity(intent1);
                break;
            case R.id.churches:
                Uri gmm2IntentUri = Uri.parse("geo:0,0?q=churches");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, gmm2IntentUri);
                intent2.setPackage("com.google.android.apps.maps");
                startActivity(intent2);
                break;
        }
        return false;
    }
}
