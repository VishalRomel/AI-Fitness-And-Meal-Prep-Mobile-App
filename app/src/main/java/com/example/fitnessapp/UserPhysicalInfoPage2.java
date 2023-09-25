package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class UserPhysicalInfoPage2 extends AppCompatActivity {

    int NextInfoCounter = 0;
    public String OptionClicked="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_physical_info_page2);
        setVisbileCalender(getIntent().getStringExtra("InfoClick"));
        findViewById(R.id.calendarView1).setVisibility(View.INVISIBLE);
        findViewById(R.id.weightCount).setVisibility(View.INVISIBLE);
    }
    //Go to the next Info
    public void nextGeneralInfo(View x) throws InterruptedException {
        NextInfoCounter++;
        if(NextInfoCounter==1)CalendarTrig(x);
        if(NextInfoCounter==2)height(x);
        if(NextInfoCounter==3)weight(x);
        if(NextInfoCounter==4){
            Intent i = new Intent(this, WriteFitnessGoal.class);
            startActivity(i);
        }

    }
    //Go back on previous Info
    public void back(View x) throws InterruptedException {
        NextInfoCounter--;
        if(NextInfoCounter==1)CalendarTrig(x);
        if(NextInfoCounter==2)height(x);
        if(NextInfoCounter==3)weight(x);
    }

    //When Users click the Numpad
    public void numClick(View num){
        System.out.println("numClick");
        Button click = (Button) num;

        //check which tablayout is visible and set to change its number base on what numpad user clicks
        if (findViewById(R.id.NumberInfo).getVisibility() == View.VISIBLE) {
           updateDsiplayNumber(click.getText(),findViewById(R.id.NumberInfo) );
        }else  updateDsiplayNumber(click.getText(),findViewById(R.id.weightCount) );

    }

    private void updateDsiplayNumber(CharSequence text, View tab) {

            System.out.println("rClick");
            // Assuming you have a reference to your TabLayout
            TabLayout tabLayout = (TabLayout) tab;

            // Get the currently selected tab
            int currentTab = tabLayout.getSelectedTabPosition();

            // Set the text of the currently selected tab to "1"
            TabLayout.Tab currentTabObject = tabLayout.getTabAt(currentTab);
            if (currentTabObject != null) {
                currentTabObject.setText(text.toString());
            }

            // Move the highlight to the next tab
            int nextTab = (currentTab + 1) % tabLayout.getTabCount();
            tabLayout.getTabAt(nextTab).select();

    }


    public void setVisbileCalender(String OptionClicked){

      //  CalendarView calendarView = findViewById(R.id.AgeCalendarView);


    }



    public void CalendarTrig(View K) throws InterruptedException {

//        if (findViewById(R.id.calendarView1).getVisibility() == View.VISIBLE) {
//            Intent i = new Intent(this, UserPhysicalInfo.class);
//            startActivity(i);
//        }


        // Hide the numpad views
        for (int i = 1; i <= 9; i++) {
            int numpadId = getResources().getIdentifier("numpad" + i, "id", getPackageName());
            View numpadButton = findViewById(numpadId);
            numpadButton.setVisibility(View.INVISIBLE);
        }

        TextView textView= findViewById(R.id.ageText);


        // Get a reference to the CalendarView
        CalendarView calendarView = findViewById(R.id.calendarView1);

        // Create a fade-in animation
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0f, 1f); // From 0% opacity (invisible) to 100% opacity (fully visible)
        fadeInAnimation.setDuration(1000); // Set the duration of the animation in milliseconds (1 second in this case)

        // Set an animation listener if you want to perform actions when the animation ends
        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Animation started (if you need to perform any actions)
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Animation ended (if you need to perform any actions)
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Animation repeated (if you need to perform any actions)
            }
        });

        textView.startAnimation(fadeInAnimation);
        textView.setText(" When's your Birthday?");

        // Start the fade-in animation and set the CalendarView's visibility to VISIBLE
        calendarView.startAnimation(fadeInAnimation);
        calendarView.setVisibility(View.VISIBLE);
    }

    public void height(View k){

        findViewById(R.id.calendarView1).setVisibility(View.INVISIBLE);
        findViewById(R.id.weightCount).setVisibility(View.INVISIBLE);
        findViewById(R.id.NumberInfo).setVisibility(View.VISIBLE);

        AlphaAnimation fadeInAnimation = new AlphaAnimation(0f, 1f);
        fadeInAnimation.setDuration(1000);

        TextView textView= findViewById(R.id.ageText);
        textView.startAnimation(fadeInAnimation);
        textView.setText("      Whats your height?");

        for (int i = 1; i <= 9; i++) {
            int numpadId = getResources().getIdentifier("numpad" + i, "id", getPackageName());
            View numpadButton = findViewById(numpadId);
            numpadButton.startAnimation(fadeInAnimation);
            numpadButton.setVisibility(View.VISIBLE);
        }

    }

    private void weight(View x) {

        AlphaAnimation fadeInAnimation = new AlphaAnimation(0f, 1f);
        fadeInAnimation.setDuration(1000);

        TextView textView= findViewById(R.id.ageText);
        textView.startAnimation(fadeInAnimation);
        textView.setText(" Whats your Weight(lb)?");
        findViewById(R.id.NumberInfo).setVisibility(View.INVISIBLE);
        findViewById(R.id.weightCount).setVisibility(View.VISIBLE);


    }

}