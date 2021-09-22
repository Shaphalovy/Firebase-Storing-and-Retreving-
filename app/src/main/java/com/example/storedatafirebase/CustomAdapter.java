package com.example.storedatafirebase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<StudentDetailsModel> {

    private Activity context;
    private List<StudentDetailsModel> studentDetailsModelList;

    public CustomAdapter(Activity context, List<StudentDetailsModel> studentDetailsModelList) {
        super(context, R.layout.sample_view, studentDetailsModelList);
        this.context = context;
        this.studentDetailsModelList = studentDetailsModelList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.sample_view,null, true);

        StudentDetailsModel studentDetailsModel = studentDetailsModelList.get(position);

        TextView t1 = view.findViewById(R.id.nameTextView);
        TextView t2 = view.findViewById(R.id.phoneTextView);

        t1.setText(studentDetailsModel.getName());
        t2.setText(studentDetailsModel.getPhone());


        return view;
    }
}
