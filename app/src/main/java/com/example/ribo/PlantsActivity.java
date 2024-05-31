package com.example.ribo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.try2102.R;

import java.util.ArrayList;

public class PlantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        DBManager dbManager = new DBManager(new MyAppSQLiteHelper(getApplication(), "my_database.db", null, 1));

        ArrayList<Plant> plants = dbManager.loadAllPersonsFromDatabase();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        PlantAdapter plantAdapter = new PlantAdapter(plants);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(plantAdapter);
    }
}