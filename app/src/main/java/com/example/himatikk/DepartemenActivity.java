package com.example.himatikk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DepartemenActivity extends AppCompatActivity {
    private ImageView pickeroh, picdanlog, pickesma, picsosma, picsospol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departemen);

        pickeroh = findViewById(R.id.kerohh);
        picdanlog = findViewById(R.id.danlogg);
        pickesma = findViewById(R.id.kesmaa);
        picsosma = findViewById(R.id.sosmaa);
        picsospol = findViewById(R.id.sospoll);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.departemen);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.departemen:
                        startActivity(new Intent(getApplicationContext(),DepartemenActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.contactus:
                        startActivity(new Intent(getApplicationContext(),ContactusActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.akun:
                        startActivity(new Intent(getApplicationContext(),AkunActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        pickeroh.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),
                        KerohActivity.class));

            }
        });

        picdanlog.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),
                        DanlogActivity.class));

            }
        });

        pickesma.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),
                        KesmaActivity.class));

            }
        });

        picsosma.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),
                        SosmaActivity.class));

            }
        });

        picsospol.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),
                        SospolActivity.class));

            }
        });
    }
}
