package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class WriteFitnessGoal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_fitness_goal);

//        WebView webView = findViewById(R.id.webview);
//
//        // Enable JavaScript (if needed)
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        webView.loadUrl("https://www.youtube.com/");
    }

    public void promptSubmit (View v) throws Exception {
        Intent i = new Intent(this, WeeklyPlan.class);

        TextInputEditText prompt = findViewById(R.id.aiPrompt);
        System.out.println(prompt.getText().toString());
        FitnessChatGPT x = new FitnessChatGPT(prompt.getText().toString());

        startActivity(i);

    }
}