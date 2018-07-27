package com.orilore.dao;
import com.orilore.model.User;
import java.util.*;
import java.sql.*;
public interface IUserDAO{
	public boolean insert(User user,Connection conn) throws Exception;
	public boolean delete(int id,Connection conn) throws Exception;
	public boolean update(User user,Connection conn) throws Exception;
	public User selectOne(int id,Connection conn) throws Exception;
	public List<User> select(Connection conn) throws Exception;
	public void close() throws Exception;
}