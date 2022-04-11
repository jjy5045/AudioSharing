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

import com.example.app.R;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.project.healingEars.api.preference.CookieSharedPreference;
import com.project.healingEars.http.vo.ProductDetailVO;
import com.project.healingEars.http.vo.UserVO;
import com.project.healingEars.http.service.userService;
import com.project.healingEars.http.vo.testVO;

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

            UserVO userVo = new UserVO(params[0], params[1]);//id, pwd
            //Call<String> stringCall = userService.getRetrofit(getApplicationContext()).login(userVO);
            //Call<String> list = userService.getRetrofit(getApplicationContext()).Info();
            //Call<List<userVO>> list = userService.getRetrofit(getApplicationContext()).Info();
            Call<String> list = userService.getRetrofit(getApplicationContext()).Info2();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String json = "{\n" +
                    "  \"result\": \"SUCCESS\",\n" +
                    "  \"userVO\": {\n" +
                    "    \"userId\": 1,\n" +
                    "    \"userType\": \"1\",\n" +
                    "    \"userEmail\": \"user1\",\n" +
                    "    \"userName\": \"유저340\",\n" +
                    "    \"userSex\": \"2\",\n" +
                    "    \"userBirth\": \"960830\",\n" +
                    "    \"userTel\": \"01087799253\",\n" +
                    "    \"userPassword\": \"1\",\n" +
                    "    \"userDel\": false,\n" +
                    "    \"userCreateTimestamp\": \"2022-03-28T08:07:33.000+00:00\",\n" +
                    "    \"userUpdateTimestamp\": null\n" +
                    "  }\n" +
                    "}";
            try {
                //System.out.println(list.execute().body());
                //testVO test = objectMapper.readValue(list.execute().body(), testVO.class);
                testVO test = objectMapper.readValue(json, testVO.class);
                UserVO user = objectMapper.readValue(json, UserVO.class);
                System.out.println(test.getResult());
                return test.getResult();
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*
            Gson gson = new Gson();
            JsonObject test = gson.fromJson(list.toString(), JsonObject.class);
            */
            //Call<ProductDetailVO> productDetail = userService.getRetrofit(getApplicationContext()).ProductDetailInfo();
            //Call<JsonObject> stringCall = userService.getRetrofit(getApplicationContext()).login(userVO);
            try {
                //return stringCall.execute().body();
                Log.v("test","리턴 list");
                //Log.d("user", String.valueOf(list.execute().body()));
                //Log.d("test", String.valueOf(list.execute().body()));
                //return list.execute().body();
                return list.execute().body();
                //return productDetail.execute().body().toString();

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
                        Log.d("test", result);
                        if(result.equalsIgnoreCase("SUCESS")) {
                            System.out.println(result);
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
