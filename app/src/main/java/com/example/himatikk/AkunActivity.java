package com.example.himatikk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AkunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        TextView nama = findViewById(R.id.namaakun);

        nama.setText(Preferences.getLoggedInUser(getBaseContext()));


        findViewById(R.id.btnlogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

    Preferences.clearLoggedInUser(getBaseContext()); startActivity(new Intent(getBaseContext(),
                LoginActivity.class));
                finish();
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.akun);
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
                    case R.id.akun:
                }
                return false;
            }
        });
    }
}
