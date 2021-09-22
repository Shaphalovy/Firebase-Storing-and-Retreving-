package com.example.storedatafirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText,phoneEditText;
    private Button saveButton,showButton;

    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student Details");

        nameEditText = findViewById(R.id.nameEditTextId);
        phoneEditText = findViewById(R.id.phoneEditTextId);

        saveButton = findViewById(R.id.saveButtonId);
        showButton = findViewById(R.id.showButtonId);

        saveButton.setOnClickListener(this);
        showButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.saveButtonId){
            saveData();
        }
        if(view.getId()==R.id.showButtonId){
            Intent intent = new Intent(MainActivity.this,StudentDetails.class);
            startActivity(intent);
        }


    }

    private void saveData() {
        String name = nameEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();

        String key = databaseReference.push().getKey();

        StudentDetailsModel studentDetailsModel = new StudentDetailsModel(name,phone);

        databaseReference.child(key).setValue(studentDetailsModel);

        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
        nameEditText.setText("");
        phoneEditText.setText("");
        nameEditText.requestFocus();
    }
}