package com.spr;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class AddTwoNumbers extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int a = Integer.parseInt(req.getParameter("fname"));
		int b = Integer.parseInt(req.getParameter("lname"));
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println("<img src=\"images/demo.png\" alt=\"Website Logo\">\n");


	}
}
