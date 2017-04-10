package com.rafilutfansyah.retrofitexamples;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("user/API")
    Call<ResultUser> getUserAPI();

    @GET("user/API")
    Call<ResponseBody> getUserJSON();
}
