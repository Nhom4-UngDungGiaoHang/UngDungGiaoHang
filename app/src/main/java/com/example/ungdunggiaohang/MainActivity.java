package com.example.ungdunggiaohang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClickBtnTao(View v)
    {
        Intent intent= new Intent(MainActivity.this, Giaodien_Donhangmoi.class);
        startActivity(intent);
    }
    public void onClickBtnGiao(View v)
    {
        Intent intent= new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }
}