package com.example.storedatafirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentDetails extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<StudentDetailsModel> studentDetailsModelList;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        databaseReference = FirebaseDatabase.getInstance().getReference("Student Details");

        studentDetailsModelList = new ArrayList<>();
        customAdapter = new CustomAdapter(StudentDetails.this, studentDetailsModelList);

        listView = findViewById(R.id.lisViewId);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                studentDetailsModelList.clear();

                for(DataSnapshot dataSnapshot1 : snapshot.getChildren()){

                    StudentDetailsModel studentDetailsModel = dataSnapshot1.getValue(StudentDetailsModel.class);

                    studentDetailsModelList.add(studentDetailsModel);
                }
                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onStart();
    }
}