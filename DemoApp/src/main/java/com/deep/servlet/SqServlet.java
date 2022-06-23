package com.deep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SqServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Using RequestDispatcher
		//int sq = (int)req.getAttribute("s");
		
		//Using SendRedirect
		//int sum = Integer.parseInt(req.getParameter("sum"));
		
		//Transfer data using http session
		//HttpSession session = req.getSession();		
		//int sum = (int)session.getAttribute("sum");
		
		//Using cookie
		Cookie[] cookies = req.getCookies();
		int sum=0;
		for(Cookie c : cookies) {
			if(c.getName().equals("sum"))
			sum=	Integer.parseInt(c.getValue());
		}
		sum = sum*sum;
		PrintWriter out = resp.getWriter();
		System.out.println("Second servlet called !");
		out.print("Result is : "+ sum);
		
	}

}
