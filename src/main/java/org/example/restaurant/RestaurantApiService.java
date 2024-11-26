package org.example.restaurant;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface RestaurantApiService {

    @POST("/restaurant/")
    Call<RestaurantRequestModel> createRestaurant(@Body RestaurantRequestModel restaurantRequestModel);

    @GET("/restaurant")
    Call<List<RestaurantResponseModel>> getRestaurant();
}
