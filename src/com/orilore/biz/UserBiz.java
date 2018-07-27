package com.orilore.biz;
import com.orilore.dao.*;
import com.orilore.model.*;
import java.util.*;
import java.sql.*;
public class UserBiz implements IUserBiz{
	private IUserDAO dao = new UserDAO();
	private DBUtil db = new DBUtil();
	private Connection conn = null;
	public boolean addUser(User user){
		try{
			conn = db.getConnection();
			if(dao.insert(user,conn)){
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
	public boolean removeUser(int id){
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
	public boolean modifyUser(User user) {;
		try{
			conn = db.getConnection();
			if(dao.update(user,conn)){
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
	public User getUser(int id){
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
	public List<User> findUser(){
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
