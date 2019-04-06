package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private DbWorker dbWorker;
    private TextView defaultCity_1, defaultCity_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defaultCity_1 = (TextView) findViewById(R.id.defaultCity_1);
        defaultCity_2 = (TextView) findViewById(R.id.defaultCity_2);
        get();
    }

    @SuppressWarnings("unchecked")
    private void get() {
            OpenWeatherHelper.getInstance()
                    .getJSONApi()
                    .getCurrentWeather("Vinnytsia")
                    .enqueue(new Callback<CityResponseModel>() {
                        @Override
                        public void onResponse(@NonNull Call<CityResponseModel> call, @NonNull Response<CityResponseModel> response) {
                            CityResponseModel post = response.body();
                            Log.d("!!!", String.valueOf(post.getId()));

//                        defaultCity_1.append(post.getName() + "\n");
                        }

                        @Override
                        public void onFailure(@NonNull Call<CityResponseModel> call, @NonNull Throwable t) {

                            toastMessage("Error occurred while getting request!");
                        }
                    });
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
