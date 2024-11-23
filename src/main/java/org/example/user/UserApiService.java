package org.example.user;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface UserApiService {

    @POST("/users/")
    Call<UserModel> createUser(@Body UserModel userModel);

    @GET("/users")
    Call<List<UserModel>> getAllUsers();
}
