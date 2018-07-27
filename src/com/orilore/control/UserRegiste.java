package com.orilore.control;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/UserRegiste.do")
public class UserRegiste extends HttpServlet {
	private IUserBiz biz = new UserBiz();
	private User bean =new User();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		bean.setUsername(username);
		bean.setPassword(password);
		boolean flag=true;
		flag=biz.addUser(bean);
		out.print(flag);
		out.flush();
		out.close();
	}

}
