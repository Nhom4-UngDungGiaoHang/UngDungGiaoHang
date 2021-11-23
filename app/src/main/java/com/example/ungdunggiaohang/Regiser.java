package com.example.ungdunggiaohang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Regiser extends AppCompatActivity {

    private EditText username, password1, password2;
    private ProgressBar progressBar;
    private String URL;
    private String TAG = "Regiser ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiser);
        username = findViewById(R.id.edt_username);
        password1 = findViewById(R.id.edt_password);
        password2 = findViewById(R.id.edt_nhaplaipassword);
        progressBar = findViewById(R.id.progressBar2);
        URL = getString(R.string.server_url);

        findViewById(R.id.btn_dangky).setOnClickListener(v -> dangKy());
    }

    private void dangKy() {
        if (!checkDangKy())
            return;

        JSONObject bodyRequest = new JSONObject();
        try {
            bodyRequest.put("username", username.getText());
            bodyRequest.put("password", password1.getText());
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL + "/account/register",
                bodyRequest,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        try {
                            int stt = response.getInt("status");
                            if (stt == 200)
                                startActivity(new Intent(Regiser.this, Login.class));
                            else
                                Toast.makeText(Regiser.this, "Dang ky khong thanh cong", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage());
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

    private boolean checkDangKy() {
        return true;
    }
}