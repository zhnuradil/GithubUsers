package dev.nura.com.githubusers.rest;

import java.util.List;

import dev.nura.com.githubusers.pojo.User;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by nura on 11.11.2018.
 */
public interface ApiService {

    @GET("users")
    Single<List<User>> getUsers();
}
