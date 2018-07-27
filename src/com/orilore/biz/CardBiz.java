package com.orilore.biz;
import com.orilore.dao.*;
import com.orilore.model.*;
import java.util.*;
import java.sql.*;
public class CardBiz implements ICardBiz{
	private ICardDAO dao = new CardDAO();
	private DBUtil db = new DBUtil();
	private Connection conn = null;
	public boolean addCard(Card card){
		try{
			conn = db.getConnection();
			if(dao.insert(card,conn)){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}finally{
			this.close();
		}
	}
	public boolean removeCard(int id){
		try{
			conn = db.getConnection();
			if(dao.delete(id,conn)){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}finally{
			this.close();
		}
	}
	public boolean modifyCard(Card card) {;
		try{
			conn = db.getConnection();
			if(dao.update(card,conn)){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}finally{
			this.close();
		}
	}
	public Card getCard(int id){
		try{
			conn = db.getConnection();
			return dao.selectOne(id,conn);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
				return null;
		}finally{
			this.close();
		}
	}
	public List<Card> findCard(){
		try{
			conn = db.getConnection();
			return dao.select(conn);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
				return null;
		}finally{
			this.close();
		}
	}
	public void close(){
		try{
			if(conn!=null && !conn.isClosed()) conn.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
