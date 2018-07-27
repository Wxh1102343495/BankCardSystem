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

@WebServlet("/lookyue.do")
public class lookyue extends HttpServlet {
	ICardBiz biz=new CardBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		int cardid=Integer.parseInt(request.getParameter("lookid"));
		List<Card> list=biz.findCard();
		JSONArray array = new JSONArray();
		for(Card s:list) {
			int cid=Integer.parseInt(s.getCardID());
			if(cid==cardid) {
				JSONObject obj = new JSONObject();
				obj.put("cardid", s.getCardID());
				obj.put("cardmoney", s.getCardMoney());
				obj.put("cardname", s.getCardName());
				array.add(obj);
			}else {
				out.print("");
			}
		}
		out.print(array);
		out.flush();
		out.close();
	}

}
