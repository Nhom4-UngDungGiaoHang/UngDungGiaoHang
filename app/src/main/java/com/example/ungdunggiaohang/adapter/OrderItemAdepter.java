package com.example.ungdunggiaohang.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdunggiaohang.R;
import com.example.ungdunggiaohang.entity.Order;
import com.example.ungdunggiaohang.utils.Helper;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;

public class OrderItemAdepter extends RecyclerView.Adapter<OrderItemAdepter.ViewHolder> {
    private List<Order> orderList;
    private Context context;
    private OnActionOrderItem onActionOrderItem;

    public OrderItemAdepter(List<Order> orderList, Context context, OnActionOrderItem onActionOrderItem) {
        this.orderList = orderList;
        this.context = context;
        this.onActionOrderItem = onActionOrderItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View orderView = inflater.inflate(R.layout.fragment_order_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(orderView, this.onActionOrderItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = this.orderList.get(position);

       holder.txtID.setText(order.getId());
       holder.txtCost.setText(Helper.getInstance().converDoubleToMoney(order.getCost()));
       holder.txtNamePackage.setText(order.getNamePackage());
       holder.txtDateSeen.setText(new SimpleDateFormat("dd.MM.yyyy").format(order.getDateSeen()));
       holder.txtFrom.setText(order.getFrom());
       holder.txtTo.setText(order.getTo());
    }

    @Override
    public int getItemCount() {
        return this.orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtID;
        private TextView txtCost;
        private TextView txtNamePackage;
        private TextView txtDateSeen;
        private TextView txtFrom;
        private TextView txtTo;
        private OnActionOrderItem onActionOrderItem;

        public ViewHolder(@NonNull View itemView, OnActionOrderItem onActionOrderItem) {
            super(itemView);

            this.onActionOrderItem = onActionOrderItem;

            txtID = itemView.findViewById(R.id.txtID);
            txtCost = itemView.findViewById(R.id.txtCost);
            txtNamePackage = itemView.findViewById(R.id.txtNamePackage);
            txtDateSeen = itemView.findViewById(R.id.txtDateSeen);
            txtFrom = itemView.findViewById(R.id.txtFrom);
            txtTo = itemView.findViewById(R.id.txtTo);

            itemView.setOnClickListener(this);        }

        @Override
        public void onClick(View view) {
            this.onActionOrderItem.onClickItem(getAdapterPosition());
        }
    }

    public interface  OnActionOrderItem {
        void onClickItem(int position);
    }
}
