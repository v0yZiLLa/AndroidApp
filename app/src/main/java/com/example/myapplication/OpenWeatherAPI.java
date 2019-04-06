package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenWeatherAPI {

    final String APP_ID = "8b3e8129ac9e59e711839ca1e82aae07";

    @GET("weather?q=vinnytsia&units=metric&appid=8b3e8129ac9e59e711839ca1e82aae07")
    Call<CityResponseModel> getCurrentWeather();
}
