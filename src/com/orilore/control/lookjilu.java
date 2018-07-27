package com.orilore.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.orilore.biz.CardBiz;
import com.orilore.biz.ICardBiz;
import com.orilore.biz.ITransactionBiz;
import com.orilore.biz.TransactionBiz;
import com.orilore.model.Card;
import com.orilore.model.Transaction;

@WebServlet("/Lookjilu.do")
public class lookjilu extends HttpServlet {
	ITransactionBiz biz1=new TransactionBiz();
	ICardBiz biz2=new CardBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		int findcardid=Integer.parseInt(request.getParameter("findjilu"));
		List<Transaction> transaction=biz1.findTransaction();
		List<Card> cards=biz2.findCard();
		JSONArray array = new JSONArray();
		for(Card c:cards) {
			 int cardid=Integer.parseInt(c.getCardID());
			 int cid=c.getId();
			 if(cardid==findcardid) {
				 for(Transaction t:transaction) {
					 int tcid=t.getCarid();
					 int tid=t.getId();
					 if(tcid==cid) {
						Transaction trs=biz1.getTransaction(tid);
						JSONObject obj = new JSONObject();
						obj.put("cardid", c.getCardID());
						obj.put("cardmoney", trs.getMoney());
						obj.put("cardtime", trs.getTime());
						obj.put("type", trs.getType());
						array.add(obj);
					 }
				 } 
			 }
		}
		out.print(array);
		out.flush();
		out.close();
	}

}
