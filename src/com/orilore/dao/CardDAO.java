package com.orilore.dao;
import com.orilore.model.Card;
import java.sql.*;
import java.util.*;
public class CardDAO implements ICardDAO{
	private PreparedStatement pstmt;
	private ResultSet rs;
	public boolean insert(Card card,Connection conn) throws Exception{
		String sql="insert into card(cardID,cardName,cardMoney) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,card.getCardID());		pstmt.setString(2,card.getCardName());		pstmt.setString(3,card.getCardMoney());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public boolean delete(int id,Connection conn) throws Exception{
		String sql = "delete from card where id=?";
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
	public boolean update(Card card,Connection conn) throws Exception{;
		String sql="update card set cardMoney=? where id=?";
		pstmt = conn.prepareStatement(sql);		pstmt.setString(1,card.getCardMoney());		pstmt.setInt(2,card.getId());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public Card selectOne(int id,Connection conn) throws Exception{
		String sql = "select * from card where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);		rs = pstmt.executeQuery();
		Card card = new Card();
		if(rs.next()){
			card.setCardID(rs.getString("cardID"));
			card.setCardName(rs.getString("cardName"));
			card.setCardMoney(rs.getString("cardMoney"));
			card.setId(rs.getInt("id"));
		}
		this.close();
		return card;
	}
	public List<Card> select(Connection conn) throws Exception{
		String sql = "select * from card";
		pstmt = conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		List<Card> cards = new ArrayList<Card>();
		while(rs.next()){
			Card card = new Card();
			card.setCardID(rs.getString("cardID"));
			card.setCardName(rs.getString("cardName"));
			card.setCardMoney(rs.getString("cardMoney"));
			card.setId(rs.getInt("id"));
			cards.add(card);
		}
		this.close();
		return cards;
	}
	public void close() throws Exception{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
}