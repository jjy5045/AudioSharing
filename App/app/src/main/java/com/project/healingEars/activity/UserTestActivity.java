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
import java.util.LinkedHashMap;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Response;

import com.example.app.R;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.project.healingEars.api.preference.CookieSharedPreference;
import com.project.healingEars.http.vo.ProDetailTestVO;
import com.project.healingEars.http.vo.ProductDetailVO;
import com.project.healingEars.http.vo.UserTestVO;
import com.project.healingEars.http.vo.UserVO;
import com.project.healingEars.http.service.userService;

import org.json.JSONObject;

public class UserTestActivity extends AppCompatActivity {

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

            //UserVO userVO = new UserVO(params[0], params[1]);//id, pwd
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            //Call<String> stringCall = UserService.getRetrofit(getApplicationContext()).login(userVO);
            Call<JsonObject> list = userService.getRetrofit(getApplicationContext()).Info3();
            try {
                //return stringCall.execute().body();
                //testVO test = objectMapper.readValue(list.execute().body().toString(), testVO.class);
                //test2VO test2 =

                ///////ProDetailTestVO test3 = objectMapper.readValue(list.execute().body().toString(), ProDetailTestVO.class);


                //return test.getUserVO().toString();
                return list.execute().body().toString();
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
                        ObjectMapper objectMapper = new ObjectMapper();
                        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                        String result = new LoginTask().execute(loginid, loginpwd, "login").get();
                        UserTestVO test3 = objectMapper.readValue(result, UserTestVO.class);





                        //String proListName = (String) ((LinkedHashMap) test3.productDetail.get(0).productList).get("proListName");
                        //String proListName = (String) ((LinkedHashMap) test3.productDetail.get(0)).get("proListName");


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
