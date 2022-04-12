package com.project.healingEars.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.app.R;
import com.project.healingEars.api.preference.CookieSharedPreference;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CookieSharedPreference pref = CookieSharedPreference.getInstanceOf(getApplicationContext());
        pref.getUserID();
    }
}