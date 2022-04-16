package com.project.healingEars.http.service;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.JsonObject;
import com.project.healingEars.http.repository.UserRepository;
import com.project.healingEars.http.vo.UserVO;
import com.project.healingEars.http.repository.constants_RestAPI;
import com.project.healingEars.api.retrofitClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;


public class UserService {

    public static class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params) {
            UserVO userVO = new UserVO(params[0], params[1]);//email, pwd
            //UserVO userVO = new UserVO("jjy0943@naver.com", "111111");
            //Object contex
            //Call<String> jsonCall = UserRepository.getRcoetrofit(params[2]).loginString(userVO);
            Call<String> result = retrofitClient.getApiService().loginString(userVO);
            try {
                return result.execute().body();
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
}
