package com.project.healingEars.http.repository;

import com.project.healingEars.api.retrofitClient;
import com.project.healingEars.http.dto.ProductDetailDTO;
import com.project.healingEars.http.dto.StationDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class ProductDetailRepository extends retrofitClient {

    public  static ProductDetailAPI getRetrofit() {
        return (ProductDetailAPI) getInstance().create(ProductDetailRepository.ProductDetailAPI.class);
    }

    public interface ProductDetailAPI {
        @GET("productDetail/station/{StnId}")
        Call<ProductDetailDTO> getProDetailByStn(@Path("StnId") Integer StnId);
    }
}
