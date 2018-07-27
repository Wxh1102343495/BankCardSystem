package com.orilore.dao;
import com.orilore.model.Card;
import java.util.*;
import java.sql.*;
public interface ICardDAO{
	public boolean insert(Card card,Connection conn) throws Exception;
	public boolean delete(int id,Connection conn) throws Exception;
	public boolean update(Card card,Connection conn) throws Exception;
	public Card selectOne(int id,Connection conn) throws Exception;
	public List<Card> select(Connection conn) throws Exception;
	public void close() throws Exception;
}