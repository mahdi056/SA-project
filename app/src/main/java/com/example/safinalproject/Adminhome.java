package com.example.safinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Adminhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adminhome);

        Button btnInsertProduct =findViewById(R.id.btn_insert_product);
        Button btnViewProduct =findViewById(R.id.btn_view_product);

        btnInsertProduct.setOnClickListener(v -> {
            Intent intent = new Intent(Adminhome.this, InsertProductActivity.class);
            startActivity(intent);
        });


        btnViewProduct.setOnClickListener(v -> {
            Intent intent = new Intent(Adminhome.this, ViewProductActivity.class);
            startActivity(intent);
        });

    }
}