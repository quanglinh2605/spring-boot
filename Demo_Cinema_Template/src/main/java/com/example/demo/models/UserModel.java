package com.example.demo.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.apis.APIClient;
import com.example.demo.apis.UserAPI;
import com.example.demo.entities.User;

public class UserModel {
	List<User> users = null;
	
	public List<User> findAllUser(){
		UserAPI api = APIClient.getClient().create(UserAPI.class);
		try {
			users = new ArrayList<User>();
			users = api.findall().execute().body(); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return users;
	}
	public User getByUsername(String username) {
		UserAPI api = APIClient.getClient().create(UserAPI.class);
		User user = new User();
		try {
			user = api.findByUsername(username).execute().body();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
}
