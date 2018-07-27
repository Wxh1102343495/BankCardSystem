package com.orilore.dao;
import com.orilore.model.Transaction;
import java.sql.*;
import java.util.*;
public class TransactionDAO implements ITransactionDAO{
	private PreparedStatement pstmt;
	private ResultSet rs;
	public boolean insert(Transaction transaction,Connection conn) throws Exception{
		String sql="insert into transaction(carid,time,money,type) values(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,transaction.getCarid());		pstmt.setString(2,transaction.getTime());		pstmt.setFloat(3,transaction.getMoney());		pstmt.setString(4,transaction.getType());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public boolean delete(int id,Connection conn) throws Exception{
		String sql = "delete from transaction where id=?";
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
	public boolean update(Transaction transaction,Connection conn) throws Exception{;
		String sql="update transaction set carid=?,time=?,money=?,type=? where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,transaction.getCarid());		pstmt.setString(2,transaction.getTime());		pstmt.setFloat(3,transaction.getMoney());		pstmt.setString(4,transaction.getType());		pstmt.setInt(5,transaction.getId());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public Transaction selectOne(int id,Connection conn) throws Exception{
		String sql = "select * from transaction where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);		rs = pstmt.executeQuery();
		Transaction transaction = new Transaction();
		if(rs.next()){
			transaction.setCarid(rs.getInt("carid"));
			transaction.setTime(rs.getString("time"));
			transaction.setMoney(rs.getFloat("money"));
			transaction.setType(rs.getString("type"));
			transaction.setId(rs.getInt("id"));
		}
		this.close();
		return transaction;
	}
	public List<Transaction> select(Connection conn) throws Exception{
		String sql = "select * from transaction";
		pstmt = conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		List<Transaction> transactions = new ArrayList<Transaction>();
		while(rs.next()){
			Transaction transaction = new Transaction();
			transaction.setCarid(rs.getInt("carid"));
			transaction.setTime(rs.getString("time"));
			transaction.setMoney(rs.getFloat("money"));
			transaction.setType(rs.getString("type"));
			transaction.setId(rs.getInt("id"));
			transactions.add(transaction);
		}
		this.close();
		return transactions;
	}
	public void close() throws Exception{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	@Override
	public List<Transaction> selectcard(int cid, Connection conn) throws Exception {
		String sql = "select * from transaction where carid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,cid);
		rs = pstmt.executeQuery();
		List<Transaction> transactions = new ArrayList<Transaction>();
		while(rs.next()){
			Transaction transaction = new Transaction();
			transaction.setCarid(rs.getInt("carid"));
			transaction.setTime(rs.getString("time"));
			transaction.setMoney(rs.getFloat("money"));
			transaction.setType(rs.getString("type"));
			transaction.setId(rs.getInt("id"));
			transactions.add(transaction);
		}
		this.close();
		return transactions;
	}
}