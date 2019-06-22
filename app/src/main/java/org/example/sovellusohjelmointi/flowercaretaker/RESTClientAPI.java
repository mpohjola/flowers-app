package org.example.sovellusohjelmointi.flowercaretaker;
import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RESTClientAPI {
    @GET("flowers")
    Call <ArrayList<Flower>> getFlowers();

    @GET("user-flowers")
    Call <ArrayList<UserFlower>> getUserFlowers(@Query("filter") String filter);

    @GET("flower-watering/{id}")
    Call <ArrayList<WateringEvent>> getWateringEvents(@Path("id") int flowerId);

    @POST("users/register")
    Call <User> createUser(@Body Map<String, String> params);

    @POST("user-flowers")
    Call <UserFlower> createUserFlower(@Body Map<String, String> params);

    @POST("flower-watering")
    Call <WateringEvent> createWateringEvent(@Body Map<String, String> params);
}
