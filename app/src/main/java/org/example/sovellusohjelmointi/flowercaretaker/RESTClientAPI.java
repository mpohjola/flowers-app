package org.example.sovellusohjelmointi.flowercaretaker;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface RESTClientAPI {
    @GET("flowers")
    Call <ArrayList<Flower>> getFlowers();

    @GET("user-flowers")
    Call <ArrayList<UserFlower>> getUserFlowers();

    @GET("flower-watering")
    Call <ArrayList<WateringEvent>> getWateringEvents();
}
