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
import com.orilore.biz.IUserBiz;
import com.orilore.biz.UserBiz;
import com.orilore.model.User;

/**
 * Servlet implementation class user
 */
@WebServlet("/user.do")
public class user extends HttpServlet {
	private IUserBiz biz = new UserBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		List<User> users = biz.findUser();
		JSONArray array = new JSONArray();
		for(User s : users){
			JSONObject obj = new JSONObject();
			obj.put("username", s.getUsername());
			obj.put("password", s.getPassword());
			array.add(obj);
		}
		out.print(array);
		out.flush();
		out.close();	
	}

}
