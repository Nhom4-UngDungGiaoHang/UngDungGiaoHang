package com.example.ungdunggiaohang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ungdunggiaohang.adapter.OrderItemAdepter;
import com.example.ungdunggiaohang.entity.Order;
import com.example.ungdunggiaohang.utils.SpacingItemDecorator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListOrder extends AppCompatActivity {
    private RecyclerView rcvListOrder;
    private List<Order> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);

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
}