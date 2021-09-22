package com.example.storedatafirebase;

import android.widget.EditText;

public class StudentDetailsModel {
    String name;
    String phone;

    public StudentDetailsModel() {

    }

    public StudentDetailsModel(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
