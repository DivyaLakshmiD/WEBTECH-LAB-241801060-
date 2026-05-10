package com.session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	
    	res.setContentType("text/html");

        HttpSession session = req.getSession(false);

        if(session != null) {
            String user = (String) session.getAttribute("username");
            res.getWriter().println(
            	    "Welcome " + user +
            	    "<br><br>" +
            	    "<form action='logout' method='get'>" +
            	    "<input type='submit' value='Logout'>" +
            	    "</form>"
            	);
        } else {
            res.sendRedirect("login.html");
        }
    }
}