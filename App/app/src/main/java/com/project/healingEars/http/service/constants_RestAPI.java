package com.project.healingEars.http.service;
import com.project.healingEars.http.vo.userVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface constants_RestAPI {
    //통신할 URL을 미리 정의하는 interface
    //userInfo : POJO(DTO)를 정의해두는 클래스 (직접 클래스를 만들 것이기 때문에 오류는 신경쓰지 않음)

    @GET("getTemp/{userId}")
    Call<userVO> getUserInfo(@Path("userId") String userId);

    @POST("getTemp/qqq") //추가예정
    Call<userVO> postUserInfo(@Body userVO userVO);

    @GET("productDetail/all")
    Call<List<userVO>> getFunc(@Body userVO userVO);

}
