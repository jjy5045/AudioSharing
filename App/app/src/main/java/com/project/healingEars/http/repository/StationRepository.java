package com.project.healingEars.http.repository;

import com.project.healingEars.api.retrofitClient;
import com.project.healingEars.http.dto.StationDTO;

import retrofit2.Call;
import retrofit2.http.GET;

public class StationRepository extends retrofitClient {

    public  static StationAPI getRetrofit() {
        return (StationAPI) getInstance().create(StationRepository.StationAPI.class);
    }

    public interface StationAPI {
        @GET("station/all")
        Call<StationDTO> getAllStation();
    }
}
