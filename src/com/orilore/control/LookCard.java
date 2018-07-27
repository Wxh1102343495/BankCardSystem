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
import com.orilore.model.Card;

@WebServlet("/LookCard.do")
public class LookCard extends HttpServlet {
	private ICardBiz biz = new CardBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		List<Card> card = biz.findCard();
		JSONArray array = new JSONArray();
		for(Card s : card){
			JSONObject obj = new JSONObject();
			obj.put("Id", s.getId());
			obj.put("CardId", s.getCardID());
			obj.put("CardName", s.getCardName());
			obj.put("CardMoney", s.getCardMoney());
			array.add(obj);
		}
		out.print(array);
		out.flush();
		out.close();
	}

}
