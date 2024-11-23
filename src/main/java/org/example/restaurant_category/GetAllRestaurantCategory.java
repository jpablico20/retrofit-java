package org.example.restaurant_category;

import org.example.RetrofitClient;
import org.example.user.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class GetAllRestaurantCategory {
    public static void main(String[] args) {
       getAllRestaurant();
    }

    public static void getAllRestaurant(){

        RestaurantCategoryApiService apiService = RetrofitClient.getRetrofitInstance().create(RestaurantCategoryApiService.class);
        Call<List<RestaurantCategoryResponseModel>> getData = apiService.getRestaurantCategory();

        getData.enqueue(new Callback<List<RestaurantCategoryResponseModel>>() {
            @Override
            public void onResponse(Call<List<RestaurantCategoryResponseModel>> call, Response<List<RestaurantCategoryResponseModel>> response) {
                //IF SUCCESSFULE
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Restaurant Category List:");
                    for (RestaurantCategoryResponseModel restaurant_category : response.body()) {
                        System.out.println("Name: " + restaurant_category.getName() + ", uuid: " + restaurant_category.getCategory_uuid());
                    }
                } else {
                    System.out.println("Failed to fetch restaurant_category: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<RestaurantCategoryResponseModel>> call, Throwable throwable) {

                //IF NOT
                System.out.println("Error" + throwable.getMessage());
            }
        });


    }

}
