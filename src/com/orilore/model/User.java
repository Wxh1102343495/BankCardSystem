package com.orilore.model;
public class User{
	private Integer Id;
	public void setId(Integer Id){
		this.Id=Id;
	}
	public Integer getId(){
		return this.Id;
	}
	private String username;
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return this.username;
	}
	private String password;
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}
}