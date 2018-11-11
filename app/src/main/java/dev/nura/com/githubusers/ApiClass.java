package dev.nura.com.githubusers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nura on 11.11.2018.
 */
public class ApiClass {

    private static ApiService apiService;

    private static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    static ApiService getApiService() {
        if(apiService == null) {
            apiService = createRetrofit().create(ApiService.class);
        }
        return apiService;
    }

}
