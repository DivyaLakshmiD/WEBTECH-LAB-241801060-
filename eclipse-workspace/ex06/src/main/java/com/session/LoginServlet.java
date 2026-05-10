package com.session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req, HttpServletResponse res)
 throws ServletException, IOException {

  String user = req.getParameter("username");
  String pass = req.getParameter("password");

  if(user.equals("admin") && pass.equals("123")) {
   HttpSession session = req.getSession();
   session.setAttribute("username", user);
   res.sendRedirect("home");
  } else {
   res.getWriter().println("Invalid Login");
   req.getRequestDispatcher("login.html").include(req, res);
  }
 }
}