package org.example.sovellusohjelmointi.flowercaretaker;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RESTController {

    private String TAG = "RESTController";
    private OkHttpClient httpClient;
    private static final String serverAddress = "http://54.194.71.79/flower-caretaker/";

    private Retrofit retrofit;

    private RESTClientAPI service;

    public RESTController() {
        httpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(serverAddress)
                .addConverterFactory(JacksonConverterFactory.create()) //Jackson converter is used to deserialize JSON data received from server
                .client(httpClient)
                .build();
        service = retrofit.create(RESTClientAPI.class);
    }

    public String getServerAddress(){
        return serverAddress;
    }

    public ArrayList<Flower> getFlowers() {
        ArrayList<Flower> flowersList = new ArrayList<Flower>();

        Call<ArrayList<Flower>> flowersCall = service.getFlowers();
        try {
            flowersList = flowersCall.execute().body();
            Log.i(TAG, "Got Flowers List, first flower name: " + flowersList.get(0).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flowersList;
    }

}
