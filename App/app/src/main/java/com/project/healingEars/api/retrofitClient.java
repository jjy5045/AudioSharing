package com.project.healingEars.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.healingEars.api.interceptor.AddCookiesInterceptor;
import com.project.healingEars.api.interceptor.ReceivedCookiesInterceptor;
import com.project.healingEars.global;
import com.project.healingEars.http.repository.constants_RestAPI;

import java.net.CookieManager;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitClient {
    // 가상머신에서는 개인 서버에 접속할 때 ip주소를 10.0.2.2로 설정

    public static constants_RestAPI getApiService() {
        return getInstance().create(constants_RestAPI.class);
    }
    //constants_RestAPI : api 를 미리 정의하여 유지보수를 편하게 하는 클래스 (직접 클래스를 만들 것이기 때문에 오류는 신경쓰지 않음)

    public static Retrofit getInstance() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(new CookieManager()))
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(global.baseURL);
        builder.addConverterFactory(GsonConverterFactory.create(gson));
        builder.client(okHttpClient);

        Retrofit retrofit = builder.build();

        return retrofit;
    }
}