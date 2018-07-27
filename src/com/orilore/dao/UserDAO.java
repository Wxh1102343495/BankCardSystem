package com.orilore.dao;
import com.orilore.model.User;
import java.sql.*;
import java.util.*;
public class UserDAO implements IUserDAO{
	private PreparedStatement pstmt;
	private ResultSet rs;
	public boolean insert(User user,Connection conn) throws Exception{
		String sql="insert into user(username,password) values(?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUsername());		pstmt.setString(2,user.getPassword());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public boolean delete(int id,Connection conn) throws Exception{
		String sql = "delete from user where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public boolean update(User user,Connection conn) throws Exception{;
		String sql="update user set username=?,password=? where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUsername());		pstmt.setString(2,user.getPassword());		pstmt.setInt(3,user.getId());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public User selectOne(int id,Connection conn) throws Exception{
		String sql = "select * from user where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);		rs = pstmt.executeQuery();
		User user = new User();
		if(rs.next()){
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setId(rs.getInt("id"));
		}
		this.close();
		return user;
	}
	public List<User> select(Connection conn) throws Exception{
		String sql = "select * from user";
		pstmt = conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		List<User> users = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setId(rs.getInt("id"));
			users.add(user);
		}
		this.close();
		return users;
	}
	public void close() throws Exception{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
}