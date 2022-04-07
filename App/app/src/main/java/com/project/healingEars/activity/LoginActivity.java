package com.project.healingEars.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;

import java.io.*;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.google.gson.JsonObject;
import com.project.healingEars.api.preference.CookieSharedPreference;
import com.project.healingEars.http.vo.userVO;
import com.project.healingEars.http.service.userService;

public class LoginActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    EditText userId, userPassword;
    Button loginBtn, joinBtn;

    EditText etPassword, etUsername;
    String passWord, userName;





    public class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params) {

            userVO userVO = new userVO(params[0], params[1]);//id, pwd
            //Call<String> stringCall = userService.getRetrofit(getApplicationContext()).login(userVO);
            Call<String> list = userService.getRetrofit(getApplicationContext()).Info();
            //Call<JsonObject> stringCall = userService.getRetrofit(getApplicationContext()).login(userVO);
            try {
                //return stringCall.execute().body();
                return list.execute().body();

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        /*
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.userId);
        etPassword = (EditText) findViewById(R.id.userPassword);
        loginbtn = (Button) findViewById(R.id.bt_login);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                userName = etUsername.getText().toString();
                passWord = etPassword.getText().toString();
                //loginCheck(userName, passWord);
            }
        });
         */

        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        BtnOnClickListener onClickListener = new BtnOnClickListener();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        Button btnSignup = findViewById(R.id.bt_signup);
        btnSignup.setOnClickListener(onClickListener);
        Button btnLogin = findViewById(R.id.bt_login);
        btnLogin.setOnClickListener(onClickListener);

        userId = (EditText) findViewById(R.id.et_userId);
        userPassword = (EditText) findViewById(R.id.et_userPassword);
        loginBtn = (Button) findViewById(R.id.bt_login);
        joinBtn = (Button) findViewById(R.id.bt_signup);
    }


    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.bt_login: // 로그인 버튼 눌렀을 경우
                    String loginid = userId.getText().toString();
                    String loginpwd = userPassword.getText().toString();
                    try {
                        String result = new LoginTask().execute(loginid, loginpwd, "login").get();

                        if (result.contains("true")) {
                            Toast.makeText(LoginActivity.this, "로그인", Toast.LENGTH_SHORT).show();
                            CookieSharedPreference pref = CookieSharedPreference.getInstanceOf(getApplicationContext());
                            pref.setUserID(loginid);

                            //Intent intent = new Intent(LoginActivity.this, activity_home.class);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                            startActivity(intent);
                            finish();
                        } else if (result.contains("false")) {
                            Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                            userId.setText("");
                            userPassword.setText("");
                        } else if (result.contains("email")) {
                            Toast.makeText(LoginActivity.this, "잘못된 이메일 형식입니다.", Toast.LENGTH_SHORT).show();
                            userId.setText("");
                            userPassword.setText("");
                        }
                    } catch (Exception ignored) {
                        Log.v("test","예외");
                    }
                    Log.v("test","종료");
                    break;
                case R.id.bt_signup: // 회원가입
                    //Intent intent = new Intent(getApplicationContext(), activity_signup.class);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    break; //테스트
            }
        }
    }

    //출처: https://dailylonnie0125.tistory.com/11 [미래의 나에게 과거의 나로부터]
}
