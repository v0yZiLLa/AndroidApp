package com.example.myapplication;

import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenWeather {

    OpenWeather(String cityName) {
        getWeatherByCityName(cityName);
    }

    public Response<CityResponseModel> weatherData;

    @SuppressWarnings("unchecked")
    private OpenWeather getWeatherByCityName(String cityName) {
        OpenWeatherHelper.getInstance()
                .getJSONApi()
                .getCurrentWeather(cityName)
                .enqueue(new Callback<CityResponseModel>() {
                    @Override
                    public void onResponse(@NonNull Call<CityResponseModel> call, @NonNull Response<CityResponseModel> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Log.d("!!!!!", response.isSuccessful() + " - " + response.body().getName());
                            weatherData = response;
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<CityResponseModel> call, @NonNull Throwable t) {
                        Log.d("!!!!!", "FAILURE");
                    }
                });
        return this;
    }
}
