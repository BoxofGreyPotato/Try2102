package com.example.try2102;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextFirstName, editTextLastName, editTextAge;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
        editTextFirstName = findViewById(R.id.etFirstName);
        editTextLastName = findViewById(R.id.etLastName);
        editTextAge = findViewById(R.id.etAge);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAdd){
            if (this.dbManager != null){
                String fName = editTextFirstName.getText().toString();
                String lName = editTextLastName.getText().toString();
                String age = editTextAge.getText().toString();
                if(!fName.isEmpty() && !lName.isEmpty() && !age.isEmpty()){
                    boolean result = dbManager.savePersonToDatabase(new Person(fName, lName, Boolean.parseBoolean(age)));
                    if (result){
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }
            } else if (v.getId() == R.id.btnNext) {
                startActivity(new Intent(this, PersonActivity.class));
            }
        }

    }
}