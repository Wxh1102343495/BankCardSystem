package com.orilore.dao;
import com.orilore.model.Transaction;
import java.util.*;
import java.sql.*;
public interface ITransactionDAO{
	public boolean insert(Transaction transaction,Connection conn) throws Exception;
	public boolean delete(int id,Connection conn) throws Exception;
	public boolean update(Transaction transaction,Connection conn) throws Exception;
	public Transaction selectOne(int id,Connection conn) throws Exception;
	public List<Transaction> select(Connection conn) throws Exception;
	public List<Transaction> selectcard(int cid,Connection conn) throws Exception;
	public void close() throws Exception;
}