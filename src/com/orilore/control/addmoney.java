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

@WebServlet("/addmoney.do")
public class addmoney extends HttpServlet {
	ITransactionBiz biz1=new TransactionBiz();
	ICardBiz biz2=new CardBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String addcardid =request.getParameter("addid");
		String addtime=request.getParameter("addtime");
		String type="¥Ê»Î";
		Float addmoney=Float.parseFloat(request.getParameter("addmoney"));
		List<Card> list=biz2.findCard();
		Transaction transaction=new Transaction();
		Card card=new Card();
		for(Card s:list) {
			int id=s.getId();
			String cardid=s.getCardID();
			Float cmoney=Float.parseFloat(s.getCardMoney());
			String money=String.valueOf(((addmoney*100)+(cmoney*100))/100);
			if(addcardid.equals(cardid)) {
				transaction.setCarid(id);
				transaction.setMoney(addmoney);
				transaction.setTime(addtime);
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
