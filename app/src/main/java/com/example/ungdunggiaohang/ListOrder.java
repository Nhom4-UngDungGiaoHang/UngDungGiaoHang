package com.example.ungdunggiaohang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ungdunggiaohang.adapter.OrderItemAdepter;
import com.example.ungdunggiaohang.entity.Order;
import com.example.ungdunggiaohang.utils.SpacingItemDecorator;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListOrder extends AppCompatActivity {
    private RecyclerView rcvListOrder;
    private List<Order> orderList;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.menu_order);
        bottomNav.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()){
                        case R.id.menu_order:

                            break;
                        case R.id.menu_map:
                            startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                            overridePendingTransition(0,0);
                            break;
                        case R.id.menu_imformation:
                            startActivity(new Intent(getApplicationContext(), Thongtinshipper.class));
                            overridePendingTransition(0,0);
                            break;
                    }
                    return false;
                });
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        Button signOut = findViewById(R.id.btn_signout);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        rcvListOrder = findViewById(R.id.rcvListOrder);

        generateListOrder();

        OrderItemAdepter orderItemAdepter = new OrderItemAdepter(orderList, this);

        rcvListOrder.setAdapter(orderItemAdepter);
        SpacingItemDecorator spacingItemDecorator = new SpacingItemDecorator(40);
        rcvListOrder.addItemDecoration(spacingItemDecorator);
        rcvListOrder.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void generateListOrder() {
        orderList = new ArrayList<Order>() {
            {
                add(new Order("#011113213", 1000000, "quà sinh nhật", new Date(), "Hưng Hòa, Bàu Bàng, Bình Dương", "Phường 17, quận Gò Vấp, tpHCM"));
                add(new Order("#011113213", 1000000, "quà sinh nhật", new Date(), "Hưng Hòa, Bàu Bàng, Bình Dương", "Phường 17, quận Gò Vấp, tpHCM"));
                add(new Order("#011113213", 1000000, "quà sinh nhật", new Date(), "Hưng Hòa, Bàu Bàng, Bình Dương", "Phường 17, quận Gò Vấp, tpHCM"));
                add(new Order("#011113213", 1000000, "quà sinh nhật", new Date(), "Hưng Hòa, Bàu Bàng, Bình Dương", "Phường 17, quận Gò Vấp, tpHCM"));
                add(new Order("#011113213", 1000000, "quà sinh nhật", new Date(), "Hưng Hòa, Bàu Bàng, Bình Dương", "Phường 17, quận Gò Vấp, tpHCM"));

            }
        };
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ListOrder.this, "signout", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }
}