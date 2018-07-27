package com.orilore.model;
public class Card{
	private Integer Id;
	public void setId(Integer Id){
		this.Id=Id;
	}
	public Integer getId(){
		return this.Id;
	}
	private String cardID;
	public void setCardID(String cardID){
		this.cardID=cardID;
	}
	public String getCardID(){
		return this.cardID;
	}
	private String cardName;
	public void setCardName(String cardName){
		this.cardName=cardName;
	}
	public String getCardName(){
		return this.cardName;
	}
	private String cardMoney;
	public void setCardMoney(String cardMoney){
		this.cardMoney=cardMoney;
	}
	public String getCardMoney(){
		return this.cardMoney;
	}
}