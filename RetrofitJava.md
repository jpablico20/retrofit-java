Java Retrofit
=============



**API for Restaurant, Menu Category, and Menu (GET ALL and CREATE only)**

1.  Implement `GET ALL` and `CREATE` operations for `Restaurant`, `MenuCategory`, and `Menu` using an API service.

```
    @POST("/restaurant/")
    Call<RestaurantRequestModel> createRestaurant(@Body RestaurantRequestModel restaurantRequestModel);
    @GET("/restaurant")
    Call<List<RestaurantResponseModel>> getRestaurant();
```
```
    @POST("/menu-category/")
    Call<MenuCategoryRequestModel> createMenuCategory(@Body MenuCategoryRequestModel menuCategoryRequestModel);
    @GET("/menu-category")
    Call<List<MenuCategoryResponseModel>> getMenuCategory();
```
```
    @POST("/menu/")
    Call<MenuRequestModel> createMenu(@Body MenuRequestModel menuRequestModel);
    @GET("/menu")
    Call<List<MenuResponseModel>> getMenu();
```

**2. Create a** `**RequestModel**` **(for POST) and a** `**ResponseModel**` **(for GET or GET ALL) for each folder, including constructors, getters, and setters based on the data structure observed in Postman.**

**3. Example for Creating Data in the Database (Using Java):**

```
    public static void main(String[] args) {
        MenuRequestModel data = new MenuRequestModel();
        data.setName("Chocolate Lava Cake");
        data.setDescription("A warm chocolate cake with a gooey molten center, served with vanilla ice cream.");
        data.setAvailability(true);
        data.setCategory_id(3);
        data.setRestaurant_id(5);
        createMenu(data);
    }
```

**Initialize** `**MenuRequestModel**`**:**
Create an instance of `MenuRequestModel`, set its attributes (e.g., name, description, availability, category ID, and restaurant ID), and pass it to the `createMenu` method.

`**createMenu**` **Method:**

```
public static void createMenu (MenuRequestModel data){
        MenuApiService apiService = RetrofitClient.getRetrofitInstance().create(MenuApiService.class);
        Call<MenuRequestModel> creatMenu = apiService.createMenu(data);
        creatMenu.enqueue(new Callback<MenuRequestModel>() {
            @Override
            public void onResponse(Call<MenuRequestModel> call, Response<MenuRequestModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Menu created: " + response.body().getName());
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
            public void onFailure(Call<MenuRequestModel> call, Throwable throwable) {
                System.out.println("Network error or request failed: " + throwable.getMessage());
            }
        });
    }
```

The `createMenu` method is designed to make an **asynchronous network call** to **create** a menu item using a REST API. It utilizes Retrofit, a library for handling HTTP requests, to send the `MenuRequestModel` data to an endpoint defined in `MenuApiService`. The method processes the response:

1.  **onResponse**: Handles a successful server response. If the response is valid, it prints the menu item’s name; otherwise, it logs the error details.
2.  **onFailure**: Logs network or request errors, such as connectivity issues or failures to communicate with the server.

**4. Example for Retrieving All Data (Using Java):**

`**getAllMenu**` **Method:**

```
    public static void getAllMenu() {
        MenuApiService apiService = RetrofitClient.getRetrofitInstance().create(MenuApiService.class);
        Call<List<MenuResponseModel>> getData = apiService.getMenu();
        getData.enqueue(new Callback<List<MenuResponseModel>>() {
            @Override
            public void onResponse(Call<List<MenuResponseModel>> call, Response<List<MenuResponseModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    System.out.println("Menu Category List:");
                    for (MenuResponseModel menuResponseModel : response.body()) {
                        System.out.println("Name: " + menuResponseModel.getName() + ", uuid: " + menuResponseModel.getMenu_uuid());
                    }
                } else {
                    System.out.println("Failed to fetch users: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<List<MenuResponseModel>> call, Throwable throwable) {
                System.out.println("Error" + throwable.getMessage());
            }
        });
    }
```

The `getAllMenu` method is used to **retrieve** a list of menu items from a REST API asynchronously using Retrofit. It makes a network request to **fetch** the menu data and processes the response:

1.  **onResponse**: Handles a successful server response. If the response is valid, it iterates through the list of `MenuResponseModel` objects and prints each menu item's name and UUID. If the response fails, it logs the HTTP error code.
2.  **onFailure**: Handles network errors or request failures, logging the error message for debugging.

This method is useful for fetching and displaying a list of menu items from a backend server.

**Usage:**
Run the `getAllMenu` method in the `main` method to retrieve and display the data from the backend.

**Retrofit for Java (REST API Integration):**
---------------------------------------------

*   Use Retrofit for making HTTP requests to interact with your REST API.
*   Ensure proper implementation of models (`RequestModel` and `ResponseModel`) and handle responses with asynchronous callbacks (`onResponse` and `onFailure`).

**OUTPUT**

In creating item/data:

![captionless image](https://miro.medium.com/v2/resize:fit:1080/format:webp/1*6_P8_Snd5W2KPAR4ihQFJg.png)![captionless image](https://miro.medium.com/v2/resize:fit:922/format:webp/1*1AeqwRFKwCbsc3_3JlKOXA.png)

![captionless image](https://miro.medium.com/v2/resize:fit:1232/format:webp/1*-SYdcGsgJ97cCqiuUYxS8A.png)

In retrieving list of item/data:

![captionless image](https://miro.medium.com/v2/resize:fit:994/format:webp/1*AD5gCV6wk0ebxYRTFfxD_g.png)![captionless image](https://miro.medium.com/v2/resize:fit:1008/format:webp/1*a16RgzWCzZHZoYHBbZQBfQ.png)

![captionless image](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*bA6yqFj7P5-2umpzEWzUKA.png)

Check the item/data in POSTMAN:

![captionless image](https://miro.medium.com/v2/resize:fit:1364/format:webp/1*V6oJFtWAN_FmdhnqzXacSw.png)![captionless image](https://miro.medium.com/v2/resize:fit:1168/format:webp/1*_r8TCbIlZWVrePXhz3mnUw.png)![captionless image](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*hVHOtiZAsGVfW_t9YZq1yg.png)

github: [https://github.com/jpablico20/retrofit-java.git](https://github.com/jpablico20/retrofit-java.git)
