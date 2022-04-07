package com.project.healingEars.http;
import com.project.healingEars.http.service.constants_RestAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitClient {
    private static final String BASE_URL = "http://localhost:8080/";
    // 가상머신에서는 개인 서버에 접속할 때 ip주소를 10.0.2.2로 설정

    public static constants_RestAPI getApiService() {
        return getInstance().create(constants_RestAPI.class);
    }
    //constants_RestAPI : api 를 미리 정의하여 유지보수를 편하게 하는 클래스 (직접 클래스를 만들 것이기 때문에 오류는 신경쓰지 않음)

    public static Retrofit getInstance() {

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        return retrofit;
    }
}
