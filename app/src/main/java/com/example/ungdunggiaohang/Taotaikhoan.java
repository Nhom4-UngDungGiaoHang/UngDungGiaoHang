package com.example.ungdunggiaohang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Taotaikhoan extends AppCompatActivity {

    private Button btntaotaikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taotaikhoan);
        btntaotaikhoan = (Button) findViewById(R.id.btntaotaikhoan);
        btntaotaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Taotaikhoan.this,Thongtinshipper.class);
                Taotaikhoan.this.startActivity(intent);
            }
        });
    }
}