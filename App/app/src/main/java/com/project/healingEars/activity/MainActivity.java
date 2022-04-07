package com.project.healingEars.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

import retrofit2.Retrofit;
import com.project.healingEars.http.service.constants_RestAPI;
import com.project.healingEars.http.retrofitClient;

public class MainActivity extends AppCompatActivity {
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_login);
    }
    */

    private constants_RestAPI constants_RestAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retrofit retrofit = retrofitClient.getInstance();
        //constants_RestAPI = retrofit.create(constants_RestAPI.getClass());

        //abc = constants_RestAPI.getFunc();

        //callRetrofit = new getApiService();
        //callRetrofit = new
        // constants_RestAPI에서 설정한 코드 입력

    }
}