package org.example.restaurant_category;

import org.example.user.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface RestaurantCategoryApiService {

    @POST("/restaurant-category/")
    Call<RestaurantCategoryRequestModel> createRestaurantCategory(@Body RestaurantCategoryRequestModel restaurantCategoryRequestModel);

    @GET("/restaurant-category")
    Call<List<RestaurantCategoryResponseModel>> getRestaurantCategory();
}
