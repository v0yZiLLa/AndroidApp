package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DbWorker dbWorker;
    private TextView defaultCity, defaultCityTemp, defaultCity2, defaultCityTemp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defaultCity = (TextView) findViewById(R.id.defaultCity);
        defaultCityTemp = (TextView) findViewById(R.id.defaultCityTemp);
        defaultCity2 = (TextView) findViewById(R.id.defaultCity2);
        defaultCityTemp2 = (TextView) findViewById(R.id.defaultCityTemp2);
        new OpenWeather("Vinnytsia");//.weatherData.body().getName());
//        getWeatherByCityName("Kyiv");

    }




}
