package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class UserPhysicalInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_physical_info);
    }

    public void GenderSelector(View v){
        Intent i = new Intent(this, GenderSelect.class);
        startActivity(i);
    }

    public void Extend(View v){
        Intent i = new Intent(this, UserPhysicalInfoPage2.class);
        i.putExtra("InfoClick", findViewById(R.id.Gender).toString());
        startActivity(i);
    }


}