package com.example.safinalproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AcademyListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AcademyAdapter academyAdapter;
    private List<Academy> academyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academy_list);

        // Initialize recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data
        academyList = new ArrayList<>();
        academyList.add(new Academy("Dhaka Cricket Academy", "dhaka@academy.com", "+880123456789", "Dhaka", "Mirpur"));
        academyList.add(new Academy("Chittagong Cricket Center", "chittagong@center.com", "+880987654321", "Chittagong", "Railway Station"));
        academyList.add(new Academy("Green Sylhet Cricket Academy", "gsca@gmail.com", "+880987654521", "Sylhet", "Stadium"));
        academyList.add(new Academy("Clemon Surma Cricket Academy", "csca@gmail.com", "+8801785648861", "Sylhet", "Balushor"));
        academyList.add(new Academy("Basic Cricket Academy", "basic@gmail.com", "+880987654131", "Sylhet", "Sylhet Stadium"));
        academyList.add(new Academy("Dhanmondi Cricket Academy", "dhanmondi@gmail.com", "+8801782348861", "Dhaka", "Dhanmondi"));
        academyList.add(new Academy("Bangladesh Cricket Academy", "bca@gmail.com", "+8801785648241", "Dhaka", "Dhanmondi"));
        academyList.add(new Academy("BKSP", "bksp@gmail.com", "+8801785248861", "Dhaka", "Konapara"));



        // Set adapter here
        academyAdapter = new AcademyAdapter(academyList);
        recyclerView.setAdapter(academyAdapter);
    }
}
