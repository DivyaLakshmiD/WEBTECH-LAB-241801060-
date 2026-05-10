package com.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {

	response.getWriter().println("Register Servlet Running");
	
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
String email = request.getParameter("email");
String password = request.getParameter("password");
String mobile = request.getParameter("mobile");
String address = request.getParameter("address");

try {

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/librarydb","root","@Divya60");

PreparedStatement ps = con.prepareStatement(
"insert into users values(?,?,?,?,?,?)");

ps.setString(1,fname);
ps.setString(2,lname);
ps.setString(3,email);
ps.setString(4,password);
ps.setString(5,mobile);
ps.setString(6,address);

int i = ps.executeUpdate();

if(i>0){
out.println("Registration Successful!");
}
else{
out.println("Registration Failed");
}

con.close();

}

catch(Exception e){
out.println(e);
}

}
}