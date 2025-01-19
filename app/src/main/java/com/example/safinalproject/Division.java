package com.example.safinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Division extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_division);

        Button btnsylhet = findViewById(R.id.btn_sylhet);
        Button btndhaka = findViewById(R.id.btn_dhaka);
        Button btnchittagong = findViewById(R.id.btn_chittagong);
        Button btnkhulna = findViewById(R.id.btn_khulna);
        Button btnrajshahi = findViewById(R.id.btn_rajshahi);
        Button btnbarisal = findViewById(R.id.btn_barisal);
        Button btnrangpur = findViewById(R.id.btn_ragpur);
        Button btnmymensingh = findViewById(R.id.btn_mymensingh);



        btnsylhet.setOnClickListener(v -> {
            Intent intent = new Intent(Division.this, MainActivity.class);
            startActivity(intent);
        });

        btndhaka.setOnClickListener(v -> {
            Intent intent = new Intent(Division.this, MainActivity.class);
            startActivity(intent);
        });

        btnchittagong.setOnClickListener(v -> {
            Intent intent = new Intent(Division.this, MainActivity.class);
            startActivity(intent);
        });

        btnkhulna.setOnClickListener(v -> {
            Intent intent = new Intent(Division.this, MainActivity.class);
            startActivity(intent);
        });

        btnrajshahi.setOnClickListener(v -> {
            Intent intent = new Intent(Division.this, MainActivity.class);
            startActivity(intent);
        });

        btnbarisal.setOnClickListener(v -> {
            Intent intent = new Intent(Division.this, MainActivity.class);
            startActivity(intent);
        });

        btnrangpur.setOnClickListener(v -> {
            Intent intent = new Intent(Division.this, MainActivity.class);
            startActivity(intent);
        });

        btnmymensingh.setOnClickListener(v -> {
            Intent intent = new Intent(Division.this, MainActivity.class);
            startActivity(intent);
        });




    }
}