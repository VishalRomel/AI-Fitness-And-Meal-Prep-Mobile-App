package com.example.fitnessapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WeeklyPlan extends AppCompatActivity {

    public static String Response ="heii";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_plan);
         TextView x1 =  findViewById(R.id.aiResponse);
         x1.setVisibility(View.INVISIBLE);
    }

    public void expandDay(View v){

        Button Sunday = findViewById(R.id.Day1);
        Button Monday = findViewById(R.id.Day2);
        TextView aiResponse =  findViewById(R.id.aiResponse);

        displayResponse(aiResponse);

        AlphaAnimation fadeOutAnimation = new AlphaAnimation(1f, 0f); // From 0% opacity (invisible) to 100% opacity (fully visible)
        fadeOutAnimation.setDuration(1000);

        AlphaAnimation fadeInAnimation = new AlphaAnimation(0f, 1f); // From 0% opacity (invisible) to 100% opacity (fully visible)
        fadeInAnimation.setDuration(500);

        if(Monday.getVisibility()==View.VISIBLE) {
            for (int i = 2; i <= 7; i++) {
                int DayID = getResources().getIdentifier("Day" + i, "id", getPackageName());
                View numpadButton = findViewById(DayID);
                numpadButton.startAnimation(fadeOutAnimation);
                numpadButton.setVisibility(View.INVISIBLE);
            }
            aiResponse.startAnimation(fadeInAnimation);
            aiResponse.setVisibility(View.VISIBLE);
        }else {
            aiResponse.startAnimation(fadeOutAnimation);
            aiResponse.setVisibility(View.INVISIBLE);
            for (int i = 2; i <= 7; i++) {
                int DayID = getResources().getIdentifier("Day" + i, "id", getPackageName());
                View numpadButton = findViewById(DayID);
                numpadButton.setVisibility(View.VISIBLE);
            }
        }
    }

    private void displayResponse(TextView aiResponse) {
        aiResponse.setText(Response);
    }

}