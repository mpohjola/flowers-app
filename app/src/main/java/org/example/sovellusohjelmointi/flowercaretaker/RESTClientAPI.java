package org.example.sovellusohjelmointi.flowercaretaker;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface RESTClientAPI {
    @GET("getFlowers")
    Call <ArrayList<Flower>> getFlowers();

    @GET("getUserFlowers")
    Call <ArrayList<UserFlower>> getUserFlowers();

    @GET("getWateringEvents")
    Call <ArrayList<WateringEvent>> getWateringEvents();
}
