package org.example.restaurant;

import org.example.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class CreateRestaurant {
    public static void main(String[] args) {
        RestaurantRequestModel data = new RestaurantRequestModel();
        data.setName("Tasty Bites");
        data.setAddress("456 Food Street, Culinary City");
        data.setDescription("A cozy family-owned restaurant specializing in Italian cuisine.");
        data.setCategory_id(4);
        data.setEmail("contact@tastybites.com");
        data.setPhone("09871234567");
        data.setStatus(true);
        data.setUser_id(3);

        createRestaurant(data);
    }

    public static void createRestaurant(RestaurantRequestModel data){

        RestaurantApiService apiService = RetrofitClient.getRetrofitInstance().create(RestaurantApiService.class);

        Call<RestaurantRequestModel> createRestaurant = apiService.createRestaurant(data);

        createRestaurant.enqueue(new Callback<RestaurantRequestModel>() {
            @Override
            public void onResponse(Call<RestaurantRequestModel> call, Response<RestaurantRequestModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Restaurant created: " + response.body().getName());
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
            public void onFailure(Call<RestaurantRequestModel> call, Throwable throwable) {
                System.out.println("Network error or request failed: " + throwable.getMessage());

            }
        });

    }
}
