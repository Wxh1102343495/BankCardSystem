package com.orilore.model;
public class Transaction{
	private Integer Id;
	public void setId(Integer Id){
		this.Id=Id;
	}
	public Integer getId(){
		return this.Id;
	}
	private Integer carid;
	public void setCarid(Integer carid){
		this.carid=carid;
	}
	public Integer getCarid(){
		return this.carid;
	}
	private String time;
	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return this.time;
	}
	private Float money;
	public void setMoney(Float money){
		this.money=money;
	}
	public Float getMoney(){
		return this.money;
	}
	private String type;
	public void setType(String type){
		this.type=type;
	}
	public String getType(){
		return this.type;
	}
}