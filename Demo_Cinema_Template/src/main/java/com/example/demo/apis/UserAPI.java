package com.example.demo.apis;

import java.util.List;

import com.example.demo.entities.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserAPI {

	@GET("user/findall")
	Call<List<User>> findall();

	@POST("user/create")
	Call<User> create(@Body User Users);

	@PUT("user/update")
	Call<User> update(@Body User Users);

	@DELETE("user/delete/{id}")
	Call<Void> delete(@Path("id") int id);

	@GET("user/getById/{id}")
	Call<User> getById(@Path("id") int id);

	@GET("user/search/{keyword}")
	Call<List<User>> search(@Path("keyword") String keyword);

	@GET("user/findByUsername/{username}")
	Call<User> findByUsername(@Path("username") String username);

	@GET("user/listAll")
	Call<List<User>> listAll();
}
