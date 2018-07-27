package com.orilore.biz;
import com.orilore.model.*;
import java.util.*;
public interface ICardBiz{
	public boolean addCard(Card card);
	public boolean removeCard(int id);
	public boolean modifyCard(Card card);
	public Card getCard(int id);
	public List<Card> findCard();
	public void close();
}