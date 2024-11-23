package org.example.user;

import org.example.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserApiService apiService = RetrofitClient.getRetrofitInstance().create(UserApiService.class);

        UserModel newUserModel = new UserModel();
        newUserModel.setEmail("test123@gmail.com");
        newUserModel.setPassword("12345678910");
        newUserModel.setRole("user");
        newUserModel.setUsername("Brandz1232");

        Call<UserModel> createUserCall = apiService.createUser(newUserModel);
        createUserCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("User created: " + response.body().getUsername());
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
            public void onFailure(Call<UserModel> call, Throwable t) {
                System.out.println("Network error or request failed: " + t.getMessage());
            }
        });

        Call<List<UserModel>> getAllUsersCall = apiService.getAllUsers();
        getAllUsersCall.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Users List:");
                    for (UserModel userModel : response.body()) {
                        System.out.println("ID: " + userModel.getEmail() + ", Username: " + userModel.getUsername());
                    }
                } else {
                    System.out.println("Failed to fetch users: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });
    }
}
