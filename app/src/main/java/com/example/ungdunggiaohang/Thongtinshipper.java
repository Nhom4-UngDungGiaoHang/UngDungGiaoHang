package com.example.ungdunggiaohang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Thongtinshipper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinshipper);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.menu_imformation);
        bottomNav.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()){
                        case R.id.menu_order:
                            startActivity(new Intent(getApplicationContext(), ListOrder.class));
                            overridePendingTransition(0,0);
                            break;
                        case R.id.menu_map:
                            startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                            overridePendingTransition(0,0);
                            break;
                        case R.id.menu_imformation:
                            break;
                    }
                    return false;
                });
    }
}