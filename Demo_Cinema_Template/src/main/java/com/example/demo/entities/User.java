package com.example.demo.entities;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("id")
	@Expose
	private String id;

	@NotEmpty
	@Length(min = 3, max = 10)
	@SerializedName("username")
	@Expose
	private String username;

	@NotEmpty
	/* @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[@#$%]).{6,20})") */
	@SerializedName("password")
	@Expose
	private String password;

	@SerializedName("avatar")
	@Expose
	private String avatar;

	@SerializedName("fullname")
	@Expose
	private String fullname;

	@SerializedName("birthday")
	@Expose
	private Date birthday;

	@NotEmpty
	@SerializedName("gender")
	@Expose
	private String gender;

	@NotEmpty
	@Email
	@SerializedName("email")
	@Expose
	private String email;

	@NotEmpty
	@SerializedName("phone")
	@Expose
	private String phone;

	@SerializedName("city")
	@Expose
	private String city;

	@SerializedName("point")
	@Expose
	private String point;

	@SerializedName("role")	
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date date) {
		this.birthday = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

}
