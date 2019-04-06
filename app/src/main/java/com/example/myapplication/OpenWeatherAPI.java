package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OpenWeatherAPI {

    @GET("q={cityName}&units=metric&appid=8b3e8129ac9e59e711839ca1e82aae07")
    Call<CityResponseModel> getCurrentWeather(@Path("cityName") String cityName);
}
