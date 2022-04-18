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
import com.project.healingEars.api.preference.CookieSharedPreference;
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

    // Activity에서 비동기 연결
    /*
    public class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params) {
            UserVO userVO = new UserVO(params[0], params[1]);//email, pwd
            //UserVO userVO = new UserVO("jjy0943@naver.com", "111111");
            Call<String> jsonCall = UserRepository.getRetrofit(getApplicationContext()).loginString(userVO);
            try {
                return jsonCall.execute().body();
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
    */


    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            /*
            switch (view.getId()) {

                case R.id.bt_login: // 로그인 버튼 눌렀을 경우
                    String loginid = userId.getText().toString();
                    String loginpwd = userPwd.getText().toString();
                    try {
                        //String result = new LoginTask().execute(loginid, loginpwd, "login").get();
                        //String result = new LoginTask().execute(loginid, loginpwd, "login").get();
                        String result = new UserService.LoginTask().execute(loginid, loginpwd).get();

                        if(result.equals("SUCCESS")) {
                            Toast.makeText(LoginActivity.this, "로그인", Toast.LENGTH_SHORT).show();
                            CookieSharedPreference pref = CookieSharedPreference.getInstanceOf(getApplicationContext());
                            pref.setUserID(loginid);
                            //pref.
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        } else if(result.equals("FAIL")) {
                            Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                            userId.setText("");
                            userPwd.setText("");
                        }
                    } catch (Exception ignored) {
                    }
                    break;
                case R.id.bt_signup: // 회원가입
                    Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                    startActivity(intent);
                    break;
            }
             */
        }
    }

}
