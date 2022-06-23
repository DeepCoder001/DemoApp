package com.deep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		PrintWriter writer = resp.getWriter();
		
		
		int sum = num1+num2;
		
		sum=sum*sum;
		
		req.setAttribute("s", sum);
		
		//Call one servlet to another Servlet using Rquest Dispatcher
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		rd.forward(req, resp);
		System.out.println(sum);
		
		//writer.print("<h1>Sum is : </h1>"+sum);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		PrintWriter writer = resp.getWriter();	
		int sum = num1+num2;
		
		//Call one servlet to another Servlet using Rquest Dispatcher
		//RequestDispatcher rd = req.getRequestDispatcher("sq");
		//rd.forward(req, resp);
		
		//Call one Servlet to another Servlet and transfer data using sendRedirect
		//resp.sendRedirect("sq?sum="+sum);
		
		
		//Transfer data one servlet to another using HttpSession
		//HttpSession httpSession = req.getSession();
		//httpSession.setAttribute("sum", sum);
		
		//Using cookie
		Cookie cookie = new Cookie("sum",sum+"");
		resp.addCookie(cookie);
		
		resp.sendRedirect("sq");
		
		System.out.println("Result of sum : "+sum);		
		writer.print("<h1>Sum is : </h1>"+sum);
	}
	
	
}
