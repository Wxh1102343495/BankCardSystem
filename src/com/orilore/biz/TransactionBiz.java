package com.orilore.biz;
import com.orilore.dao.*;
import com.orilore.model.*;
import java.util.*;
import java.sql.*;
public class TransactionBiz implements ITransactionBiz{
	private ITransactionDAO dao = new TransactionDAO();
	private ICardDAO dao1=new CardDAO();
	private DBUtil db = new DBUtil();
	private Connection conn = null;
	public boolean addTransaction(Transaction transaction,Card card){
		try{
			conn = db.getConnection();
			conn.setAutoCommit(false);
			if(dao.insert(transaction,conn) && dao1.update(card, conn)){
				conn.commit();
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
	public boolean removeTransaction(int id){
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
	public boolean modifyTransaction(Transaction transaction) {;
		try{
			conn = db.getConnection();
			if(dao.update(transaction,conn)){
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
	public Transaction getTransaction(int id){
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
	public List<Transaction> findTransaction(){
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
	@Override
	public List<Transaction> findCardTransaction(int cid) {
		try{
			conn = db.getConnection();
			return dao.selectcard(cid,conn);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
				return null;
		}finally{
			this.close();
		}
	}
}
