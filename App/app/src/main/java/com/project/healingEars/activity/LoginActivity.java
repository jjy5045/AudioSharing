package com.project.healingEars.activity;

import android.content.Intent;
import android.os.Bundle;
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


import com.example.app.R;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.project.healingEars.activity.test.proRentTestActivity;
import com.project.healingEars.api.preference.CookieSharedPreference;
import com.project.healingEars.http.dto.ProductRentDTO;
import com.project.healingEars.http.service.UserService;
import com.project.healingEars.http.vo.UserVO;

import retrofit2.Call;

public class LoginActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    int count = 0;

    EditText userId, userPwd;
    Button loginBtn, joinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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
        userPwd = (EditText) findViewById(R.id.et_userPassword);
        loginBtn = (Button) findViewById(R.id.bt_login);
        joinBtn = (Button) findViewById(R.id.bt_signup);
    }


    public class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params) {
            UserVO userVO = new UserVO(params[0], params[1]);//email, pwd
            //UserVO userVO = new UserVO("jjy0943@naver.com", "111111");
            Call<JsonObject> jsonCall = UserService.getRetrofit(getApplicationContext()).login(userVO);
            try {
                return jsonCall.execute().body().toString();
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


    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.bt_login: // 로그인 버튼 눌렀을 경우
                    String loginid = userId.getText().toString();
                    String loginpwd = userPwd.getText().toString();
                    try {
                        String result = new LoginTask().execute(loginid, loginpwd, "login").get();
                        ObjectMapper objectMapper = new ObjectMapper();
                        // FAIL_ON_UNKNOWN_PROPERTIES => null값이 포함되더라도 mapping 진행
                        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        ProductRentDTO body = objectMapper.readValue(result, ProductRentDTO.class);

                        if ((body.result).equals("SUCCESS")) {
                            Toast.makeText(LoginActivity.this, "로그인", Toast.LENGTH_SHORT).show();
                            CookieSharedPreference pref = CookieSharedPreference.getInstanceOf(getApplicationContext());
                            pref.setUserID(loginid);
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        } else if ((body.result).equals("FAIL")) {
                            Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                            userId.setText("");
                            userPwd.setText("");
                        }
                        /*
                        else if (body.contains("email")) {
                            Toast.makeText(LoginActivity.this, "잘못된 이메일 형식입니다.", Toast.LENGTH_SHORT).show();
                            userId.setText("");
                            userPwd.setText("");
                        }

                         */
                    } catch (Exception ignored) {
                    }
                    break;
                case R.id.bt_signup: // 회원가입
                    Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

}
