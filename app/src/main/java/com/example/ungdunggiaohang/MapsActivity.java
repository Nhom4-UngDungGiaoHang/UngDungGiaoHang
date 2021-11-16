package com.example.ungdunggiaohang;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.ungdunggiaohang.databinding.ActivityMapsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.menu_map);
        bottomNav.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()){
                        case R.id.menu_order:
                            startActivity(new Intent(getApplicationContext(), ListOrder.class));
                            overridePendingTransition(0,0);
                            break;
                        case R.id.menu_map:

                            break;
                        case R.id.menu_imformation:
                            startActivity(new Intent(getApplicationContext(), Thongtinshipper.class));
                            overridePendingTransition(0,0);
                            break;
                    }
                    return false;
                });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng iuh = new LatLng(10.821862, 106.687752);
        mMap.addMarker(new MarkerOptions().position(iuh).title("IUH"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(iuh, 15f));
    }
}