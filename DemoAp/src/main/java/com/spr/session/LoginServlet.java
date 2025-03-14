package com.spr.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "Spr@6149".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            //resp.sendRedirect("login.html");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
            dispatcher.forward(req, resp);

        } else {
            resp.getWriter().write("Invalid credentials");
        }
    }
}
