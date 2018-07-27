package com.orilore.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orilore.biz.CardBiz;
import com.orilore.biz.ICardBiz;
import com.orilore.biz.ITransactionBiz;
import com.orilore.biz.TransactionBiz;
import com.orilore.model.Card;
import com.orilore.model.Transaction;

@WebServlet("/DelMoney.do")
public class DelMoney extends HttpServlet {
	ITransactionBiz biz1=new TransactionBiz();
	ICardBiz biz2=new CardBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String delcardid =request.getParameter("delid");
		String deltime=request.getParameter("deltime");
		String type="Ö§³ö";
		Float delmoney=Float.parseFloat(request.getParameter("delmoney"));
		List<Card> list=biz2.findCard();
		Transaction transaction=new Transaction();
		Card card=new Card();
		for(Card s:list) {
			int id=s.getId();
			String cardid=s.getCardID();
			Float cmoney=Float.valueOf(s.getCardMoney());
			String money=String.valueOf(((cmoney*100)-(delmoney*100))/100);
			if(delcardid.equals(cardid)) {
				transaction.setCarid(id);
				transaction.setMoney(delmoney);
				transaction.setTime(deltime);
				transaction.setType(type);
				card.setId(id);
				card.setCardMoney(money);
				boolean flag=biz1.addTransaction(transaction,card);
				if(flag) {
					out.print(flag);
				}
			}
		}
		out.flush();
		out.close();
	}
}