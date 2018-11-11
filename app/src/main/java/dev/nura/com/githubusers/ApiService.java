package dev.nura.com.githubusers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nura on 11.11.2018.
 */
public interface ApiService {

    @GET("users")
    Call<List<User>> getUsers();
}
