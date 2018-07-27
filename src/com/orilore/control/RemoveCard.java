package com.orilore.control;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.orilore.dao.ITransactionDAO;
import com.orilore.dao.TransactionDAO;
import com.orilore.model.Card;
import com.orilore.model.Transaction;
import com.orilore.model.User;

@WebServlet("/RemoveCard.do")
public class RemoveCard extends HttpServlet {
	private ICardBiz biz = new CardBiz();
	private ITransactionBiz biz1=new TransactionBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		int cid = Integer.parseInt(request.getParameter("cid"));
		List<Transaction> cardtras=biz1.findCardTransaction(cid);
		for(Transaction t:cardtras) {
			int sid=t.getId();
			biz1.removeTransaction(sid);
		}
		boolean flag=biz.removeCard(cid);
		if(flag) {
			out.print(flag);
		}
		out.flush();
		out.close();
	}

}

