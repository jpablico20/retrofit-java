package org.example.restaurant_category;

import org.example.RetrofitClient;
import org.example.user.UserApiService;
import org.example.user.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class CreateRestaurantCategory {

    public static void main(String[] args) {
        RestaurantCategoryRequestModel data = new RestaurantCategoryRequestModel();
        data.setName("Fast Food");
        createRestaurantCategory(data);
    }

    public static void createRestaurantCategory(RestaurantCategoryRequestModel data){

        RestaurantCategoryApiService apiService = RetrofitClient.getRetrofitInstance().create(RestaurantCategoryApiService.class);

        Call<RestaurantCategoryRequestModel> createRestaurantCategory = apiService.createRestaurantCategory(data);

        createRestaurantCategory.enqueue(new Callback<RestaurantCategoryRequestModel>() {
            @Override
            public void onResponse(Call<RestaurantCategoryRequestModel> call, Response<RestaurantCategoryRequestModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Restaurant Category created: " + response.body().getName());
                } else {
                    try {
                        String errorMessage = response.errorBody() != null ? response.errorBody().string() : "Unknown error";
                        System.out.println("Failed to create user. Code: " + response.code() + ", Error: " + errorMessage);
                    } catch (IOException e) {
                        System.out.println("Error reading error body: " + e.getMessage());
                    }
                }
             }

            @Override
            public void onFailure(Call<RestaurantCategoryRequestModel> call, Throwable throwable) {
                        System.out.println("Network error or request failed: " + throwable.getMessage());

            }
        });

    }

}
