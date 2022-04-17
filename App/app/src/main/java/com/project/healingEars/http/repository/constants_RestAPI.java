package com.project.healingEars.http.repository;
import com.google.gson.JsonObject;
import com.project.healingEars.http.dto.UserDTO;
import com.project.healingEars.http.vo.UserVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface constants_RestAPI {
    //통신할 URL을 미리 정의하는 interface
    //userInfo : POJO(DTO)를 정의해두는 클래스 (직접 클래스를 만들 것이기 때문에 오류는 신경쓰지 않음)

    @GET("getTemp/{userId}")
    Call<UserVO> getUserInfo(@Path("userId") String userId);

    @POST("getTemp/qqq") //추가예정
    Call<UserVO> postUserInfo(@Body UserVO userVO);

    @GET("productDetail/all")
    Call<List<UserVO>> getFunc(@Body UserVO userVO);

    @GET("productDetail/all")
    Call<String> Info4();

    @Headers("Content-Type: application/json")
    @POST("users/login")
    Call<UserDTO> loginString(@Body UserVO userVO);

    @GET("users/logout")
    Call<String> logout();

}
