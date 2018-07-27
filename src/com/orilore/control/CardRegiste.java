package com.orilore.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orilore.biz.CardBiz;
import com.orilore.biz.ICardBiz;
import com.orilore.biz.IUserBiz;
import com.orilore.biz.UserBiz;
import com.orilore.model.Card;

@WebServlet("/CardRegister.do")
public class CardRegiste extends HttpServlet {
	private ICardBiz biz = new CardBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String cardID = request.getParameter("cardid");
		String cardName =request.getParameter("cardname");
		String cardMoney =request.getParameter("cardmoney");
		Card card=new Card();
		card.setCardID(cardID);
		card.setCardMoney(cardMoney);
		card.setCardName(cardName);
		boolean flag=true;
		flag=biz.addCard(card);
		out.print(flag);
		out.flush();
		out.close();
	}

}

