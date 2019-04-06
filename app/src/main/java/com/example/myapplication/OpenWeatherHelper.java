package com.example.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenWeatherHelper {

    private final String API_KEY = "8b3e8129ac9e59e711839ca1e82aae07";
    private final String openWeatherApiURL = "?q=%s&appid=%s&units=metric";
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather/";
    private Retrofit retrofit;
    private static OpenWeatherHelper mInstance;

    private OpenWeatherHelper() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static OpenWeatherHelper getInstance() {
        if (mInstance == null) {
            mInstance = new OpenWeatherHelper();
        }
        return mInstance;
    }


    public OpenWeatherAPI getJSONApi() {
        return retrofit.create(OpenWeatherAPI.class);
    }
}
