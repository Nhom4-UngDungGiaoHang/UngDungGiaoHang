package com.example.ungdunggiaohang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickBtn(View v)
    {
        Intent intent= new Intent(Login.this, Regiser.class);
        startActivity(intent);
    }
    public void onClickBtnDonHang(View v)
    {
        Intent intent= new Intent(Login.this, ListOrder.class);
        startActivity(intent);
    }
}